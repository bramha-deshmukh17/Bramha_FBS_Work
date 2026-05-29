package com.controller;

import com.bean.Order;
import com.bean.Payment;
import com.bean.DeliveryAddress;
import com.serviceimpl.OrderServiceImpl;
import com.serviceimpl.PaymentServiceImpl;
import com.DAOImpl.DeliveryAddressDAOImpl;
import com.services.OrderService;
import com.services.PaymentService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/paymentProcess")
public class PaymentProcessServlet extends HttpServlet {
    private OrderService orderService = new OrderServiceImpl();
    private PaymentService paymentService = new PaymentServiceImpl();
    private DeliveryAddressDAOImpl deliveryAddressDAO = new DeliveryAddressDAOImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int orderId = Integer.parseInt(request.getParameter("orderId"));
            double amount = Double.parseDouble(request.getParameter("amount"));
            String paymentMethod = request.getParameter("paymentMethod");
            
            String streetAddress = request.getParameter("streetAddress");
            String city = request.getParameter("city");
            String state = request.getParameter("state");
            String zipCode = request.getParameter("zipCode");
            String phone = request.getParameter("phone");

            // Validate delivery address
            if (streetAddress == null || streetAddress.trim().isEmpty() ||
                city == null || city.trim().isEmpty() ||
                state == null || state.trim().isEmpty() ||
                zipCode == null || zipCode.trim().isEmpty() ||
                phone == null || phone.trim().isEmpty()) {
                response.sendRedirect("payment?orderId=" + orderId + "&amount=" + amount + "&message=Please fill all address fields");
                return;
            }

            // Get order
            Order order = orderService.getOrderById(orderId);
            if (order == null) {
                response.sendRedirect("payment?orderId=" + orderId + "&amount=" + amount + "&message=Order not found");
                return;
            }

            // Verify user owns this order (security check)
            java.util.List<DeliveryAddress> userAddresses = deliveryAddressDAO.getDeliveryAddressesByUserId(order.getUserId());
            if (userAddresses == null) {
                response.sendRedirect("payment?orderId=" + orderId + "&amount=" + amount + "&message=Cannot verify user");
                return;
            }

            // Save delivery address
            DeliveryAddress address = new DeliveryAddress(order.getUserId(), streetAddress, city, state, zipCode, phone);
            deliveryAddressDAO.addDeliveryAddress(address);

            // Retrieve the just-saved address
            java.util.List<DeliveryAddress> allAddresses = deliveryAddressDAO.getDeliveryAddressesByUserId(order.getUserId());
            if (allAddresses == null || allAddresses.isEmpty()) {
                response.sendRedirect("payment?orderId=" + orderId + "&amount=" + amount + "&message=Failed to save delivery address");
                return;
            }
            DeliveryAddress savedAddress = allAddresses.get(0); // Most recent

            // Update order with delivery address and payment information
            order.setDeliveryAddressId(savedAddress.getId());

            // Create payment record
            Payment payment = new Payment(orderId, amount, paymentMethod, "Paid");
            paymentService.addPayment(payment);

            // Update order status to Shipped (payment successful)
            order.setStatus("Shipped");
            orderService.updateOrder(order);

            // Redirect to confirmation
            response.sendRedirect("orderConfirmation.jsp?orderId=" + orderId + "&amount=" + amount);

        } catch (NumberFormatException e) {
            response.sendRedirect("payment?message=Invalid order or amount");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("payment?message=Error processing payment: " + e.getMessage());
        }
    }
}
