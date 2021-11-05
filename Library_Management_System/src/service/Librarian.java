/**
 * 
 */
package service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dao.Dao;
import entity.Book;
import entity.Branch;
import view.View;

/**
 * @author rickylopez TODO: CLEAN UP CODE
 */
public class Librarian {

	private Dao DB;
	private Scanner scnnr;

	public Librarian(Dao dB, Scanner scnnr) {
		DB = dB;
		this.scnnr = scnnr;
	}

	public int lib1() {

		// retrieve selection of library branches.

		List<Branch> libBranches;

		try {
			libBranches = DB.retrieveLibraryBranches();
		} catch (SQLException e) {
			System.out.println(
					"Sorry, something has gone wrong with the database. Ensure that you are connecting to the proper database.");
			return -1;
		}

		View.displayLib1(libBranches);

		// grab user input.

		// Scanner scnnr = new Scanner(System.in);
		int input = 0;

		while (true) {
			try {
				if (scnnr.hasNextLine())
					input = Integer.parseInt(scnnr.next());
			} catch (NumberFormatException e) {
				View.printUserErr();
				continue;
			}

			if (input > libBranches.size() + 1 || input < 1) {
				View.printUserErr();
				continue;
			}

			break;
		}

		if (input == libBranches.size() + 1) { // Return to Main Menu.
			return 0; // main menu code
		}

		// scnnr.close();

		return lib2(libBranches.get(input - 1));

	}

	public int lib2(Branch branch) {

		View.displayLib2(branch);

		int input = 0;
		scnnr.nextLine();

		while (scnnr.hasNextLine()) {

			try {
				input = Integer.parseInt(scnnr.nextLine());
			} catch (NumberFormatException e) {
				View.printUserErr();
				continue;
			}

			if (input == 1) { // update details of library.

				lib3(branch);
				try {
					View.displayLib2(DB.retrieveLibraryBranch(branch.getBranchId()));
				} catch (SQLException e) {
					View.printSQLErr();
				}

			} else if (input == 2) { // add book copies to library.

				lib4(branch);
				try {
					View.displayLib2(DB.retrieveLibraryBranch(branch.getBranchId()));
				} catch (SQLException e) {
					View.printSQLErr();
				}

			} else if (input == 3)
				return 0; // main menu code
			else
				View.printUserErr();

		}

		return 1;

	}

	public int lib3(Branch branch) {

		String input = "";
		String newBranchName = "";
		String newBranchAddress = "";

		while (true) {

			View.displayLib3(branch);

			if (scnnr.hasNextLine())
				input = scnnr.nextLine();

			if ("quit".equals(input.toLowerCase()))
				return 0; // Main Menu code

			if ("n/a".equals(input.toLowerCase())) // input is N/A so no change.
				newBranchName = branch.getBranchName();
			else
				newBranchName = input;

			View.displayLib3();

			if (scnnr.hasNextLine())
				input = scnnr.nextLine();

			if ("quit".equals(input.toLowerCase()))
				return 0; // Main Menu code

			if ("n/a".equals(input.toLowerCase())) // input is N/A so no change.
				newBranchAddress = branch.getBranchAddress();
			else
				newBranchAddress = input;

			if ("".equals(newBranchName) || "".equals(newBranchAddress)) {
				View.printUserErr();
				continue;
			}

			try {
				DB.updateLibraryBranch(branch.getBranchId(), newBranchName, newBranchAddress);
			} catch (SQLException e) {
				View.printSQLErr();
				continue;
			}

			View.success();
			return 1;

		}

	}

	public int lib4(Branch branch) {

		int bookChoice = 0;
		int numOfCopies = 0;
		int newCopies = -1;
		List<String> titlesAndAuthors = new ArrayList<String>();
		List<Book> books = new ArrayList<Book>();

		try {
			titlesAndAuthors = DB.retrieveBookTitlesAndAuthors(); 	// THESE TWO SHOULD BE IN THE SAME ORDER
			books = DB.retrieveBooks(); 							// THESE TWO SHOULD BE IN THE SAME ORDER
		} catch (SQLException e) {
			View.printSQLErr();
			return -1;
		}

		View.displayLib4(branch, titlesAndAuthors);

		while (scnnr.hasNextLine()) {

			try {
				bookChoice = Integer.parseInt(scnnr.nextLine());
			} catch (NumberFormatException e) {
				View.printUserErr();
				continue;
			}

			if (bookChoice < 0 || bookChoice > titlesAndAuthors.size()) {
				View.printUserErr();
				continue;
			}

			break;

		}

		try {
			numOfCopies = DB.retrieveNumberOfCopies(books.get(bookChoice - 1).getBookId(), branch.getBranchId());
		} catch (SQLException e) {
			View.printSQLErr();
			return -1;
		}

		View.displayLib4(numOfCopies);

		while (scnnr.hasNextLine()) {
			
			
			try {
				
				newCopies = Integer.parseInt(scnnr.nextLine());
				
				if (newCopies < 0) {
					View.printUserErr();
					continue;
				}
				
				DB.updateNumberOfCopies(books.get(bookChoice - 1).getBookId(), branch.getBranchId(), newCopies);
				
			} catch (NumberFormatException e) {
				View.printUserErr();
				continue;
			} catch( SQLException e) {
				View.printSQLErr();
				continue;
			}


			break;
		}

		View.success();
		return 1;

	}

	public void closeScanner() {
		scnnr.close();
	}

}
