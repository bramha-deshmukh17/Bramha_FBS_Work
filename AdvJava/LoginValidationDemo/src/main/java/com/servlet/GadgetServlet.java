package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/gadget")
public class GadgetServlet extends HttpServlet {
    Connection con;

    public void init() {
        String driverClass = getServletConfig().getServletContext().getInitParameter("driver");
        String url = getServletConfig().getServletContext().getInitParameter("url");
        String user = getServletConfig().getServletContext().getInitParameter("username");
        try {
            Class.forName(driverClass);
            con = DriverManager.getConnection(url, user, "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String mobile = request.getParameter("mobile");
            String laptop = request.getParameter("laptop");

            HttpSession hs = request.getSession(false);
            String username = (String) hs.getAttribute("user");

            Map<String, String> cart = new HashMap<>();
            cart.put("mobile", mobile);
            cart.put("laptop", laptop);
            HttpSession session = request.getSession();
            session.setAttribute("cart", cart);

            hs.setAttribute("cart", cart);

            // Store cart data in database
            PreparedStatement pst = con.prepareStatement(
                    "INSERT INTO carttable (username, mobile, laptop) VALUES (?, ?, ?)");
            pst.setString(1, username);
            pst.setString(2, mobile);
            pst.setString(3, laptop);
            pst.executeUpdate();

            response.setContentType("text/html");
            response.getWriter().println("<h2>Gadgets added to cart!</h2>");
            response.getWriter().println("<p>Mobile: " + mobile + "</p>");
            response.getWriter().println("<p>Laptop: " + laptop + "</p>");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void destroy() {
        try {
            if (con != null)
                con.close();
        } catch (Exception e) {
            // ignore
        }
    }
}