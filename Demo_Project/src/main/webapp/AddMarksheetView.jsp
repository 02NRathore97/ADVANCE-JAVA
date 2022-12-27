<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add MArksheet</title>
</head>
<body>
	<jsp:include page="/HeaderView.jsp"></jsp:include><hr>

	<h1 align="center">Add Marksheet</h1>
		
	
		<h3 align="center"><%String msg = (String)request.getAttribute("msg");
			   			if(msg != null){%><font color="Green"><%=msg %></font>
					<%}%>
		</h3>
		<h4 align="center"><%String Error = (String)request.getAttribute("error");
			   			if(Error != null){%><font color="red"><%=Error %></font>
					<%}%>
		</h3>
	

		
<center>
<form method="post" action="AddMarksheetCtl">
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
			<td width="150px" ><input type="text" name="RollNo" value="" placeholder="Enter roll no"></td>
			<td width="150px"><input type="text" name="FirstName" value="" placeholder="Enter First Name"></td>
			<td width="150px"><input type="text" name="LastName" value="" placeholder="Enter Last Name"></td>
			<td width="150px"><input type="text" name="Physics" value="" placeholder="Entert Marks"></td>
			<td width="150px"><input type="text" name="Chemistry" value="" placeholder="Entert Marks"></td>
			<td width="150px"><input type="text" name="Math" value="" placeholder="Entert Marks"></td>
		</tr>
		
			
		</table>
		<h4 align="center"><input type="submit" name="Submit" value="Submit"></h4>
</form>
</center>
<jsp:include page="/FooterView.jsp"></jsp:include>
</body>
</html>