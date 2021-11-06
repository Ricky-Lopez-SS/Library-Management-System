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
import entity.Borrower;
import entity.Branch;
import view.View;

/**
 * @author Lopez
 *
 */
public class User {
	
	private Dao DB;
	private Scanner scnnr;
	
	public User(Dao dB, Scanner scnnr) {
		DB = dB;
		this.scnnr = scnnr;
	}
	
	public int bor1() {
		
		View.displayCardCheck();
		String input = "";
		Borrower borrower = null;
		int returnCode = 1; 
		
		while(scnnr.hasNextLine()) { //loop that validates cardnumbers. 
			
			try {
				
				input = scnnr.nextLine();
				
				borrower = DB.validateCardNumber(input);
				
				if(borrower == null) {
					View.printUserErr();
					continue;
				}
				
			}catch(SQLException e) {
				View.printSQLErr();
				return -1;
			}
			
			break;
			
		}
		
		
		View.displayBor1(borrower.getName());
		
		while(scnnr.hasNextLine()) { //loop for option select. 
			
			input = scnnr.nextLine();
			
			if("1".equals(input)) 
				returnCode = bor2(borrower);
			else if("2".equals(input)) 
				returnCode = bor3(borrower);
			else if("3".equals(input))
				return 0;
			else
				View.printUserErr();
			
			if(returnCode == 0 || returnCode == -1)
				return returnCode;
			else if(returnCode == 3)
				return 0; //Main Menu code
			else
				View.displayBor1(borrower.getName());
			continue;
			
			
		}
		
		
		return 1;
		
		
	}
	
	
	public int bor2(Borrower borrower) {
		
		int input = 0;
		Branch branch = null;
		Book book = null;
		
		List<Branch> branchList = new ArrayList<Branch>();
		List<Book> bookList = new ArrayList<Book>();
		List<String> booksAndAuthors = new ArrayList<String>();
		
		try {
			branchList = DB.retrieveLibraryBranches();
		}catch(SQLException e){
			View.printSQLErr();
			return -1;
		}
		
		View.displayBor2(branchList);
		
		while(scnnr.hasNextLine()) {
			
			
			try {
				
				input = Integer.parseInt(scnnr.nextLine());
				
				if(input > branchList.size() + 1 || input < 1) {
					View.printUserErr();
					continue;
				}
				
				if(input == branchList.size() + 1) {
					return 1;
				}
				
				branch = branchList.get(input-1);
				
				booksAndAuthors = DB.retrieveBookTitlesAndAuthors(branch.getBranchId());
				bookList = DB.retrieveBooks(branch.getBranchId());
				
				View.displayBor2Cont(booksAndAuthors);
				
				break;
				
			}catch(NumberFormatException e) {
				View.printUserErr();
				continue;
			}catch(SQLException e) {
				View.printSQLErr();
				return -1;
			}
			
			
			
		}
		
		while(scnnr.hasNextLine()) {
			
			try {
				
				input = Integer.parseInt(scnnr.nextLine());
				
				if(input > bookList.size() + 1 || input < 1) {
					View.printUserErr();
					continue;
				}
				
				if(input == bookList.size() + 1) { //Cancel operation
					View.cancelOperationNotice();
					return bor2(borrower);
				}
				
				book = bookList.get(input-1);
				
				DB.createBookLoanEntry(book.getBookId(), branch.getBranchId(), borrower.getCardNo());
				
				View.success();
				
				break;
				
				
			}catch(NumberFormatException e) {
				View.printUserErr();
				continue;
			}catch(SQLException e) {
				View.printSQLErr();
				continue;
			}
		}
		
		
		
		return 1;
		
	}
	
	
public int bor3(Borrower borrower) {
		
		int input = 0;
		Branch branch = null;
		Book book = null;
		
		List<Branch> branchList = new ArrayList<Branch>();
		List<Book> bookList = new ArrayList<Book>();
		List<String> booksAndAuthors = new ArrayList<String>();
		
		try {
			branchList = DB.retrieveLibraryBranches();
		}catch(SQLException e){
			View.printSQLErr();
			return -1;
		}
		
		View.displayBor3(branchList);
		
		while(scnnr.hasNextLine()) {
			
			
			try {
				
				input = Integer.parseInt(scnnr.nextLine());
				
				if(input > branchList.size() + 1 || input < 1) {
					View.printUserErr();
					continue;
				}
				
				if(input == branchList.size() + 1) {
					return 1;
				}
				
				branch = branchList.get(input-1);
				
				booksAndAuthors = DB.retrieveBookTitlesAndAuthors(branch.getBranchId());
				bookList = DB.retrieveBooks(branch.getBranchId());
				
				View.displayBor3Cont(booksAndAuthors);
				
				break;
				
			}catch(NumberFormatException e) {
				View.printUserErr();
				continue;
			}catch(SQLException e) {
				View.printSQLErr();
				return -1;
			}
			
			
			
		}
		
		while(scnnr.hasNextLine()) {
			
			try {
				
				input = Integer.parseInt(scnnr.nextLine());
				
				if(input > bookList.size() + 1 || input < 1) {
					View.printUserErr();
					continue;
				}
				
				if(input == bookList.size() + 1) { //Cancel operation
					View.cancelOperationNotice();
					return bor2(borrower);
				}
				
				book = bookList.get(input-1);
				
				DB.updateBookLoanReturn(book.getBookId(), branch.getBranchId(), borrower.getCardNo());
				
				View.success();
				
				break;
				
				
			}catch(NumberFormatException e) {
				View.printUserErr();
				continue;
			}catch(SQLException e) {
				View.printSQLErr();
				continue;
			}
		}
		
		
		
		return 1;
		
	}
	
	
	
}
