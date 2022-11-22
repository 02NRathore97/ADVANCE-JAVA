<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>BS</title>
</head>
<body>
hello....B

	<% 
	request.setAttribute("DryFruit", "Almond");
%>
<jsp:forward page="C.jsp"></jsp:forward>
</body>
</html>