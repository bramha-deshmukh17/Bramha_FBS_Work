package com.controller;

import com.bean.Order;
import com.bean.DeliveryAddress;
import com.serviceimpl.OrderServiceImpl;
import com.serviceimpl.CartServiceImpl;
import com.DAOImpl.DeliveryAddressDAOImpl;
import com.services.OrderService;
import com.services.CartService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet("/CheckoutServlet")
public class CheckoutServlet extends HttpServlet {
    private OrderService orderService = new OrderServiceImpl();
    private CartService cartService = new CartServiceImpl();
    private DeliveryAddressDAOImpl deliveryAddressDAO = new DeliveryAddressDAOImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Integer userId = (Integer) session.getAttribute("userId");

        if (userId == null) {
            response.sendRedirect("login.jsp?message=Please login first");
            return;
        }

        try {
            // Get checkout information from form
            String address = request.getParameter("address");
            String city = request.getParameter("city");
            String state = request.getParameter("state");
            String zip = request.getParameter("zip");
            String phone = request.getParameter("phone");
            double totalAmount = Double.parseDouble(request.getParameter("totalAmount"));

            // Validate inputs
            if (address == null || address.trim().isEmpty() ||
                city == null || city.trim().isEmpty() ||
                state == null || state.trim().isEmpty() ||
                zip == null || zip.trim().isEmpty() ||
                phone == null || phone.trim().isEmpty()) {
                response.sendRedirect("checkout.jsp?message=Please fill in all fields");
                return;
            }

            // Save delivery address
            DeliveryAddress deliveryAddress = new DeliveryAddress(userId, address, city, state, zip, phone);
            deliveryAddressDAO.addDeliveryAddress(deliveryAddress);
            
            // Verify address was saved before proceeding
            List<DeliveryAddress> allAddresses = deliveryAddressDAO.getDeliveryAddressesByUserId(userId);
            if (allAddresses == null || allAddresses.isEmpty()) {
                response.sendRedirect("checkout.jsp?message=Failed to save delivery address");
                return;
            }
            
            // Get the most recently saved address (first in DESC ordered list)
            DeliveryAddress savedAddress = allAddresses.get(0);

            // Create order
            Order order = new Order();
            order.setUserId(userId);
            order.setTotalAmount(totalAmount);
            order.setOrderDate(new Date());
            order.setStatus("Pending Payment");
            if (savedAddress != null) {
                order.setDeliveryAddressId(savedAddress.getId());
            }

            // Place order
            if (orderService.placeOrder(order)) {
                // Store order info in session for payment
                session.setAttribute("currentOrder", order);
                session.setAttribute("orderId", order.getId());
                session.setAttribute("deliveryAddress", savedAddress);

                // Clear cart items
                cartService.clearCartByUserId(userId);

                // Redirect to payment through PaymentServlet
                response.sendRedirect("payment?orderId=" + order.getId() + "&amount=" + totalAmount);
            } else {
                response.sendRedirect("checkout.jsp?message=Failed to create order");
            }
        } catch (NumberFormatException e) {
            response.sendRedirect("checkout.jsp?message=Invalid amount");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("checkout.jsp?message=Error processing checkout: " + e.getMessage());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("checkout.jsp");
    }
}