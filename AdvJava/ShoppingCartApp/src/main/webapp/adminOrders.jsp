<%@ page contentType="text/html; charset=UTF-8" %>
    <%@ page import="java.util.List" %>
        <%@ page import="com.bean.Order" %>
            <%@ page import="com.bean.User" %>
                <%@ page import="com.serviceimpl.OrderServiceImpl" %>
                    <%@ page import="com.services.OrderService" %>
                        <% User loggedInUser=(User) session.getAttribute("user"); if (loggedInUser==null ||
                            loggedInUser.getRole()==null || !"admin".equals(loggedInUser.getRole())) {
                            response.sendRedirect("login.jsp"); return; } OrderService orderService=new
                            OrderServiceImpl(); List<Order> orders = orderService.getAllOrders();
                            %>
                            <!DOCTYPE html>
                            <html>

                            <head>
                                <meta charset="UTF-8">
                                <title>Admin - Orders Management</title>
                                <style>
                                    body {
                                        font-family: Arial, sans-serif;
                                        background-color: #f4f4f4;
                                        margin: 0;
                                        padding: 0;
                                    }

                                    .navbar {
                                        background-color: #1f456e;
                                        color: white;
                                        padding: 15px 30px;
                                        display: flex;
                                        justify-content: space-between;
                                        align-items: center;
                                        box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
                                    }

                                    .navbar h1 {
                                        margin: 0;
                                        font-size: 24px;
                                    }

                                    .navbar a {
                                        background-color: #28a745;
                                        color: white;
                                        padding: 8px 16px;
                                        border-radius: 4px;
                                        text-decoration: none;
                                        font-weight: bold;
                                    }

                                    .navbar a:hover {
                                        background-color: #218838;
                                    }

                                    .container {
                                        max-width: 1200px;
                                        margin: 20px auto;
                                        background-color: white;
                                        padding: 20px;
                                        border-radius: 8px;
                                        box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
                                    }

                                    h2 {
                                        color: #333;
                                        margin-top: 0;
                                    }

                                    .message {
                                        padding: 15px;
                                        margin-bottom: 20px;
                                        border-radius: 4px;
                                    }

                                    .message.success {
                                        background-color: #d4edda;
                                        color: #155724;
                                        border: 1px solid #c3e6cb;
                                    }

                                    .table-wrapper {
                                        overflow-x: auto;
                                    }

                                    table {
                                        width: 100%;
                                        border-collapse: collapse;
                                        margin-top: 20px;
                                    }

                                    th {
                                        background-color: #1f456e;
                                        color: white;
                                        padding: 12px;
                                        text-align: left;
                                        font-weight: bold;
                                    }

                                    td {
                                        padding: 12px;
                                        border-bottom: 1px solid #ddd;
                                    }

                                    tr:hover {
                                        background-color: #f9f9f9;
                                    }

                                    .status-pending {
                                        background-color: #fff3cd;
                                        color: #856404;
                                        padding: 5px 10px;
                                        border-radius: 3px;
                                        font-weight: bold;
                                        font-size: 12px;
                                    }

                                    .status-shipped {
                                        background-color: #d1ecf1;
                                        color: #0c5460;
                                        padding: 5px 10px;
                                        border-radius: 3px;
                                        font-weight: bold;
                                        font-size: 12px;
                                    }

                                    .status-delivery {
                                        background-color: #cce5ff;
                                        color: #004085;
                                        padding: 5px 10px;
                                        border-radius: 3px;
                                        font-weight: bold;
                                        font-size: 12px;
                                    }

                                    .status-delivered {
                                        background-color: #d4edda;
                                        color: #155724;
                                        padding: 5px 10px;
                                        border-radius: 3px;
                                        font-weight: bold;
                                        font-size: 12px;
                                    }

                                    .action-btn {
                                        background-color: #007bff;
                                        color: white;
                                        border: none;
                                        padding: 6px 12px;
                                        border-radius: 4px;
                                        cursor: pointer;
                                        font-size: 12px;
                                        font-weight: bold;
                                        margin-right: 5px;
                                    }

                                    .action-btn:hover {
                                        background-color: #0056b3;
                                    }

                                    .action-btn.disabled {
                                        background-color: #ccc;
                                        cursor: not-allowed;
                                    }

                                    .no-data {
                                        text-align: center;
                                        padding: 40px;
                                        color: #999;
                                    }

                                    .update-form {
                                        display: flex;
                                        gap: 5px;
                                        align-items: center;
                                    }

                                    .update-form input {
                                        display: none;
                                    }

                                    .tracking-input {
                                        width: 120px;
                                        padding: 5px;
                                        font-size: 12px;
                                    }
                                </style>
                                <script>
                                    function updateDeliveryInfo(orderId) {
                                        const tracking = prompt("Enter Tracking Number (optional):");
                                        if (tracking !== null) {
                                            const form = document.getElementById("form_" + orderId);
                                            form.trackingNumber.value = tracking;
                                            form.submit();
                                        }
                                    }
                                </script>
                            </head>

                            <body>
                                <div class="navbar">
                                    <h1>📦 Admin - Orders Management</h1>
                                    <a href="adminDashboard.jsp">← Back to Dashboard</a>
                                </div>

                                <div class="container">
                                    <h2>All Customer Orders</h2>

                                    <% if (request.getParameter("message") !=null) { %>
                                        <div class="message success">
                                            <%= request.getParameter("message") %>
                                        </div>
                                        <% } %>

                                            <% if (orders==null || orders.isEmpty()) { %>
                                                <div class="no-data">
                                                    <p>No orders found in the system.</p>
                                                </div>
                                                <% } else { %>
                                                    <div class="table-wrapper">
                                                        <table>
                                                            <thead>
                                                                <tr>
                                                                    <th>Order ID</th>
                                                                    <th>User ID</th>
                                                                    <th>Total Amount</th>
                                                                    <th>Order Date</th>
                                                                    <th>Status</th>
                                                                    <th>Tracking Number</th>
                                                                    <th>Actions</th>
                                                                </tr>
                                                            </thead>
                                                            <tbody>
                                                                <% for (Order order : orders) { %>
                                                                    <tr>
                                                                        <td><strong>#<%= order.getId() %></strong></td>
                                                                        <td>
                                                                            <%= order.getUserId() %>
                                                                        </td>
                                                                        <td>Rs. <%= String.format("%.2f",
                                                                                order.getTotalAmount()) %>
                                                                        </td>
                                                                        <td>
                                                                            <%= new
                                                                                java.text.SimpleDateFormat("dd-MMM-yyyy
                                                                                HH:mm").format(order.getOrderDate()) %>
                                                                        </td>
                                                                        <td>
                                                                            <% String status=order.getStatus(); String
                                                                                statusClass="status-pending" ; if
                                                                                ("Shipped".equalsIgnoreCase(status))
                                                                                statusClass="status-shipped" ; else if
                                                                                ("Out For
                                                                                Delivery".equalsIgnoreCase(status))
                                                                                statusClass="status-delivery" ; else if
                                                                                ("Delivered".equalsIgnoreCase(status))
                                                                                statusClass="status-delivered" ; %>
                                                                                <span class="<%= statusClass %>">
                                                                                    <%= status %>
                                                                                </span>
                                                                        </td>
                                                                        <td>
                                                                            <%= order.getTrackingNumber() !=null ?
                                                                                order.getTrackingNumber() : "Not Set" %>
                                                                        </td>
                                                                        <td>
                                                                            <form id="form_<%= order.getId() %>"
                                                                                method="post" action="AdminServlet"
                                                                                style="display: inline;">
                                                                                <input type="hidden" name="action"
                                                                                    value="updateOrderStatus">
                                                                                <input type="hidden" name="orderId"
                                                                                    value="<%= order.getId() %>">
                                                                                <input type="hidden"
                                                                                    name="trackingNumber" value="">

                                                                                <% String nextStatus="" ; boolean
                                                                                    canUpdate=false; if ("Order
                                                                                    Placed".equalsIgnoreCase(status)) {
                                                                                    nextStatus="Shipped" ;
                                                                                    canUpdate=true; } else if
                                                                                    ("Shipped".equalsIgnoreCase(status))
                                                                                    { nextStatus="Out For Delivery" ;
                                                                                    canUpdate=true; } else if ("Out For
                                                                                    Delivery".equalsIgnoreCase(status))
                                                                                    { nextStatus="Delivered" ;
                                                                                    canUpdate=true; } %>

                                                                                    <% if (canUpdate) { %>
                                                                                        <input type="hidden"
                                                                                            name="newStatus"
                                                                                            value="<%= nextStatus %>">
                                                                                        <button type="submit"
                                                                                            class="action-btn">Mark <%=
                                                                                                nextStatus %></button>
                                                                                        <button type="button"
                                                                                            class="action-btn"
                                                                                            onclick="updateDeliveryInfo(<%= order.getId() %>)">Set
                                                                                            Tracking</button>
                                                                                        <% } else { %>
                                                                                            <button type="button"
                                                                                                class="action-btn disabled"
                                                                                                disabled>No
                                                                                                Action</button>
                                                                                            <% } %>
                                                                            </form>
                                                                        </td>
                                                                    </tr>
                                                                    <% } %>
                                                            </tbody>
                                                        </table>
                                                    </div>
                                                    <% } %>
                                </div>
                            </body>

                            </html>