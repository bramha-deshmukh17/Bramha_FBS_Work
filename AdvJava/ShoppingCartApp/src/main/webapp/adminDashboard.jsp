<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ page import="com.bean.User" %>
        <% User loggedInUser=(User) session.getAttribute("user"); if (loggedInUser==null || loggedInUser.getRole()==null
            || !"admin".equals(loggedInUser.getRole())) { response.sendRedirect("login.jsp"); return; } %>
            <!DOCTYPE html>
            <html lang="en">

            <head>
                <meta charset="UTF-8">
                <title>Admin Dashboard</title>

                <!-- Tailwind CDN -->
                <script src="https://cdn.tailwindcss.com"></script>
            </head>

            <body class="bg-gray-100 min-h-screen">

                <!-- Top Navbar -->
                <nav class="bg-blue-600 text-white px-6 py-4 flex justify-between items-center shadow-md">
                    <h1 class="text-xl font-bold">Admin Dashboard</h1>

                    <a href="logout"
                        class="bg-white text-blue-600 px-4 py-2 rounded-lg font-semibold hover:bg-gray-100 transition">
                        Logout
                    </a>
                </nav>

                <!-- Main Content -->
                <div class="max-w-5xl mx-auto mt-10 px-4">

                    <h2 class="text-2xl font-bold text-gray-800 mb-6">
                        Welcome, Admin 👋
                    </h2>

                    <!-- Dashboard Cards -->
                    <div class="grid grid-cols-1 md:grid-cols-3 gap-6">

                        <!-- View Users -->
                        <a href="admin?action=users"
                            class="bg-white p-6 rounded-2xl shadow-md hover:shadow-lg transition border">
                            <h3 class="text-lg font-semibold text-gray-700 mb-2">View Users</h3>
                            <p class="text-sm text-gray-500">See all registered users in the system.</p>
                        </a>

                        <!-- View Orders -->
                        <a href="admin?action=orders"
                            class="bg-white p-6 rounded-2xl shadow-md hover:shadow-lg transition border">
                            <h3 class="text-lg font-semibold text-gray-700 mb-2">View Orders</h3>
                            <p class="text-sm text-gray-500">Check customer orders and status.</p>
                        </a>

                        <!-- Manage Products -->
                        <a href="admin?action=products"
                            class="bg-white p-6 rounded-2xl shadow-md hover:shadow-lg transition border">
                            <h3 class="text-lg font-semibold text-gray-700 mb-2">Manage Products</h3>
                            <p class="text-sm text-gray-500">Add, edit, or remove products.</p>
                        </a>


                    </div>
                </div>

            </body>

            </html>