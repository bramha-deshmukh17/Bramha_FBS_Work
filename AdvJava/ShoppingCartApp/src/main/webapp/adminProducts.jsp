<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="jakarta.tags.core" prefix="c" %>
        <%@ page import="com.bean.User" %>

            <% User loggedInUser=(User) session.getAttribute("user"); if (loggedInUser==null ||
                loggedInUser.getRole()==null || !"admin".equals(loggedInUser.getRole())) {
                response.sendRedirect("login.jsp"); return; } String msg=request.getParameter("msg"); %>

                <!DOCTYPE html>
                <html lang="en">

                <head>
                    <meta charset="UTF-8">
                    <title>Admin - Products</title>
                    <script src="https://cdn.tailwindcss.com"></script>
                </head>

                <body class="bg-gray-100 min-h-screen">
                    <nav class="bg-blue-600 text-white px-6 py-4 flex justify-between items-center shadow-md">
                        <h1 class="text-xl font-bold">Admin - Products</h1>
                        <div class="flex gap-3">
                            <a href="admin?action=newProduct"
                                class="bg-white text-blue-600 px-4 py-2 rounded-lg font-semibold hover:bg-gray-100 transition">Add
                                Product</a>
                            <a href="adminDashboard.jsp"
                                class="bg-white text-blue-600 px-4 py-2 rounded-lg font-semibold hover:bg-gray-100 transition">Dashboard</a>
                        </div>
                    </nav>

                    <div class="max-w-7xl mx-auto mt-10 px-4">
                        <h2 class="text-2xl font-bold text-gray-800 mb-6">Manage Products</h2>

                        <% if (msg !=null) { %>
                            <div class="mb-6 bg-white border rounded-xl p-4 text-sm text-gray-700">
                                <% if ("product_added".equals(msg)) { %>
                                    Product added.
                                    <% } else if ("product_updated".equals(msg)) { %>
                                        Product updated.
                                        <% } else if ("product_deleted".equals(msg)) { %>
                                            Product deleted.
                                            <% } else if ("product_add_failed".equals(msg) || "product_update_failed"
                                                .equals(msg) || "product_delete_failed" .equals(msg)) { %>
                                                Action failed.
                                                <% } else { %>
                                                    <%= msg %>
                                                        <% } %>
                            </div>
                            <% } %>

                                <div class="bg-white rounded-2xl shadow-md overflow-hidden">
                                    <div class="overflow-x-auto">
                                        <table class="min-w-full text-sm">
                                            <thead class="bg-gray-50 text-gray-700">
                                                <tr>
                                                    <th class="text-left px-4 py-3 font-semibold">ID</th>
                                                    <th class="text-left px-4 py-3 font-semibold">Image</th>
                                                    <th class="text-left px-4 py-3 font-semibold">Name</th>
                                                    <th class="text-left px-4 py-3 font-semibold">Category</th>
                                                    <th class="text-left px-4 py-3 font-semibold">Price</th>
                                                    <th class="text-left px-4 py-3 font-semibold">Qty</th>
                                                    <th class="text-right px-4 py-3 font-semibold">Actions</th>
                                                </tr>
                                            </thead>
                                            <tbody class="divide-y">
                                                <c:forEach var="p" items="${products}">
                                                    <tr class="hover:bg-gray-50">
                                                        <td class="px-4 py-3 text-gray-700">${p.id}</td>
                                                        <td class="px-4 py-3">
                                                            <img src="${p.imageUrl}" alt="${p.name}"
                                                                class="h-12 w-12 object-cover rounded-lg border"
                                                                onerror="this.style.display='none'" />
                                                        </td>
                                                        <td class="px-4 py-3 text-gray-800 font-medium">${p.name}</td>
                                                        <td class="px-4 py-3 text-gray-700">${p.category}</td>
                                                        <td class="px-4 py-3 text-gray-700">₹ ${p.price}</td>
                                                        <td class="px-4 py-3 text-gray-700">${p.quantity}</td>
                                                        <td class="px-4 py-3 text-right whitespace-nowrap">
                                                            <a href="admin?action=editProduct&id=${p.id}"
                                                                class="inline-block bg-blue-600 text-white px-3 py-2 rounded-lg font-semibold hover:bg-blue-700 transition">
                                                                Edit
                                                            </a>
                                                            <form action="admin" method="post" class="inline">
                                                                <input type="hidden" name="action"
                                                                    value="deleteProduct">
                                                                <input type="hidden" name="id" value="${p.id}">
                                                                <button type="submit"
                                                                    class="bg-red-600 text-white px-3 py-2 rounded-lg font-semibold hover:bg-red-700 transition"
                                                                    onclick="return confirm('Delete this product?');">
                                                                    Delete
                                                                </button>
                                                            </form>
                                                        </td>
                                                    </tr>
                                                </c:forEach>

                                                <c:if test="${empty products}">
                                                    <tr>
                                                        <td colspan="7" class="px-4 py-6 text-center text-gray-500">No
                                                            products found.</td>
                                                    </tr>
                                                </c:if>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                    </div>

                </body>

                </html>