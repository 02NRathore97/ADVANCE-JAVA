package in.com.raystec.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public final class C3P0DataSourceConnection {
	
	//JDBC DataSource static object
	private static C3P0DataSourceConnection dsc = null;
	
	//C3P0 DataBase connection Pool
	private ComboPooledDataSource ds = null;
	
	//make default constructor private
	private C3P0DataSourceConnection()throws Exception {
		ds = new ComboPooledDataSource();
		ds.setDriverClass("com.mysql.cj.jdbc.Driver");
		ds.setJdbcUrl("jdbc:mysql://localhost:3306/raystec");
		ds.setUser("root");
		ds.setPassword("root");
		ds.setInitialPoolSize(5);
		ds.setAcquireIncrement(3);
		ds.setMaxPoolSize(10);
	}
		
		
	//get singleton class instance
	public static C3P0DataSourceConnection getInstance() throws Exception {
		if(dsc == null) {
			dsc = new C3P0DataSourceConnection();
		}
		return dsc;
	}
	
	//get connection from DCP
	public static Connection getConnection(){
		try {
		return getInstance().ds.getConnection();
		}
		catch(Exception e) {
			return null;
		}
	}
	
	//close connection
	public static void closeConnection(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if(rs != null) {
				rs.close();
			}
			if(stmt != null) {
				stmt.close();
			}
			if(conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//close connection
	
	public static void closeConnection(Connection conn, Statement stmt) {
		closeConnection(conn, stmt, null);
	}
	

	//close connection
	
	public static void closeConnection(Connection conn) {
		closeConnection(conn, null, null);
	}
	
	public static void main(String[] args) throws SQLException {
		String Q = "SELECT * FROM EMPLOYEE";
		
		//GET CONNECTION
		Connection conn = C3P0DataSourceConnection.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(Q);
		
		System.out.println("DB POOL CONNECTION");
		
			while(rs.next()) {
				System.out.println(rs.getString(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
				System.out.println(rs.getString(4));
				System.out.println(rs.getString(5));
				
			
		}
		//return connection to poll
		C3P0DataSourceConnection.closeConnection(conn, stmt,  rs);
	}
}

	

	



		
	

	

	
