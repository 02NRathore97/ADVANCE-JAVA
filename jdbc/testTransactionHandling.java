package in.com.raystec.jdbc;

import java.sql.*;

public class testTransactionHandling {
	public static void main(String[] args)throws Exception {
		//load the driver
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				//create connection
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/raystec", "root", "root");
				
				
				
				//transaction handling
				conn.setAutoCommit(false);
				//create statement
				Statement stmt = conn.createStatement();
				stmt.executeUpdate("INSERT INTO EMPLOYEE(EMP_ID, FNAME, LNAME, SALARY) VALUES(13, 'RAHUL', 'VYAS',17000)");
				stmt.executeUpdate("INSERT INTO EMPLOYEE(EMP_ID, FNAME, LNAME, SALARY) VALUES(14, 'ROHAN', 'RATHORE',22000 )");
				stmt.executeUpdate("INSERT INTO EMPLOYEE(EMP_ID, FNAME, LNAME, SALARY) VALUES(13, 'SAHIL', 'SHARMA',21000 )");
				conn.commit();
			
				System.out.println("done..........");
				//close connection
					
					
					stmt.close();
					conn.close();
				
					
				}
	}


