package com.raystec.ctl;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.raystec.model.MarksheetModel;
import com.raystec.bean.MarksheetBean;

@WebServlet("/GetMarksheetListCtl.do")
public class GetMarksheetListCtl extends HttpServlet {
				MarksheetModel model = new MarksheetModel();
				MarksheetBean bean = new MarksheetBean();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//code to show all records of database	
		try {
			List list = model.search();
			RequestDispatcher rd = request.getRequestDispatcher("/GetMarksheetListView.jsp");
			request.setAttribute("list", list);
			rd.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	
		
				}
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		
	
	  }
	}

