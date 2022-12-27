package com.raystec.ctl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.raystec.bean.UserRegistrationBean;
import com.raystec.model.UserRegistrationModel;

@WebServlet("/Loginctl")
public class LoginCtl extends HttpServlet {
	
       
    
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		UserRegistrationBean bean = new UserRegistrationBean();
		UserRegistrationModel model = new UserRegistrationModel();
		
		String User = request.getParameter("LoginId");
		String Pass = request.getParameter("Password");
		
		
		//code for session
		 HttpSession session = null;
		
		
	if(!User.equals("") && !Pass.equals("")) {
			
				try {
					bean = model.getAuthentication(User, Pass);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			
			if(bean.getLoginid()!= null && bean.getPass()!= null) {
				 RequestDispatcher rd = request.getRequestDispatcher("WelcomeView.jsp");
				 
				 session = request.getSession();
				 session.setAttribute("uname", bean.getFirstname());
				 
				 rd.forward(request, response);
			}
			else {
				
				 request.setAttribute("error", "Invalid Username or Password");
				 RequestDispatcher rd = request.getRequestDispatcher("/LoginView.jsp");
				 rd.forward(request, response);
				}
		
		}
		 if(User.equals("") && Pass.equals("")) {
			request.setAttribute("UError", "LoginId is Required");
			request.setAttribute("PError", "Password is Required");
			RequestDispatcher rd = request.getRequestDispatcher("/LoginView.jsp");
			rd.forward(request, response);
		}
		else if(User.equals("")) {
			request.setAttribute("UError", "LoginId is Required");
			RequestDispatcher rd = request.getRequestDispatcher("/LoginView.jsp");
			rd.forward(request, response);
		}else {
			request.setAttribute("PError", "Password is Required");
			RequestDispatcher rd = request.getRequestDispatcher("/LoginView.jsp");
			rd.forward(request, response);
			}
	}
	}
