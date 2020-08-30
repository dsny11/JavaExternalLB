package books;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLDBConnection {
    // Connect to your database.
    // Replace server name, username, and password with your credentials
   public static void getAllBooks() {
	//public static void main(String[] args) {
	   boolean bFound = false;
        String connectionUrl =
                "jdbc:sqlserver://CHE-2V4WMV2\\SQLEXPRESS:50232"
                        + ";database=Books"
                        + ";integratedSecurity=true";
        
        ResultSet resultSet = null;

        try (Connection connection = DriverManager.getConnection(connectionUrl);        		
        		Statement statement = connection.createStatement();) {
        	// Create and execute a SELECT SQL statement.
        	String selectSql = "select * from books b inner join Author a on a.id = b.authorid";
            resultSet = statement.executeQuery(selectSql);

            // Print results from select statement
            System.out.println("List of Books : ");
            System.out.println("--------------------------------------------------");

            while (resultSet.next()) {
            	bFound = true;
            	 System.out.println("Title - > "+resultSet.getString("Title"));
	         	   System.out.println("ISBNCode - > "+resultSet.getString("ISBNCode"));
	         	   System.out.println("AuthorName - > "+resultSet.getString("Name"));
	         	  System.out.println("AuthorUID - > "+resultSet.getString("AuthorUID"));
	         	  System.out.println("--------------------------------------------------");
            }
            if (!(bFound)) {
            	throw new SQLException("No Books found !");
            }
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
        	System.out.println("Unable to get all books information");
            e.printStackTrace();
            
        }
    }
   
   public static void getBookDetailsByName(String bookName) {
		//public static void main(String[] args) {	
	   boolean bFound = false; 
	   String connectionUrl =
	                "jdbc:sqlserver://CHE-2V4WMV2\\SQLEXPRESS:50232"
	                        + ";database=Books"
	                        + ";integratedSecurity=true";
	        
	   ResultSet resultSet = null;
       try (Connection connection = DriverManager.getConnection(connectionUrl);        		
    		   Statement statement = connection.createStatement();) {
	        	// Create and execute a SELECT SQL statement.
    	   String selectSql = "select * from books b inner join Author a on a.id = b.authorid where b.Title = '"+bookName+"'";
    	   		resultSet = statement.executeQuery(selectSql);
	            // Print results from select statement    	   		
	            System.out.println("Book Details : ");
	            System.out.println("--------------------------------------------------");
	            
	            while (resultSet.next()) {
	            	bFound=true;
	         	   System.out.println("Title - > "+resultSet.getString("Title"));
	         	   System.out.println("ISBNCode - > "+resultSet.getString("ISBNCode"));
	         	   System.out.println("AuthorName - > "+resultSet.getString("Name"));
	         	  System.out.println("AuthorUID - > "+resultSet.getString("AuthorUID"));
	         	  System.out.println("--------------------------------------------------");	         	   
	            }
	            if (!(bFound)) {
	            	throw new SQLException("No Books found by name : " + bookName);
	            }
	        }
	        // Handle any errors that may have occurred.
	        catch (SQLException e) {
	        	System.out.println("Unable to get information for bookName : "+bookName);
	            e.printStackTrace();
	        }
	    }
   
   public static void addBook(Books b) {
	 //public static void main(String[] args) {	
	   int authorID = 0;
	   String connectionUrl =
	                "jdbc:sqlserver://CHE-2V4WMV2\\SQLEXPRESS:50232"
	                        + ";database=Books"
	                        + ";integratedSecurity=true";
	        
	   ResultSet resultSet = null;
       try (Connection connection = DriverManager.getConnection(connectionUrl);        		
    		   Statement statement = connection.createStatement();) {
	        	// Create and execute a SELECT SQL statement.
    	   String SelectSql = "select * from books where ISBNCode = '"+b.getIsbnCode()+"'";  
    	   resultSet = statement.executeQuery(SelectSql);   	   
    	   if (resultSet.next()) {
    		   throw new SQLException("ISBNCode already exists for another Book. Please provide a valid ISBNCode!");
    	   }
    	   
    	   String SelectSqlAuthor = "SELECT * from Author where AuthorUID = '"+b.getAuthorUID()+"'";    	   
    	   resultSet = statement.executeQuery(SelectSqlAuthor);    	   
    	   while (resultSet.next()) {	     
    		   authorID = Integer.parseInt(resultSet.getString("ID"));
    	   }
    	   if(authorID==0) {    		   
    		   throw new SQLException("AuthorUID does not exist in system. Add 'Author' information and then try adding 'Book' information!");
    	   }
    	   
    	   
    	   
    	   String insertSql = "insert into Books (Title, ISBNCode, AuthorID)" + 
    	   		"values ('"+b.getTitle()+"','"+b.getIsbnCode()+"', '"+authorID+"')";   	   		
	            // Print results from select statement    	   
    	   		statement.executeUpdate(insertSql);
	            System.out.println("Book Added Successfully!");
	            System.out.println("--------------------------------------------------");
	        }
	        // Handle any errors that may have occurred.
	        catch (SQLException e) {
	        	System.out.println("Unable to add book");
	            e.printStackTrace();
	        }
   }
   
   public static void deleteBookByName(String bookName) {
		 //public static void main(String[] args) {	   
		   String connectionUrl =
		                "jdbc:sqlserver://CHE-2V4WMV2\\SQLEXPRESS:50232"
		                        + ";database=Books"
		                        + ";integratedSecurity=true";		        
		   
	       try (Connection connection = DriverManager.getConnection(connectionUrl);        		
	    		   Statement statement = connection.createStatement();) {
		        	// Create and execute a DELETE SQL statement.
	    	   
	    	   String DeleteSqlBook = "delete from books where title = '"+bookName+"'";
	    	   int cnt = statement.executeUpdate(DeleteSqlBook);	    	      	   
	    	   if (cnt==0) {
	    		   throw new SQLException("Book with provided name does not exist. Please provide a valid Book Name!");
	    	   }
		            System.out.println("Book Deleted Successfully!");
		            System.out.println("--------------------------------------------------");
		        }
		        // Handle any errors that may have occurred.
		        catch (SQLException e) {
		        	System.out.println("Unable to Delete book: "+ bookName);
		            e.printStackTrace();
		        }
   }
   
   public static void addAuthor(Author a) {
		 //public static void main(String[] args) {	
		   String connectionUrl =
		                "jdbc:sqlserver://CHE-2V4WMV2\\SQLEXPRESS:50232"
		                        + ";database=Books"
		                        + ";integratedSecurity=true";
		        
		   ResultSet resultSet = null;
	       try (Connection connection = DriverManager.getConnection(connectionUrl);        		
	    		   Statement statement = connection.createStatement();) {
		        	// Create and execute a INSERT SQL statement.
	    	   String SelectSqlAuthor = "select * from Author where AuthorUID = '"+a.getAuthorUID()+"'";  
	    	   resultSet = statement.executeQuery(SelectSqlAuthor);   	   
	    	   if (resultSet.next()) {
	    		   throw new SQLException("AuthorUID already exists for another Author. Please provide a valid AuthorUID!");
	    	   }
	    	   String insertSql = "insert into Author (AuthorUID, Name, Email)" + 
	    	   		"values ('"+a.getAuthorUID()+"','"+a.getAuthorName()+"', '"+a.getAuthorEmail()+"')";	              	   
	    	   		statement.executeUpdate(insertSql);
		            System.out.println("Author Added Successfully!");
		            System.out.println("--------------------------------------------------");
		        }
		        // Handle any errors that may have occurred.
		        catch (SQLException e) {
		        	System.out.println("Unable to Add Author");
		            e.printStackTrace();
		        }
   }
   public static void deleteAuthorByUID(String authorUID) {
		 //public static void main(String[] args) {	   
		   String connectionUrl =
		                "jdbc:sqlserver://CHE-2V4WMV2\\SQLEXPRESS:50232"
		                        + ";database=Books"
		                        + ";integratedSecurity=true";		        
		   ResultSet resultSet = null;
	       try (Connection connection = DriverManager.getConnection(connectionUrl);        		
	    		   Statement statement = connection.createStatement();) {
		        	// Create and execute a DELETE SQL statement.
	    	   
	    	   String SelectSqlAuthor = "select * from books where AuthorID in (Select ID from Author where AuthorUID = '"+authorUID+"')";    	   
	    	   resultSet = statement.executeQuery(SelectSqlAuthor);    	   
	    	   while (resultSet.next()) {	     
	    		   throw new SQLException("Author has existing Books. Delete associated 'Books' and then try deleting 'Author' information!");
	    	   }   
	    	   
	    	   String DeleteSqlAuthor = "delete from author where AuthorUID = '"+authorUID+"'";
	    	   int cnt = statement.executeUpdate(DeleteSqlAuthor);   	   
	    	   if (cnt==0) {
	    		   throw new SQLException("Unable to find Author. Please provide a valid AuthorUID!");
	    	   }
	    	  else {
	    		  System.out.println("Author Deleted Successfully!");
	    		  System.out.println("--------------------------------------------------");
	    	  }
		          
	       }
		        // Handle any errors that may have occurred.
	       catch (SQLException e) {
	    	   System.out.println("Unable to Delete Author with UID: " + authorUID);
	    	   e.printStackTrace();
	       }
   }
   public static void getAllAuthors() {
	   boolean bFound = false;
		//public static void main(String[] args) {
	        String connectionUrl =
	                "jdbc:sqlserver://CHE-2V4WMV2\\SQLEXPRESS:50232"
	                        + ";database=Books"
	                        + ";integratedSecurity=true";
	        
	        ResultSet resultSet = null;

	        try (Connection connection = DriverManager.getConnection(connectionUrl);        		
	        		Statement statement = connection.createStatement();) {
	        	// Create and execute a SELECT SQL statement.
	        	String selectSql = "select * from author ";
	            resultSet = statement.executeQuery(selectSql);

	            // Print results from select statement	            
	            System.out.println("List of Authors : ");
	            System.out.println("--------------------------------------------------");

	            while (resultSet.next()) {
	            	bFound=true;
	            	System.out.println("Author Name - > "+resultSet.getString("Name"));
	            	System.out.println("Author UID - > "+resultSet.getString("AuthorUID"));
	            	System.out.println("Author Email - > "+resultSet.getString("Email"));		         	  
	            	System.out.println("--------------------------------------------------");
	            }
	            if (!(bFound)) {
	            	throw new SQLException("No Authors found !");
	            }
	        }
	        // Handle any errors that may have occurred.
	        catch (SQLException e) {
	            e.printStackTrace();
	        }
   }
   public static void getAuthorDetailsByName(String authorName) {
		//public static void main(String[] args) {
	   boolean bFound = false;
	        String connectionUrl =
	                "jdbc:sqlserver://CHE-2V4WMV2\\SQLEXPRESS:50232"
	                        + ";database=Books"
	                        + ";integratedSecurity=true";
	        
	        ResultSet resultSet = null;

	        try (Connection connection = DriverManager.getConnection(connectionUrl);        		
	        		Statement statement = connection.createStatement();) {
	        	// Create and execute a SELECT SQL statement.
	        	String selectSql = "select * from author where name = '"+authorName+"' ";
	            resultSet = statement.executeQuery(selectSql);
	            // Print results from select statement	            	            
	            System.out.println("--------------------------------------------------");	           
	            while (resultSet.next()) {
	            	bFound=true;
	            	System.out.println("Author Name - > "+resultSet.getString("Name"));
	            	System.out.println("Author UID - > "+resultSet.getString("AuthorUID"));
	            	System.out.println("Author Email - > "+resultSet.getString("Email"));		         	  
	            	System.out.println("--------------------------------------------------");
	            }
	            if (!(bFound)) {
	            	throw new SQLException("No Authors found by name : " + authorName);
	            }
	            
	        }
	        // Handle any errors that may have occurred.
	        catch (SQLException e) {
	            e.printStackTrace();
	        }
  }
   public static void updateBookNameByISBNCode(String isbnCode, String newBookName) {
		 //public static void main(String[] args) {	   
		   String connectionUrl =
		                "jdbc:sqlserver://CHE-2V4WMV2\\SQLEXPRESS:50232"
		                        + ";database=Books"
		                        + ";integratedSecurity=true";		        
		   
	       try (Connection connection = DriverManager.getConnection(connectionUrl);        		
	    		   Statement statement = connection.createStatement();) {
		        	// Create and execute a Update SQL statement.
	    	   
	    	   String UpdateSqlBook = "Update books set Title = '"+newBookName+"' where ISBNCode = '"+isbnCode+"'";
	    	   int cnt = statement.executeUpdate(UpdateSqlBook);
	    	   if(cnt==0) {
	    		   throw new SQLException("Unable to update BookName. Please provide a valid ISBN Code!");
	    	   }
	    	   else {
	    		   System.out.println("Book Name Updated Successfully!");
		            System.out.println("----------------------------------");
	    	   }    
	       }
		        // Handle any errors that may have occurred.
	       catch (SQLException e) {
	    	   e.printStackTrace();
	       }
   }
   
   public static void updateAuthorNameByUID(String authorUID, String authorName) {
		 //public static void main(String[] args) {	   
		   String connectionUrl =
		                "jdbc:sqlserver://CHE-2V4WMV2\\SQLEXPRESS:50232"
		                        + ";database=Books"
		                        + ";integratedSecurity=true";		        
		   
	       try (Connection connection = DriverManager.getConnection(connectionUrl);        		
	    		   Statement statement = connection.createStatement();) {
		        	// Create and execute a Update SQL statement.
	    	   
	    	   String UpdateSqlBook = "Update author set Name = '"+authorName+"' where AuthorUID = '"+authorUID+"'";
	    	   int cnt = statement.executeUpdate(UpdateSqlBook);
	    	   if(cnt==0) {
	    		   throw new SQLException("Unable to update Author Name. Please provide a valid AuthorUID!");
	    	   }
	    	   else {
	    		   System.out.println("Author Name Updated Successfully!");
		            System.out.println("----------------------------------");
	    	   }    
	       }
		        // Handle any errors that may have occurred.
	       catch (SQLException e) {
	    	   e.printStackTrace();
	       }
   }
   
   public static void updateAuthorEmailByUID(String authorUID, String authorEmail) {
		 //public static void main(String[] args) {	   
		   String connectionUrl =
		                "jdbc:sqlserver://CHE-2V4WMV2\\SQLEXPRESS:50232"
		                        + ";database=Books"
		                        + ";integratedSecurity=true";		        
		   
	       try (Connection connection = DriverManager.getConnection(connectionUrl);        		
	    		   Statement statement = connection.createStatement();) {
		        	// Create and execute a Update SQL statement.
	    	   
	    	   String UpdateSqlBook = "Update author set Email = '"+authorEmail+"' where AuthorUID = '"+authorUID+"'";
	    	   int cnt = statement.executeUpdate(UpdateSqlBook);
	    	   if(cnt==0) {
	    		   throw new SQLException("Unable to update Author Email. Please provide a valid AuthorUID!");
	    	   }
	    	   else {
	    		   System.out.println("Author Email Updated Successfully!");
		            System.out.println("----------------------------------");
	    	   }    
	       }
		        // Handle any errors that may have occurred.
	       catch (SQLException e) {
	    	   e.printStackTrace();
	       }
 }
	   
}
