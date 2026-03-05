<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Signup Page</title>

<!-- External CSS -->
<link rel="stylesheet" href="style.css">

<!-- External JS -->
<script src="script.js" defer></script>

</head>

<body>

    <div class="signup-box">
        <h2>Signup</h2>

        <form onsubmit="return validateForm()">

            <label>Username</label>
            <input type="text" id="username" placeholder="Enter username" required>

            <label>Password</label>
            <input type="password" id="password" placeholder="Enter password" required>

            <label>Security Question</label>
            <select id="securityQuestion" required>
                <option value="">-- Select Question --</option>
                <option>What is your pet's name?</option>
                <option>What is your favorite teacher's name?</option>
                <option>What is your birth city?</option>
                <option>What is your favorite food?</option>
            </select>

            <label>Security Answer</label>
            <input type="text" id="answer" placeholder="Enter answer" required>

            <button type="submit">Submit</button>

        </form>
    </div>

</body>
</html>
   