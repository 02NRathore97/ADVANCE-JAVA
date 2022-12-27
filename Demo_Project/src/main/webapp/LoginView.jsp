<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
<jsp:include page="/HeaderView.jsp"></jsp:include><hr>
	
	
	<form action="Loginctl" method="post">
		<table align="center">
		
		<h4 align="center"><%String msg = (String)request.getAttribute("msg");
			   			if(msg != null){%><font color="Green"><%=msg %></font>
					<%}%></h4>
			<h4 align="center"><%String Error = (String)request.getAttribute("error");
			   			if(Error != null){%><font color="red"><%=Error %></font>
					<%}%></h4>
			<tr>
				<td align="right">Login Id <font style="color: red;">*</font> :</td>
				<td >
					<input type="text" name="LoginId" value="" placeholder="Enter Login Id" >
					 <%String UError = (String)request.getAttribute("UError");
			   			if(UError != null){%><font color="red"><%=UError %></font>
					<%}%> 
				</td>
			</tr>
			<tr>
				<td align="right">Password <font style="color: red;">*</font> :</td>
				<td>
					<input type="password" name="Password" value="" placeholder="Enter Password" >
				 <%String PError = (String)request.getAttribute("PError");
			   			if(PError != null){%><font color="red"><%=PError %></font>
					<%}%> 
				</td>
			</tr>
			<tr>
				<td></td>
				<td align="left">
					<input type="submit" name="Submit" value="SignIn">
					<a href="UserRegistrationView.jsp"><input type="button" value="SignUp" ></a>
				</td>
			</tr>
			<tr>
				<td></td>
				<td><a href="ForgetPasswordView.jsp"><h5>Forget Password ?</h5></a></td>
			</tr>
		</table>
	</form>
	
	<jsp:include page="/FooterView.jsp"></jsp:include>
</body>
</html>