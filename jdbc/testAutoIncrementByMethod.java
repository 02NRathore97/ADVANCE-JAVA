package in.com.raystec.jdbc;
import java.sql.*;


public class testAutoIncrementByMethod {
	public static void main(String[] args) throws Exception {
		testAdd();
	}
	
	public static int nextPK()throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/raystec", "root", "root");
		
		int pk = 0;
		PreparedStatement pstmt = conn.prepareStatement("SELECT MAX(EMP_ID) FROM EMPLOYEE_2");
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			pk = rs.getInt(1);
		}
		return pk + 1;
		
		
	}
	
	public static void testAdd()throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/raystec", "root", "root");
		
		PreparedStatement pstmt = conn.prepareStatement("INSERT INTO EMPLOYEE_2(EMP_ID, FNAME, LNAME, SALARY) VALUES(?,?,?,?)");
		
		pstmt.setInt(1, nextPK());
		pstmt.setString(2, "NEERAJ");
		pstmt.setString(3, "RATHORE");
		pstmt.setInt(4,250000);
		
		pstmt.executeUpdate();
		
		System.out.println("inserted...............");
		
		pstmt.close();
		conn.close();
		
		
		
		
	}
	
}
