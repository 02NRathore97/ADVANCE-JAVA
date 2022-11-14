package in.com.raystec.jdbc;
import java.sql.*;
import java.util.Scanner;


public class testGetValueRunTime {
	public static void main(String[] args) throws Exception {
		//load the driver
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				//create connection
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/raystec", "root", "root");
				
				String Q = "INSERT INTO EMPLOYEE(EMP_ID, FNAME, LNAME, SALARY) VALUES(?,?,?,?)";
				
				PreparedStatement pstmt = conn.prepareStatement(Q);
				
				Scanner sc = new Scanner(System.in);
				
				System.out.println("ENTER ID");
				int id = sc.nextInt();
				
				System.out.println("ENTER FNAME");
				String fn = sc.next();
				
				System.out.println("ENTER LNAME");
				String ln = sc.next();
				
				System.out.println("ENTER SALARY");
				int s = sc.nextInt();
				
				pstmt.setInt(1, id);
				pstmt.setString(2, fn);
				pstmt.setString(3, ln);
				pstmt.setInt(4, s);
				
				pstmt.executeUpdate();
				
				System.out.println("inserted...........");
				
				pstmt.close();
				conn.close();
				
				
				
	}
}
