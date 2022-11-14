package in.com.raystec.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.io.*;

public class testGetValueRunTimeIO {
	public static void main(String[] args) throws Exception {
		//load the driver
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				//create connection
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/raystec", "root", "root");
				
				String Q = "INSERT INTO EMPLOYEE(EMP_ID, FNAME, LNAME, SALARY) VALUES(?,?,?,?)";
				
				PreparedStatement pstmt = conn.prepareStatement(Q);
				
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
				
				System.out.println("ENTER ID");
				int id = Integer.parseInt(br.readLine());
				
				System.out.println("ENTER FNAME");
				String fn = br.readLine();
				
				System.out.println("ENTER LNAME");
				String ln = br.readLine();
				
				System.out.println("ENTER SALARY");
				int s = Integer.parseInt(br.readLine());
				
				pstmt.setInt(1, id);
				pstmt.setString(2, fn);
				pstmt.setString(3, ln);
				pstmt.setInt(4, s);
				
				pstmt.executeUpdate();
				
				System.out.println("inserted...........");
				
				conn.close();
				pstmt.close();
				
				
				
	}
}
