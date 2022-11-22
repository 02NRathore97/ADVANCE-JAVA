<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LOGIN VIEW</title>
<style>
	input{
		padding:8px;
	}
	.submit{
	padding:8px 73px;
	}
</style>
</head>
<body>
	<form method="get" action="LoginData.jsp">
		<table align="center">
		<h2 align="center">LOGIN</h2>
			   <tr>
			   	<th>Username*</th>
			   	<td><input type = "text" name = "pwd" value = "" placeholder = "Enter Username"></td>
			   </tr>
			   <tr>
			   	<th>Password*</th>
			   	<td><input type = "password" name = "pwd" value = "" placeholder = "Enter Password"></td>
			   </tr>
			   <tr>
			   	<th></th>
			   	<td><input type = "submit" name = "operation" value = "Login" class = "submit"></td>
			   </tr>
			   
			</table>
			<span align="center"><h5>Need an account? <a href = "RegistrationView.jsp" align="center">SIGN UP</a></h5></span>
	</form>
</body>
</html>