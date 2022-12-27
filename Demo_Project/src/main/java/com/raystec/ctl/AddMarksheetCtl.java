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

@WebServlet("/AddMarksheetCtl.do")
public class AddMarksheetCtl extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MarksheetBean bean = new MarksheetBean();
		MarksheetModel model = new MarksheetModel();
		
		String rollno = request.getParameter("RollNo");
		String firstname = request.getParameter("FirstName");
		String lastname = request.getParameter("LastName");
		String physics = request.getParameter("Physics");
		String chemistry = request.getParameter("Chemistry");
		String math = request.getParameter("Math");
		
		try {
			bean.setId(nextPk());
		} catch (Exception e) {
			e.printStackTrace();
		}
		bean.setRollno(rollno);
		bean.setFirstname(firstname);
		bean.setLastname(lastname);
		bean.setPhysics(physics);
		bean.setChemistry(chemistry);
		bean.setMath(math);
		
		

		String firstnamereg = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$";
		String lastnamereg = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$";
		String rollnoreg = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		
		
		
		if ( rollno.equals("") && firstname.equals("") && lastname.equals("") && physics.equals("") && chemistry.equals("") && math.equals("")){
			request.setAttribute("Error", "Fields are empty");
			
			RequestDispatcher rd = request.getRequestDispatcher("/AddMarksheetView.jsp");
			rd.forward(request, response);
		}else {

			if (rollno.equals("") || firstname.equals("") || lastname.equals("") || physics.equals("") || chemistry.equals("")|| math.equals(""))
				{
				
				if (rollno.equals("")) {
					request.setAttribute("Error", "Roll No is required");

				} else if (!rollno.matches(rollnoreg)) {
					request.setAttribute("Error", "Enter currect roll no");

				}
				
				if (firstname.equals("")) {
					request.setAttribute("Error", "First Name is required");

				} else if (!firstname.matches(firstnamereg)) {
					request.setAttribute("Error", "Enter Aplhabet only in FirstName");

				}
				if (lastname.equals("")) {
					request.setAttribute("Error", "Last Name is required");

				} else if (!lastname.matches(lastnamereg)) {
					request.setAttribute("Error", "Enter Aplhabet only in LastName");

				}
				if (physics.equals("")) {
					request.setAttribute("Error", "Marks in Physics are required");
				} else if (!physics.matches(rollno)) {

					request.setAttribute("Error", "Enter valid Marks");

				}
				if(chemistry.equals("")) {
					request.setAttribute("Error", "Marks in Chemistry are required");
				}
				else if(!chemistry.matches(rollno)) {
					request.setAttribute("Error", "Enter valid Marks");
				}
				if(math.equals("")) {
					request.setAttribute("Error", "Marks in Mathematics are required");
				}
				else if(!math.matches(rollno)) {
					request.setAttribute("Error", "Enter valid Marks");
				}
				
				
				RequestDispatcher rd = request.getRequestDispatcher("/AddMarksheetView.jsp");
				rd.forward(request, response);
			}
			try {
				model.addMarksheet(bean);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			RequestDispatcher rd = request.getRequestDispatcher("/AddMarksheetView.jsp");
			request.setAttribute("msg" ,"Successfull !!!! ");
			rd.forward(request, response);

		}
	}
	//NextPk method
	public static int nextPk() throws Exception {
		//load driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//create connection
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/DEMO_PROJECT","root","root");
		
		//create statement
		int pk = 0;
		PreparedStatement pstmt = conn.prepareStatement("SELECT MAX(ID) FROM MARKSHEET");
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			pk = rs.getInt(1);
		}
		return pk + 1;
	}
	}