/**
 * 
 */
package view;

import java.util.List;

import entity.Branch;

/**
 * @author Lopez
 *
 */
public class View {
	
	public static void displayMain() {
			
		System.out.format("%n%n*******************************************************************%n%n");
		
		
		System.out.format("Welcome to the SS Library Management System. Which category of user are you?%n");
		System.out.format("(Please type in the selection number!)%n%n");
		
		System.out.format("1�Librarian%n%n");
		System.out.format("2�Administrator%n%n");
		System.out.format("3�Borrower%n%n");
		
		
		System.out.format("%n*******************************************************************%n%n");
		
	}
	
	public static void displayLib1(List<Branch> list) {
		
		System.out.format("Please select the branch you manage.%n%n");
		
		int counter;
		
		for(counter = 1; counter <= list.size(); counter++) 
			System.out.format("%d) %s, %s%n", counter, list.get(counter-1).getBranchName(), list.get(counter-1).getBranchAddress() );
		
		System.out.format("%n%d) Quit to Main Menu%n%n", counter);
		
		
	}
	
	public static void displayLib2(Branch branch) {
		
		System.out.format("%n*******************************************************************%n%n");
		
		System.out.format("Library: %s%n%n" , branch.getBranchName());
		
		System.out.println("What would you like to do?");
		
		System.out.println("1) Update the details of the library");
		System.out.println("2) Add copies of a book to the library");
		System.out.format("%n3) Quit to Main Menu%n");
		
		
		System.out.format("%n*******************************************************************%n%n");
		
	}
	
	public static void displayLib3(Branch branch) {
		
		System.out.format("You have chosen to update the Branch with Branch Id: $d and Branch Name: %s.%n%n", branch.getBranchId(), branch.getBranchName());
		
		System.out.format("Enter ‘quit’ at any prompt to cancel operation.%n%n");
		
		System.out.println("Please enter new branch name or enter N/A for no change:");
		
	}
	
	public static void displayLib3() {
		System.out.format("%nPlease enter new branch address or enter N/A for no change:%n%n");
		
		System.out.format("%n*******************************************************************%n%n");
	}
	
	public static void success() {
		System.out.println("Success! Database updated.");
	}
	
	public static void printErr() {
		System.out.println("Sorry, that answer is invalid. Please try again.");
	}

}
