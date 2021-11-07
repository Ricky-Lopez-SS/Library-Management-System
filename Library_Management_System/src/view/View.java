/**
 * 
 */
package view;


/**
 * @author Lopez
 *
 */
public class View {
	
	public static void displayMain() {
			
		System.out.format("%n%n*******************************************************************%n%n");
		
		
		System.out.format("Welcome to the SS Library Management System. Which category of user are you?%n");
		System.out.format("(Please type in the selection number, or type 'quit' to exit!)%n%n");
		
		System.out.format("1) Librarian%n%n");
		System.out.format("2) Administrator%n%n");
		System.out.format("3) Borrower%n%n");
		
		
		
	}
		
	public static void success() {
		System.out.println("Success! Database updated.");
	}
	
	public static void printUserErr() {
		System.out.println("Sorry, that answer is invalid. Please try again.");
	}
	
	public static void printSQLErr() {
		System.out.println("Sorry, an SQL Error has occurred. Please try again, or try modifying the database.");
	}
	
	public static void cancelOperationNotice() {
		System.out.println("Operation has been cancelled.");
	}

}
