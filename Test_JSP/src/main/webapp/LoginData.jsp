<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LOGIN DATA</title>
</head>
<body>
<%
String user = request.getParameter("user");
String pwd = request.getParameter("pwd");
%>


<%= user %><br>
<%= pwd %>
</body>
</html>