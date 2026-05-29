package com.DAOImpl;

import com.DAO.ReviewDAO;
import com.bean.Review;
import com.aspect.ConnectionProvider;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReviewDAOImpl implements ReviewDAO {

    @Override
    public boolean addReview(Review review) {
        String sql = "INSERT INTO reviews(productId, userId, rating, comment, reviewDate) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = ConnectionProvider.provideConnection(); 
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, review.getProductId());
            ps.setInt(2, review.getUserId());
            ps.setInt(3, review.getRating());
            ps.setString(4, review.getComment());
            ps.setTimestamp(5, new Timestamp(review.getReviewDate().getTime()));
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateReview(Review review) {
        String sql = "UPDATE reviews SET rating=?, comment=? WHERE id=?";
        try (Connection conn = ConnectionProvider.provideConnection(); 
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, review.getRating());
            ps.setString(2, review.getComment());
            ps.setInt(3, review.getId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteReview(int reviewId) {
        String sql = "DELETE FROM reviews WHERE id=?";
        try (Connection conn = ConnectionProvider.provideConnection(); 
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, reviewId);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Review getReviewById(int reviewId) {
        String sql = "SELECT * FROM reviews WHERE id=?";
        try (Connection conn = ConnectionProvider.provideConnection(); 
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, reviewId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Review review = new Review();
                review.setId(rs.getInt("id"));
                review.setProductId(rs.getInt("productId"));
                review.setUserId(rs.getInt("userId"));
                review.setRating(rs.getInt("rating"));
                review.setComment(rs.getString("comment"));
                review.setReviewDate(new java.util.Date(rs.getTimestamp("reviewDate").getTime()));
                return review;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Review> getReviewsByProductId(int productId) {
        String sql = "SELECT r.*, u.name FROM reviews r JOIN users u ON r.userId = u.id WHERE r.productId=? ORDER BY r.reviewDate DESC";
        List<Review> reviews = new ArrayList<>();
        try (Connection conn = ConnectionProvider.provideConnection(); 
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, productId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Review review = new Review();
                review.setId(rs.getInt("id"));
                review.setProductId(rs.getInt("productId"));
                review.setUserId(rs.getInt("userId"));
                review.setRating(rs.getInt("rating"));
                review.setComment(rs.getString("comment"));
                review.setReviewDate(new java.util.Date(rs.getTimestamp("reviewDate").getTime()));
                review.setUserName(rs.getString("name"));
                reviews.add(review);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reviews;
    }

    @Override
    public List<Review> getReviewsByUserId(int userId) {
        String sql = "SELECT * FROM reviews WHERE userId=? ORDER BY reviewDate DESC";
        List<Review> reviews = new ArrayList<>();
        try (Connection conn = ConnectionProvider.provideConnection(); 
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Review review = new Review();
                review.setId(rs.getInt("id"));
                review.setProductId(rs.getInt("productId"));
                review.setUserId(rs.getInt("userId"));
                review.setRating(rs.getInt("rating"));
                review.setComment(rs.getString("comment"));
                review.setReviewDate(new java.util.Date(rs.getTimestamp("reviewDate").getTime()));
                reviews.add(review);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reviews;
    }

    @Override
    public double getAverageRatingByProductId(int productId) {
        String sql = "SELECT AVG(rating) as avgRating FROM reviews WHERE productId=?";
        try (Connection conn = ConnectionProvider.provideConnection(); 
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, productId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getDouble("avgRating");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0.0;
    }

    @Override
    public int getReviewCountByProductId(int productId) {
        String sql = "SELECT COUNT(*) as reviewCount FROM reviews WHERE productId=?";
        try (Connection conn = ConnectionProvider.provideConnection(); 
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, productId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("reviewCount");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
