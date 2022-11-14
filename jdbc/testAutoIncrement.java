package in.com.raystec.jdbc;
import java.sql.*;

public class testAutoIncrement {
	public static void main(String[] args) throws Exception {
		
		nextPK();
		
	}

	public static void nextPK() throws Exception {
		//load driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//create connection
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/raystec", "root", "root");
		
		//create statement
		String Q = "INSERT INTO EMPLOYEE_2 VALUES(EMP_ID,?,?,?)";
		
		PreparedStatement pstmt = conn.prepareStatement(Q);
		
		
		pstmt.setString(1, "AMIT");
		pstmt.setString(2, "RATHORE");
		pstmt.setInt(3, 30000);
		int i = pstmt.executeUpdate();
		
		System.out.println("update succesfully..........");
		
		//close connection
		
		pstmt.close();
		conn.close();
	}

}
