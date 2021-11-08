/**
 * 
 */
package service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import dao.Dao;
import entity.Author;
import entity.Borrower;
import entity.Branch;
import entity.Genre;
import entity.Modelable;
import entity.Publisher;
import view.View;
import view.ViewAdmin;

/**
 * @author rickylopez
 *
 */
public class Administrator {
	
	private Dao DB;
	private Scanner scnnr;
	
	private enum item {AUTHOR, BOOK, BORROWER, BRANCH, GENRE, PUBLISHER};
	
	public Administrator(Dao DB, Scanner scnnr) {
		
		this.scnnr = scnnr;
		this.DB = DB;
		
	}
	
	
	public int admin1() {
		
		ViewAdmin.displayAdmin();
		
		String input = "";
		int returnCode = 1;
		
		while(scnnr.hasNextLine()) {
			
			input = scnnr.nextLine();
			
			if("1".equals(input))
				returnCode = adminCrud();
			else if("2".equals(input))
				returnCode = admin2();
			else if("3".equals(input))
				return 0; // Main Menu Code. 
			else {
				View.printUserErr();
				continue;
			}
			
			if(returnCode == 1) { //return from child method call. 
				ViewAdmin.displayAdmin();
				continue;
			}else if (returnCode == 0) {
				return returnCode;
			}
			
			break;
			
			
		}
		
		
		return 1;
		
	}
	
	public int adminCrud() {
		
		ViewAdmin.displayAdminCrud();
		String input = "";
		int crudCode = 0;
		
		
		while(scnnr.hasNextLine()) {
			
			input = scnnr.nextLine();
			
			if("1".equals(input))
				crudCode = 1;
			else if("2".equals(input))
				crudCode = 2;
			else if("3".equals(input))
				crudCode = 3;
			else if("4".equals(input))
				crudCode = 4;
			else if("5".equals(input))
				return 1; //return to admin main menu
			else {
				View.printUserErr();
				continue;
			}
			
			return adminCrudCont(crudCode);
			
		}
		
		
		
		
		return 1;
	}
	
	public int adminCrudCont(int crudCode) {
		
		ViewAdmin.displayAdminCrud2();
	
		
		String input = "";
		item dataType = null;
		
		while(scnnr.hasNextLine()) {
			
			input = scnnr.nextLine();
			
			//Author%n2) Book%n3) Borrower%n4) Branch%n5) Genre%n6) Publisher
			switch(input) {
				case "1" :
					dataType = item.AUTHOR;
					break;
				case "2" :
					dataType = item.BOOK;
					break;
				case "3" :
					dataType = item.BORROWER;
					break;
				case "4" :
					dataType = item.BRANCH;
					break;
				case "5" :
					dataType = item.GENRE;
					break;
				case "6" :
					dataType = item.PUBLISHER;
					break;
				case "7" :
					View.cancelOperationNotice();
					return 1;
				default :
					View.printUserErr();
					continue;
			
			}
			
			
			switch(crudCode) {
				case 1:
					return adminCreate(dataType);
				case 2:
					return adminRead(dataType);
				case 3:
					return adminUpdate(dataType);
				case 4:
					return adminDelete(dataType);
				default:
					break;
				
			}
			
			
		}
		
		return 1;
		
	}
	
