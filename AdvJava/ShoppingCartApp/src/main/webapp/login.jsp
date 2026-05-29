<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="jakarta.tags.core" prefix="c" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <title>Login</title>

            <!-- Tailwind CDN -->
            <script src="https://cdn.tailwindcss.com"></script>

            <!-- JS Validation -->
            <script>
                function validateLogin() {
                    const email = document.forms["loginForm"]["email"].value.trim();
                    const password = document.forms["loginForm"]["password"].value.trim();
                    const errorBox = document.getElementById("jsError");

                    let errors = [];

                    const emailPattern = /^[^ ]+@[^ ]+\.[a-z]{2,3}$/;
                    if (!email.match(emailPattern)) {
                        errors.push("Enter a valid email address.");
                    }

                    if (password.length < 6) {
                        errors.push("Password must be at least 6 characters.");
                    }

                    if (errors.length > 0) {
                        errorBox.innerHTML = errors.join("<br>");
                        errorBox.classList.remove("hidden");
                        return false;
                    }

                    return true;
                }
            </script>
        </head>

        <body class="bg-gray-100 flex items-center justify-center min-h-screen">

            <div class="bg-white shadow-lg rounded-2xl p-8 w-full max-w-md">

                <h2 class="text-2xl font-bold text-center text-gray-800 mb-6">
                    Welcome Back
                </h2>

                <!-- JS Error Box -->
                <div id="jsError"
                    class="hidden mb-4 p-3 text-sm text-red-700 bg-red-100 border border-red-300 rounded-lg">
                </div>

                <!-- Server Error Message -->
                <c:if test="${not empty error}">
                    <div class="mb-4 p-3 text-sm text-red-700 bg-red-100 border border-red-300 rounded-lg">
                        ${error}
                    </div>
                </c:if>

                <!-- Success Message -->
                <c:if test="${not empty success}">
                    <div class="mb-4 p-3 text-sm text-green-700 bg-green-100 border border-green-300 rounded-lg">
                        ${success}
                    </div>
                </c:if>

                <form name="loginForm" action="login" method="post" onsubmit="return validateLogin()" class="space-y-4">

                    <div>
                        <label class="block text-sm font-medium text-gray-600">Email</label>
                        <input type="email" name="email" required
                            class="w-full mt-1 px-4 py-2 border rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500">
                    </div>

                    <div>
                        <label class="block text-sm font-medium text-gray-600">Password</label>
                        <input type="password" name="password" required
                            class="w-full mt-1 px-4 py-2 border rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500">
                    </div>

                    <button type="submit"
                        class="w-full bg-blue-600 text-white py-2 rounded-lg hover:bg-blue-700 transition duration-200 font-semibold">
                        Login
                    </button>
                </form>

                <p class="text-center text-sm text-gray-600 mt-4">
                    Don’t have an account?
                    <a href="register.jsp" class="text-blue-600 hover:underline font-medium">Register</a>
                </p>

            </div>

        </body>

        </html>