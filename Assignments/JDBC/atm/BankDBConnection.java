package atm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import books.Author;

public class BankDBConnection {
	public static double getBalance(Account account) {
		//public static void main(String[] args) {
		   boolean bFound = false;
		   double balance=0;
	        String connectionUrl =
	                "jdbc:sqlserver://CHE-2V4WMV2\\SQLEXPRESS:50232"
	                        + ";database=Bank"
	                        + ";integratedSecurity=true";
	        
	        ResultSet resultSet = null;

	        try (Connection connection = DriverManager.getConnection(connectionUrl);        		
	        		Statement statement = connection.createStatement();) {
	        	// Create and execute a SELECT SQL statement.
	        	String selectSql = "select * from account where accountNumber  = "+account.getAccountNumber();
	            resultSet = statement.executeQuery(selectSql);
	            while (resultSet.next()) {
	            	bFound = true;
	            	 System.out.println("Balance - > "+resultSet.getString("Balance"));
	            	 account.setBalance(Double.parseDouble(resultSet.getString("Balance")));		         	  
	            	 System.out.println("--------------------------------------------------");
	            	 balance = account.getBalance();
	            	 
	            }
	            if (!(bFound)) {
	            	throw new SQLException("Unable to get balance. Contact Customer Service!");
	            }
	        }
	        // Handle any errors that may have occurred.
	        catch (SQLException e) {	        	
	            e.printStackTrace();
	            
	        }
	        return balance;
	    }
	
	public static boolean validate(Account account, boolean accountOnly) {
		//public static void main(String[] args) {
		   boolean bFound = false;
		   boolean bSuccess = false;
	        String connectionUrl =
	                "jdbc:sqlserver://CHE-2V4WMV2\\SQLEXPRESS:50232"
	                        + ";database=Bank"
	                        + ";integratedSecurity=true";
	        
	        ResultSet resultSet = null;

	        try (Connection connection = DriverManager.getConnection(connectionUrl);        		
	        		Statement statement = connection.createStatement();) {
	        	// Create and execute a SELECT SQL statement.
	        	String selectSql = "select * from account where accountNumber = "+account.getAccountNumber();
	            resultSet = statement.executeQuery(selectSql);
	            while (resultSet.next()) {
	            	bFound = true;
	            	 System.out.println("Logging into Account...");
	            	 
	            }
	            if (!(bFound)) {
	            	throw new SQLException("Invalid Account Number entered!. Please provide a valid Account Number");
	            }
	            	                       
	            if(!(accountOnly)) {
	            	
	            	selectSql = "select * from account where accountNumber = "+account.getAccountNumber()+" and AccountPIN = "+account.getAccountPIN();
		            
		            resultSet = statement.executeQuery(selectSql);
		            bFound = false;
		            
		            while (resultSet.next()) {
		            	bFound = true;
		            	 System.out.println("Login Successful!");
		            	 bSuccess=true;
		            }
		            if (!(bFound)) {
		            	throw new SQLException("Invalid PIN entered! Please provide a valid PIN!");
		            }
	            }
	            else {
	            	bSuccess=true;
	            }
	            
	        }
	        // Handle any errors that may have occurred.
	        catch (SQLException e) {
	        	System.out.println("Login Failed!");
	            e.printStackTrace();
	            
	        }
	        return bSuccess;
	    }
	public static void manageAmount(Account account, double amount, boolean isCredit, boolean isTransfer) {
		//public static void main(String[] args) {
		   boolean bFound = false;
		   double balance=0;
		   String typeMessage = "";
	        String connectionUrl =
	                "jdbc:sqlserver://CHE-2V4WMV2\\SQLEXPRESS:50232"
	                        + ";database=Bank"
	                        + ";integratedSecurity=true";
	        BankDBConnection.getBalance(account);
	        ResultSet resultSet = null;

	        try (Connection connection = DriverManager.getConnection(connectionUrl);        		
	        		Statement statement = connection.createStatement();) {
	        	// Create and execute a SELECT SQL statement.
	        /*	String selectSql = "select * from account where accountNumber  = "+account.getAccountNumber();
	            resultSet = statement.executeQuery(selectSql);
	            while (resultSet.next()) {
	            	bFound = true;
	            	 System.out.println("Old Balance : "+resultSet.getString("Balance"));
	            	 System.out.println("Amount Withdrawn : "+amount);
	            	 balance = account.getBalance()-amount;
	            	 account.setBalance(balance);
	            	 System.out.println("New Balance : "+balance);	            	 
	            	 System.out.println("--------------------------------------------------");
	            }
	            if (!(bFound)) {
	            	throw new SQLException("Unable to perform action. Contact Customer Service!");
	            } */
	        	if (!(isCredit)){
	        		balance = account.getBalance()-amount;
	        		typeMessage = "Debited";
	        	}
	        	else {
	        		balance = account.getBalance()+amount;
	        		typeMessage = "Credited";
	        	}
	        	
	            String UpdateSqlBalance = "Update account set balance = '"+balance+"' where accountNumber  = "+account.getAccountNumber();
		    	   int cnt = statement.executeUpdate(UpdateSqlBalance);
		    	   if(cnt==0) {
		    		   throw new SQLException("Unable to perform action. Contact Customer Service!");
		    	   }
		    	   else {
		    		   if (!(isTransfer)) {
		    			   System.out.println("Old Balance : "+account.getBalance());
			    		   System.out.println("Amount "+typeMessage+" : "+amount);
			    		   
			            	 account.setBalance(balance);
			            	 System.out.println("New Balance : "+balance);   
		    		   }		    		  
		            	 System.out.println("Action Completed Successfully!");
		            	 System.out.println("----------------------------------");
		    	   }    	            
	        }
	        // Handle any errors that may have occurred.
	        catch (SQLException e) {	        	
	            e.printStackTrace();
	            
	        }
	    }
	