	private int adminCreate(item dataType) {
		
		//Author Book Borrower Branch Genre Publisher
		
		try {
		
			switch(dataType) {
				case AUTHOR:
					
					ViewAdmin.displayAdminCreate
						("AUTHOR", new String[]{"authorId" , "authorName"});
					
					String authorId, authorName;
					authorId = authorName = "";
					
					while(scnnr.hasNextLine()) {
						
						authorId = scnnr.nextLine();
						authorName = scnnr.nextLine();
						
						//DB.createAuthor(authorId, authorName);
						DB.createItem
							("tbl_author" , new String[] {authorId, authorName});
						
						View.success();
						return 1; 
					}
					
					
				case BOOK:
					
					ViewAdmin.displayAdminCreate
						("BOOK", new String[] {"bookId, title, pubId"});
					
					String bookId, title, pubId;
					bookId = title = pubId = "";
					
					while(scnnr.hasNextLine()) {
						
						bookId = scnnr.nextLine();
						title = scnnr.nextLine();
						pubId = scnnr.nextLine();
						
						//DB.createBook(bookId, title, pubId);
						
						DB.createItem
							("tbl_book", new String[] {bookId, title, pubId});
						
						View.success();
						return 1;
						
					}
					
					
				case BORROWER:
					
					ViewAdmin.displayAdminCreate
						("BORROWER", new String[]{"cardNo", "name", "address", "phone"});
					
					String cardNo, name, address, phone;
					cardNo = name = address = phone = "";
					
					while(scnnr.hasNextLine()) {
						
						cardNo = scnnr.nextLine();
						name = scnnr.nextLine();
						address = scnnr.nextLine();
						phone = scnnr.nextLine();
						
						DB.createItem
							("tbl_borrower" , new String[] {cardNo, name, address, phone});
						
						View.success();
						return 1;
						
					}
				
				case BRANCH:
					
					ViewAdmin.displayAdminCreate
						("BRANCH" , new String[] {"branchId", "branchName", "branchAddress"});
					
					String branchId, branchName, branchAddress;
					branchId = branchName = branchAddress = "";
					
					while(scnnr.hasNextLine()) {
						
						branchId = scnnr.nextLine();
						branchName = scnnr.nextLine();
						branchAddress = scnnr.nextLine();
						
						DB.createItem
							("tbl_library_branch" , new String[] {branchId, branchName, branchAddress});
						
						View.success();
						return 1;
					}
					
				case GENRE:
					
					ViewAdmin.displayAdminCreate
						("GENRE" , new String[] {"genreId", "genreName"});
					
					String genreId, genreName;
					genreId = genreName = "";
					
					while(scnnr.hasNextLine()) {
						
						genreId = scnnr.nextLine();
						genreName = scnnr.nextLine();
						
						DB.createItem
							("tbl_genre" , new String[] {genreId, genreName});
						
						View.success();
						return 1;
						
					}
					
				case PUBLISHER:
					
					ViewAdmin.displayAdminCreate
						("PUBLISHER" , new String[] {"publisherId", "publisherName", "publisherAddress", "publisherPhone"});
					
					String publisherId, publisherName, publisherAddress, publisherPhone;
					publisherId = publisherName = publisherAddress = publisherPhone = "";
					
					while(scnnr.hasNextLine()) {
						
						publisherId = scnnr.nextLine();
						publisherName = scnnr.nextLine();
						publisherAddress = scnnr.nextLine();
						publisherPhone = scnnr.nextLine();
						
						DB.createItem
							("tbl_publisher" , new String[] {publisherId, publisherName, publisherAddress, publisherPhone});
						
						View.success();
						return 1;
						
						
					}
			}
		
		}catch(SQLException e) {
			View.printSQLErr();
			return 0;
		}
		
		return 0;
	}


	private int adminRead(item dataType) {
		
		try {
			switch(dataType) {
				case AUTHOR:
					List<Author> authorList = DB.retrieveAuthors();
					ViewAdmin.displayAuthors(authorList);
					break;
					
				case BOOK:
					
					List<String> bookList = DB.retrieveBookTitlesAndAuthors();
					ViewAdmin.displayBooks(bookList);
					break;
					
				case BORROWER:
					
					List<Borrower> borrowerList = DB.retrieveBorrowers();
					ViewAdmin.displayBorrowers(borrowerList);
					break;
				
				case BRANCH:
					
					List<Branch> branchList = DB.retrieveLibraryBranches();
					ViewAdmin.displayBranches(branchList);
					break;
					
				case GENRE:
					
					List<Genre> genreList = DB.retrieveGenres();
					ViewAdmin.displayGenres(genreList);
					break;
					
				case PUBLISHER:
					
					List<Publisher> publisherList = DB.retrievePublishers();
					ViewAdmin.displayPublishers(publisherList);
					break;
					
				default :
					break;
					
			}
		}catch(SQLException e) {
				View.printSQLErr();
				return 0; 
		}
		
		return 1;
	}


