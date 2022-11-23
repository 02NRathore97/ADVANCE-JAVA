package in.com.raystec;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/VisitorCount")
public class VisitorCount extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletContext app = getServletContext();
		response.setIntHeader("refresh", 10);
		
		Integer  count = (Integer)app.getAttribute("visitor");
		
		if(count == null) {
			count = 1;
			
	}else {
		count++;
		}
		
		app.setAttribute("visitor", count);
		PrintWriter out = response.getWriter();
		out.print("visitor " + count);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
