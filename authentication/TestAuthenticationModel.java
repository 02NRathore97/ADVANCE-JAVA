package in.com.raystec.authentication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import in.com.raystec.marksheet.MarksheetBean;
import in.com.raystec.marksheet.MarksheetModel;

public class TestAuthenticationModel {
	
	public static void main(String[] args) throws Exception {
		String user = "NEERAJ";
		String pass = "112";
		
		AuthenticationModel am = new AuthenticationModel();
		
		AuthenticationBean bean = new AuthenticationBean();
		bean = am.getAuthentication();
		if(bean.getUsername().equals(user) && bean.getPassword().equals(pass)) {
			System.out.println(bean.getUsername());
			System.out.println(bean.getPassword());
		}else {
			System.out.println("...................");
		}
		
	}
	
		
}
