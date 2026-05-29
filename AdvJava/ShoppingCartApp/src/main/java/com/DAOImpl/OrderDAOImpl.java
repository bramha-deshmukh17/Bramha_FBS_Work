package com.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.DAO.OrderDAO;
import com.aspect.ConnectionProvider;
import com.bean.Order;

public class OrderDAOImpl implements OrderDAO {

    @Override
    public boolean placeOrder(Order order) {
        String sql = "INSERT INTO orders(user_id, totalAmount, orderDate, status, delivery_address_id) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = ConnectionProvider.provideConnection(); PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, order.getUserId());
            ps.setDouble(2, order.getTotalAmount());
            ps.setTimestamp(3, new java.sql.Timestamp(order.getOrderDate().getTime()));
            ps.setString(4, order.getStatus());
            if (order.getDeliveryAddressId() > 0) {
                ps.setInt(5, order.getDeliveryAddressId());
            } else {
                ps.setNull(5, java.sql.Types.INTEGER);
            }
            int updated = ps.executeUpdate();
            if (updated <= 0) {
                return false;
            }

            try (ResultSet keys = ps.getGeneratedKeys()) {
                if (keys.next()) {
                    order.setId(keys.getInt(1));
                }
            }

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Order> getOrdersByUserId(int userId) {
        List<Order> orders = new ArrayList<>();
        String sql = "SELECT * FROM orders WHERE user_id=? ORDER BY orderDate DESC";
        try (Connection conn = ConnectionProvider.provideConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Order order = new Order(
                        rs.getInt("id"),
                        rs.getInt("user_id"),
                        rs.getDouble("totalAmount"),
                        rs.getTimestamp("orderDate"),
                        rs.getString("status"));
                int deliveryAddressId = rs.getInt("delivery_address_id");
                if (!rs.wasNull()) {
                    order.setDeliveryAddressId(deliveryAddressId);
                }
                orders.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    @Override
    public List<Order> getAllOrders() {
        List<Order> orders = new ArrayList<>();
        String sql = "SELECT * FROM orders ORDER BY orderDate DESC";
        try (Connection conn = ConnectionProvider.provideConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Order order = new Order(
                        rs.getInt("id"),
                        rs.getInt("user_id"),
                        rs.getDouble("totalAmount"),
                        rs.getTimestamp("orderDate"),
                        rs.getString("status"));
                int deliveryAddressId = rs.getInt("delivery_address_id");
                if (!rs.wasNull()) {
                    order.setDeliveryAddressId(deliveryAddressId);
                }
                orders.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    @Override
    public boolean updateOrderStatus(int orderId, String status) {
        String sql = "UPDATE orders SET status=? WHERE id=?";
        try (Connection conn = ConnectionProvider.provideConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, status);
            ps.setInt(2, orderId);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Order getOrderById(int orderId) {
        String sql = "SELECT * FROM orders WHERE id=?";
        try (Connection conn = ConnectionProvider.provideConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, orderId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Order order = new Order(
                        rs.getInt("id"),
                        rs.getInt("user_id"),
                        rs.getDouble("totalAmount"),
                        rs.getTimestamp("orderDate"),
                        rs.getString("status"));
                int deliveryAddressId = rs.getInt("delivery_address_id");
                if (!rs.wasNull()) {
                    order.setDeliveryAddressId(deliveryAddressId);
                }
                return order;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean updateOrder(Order order) {
        String sql = "UPDATE orders SET user_id=?, totalAmount=?, status=?, delivery_address_id=? WHERE id=?";
        try (Connection conn = ConnectionProvider.provideConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, order.getUserId());
            ps.setDouble(2, order.getTotalAmount());
            ps.setString(3, order.getStatus());
            if (order.getDeliveryAddressId() > 0) {
                ps.setInt(4, order.getDeliveryAddressId());
            } else {
                ps.setNull(4, java.sql.Types.INTEGER);
            }
            ps.setInt(5, order.getId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
