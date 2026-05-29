package com.controller;

import com.aspect.ObjectCreater;
import com.bean.User;
import com.services.UserService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
    private final UserService userService = ObjectCreater.createObject("userService", UserService.class);

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (userService == null) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Service initialization failed");
            return;
        }
        
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        // Validate required fields
        if (name == null || name.trim().isEmpty() ||
            email == null || email.trim().isEmpty() ||
            password == null || password.trim().isEmpty()) {
            response.sendRedirect("register.jsp?msg=missing_fields");
            return;
        }
        
        String role = "customer";
        User user = new User(0, name.trim(), email.trim(), password, role);
        boolean registered = userService.registerUser(user);
        if (registered) {
            response.sendRedirect("login.jsp?msg=registered");
        } else {
            response.sendRedirect("register.jsp?msg=error");
        }
}