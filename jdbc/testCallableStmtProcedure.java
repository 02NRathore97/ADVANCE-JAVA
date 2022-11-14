package in.com.raystec.jdbc;
import java.sql.*;

public class testCallableStmtProcedure {
	public static void main(String[] args) {
		
		String Q = "{CALL userCount(?)}";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/raystec","root","root");
			
			
			CallableStatement cal = conn.prepareCall(Q);
			cal.registerOutParameter(1, Types.INTEGER);
			cal.execute();
			
			System.out.println(cal.getInt(1));
			
			conn.close();
			cal.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
