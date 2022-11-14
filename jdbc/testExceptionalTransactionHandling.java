package in.com.raystec.jdbc;

import java.sql.*;


public class testExceptionalTransactionHandling {
	public static void main(String[] args)throws Exception {
		//load the driver
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				//create connection
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/raystec", "root", "root");
				conn.setAutoCommit(false);
				Statement stmt = conn.createStatement();
				try {
					
					stmt.executeUpdate("INSERT INTO EMPLOYEE(EMP_ID, FNAME, LNAME, SALARY) VALUES(13, 'RAHUL', 'VYAS',17000)");
					stmt.executeUpdate("INSERT INTO EMPLOYEE(EMP_ID, FNAME, LNAME, SALARY) VALUES(14, 'ROHAN', 'RATHORE',22000 )");
					stmt.executeUpdate("INSERT INTO EMPLOYEE(EMP_ID, FNAME, LNAME, SALARY) VALUES(15, 'SAHIL', 'SHARMA',21000 )");
				conn.commit();
					
				} catch (Exception e) {
					conn.rollback();
				}
				
				System.out.println("done..........");
				//close connection
					
					
					stmt.close();
					conn.close();
				
					
				}
}
