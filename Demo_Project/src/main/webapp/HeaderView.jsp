<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Header</title>
<style type="text/css">
	img{
		width: 200px;
		
	}
</style>

</head>
<body>
  <%String user = (String)session.getAttribute("uname"); %>
	<table width="100%" border="0">
        <tr>
            <td width="90%">
            	<%if(user != null){ %>
            	
            	<a href = "LogoutView.jsp">LogOut</a>
            	<h3>Hi,<%=user %></h3>
            
         
          
       			  <% }else {%>
           		
           		<h3>Hi, Guest</h3>
           </td>
          
          <% } %>
            <td rowspan="2">
                <h1 align="Right">
                    <img src="img/logo.png" >
                </h1>
            </td>
        </tr>
       
        
    </table>
    
    
</body>
</html>