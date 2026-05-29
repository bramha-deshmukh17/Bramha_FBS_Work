package com.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.DAO.CartDAO;
import com.aspect.ConnectionProvider;
import com.bean.CartItem;

public class CartDAOImpl implements CartDAO {

    @Override
    public boolean addCartItem(CartItem cartItem) {
        String sql = "INSERT INTO cart(user_id, product_id, quantity) VALUES (?, ?, ?)";
        try (Connection conn = ConnectionProvider.provideConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, cartItem.getUserId());
            ps.setInt(2, cartItem.getProductId());
            ps.setInt(3, cartItem.getQuantity());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateCartItem(CartItem cartItem) {
        String sql = "UPDATE cart SET quantity=? WHERE id=?";
        try (Connection conn = ConnectionProvider.provideConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, cartItem.getQuantity());
            ps.setInt(2, cartItem.getId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean removeCartItem(int id) {
        String sql = "DELETE FROM cart WHERE id=?";
        try (Connection conn = ConnectionProvider.provideConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<CartItem> getCartItemsByUserId(int userId) {
        List<CartItem> items = new ArrayList<>();

        String sql = """
                SELECT c.id, c.user_id, c.product_id, c.quantity,
                       p.name AS product_name, p.price, p.imageUrl
                FROM cart c
                JOIN products p ON p.id = c.product_id
                WHERE c.user_id = ?
                """;

        try (Connection conn = ConnectionProvider.provideConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, userId);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    CartItem ci = new CartItem();
                    ci.setId(rs.getInt("id"));
                    ci.setUserId(rs.getInt("user_id"));
                    ci.setProductId(rs.getInt("product_id"));
                    ci.setQuantity(rs.getInt("quantity"));

                    ci.setProductName(rs.getString("product_name"));
                    ci.setPrice(rs.getDouble("price"));
                    ci.setImageUrl(rs.getString("imageUrl"));

                    items.add(ci);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;
    }

    @Override
    public void clearCartByUserId(int userId) {
        String sql = "DELETE FROM cart WHERE user_id=?";
        try (Connection conn = ConnectionProvider.provideConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, userId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
