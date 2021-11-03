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
		System.out.format("(Please type in the selection number!)%n%n");
		
		System.out.format("1•Librarian%n%n");
		System.out.format("2•Administrator%n%n");
		System.out.format("3•Borrower%n%n");
		
		
		System.out.format("%n*******************************************************************%n%n");
		
	}
	
	public static void displayLib1() {
		
		System.out.println("Please select  the branch you manage.");
		System.out.println("(Typing Quit will take to you the Main Menu.)");
		
		System.out.format("%n*******************************************************************%n%n");
		
	}

}
