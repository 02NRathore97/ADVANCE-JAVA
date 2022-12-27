<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Get Marksheet</title>
</head>
<body>
	
	<jsp:include page="/HeaderView.jsp"></jsp:include><hr>
	  <form action="GetMarksheetCtl" method="post">
            <h3 align="center">Enter Your Roll No</h3>
           
           
            <table align="center">
            
				
                <tr>
					<td align="right">Roll N0<font style="color: red;">*</font> :</td>
					<td >
						<input type="text" name="RollNo" value="" placeholder="Enter Your Roll No" >
						<%String RollNoError = (String)request.getAttribute("RollNoError");
				   			if(RollNoError!= null){%>
					   			<font color=red><%=RollNoError %><font>
							<%}%>	
					</td>
				</tr>
			    <tr>
					<td></td>
					<td align="left">
						<input type="submit" name="Submit" value="submit" >
					</td>
				</tr>
                
            </table>
        </form>
 	<jsp:include page="/FooterView.jsp"></jsp:include>
</body>
</html>