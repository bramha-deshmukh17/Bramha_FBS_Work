package com.serviceimpl;

import com.services.ReviewService;
import com.bean.Review;
import com.DAOImpl.ReviewDAOImpl;
import com.DAO.ReviewDAO;
import java.util.List;

public class ReviewServiceImpl implements ReviewService {
    private ReviewDAO reviewDAO = new ReviewDAOImpl();

    @Override
    public boolean addReview(Review review) {
        return reviewDAO.addReview(review);
    }

    @Override
    public boolean updateReview(Review review) {
        return reviewDAO.updateReview(review);
    }

    @Override
    public boolean deleteReview(int reviewId) {
        return reviewDAO.deleteReview(reviewId);
    }

    @Override
    public Review getReviewById(int reviewId) {
        return reviewDAO.getReviewById(reviewId);
    }

    @Override
    public List<Review> getReviewsByProductId(int productId) {
        return reviewDAO.getReviewsByProductId(productId);
    }

    @Override
    public List<Review> getReviewsByUserId(int userId) {
        return reviewDAO.getReviewsByUserId(userId);
    }

    @Override
    public double getAverageRatingByProductId(int productId) {
        return reviewDAO.getAverageRatingByProductId(productId);
    }

    @Override
    public int getReviewCountByProductId(int productId) {
        return reviewDAO.getReviewCountByProductId(productId);
    }
}
