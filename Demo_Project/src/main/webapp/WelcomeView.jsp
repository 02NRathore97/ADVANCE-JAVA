<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>

</head>
<body>
	
	<jsp:include page="HeaderView.jsp"></jsp:include>
	<a href="GetMarksheetView.jsp">Get Marksheet</a> | 
	<a href="AddMarksheetView.jsp">Add Marksheet</a> |
	<a href="GetMarksheetListCtl">Get Marksheet List</a> 
	<hr>
	
	
	<h1 align="center"><font color="red" >Welcome To ORS</font></h1>
	<jsp:include page="/FooterView.jsp"></jsp:include>
</body>
</html>