package in.com.raystec.authentication;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import in.com.raystec.marksheet.MarksheetBean;



public class AuthenticationModel {
	
	public AuthenticationBean getAuthentication() throws Exception {
		
	
		
	
		
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/raystec", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("SELECT USERNAME ,PASSWORD FROM AUTHENTICATION");
		ResultSet rs = pstmt.executeQuery();
	AuthenticationBean bean = null;
		while (rs.next()) {
			  new AuthenticationBean();
			
			bean.setUsername(rs.getString(1));
			bean.setPassword(rs.getString(2));
		}
		return bean;
		
//		Iterator it = list.iterator();
//		int i = 0;
//		while(it.hasNext()) {
//			 AuthenticationBean bean = (AuthenticationBean)it.next();
//			 if(user.equals(bean.getUsername()) && pass.equals(bean.getPassword())) {
//				 i = 1;
//				 if(i==1) {
//					 break;
//				 }
//			 }
//			 else{
//				i = 0;
//			 }
//			}
//		if(i == 1) {
//			System.out.println("valid");
//		}else {
//		System.out.println("invalid");
//		
//		}
	}
}
