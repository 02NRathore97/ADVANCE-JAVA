<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>B_sendRedirector</title>
</head>
<body>
Hello..B
<% 
	request.setAttribute("DryFruit", "Almond");
response.sendRedirect("C_SendRedirector.jsp");
%>
</body>
</html>