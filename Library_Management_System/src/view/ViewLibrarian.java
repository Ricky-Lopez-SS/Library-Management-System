package view;

import java.util.List;

import entity.Branch;

public class ViewLibrarian {
	
	public static void displayLib1(List<Branch> list) {
		
		System.out.format("%n*******************************************************************%n%n");
		
		System.out.format("Please select the branch you manage.%n%n");
		
		int counter;
		
		for(counter = 1; counter <= list.size(); counter++) 
			System.out.format("%d) %s, %s%n", counter, list.get(counter-1).getBranchName(), list.get(counter-1).getBranchAddress() );
		
		System.out.format("%n%d) Quit to Main Menu%n%n", counter);
		
		
	}
	
	public static void displayLib2(Branch branch) {
		
		System.out.format("%n*******************************************************************%n%n");
		
		System.out.format("%s Library%n%n" , branch.getBranchName());
		
		System.out.format("What would you like to do?%n%n");
		
		System.out.println("1) Update the details of the library");
		System.out.println("2) Add copies of a book to the library");
		System.out.format("%n3) Quit to Main Menu%n%n");
		
		
	}
	
	public static void displayLib3(Branch branch) {
		
		System.out.format("%n*******************************************************************%n%n");
		
		System.out.format("You have chosen to update the Branch with Branch Id: %d and Branch Name: %s.%n%n", branch.getBranchId(), branch.getBranchName());
		
		System.out.format("Enter 'quit' at any prompt to cancel operation.%n%n");
		
		System.out.format("Please enter new branch name or enter N/A for no change:%n%n");
		
	}
	
	public static void displayLib3() {
		System.out.format("%nPlease enter new branch address or enter N/A for no change:%n%n");
		
		
	}
	
	public static void displayLib4(Branch branch, List<String> booksAndAuthors) {
		
		System.out.format("%n*******************************************************************%n%n");
			
		System.out.format("%s Library%n%n" , branch.getBranchName());
		
		System.out.format("Pick the Book you want to add copies of to your branch. %n%n");
		
		for(int i = 1; i <= booksAndAuthors.size(); i++) 
			System.out.format("%d) %s%n", i, booksAndAuthors.get(i-1));
		
	}
	
	public static void displayLib4(int numOfCopies) {
		
		System.out.format("Existing number of copies: %d%n%n" , numOfCopies);
		
		System.out.format("Enter new number of copies:%n%n");
		
	}

}
