package view;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;

import entity.Author;
import entity.Book;
import entity.Borrower;
import entity.Branch;
import entity.Genre;
import entity.Modelable;
import entity.Publisher;

public class ViewAdmin {
	
	public static void displayAdmin() {
		
		System.out.format("%n*******************************************************************%n%n");
		
		System.out.format("-ADMIN-%n%n");
		
		System.out.format("Choose an option:%n%n");
		
		System.out.println("1) CRUD Operations");
		System.out.println("2) Override due date for a book loan");
		
		System.out.format("%n3) Quit to Main Menu%n%n");
		
		
	}
	
	public static void displayAdminCrud() {
		
		System.out.format("%n*******************************************************************%n%n");
		
		System.out.format("-CRUD OPERATIONS-%n%n");
		
		System.out.format("Choose an operation:%n%n");
		
		System.out.format("1) Create%n2) Read%n3) Update%n4) Delete%n%n");
		
		System.out.format("5) Return to Admin Main Menu%n%n");
		
		
		
	}
	
	public static void displayAdminCrud2() {
		
		System.out.format("%n*******************************************************************%n%n");
		
		System.out.format("Choose an item:%n%n");
		
		System.out.format("1) Author%n2) Book%n3) Borrower%n4) Branch%n5) Genre%n6) Publisher%n%n");
		
		System.out.format("7) Cancel Operation.%n%n");
		
		
	}

	public static void displayAdminCreate(String itemType , String[] attributes) {
		
		System.out.format("%nCreating %s..%nitem field attributes:%n     " , itemType);
		
		for(String s : attributes)
			System.out.format("%s     " , s);
		
		System.out.format("%n%nPlease enter a value for each field attribute. Invalid fields will result in error.%n%n");
		
		
		
	}
	
	public static void displayAdminUpdate(String itemType, String[] attributes) {
		
		
		System.out.format("%nUpdating %s..%n%nitem field attributes:%n%n" , itemType);
		
		for(int i = 1; i <= attributes.length; i++) 
			System.out.format("%s     ", attributes[i-1]);
		
		System.out.format("%n%nPlease type in the field you would like to update.%n%n");
		
		
	}
	
	public static void displayAdminUpdate(String field, List<Modelable> itemList) {
		
		int counter;
		
		System.out.format("Updating %s..%n%n", field);
		
		System.out.format
			("Please choose a %s in the database that you would like to update:%n%n", itemList.get(0).getItemType() );
		
		for(counter = 1; counter <= itemList.size(); counter++ )
			System.out.format("%d) %s%n", counter , itemList.get(counter-1));
		
		System.out.format("%n%n%d) Quit to Admin Menu%n%n" , counter);
		
		
		
	}
	
	public static void displayAdminUpdate() {
		
		System.out.format("Please enter the new identity for the field you have chosen to modify:%n%n");
		
	}
	

	public static void displayBooks(List<String> bookList) {
		
		System.out.format("LIST OF ALL BOOKS%n%n");
		
		for(int i = 1; i <= bookList.size(); i++) 
			System.out.format("%s%n", bookList.get(i-1));
		
	}

	public static void displayBorrowers(List<Borrower> borrowerList) {
		
		System.out.format("LIST OF ALL BORROWERS%n%n");
		
		for(int i = 1; i <= borrowerList.size(); i++) 
			System.out.format("%s%n", borrowerList.get(i-1).getName());
		
	}

	public static void displayBranches(List<Branch> branchList) {

		System.out.format("LIST OF ALL BRANCHES%n%n");
		
		for(int i = 1; i <= branchList.size(); i++) 
			System.out.format("%s%n", branchList.get(i-1).getBranchName());
		
	}

	public static void displayGenres(List<Genre> genreList) {
		
		System.out.format("LIST OF ALL GENRES%n%n");
		
		for(int i = 1; i <= genreList.size(); i++) 
			System.out.format("%s%n", genreList.get(i-1).getGenreName());
		
	}

	public static void displayPublishers(List<Publisher> publisherList) {
		
		System.out.format("LIST OF ALL PUBLISHERS%n%n");
		
		for(int i = 1; i <= publisherList.size(); i++) 
			System.out.format("%s%n", publisherList.get(i-1).getPublisherName());
		
	}

	public static void displayAuthors(List<Author> authorList) {

		System.out.format("LIST OF ALL AUTHORS%n%n");
		
		for(int i = 1; i <= authorList.size(); i++) 
			System.out.format("%s%n", authorList.get(i-1).getAuthorName());
		
	}

	public static void displayAdminDelete(List<Modelable> itemList) {
		
		int counter;
		
		System.out.format("Please select the item you would like to delete.%n%n");
		
		for(counter = 1; counter <= itemList.size(); counter++)
			System.out.format("%d) %s%n" , counter, itemList.get(counter-1));
		
		System.out.format("%d) Quit to Admin Menu%n%n" , counter);
		
	}




}
