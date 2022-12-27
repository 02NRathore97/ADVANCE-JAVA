<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student</title>
</head>
<body>
<center>
<form action = "StudentCtl.jsp" method = "get">
<h3>Student Form</h3>
	<table>
		<tr>
			<th>Id*</th>
			<td><input type = "text" name = "id"  ></td>
		</tr>
		<tr>
			<th>FirstName*</th>
			<td><input type = "text" name = "fname"  ></td>
		</tr>
		<tr>
			<th>LastName*</th>
			<td><input type = "text" name = "lname"  ></td>
		</tr>
			<tr>
			<th></th>
			<td><input type = "submit" name = "submit" value = "submit" ></td>
		</tr>
	</table>
</form>
</center>
</body>
</html>