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
                    <title>Admin - Users</title>
                    <script src="https://cdn.tailwindcss.com"></script>
                </head>

                <body class="bg-gray-100 min-h-screen">
                    <nav class="bg-blue-600 text-white px-6 py-4 flex justify-between items-center shadow-md">
                        <h1 class="text-xl font-bold">Admin - Users</h1>
                        <a href="adminDashboard.jsp"
                            class="bg-white text-blue-600 px-4 py-2 rounded-lg font-semibold hover:bg-gray-100 transition">Dashboard</a>
                    </nav>

                    <div class="max-w-6xl mx-auto mt-10 px-4">
                        <h2 class="text-2xl font-bold text-gray-800 mb-6">Registered Users</h2>

                        <% if (msg !=null) { %>
                            <div class="mb-6 bg-white border rounded-xl p-4 text-sm text-gray-700">
                                <% if ("user_deleted".equals(msg)) { %>
                                    User deleted successfully.
                                    <% } else if ("user_delete_failed".equals(msg)) { %>
                                        Failed to delete user.
                                        <% } else if ("cannot_delete_self".equals(msg)) { %>
                                            You cannot delete your own admin account.
                                            <% } else if ("cannot_delete_admin".equals(msg)) { %>
                                                Admin users cannot be deleted from here.
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
                                                    <th class="text-left px-4 py-3 font-semibold">Name</th>
                                                    <th class="text-left px-4 py-3 font-semibold">Email</th>
                                                    <th class="text-left px-4 py-3 font-semibold">Role</th>
                                                    <th class="text-right px-4 py-3 font-semibold">Action</th>
                                                </tr>
                                            </thead>
                                            <tbody class="divide-y">
                                                <c:forEach var="u" items="${users}">
                                                    <tr class="hover:bg-gray-50">
                                                        <td class="px-4 py-3 text-gray-700">${u.id}</td>
                                                        <td class="px-4 py-3 text-gray-800 font-medium">${u.name}</td>
                                                        <td class="px-4 py-3 text-gray-700">${u.email}</td>
                                                        <td class="px-4 py-3">
                                                            <span
                                                                class="inline-flex items-center px-2 py-1 rounded-lg text-xs font-semibold bg-gray-100 text-gray-700">
                                                                ${u.role}
                                                            </span>
                                                        </td>
                                                        <td class="px-4 py-3 text-right">
                                                            <c:choose>
                                                                <c:when test="${u.id == sessionScope.user.id}">
                                                                    <span class="text-xs text-gray-500">Current</span>
                                                                </c:when>
                                                                <c:when test="${u.role == 'admin'}">
                                                                    <span class="text-xs text-gray-500">Protected</span>
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <form action="admin" method="post" class="inline">
                                                                        <input type="hidden" name="action"
                                                                            value="deleteUser">
                                                                        <input type="hidden" name="id" value="${u.id}">
                                                                        <button type="submit"
                                                                            class="bg-red-600 text-white px-3 py-2 rounded-lg font-semibold hover:bg-red-700 transition"
                                                                            onclick="return confirm('Delete this user?');">
                                                                            Delete
                                                                        </button>
                                                                    </form>
                                                                </c:otherwise>
                                                            </c:choose>
                                                        </td>
                                                    </tr>
                                                </c:forEach>

                                                <c:if test="${empty users}">
                                                    <tr>
                                                        <td colspan="5" class="px-4 py-6 text-center text-gray-500">No
                                                            users found.</td>
                                                    </tr>
                                                </c:if>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>

                    </div>
                </body>

                </html>