	 public static void insertTransaction(Account a, double transactionAmount, String transactionType) {
		 //public static void main(String[] args) {	
		 int transactiontypeid = 0;
		 if(transactionType.toLowerCase().equals("credit")) {
			 transactiontypeid=1;
		 }
		 else if (transactionType.toLowerCase().equals("debit")) {
			 transactiontypeid=2;
			 transactionAmount = -transactionAmount;			 
		 }
		 double accountID=0;
		   String connectionUrl =
		                "jdbc:sqlserver://CHE-2V4WMV2\\SQLEXPRESS:50232"
		                        + ";database=Bank"
		                        + ";integratedSecurity=true";
		        
		   ResultSet resultSet = null;
	       try (Connection connection = DriverManager.getConnection(connectionUrl);        		
	    		   Statement statement = connection.createStatement();) {
		        	// Create and execute a INSERT SQL statement.
	    	   String SelectSqlAuthor = "SELECT * from Account where AccountNumber = '"+a.getAccountNumber()+"'";    	   
	    	   resultSet = statement.executeQuery(SelectSqlAuthor);    	   
	    	   while (resultSet.next()) {	     
	    		   accountID = Integer.parseInt(resultSet.getString("ID"));
	    	   }
	    	   if(accountID==0) {    		   
	    		   throw new SQLException("Account does not exist in system.");
	    	   }
	    	   
	    	   String insertSql = "insert into Transactions (AccountID, TransactionTypeID, Amount)" + 
	    	   		"values ("+accountID+","+transactiontypeid+", "+transactionAmount+")";	  
	    	   
	    	   		statement.executeUpdate(insertSql);		            
		            System.out.println("--------------------------------------------------");
		        }
		        // Handle any errors that may have occurred.
		        catch (SQLException e) {
		        	System.out.println("Unable to Add Transaction!");
		            e.printStackTrace();
		        }
   }
	 
