<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Data</title>
</head>
<body>
<%
String fname = request.getParameter("fname");
String lname = request.getParameter("lname");
String gender = request.getParameter("gender");
String phone = request.getParameter("phone");
String address = request.getParameter("address");
String email = request.getParameter("email");
String password = request.getParameter("password");

%>
<%= fname%><br>
<%= lname%><br>
<%= gender%><br>
<%= phone%><br>
<%= address%><br>
<%= email%><br>
<%= password%><br>
</body>
</html>