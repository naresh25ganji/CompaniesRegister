<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
<link rel="stylesheet" href="css/login.css" type="text/css"></link>
</head>
<body>
	<div id="login-box-container">
		<form method="POST" action='LoginController' name="authentication"
			class="login-box">
			<h1 class="heading">Companies Register</h1>
			<h1 class="login">Login</h1>
			<div class="inputBox">
				<input type="text" name="username" placeholder="Username"> <span
					class="bar"></span>
			</div>
			<div class="inputBox">
				<input type="password" name="password" placeholder="Password">
				<span class="bar"></span>
			</div>
			<button id="login_button" class="btn_login">LOG IN</button>
		</form>
	</div>
</body>
</html>