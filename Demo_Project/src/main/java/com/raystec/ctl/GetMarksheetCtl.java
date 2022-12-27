package com.raystec.ctl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.raystec.bean.MarksheetBean;
import com.raystec.model.MarksheetModel;

@WebServlet("/GetMarksheetCtl.do")
public class GetMarksheetCtl extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
			String rollno = request.getParameter("RollNo");
		
		if(rollno.equals("")) {
			RequestDispatcher rd = request.getRequestDispatcher("GetMarksheetView.jsp");
			request.setAttribute("RollNoError", "Roll No is required");
			rd.forward(request, response);
			
		}else {
			MarksheetModel model = new MarksheetModel();
			
			
			try {
				MarksheetBean bean = model.getMarksheet(rollno);
				
			
			if(bean != null) {
				RequestDispatcher rd = request.getRequestDispatcher("/showMarksheetView.jsp");
				request.setAttribute("rollno", bean.getRollno());
				request.setAttribute("firstname", bean.getFirstname());
				request.setAttribute("lastname", bean.getLastname());
				request.setAttribute("physics", bean.getPhysics());
				request.setAttribute("chemistry", bean.getChemistry());
				request.setAttribute("math", bean.getMath());
				
				rd.forward(request, response);
				
			}else {
				RequestDispatcher rd = request.getRequestDispatcher("GetMarksheetView.jsp");
				request.setAttribute("RollNoError", "Invaild Roll No");
				rd.forward(request, response);
			}
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		}
	}
		
		
		

	

}
