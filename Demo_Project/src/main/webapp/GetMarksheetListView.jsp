<%@page import="com.raystec.bean.MarksheetBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Get Marksheet List</title>
</head>
<body>
<jsp:include page="/HeaderView.jsp"></jsp:include><hr>

<center>
	<h2>Marksheet List</h2>     
 	
                   
    <!-- get maraksheet records    -->
   
      <table border="1" width="100%">
      <tr>
	            <th>ID</th>
	            <th>RollNo</th>
	            <th>First Name</th>
	            <th>Last Name</th>
	            <th>Physics</th>
	            <th>Chemistry</th>
	            <th>Math</th>
	       </tr>
            
            <% 
               ArrayList<MarksheetBean> list = (ArrayList)request.getAttribute("list");
             MarksheetBean bean = new MarksheetBean(); 
               Iterator<MarksheetBean> it = list.iterator();
             	
               while (it.hasNext()) {
                   bean = it.next();
                  
              %>
                <tr>
                   
                    <td><%=bean.getId()%></td>
                    <td><%=bean.getRollno()%></td>
                    <td><%=bean.getFirstname()%></td>
                    <td><%=bean.getLastname()%></td>
                    <td><%=bean.getPhysics()%></td>
                    <td><%=bean.getChemistry()%></td>
                    <td><%=bean.getMath()%></td>
                   	
                </tr>

                <%
                    }
                %>
            </table>
           
        </form>
    </center>
    <jsp:include page="/FooterView.jsp"></jsp:include>
</body>
</html>