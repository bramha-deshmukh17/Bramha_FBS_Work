package com.controller;

import com.aspect.ConnectionProvider;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import org.json.JSONObject;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.InputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Properties;

@WebServlet("/razorpay/create-order")
public class RazorpayCreateOrderServlet extends HttpServlet {

    private Properties loadRazorpayProps() throws IOException {
        Properties p = new Properties();
        try (InputStream in = getClass().getClassLoader().getResourceAsStream("razorpay.properties")) {
            if (in == null) throw new IllegalStateException("Missing resource: /razorpay.properties");
            p.load(in);
        }
        return p;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // Validate parameters
        String orderIdStr = req.getParameter("orderId");
        String amountStr = req.getParameter("amount");
        String name = req.getParameter("name");
        
        if (orderIdStr == null || orderIdStr.trim().isEmpty()) {
            resp.setStatus(400);
            resp.getWriter().write("{\"error\": \"Order ID is required\"}");
            return;
        }
        
        if (amountStr == null || amountStr.trim().isEmpty()) {
            resp.setStatus(400);
            resp.getWriter().write("{\"error\": \"Amount is required\"}");
            return;
        }
        
        if (name == null || name.trim().isEmpty()) {
            resp.setStatus(400);
            resp.getWriter().write("{\"error\": \"Name is required\"}");
            return;
        }
        
        int orderId = Integer.parseInt(orderIdStr); // your internal order id
        BigDecimal amountInRupees = new BigDecimal(amountStr);
        long amountPaise = amountInRupees.movePointRight(2).longValueExact();

        try {
            Properties rp = loadRazorpayProps();
            RazorpayClient client = new RazorpayClient(rp.getProperty("key_id"), rp.getProperty("key_secret"));

            JSONObject options = new JSONObject();
            options.put("amount", amountPaise);
            options.put("currency", "INR");
            options.put("receipt", "order_" + orderId);

            Order rzpOrder = client.orders.create(options);
            String razorpayOrderId = String.valueOf((Object) rzpOrder.get("id"));

            // Upsert a Pending payment row (minimal storage; no card details)
            String upsert = """
                INSERT INTO payments(order_id, paymentDate, cardHolderName, amount, status)
                VALUES (?, NOW(), ?, ?, 'Pending')
                ON DUPLICATE KEY UPDATE
                    paymentDate = NOW(),
                    cardHolderName = VALUES(cardHolderName),
                    amount = VALUES(amount),
                    status = 'Pending'
                """;
            try (Connection con = ConnectionProvider.provideConnection();
                 PreparedStatement ps = con.prepareStatement(upsert)) {
                ps.setInt(1, orderId);
                ps.setString(2, name);
                ps.setBigDecimal(3, amountInRupees);
                ps.executeUpdate();
            }

            JSONObject out = new JSONObject();
            out.put("keyId", rp.getProperty("key_id"));
            out.put("orderId", orderId);
            out.put("razorpayOrderId", razorpayOrderId);
            out.put("amount", amountPaise);
            out.put("currency", "INR");

            resp.getWriter().write(out.toString());

        } catch (Exception e) {
            resp.setStatus(500);
            resp.getWriter().write(new JSONObject().put("error", e.getMessage()).toString());
        }
    }
}