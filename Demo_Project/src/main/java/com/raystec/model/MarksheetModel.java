package com.raystec.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.raystec.bean.MarksheetBean;

public class MarksheetModel {

	//get Marksheet method
	public MarksheetBean getMarksheet(String rollno) throws Exception {
		// load driver
		Class.forName("com.mysql.cj.jdbc.Driver");

		// create connection
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/DEMO_PROJECT", "root", "root");

	
		// create statement
		PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM MARKSHEET WHERE ROLLNO = ?");
		pstmt.setString(1, rollno);

		ResultSet rs = pstmt.executeQuery();
		
		MarksheetBean bean = null;

		while (rs.next()) {
			bean = new MarksheetBean();
			bean.setId(rs.getInt(1));
			bean.setRollno(rs.getString(2));
			bean.setFirstname(rs.getString(3));
			bean.setLastname(rs.getString(4));
			bean.setPhysics(rs.getString(5));
			bean.setChemistry(rs.getString(6));
			bean.setMath(rs.getString(7));
		}

		return bean;
   }
	
	// add method
		public void addMarksheet(MarksheetBean bean) throws Exception {
			// load driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// create connection
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/DEMO_PROJECT", "root", "root");

			// transaction handling
			conn.setAutoCommit(false);

			// create statement
			PreparedStatement pstmt = conn.prepareStatement("INSERT INTO MARKSHEET VALUES(?,?,?,?,?,?,?)");

			pstmt.setInt(1, bean.getId());
			pstmt.setString(2, bean.getRollno());
			pstmt.setString(3, bean.getFirstname());
			pstmt.setString(4, bean.getLastname());
			pstmt.setString(5, bean.getPhysics());
			pstmt.setString(6, bean.getChemistry());
			pstmt.setString(7, bean.getMath());

			pstmt.executeUpdate();
			conn.commit();

			// close connection
			pstmt.close();
			conn.close();
		}
		
		//search method
		public ArrayList<MarksheetBean> search() throws Exception {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/DEMO_PROJECT", "root", "root");

			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM MARKSHEET");
			ResultSet rs = pstmt.executeQuery();
			ArrayList<MarksheetBean> list = new ArrayList<MarksheetBean>();
			MarksheetBean bean = null;
			
			while (rs.next()) {
				bean = new MarksheetBean();
			
				bean.setId(rs.getInt(1));
				bean.setRollno(rs.getString(2));
				bean.setFirstname(rs.getString(3));
				bean.setLastname(rs.getString(4));
				bean.setPhysics(rs.getString(5));
				bean.setChemistry(rs.getString(6));
				bean.setMath(rs.getString(7));
				list.add(bean);
			}
			return list;
			
		}
}
