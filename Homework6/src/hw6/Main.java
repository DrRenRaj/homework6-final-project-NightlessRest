/*
	Brian G. Escobar
	CS 1050
	Homework 6
*/


package hw6;
import java.util.ArrayList;
import java.util.Scanner;
//// Class representing a book in the library
class Book{
	//initializing my variables
	private String title;
	private String author;
	private String isbn;
	private Boolean isAvailable;
	//using my constructor to assign values to my variables
	public Book(String title, String author, String isbn){
		//using .this to not confuse java from the original variables and the parameters 
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		isAvailable = true;
	}
	
	//Get and set for different values
	public String getISBN() {
		return isbn;
	}
	public String getTitle() {
		return title;
	}
	public String getAuthor() {
		return author;
	}
	public boolean getAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean available) {
		isAvailable = available;
	}
	//Using toString so when I call it into a string it prints the whole values
	//Used line breaks for better readability
	public String toString() {
		return "Title: "+ title + "\n" +
			   "Author: " + author + "\n"+
			    "ISBN: " + isbn + "\n"+
			     "Is available?: " + (isAvailable ? "Yes" : "No");
				
	}
}


//Library class containing my array list with all the book objects
class Library{
	// Collection of books using an ArrayList
	private ArrayList<Book> books = new ArrayList<>();
	// Method to add a book to the library

	public void addBook(Book book) {
		for (Book bookie : books) {
			// Check if a book with the same ISBN already exists
			if(bookie.getISBN().equals(book.getISBN())) {
				System.out.println("This book already exist in the library");
				return;
				}
			
			}
		books.add(book);// Add book if ISBN is unique
		 System.out.println("Book titled: " + book.getTitle() + " has been succesufully added to the library");
		}
		
	
	// Method to remove a book based on its ISBN
	public void removeBook(String isbn) {
		for (Book bookie : books) {
			
			if(bookie.getISBN().equals(isbn)) {
				System.out.println("Book with ISBN: " + isbn + " has been succesfully removed.");
				books.remove(bookie);
				return;
			}
		}
		System.out.println("Book was not found.");
	}
	
	// Method to display all books in the library
	public void displayAllBooks() {
		//If array is empty
		if (books.isEmpty()) {       
            System.out.println("No books in Library System, please add books");
            return;
        }
		System.out.println("Book on the system:");
		for (Book bookie : books) {
			System.out.println(bookie);
			System.out.println();
			
		}
	}
	// Method to search for books by title
	public void searchByTitle(String title) {
		System.out.println("Books which titles start with the following: " + title);
		boolean found = false;
		for(Book bookie: books) {
			
			if (bookie.getTitle().toLowerCase().startsWith(title.toLowerCase())) {
				System.out.println(bookie);
				System.out.println();
				found = true;
			}
				
			}
			
		if(!found) {
			System.out.println("No matches found");
			
		}
			
	}
	// Method to search for books by author

	public void searchByAuthor(String author){
		boolean found = false;
		System.out.println("Books which authors start with the following: " + author);
		for(Book bookie: books) {
			
			if (bookie.getAuthor().toLowerCase().startsWith(author.toLowerCase())) {
				System.out.println(bookie);
				System.out.println();
				found = true;
			}
		}
		if(!found) {
			System.out.println("Matches not found");
		}
	}
	
    //Checkout a book method

	public void checkOutBook(String isbn){
		for (Book bookie : books) {
			if(bookie.getISBN().equals(isbn)) {
				if(bookie.getAvailable()) {
				    bookie.setAvailable(false);
				    System.out.println("Book titled " + bookie.getTitle() + " with ISBN: " + isbn + " has been successfully checked out.");
				} else {
				    System.out.println("Book is already checked out.");
				}
				return;
			}
		}
		System.out.println("ISBN incorrect, can't find book.");

	}
    //Return a book method
	public void returnBook(String isbn){
		for (Book bookie : books) {
			if(bookie.getISBN().equals(isbn)) {
				if (!bookie.getAvailable()) {
				    bookie.setAvailable(true);
				    System.out.println("Book titled " + bookie.getTitle() + " with ISBN: " + isbn + " has been successfully returned.");
				} else {
				    System.out.println("Book titled " + bookie.getTitle() + " with ISBN: " + isbn + " was not checked out.");
				}
				return;
				
			}
	   
		}
		System.out.println("ISBN incorrect, can't find book.");
		}
	
	
	}

//Add other classes here or separate java files in same package
public class Main {
	public static void main(String[] args) {
			Library library_ = new Library();
		 	Scanner menuScanner = new Scanner(System.in);
		 	String title, author, isbn;
		 	
				
			System.out.println("Welcome to your Library Management Program!");
			System.out.println("How can I help you today?");
			while(true) {
				System.out.println("1. Add Book");
			    System.out.println("2. Remove Book");
			    System.out.println("3. Display All Books");
			    System.out.println("4. Search by Title");
			    System.out.println("5. Search by Author");
			    System.out.println("6. Check Out Book");
			    System.out.println("7. Return Book");
			    System.out.println("8. Exit");
			    
			   
			    int option = menuScanner.hasNextInt() ? menuScanner.nextInt() : 0;
			    menuScanner.nextLine();
			    
			    
			    switch(option){
			    case 1: //1. Add Book
	                System.out.print("Enter the title: ");
	                title = menuScanner.nextLine();
	                System.out.print("Enter the author: ");
	                author = menuScanner.nextLine();
	                System.out.print("Enter the ISBN: ");
	                isbn = menuScanner.nextLine();
	                Book book = new Book(title, author, isbn);
	                library_.addBook(book);
	               
	                break;
	            case 2:
	            	// 2. Remove Book
	            	System.out.print("Enter the ISBN of book wish to be removed: ");
	            	isbn = menuScanner.nextLine();
	            	library_.removeBook(isbn);
	                break;
	            case 3:
	            	// 3. Display All Books
	                library_.displayAllBooks();
	                break;
	            case 4:        
	            	//4. Search by Title
	            	System.out.print("Enter the first letters or the full name of the title of the book: ");
	            	title = menuScanner.nextLine();
	            	library_.searchByTitle(title);
	                break;
	            case 5:
	            	//5. Search by Author
	            	System.out.print("Enter the first letters or the full name of the author of the book: ");
	            	author = menuScanner.nextLine();
	            	library_.searchByAuthor(author);
	                break;
	            case 6:      
	            	//6. Check Out Book	
	            	System.out.print("Enter the ISBN of book wish to check out: ");
	            	isbn = menuScanner.nextLine();
	            	library_.checkOutBook(isbn);
	                break;
	               
	            case 7:
	            	// 7. Return Book
	            	System.out.print("Enter the ISBN of book wish to return: ");
	            	isbn = menuScanner.nextLine();
	            	library_.returnBook(isbn);
	                break;
	                //8. Exit
	            case 8:
	            	System.out.println("Hope to see you again!");
	            	System.exit(0);
	            	menuScanner.close();
	                break;
	            default:
	                System.out.println("Wrong input has been entered, please introuduce a valid option");
	                break;
			    }
	        }
		
				
				
				
				
			}
			

}
