<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="jakarta.tags.core" prefix="c" %>
        <%@ page import="java.util.List" %>
            <%@ page import="com.bean.Product" %>

                <!DOCTYPE html>
                <html lang="en">

                <head>
                    <meta charset="UTF-8">
                    <title>Products</title>

                    <!-- Tailwind CDN -->
                    <script src="https://cdn.tailwindcss.com"></script>
                </head>

                <body class="bg-gray-100 min-h-screen">

                    <!-- Navbar -->
                    <nav class="bg-blue-600 text-white px-6 py-4 flex justify-between items-center shadow-md">
                        <h1 class="text-xl font-bold">Shop Products 🛍</h1>

                        <div class="flex items-center gap-3">
                            <a href="${pageContext.request.contextPath}/orders"
                                class="bg-white text-blue-600 px-4 py-2 rounded-lg font-semibold hover:bg-gray-100 transition">
                                My Orders
                            </a>
                            <a href="${pageContext.request.contextPath}/cart"
                                class="bg-white text-blue-600 px-4 py-2 rounded-lg font-semibold hover:bg-gray-100 transition">
                                View Cart
                            </a>
                            <form action="${pageContext.request.contextPath}/logout" method="post" class="m-0">
                                <button type="submit" class="bg-red-600 text-white px-4 py-2 rounded-lg font-semibold hover:bg-red-700 transition">
                                    Logout
                                </button>
                            </form>
                        </div>
                    </nav>

                    <!-- Container -->
                    <div class="max-w-7xl mx-auto px-4 py-8">

                        <h2 class="text-2xl font-bold text-gray-800 mb-6">
                            Available Products
                        </h2>

                        <!-- Empty State -->
                        <c:if test="${empty products}">
                            <p class="text-center text-gray-600 text-lg py-10">
                                No products available right now.
                            </p>
                        </c:if>

                        <!-- Product Grid -->
                        <div class="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-4 gap-6">

                            <c:forEach var="product" items="${products}">
                                <div
                                    class="bg-white rounded-2xl shadow-md hover:shadow-lg transition p-4 flex flex-col">

                                    <!-- Image -->
                                    <img src="${product.imageUrl}" alt="${product.name}"
                                        class="h-40 w-full object-cover rounded-lg mb-4">

                                    <!-- Details -->
                                    <h3 class="text-lg font-semibold text-gray-800">${product.name}</h3>
                                    <p class="text-sm text-gray-500 mt-1 line-clamp-2">
                                        ${product.description}
                                    </p>

                                    <div class="mt-2 text-sm text-gray-600">
                                        Category: <span class="font-medium">${product.category}</span>
                                    </div>

                                    <!-- Price -->
                                    <div class="mt-3 text-xl font-bold text-green-600">
                                        ₹ ${product.price}
                                    </div>

                                    <!-- Add to Cart / Buy Now -->
                                    <form action="${pageContext.request.contextPath}/cart" method="post" class="mt-4">
                                        <input type="hidden" name="productId" value="${product.id}">

                                        <div class="flex items-center gap-3">
                                            <label class="text-sm text-gray-700">Qty</label>
                                            <input type="number" name="quantity" value="1" min="1"
                                                class="w-20 border rounded-lg px-3 py-2 text-sm" />
                                        </div>

                                        <div class="mt-3 grid grid-cols-2 gap-2">
                                            <button type="submit" name="action" value="add"
                                                class="w-full bg-blue-600 text-white py-2 rounded-lg hover:bg-blue-700 transition font-semibold">
                                                Add to Cart
                                            </button>

                                            <button type="submit" name="action" value="buyNow"
                                                class="w-full bg-green-600 text-white py-2 rounded-lg hover:bg-green-700 transition font-semibold">
                                                Buy Now
                                            </button>
                                        </div>
                                    </form>

                                </div>
                            </c:forEach>

                        </div>

                    </div>

                </body>

                </html>