	 public static Customer getCustomerInformation(Account account) {
			//public static void main(String[] args) {
		 Customer customer =new Customer();
			   boolean bFound = false;
			   double balance=0;
			   String customerName = "";
			   long customerPhone = 0;
			   String customerEmail = "";
		        String connectionUrl =
		                "jdbc:sqlserver://CHE-2V4WMV2\\SQLEXPRESS:50232"
		                        + ";database=Bank"
		                        + ";integratedSecurity=true";
		        
		        ResultSet resultSet = null;

		        try (Connection connection = DriverManager.getConnection(connectionUrl);        		
		        		Statement statement = connection.createStatement();) {
		        	// Create and execute a SELECT SQL statement.
		        	String selectSql = "select * from customer where id in (select customerid from account where AccountNumber = "+account.getAccountNumber()+")";
		            resultSet = statement.executeQuery(selectSql);
		            while (resultSet.next()) {	     
		            	customerName = resultSet.getString("Name");
		            	customer.setName(customerName);
		            	customerPhone = Long.parseLong(resultSet.getString("PhoneNo"));
		            	customer.setPhoneNumber(customerPhone);
		            	customerEmail = resultSet.getString("Email");
		            	customer.setEmailID(customerEmail);
		            	bFound=true;
			    	   }
		            if (!(bFound)) {
		            	throw new SQLException("Unable to get Customer Details. Contact Customer Service!");
		            }
		        }
		        // Handle any errors that may have occurred.
		        catch (SQLException e) {	        	
		            e.printStackTrace();
		            
		        }
		        return customer;
		    }
	 
	 public static void updateCustomerPhone (Account a, long newPhoneNumber) {
		 //public static void main(String[] args) {	   
		 int customerID = 0;
		   String connectionUrl =
		                "jdbc:sqlserver://CHE-2V4WMV2\\SQLEXPRESS:50232"
		                        + ";database=Bank"
		                        + ";integratedSecurity=true";		        
		   ResultSet resultSet = null;
	       try (Connection connection = DriverManager.getConnection(connectionUrl);        		
	    		   Statement statement = connection.createStatement();) {
		        	// Create and execute a Update SQL statement.
	    	   String SelectSqlAuthor = "SELECT * from Account where AccountNumber = '"+a.getAccountNumber()+"'";    	   
	    	   resultSet = statement.executeQuery(SelectSqlAuthor);    	   
	    	   while (resultSet.next()) {	     
	    		   customerID = Integer.parseInt(resultSet.getString("CustomerID"));
	    	   }
	    	   if(customerID==0) {    		   
	    		   throw new SQLException("Unable to get Customer Details. Contact Customer Care!");
	    	   }
	    	   
	    	   String UpdateSqlBook = "Update customer set PhoneNo = "+newPhoneNumber+" where ID = "+customerID+"";
	    	   int cnt = statement.executeUpdate(UpdateSqlBook);
	    	   if(cnt==0) {
	    		   throw new SQLException("Unable to update Customer Phone Number. Contact Customer Care!");
	    	   }
	    	   else {
	    		   System.out.println("Customer Phone Number Updated Successfully!");
		            System.out.println("----------------------------------");
	    	   }    
	       }
		        // Handle any errors that may have occurred.
	       catch (SQLException e) {
	    	   e.printStackTrace();
	       }
   }
	 
	 public static void updateCustomerEmail (Account a, String newEmail) {
		 //public static void main(String[] args) {	   
		 int customerID = 0;
		   String connectionUrl =
		                "jdbc:sqlserver://CHE-2V4WMV2\\SQLEXPRESS:50232"
		                        + ";database=Bank"
		                        + ";integratedSecurity=true";		        
		   ResultSet resultSet = null;
	       try (Connection connection = DriverManager.getConnection(connectionUrl);        		
	    		   Statement statement = connection.createStatement();) {
		        	// Create and execute a Update SQL statement.
	    	   String SelectSqlAuthor = "SELECT * from Account where AccountNumber = '"+a.getAccountNumber()+"'";    	   
	    	   resultSet = statement.executeQuery(SelectSqlAuthor);    	   
	    	   while (resultSet.next()) {	     
	    		   customerID = Integer.parseInt(resultSet.getString("CustomerID"));
	    	   }
	    	   if(customerID==0) {    		   
	    		   throw new SQLException("Unable to get Customer Details. Contact Customer Care!");
	    	   }
	    	   
	    	   String UpdateSqlBook = "Update customer set Email = '"+newEmail+"' where ID = "+customerID+"";
	    	   int cnt = statement.executeUpdate(UpdateSqlBook);
	    	   if(cnt==0) {
	    		   throw new SQLException("Unable to update Customer Email. Contact Customer Care!");
	    	   }
	    	   else {
	    		   System.out.println("Customer Email Updated Successfully!");
		            System.out.println("----------------------------------");
	    	   }    
	       }
		        // Handle any errors that may have occurred.
	       catch (SQLException e) {
	    	   e.printStackTrace();
	       }
   }

}
