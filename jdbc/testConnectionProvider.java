package in.com.raystec.jdbc;
import java.sql.*;


public class testConnectionProvider {
	private static Connection conn;
	
	public static Connection getConnection() {
		try {
			if(conn == null){
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/raystec","root","root");
			}
			
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
		}
	}
		
	