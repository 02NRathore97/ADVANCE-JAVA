<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>A</title>
</head>
<body>
hello....A.

	<% 
	request.setAttribute("Fruit", "Apple");
%> 
<jsp:forward page="B.jsp"></jsp:forward>
</body>
</html>