<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Forget Password</title>
</head>
<body>
	
	<jsp:include page="/HeaderView.jsp"></jsp:include><hr>
	  <form action="ForgetPasswordCtl" method="post">
            <h1 align="center">Forgot your password?</h1>
            <h4 align="center">Submit your Login Id and we'll send you password.</h4>
           
            <table align="center">
            	<h4 align="center">
            		<%String pwd = (String)request.getAttribute("Pwd");
			   			if(pwd != null){%><font color="Green"><%=pwd %></font>
					<%}%>
				</h4>
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
					<td></td>
					<td align="left">
						<input type="submit" name="Submit" value="Go" >
					</td>
				</tr>
                
            </table>
        </form>
 	<jsp:include page="/FooterView.jsp"></jsp:include>
</body>
</html>