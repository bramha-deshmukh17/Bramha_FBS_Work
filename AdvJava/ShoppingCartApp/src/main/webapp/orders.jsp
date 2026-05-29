<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="jakarta.tags.core" prefix="c" %>
        <%@ page import="com.bean.User" %>

            <% User loggedInUser=(User) session.getAttribute("user"); if (loggedInUser==null) {
                response.sendRedirect("login.jsp"); return; } %>

                <!DOCTYPE html>
                <html lang="en">

                <head>
                    <meta charset="UTF-8">
                    <title>My Orders</title>
                    <script src="https://cdn.tailwindcss.com"></script>
                </head>

                <body class="bg-gray-100 min-h-screen">
                    <nav class="bg-blue-600 text-white px-6 py-4 flex justify-between items-center shadow-md">
                        <h1 class="text-xl font-bold">My Orders</h1>
                        <div class="flex items-center gap-3">
                            <a href="${pageContext.request.contextPath}/products"
                                class="bg-white text-blue-600 px-4 py-2 rounded-lg font-semibold hover:bg-gray-100 transition">Shop</a>
                            <a href="${pageContext.request.contextPath}/cart"
                                class="bg-white text-blue-600 px-4 py-2 rounded-lg font-semibold hover:bg-gray-100 transition">Cart</a>
                        </div>
                    </nav>

                    <div class="max-w-5xl mx-auto mt-10 px-4">
                        <h2 class="text-2xl font-bold text-gray-800 mb-6">Your Orders</h2>

                        <div class="bg-white rounded-2xl shadow-md overflow-hidden">
                            <div class="overflow-x-auto">
                                <table class="min-w-full text-sm">
                                    <thead class="bg-gray-50 text-gray-700">
                                        <tr>
                                            <th class="text-left px-4 py-3 font-semibold">Order ID</th>
                                            <th class="text-left px-4 py-3 font-semibold">Total</th>
                                            <th class="text-left px-4 py-3 font-semibold">Date</th>
                                            <th class="text-left px-4 py-3 font-semibold">Status</th>
                                        </tr>
                                    </thead>
                                    <tbody class="divide-y">
                                        <c:forEach var="o" items="${orders}">
                                            <tr class="hover:bg-gray-50">
                                                <td class="px-4 py-3 text-gray-700">${o.id}</td>
                                                <td class="px-4 py-3 text-gray-700">₹ ${o.totalAmount}</td>
                                                <td class="px-4 py-3 text-gray-700">${o.orderDate}</td>
                                                <td class="px-4 py-3">
                                                    <div class="flex items-center gap-2 flex-wrap">
                                                        <c:choose>
                                                            <c:when
                                                                test="${o.status == 'Pending Payment' || o.status == 'Order Placed'}">
                                                                <span
                                                                    class="inline-flex items-center px-2 py-1 rounded-lg text-xs font-semibold bg-yellow-100 text-yellow-700">
                                                                    ⏳ ${o.status}
                                                                </span>
                                                                <a href="${pageContext.request.contextPath}/payment?orderId=${o.id}&amount=${o.totalAmount}"
                                                                    class="px-3 py-1 bg-green-600 text-white text-xs rounded-lg hover:bg-green-700 font-semibold transition">Complete
                                                                    Payment</a>
                                                            </c:when>
                                                            <c:when
                                                                test="${o.status == 'Shipped' || o.status == 'Out For Delivery'}">
                                                                <span
                                                                    class="inline-flex items-center px-2 py-1 rounded-lg text-xs font-semibold bg-blue-100 text-blue-700">
                                                                    📦 ${o.status}
                                                                </span>
                                                            </c:when>
                                                            <c:when test="${o.status == 'Delivered'}">
                                                                <span
                                                                    class="inline-flex items-center px-2 py-1 rounded-lg text-xs font-semibold bg-green-100 text-green-700">
                                                                    ✓ ${o.status}
                                                                </span>
                                                            </c:when>
                                                            <c:otherwise>
                                                                <span
                                                                    class="inline-flex items-center px-2 py-1 rounded-lg text-xs font-semibold bg-gray-100 text-gray-700">
                                                                    ${o.status}
                                                                </span>
                                                            </c:otherwise>
                                                        </c:choose>
                                                    </div>
                                                </td>
                                            </tr>
                                        </c:forEach>

                                        <c:if test="${empty orders}">
                                            <tr>
                                                <td colspan="4" class="px-4 py-6 text-center text-gray-500">You have no
                                                    orders yet.</td>
                                            </tr>
                                        </c:if>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </body>

                </html>