	private int adminUpdate(item dataType) {
		
		
		List<Modelable> items = null;
		String field, newFieldValue;
		int selectionValue = -1;
		field = newFieldValue = "";
		
		try {
			
			switch(dataType) {
				case AUTHOR:
					
					ViewAdmin.displayAdminUpdate("AUTHOR", new String[] {"authorId", "authorName"} );
					
					if(scnnr.hasNextLine())
						field = scnnr.nextLine();
					
					//my pride and joy
					items = DB.retrieveAuthors()
							.stream().map( (x) -> (Modelable) x ).collect(Collectors.toList());
					
					
					ViewAdmin.displayAdminUpdate(field, items);
					
					if(scnnr.hasNextLine())
						selectionValue = Integer.parseInt(scnnr.nextLine());
					
					ViewAdmin.displayAdminUpdate();
					
					if(scnnr.hasNextLine())
						newFieldValue = scnnr.nextLine();
					
					DB.updateItem
						(field, newFieldValue, "authorId", items.get(selectionValue-1).getVerifiableAttribute() );
					
					break;
					
					
				case BOOK:
					
					ViewAdmin.displayAdminUpdate("BOOK", new String[] {"bookId", "title" , "pubId"} );
					
					if(scnnr.hasNextLine())
						field = scnnr.nextLine();
					
					//my pride and joy
					items = DB.retrieveBooks()
							.stream().map( (x) -> (Modelable) x ).collect(Collectors.toList());
					
					
					ViewAdmin.displayAdminUpdate(field, items);
					
					if(scnnr.hasNextLine())
						selectionValue = Integer.parseInt(scnnr.nextLine());
					
					ViewAdmin.displayAdminUpdate();
					
					if(scnnr.hasNextLine())
						newFieldValue = scnnr.nextLine();
					
					DB.updateItem
						(field, newFieldValue, "bookId", items.get(selectionValue-1).getVerifiableAttribute() );
					
					break;
					
				case BORROWER:
					
					ViewAdmin.displayAdminUpdate("BORROWER", new String[] {"cardNo", "name" , "address" , "phone"} );
					
					if(scnnr.hasNextLine())
						field = scnnr.nextLine();
					
					//my pride and joy
					items = DB.retrieveBooks()
							.stream().map( (x) -> (Modelable) x ).collect(Collectors.toList());
					
					
					ViewAdmin.displayAdminUpdate(field, items);
					
					if(scnnr.hasNextLine())
						selectionValue = Integer.parseInt(scnnr.nextLine());
					
					ViewAdmin.displayAdminUpdate();
					
					if(scnnr.hasNextLine())
						newFieldValue = scnnr.nextLine();
					
					DB.updateItem
						(field, newFieldValue, "cardNo", items.get(selectionValue-1).getVerifiableAttribute() );
					
					break;
				
				case BRANCH:
					
					ViewAdmin.displayAdminUpdate("BRANCH", new String[] {"branchId", "branchName" , "branchAddress"} );
					
					if(scnnr.hasNextLine())
						field = scnnr.nextLine();
					
					//my pride and joy
					items = DB.retrieveBooks()
							.stream().map( (x) -> (Modelable) x ).collect(Collectors.toList());
					
					
					ViewAdmin.displayAdminUpdate(field, items);
					
					if(scnnr.hasNextLine())
						selectionValue = Integer.parseInt(scnnr.nextLine());
					
					ViewAdmin.displayAdminUpdate();
					
					if(scnnr.hasNextLine())
						newFieldValue = scnnr.nextLine();
					
					DB.updateItem
						(field, newFieldValue, "branchId", items.get(selectionValue-1).getVerifiableAttribute() );
					
					break;
					
				case GENRE:
					
					ViewAdmin.displayAdminUpdate("GENRE", new String[] {"genreId", "genreName"} );
					
					if(scnnr.hasNextLine())
						field = scnnr.nextLine();
					
					//my pride and joy
					items = DB.retrieveBooks()
							.stream().map( (x) -> (Modelable) x ).collect(Collectors.toList());
					
					
					ViewAdmin.displayAdminUpdate(field, items);
					
					if(scnnr.hasNextLine())
						selectionValue = Integer.parseInt(scnnr.nextLine());
					
					ViewAdmin.displayAdminUpdate();
					
					if(scnnr.hasNextLine())
						newFieldValue = scnnr.nextLine();
					
					DB.updateItem
						(field, newFieldValue, "genreId", items.get(selectionValue-1).getVerifiableAttribute() );
					
					break;
					
				case PUBLISHER:
					
					ViewAdmin.displayAdminUpdate("PUBLISHER", new String[] {"publisherId", "publisherName" , "publisherAddress" , "publisherPhone"} );
					
					if(scnnr.hasNextLine())
						field = scnnr.nextLine();
					
					//my pride and joy
					items = DB.retrieveBooks()
							.stream().map( (x) -> (Modelable) x ).collect(Collectors.toList());
					
					
					ViewAdmin.displayAdminUpdate(field, items);
					
					if(scnnr.hasNextLine())
						selectionValue = Integer.parseInt(scnnr.nextLine());
					
					ViewAdmin.displayAdminUpdate();
					
					if(scnnr.hasNextLine())
						newFieldValue = scnnr.nextLine();
					
					DB.updateItem
						(field, newFieldValue, "publisherId", items.get(selectionValue-1).getVerifiableAttribute() );
					
					break;
			}
		}catch(Exception e) {
			View.printSQLErr();
			return -1;
		}
		
		View.success();
		return 0;
	}


