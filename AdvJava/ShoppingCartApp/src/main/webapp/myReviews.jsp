<%@ page contentType="text/html; charset=UTF-8" %>
    <%@ page import="java.util.List" %>
        <%@ page import="com.bean.Review" %>
            <% Integer userId=(Integer) session.getAttribute("userId"); if (userId==null) {
                response.sendRedirect("login.jsp?message=Please login first"); return; } @SuppressWarnings("unchecked")
                List<Review> reviews = (List<Review>) request.getAttribute("reviews");
                    if (reviews == null) {
                    reviews = new java.util.ArrayList<>();
                        }
                        %>
                        <!DOCTYPE html>
                        <html>

                        <head>
                            <meta charset="UTF-8">
                            <title>My Reviews</title>
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

                                .no-reviews {
                                    text-align: center;
                                    padding: 40px;
                                    color: #999;
                                }

                                .review-card {
                                    background-color: #f9f9f9;
                                    padding: 20px;
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

                                .product-id {
                                    font-weight: bold;
                                    color: #333;
                                }

                                .review-date {
                                    color: #999;
                                    font-size: 12px;
                                }

                                .stars {
                                    color: #ffc107;
                                    font-size: 18px;
                                    margin-bottom: 10px;
                                }

                                .review-comment {
                                    color: #555;
                                    line-height: 1.6;
                                    word-wrap: break-word;
                                    margin-bottom: 10px;
                                }

                                .review-actions {
                                    margin-top: 10px;
                                    display: flex;
                                    gap: 10px;
                                }

                                .btn {
                                    padding: 6px 12px;
                                    border: none;
                                    border-radius: 4px;
                                    cursor: pointer;
                                    font-size: 12px;
                                    font-weight: bold;
                                }

                                .btn-edit {
                                    background-color: #007bff;
                                    color: white;
                                }

                                .btn-edit:hover {
                                    background-color: #0056b3;
                                }

                                .btn-delete {
                                    background-color: #dc3545;
                                    color: white;
                                }

                                .btn-delete:hover {
                                    background-color: #c82333;
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

                                .stats {
                                    background-color: #f0f0f0;
                                    padding: 15px;
                                    border-radius: 4px;
                                    margin-bottom: 20px;
                                    display: flex;
                                    gap: 30px;
                                }

                                .stat-item {
                                    flex: 1;
                                    text-align: center;
                                }

                                .stat-value {
                                    font-size: 28px;
                                    font-weight: bold;
                                    color: #ffc107;
                                }

                                .stat-label {
                                    color: #666;
                                    font-size: 12px;
                                    margin-top: 5px;
                                }
                            </style>
                        </head>

                        <body>
                            <div class="container">
                                <h1>⭐ My Product Reviews</h1>

                                <% if (reviews !=null && !reviews.isEmpty()) { %>
                                    <div class="stats">
                                        <div class="stat-item">
                                            <div class="stat-value">
                                                <%= reviews.size() %>
                                            </div>
                                            <div class="stat-label">Total Reviews</div>
                                        </div>
                                        <div class="stat-item">
                                            <div class="stat-value">
                                                <% if (reviews.size()> 0) {
                                                    double sum = 0;
                                                    for (Review r : reviews) {
                                                    sum += r.getRating();
                                                    }
                                                    out.print(String.format("%.1f", sum / reviews.size()));
                                                    } else {
                                                    out.print("0");
                                                    }
                                                    %>
                                            </div>
                                            <div class="stat-label">Average Rating</div>
                                        </div>
                                    </div>

                                    <% for (Review review : reviews) { %>
                                        <div class="review-card">
                                            <div class="review-header">
                                                <span class="product-id">Product ID: <%= review.getProductId() %></span>
                                                <span class="review-date">
                                                    <%= new java.text.SimpleDateFormat("dd MMM
                                                        yyyy").format(review.getReviewDate()) %>
                                                </span>
                                            </div>

                                            <div class="stars">
                                                <% for (int i=0; i < review.getRating(); i++) { out.print("★"); } for
                                                    (int i=review.getRating(); i < 5; i++) { out.print("☆"); } %>
                                                    <span style="color: #666; margin-left: 5px; font-size: 14px;">
                                                        <%= review.getRating() %>/5
                                                    </span>
                                            </div>

                                            <div class="review-comment">
                                                <%= review.getComment() %>
                                            </div>

                                            <div class="review-actions">
                                                <form method="post" action="ReviewServlet" style="display: inline;">
                                                    <input type="hidden" name="action" value="deleteReview">
                                                    <input type="hidden" name="reviewId" value="<%= review.getId() %>">
                                                    <button type="submit" class="btn btn-delete"
                                                        onclick="return confirm('Are you sure?')">Delete Review</button>
                                                </form>
                                            </div>
                                        </div>
                                        <% } %>
                                            <% } else { %>
                                                <div class="no-reviews">
                                                    <p>You haven't written any reviews yet</p>
                                                    <a href="productList.jsp"
                                                        style="color: #007bff; text-decoration: none;">Browse Products
                                                        →</a>
                                                </div>
                                                <% } %>

                                                    <a href="productList.jsp" class="back-btn">← Back to Products</a>
                            </div>
                        </body>

                        </html>