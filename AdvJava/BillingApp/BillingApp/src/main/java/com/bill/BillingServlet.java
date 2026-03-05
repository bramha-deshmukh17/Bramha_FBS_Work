package com.bill;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class BillingServlet extends HttpServlet {

    private Connection con;

    @Override
    public void init() throws ServletException {
        try {
            String driver = getServletContext().getInitParameter("driver");
            String url = getServletContext().getInitParameter("url");
            String dbUser = getServletContext().getInitParameter("username");
            String pass = getServletContext().getInitParameter("password");

            Class.forName(driver);
            con = DriverManager.getConnection(url, dbUser, pass);

            System.out.println("DB Connected");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        out.println("<html>");
        out.println("<head><title>Billing Page</title></head>");
        out.println("<body>");

        out.println("<h2>Billing Data</h2>");

        String sql = "SELECT laptop, phone, price FROM shoppingcart";

        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            out.println("<table border='1'>");
            out.println("<tr>");
            out.println("<th>Laptop</th>");
            out.println("<th>Phone</th>");
            out.println("<th>Price</th>");
            out.println("</tr>");

            double totalBill = 0;
            boolean dataFound = false;

            while (rs.next()) {
                dataFound = true;
                double price = rs.getDouble("price");
                totalBill += price;

                out.println("<tr>");
                out.println("<td>" + rs.getString("laptop") + "</td>");
                out.println("<td>" + rs.getString("phone") + "</td>");
                out.println("<td>" + price + "</td>");
                out.println("</tr>");
            }

            if (dataFound) {
                out.println("<tr>");
                out.println("<td colspan='2'><b>Total Bill</b></td>");
                out.println("<td><b>" + totalBill + "</b></td>");
                out.println("</tr>");
            } else {
                out.println("<tr><td colspan='3'>No data found</td></tr>");
            }

            out.println("</table>");

        } catch (Exception e) {
            e.printStackTrace();
            out.println("<p>Error while reading data</p>");
        }

        out.println("<br>");
        out.println("<form action='logout' method='post'>");
        out.println("<input type='submit' value='Logout'>");
        out.println("</form>");


        out.println("</body>");
        out.println("</html>");
    }
}