	private int adminDelete(item dataType) {
		
		List<Modelable> itemList = null;
		String tableName, primaryField;
		tableName = primaryField = "";
		int selectionValue = -1;
		
		try {
			switch(dataType) {
				case AUTHOR:
					
					itemList = DB.retrieveAuthors()
						.stream().map( (x) -> (Modelable) x ).collect(Collectors.toList());
					tableName = "tbl_author";
					primaryField = "authorId";
					break;
					
				case BOOK:
					
					itemList = DB.retrieveBooks()
						.stream().map( (x) -> (Modelable) x ).collect(Collectors.toList());
					tableName = "tbl_book";
					primaryField = "bookId";
					break;
					
					
				case BORROWER:
					
					itemList = DB.retrieveBorrowers()
						.stream().map( (x) -> (Modelable) x ).collect(Collectors.toList());
					tableName = "tbl_borrower";
					primaryField = "cardNo";
					break;
				
				case BRANCH:
					
					itemList = DB.retrieveLibraryBranches()
						.stream().map( (x) -> (Modelable) x ).collect(Collectors.toList());
					tableName = "tbl_library_branch";
					primaryField = "branchId";
					break;
					
				case GENRE:
					
					itemList = DB.retrieveGenres()
						.stream().map( (x) -> (Modelable) x ).collect(Collectors.toList());
					tableName = "tbl_genre";
					primaryField = "genreId";
					break;
					
				case PUBLISHER:
					
					itemList = DB.retrievePublishers()
						.stream().map( (x) -> (Modelable) x ).collect(Collectors.toList());
					tableName = "tbl_publisher";
					primaryField = "publisherId";
					break;
			}
			
			ViewAdmin.displayAdminDelete(itemList);
			
			if(scnnr.hasNextLine())
				selectionValue = Integer.parseInt(scnnr.nextLine());
			
			
			DB.deleteItem(itemList.get(selectionValue-1), tableName, primaryField);
		
		}catch(SQLException e) {
			View.printSQLErr();
			return -1;
		}
		
		View.success();

		return 0;
	}


	public int admin2() {
		
		
		return 1;
	}

}
