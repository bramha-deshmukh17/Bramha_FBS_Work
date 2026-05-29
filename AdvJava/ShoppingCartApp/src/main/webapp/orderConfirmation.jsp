<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="jakarta.tags.core" prefix="c" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <title>Order Confirmation</title>
            <script src="https://cdn.tailwindcss.com"></script>
        </head>

        <body class="bg-gray-100 min-h-screen">
            <nav class="bg-blue-600 text-white px-6 py-4 flex justify-between items-center shadow-md">
                <h1 class="text-xl font-bold">Order Confirmed</h1>
                <div class="flex items-center gap-3">
                    <a href="${pageContext.request.contextPath}/products"
                        class="bg-white text-blue-600 px-4 py-2 rounded-lg font-semibold hover:bg-gray-100 transition">Shop</a>
                    <a href="${pageContext.request.contextPath}/orders"
                        class="bg-white text-blue-600 px-4 py-2 rounded-lg font-semibold hover:bg-gray-100 transition">My
                        Orders</a>
                </div>
            </nav>

            <div class="max-w-2xl mx-auto mt-10 px-4">
                <!-- Success Message -->
                <div class="bg-white rounded-2xl shadow-lg overflow-hidden mb-6">
                    <div class="bg-gradient-to-r from-green-600 to-green-800 text-white px-6 py-8 text-center">
                        <div class="text-6xl mb-4">✓</div>
                        <h1 class="text-3xl font-bold mb-2">Payment Successful!</h1>
                        <p class="text-green-100 text-lg">Your order has been confirmed</p>
                    </div>

                    <div class="p-8">
                        <!-- Order Information -->
                        <div class="bg-gray-50 p-6 rounded-lg mb-6">
                            <h2 class="text-xl font-bold text-gray-800 mb-4">Order Summary</h2>
                            <div class="space-y-3">
                                <div class="flex justify-between">
                                    <span class="text-gray-600">Order ID:</span>
                                    <span class="font-semibold text-gray-800">${orderId}</span>
                                </div>
                                <div class="flex justify-between">
                                    <span class="text-gray-600">Amount Paid:</span>
                                    <span class="font-semibold text-green-600">₹ ${amount}</span>
                                </div>
                                <div class="flex justify-between">
                                    <span class="text-gray-600">Payment Status:</span>
                                    <span
                                        class="inline-flex items-center px-3 py-1 rounded-full text-sm font-semibold bg-green-100 text-green-700">
                                        ✓ Paid
                                    </span>
                                </div>
                                <div class="flex justify-between">
                                    <span class="text-gray-600">Order Status:</span>
                                    <span
                                        class="inline-flex items-center px-3 py-1 rounded-full text-sm font-semibold bg-blue-100 text-blue-700">
                                        📦 Shipped
                                    </span>
                                </div>
                            </div>
                        </div>

                        <!-- Next Steps -->
                        <div class="bg-blue-50 border border-blue-200 rounded-lg p-6 mb-6">
                            <h3 class="text-lg font-semibold text-gray-800 mb-4">What's Next?</h3>
                            <ul class="space-y-3">
                                <li class="flex items-start">
                                    <span
                                        class="flex-shrink-0 h-6 w-6 flex items-center justify-center rounded-full bg-blue-600 text-white text-sm font-bold mr-3">1</span>
                                    <span class="text-gray-700">Your order will be dispatched soon</span>
                                </li>
                                <li class="flex items-start">
                                    <span
                                        class="flex-shrink-0 h-6 w-6 flex items-center justify-center rounded-full bg-blue-600 text-white text-sm font-bold mr-3">2</span>
                                    <span class="text-gray-700">You will receive an SMS/Email with tracking
                                        details</span>
                                </li>
                                <li class="flex items-start">
                                    <span
                                        class="flex-shrink-0 h-6 w-6 flex items-center justify-center rounded-full bg-blue-600 text-white text-sm font-bold mr-3">3</span>
                                    <span class="text-gray-700">Track your order from "My Orders" page</span>
                                </li>
                                <li class="flex items-start">
                                    <span
                                        class="flex-shrink-0 h-6 w-6 flex items-center justify-center rounded-full bg-blue-600 text-white text-sm font-bold mr-3">4</span>
                                    <span class="text-gray-700">Receive and rate the products</span>
                                </li>
                            </ul>
                        </div>

                        <!-- Action Buttons -->
                        <div class="flex gap-4">
                            <a href="${pageContext.request.contextPath}/orders"
                                class="flex-1 bg-blue-600 hover:bg-blue-700 text-white font-bold py-3 rounded-lg text-center transition">
                                View My Orders
                            </a>
                            <a href="${pageContext.request.contextPath}/products"
                                class="flex-1 bg-gray-300 hover:bg-gray-400 text-gray-800 font-bold py-3 rounded-lg text-center transition">
                                Continue Shopping
                            </a>
                        </div>

                        <!-- Support -->
                        <div class="mt-8 pt-6 border-t border-gray-300 text-center">
                            <p class="text-gray-600 mb-2">Need help? We're here for you</p>
                            <a href="mailto:support@example.com"
                                class="text-blue-600 hover:text-blue-800 font-medium">support@example.com</a>
                        </div>
                    </div>
                </div>
            </div>
        </body>

        </html>

        <head>
            <meta charset="UTF-8">
            <title>Order Confirmation</title>
            <style>
                body {
                    font-family: Arial, sans-serif;
                    background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
                    margin: 0;
                    padding: 20px;
                    min-height: 100vh;
                    display: flex;
                    align-items: center;
                    justify-content: center;
                }

                .container {
                    background-color: white;
                    padding: 40px;
                    border-radius: 12px;
                    box-shadow: 0 10px 25px rgba(0, 0, 0, 0.2);
                    max-width: 600px;
                    width: 100%;
                }

                .success-header {
                    text-align: center;
                    margin-bottom: 30px;
                }

                .success-icon {
                    font-size: 60px;
                    margin-bottom: 10px;
                }

                h1 {
                    color: #28a745;
                    margin: 0;
                    font-size: 32px;
                }

                .subtitle {
                    color: #666;
                    font-size: 16px;
                    margin-top: 5px;
                }

                .order-details {
                    background-color: #f8f9fa;
                    padding: 20px;
                    border-radius: 8px;
                    margin: 20px 0;
                    border-left: 4px solid #28a745;
                }

                .detail-row {
                    display: flex;
                    justify-content: space-between;
                    padding: 12px 0;
                    border-bottom: 1px solid #e9ecef;
                }

                .detail-row:last-child {
                    border-bottom: none;
                }

                .detail-label {
                    color: #666;
                    font-weight: 500;
                }

                .detail-value {
                    color: #333;
                    font-weight: bold;
                }

                .total-row {
                    background-color: white;
                    padding: 15px;
                    border-radius: 8px;
                    margin: 15px 0;
                }

                .total-row .detail-row {
                    font-size: 18px;
                    padding: 15px 0;
                }

                .total-row .detail-value {
                    color: #28a745;
                    font-size: 24px;
                }

                .status-badge {
                    display: inline-block;
                    background-color: #28a745;
                    color: white;
                    padding: 8px 16px;
                    border-radius: 20px;
                    font-size: 14px;
                    font-weight: bold;
                }

                .tracking-info {
                    background-color: #e7f3ff;
                    padding: 15px;
                    border-radius: 8px;
                    margin: 15px 0;
                    border-left: 4px solid #0066cc;
                }

                .tracking-label {
                    color: #0066cc;
                    font-weight: bold;
                    font-size: 14px;
                }

                .tracking-value {
                    color: #333;
                    font-size: 14px;
                    margin-top: 5px;
                }

                .timeline {
                    margin: 20px 0;
                    padding: 20px;
                    background-color: #f8f9fa;
                    border-radius: 8px;
                }

                .timeline-item {
                    display: flex;
                    margin-bottom: 15px;
                }

                .timeline-item:last-child {
                    margin-bottom: 0;
                }

                .timeline-dot {
                    width: 12px;
                    height: 12px;
                    border-radius: 50%;
                    background-color: #28a745;
                    margin-right: 15px;
                    margin-top: 5px;
                }

                .timeline-text {
                    color: #333;
                }

                .buttons {
                    display: flex;
                    gap: 10px;
                    margin-top: 25px;
                    justify-content: center;
                }

                .btn {
                    flex: 1;
                    padding: 12px 20px;
                    border: none;
                    border-radius: 4px;
                    cursor: pointer;
                    font-size: 16px;
                    font-weight: bold;
                    text-decoration: none;
                    text-align: center;
                }

                .btn-primary {
                    background-color: #28a745;
                    color: white;
                }

                .btn-primary:hover {
                    background-color: #218838;
                }

                .btn-secondary {
                    background-color: #0066cc;
                    color: white;
                }

                .btn-secondary:hover {
                    background-color: #0052a3;
                }
            </style>
        </head>

        <body>
            <div class="container">
                <div class="success-header">
                    <div class="success-icon">✅</div>
                    <h1>Order Confirmed!</h1>
                    <p class="subtitle">Thank you for your purchase. Your order has been successfully placed.</p>
                </div>

                <div class="order-details">
                    <div class="detail-row">
                        <span class="detail-label">Order ID:</span>
                        <span class="detail-value">#<%= order.getId() %></span>
                    </div>
                    <div class="detail-row">
                        <span class="detail-label">Order Date:</span>
                        <span class="detail-value">
                            <%= new java.text.SimpleDateFormat("dd-MMM-yyyy HH:mm").format(order.getOrderDate()) %>
                        </span>
                    </div>
                    <div class="detail-row">
                        <span class="detail-label">Status:</span>
                        <span><span class="status-badge">
                                <%= order.getStatus() %>
                            </span></span>
                    </div>
                    <div class="detail-row">
                        <span class="detail-label">Shipping Address:</span>
                        <span class="detail-value">
                            <%= order.getShippingAddress() !=null ? order.getShippingAddress() : "Standard Shipping" %>
                        </span>
                    </div>
                </div>

                <div class="total-row">
                    <div class="detail-row">
                        <span class="detail-label">Total Amount:</span>
                        <span class="detail-value">Rs. <%= String.format("%.2f", order.getTotalAmount()) %></span>
                    </div>
                </div>

                <% if (order.getTrackingNumber() !=null && !order.getTrackingNumber().isEmpty()) { %>
                    <div class="tracking-info">
                        <div class="tracking-label">📍 Tracking Number:</div>
                        <div class="tracking-value">
                            <%= order.getTrackingNumber() %>
                        </div>
                    </div>
                    <% } %>

                        <div class="timeline">
                            <div class="timeline-item">
                                <div class="timeline-dot"></div>
                                <div class="timeline-text">Order Placed - <%= new java.text.SimpleDateFormat("dd MMM
                                        yyyy").format(order.getOrderDate()) %>
                                </div>
                            </div>
                            <% if (order.getDeliveryDate() !=null) { %>
                                <div class="timeline-item">
                                    <div class="timeline-dot"></div>
                                    <div class="timeline-text">Expected Delivery - <%= new
                                            java.text.SimpleDateFormat("dd MMM yyyy").format(order.getDeliveryDate()) %>
                                    </div>
                                </div>
                                <% } %>
                                    <div class="timeline-item">
                                        <div class="timeline-dot"></div>
                                        <div class="timeline-text">Currently <%= order.getStatus() %>
                                        </div>
                                    </div>
                        </div>

                        <div class="buttons">
                            <a href="orders.jsp" class="btn btn-primary">View My Orders</a>
                            <a href="productList.jsp" class="btn btn-secondary">Continue Shopping</a>
                        </div>
            </div>
        </body>

        </html>