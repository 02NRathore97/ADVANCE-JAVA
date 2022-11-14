package in.com.raystec.marksheet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MarksheetModel {

	// add method
	public void add(MarksheetBean bean) throws Exception {
		// load driver
		Class.forName("com.mysql.cj.jdbc.Driver");

		// create connection
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/raystec", "root", "root");

		// transaction handling
		conn.setAutoCommit(false);

		// create statement
		PreparedStatement pstmt = conn.prepareStatement("INSERT INTO MARKSHEET VALUES(?,?,?,?,?,?,?)");

		pstmt.setInt(1, bean.getId());
		pstmt.setString(2, bean.getRollno());
		pstmt.setString(3, bean.getFname());
		pstmt.setString(4, bean.getLname());
		pstmt.setInt(5, bean.getPhy());
		pstmt.setInt(6, bean.getChe());
		pstmt.setInt(7, bean.getMat());

		pstmt.executeUpdate();
		conn.commit();

		// close connection
		pstmt.close();
		conn.close();
	}

	// update method
	public void update(MarksheetBean bean) throws Exception {
		// load driver
		Class.forName("com.mysql.cj.jdbc.Driver");

		// create connection
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/raystec", "root", "root");

		// transaction handling
		conn.setAutoCommit(false);

		// create statement
		PreparedStatement pstmt = conn.prepareStatement("UPDATE MARKSHEET SET LNAME = ? WHERE ID = ?");

		pstmt.setInt(1, bean.getId());
		pstmt.setString(2, bean.getRollno());
		

		pstmt.executeUpdate();
		conn.commit();

		// close connection
		pstmt.close();
		conn.close();
	}

	// delete method
	public void delete(MarksheetBean bean) throws Exception {
		// load driver
		Class.forName("com.mysql.cj.jdbc.Driver");

		// create connection
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/raystec", "root", "root");

		// transaction handling
		conn.setAutoCommit(false);

		// create statement
		PreparedStatement pstmt = conn.prepareStatement("DELETE FROM MARKSHEET WHERE ROLLNO = ?");

		pstmt.setString(1, bean.getRollno());

		pstmt.executeUpdate();
		conn.commit();

		// close connection
		pstmt.close();
		conn.close();
	}

	// get method
	public MarksheetBean get(MarksheetBean bean) throws Exception {
		// load driver
		Class.forName("com.mysql.cj.jdbc.Driver");

		// create connection
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/raystec", "root", "root");

	
		// create statement
		PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM MARKSHEET WHERE ROLLNO = ?");
		pstmt.setString(1, bean.getRollno());

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			bean.setId(rs.getInt(1));
			bean.setRollno(rs.getString(2));
			bean.setFname(rs.getString(3));
			bean.setLname(rs.getString(4));
			bean.setPhy(rs.getInt(5));
			bean.setChe(rs.getInt(6));
			bean.setMat(rs.getInt(7));
		}

		return bean;

		
	}

	
	public ArrayList<MarksheetBean> getMeritList() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/raystec", "root", "root");

		PreparedStatement ps = conn.prepareStatement(
				"SELECT ID, ROLLNO, FNAME, LNAME, PHYSICS, CHEMISTRY, MATH,(PHYSICS + CHEMISTRY + MATH) AS TOTAL, ((PHYSICS + CHEMISTRY + MATH)/3) AS PERCENTAGE FROM MARKSHEET WHERE (PHYSICS >40 AND CHEMISTRY >40 AND MATH >40) ORDER BY TOTAL DESC");
		ResultSet rs = ps.executeQuery();
		ArrayList<MarksheetBean> list = new ArrayList<MarksheetBean>();
		
		while (rs.next()) {
			MarksheetBean bean = new MarksheetBean();
		
			bean.setId(rs.getInt(1));
			bean.setRollno(rs.getString(2));
			bean.setFname(rs.getString(3));
			bean.setLname(rs.getString(4));
			bean.setPhy(rs.getInt(5));
			bean.setChe(rs.getInt(6));
			bean.setMat(rs.getInt(7));
			list.add(bean);
		}
		return list;
		
	}
	
	
	
//	} // search method

	public static void search() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/raystec", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM MARKSHEET");

		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			
			System.out.print("\t"+rs.getInt(1));
			System.out.print("\t"+rs.getString(2));
			System.out.print("\t"+rs.getString(3));
			System.out.print("\t"+rs.getString(4));
			System.out.print("\t"+rs.getInt(5));
			System.out.print("\t"+rs.getInt(6));
			System.out.print("\t"+rs.getInt(7));
			System.out.println(" ");
		}

		pstmt.close();
		conn.close();

	}

}

