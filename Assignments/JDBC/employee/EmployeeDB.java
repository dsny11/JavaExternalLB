package employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class EmployeeDB {
	public static void addSalaryRaise(String employeeType, double percentage) {
		
		 //public static void main(String[] args) {
		boolean bFound = false;
		double amount = 0;
	    HashMap<Integer, Double> myMap = new HashMap<Integer, Double>();
		
		 
		   String connectionUrl =
		                "jdbc:sqlserver://CHE-2V4WMV2\\SQLEXPRESS:50232"
		                        + ";database=Employee"
		                        + ";integratedSecurity=true";		        
		   ResultSet resultSet = null;

	        try (Connection connection = DriverManager.getConnection(connectionUrl);        		
	        		Statement statement = connection.createStatement();) {
	        	// Create and execute a SELECT SQL statement.
	        	String selectSql = "select * from salary where EmployeeID in (select ID from Employee where EmployeeTypeID in (select ID from EmployeeType where Type = '"+employeeType+"'))";
	            resultSet = statement.executeQuery(selectSql);
	            while (resultSet.next()) {	            	
	            	bFound = true;
	            	amount = Double.parseDouble((resultSet.getString("Amount")));
	            	amount = amount + (amount * (percentage/100));	            	
	            	myMap.put(Integer.parseInt(resultSet.getString("EmployeeID")), amount);	            	 
	            }
	            
	            if (!(bFound)) {
	            	throw new SQLException ("No Employee information found with type : " + employeeType);
	            }
	            
	            PreparedStatement stmt = connection.prepareStatement("update salary set Amount=? where EmployeeID = ?");
	            Iterator<Entry<Integer, Double>> it = myMap.entrySet().iterator();
	            
	            while (it.hasNext()) {
	                Map.Entry<Integer,Double> pairs = (Map.Entry<Integer,Double>)it.next();
	                stmt.setInt(2, pairs.getKey());
	                stmt.setDouble(1, pairs.getValue());	                
	                stmt.addBatch(); // this will just collect the data values
	                it.remove();
	            }	            
	            stmt.executeBatch();
            	System.out.println("Action is successful!");
	        }
	        // Handle any errors that may have occurred.
	        catch (SQLException e) {	        	
	            e.printStackTrace();
	            
	        }
	        
	        
  }
	
	public static void processSalary() {
		
		 //public static void main(String[] args) {
		boolean bFound = false;
		double amount = 0;
	    HashMap<Integer, Double> myMap = new HashMap<Integer, Double>();
		
		 int customerID = 0;
		   String connectionUrl =
		                "jdbc:sqlserver://CHE-2V4WMV2\\SQLEXPRESS:50232"
		                        + ";database=Employee"
		                        + ";integratedSecurity=true";		        
		   ResultSet resultSet = null;

	        try (Connection connection = DriverManager.getConnection(connectionUrl);        		
	        		Statement statement = connection.createStatement();) {
	        	// Create and execute a SELECT SQL statement.
	        	String selectSql = "select * from salary";
	            resultSet = statement.executeQuery(selectSql);
	            while (resultSet.next()) {            	
	            	bFound = true;	            	       	
	            	myMap.put(Integer.parseInt(resultSet.getString("EmployeeID")), Double.parseDouble((resultSet.getString("Amount"))));	            	 
	            }
	            
	            if (!(bFound)) {
	            	throw new SQLException ("No Salary information found ! ");
	            }
	            
	            PreparedStatement stmt = connection.prepareStatement("insert into MonthlySalary ("
	            		+ "Date,"
	            		+ "EmployeeID, "
	            		+ "SalaryAmount) values ( "
	            		+ "getdate(),?, ? ");
	            
	            Iterator<Entry<Integer, Double>> it = myMap.entrySet().iterator();
	            
	            while (it.hasNext()) {
	                Map.Entry<Integer,Double> pairs = (Map.Entry<Integer,Double>)it.next();
	                stmt.setInt(1, pairs.getKey());	                
	                stmt.setDouble(2, pairs.getValue());	                
	                stmt.addBatch(); // this will just collect the data values
	                it.remove();
	            }	            
	            System.out.println(stmt);

	            stmt.executeUpdate();
           	System.out.println("Action is successful!");
	        }
	        // Handle any errors that may have occurred.
	        catch (SQLException e) {	        	
	            e.printStackTrace();
	            
	        }
 }
}
