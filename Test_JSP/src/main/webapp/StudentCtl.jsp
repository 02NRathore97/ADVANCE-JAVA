<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Ctl</title>
</head>
<body>
	<jsp:useBean id="bean" class="in.com.raystec.bean.StudentBean" scope="application"></jsp:useBean>
	
	
	<jsp:setProperty property="*" name="bean"/>
	
	<jsp:getProperty property="id" name="bean"/>
	<jsp:getProperty property="fname" name="bean"/>
	<jsp:getProperty property="lname" name="bean"/>
</body>
</html>