package in.com.raystec.jdbc;
import java.sql.*;

public class testBatchProcessingStmt {
	public static void main(String[] args)throws Exception {
		//load the driver
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				//create connection
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/raystec", "root", "root");
				Statement stmt = conn.createStatement();
				
				stmt.addBatch("INSERT INTO EMPLOYEE(EMP_ID, FNAME, LNAME,SALARY) VALUES(16, 'SHAYAM', 'RATHI', 11000)");
				stmt.addBatch("INSERT INTO EMPLOYEE(EMP_ID, FNAME, LNAME,SALARY) VALUES(17, 'SOHAN', 'RAI', 15000)");
				stmt.addBatch("INSERT INTO EMPLOYEE(EMP_ID, FNAME, LNAME,SALARY) VALUES(18, 'GANESH', 'RAO', 17000)");
				
				int[] i = stmt.executeBatch();
				
				System.out.println("done........");
				
				stmt.close();
				conn.close();

				
}
	}
