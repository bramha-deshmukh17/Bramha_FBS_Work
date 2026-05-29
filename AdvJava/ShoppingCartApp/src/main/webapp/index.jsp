<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Online Shopping Cart</title>

    <!-- Tailwind CDN -->
    <script src="https://cdn.tailwindcss.com"></script>
</head>

<body class="bg-gradient-to-br from-blue-500 to-indigo-600 min-h-screen flex items-center justify-center">

    <!-- Main Card -->
    <div class="bg-white shadow-2xl rounded-3xl p-10 text-center max-w-md w-full">

        <h1 class="text-3xl font-bold text-gray-800 mb-4">
            Online Shopping Cart
        </h1>

        <p class="text-gray-600 mb-8">
            Welcome! Shop your favorite products easily and securely.
        </p>

        <!-- Buttons -->
        <div class="flex flex-col gap-4">

            <a href="login.jsp"
                class="bg-blue-600 text-white py-2 rounded-xl font-semibold hover:bg-blue-700 transition">
                Login
            </a>

            <a href="register.jsp"
                class="bg-gray-200 text-gray-800 py-2 rounded-xl font-semibold hover:bg-gray-300 transition">
                Register
            </a>

        </div>

    </div>

</body>
</html>
