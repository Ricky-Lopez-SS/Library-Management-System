/**
 * 
 */
package service;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import dao.Dao;
import entity.Branch;
import view.View;

/**
 * @author rickylopez
 *
 */
public class Librarian {

	public static int lib1(Dao DB) {

		// retrieve selection of library branches.

		List<Branch> libBranches;

		try {
			libBranches = DB.retrieveLibraryBranches();
		} catch (SQLException e) {
			System.out.println("Sorry, something has gone wrong with the database. Ensure that you are connecting to the proper database.");
			return -1;
		}

		View.displayLib1(libBranches);

		// grab user input.

		Scanner scnnr = new Scanner(System.in);
		int input = 0;

		while (true) {
			try {
				if (scnnr.hasNextLine())
					input = Integer.parseInt(scnnr.next());
			} catch (NumberFormatException e) {
				View.printErr();
				continue;
			}

			if (input > libBranches.size() + 1 || input < 1) {
				View.printErr();
				continue;
			}

			break;
		}

		if (input == libBranches.size() + 1) { // Return to Main Menu.
			scnnr.close();
			return 0; // main menu code
		}

		scnnr.close();
		lib2(libBranches.get(input - 1));
		return input;

	}

	public static int lib2(Branch branch) {

		View.displayLib2(branch);

		Scanner scnnr = new Scanner(System.in);
		int input = 0;
		
		/*
		while(true) { //Dogshit broken code
			try {
				if (scnnr.hasNextLine())
					input = Integer.parseInt(scnnr.next());
			} catch (NumberFormatException e) {
				View.printErr();
				continue;
			}
	
			if (input == 1) { // update details of library.
				scnnr.close();
				return lib3(branch);
			} else if (input == 2) { // add book copies to library.
				scnnr.close();
				return lib4(branch);
			}else 
				View.printErr(); //tod0: ERROR HERE!
			
		}
		*/
		
		//TODO: ERROR HERE! program never enters this while loop! hasNextLine() not blocking for some reason.
		
		while(scnnr.hasNextLine()) {
			
			try {
				input = Integer.parseInt(scnnr.next());
			}catch (NumberFormatException e) {
				View.printErr();
				continue;
			}
			
			if (input == 1) { //update details of library.
				scnnr.close();
				return lib3(branch);
			}else if(input == 2) { // add book copies to library.
				scnnr.close();
				return lib4(branch);
			}else
				View.printErr();
			
			
		}
		
		scnnr.close();
		return 1;
		
		
	}

	public static int lib3(Branch branch) {
		
		View.displayLib3(branch);
		
		Scanner scnnr = new Scanner(System.in);
		String input = "";
		
		if(scnnr.hasNextLine())
			input = scnnr.nextLine();
		
		if("quit".equals(input.toLowerCase())) {
			scnnr.close();
			return 0; //Main Menu code
		}
		
		if(!"n/a".equals(input.toLowerCase())) { //input is not N/A.
			
			//TODO: modify table value for library branch! Create some dao method
			//TODO: add error checking so fallthrough is automatically a success
			
		}
		
		
		View.displayLib3();
		
		if(scnnr.hasNextLine())
			input = scnnr.nextLine();
		
		if("quit".equals(input.toLowerCase())) {
			scnnr.close();
			return 2; //Main Menu code
		}
		
		if(!"n/a".equals(input.toLowerCase())) {
			
			//TODO: modify table value for library branch! Create some dao method.
			//TODO: add error checking do fallthrough is automatically a success
			
		}
		
		View.success();
		scnnr.close();
		return 1;
			
		
		
	}

	public static int lib4(Branch branch) {
		return -10;
	}

}
