package com.demo;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.sun.net.httpserver.Request;

public class LoginServlet extends HttpServlet {

    Connection con;

    
    @Override
    public void init() {
        try {
            ServletContext context = getServletConfig().getServletContext();

            String driver = context.getInitParameter("driver");
            String url = context.getInitParameter("url");
            String username = context.getInitParameter("username");
            String password = context.getInitParameter("password");

            Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);

            System.out.println("Database Connected Successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String user = request.getParameter("username");
        String pass = request.getParameter("password");

        PrintWriter out = response.getWriter();

        boolean isValid = checkUser(user, pass); 
        
        RequestDispatcher rs = null;

        if (isValid) {
        	

        	
        	 HttpSession session = request.getSession(true);
             session.setAttribute("username", user);

             
             RequestDispatcher rd = request.getRequestDispatcher("/Card.html");
             rd.forward(request, response);

        	
        } else {
        	
        	rs = request.getRequestDispatcher("/index.html");
        	rs.include(request, response);
            out.println("<h1>Invalid User</h1>");
        }
    }

    
    private boolean checkUser(String username, String password) {

        boolean status = false;

        try { 
            String sql = "SELECT * FROM users WHERE username=? AND password=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                status = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
}
