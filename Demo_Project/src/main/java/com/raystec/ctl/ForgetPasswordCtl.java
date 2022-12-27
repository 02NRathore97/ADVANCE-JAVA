package com.raystec.ctl;

import java.awt.SecondaryLoop;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.raystec.bean.UserRegistrationBean;
import com.raystec.model.UserRegistrationModel;

@WebServlet("/ForgetPasswordCtl")
public class ForgetPasswordCtl extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("LoginId");
		
		
		
		
		if(login.equals("")) {
			RequestDispatcher rd = request.getRequestDispatcher("ForgetPasswordView.jsp");
			request.setAttribute("LoginError", "Login Id is required");
			rd.forward(request, response);
			
		}else {
			UserRegistrationModel model = new UserRegistrationModel();
			
			
			try {
				UserRegistrationBean bean = model.forgetPassword(login);
				
			
			if(bean != null) {
				RequestDispatcher rd = request.getRequestDispatcher("ForgetPasswordView.jsp");
				request.setAttribute("Pwd", bean.getPass());
				rd.forward(request, response);
			}else {
				RequestDispatcher rd = request.getRequestDispatcher("ForgetPasswordView.jsp");
				request.setAttribute("LoginError", "Invaild Login Id");
				rd.forward(request, response);
			}
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		}
	}
}
