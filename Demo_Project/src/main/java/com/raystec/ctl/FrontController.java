package com.raystec.ctl;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebFilter("*.do")
public class FrontController implements Filter {

    
    public FrontController() {
        // TODO Auto-generated constructor stub
    }

    public void doFilter(ServletRequest req, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
    	
    	HttpServletRequest request = (HttpServletRequest)req;
    	HttpSession session = request.getSession(true);
    	
    	if(session.getAttribute("uname") == null) {
    		request.setAttribute("msg", "session is expired plz login");
    		RequestDispatcher rd = request.getRequestDispatcher("LoginView.jsp");
    	rd.forward(request, response);
    	}else {
    	

		// pass the request along the filter chain
		chain.doFilter(request, response);
	}
    	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
	
	public void destroy() {
		// TODO Auto-generated method stub
	}

}
