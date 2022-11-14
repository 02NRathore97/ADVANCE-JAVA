package in.com.raystec.jdbc;
import java.sql.*;

public class testBatchProcessingPstmt {
	public static void main(String[] args)throws Exception {
		//load the driver
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				String Q = "INSERT INTO EMPLOYEE(EMP_ID, FNAME, LNAME,SALARY) VALUES(?, ?, ?, ?)";
				
				//create connection
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/raystec", "root", "root");
				PreparedStatement pstmt = conn.prepareStatement(Q);
				
				pstmt.setInt(1,19);
				pstmt.setString(2,"REENA" );
				pstmt.setString(3, "RAO" );
				pstmt.setInt(4,15000 );
				pstmt.addBatch();
				
				pstmt.setInt(1,20);
				pstmt.setString(2,"REENA" );
				pstmt.setString(3, "RAO" );
				pstmt.setInt(4,15000 );
				pstmt.addBatch();
				
				int[] i = pstmt.executeBatch();
				
				
			
				
				System.out.println("done........");
				
				pstmt.close();
				conn.close();

				
}
}
