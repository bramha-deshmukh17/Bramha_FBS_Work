package com.controller;

import com.aspect.ObjectCreater;
import com.bean.User;
import com.services.UserService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private final UserService userService = ObjectCreater.createObject("userService", UserService.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (userService == null) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Service initialization failed");
            return;
        }

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (email == null || email.trim().isEmpty() || password == null || password.trim().isEmpty()) {
            response.sendRedirect("login.jsp?msg=missing_fields");
            return;
        }

        User user = userService.loginUser(email, password);
        if (user != null) {
            HttpSession session = request.getSession(true);
            session.setAttribute("user", user);
            session.setAttribute("userId", user.getId());
            System.out.println("DEBUG: User logged in - ID: " + user.getId() + ", Role: " + user.getRole());
            System.out.println("DEBUG: Session ID: " + session.getId());
            System.out.println("DEBUG: Session userId attribute set to: " + session.getAttribute("userId"));

            if ("admin".equals(user.getRole())) {
                response.sendRedirect("adminDashboard.jsp");
            } else {
                response.sendRedirect("products");
            }
        } else {
            response.sendRedirect("login.jsp?msg=invalid");
        }
    }
}