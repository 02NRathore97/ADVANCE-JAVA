package in.com.raystec.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class TestPstmtCRUD {
	
    	public static void main(String[] args) throws Exception{
			
			// testGetById(2);
			 //testSelect();
			 testSelectAll();
			// testUpdate();
			 //testAdd();
			 //testDelete();
			 
    	}
				public static void testGetById(int i){
					//load the driver
					
					try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					//create connection
					Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/raystec", "root", "root");
					
					
					//using method to create connection
					//Connection conn = testConnectionProvider.getConnection();	
						
					//create statement
					PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM EMPLOYEE WHERE EMP_ID = ?");
					pstmt.setInt(1, i);
					ResultSet rs = pstmt.executeQuery();
					
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
						pstmt.close();
						conn.close();
					}
					catch(Exception e) {
						e.printStackTrace();
					}
						
				  }

				public static void testSelect() throws Exception{
					//load the driver
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					//create connection
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/raystec", "root", "root");
					
					//create statement
					
					String Q = "SELECT * FROM EMPLOYEE WHERE EMP_ID = ?";
					PreparedStatement Pstmt = conn.prepareStatement(Q);
					Pstmt.setInt(1,3);
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
				public static void testSelectAll() throws Exception{
					//load the driver
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					//create connection
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/raystec", "root", "root");
					
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
				
				public static void testUpdate() throws Exception{
					//load the driver
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					//create connection
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/raystec", "root", "root");
					
					//create statement
					
					String Q = "UPDATE EMPLOYEE SET SALARY = 26000 WHERE EMP_ID = 7";
					PreparedStatement Pstmt = conn.prepareStatement(Q);
					int i = Pstmt.executeUpdate();
					
					System.out.println(i + " INSERTED.......");
					
					
						
					//close connection
						
						
						Pstmt.close();
						conn.close();
					}
				public static void testAdd() throws Exception{
					//load the driver
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					//create connection
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/raystec", "root", "root");
					
					//create statement
					
					String Q = "INSERT INTO EMPLOYEE VALUES(7, 'VINOD', 'RATHORE',20000 ,3)";
					PreparedStatement pstmt = conn.prepareStatement(Q);
					int i = pstmt.executeUpdate();
					
					//manipulate statement
					
					System.out.println(i+" Inserted");
						
					//close connection
						
						
						pstmt.close();
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
					PreparedStatement pstmt = conn.prepareStatement(Q);
					int i = pstmt.executeUpdate();
					
					//manipulate statement
					
					System.out.println(i+" UPDATE IS SUCCESSFULL IN DATABASE........");
						
					//close connection
						
						
						pstmt.close();
						conn.close();
					}
				
		}

