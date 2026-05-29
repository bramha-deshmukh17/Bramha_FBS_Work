package com.DAOImpl;

import com.DAO.ProductDAO;
import com.bean.Product;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import com.aspect.ConnectionProvider;

public class ProductDAOImpl implements ProductDAO {

    @Override
    public boolean addProduct(Product product) {
        String sql = "INSERT INTO products(name, description, price, category, quantity, imageUrl) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConnectionProvider.provideConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, product.getName());
            ps.setString(2, product.getDescription());
            ps.setDouble(3, product.getPrice());
            ps.setString(4, product.getCategory());
            ps.setInt(5, product.getQuantity());
            ps.setString(6, product.getImageUrl());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateProduct(Product product) {
        String sql = "UPDATE products SET name=?, description=?, price=?, category=?, quantity=?, imageUrl=? WHERE id=?";
        try (Connection conn = ConnectionProvider.provideConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, product.getName());
            ps.setString(2, product.getDescription());
            ps.setDouble(3, product.getPrice());
            ps.setString(4, product.getCategory());
            ps.setInt(5, product.getQuantity());
            ps.setString(6, product.getImageUrl());
            ps.setInt(7, product.getId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteProduct(int id) {
        String sql = "DELETE FROM products WHERE id=?";
        try (Connection conn = ConnectionProvider.provideConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Product getProductById(int id) {
        String sql = "SELECT * FROM products WHERE id=?";
        try (Connection conn = ConnectionProvider.provideConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getDouble("price"),
                        rs.getString("category"),
                        rs.getInt("quantity"),
                        rs.getString("imageUrl"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM products";
        try (Connection conn =ConnectionProvider.provideConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                products.add(new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getDouble("price"),
                        rs.getString("category"),
                        rs.getInt("quantity"),
                        rs.getString("imageUrl")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }
}
