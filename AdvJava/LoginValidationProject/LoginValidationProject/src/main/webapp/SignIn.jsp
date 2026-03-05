<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>

<!-- External CSS -->
<link rel="stylesheet" href="login.css">

<!-- External JS -->
<script src="login.js" defer></script>

</head>

<body>

    <div class="login-box">
        <h2>Login</h2>

        <form action="LoginController" method="post" onsubmit="return validateLogin()">

            <label>Username</label>
            <input type="text" id="username" name="username" placeholder="Enter username" required>

            <label>Password</label>
            <input type="password" id="password" name="password" placeholder="Enter password" required>

            <button type="submit">Login</button>

        </form>
    </div>

</body>
</html>

    