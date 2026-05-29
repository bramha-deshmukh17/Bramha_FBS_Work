<%@ page contentType="text/html; charset=UTF-8" %>
    <%@ page import="java.util.List" %>
        <%@ page import="com.bean.CartItem" %>
            <%@ page import="com.serviceimpl.CartServiceImpl" %>
                <%@ page import="com.services.CartService" %>
                    <% Integer userId=(Integer) session.getAttribute("userId"); String userName=(String)
                        session.getAttribute("userName"); if (userId==null) {
                        response.sendRedirect("login.jsp?message=Please login first"); return; } CartService
                        cartService=new CartServiceImpl(); List<CartItem> cartItems =
                        cartService.getCartItemsByUserId(userId);

                        double totalPrice = 0;
                        for (CartItem item : cartItems) {
                        totalPrice += item.getPrice() * item.getQuantity();
                        }
                        %>
                        <!DOCTYPE html>
                        <html>

                        <head>
                            <meta charset="UTF-8">
                            <title>Shopping Cart</title>
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
                                    padding: 20px;
                                    border-radius: 8px;
                                    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
                                }

                                h1 {
                                    color: #333;
                                    border-bottom: 2px solid #007bff;
                                    padding-bottom: 10px;
                                }

                                .cart-empty {
                                    text-align: center;
                                    padding: 40px;
                                    color: #666;
                                }

                                .cart-table {
                                    width: 100%;
                                    border-collapse: collapse;
                                    margin-top: 20px;
                                }

                                .cart-table th {
                                    background-color: #007bff;
                                    color: white;
                                    padding: 12px;
                                    text-align: left;
                                }

                                .cart-table td {
                                    padding: 12px;
                                    border-bottom: 1px solid #ddd;
                                }

                                .cart-table tr:hover {
                                    background-color: #f9f9f9;
                                }

                                .product-image {
                                    max-width: 60px;
                                    height: auto;
                                }

                                .quantity-input {
                                    width: 60px;
                                    padding: 5px;
                                }

                                .action-btn {
                                    background-color: #dc3545;
                                    color: white;
                                    border: none;
                                    padding: 6px 12px;
                                    border-radius: 4px;
                                    cursor: pointer;
                                }

                                .action-btn:hover {
                                    background-color: #c82333;
                                }

                                .cart-summary {
                                    margin-top: 20px;
                                    padding: 15px;
                                    background-color: #f0f0f0;
                                    border-radius: 4px;
                                    text-align: right;
                                }

                                .summary-row {
                                    font-size: 18px;
                                    margin: 10px 0;
                                }

                                .total {
                                    font-size: 24px;
                                    font-weight: bold;
                                    color: #007bff;
                                    margin-top: 15px;
                                }

                                .buttons {
                                    margin-top: 20px;
                                    text-align: right;
                                }

                                .btn {
                                    padding: 10px 20px;
                                    margin-left: 10px;
                                    border: none;
                                    border-radius: 4px;
                                    cursor: pointer;
                                    font-size: 16px;
                                    text-decoration: none;
                                    display: inline-block;
                                }

                                .btn-primary {
                                    background-color: #007bff;
                                    color: white;
                                }

                                .btn-primary:hover {
                                    background-color: #0056b3;
                                }

                                .btn-secondary {
                                    background-color: #6c757d;
                                    color: white;
                                }

                                .btn-secondary:hover {
                                    background-color: #5a6268;
                                }

                                .message {
                                    padding: 12px;
                                    margin-bottom: 15px;
                                    border-radius: 4px;
                                }

                                .message.success {
                                    background-color: #d4edda;
                                    color: #155724;
                                    border: 1px solid #c3e6cb;
                                }

                                .message.error {
                                    background-color: #f8d7da;
                                    color: #721c24;
                                    border: 1px solid #f5c6cb;
                                }
                            </style>
                        </head>

                        <body>
                            <div class="container">
                                <h1>🛒 Shopping Cart</h1>

                                <% if (request.getParameter("message") !=null) { %>
                                    <div class="message success">
                                        <%= request.getParameter("message") %>
                                    </div>
                                    <% } %>

                                        <% if (cartItems.isEmpty()) { %>
                                            <div class="cart-empty">
                                                <p>Your cart is empty</p>
                                                <a href="productList.jsp" class="btn btn-primary">Continue Shopping</a>
                                            </div>
                                            <% } else { %>
                                                <table class="cart-table">
                                                    <thead>
                                                        <tr>
                                                            <th>Product</th>
                                                            <th>Price</th>
                                                            <th>Quantity</th>
                                                            <th>Subtotal</th>
                                                            <th>Action</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <% for (CartItem item : cartItems) { %>
                                                            <tr>
                                                                <td>
                                                                    <% if (item.getImageUrl() !=null &&
                                                                        !item.getImageUrl().isEmpty()) { %>
                                                                        <img src="<%= item.getImageUrl() %>"
                                                                            alt="<%= item.getProductName() %>"
                                                                            class="product-image">
                                                                        <% } %>
                                                                            <%= item.getProductName() %>
                                                                </td>
                                                                <td>Rs. <%= String.format("%.2f", item.getPrice()) %>
                                                                </td>
                                                                <td>
                                                                    <form method="post" action="CartServlet"
                                                                        style="display:inline;">
                                                                        <input type="hidden" name="action"
                                                                            value="update">
                                                                        <input type="hidden" name="cartItemId"
                                                                            value="<%= item.getId() %>">
                                                                        <input type="number" name="quantity"
                                                                            value="<%= item.getQuantity() %>" min="1"
                                                                            class="quantity-input">
                                                                        <button type="submit"
                                                                            style="padding: 5px 10px; cursor: pointer;">Update</button>
                                                                    </form>
                                                                </td>
                                                                <td>Rs. <%= String.format("%.2f", item.getPrice() *
                                                                        item.getQuantity()) %>
                                                                </td>
                                                                <td>
                                                                    <form method="post" action="CartServlet"
                                                                        style="display:inline;">
                                                                        <input type="hidden" name="action"
                                                                            value="remove">
                                                                        <input type="hidden" name="cartItemId"
                                                                            value="<%= item.getId() %>">
                                                                        <button type="submit"
                                                                            class="action-btn">Remove</button>
                                                                    </form>
                                                                </td>
                                                            </tr>
                                                            <% } %>
                                                    </tbody>
                                                </table>

                                                <div class="cart-summary">
                                                    <div class="summary-row">Items: <%= cartItems.size() %>
                                                    </div>
                                                    <div class="total">Total: Rs. <%= String.format("%.2f", totalPrice)
                                                            %>
                                                    </div>
                                                </div>

                                                <div class="buttons">
                                                    <a href="productList.jsp" class="btn btn-secondary">Continue
                                                        Shopping</a>
                                                    <a href="checkout.jsp" class="btn btn-primary">Proceed to
                                                        Checkout</a>
                                                </div>
                                                <% } %>
                            </div>
                        </body>

                        </html>