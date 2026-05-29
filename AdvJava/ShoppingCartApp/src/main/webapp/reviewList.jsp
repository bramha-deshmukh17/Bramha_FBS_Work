<%@ page contentType="text/html; charset=UTF-8" %>
    <%@ page import="java.util.List" %>
        <%@ page import="com.bean.Review" %>
            <%@ page import="com.serviceimpl.ReviewServiceImpl" %>
                <%@ page import="com.services.ReviewService" %>
                    <% Integer productId=null; if (request.getParameter("productId") !=null) {
                        productId=Integer.parseInt(request.getParameter("productId")); } else if
                        (request.getAttribute("productId") !=null) { productId=(Integer)
                        request.getAttribute("productId"); } ReviewService reviewService=new ReviewServiceImpl();
                        List<Review> reviews = reviewService.getReviewsByProductId(productId);
                        double avgRating = reviewService.getAverageRatingByProductId(productId);
                        int reviewCount = reviewService.getReviewCountByProductId(productId);
                        %>
                        <!DOCTYPE html>
                        <html>

                        <head>
                            <meta charset="UTF-8">
                            <title>Product Reviews</title>
                            <style>
                                body {
                                    font-family: Arial, sans-serif;
                                    background-color: #f4f4f4;
                                    margin: 0;
                                    padding: 20px;
                                }

                                .container {
                                    max-width: 900px;
                                    margin: 0 auto;
                                    background-color: white;
                                    padding: 30px;
                                    border-radius: 8px;
                                    box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
                                }

                                h1 {
                                    color: #333;
                                    border-bottom: 2px solid #ffc107;
                                    padding-bottom: 15px;
                                }

                                .rating-summary {
                                    display: flex;
                                    align-items: center;
                                    margin-bottom: 30px;
                                    padding: 20px;
                                    background-color: #f9f9f9;
                                    border-radius: 8px;
                                }

                                .rating-score {
                                    font-size: 48px;
                                    font-weight: bold;
                                    color: #ffc107;
                                    margin-right: 30px;
                                    min-width: 80px;
                                }

                                .rating-details {
                                    flex: 1;
                                }

                                .stars {
                                    font-size: 24px;
                                    color: #ffc107;
                                    margin-bottom: 10px;
                                }

                                .review-count {
                                    color: #666;
                                    font-size: 14px;
                                }

                                .add-review-btn {
                                    background-color: #ffc107;
                                    color: #333;
                                    border: none;
                                    padding: 10px 20px;
                                    border-radius: 4px;
                                    cursor: pointer;
                                    font-weight: bold;
                                    text-decoration: none;
                                }

                                .add-review-btn:hover {
                                    background-color: #ffb300;
                                }

                                .reviews-section {
                                    margin-top: 30px;
                                }

                                .review-item {
                                    background-color: #f9f9f9;
                                    padding: 15px;
                                    margin-bottom: 15px;
                                    border-left: 4px solid #ffc107;
                                    border-radius: 4px;
                                }

                                .review-header {
                                    display: flex;
                                    justify-content: space-between;
                                    align-items: center;
                                    margin-bottom: 10px;
                                }

                                .reviewer-name {
                                    font-weight: bold;
                                    color: #333;
                                }

                                .review-date {
                                    color: #999;
                                    font-size: 12px;
                                }

                                .review-rating {
                                    color: #ffc107;
                                    font-size: 16px;
                                    margin-bottom: 10px;
                                }

                                .review-comment {
                                    color: #555;
                                    line-height: 1.6;
                                    word-wrap: break-word;
                                }

                                .no-reviews {
                                    text-align: center;
                                    padding: 40px;
                                    color: #999;
                                }

                                .back-btn {
                                    display: inline-block;
                                    background-color: #6c757d;
                                    color: white;
                                    padding: 10px 20px;
                                    border-radius: 4px;
                                    text-decoration: none;
                                    margin-top: 20px;
                                }

                                .back-btn:hover {
                                    background-color: #5a6268;
                                }
                            </style>
                        </head>

                        <body>
                            <div class="container">
                                <h1>⭐ Product Reviews (Product ID: <%= productId %>)</h1>

                                <div class="rating-summary">
                                    <div class="rating-score">
                                        <%= String.format("%.1f", avgRating) %>
                                    </div>
                                    <div class="rating-details">
                                        <div class="stars">
                                            <% int fullStars=(int) avgRating; for (int i=0; i < fullStars; i++) {
                                                out.print("★"); } if (avgRating % 1>= 0.5) {
                                                out.print("☆");
                                                }
                                                %>
                                        </div>
                                        <div class="review-count">Based on <%= reviewCount %> reviews</div>
                                    </div>
                                    <a href="productList.jsp?productId=<%= productId %>" class="add-review-btn">+ Add
                                        Review</a>
                                </div>

                                <div class="reviews-section">
                                    <% if (reviews.isEmpty()) { %>
                                        <div class="no-reviews">
                                            <p>No reviews yet. Be the first to review this product!</p>
                                        </div>
                                        <% } else { %>
                                            <% for (Review review : reviews) { %>
                                                <div class="review-item">
                                                    <div class="review-header">
                                                        <span class="reviewer-name">
                                                            <%= review.getUserName() !=null ? review.getUserName()
                                                                : "Anonymous" %>
                                                        </span>
                                                        <span class="review-date">
                                                            <%= new java.text.SimpleDateFormat("dd MMM
                                                                yyyy").format(review.getReviewDate()) %>
                                                        </span>
                                                    </div>
                                                    <div class="review-rating">
                                                        <% for (int i=0; i < review.getRating(); i++) { out.print("★");
                                                            } for (int i=review.getRating(); i < 5; i++) {
                                                            out.print("☆"); } %>
                                                            <span style="color: #666; margin-left: 5px;">
                                                                <%= review.getRating() %>/5
                                                            </span>
                                                    </div>
                                                    <div class="review-comment">
                                                        <%= review.getComment() %>
                                                    </div>
                                                </div>
                                                <% } %>
                                                    <% } %>
                                </div>

                                <a href="productList.jsp" class="back-btn">← Back to Products</a>
                            </div>
                        </body>

                        </html>