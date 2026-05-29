package com.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.DAO.PaymentDAO;
import com.aspect.ConnectionProvider;
import com.bean.Payment;

public class PaymentDAOImpl implements PaymentDAO {

    @Override
    public boolean addPayment(Payment payment) {
        String status = (payment.getStatus() == null || payment.getStatus().isBlank()) ? "Pending" : payment.getStatus();
        String method = (payment.getPaymentMethod() == null || payment.getPaymentMethod().isBlank()) ? "Card" : payment.getPaymentMethod();

        String sql = """
            INSERT INTO payments(order_id, payment_date, amount, payment_method, status)
            VALUES (?, NOW(), ?, ?, ?)
            ON DUPLICATE KEY UPDATE
              payment_date = NOW(),
              amount = VALUES(amount),
              payment_method = VALUES(payment_method),
              status = VALUES(status)
            """;

        try (Connection conn = ConnectionProvider.provideConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, payment.getOrderId());
            ps.setDouble(2, payment.getAmount());
            ps.setString(3, method);
            ps.setString(4, status);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("SQLException in PaymentDAOImpl.addPayment()");
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Payment getPaymentByOrderId(int orderId) {
        String sql = "SELECT * FROM payments WHERE order_id=?";
        try (Connection conn = ConnectionProvider.provideConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, orderId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Payment(
                        rs.getInt("id"),
                        rs.getInt("order_id"),
                        rs.getDouble("amount"),
                        rs.getTimestamp("payment_date"),
                        rs.getString("payment_method"),
                        rs.getString("status"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Payment> getAllPayments() {
        List<Payment> payments = new ArrayList<>();
        String sql = "SELECT * FROM payments";
        try (Connection conn = ConnectionProvider.provideConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                payments.add(new Payment(
                        rs.getInt("id"),
                        rs.getInt("order_id"),
                        rs.getDouble("amount"),
                        rs.getTimestamp("payment_date"),
                        rs.getString("payment_method"),
                        rs.getString("status")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return payments;
    }
}
