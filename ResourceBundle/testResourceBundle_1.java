package in.com.raystec.ResourceBundle;

import java.sql.*;
import java.util.ResourceBundle;

public class testResourceBundle_1 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
	
	
	ResourceBundle rb = ResourceBundle.getBundle("in.com.raystec.Resourcebundle.app");
	//load the driver
	Class.forName(rb.getString("driver"));
	
	//create connection
	Connection conn = DriverManager.getConnection(rb.getString("url"), rb.getString("user"), rb.getString("pswd"));
	
	//create statement
	
	String Q = "SELECT * FROM EMPLOYEE";
	PreparedStatement Pstmt = conn.prepareStatement(Q);
	ResultSet rs = Pstmt.executeQuery();
	
	//manipulate statement
	
	while(rs.next()) {
		System.out.print("\t"+rs.getString(1));
		System.out.print("\t"+rs.getString(2));
		System.out.print("\t\t"+rs.getString(3));
		System.out.print("\t\t"+rs.getString(4));
		System.out.print("\t\t"+rs.getString(5));
		System.out.println(" ");
	}
		
	//close connection
		
		rs.close();
		Pstmt.close();
		conn.close();
	
		
}
}