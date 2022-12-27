<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Registration</title>

<style>
	#date{
		width: 165px
	}
</style>

</head>
<body>
	
	<jsp:include page="/HeaderView.jsp"></jsp:include><hr>
	
	
	<form action="UserRegistrationCtl" method="post">
		<h2 align="center">User Registration</h2>
		<table align="center">
			<tr >
				<td align="right">First Name<font style="color: red;">*</font> :</td>
				<td >
					<input type="text" name="FirstName" value="" placeholder="Enter First Name" >
					<%String FnameError = (String)request.getAttribute("FnameError");
			   			if(FnameError != null){%>
				   			<font color=red><%=FnameError %><font>
						<%}%>
				</td>
			</tr>
			<tr>
				<td align="right">Last Name <font style="color: red;">*</font> :</td>
				<td >
					<input type="text" name="LastName" value="" placeholder="Enter Last Name" >
					<%String LnameError = (String)request.getAttribute("LnameError");
			   			if(LnameError != null){%>
				   			<font color=red><%=LnameError %><font>
						<%}%>
				</td>
			</tr>
			
			<tr>
				<td align="right">Gender <font style="color: red;">*</font> :</td>
				<td ><select name="Gender">
						<option value="">-------------select------------</option>
						<option value="Male">Male</option>
						<option value="Female">FeMale</option>
					</select>
					<%String GenderError = (String)request.getAttribute("GenderError");
			   			if(GenderError != null){%>
				   			<font color=red><%=GenderError %><font>
						<%}%>
				</td>
			</tr>
			<tr>
				<td align="right" >Date Of Birth <font style="color: red;">*</font> :</td>
				<td >
					<input type="date" name="DOB" value=""  id="date">
					<%String DobError = (String)request.getAttribute("DobError");
			   			if(DobError != null){%>
				   			<font color=red><%=DobError %><font>
						<%}%>
				</td>
			</tr>
			<tr>
				<td align="right">Mobile No <font style="color: red;">*</font> :</td>
				<td >
					<input type="tel" name="MobileNo" value="" placeholder="Enter Mobile Number" >
					<%String MobileError = (String)request.getAttribute("MobileError");
			   			if(MobileError != null){%>
				   			<font color=red><%=MobileError %><font>
						<%}%>
				</td>
			</tr>
			<tr>
				<td align="right">Login Id<font style="color: red;">*</font> :</td>
				<td >
					<input type="text" name="LoginId" value="" placeholder="Enter UserName" >
					<%String LoginError = (String)request.getAttribute("LoginError");
			   			if(LoginError != null){%>
				   			<font color=red><%=LoginError %><font>
						<%}%>	
				</td>
			</tr>
			<tr>
				<td align="right">Password <font style="color: red;">*</font> :</td>
				<td>
					<input type="text" name="Password" value="" placeholder="Enter Password" >
					<%String PasswordError = (String)request.getAttribute("PassError");
			   			if(PasswordError != null){%>
				   		<font color=red><%=PasswordError %><font><%}%>
				</td>
			</tr>
			
			<tr>
				<td></td>
				<td align="left">
					<input type="submit" name="Submit" value="Submit" >
					<input type="reset" name="Reset" value="Reset">
				</td>
			</tr>
			
		</table>
	
	</form>
	
	<jsp:include page="/FooterView.jsp"></jsp:include>
</body>
</html>