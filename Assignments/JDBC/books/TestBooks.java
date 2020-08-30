package books;

import java.util.Scanner;

public class TestBooks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean bStart = true;
		String option =  "";
		SQLDBConnection con = new SQLDBConnection();
		String bookName="";
		String isbnCode="";
		String authorUID="";
		String authorName="";
		String authorEmail="";		
		Scanner s = new Scanner(System.in);
		while(bStart) {		
		System.out.println("--Just Books--");
		System.out.println("Enter 1 to Manage Books");
		System.out.println("Enter 2 to Manage Authors");
		System.out.println("Enter 3 to Exit");
		//Books
		//if(s.nextInt()==1) {
		option = s.next();
		switch(option) {
		case "1" : 
			System.out.println("Enter 1 to Add new book");
			System.out.println("Enter 2 to View book");
			System.out.println("Enter 3 to Delete book");
			System.out.println("Enter 4 to Update book Name");
			//Add New Book
			option = s.next();
			switch(option) {
			case "1" : 
			//if(s.nextInt()==1) {
				System.out.println("Enter Book Name");
				bookName = s.next();
				System.out.println("Enter ISBN Code");
				isbnCode = s.next();
				System.out.println("Enter Author UID");
				authorUID = s.next();
				Author author = new Author(authorUID);
				Books books = new Books(bookName,isbnCode,author);
				System.out.println("New Book Details are : ");
				System.out.println("Book Name  :" +books.getTitle());
				System.out.println("ISBN Code  :" +books.getIsbnCode());
				con.addBook(books);
				//code to add books 
			//}		
			//View Book
			//else if(s.nextInt()==2) {
				break;
			case "2" : 
				System.out.println("Enter 1 to view Book details by Name");
				System.out.println("Enter 2 to view all Books in Library");	
				option = s.next();
				switch(option) {
				case "1" : 
				//if(s.nextInt()==1) {	
					System.out.println("Enter Book Name");
					con.getBookDetailsByName(s.next());			
				//}
					break;
				case "2" : 
				//else if (s.nextInt()==2) {					
					con.getAllBooks();
					break;
				default :
					System.out.println("Invalid option entered");
				}
			//}	
			//Delete Book
			//else if(s.nextInt()==3) {
				break;
			case "3" : 
				System.out.println("Enter Book Name to delete");
				con.deleteBookByName(s.next());			
			//}
			//Update Book
			//else if(s.nextInt()==4) {
				break;
			case "4" : 
				System.out.println("Enter ISBN Code of the book to be updated");
				isbnCode = s.next();
				System.out.println("Enter New Book Name");
				bookName = s.next();				
				con.updateBookNameByISBNCode(isbnCode,bookName);
				break;
			default :
				System.out.println("Invalid option entered");
			}
		//}
		//Authors
			break;
		case "2":
		//else if(s.nextInt()==2) {
			System.out.println("Enter 1 to Add new author");
			System.out.println("Enter 2 to View details about author");
			System.out.println("Enter 3 to Delete author ");
			System.out.println("Enter 4 to Update author detail");
			//if(s.nextInt()==1) {
			option = s.next();
			switch(option) {
			case "1" : 
				System.out.println("Enter Author Name");
				authorName = s.next();
				System.out.println("Enter Author UID");
				authorUID = s.next();
				System.out.println("Enter Author Email");
				authorEmail = s.next();
				Author author = new Author(authorName, authorUID,authorEmail);
				System.out.println("New Author Details are : ");
				System.out.println("Author Name  :" +author.getAuthorName());
				System.out.println("Author UID :" +author.getAuthorUID());
				System.out.println("Author Email :" +author.getAuthorEmail());
				con.addAuthor(author);
			//}
			//else if (s.nextInt()==2) {
				break;
			case "2" : 
				System.out.println("Enter 1 to view Author details by Name");
				System.out.println("Enter 2 to view all Authors in Library");
				option = s.next();
				switch(option) {
				case "1" : 
				//if(s.nextInt()==1) {	
					System.out.println("Enter Author Name");
					con.getAuthorDetailsByName(s.next());			
				//}
					break;
				case "2" : 
				//else if (s.nextInt()==2) {					
					con.getAllAuthors();
					break;
				default :
					System.out.println("Invalid option entered");
				}
			//}
			//else if (s.nextInt()==3) {
				break;
			case "3" : 
				System.out.println("Enter Author UID");
				authorUID = s.next();
				con.deleteAuthorByUID(authorUID);
			//}
			//else if (s.nextInt()==4) {
				break;
			case "4" : 
				System.out.println("Enter 1 to edit Author Name");
				System.out.println("Enter 2 to edit Author Email");
				option = s.next();
				switch(option) {
				case "1" : 
				//if(s.nextInt()==1) {	
					System.out.println("Enter AuthorUID of the author");
					authorUID = s.next();
					System.out.println("Enter New Author Name");
					authorName = s.next();				
					con.updateAuthorNameByUID(authorUID,authorName);		
				//}
				//else if (s.nextInt()==2) {	
					break;
				case "2" :
					System.out.println("Enter AuthorUID of the author");
					authorUID = s.next();
					System.out.println("Enter New Author Email");
					authorEmail = s.next();				
					con.updateAuthorEmailByUID(authorUID,authorEmail);	
					break;
				default :
					System.out.println("Invalid option entered");
				}
				break;
			default :
				System.out.println("Invalid option entered");
			}			
		//}
		//else {
			break;
		case "3":			
			System.out.println("Exiting program!");	
			exitProgram();
			break;		
		default :
			System.out.println("Invalid option entered");
		}
        System.out.println("--------------------------------------------------");
		System.out.println("Back to Main Menu!");
		System.out.println("--------------------------------------------------");
	  }
	}
	
	private static void exitProgram() {
		System.exit(0);
	}
}
