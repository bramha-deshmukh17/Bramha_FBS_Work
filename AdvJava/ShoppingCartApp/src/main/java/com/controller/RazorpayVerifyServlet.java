package com.controller;

import com.aspect.ConnectionProvider;
import org.json.JSONObject;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.InputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Properties;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

@WebServlet("/razorpay/verify")
public class RazorpayVerifyServlet extends HttpServlet {

    private String hmacSha256Hex(String secret, String data) throws Exception {
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8), "HmacSHA256"));
        byte[] digest = mac.doFinal(data.getBytes(StandardCharsets.UTF_8));

        StringBuilder sb = new StringBuilder(digest.length * 2);
        for (byte b : digest) sb.append(String.format("%02x", b));
        return sb.toString();
    }

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
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        // Validate all required parameters before parsing
        String orderIdParam = req.getParameter("orderId");
        String rzpOrderId = req.getParameter("razorpay_order_id");
        String rzpPaymentId = req.getParameter("razorpay_payment_id");
        String rzpSignature = req.getParameter("razorpay_signature");

        if (orderIdParam == null || orderIdParam.trim().isEmpty() ||
            rzpOrderId == null || rzpOrderId.trim().isEmpty() ||
            rzpPaymentId == null || rzpPaymentId.trim().isEmpty() ||
            rzpSignature == null || rzpSignature.trim().isEmpty()) {
            resp.setStatus(400);
            resp.getWriter().write(new JSONObject().put("verified", false).put("error", "Missing required parameters").toString());
            return;
        }

        try {
            int orderId = Integer.parseInt(orderIdParam);
            Properties rp = loadRazorpayProps();
            String secret = rp.getProperty("key_secret");

            String payload = rzpOrderId + "|" + rzpPaymentId;
            String expectedSig = hmacSha256Hex(secret, payload);

            if (!expectedSig.equals(rzpSignature)) {
                resp.setStatus(400);
                resp.getWriter().write(new JSONObject().put("verified", false).put("error", "Invalid signature").toString());
                return;
            }

            String update = """
                UPDATE payments
                SET status='Paid',
                    paymentDate = NOW()
                WHERE order_id=?
                """;
            try (Connection con = ConnectionProvider.provideConnection();
                 PreparedStatement ps = con.prepareStatement(update)) {
                ps.setInt(1, orderId);
                ps.executeUpdate();
            }

            resp.getWriter().write(new JSONObject().put("verified", true).toString());

        } catch (Exception e) {
            resp.setStatus(500);
            resp.getWriter().write(new JSONObject().put("verified", false).put("error", e.getMessage()).toString());
        }
    }
}