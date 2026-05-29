package com.controller;

import com.bean.Review;
import com.serviceimpl.ReviewServiceImpl;
import com.services.ReviewService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

@WebServlet("/ReviewServlet")
public class ReviewServlet extends HttpServlet {
    private ReviewService reviewService = new ReviewServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        HttpSession session = request.getSession();

        if ("addReview".equals(action)) {
            addReview(request, response, session);
        } else if ("updateReview".equals(action)) {
            updateReview(request, response, session);
        } else if ("deleteReview".equals(action)) {
            deleteReview(request, response, session);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("viewReviews".equals(action)) {
            viewProductReviews(request, response);
        } else if ("myReviews".equals(action)) {
            viewMyReviews(request, response);
        }
    }

    private void addReview(HttpServletRequest request, HttpServletResponse response, HttpSession session)
            throws ServletException, IOException {
        try {
            // Validate user first
            Integer userId = (Integer) session.getAttribute("userId");
            if (userId == null) {
                response.sendRedirect("login.jsp?message=Please login to add a review");
                return;
            }

            // Validate parameters exist before parsing
            String productIdParam = request.getParameter("productId");
            String ratingParam = request.getParameter("rating");
            if (productIdParam == null || productIdParam.trim().isEmpty() ||
                ratingParam == null || ratingParam.trim().isEmpty()) {
                response.sendRedirect("productList.jsp?message=Missing required fields");
                return;
            }

            int productId = Integer.parseInt(productIdParam);
            int rating = Integer.parseInt(ratingParam);
            String comment = request.getParameter("comment");

            if (rating < 1 || rating > 5) {
                response.sendRedirect("productList.jsp?message=Rating must be between 1 and 5");
                return;
            }

            Review review = new Review(productId, userId, rating, comment, new Date());
            if (reviewService.addReview(review)) {
                response.sendRedirect("productList.jsp?message=Review added successfully");
            } else {
                response.sendRedirect("productList.jsp?message=Failed to add review");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("productList.jsp?message=Error adding review");
        }
    }

    private void updateReview(HttpServletRequest request, HttpServletResponse response, HttpSession session)
            throws ServletException, IOException {
        try {
            int reviewId = Integer.parseInt(request.getParameter("reviewId"));
            int rating = Integer.parseInt(request.getParameter("rating"));
            String comment = request.getParameter("comment");

            if (rating < 1 || rating > 5) {
                response.sendRedirect("productList.jsp?message=Rating must be between 1 and 5");
                return;
            }

            Review review = reviewService.getReviewById(reviewId);
            if (review != null) {
                review.setRating(rating);
                review.setComment(comment);
                if (reviewService.updateReview(review)) {
                    response.sendRedirect("productList.jsp?message=Review updated successfully");
                } else {
                    response.sendRedirect("productList.jsp?message=Failed to update review");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("productList.jsp?message=Error updating review");
        }
    }

    private void deleteReview(HttpServletRequest request, HttpServletResponse response, HttpSession session)
            throws ServletException, IOException {
        try {
            int reviewId = Integer.parseInt(request.getParameter("reviewId"));
            if (reviewService.deleteReview(reviewId)) {
                response.sendRedirect("productList.jsp?message=Review deleted successfully");
            } else {
                response.sendRedirect("productList.jsp?message=Failed to delete review");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("productList.jsp?message=Error deleting review");
        }
    }

    private void viewProductReviews(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int productId = Integer.parseInt(request.getParameter("productId"));
            request.setAttribute("reviews", reviewService.getReviewsByProductId(productId));
            request.setAttribute("avgRating", reviewService.getAverageRatingByProductId(productId));
            request.setAttribute("reviewCount", reviewService.getReviewCountByProductId(productId));
            request.getRequestDispatcher("reviewList.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void viewMyReviews(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            Integer userId = (Integer) session.getAttribute("userId");
            if (userId != null) {
                request.setAttribute("reviews", reviewService.getReviewsByUserId(userId));
                request.getRequestDispatcher("myReviews.jsp").forward(request, response);
            } else {
                response.sendRedirect("login.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
