<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Form</title>
<style>
	input{
		padding:8px 30px;
	}
	#submit{
	padding:8px 86px;
	}
	#reset{
	padding:8px 90px;
	}
	</style>
</head>
<body>
	<form method="post" action="RegistrationData.jsp">
		<table align="center">
		<h2 align="center">REGISTRATION</h2>
				<tr>
					<th>FirstName*</th>
					<td><input type="text" name="fname" value=""></td>
				</tr>
				<tr>
					<th>LastName*</th>
					<td><input type="text" name="lname" value=""></td>
				</tr>
				<tr>
					<th>Gender*</th>
					<td>
					<input type="radio" name="gender" value="male">MALE
					<input type="radio" name="gender" value="female">FEMALE
					</td>
				</tr>
				
				<tr>
					<th>PhoneNo*</th>
					<td><input type="tel" name="phone" value=""></td>
				</tr>
				<tr>
					<th>Address</th>
					<td><input type="text" name="address" value=""></td>
				</tr>
				<tr>
					<th>EmailId</th>
					<td><input type="email" name="email" value=""></td>
				</tr>
				<tr>
					<th>Password</th>
					<td><input type="password" name="password" value=""></td>
				</tr>
				<tr>
					<th></th>
					<td><input type="submit" name="submit" value="SUBMIT" id="submit"></td>
				</tr>
				<tr>
					<th></th>
					<td><input type="reset" name="Reset" value="RESET" id="reset"></td>
				</tr>
				
			</table>
	</form>


</body>
</html>