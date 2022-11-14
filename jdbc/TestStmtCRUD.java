package in.com.raystec.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestStmtCRUD {
	public static void main(String[] args) throws Exception{
		
		testSelect();
		//testAdd();
		//testUpdate();
		//testDelete();
		//testAddByDynamicStatement();
		
	}
	
	

	public static void testSelect() throws Exception{
		//load the driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//create connection
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/raystec", "root", "root");
		
		//create statement
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM EMPLOYEE");
		
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
			stmt.close();
			conn.close();
		
			
		}
	
	public static void testAdd() throws Exception{
		//load the driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//create connection
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/raystec", "root", "root");
		
		//create statement
		Statement stmt = conn.createStatement();
		int i = stmt.executeUpdate("INSERT INTO EMPLOYEE VALUES(7, 'VINOD', 'RATHORE',20000 ,3)");
		
		//manipulate statement
		
		System.out.println(i+" Inserted");
			
		//close connection
			
			
			stmt.close();
			conn.close();
		
			
		}
	
	public static void testUpdate() throws Exception{
		//load the driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//create connection
		
		String url = "jdbc:mysql://localhost:3306/raystec";
		String username = "root";
		String password = "root";
		
		Connection conn = DriverManager.getConnection(url,username ,password );
		
		//create query
		String Q = "UPDATE EMPLOYEE SET SALARY = 25000 WHERE EMP_ID = 7";
		
		//create statement
		Statement stmt = conn.createStatement();
		int i = stmt.executeUpdate(Q);
		
		//manipulate statement
		
		System.out.println(i+" UPDATE IS SUCCESSFULL IN DATABASE........");
			
		//close connection
			
			
			stmt.close();
			conn.close();
		}
	
	public static void testDelete() throws Exception{
		//load the driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//create connection
		
		String url = "jdbc:mysql://localhost:3306/raystec";
		String username = "root";
		String password = "root";
		
		Connection conn = DriverManager.getConnection(url,username ,password );
		
		//create query
		String Q = "DELETE FROM EMPLOYEE WHERE EMP_ID = 7";
		
		//create statement
		Statement stmt = conn.createStatement();
		int i = stmt.executeUpdate(Q);
		
		//manipulate statement
		
		System.out.println(i+" UPDATE IS SUCCESSFULL IN DATABASE........");
			
		//close connection
			
			
			stmt.close();
			conn.close();
		}
	
	
	public static void testAddByDynamicStatement() throws Exception {
		
	//load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//create connection
			
			String url = "jdbc:mysql://localhost:3306/raystec";
			String username = "root";
			String password = "root";
			
			Connection conn = DriverManager.getConnection(url,username ,password );
			
			//create query
			
			int EMP_ID = 8;
			String FNAME = "AMIT";
			String LNAME = "RATHORE";
			int SALARY = 30000;
			int DEPT_ID = 4;
			
			
			String Q = "INSERT INTO EMPLOYEE VALUES("+EMP_ID+", '"+FNAME+"', '"+LNAME+"', "+SALARY+", "+DEPT_ID+")";
			
			
			//create statement
			Statement stmt = conn.createStatement();
			int i = stmt.executeUpdate(Q);
			
			//manipulate statement
			
			System.out.println(i+" UPDATE IS SUCCESSFULL IN DATABASE........");
				
			//close connection
				
				
				stmt.close();
				conn.close();
		
		
	}
	

	}

	


