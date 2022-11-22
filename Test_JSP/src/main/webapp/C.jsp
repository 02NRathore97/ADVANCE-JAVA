<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>C</title>
</head>
<body>
hello....... C
<% 
	request.setAttribute("Veggies", "Tomato");

String F = (String)request.getAttribute("Fruit");
String D = (String)request.getAttribute("DryFruit");
String V = (String)request.getAttribute("Veggies");
%>

<%=F %>
<%=D %>
<%=V %>
</body>
</html>