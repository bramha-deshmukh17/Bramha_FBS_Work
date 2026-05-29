<%@ page contentType="text/html; charset=UTF-8" %>
    <%@ page import="java.util.List" %>
        <%@ page import="com.bean.CartItem" %>
            <%@ page import="com.serviceimpl.CartServiceImpl" %>
                <%@ page import="com.services.CartService" %>
                    <% Integer userId=(Integer) session.getAttribute("userId"); if (userId==null) {
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
                            <title>Checkout</title>
                            <style>
                                body {
                                    font-family: Arial, sans-serif;
                                    background-color: #f4f4f4;
                                    margin: 0;
                                    padding: 20px;
                                }

                                .container {
                                    max-width: 700px;
                                    margin: 0 auto;
                                    background-color: white;
                                    padding: 30px;
                                    border-radius: 8px;
                                    box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
                                }

                                h1 {
                                    color: #333;
                                    text-align: center;
                                    border-bottom: 2px solid #28a745;
                                    padding-bottom: 15px;
                                }

                                .form-group {
                                    margin-bottom: 20px;
                                }

                                label {
                                    display: block;
                                    margin-bottom: 5px;
                                    font-weight: bold;
                                    color: #333;
                                }

                                input,
                                select,
                                textarea {
                                    width: 100%;
                                    padding: 10px;
                                    border: 1px solid #ddd;
                                    border-radius: 4px;
                                    box-sizing: border-box;
                                    font-size: 14px;
                                }

                                input:focus,
                                select:focus,
                                textarea:focus {
                                    outline: none;
                                    border-color: #28a745;
                                    background-color: #f0fff0;
                                }

                                .readonly {
                                    background-color: #f0f0f0;
                                    cursor: not-allowed;
                                }

                                .summary {
                                    background-color: #f9f9f9;
                                    padding: 15px;
                                    border-left: 4px solid #28a745;
                                    margin-bottom: 20px;
                                    border-radius: 4px;
                                }

                                .summary-row {
                                    display: flex;
                                    justify-content: space-between;
                                    margin-bottom: 8px;
                                }

                                .summary-total {
                                    font-size: 18px;
                                    font-weight: bold;
                                    color: #28a745;
                                    border-top: 1px solid #ddd;
                                    padding-top: 10px;
                                }

                                .form-row {
                                    display: grid;
                                    grid-template-columns: 1fr 1fr;
                                    gap: 15px;
                                }

                                .buttons {
                                    display: flex;
                                    gap: 10px;
                                    margin-top: 20px;
                                }

                                .btn {
                                    flex: 1;
                                    padding: 12px;
                                    border: none;
                                    border-radius: 4px;
                                    cursor: pointer;
                                    font-size: 16px;
                                    font-weight: bold;
                                }

                                .btn-primary {
                                    background-color: #28a745;
                                    color: white;
                                }

                                .btn-primary:hover {
                                    background-color: #218838;
                                }

                                .btn-secondary {
                                    background-color: #6c757d;
                                    color: white;
                                    text-decoration: none;
                                    display: flex;
                                    align-items: center;
                                    justify-content: center;
                                }

                                .btn-secondary:hover {
                                    background-color: #5a6268;
                                }

                                .message {
                                    padding: 10px;
                                    margin-bottom: 15px;
                                    border-radius: 4px;
                                }

                                .message.info {
                                    background-color: #d1ecf1;
                                    color: #0c5460;
                                    border: 1px solid #bee5eb;
                                }

                                .required {
                                    color: #dc3545;
                                }
                            </style>
                            <script>
                                function validateCheckout() {
                                    const address = document.getElementById("address").value.trim();
                                    const city = document.getElementById("city").value.trim();
                                    const state = document.getElementById("state").value.trim();
                                    const zip = document.getElementById("zip").value.trim();
                                    const phone = document.getElementById("phone").value.trim();

                                    if (!address || !city || !state || !zip || !phone) {
                                        alert("Please fill in all required fields");
                                        return false;
                                    }

                                    if (!/^\d{10}$/.test(phone)) {
                                        alert("Phone number must be 10 digits");
                                        return false;
                                    }

                                    if (!/^\d{6}$/.test(zip)) {
                                        alert("ZIP code must be 6 digits");
                                        return false;
                                    }

                                    return true;
                                }
                            </script>
                        </head>

                        <body>
                            <div class="container">
                                <h1>📦 Checkout</h1>

                                <% if (request.getParameter("message") !=null) { %>
                                    <div class="message info">
                                        <%= request.getParameter("message") %>
                                    </div>
                                    <% } %>

                                        <div class="summary">
                                            <div class="summary-row">
                                                <span>Items in Cart:</span>
                                                <strong>
                                                    <%= cartItems.size() %>
                                                </strong>
                                            </div>
                                            <div class="summary-row">
                                                <span>Subtotal:</span>
                                                <strong>Rs. <%= String.format("%.2f", totalPrice) %></strong>
                                            </div>
                                            <div class="summary-row">
                                                <span>Delivery Charges:</span>
                                                <strong>Rs. 50.00</strong>
                                            </div>
                                            <div class="summary-row summary-total">
                                                <span>Total Amount:</span>
                                                <strong>Rs. <%= String.format("%.2f", totalPrice + 50) %></strong>
                                            </div>
                                        </div>

                                        <form method="post" action="CheckoutServlet"
                                            onsubmit="return validateCheckout()">
                                            <input type="hidden" name="totalAmount" value="<%= totalPrice + 50 %>">
                                            <input type="hidden" name="subtotal" value="<%= totalPrice %>">

                                            <h2 style="color: #333; margin-top: 25px; margin-bottom: 15px;">Shipping
                                                Information</h2>

                                            <div class="form-group">
                                                <label for="address">Street Address <span
                                                        class="required">*</span></label>
                                                <textarea id="address" name="address" rows="3"
                                                    placeholder="Enter your full address" required></textarea>
                                            </div>

                                            <div class="form-row">
                                                <div class="form-group">
                                                    <label for="city">City <span class="required">*</span></label>
                                                    <input type="text" id="city" name="city" placeholder="City"
                                                        required>
                                                </div>
                                                <div class="form-group">
                                                    <label for="state">State/Province <span
                                                            class="required">*</span></label>
                                                    <input type="text" id="state" name="state" placeholder="State"
                                                        required>
                                                </div>
                                            </div>

                                            <div class="form-row">
                                                <div class="form-group">
                                                    <label for="zip">ZIP Code <span class="required">*</span></label>
                                                    <input type="text" id="zip" name="zip"
                                                        placeholder="ZIP Code (6 digits)" maxlength="6" required>
                                                </div>
                                                <div class="form-group">
                                                    <label for="phone">Phone Number <span
                                                            class="required">*</span></label>
                                                    <input type="text" id="phone" name="phone"
                                                        placeholder="Phone (10 digits)" maxlength="10" required>
                                                </div>
                                            </div>

                                            <h2 style="color: #333; margin-top: 25px; margin-bottom: 15px;">Delivery
                                                Option</h2>
                                            <div class="form-group">
                                                <label for="delivery">Delivery Type</label>
                                                <select id="delivery" name="deliveryType">
                                                    <option value="Standard">Standard Delivery (5-7 days) - Rs. 50
                                                    </option>
                                                    <option value="Express">Express Delivery (2-3 days) - Rs. 200
                                                    </option>
                                                    <option value="Overnight">Overnight Delivery - Rs. 500</option>
                                                </select>
                                            </div>

                                            <div class="buttons">
                                                <a href="cart.jsp" class="btn btn-secondary">← Back to Cart</a>
                                                <button type="submit" class="btn btn-primary">Proceed to Payment
                                                    →</button>
                                            </div>
                                        </form>
                            </div>
                        </body>

                        </html>