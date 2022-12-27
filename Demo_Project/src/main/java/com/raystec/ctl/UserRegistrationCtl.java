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


import com.raystec.bean.UserRegistrationBean;
import com.raystec.model.UserRegistrationModel;

@WebServlet("/UserRegistrationCtl")
public class UserRegistrationCtl extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserRegistrationBean bean = new UserRegistrationBean();
		UserRegistrationModel model = new UserRegistrationModel();
		
		String firstname =  request.getParameter("FirstName");
		String lastname = request.getParameter("LastName");
		String gender = request.getParameter("Gender");
		String dob = request.getParameter("DOB");
		String mobile = request.getParameter("MobileNo");
		String loginid = request.getParameter("LoginId");
		String pass = request.getParameter("Password");
		
		
		try {
			bean.setReg_id(nextPk());
		} catch (Exception e) {
			e.printStackTrace();
		}
		bean.setFirstname(firstname);
		bean.setLastname(lastname);
		bean.setGender(gender);
		bean.setDob(dob);
		bean.setMobile(mobile);
		bean.setLoginid(loginid);
		bean.setPass(pass);
		
		
		
		String firstnamereg = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$";
		String lastnamereg = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$";
		String mobilereg = "^(\\+\\d{1,3}[- ]?)?\\d{10}$";
		String loginidreg = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		String passreg = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{8,20}$";
		
		

		if (firstname.equals("") && lastname.equals("") && loginid.equals("") && pass.equals("") && gender.equals("") && dob.equals("") && mobile.equals("")) {
			request.setAttribute("FnameError", "First Name is required");
			request.setAttribute("LnameError", "Last Name is required");
			request.setAttribute("GenderError", "Gender is required");
			request.setAttribute("DobError", "Date of birth is required");
			request.setAttribute("MobileError", "Mobile number is required");
			request.setAttribute("LoginError", "Login Id is required");
			request.setAttribute("PassError", "Password is required");
			
			
			RequestDispatcher rd = request.getRequestDispatcher("UserRegistrationView.jsp");
			rd.forward(request, response);
		
		} else {

			if (firstname.equals("") || lastname.equals("") || loginid.equals("") || pass.equals("")|| gender.equals("") || dob.equals("")|| mobile.equals(""))
				{
				if (firstname.equals("")) {
					request.setAttribute("FnameError", "First Name is required");

				} else if (!firstname.matches(firstnamereg)) {
					request.setAttribute("FnameError", "Enter Aplhabet only");

				}
				if (lastname.equals("")) {
					request.setAttribute("LnameError", "Last Name is required");

				} else if (!lastname.matches(lastnamereg)) {
					request.setAttribute("LnameError", "Enter Aplhabet only");

				}
				if (loginid.equals("")) {
					request.setAttribute("LoginError", "Login Id is required");
				} else if (!loginid.matches(loginidreg)) {

					request.setAttribute("LoginError", "Enter Login Id with special characters");

				}
				if(pass.equals("")) {
					request.setAttribute("PassError", "Password is required");
				}
				else if(!pass.matches(passreg)) {
					request.setAttribute("PassError", "Enter Password that contains super characters");
				}
				
				if(mobile.equals("")) {
					request.setAttribute("MobileError", "Mobile number is required");
				}
				else if(!mobile.matches(mobilereg)) {
					request.setAttribute("MobileError", "Enter Mobile no that starts with [6-9]");
				}
				
				if(gender.equals("")) {
					request.setAttribute("GenderError", "Gender is required");
				}
				if(dob.equals("")) {
					request.setAttribute("DobError", "Date of birth is required");
				}
				RequestDispatcher rd = request.getRequestDispatcher("/UserRegistrationView.jsp");
				rd.forward(request, response);
			}
				
		
		
		try {
			model.add(bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
				
				
		RequestDispatcher rd = request.getRequestDispatcher("/LoginView.jsp");
		request.setAttribute("msg" ,"Successfull registration !!!! Now You Can LOGIN");
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
				PreparedStatement pstmt = conn.prepareStatement("SELECT MAX(REG_ID) FROM REGISTRATION");
				ResultSet rs = pstmt.executeQuery();
				
				while(rs.next()) {
					pk = rs.getInt(1);
				}
				return pk + 1;
			}

	}


