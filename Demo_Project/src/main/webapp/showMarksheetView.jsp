<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Marksheet</title>
</head>
<body>

<jsp:include page="/HeaderView.jsp"></jsp:include><hr>

	<h1 align="center">Result</h1>
	
	<%String rollno = (String)request.getAttribute("rollno"); %>
	<%String firstname = (String)request.getAttribute("firstname"); %>
	<%String lastname = (String)request.getAttribute("lastname"); %>
	<%String physics = (String)request.getAttribute("physics"); %>
	<%String chemistry = (String)request.getAttribute("chemistry"); %>
	<%String math = (String)request.getAttribute("math"); %>
		
<center>
	<table border="1px solid black;">	
		<tr  >
			<th width="150px">Roll No</th>
			<th width="150px">FirstName</th>
			<th width="150px">LastName</th>
			<th width="150px">Physics</th>
			<th width="150px">Chemistry</th>
			<th width="150px">Math</th>
		</tr>
		<tr align="center" >
			<td width="150px" ><%=rollno %></td>
			<td width="150px"><%=firstname %></td>
			<td width="150px"><%=lastname %></td>
			<td width="150px"><%=physics %></td>
			<td width="150px"><%=chemistry %></td>
			<td width="150px"><%=math %></td>
		</tr>
		
	
	</table>
</center>
<jsp:include page="/FooterView.jsp"></jsp:include>
</body>
</html>