package employee;

import java.awt.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ListIterator;
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
	            		+ "SalaryAmount, "
	            		+ "BonusAmount) values ( "
	            		+ "getdate(),?, ?,0 )");
	            
	            Iterator<Entry<Integer, Double>> it = myMap.entrySet().iterator();
	            
	            while (it.hasNext()) {
	                Map.Entry<Integer,Double> pairs = (Map.Entry<Integer,Double>)it.next();
	                stmt.setInt(1, pairs.getKey());	                
	                stmt.setDouble(2, pairs.getValue());	                
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
	
	public static void viewMonthlySalary() {
		
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
	        	String selectSql = "select m.ID,e.EmployeeUID,e.Name,t.Type,m.SalaryAmount,m.BonusAmount,CONVERT(varchar,m.date,100) as date from Employee e" + 
	        			" Inner join MonthlySalary m " + 
	        			" on e.ID = m.EmployeeID"+
	        			" Inner Join EmployeeType t" +
	        			" on" +
	        			" t.ID = e.EmployeeTypeID" +
	        			" where m.date in (select MAX(Date) as myDate from MonthlySalary GROUP BY EmployeeID )";
	            resultSet = statement.executeQuery(selectSql);	
	            while (resultSet.next()) {            	
	            	bFound = true;     
		            System.out.println("----------------------------------");
	            	System.out.println("Employee UID --> " + resultSet.getString("EmployeeUID"));
	            	System.out.println("Employee Name --> " + resultSet.getString("Name"));
	            	System.out.println("Employee Type --> " + resultSet.getString("Type"));
	            	System.out.println("Salary Amount --> " + resultSet.getString("SalaryAmount"));
	            	System.out.println("Bonus Amount --> " + resultSet.getString("BonusAmount"));
	            	System.out.println("Date --> " + resultSet.getString("date"));	            		            	 
	            }	            
	            System.out.println("----------------------------------");            
	            if (!(bFound)) {
	            	throw new SQLException ("No Salary information found ! ");
	            }
          	System.out.println("Action is successful!");
	        }
	        // Handle any errors that may have occurred.
	        catch (SQLException e) {	        	
	            e.printStackTrace();
	            
	        }
}
	
	public static void processDOBBonus() {
		
		 //public static void main(String[] args) {
		boolean bFound = false;
		double amount = 0;
		double bonus = 1000;
		ArrayList<Integer> myList = new ArrayList<Integer>();
		
		 int customerID = 0;
		   String connectionUrl =
		                "jdbc:sqlserver://CHE-2V4WMV2\\SQLEXPRESS:50232"
		                        + ";database=Employee"
		                        + ";integratedSecurity=true";		        
		   ResultSet resultSet = null;

	        try (Connection connection = DriverManager.getConnection(connectionUrl);        		
	        		Statement statement = connection.createStatement();) {
	        	// Create and execute a SELECT SQL statement.
	        	String selectSql = "select m.ID,e.EmployeeUID,e.Name,m.SalaryAmount from Employee e"
	        			+" Inner join MonthlySalary m"
	        			+" on e.ID = m.EmployeeID"
	        			+" where m.date in (select MAX(Date) as myDate from MonthlySalary"
	        			+" GROUP BY EmployeeID ) and  MONTH(e.DOB) = Month(getdate())";	        	
	            resultSet = statement.executeQuery(selectSql);
	            while (resultSet.next()) {            	
	            	bFound = true;	            	       	
	            	myList.add(Integer.parseInt(resultSet.getString("ID")));	            	
	            }
	            
	            if (!(bFound)) {
	            	throw new SQLException ("No Employees have their DOB this month!");
	            }
	            
	            PreparedStatement stmt = connection.prepareStatement("Update MonthlySalary set BonusAmount = BonusAmount + "+bonus+" where ID =  ?");
	            		
	            
	            ListIterator <Integer> it = myList.listIterator();
	            
	            while (it.hasNext()) {	                
	                stmt.setInt(1, it.next());               
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
	public static void processTypeAndSalesBonus(String employeeType, double salesThrehold) {
		
		 //public static void main(String[] args) {
		boolean bFound = false;
		double amount = 0;
		double bonus = 1000;
		ArrayList<Integer> myList = new ArrayList<Integer>();
		
		 int customerID = 0;
		   String connectionUrl =
		                "jdbc:sqlserver://CHE-2V4WMV2\\SQLEXPRESS:50232"
		                        + ";database=Employee"
		                        + ";integratedSecurity=true";		        
		   ResultSet resultSet = null;

	        try (Connection connection = DriverManager.getConnection(connectionUrl);        		
	        		Statement statement = connection.createStatement();) {
	        	// Create and execute a SELECT SQL statement.
	        	String selectSql = "select m.ID,e.EmployeeUID,e.Name,t.Type,m.SalaryAmount,m.BonusAmount,CONVERT(varchar,m.date,100) as date from Employee e"
	        			+ " Inner join MonthlySalary m"
	        			+ " on e.ID = m.EmployeeID"
	        			+ " Inner Join EmployeeType t"
	        			+ " on"
	        			+ " t.ID = e.EmployeeTypeID"
	        			+ " where m.date in (select MAX(Date) as myDate from MonthlySalary"
	        			+ " GROUP BY EmployeeID) and t.type = '"+employeeType+"' and m.EmployeeID in ("
	        			+ " select s.EmployeeID  from sales s"
	        			+ " inner join employee e"
	        			+ " on" 
	        			+ " e.id = s.EmployeeID"
	        			+ " where Month(s.date) = Month(getdate())" 
	        			+ " Group by s.EmployeeID"
	        			+ " Having SUM(s.Amount)>"+salesThrehold+")"
;
	        	System.out.println(selectSql);
	            resultSet = statement.executeQuery(selectSql);
	            while (resultSet.next()) {            	
	            	bFound = true;	            	       	
	            	myList.add(Integer.parseInt(resultSet.getString("ID")));           	 
	            }
	            
	            if (!(bFound)) {
	            	throw new SQLException ("No Employees found for processing bonus");
	            }
	            
	            PreparedStatement stmt = connection.prepareStatement("Update MonthlySalary set BonusAmount = BonusAmount + "+bonus+" where ID =  ?");
	            		
	            
	            ListIterator <Integer> it = myList.listIterator();
	            
	            while (it.hasNext()) {	                
	                stmt.setInt(1, it.next());               
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
}
