package in.com.raystec.jdbc;

import java.sql.*;

public class testMetaData {
	public static void main(String[] args)throws Exception {
		
	
	//load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
	//create connection
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/raystec", "root", "root");
			
	//create statement
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM EMPLOYEE");
			ResultSetMetaData rsmt = rs.getMetaData();
			
			System.out.println("Catelog Name : " + rsmt.getCatalogName(1));
			System.out.println("Table Name : " + rsmt.getTableName(1));
			
			
			
	//manipulate statement
			int columnCount = rsmt.getColumnCount();
			System.out.println("Total Columns "+ columnCount);
			System.out.println();
			
			
			for(int i = 1; i<= columnCount; i++) {
				System.out.println("Column : " +(i));
				System.out.println("Label : " + rsmt.getColumnLabel(i));
				System.out.println("Name : " + rsmt.getColumnName(i));
				System.out.println("Type : " + rsmt.getColumnTypeName(i));
				System.out.println("Size : " + rsmt.getColumnDisplaySize(i));
				System.out.println("Precision : " + rsmt.getPrecision(i));
				System.out.println();
				
			}
			
				
	//close connection
				
				rs.close();
				stmt.close();
				conn.close();
			
			
				
			}
}

