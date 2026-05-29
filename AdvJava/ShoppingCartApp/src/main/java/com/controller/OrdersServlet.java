package com.controller;

import com.aspect.ObjectCreater;
import com.bean.Order;
import com.bean.User;
import com.services.OrderService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet("/orders")
public class OrdersServlet extends HttpServlet {
    private final OrderService orderService = ObjectCreater.createObject("orderService", OrderService.class);

    private Integer resolveUserId(HttpSession session) {
        // First check for userId attribute (Integer)
        Object userIdObj = session.getAttribute("userId");
        if (userIdObj instanceof Integer)
            return (Integer) userIdObj;
        
        // Fallback: check user attribute (User object)
        Object userObj = session.getAttribute("user");
        if (userObj instanceof User)
            return ((User) userObj).getId();
        
        return null;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (orderService == null) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Service initialization failed");
            return;
        }
        
        HttpSession session = request.getSession(false);
        if (session == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        Integer userId = resolveUserId(session);
        if (userId == null) {
            // User has session but no userId - log them out
            session.invalidate();
            response.sendRedirect("login.jsp?msg=session_expired");
            return;
        }

        List<Order> orders = orderService.getOrdersByUserId(userId);
        request.setAttribute("orders", orders);
        request.getRequestDispatcher("orders.jsp").forward(request, response);
    }
}
