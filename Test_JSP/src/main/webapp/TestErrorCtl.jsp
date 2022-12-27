<%@page import="com.mchange.v2.cfg.PropertiesConfigSource.Parse"%>
<%@page errorPage="ErrorPage.jsp" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>TestErrorCtl</title>
</head>
<body>
	<%
		int a =Integer.parseInt(request.getParameter("Id")) ;
		out.println(a);
		
	
		
	%>
</body>
</html>