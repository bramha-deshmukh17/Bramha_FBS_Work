package com.DAO;

import com.bean.Review;
import java.util.List;

public interface ReviewDAO {
    boolean addReview(Review review);

    boolean updateReview(Review review);

    boolean deleteReview(int reviewId);

    Review getReviewById(int reviewId);

    List<Review> getReviewsByProductId(int productId);

    List<Review> getReviewsByUserId(int userId);

    double getAverageRatingByProductId(int productId);

    int getReviewCountByProductId(int productId);
}
