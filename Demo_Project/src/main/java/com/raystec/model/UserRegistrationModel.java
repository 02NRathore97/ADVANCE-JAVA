package com.raystec.model;

import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

import com.raystec.bean.UserRegistrationBean;



/**
 * @author Neeraj
 *
 */

public class UserRegistrationModel {
	
	//forget Password Method
	
	
	public static UserRegistrationBean forgetPassword(String User) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/DEMO_PROJECT", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM REGISTRATION WHERE LOGINID = ?");
		pstmt.setString(1, User);
		
		ResultSet rs = pstmt.executeQuery();
		UserRegistrationBean bean = null;
		
		while (rs.next()) {
			bean = new UserRegistrationBean();
			bean.setPass(rs.getString(8));
			
		}
//				pstmt.close();
//				conn.close();
				return bean;
	}
	
	
	//authentication method
public static  UserRegistrationBean getAuthentication(String user, String pass) throws Exception {
		
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/DEMO_PROJECT", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM REGISTRATION WHERE LOGINID = ? AND PASS = ?");
		pstmt.setString(1, user);
		pstmt.setString(2, pass);
		ResultSet rs = pstmt.executeQuery();
		UserRegistrationBean bean = new UserRegistrationBean();
		
	
		
		while (rs.next()) {
			bean.setReg_id(rs.getInt(1));
			bean.setFirstname(rs.getString(2));
			bean.setLastname(rs.getString(3));
			bean.setGender(rs.getString(4));
			bean.setDob(rs.getString(5));
			bean.setMobile(rs.getString(6));
			bean.setLoginid(rs.getString(7));
			bean.setPass(rs.getString(8));
		}
				pstmt.close();
				conn.close();
				
				
				return bean;
	}

	//add method
	public void add(UserRegistrationBean bean) throws Exception {
		// load driver
		Class.forName("com.mysql.cj.jdbc.Driver");

		// create connection
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/DEMO_PROJECT", "root", "root");

		// transaction handling
		conn.setAutoCommit(false);

		// create statement
		PreparedStatement pstmt = conn.prepareStatement("INSERT INTO REGISTRATION VALUES(?,?,?,?,?,?,?,?)");

		pstmt.setInt(1, bean.getReg_id());
		pstmt.setString(2, bean.getFirstname());
		pstmt.setString(3, bean.getLastname());
		pstmt.setString(4, bean.getGender());
		pstmt.setString(5, bean.getDob());
		pstmt.setString(6, bean.getMobile());
		pstmt.setString(7, bean.getLoginid());
		pstmt.setString(8, bean.getPass());
		
		

		pstmt.executeUpdate();
		conn.commit();

		// close connection
		pstmt.close();
		conn.close();
	}
}
