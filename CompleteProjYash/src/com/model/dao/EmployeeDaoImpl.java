package com.model.dao;
import java.sql.*;
import java.util.ArrayList;

import com.model.bean.Employee;

public class EmployeeDaoImpl implements EmployeeDAO{

	public ArrayList<Employee> displayAll() {
		ArrayList <Employee> emp_list= new ArrayList<Employee> ();
		// TODO Auto-generated method stub
		final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";  
		final String DB_URL = "jdbc:oracle:thin:@192.168.4.121:1521:orcl";
		final String USER = "hr";
	    final String PASS = "hr";
	    Connection conn = null;
	    PreparedStatement stmt = null;
	   
	    try{
	      //STEP 2: Register JDBC driver
	      Class.forName(JDBC_DRIVER);
	
	      //STEP 3: Open a connection
	      System.out.println("Connecting to database...");
	      conn = DriverManager.getConnection(DB_URL,USER,PASS);
	
	      //STEP 4: Execute a query
	      System.out.println("Creating statement...");
	      stmt = conn.prepareStatement("select * from Empl");
	      ResultSet rs = stmt.executeQuery();
	
	      //STEP 5: Extract data from result set
	      while(rs.next()){
	    	 Employee e = new Employee();
	         //Retrieve by column name
	         e.setID(rs.getInt("EMP_ID"));
	         e.setDepartment(rs.getString("DEPARTMENT"));
	         e.setName(rs.getString("NAME"));
	         e.setSalary(rs.getInt("SALARY"));
	         emp_list.add(e);
	      }
	      
	      conn.close();
	   }catch(SQLException se){     
	      se.printStackTrace();
	   }catch(Exception e){
	      e.printStackTrace();
	   }
	
	    return emp_list;
	}

	public Employee searchById(int Id) {
		// TODO Auto-generated method stub
		final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";  
		final String DB_URL = "jdbc:oracle:thin//192.168.4.121:1521:orcl";
		final String USER = "hr";
	    final String PASS = "hr";
	    Connection conn = null;
	    PreparedStatement stmt = null;
	    Employee e = null;
	    try{
	      //STEP 2: Register JDBC driver
	      Class.forName(JDBC_DRIVER);
	
	      //STEP 3: Open a connection
	      System.out.println("Connecting to database...");
	      conn = DriverManager.getConnection(DB_URL,USER,PASS);
	
	      //STEP 4: Execute a query
	      System.out.println("Creating statement...");
	      stmt = conn.prepareStatement("select * form Empl where id = ?");
	      stmt.setInt(1, Id);
	      ResultSet rs = stmt.executeQuery();
	
	      //STEP 5: Extract data from result set
	      e = new Employee();
	      while(rs.next()){
	         //Retrieve by column name
	         e.setID(rs.getInt("EMP_ID"));
	         e.setDepartment(rs.getString("DEPARTMENT"));
	         e.setName(rs.getString("NAME"));
	         e.setSalary(rs.getInt("SALARY"));
	      }

	      conn.close();
	    }catch(SQLException se){
	    	se.printStackTrace();
	    }catch(Exception ex){
	    	ex.printStackTrace();
	    }
	    return e;
	}

	public boolean insert(Employee Emp) {
		// TODO Auto-generated method stub
		final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";  
		final String DB_URL = "jdbc:oracle:thin//192.168.4.121:1521:orcl";
		final String USER = "hr";
	    final String PASS = "hr";
	    Connection conn = null;
	    PreparedStatement stmt = null;
	   
	   try{
	      //STEP 2: Register JDBC driver
	      Class.forName(JDBC_DRIVER);
	
	      //STEP 3: Open a connection
	      System.out.println("Connecting to database...");
	      conn = DriverManager.getConnection(DB_URL,USER,PASS);
	
	      //STEP 4: Execute a query
	      System.out.println("Creating statement...");
	      stmt = conn.prepareStatement("insert into Empl values (?,?,?,?)");
	      
	      stmt.setString(1,Emp.getName());  
	      stmt.setInt(2,Emp.getID());
	      stmt.setString(3,Emp.getDepartment());  
	      stmt.setInt(4,Emp.getSalary());
	      
	     
	      if(stmt.executeUpdate() > 0) {
	    	  return true;
	      } else {
	    	  return false;
	      }
	      
	   }catch(SQLException se){
	      se.printStackTrace();
	   }catch(Exception e){
	      e.printStackTrace();
	   }finally{
	      try {
	    	  conn.close();
	      } catch (SQLException e) {
	    	  e.printStackTrace();
	      }
	   }
	   return false;
	}

	public boolean delete(int Id) {
		// TODO Auto-generated method stub
				final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";  
				final String DB_URL = "jdbc:oracle:thin//192.168.4.121:1521:orcl";
				final String USER = "hr";
			    final String PASS = "hr";
			    Connection conn = null;
			    PreparedStatement stmt = null;
			   
			   try{
			      //STEP 2: Register JDBC driver
			      Class.forName(JDBC_DRIVER);
			
			      //STEP 3: Open a connection
			      System.out.println("Connecting to database...");
			      conn = DriverManager.getConnection(DB_URL,USER,PASS);
			
			      //STEP 4: Execute a query
			      System.out.println("Creating statement...");
			      stmt = conn.prepareStatement("delete from Empl where id = ?");
			      stmt.setInt(1, Id);
		
			     
			      if(stmt.executeUpdate() > 0) {
			    	  return true;
			      } else {
			    	  return false;
			      }
			      
			   }catch(SQLException se){
			      se.printStackTrace();
			   }catch(Exception e){
			      e.printStackTrace();
			   }finally{
			      try {
			    	  conn.close();
			      } catch (SQLException e) {
			    	  e.printStackTrace();
			      }
			   }
		return false;
	}

}
