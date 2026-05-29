package com.controller;

import com.aspect.ObjectCreater;
import com.bean.Order;
import com.bean.Payment;
import com.services.OrderService;
import com.services.PaymentService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/payment")
public class PaymentServlet extends HttpServlet {
    private final PaymentService paymentService = ObjectCreater.createObject("paymentService", PaymentService.class);
    private final OrderService orderService = ObjectCreater.createObject("orderService", OrderService.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String orderIdParam = request.getParameter("orderId");
            if (orderIdParam == null || orderIdParam.trim().isEmpty()) {
                response.sendRedirect("cart.jsp?error=Invalid order ID");
                return;
            }
            int orderId = Integer.parseInt(orderIdParam);

        Order order = orderService.getOrderById(orderId);
        double amount = (order != null)
                ? order.getTotalAmount()
                : Double.parseDouble(request.getParameter("amount"));

        Payment existing = paymentService.getPaymentByOrderId(orderId);

            request.setAttribute("orderId", orderId);
            request.setAttribute("amount", amount);
            request.setAttribute("payment", existing);

            request.getRequestDispatcher("payment.jsp").forward(request, response);
        } catch (NumberFormatException e) {
            response.sendRedirect("cart.jsp?error=Invalid order or amount format");
        }
    }

    // No card form submit anymore; Razorpay handles payment.
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("payment?orderId=" + request.getParameter("orderId") + "&amount=" + request.getParameter("amount"));
    }
}