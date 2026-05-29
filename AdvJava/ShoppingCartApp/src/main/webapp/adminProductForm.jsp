<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ page import="com.bean.User" %>
        <%@ page import="com.bean.Product" %>
            <% User loggedInUser=(User) session.getAttribute("user"); if (loggedInUser==null ||
                loggedInUser.getRole()==null || !"admin".equals(loggedInUser.getRole())) {
                response.sendRedirect("login.jsp"); return; } String mode=(String) request.getAttribute("mode"); if
                (mode==null) mode="add" ; Product product=(Product) request.getAttribute("product"); boolean
                isEdit=(product !=null && product.getId()> 0) || "edit".equalsIgnoreCase(mode);

                String msg = request.getParameter("msg");
                %>
                <!DOCTYPE html>
                <html lang="en">

                <head>
                    <meta charset="UTF-8">
                    <title>
                        <%= isEdit ? "Edit Product" : "Add Product" %>
                    </title>
                    <script src="https://cdn.tailwindcss.com"></script>
                </head>

                <body class="bg-gray-100 min-h-screen">

                    <nav class="bg-blue-600 text-white px-6 py-4 flex justify-between items-center shadow-md">
                        <h1 class="text-xl font-bold">
                            <%= isEdit ? "Admin - Edit Product" : "Admin - Add Product" %>
                        </h1>
                        <a href="admin?action=products"
                            class="bg-white text-blue-600 px-4 py-2 rounded-lg font-semibold hover:bg-gray-100 transition">Back</a>
                    </nav>

                    <div class="max-w-3xl mx-auto mt-10 px-4">

                        <% if (msg !=null) { %>
                            <div class="mb-6 bg-white border rounded-xl p-4 text-sm text-gray-700">
                                <% if ("invalid_input".equals(msg)) { %>
                                    Please fill all fields with valid values.
                                    <% } else { %>
                                        <%= msg %>
                                            <% } %>
                            </div>
                            <% } %>

                                <div class="bg-white rounded-2xl shadow-md p-6">
                                    <form action="admin" method="post" enctype="multipart/form-data" class="space-y-4">
                                        <input type="hidden" name="action" value="<%= isEdit ? "updateProduct"
                                            : "addProduct" %>">
                                        <% if (isEdit && product !=null) { %>
                                            <input type="hidden" name="id" value="<%= product.getId() %>">
                                            <% } %>

                                                <div>
                                                    <label
                                                        class="block text-sm font-semibold text-gray-700 mb-1">Name</label>
                                                    <input type="text" name="name" required
                                                        value="<%= (product != null && product.getName()!=null) ? product.getName() : "" %>"
                                                        class="w-full border rounded-lg px-3 py-2 focus:outline-none focus:ring-2 focus:ring-blue-400">
                                                </div>

                                                <div>
                                                    <label
                                                        class="block text-sm font-semibold text-gray-700 mb-1">Description</label>
                                                    <textarea name="description" required rows="4"
                                                        class="w-full border rounded-lg px-3 py-2 focus:outline-none focus:ring-2 focus:ring-blue-400"><%= (product != null && product.getDescription()!=null) ? product.getDescription() : "" %></textarea>
                                                </div>

                                                <div class="grid grid-cols-1 md:grid-cols-2 gap-4">
                                                    <div>
                                                        <label
                                                            class="block text-sm font-semibold text-gray-700 mb-1">Category</label>
                                                        <input type="text" name="category" required
                                                            value="<%= (product != null && product.getCategory()!=null) ? product.getCategory() : "" %>"
                                                            class="w-full border rounded-lg px-3 py-2 focus:outline-none focus:ring-2 focus:ring-blue-400">
                                                    </div>

                                                    <div>
                                                        <label
                                                            class="block text-sm font-semibold text-gray-700 mb-1">Quantity</label>
                                                        <input type="number" name="quantity" min="0" required
                                                            value="<%= (product != null) ? product.getQuantity() : 0 %>"
                                                            class="w-full border rounded-lg px-3 py-2 focus:outline-none focus:ring-2 focus:ring-blue-400">
                                                    </div>
                                                </div>

                                                <div>
                                                    <label
                                                        class="block text-sm font-semibold text-gray-700 mb-1">Price</label>
                                                    <input type="number" name="price" min="0" step="0.01" required
                                                        value="<%= (product != null) ? product.getPrice() : 0 %>"
                                                        class="w-full border rounded-lg px-3 py-2 focus:outline-none focus:ring-2 focus:ring-blue-400">
                                                </div>

                                                <% if (isEdit && product !=null && product.getImageUrl() !=null) { %>
                                                    <div>
                                                        <label
                                                            class="block text-sm font-semibold text-gray-700 mb-2">Current
                                                            Image</label>
                                                        <img src="<%= product.getImageUrl() %>" alt="Product image"
                                                            class="h-32 w-32 object-cover rounded-lg border">
                                                    </div>
                                                    <% } %>

                                                        <div>
                                                            <label
                                                                class="block text-sm font-semibold text-gray-700 mb-1">
                                                                <%= isEdit ? "Replace Image (optional)" : "Image" %>
                                                            </label>
                                                            <input type="file" name="image"
                                                                accept="image/png,image/jpeg,image/gif,image/webp"
                                                                class="w-full border rounded-lg px-3 py-2 bg-white">
                                                            <p class="text-xs text-gray-500 mt-1">Allowed: PNG, JPG,
                                                                GIF, WEBP (max 10MB)</p>
                                                        </div>

                                                        <div class="flex gap-3 pt-2">
                                                            <button type="submit"
                                                                class="bg-blue-600 text-white px-5 py-2 rounded-lg font-semibold hover:bg-blue-700 transition">
                                                                <%= isEdit ? "Update Product" : "Add Product" %>
                                                            </button>
                                                            <a href="admin?action=products"
                                                                class="bg-gray-200 text-gray-800 px-5 py-2 rounded-lg font-semibold hover:bg-gray-300 transition">Cancel</a>
                                                        </div>

                                    </form>
                                </div>

                    </div>

                </body>

                </html>