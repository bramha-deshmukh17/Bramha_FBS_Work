<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User registration page</title>
</head>
<body>
	<form action="registration" method="post">
		Email Id : <input type="email" name="mail" required="required"/><br></br>
		Username : <input type="text" name="user" required="required"><br></br>
		Password : <input type="password" name="pass" required="required"><br></br>
		<button type="submit">register</button>
	</form>
	<a href="login.jsp">Already have account ? Login</a>
</body>
</html>