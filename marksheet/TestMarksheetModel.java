package in.com.raystec.marksheet;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestMarksheetModel {
	
	//NextPk method
	public static int nextPk() throws Exception {
		//load driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//create connection
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/raystec","root","root");
		
		//create statement
		int pk = 0;
		PreparedStatement pstmt = conn.prepareStatement("SELECT MAX(ID) FROM MARKSHEET");
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			pk = rs.getInt(1);
		}
		return pk + 1;
	}
	
	private static void testAdd() throws Exception {
		
		//creating object of bean class
		MarksheetBean bean = new MarksheetBean();
		
		//setting values
		bean.setId(nextPk());
		bean.setRollno("113");
		bean.setFname("RAVI");
		bean.setLname("KUMAR");
		bean.setPhy(56);
		bean.setChe(56);
		bean.setMat(56);
		
		//creating object of Marksheetmodel class
		MarksheetModel mm = new MarksheetModel();
		mm.add(bean);
		
		System.out.println("Inserted..........");
		
	}
	
	private static void testUpdate() throws Exception {
		//creating object of bean class
		MarksheetBean bean = new MarksheetBean();
		
		//setting values
		bean.setId(7);
		bean.setRollno(bean.getRollno());
		bean.setFname(bean.getFname());
		bean.setLname("KUMAR");
		bean.setPhy(bean.getPhy());
		bean.setChe(bean.getChe());
		bean.setMat(bean.getMat());
		
		
		//creating object of Marksheetmodel class
		MarksheetModel mm = new MarksheetModel();
		mm.update(bean);
		
		System.out.println("Inserted..........");
		
	}
	
	private static void testDelete() throws Exception {
		//creating object of bean class
				MarksheetBean bean = new MarksheetBean();
				
				//setting values
				bean.setRollno("113");
				
				//creating object of Marksheetmodel class
				MarksheetModel mm = new MarksheetModel();
				mm.get(bean);
				
				System.out.println("deleted..........");
		
	}
	
	private static void testGet() throws Exception {
		//creating object of bean class
		MarksheetBean bean = new MarksheetBean();
		
		//setting values
		bean.setRollno("112");
		
		//creating object of Marksheetmodel class
		MarksheetModel mm = new MarksheetModel();
		mm.get(bean);
		
		System.out.print("ID") ;
		System.out.print("\tROLL NO");
		System.out.print("\t FNAME");
		System.out.print("\tLNAME");
		System.out.print("\tPHYSICS");
		System.out.print("\tCHEMISTRY");
		System.out.print("\tMATH");
		System.out.println();
		System.out.print(bean.getId()) ;
		System.out.print("\t"+bean.getRollno());
		System.out.print("\t "+bean.getFname());
		System.out.print("\t"+bean.getLname());
		System.out.print("\t"+bean.getPhy());
		System.out.print("\t"+bean.getChe());
		System.out.print("\t"+bean.getMat());

	}
	
	private static void testGetMeritList() throws Exception {
		//creating object of bean class
				//MarksheetBean bean = new MarksheetBean();
				
				//creating object of Marksheetmodel class
				MarksheetModel mm = new MarksheetModel();
				List l1  = mm.getMeritList();
				Iterator it = l1.iterator();
				
				while(it.hasNext()) {
					MarksheetBean bean = (MarksheetBean)it.next();
					System.out.print("\t" +bean.getId());
					System.out.println("\t"+bean.getRollno());
					System.out.print("\t"+bean.getFname());
					System.out.print("\t"+bean.getLname());
					System.out.print("\t"+bean.getPhy());
					System.out.print("\t"+bean.getChe());
					System.out.print("\t"+bean.getMat());
					System.out.println();
				}
				
	}
				
			
	private static void testSearch() throws Exception {
		//creating object of bean class
		MarksheetModel mm = new MarksheetModel();
		mm.search();
	
	}
	
	//main method
	public static void main(String[] args)throws Exception {
		//testAdd();
		testUpdate();
		//testDelete();
		//testGet();
		//testGetMeritList();
		//testSearch();
	}

	
	

	

	

	



	
}
