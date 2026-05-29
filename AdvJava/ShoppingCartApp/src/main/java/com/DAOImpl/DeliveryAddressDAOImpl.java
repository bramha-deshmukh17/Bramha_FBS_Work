package com.DAOImpl;

import com.bean.DeliveryAddress;
import com.DAO.DeliveryAddressDAO;
import com.aspect.ConnectionProvider;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DeliveryAddressDAOImpl implements DeliveryAddressDAO {
    
    @Override
    public boolean addDeliveryAddress(DeliveryAddress address) {
        String query = "INSERT INTO delivery_addresses (user_id, street_address, city, state, zip_code, phone, is_default) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = ConnectionProvider.provideConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, address.getUserId());
            ps.setString(2, address.getStreetAddress());
            ps.setString(3, address.getCity());
            ps.setString(4, address.getState());
            ps.setString(5, address.getZipCode());
            ps.setString(6, address.getPhone());
            ps.setBoolean(7, address.isDefault());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    @Override
    public DeliveryAddress getDeliveryAddressById(int id) {
        String query = "SELECT * FROM delivery_addresses WHERE id = ?";
        try (Connection con = ConnectionProvider.provideConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                DeliveryAddress address = new DeliveryAddress();
                address.setId(rs.getInt("id"));
                address.setUserId(rs.getInt("user_id"));
                address.setStreetAddress(rs.getString("street_address"));
                address.setCity(rs.getString("city"));
                address.setState(rs.getString("state"));
                address.setZipCode(rs.getString("zip_code"));
                address.setPhone(rs.getString("phone"));
                address.setDefault(rs.getBoolean("is_default"));
                return address;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    @Override
    public List<DeliveryAddress> getDeliveryAddressesByUserId(int userId) {
        List<DeliveryAddress> addresses = new ArrayList<>();
        String query = "SELECT * FROM delivery_addresses WHERE user_id = ? ORDER BY is_default DESC, created_at DESC";
        try (Connection con = ConnectionProvider.provideConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DeliveryAddress address = new DeliveryAddress();
                address.setId(rs.getInt("id"));
                address.setUserId(rs.getInt("user_id"));
                address.setStreetAddress(rs.getString("street_address"));
                address.setCity(rs.getString("city"));
                address.setState(rs.getString("state"));
                address.setZipCode(rs.getString("zip_code"));
                address.setPhone(rs.getString("phone"));
                address.setDefault(rs.getBoolean("is_default"));
                addresses.add(address);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return addresses;
    }
    
    @Override
    public DeliveryAddress getDefaultDeliveryAddress(int userId) {
        String query = "SELECT * FROM delivery_addresses WHERE user_id = ? AND is_default = TRUE LIMIT 1";
        try (Connection con = ConnectionProvider.provideConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                DeliveryAddress address = new DeliveryAddress();
                address.setId(rs.getInt("id"));
                address.setUserId(rs.getInt("user_id"));
                address.setStreetAddress(rs.getString("street_address"));
                address.setCity(rs.getString("city"));
                address.setState(rs.getString("state"));
                address.setZipCode(rs.getString("zip_code"));
                address.setPhone(rs.getString("phone"));
                address.setDefault(rs.getBoolean("is_default"));
                return address;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    @Override
    public boolean updateDeliveryAddress(DeliveryAddress address) {
        String query = "UPDATE delivery_addresses SET street_address = ?, city = ?, state = ?, zip_code = ?, phone = ?, is_default = ? WHERE id = ?";
        try (Connection con = ConnectionProvider.provideConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, address.getStreetAddress());
            ps.setString(2, address.getCity());
            ps.setString(3, address.getState());
            ps.setString(4, address.getZipCode());
            ps.setString(5, address.getPhone());
            ps.setBoolean(6, address.isDefault());
            ps.setInt(7, address.getId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    @Override
    public boolean deleteDeliveryAddress(int id) {
        String query = "DELETE FROM delivery_addresses WHERE id = ?";
        try (Connection con = ConnectionProvider.provideConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
