<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>A_sendRedirector</title>
</head>
<body>
Hello...A
<% 
	request.setAttribute("Fruit", "Apple");
response.sendRedirect("B_SendRedirector.jsp");
%>
</body>
</html>