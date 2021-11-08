/**
 * 
 */
package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.*;

/**
 * @author Lopez
 *
 */
public class Dao {

	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost/library";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "Rubio0323"; // TODO :HIDE LATER!

	private Connection conn;

	public Dao() {
		super();

		try {

			Class.forName(DRIVER); // throws error but still works?
			this.conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public int createAuthor(String authorId, String authorName) throws SQLException {
		
		String query = String.format("INSERT INTO tbl_author VALUES (%s, '%s')" , authorId, authorName);
		
		PreparedStatement stmnt = conn.prepareStatement(query);
		
		return stmnt.executeUpdate();
		
	}
	
	
	public Borrower validateCardNumber(String cardNo) throws SQLException {
		
		String query = ("SELECT * FROM tbl_borrower WHERE cardNo = " + cardNo);
		
		PreparedStatement stmnt = conn.prepareStatement(query);
		
		ResultSet rs = stmnt.executeQuery();
		
		if(rs.next())
			return new Borrower(rs.getInt("cardNo"), rs.getString("name"), rs.getString("address"), rs.getString("phone"));
		
		return null;
		
		
	}
	
	public Book retrieveBookByName(String bookName) throws SQLException{
		
		String query = "SELECT * FROM tbl_book WHERE title LIKE '" + bookName + "'";
		
		PreparedStatement stmnt = conn.prepareStatement(query);
		
		ResultSet rs = stmnt.executeQuery();
		
		if(rs.next()) 
			return new Book(rs.getInt("bookId") , rs.getString("title"), rs.getInt("pubId"));
		
		return null;
		
	}
	
	public Borrower retrieveBorrower(int cardNo) throws SQLException {
		
		String query = String.format("SELECT * FROM tbl_borrower WHERE cardNo = %d" , cardNo);
		
		PreparedStatement stmnt = conn.prepareStatement(query);
		
		ResultSet rs = stmnt.executeQuery();
		
		if(rs.next())
			return new Borrower(rs.getInt("cardNo"), rs.getString("name"), rs.getString("address"), rs.getString("phone") );
		
		throw new SQLException();
		
	}
	
	public int retrieveNumberOfCopies(int bookId, int branchId) throws SQLException {
		
		String query = "SELECT * FROM tbl_book_copies WHERE bookId = " + bookId
				+ " AND branchId = " + branchId;
		
		
		PreparedStatement stmnt = conn.prepareStatement(query);
		
		ResultSet rs = stmnt.executeQuery();
		
		
		
		if(rs.next())
			return rs.getInt("noOfCopies");
		else
			return 0;
		
	}
	

	
	public List<String> retrieveBookTitlesAndAuthors() throws SQLException {
		
		List<String> list = new ArrayList<String>();
		
		String query = "SELECT title, authorName FROM tbl_book "
				+ "LEFT JOIN tbl_book_authors ON tbl_book.bookId = tbl_book_authors.bookId "
				+ "LEFT JOIN tbl_author ON tbl_book_authors.authorId = tbl_author.authorId";
		
		PreparedStatement stmnt = conn.prepareStatement(query);
		
		ResultSet rs = stmnt.executeQuery();
		
		while(rs.next()) {
			
			if( rs.getString("authorName") == null ) //no author
					list.add(String.format("%s", rs.getString("title")));
			else 
				list.add(String.format("'%s' by %s", rs.getString("title") , rs.getString("authorName")));
		}
		
		
		return list;
		
	}
	
	public List<String> retrieveBookTitlesAndAuthors(int branchId) throws SQLException {
		
		List<String> list = new ArrayList<String>();
		
		String query = "SELECT title, authorName, tbl_book_copies.branchId FROM tbl_book "
				+ "INNER JOIN tbl_book_authors ON tbl_book.bookId = tbl_book_authors.bookId "
				+ "INNER JOIN tbl_author ON tbl_book_authors.authorId = tbl_author.authorId "
				+ "INNER JOIN tbl_book_copies ON tbl_book.bookId = tbl_book_copies.bookId "
				+ "INNER JOIN tbl_library_branch ON tbl_library_branch.branchId = tbl_book_copies.branchId "
				+ "WHERE tbl_book_copies.branchId = " + branchId;
		
		
		PreparedStatement stmnt = conn.prepareStatement(query);
		
		ResultSet rs = stmnt.executeQuery();
		
		while(rs.next()) {
			list.add(rs.getString("title") + " by " + rs.getString("authorName"));
		}
		
		return list;
		
	}
	

	
	public List<Book> retrieveBooks() throws SQLException {
		
		List<Book> list = new ArrayList<Book>();
		
		String query = "SELECT * FROM tbl_book";
		
		PreparedStatement stmnt = conn.prepareStatement(query);
		
		ResultSet rs = stmnt.executeQuery();
		
		while(rs.next()) {
			list.add( new Book(rs.getInt("BookId"), rs.getString("title"), rs.getInt("pubId")) );
		}
		
		
		return list;
		
	}
	
	public List<Book> retrieveBooks(int branchId) throws SQLException {
		
		List<Book> list = new ArrayList<Book>();
		
		String query = "SELECT tbl_book_copies.bookId, title, pubId FROM tbl_book_copies "
				+ "INNER JOIN tbl_book ON tbl_book.bookId = tbl_book_copies.bookId "
				+ "WHERE branchId = " + branchId;
		
		PreparedStatement stmnt = conn.prepareStatement(query);
		
		ResultSet rs = stmnt.executeQuery();
		
		while(rs.next()) {
			list.add( new Book(rs.getInt("bookId") , rs.getString("title") , rs.getInt("pubId")) );
		}
		
		return list;
		
	}
	
	public List<Publisher> retrievePublishers() throws SQLException {
		
		List<Publisher> list = new ArrayList<Publisher>();
		
		String query = "SELECT * FROM tbl_publisher";
		
		PreparedStatement stmnt = conn.prepareStatement(query);
		
		ResultSet rs = stmnt.executeQuery();
		
		while(rs.next()) {
			list.add(new Publisher
					(rs.getInt("publisherId"), rs.getString("publisherName") , rs.getString("publisherAddress"), rs.getString("publisherPhone")) );
		}
		
		
		return list;
		
	}
	
	public List<Author> retrieveAuthors() throws SQLException {
		
		List<Author> list = new ArrayList<Author>();
		
		String query = "SELECT * FROM tbl_author";
		
		PreparedStatement stmnt = conn.prepareStatement(query);
		
		ResultSet rs = stmnt.executeQuery();
		
		while(rs.next()) {
			list.add( new Author(rs.getInt("authorId"), rs.getString("authorName")) );
		}
		
		
		return list;
		
	}
	
	public List<Genre> retrieveGenres() throws SQLException {
		
		List<Genre> list = new ArrayList<Genre>();
		
		String query = "SELECT * FROM tbl_genre";
		
		PreparedStatement stmnt = conn.prepareStatement(query);
		
		ResultSet rs = stmnt.executeQuery();
		
		while(rs.next()) {
			list.add( new Genre(rs.getInt("genre_id"), rs.getString("genre_name")) );
		}
		
		
		return list;
		
	}
	
	public List<Borrower> retrieveBorrowers() throws SQLException {
		
		List<Borrower> list = new ArrayList<Borrower>();
		
		String query = "SELECT * FROM tbl_borrower";
		
		PreparedStatement stmnt = conn.prepareStatement(query);
		
		ResultSet rs = stmnt.executeQuery();
		
		while(rs.next()) {
			list.add( new Borrower
					(rs.getInt("cardNo"), rs.getString("name"), rs.getString("address"), rs.getString("phone")) );
		}
		
		
		return list;
		
	}
	
	public List<BookLoan> retrieveBookLoans() throws SQLException {
		
		List<BookLoan> list = new ArrayList<BookLoan>();
		
		String query = "SELECT * FROM tbl_book_loans";
		
		PreparedStatement stmnt = conn.prepareStatement(query);
		
		ResultSet rs = stmnt.executeQuery();
		
		while(rs.next()) 
			list.add(new BookLoan
					(rs.getInt("bookId"), rs.getInt("branchId"), rs.getInt("cardNo"), rs.getDate("dateOut"), rs.getDate("dueDate"), rs.getDate("dateIn") ));
		
		return list;
		
	}
	
	public List<String> retrieveBookLoansAndNames() throws SQLException {
		
		List<String> list = new ArrayList<String>();
		
		String query = "select name, title, tbl_book_loans.bookId, dateOut, dueDate, dateIn from tbl_book_loans "
				+ "LEFT JOIN tbl_borrower ON tbl_borrower.cardNo = tbl_book_loans.cardNo "
				+ "INNER JOIN tbl_book ON tbl_book_loans.bookId = tbl_book.bookId";
		
		PreparedStatement stmnt = conn.prepareStatement(query);
		
		ResultSet rs = stmnt.executeQuery();
		
		while(rs.next()) 
			list.add(String.format("%-20s %-20s %-20s %-20s %-20s", rs.getString("name"), rs.getString("title"), rs.getDate("dateOut"), rs.getDate("dueDate"), rs.getDate("dateIn")));
		
		return list;
		
	}
	
	
	public List<Book> retrieveBooksOfBranch(int branchId) throws SQLException {
		
		List<Book> list = new ArrayList<Book>();
		
		String subquery = "(SELECT bookId FROM tbl_book_copies WHERE branchId = "  + branchId + ")";
		
		StringBuilder query = new StringBuilder("SELECT * FROM tbl_book WHERE bookId IN ");
		query.append(subquery);
		
		PreparedStatement stmnt = conn.prepareStatement(query.toString());
		
		ResultSet rs = stmnt.executeQuery();
		
		while(rs.next())
			list.add( new Book(rs.getInt("BookId"), rs.getString("title"), rs.getInt("pubId")) );
		
		return list;
		
		

		
	}
	
	public Branch retrieveLibraryBranch(int id) throws SQLException {
		
		String query = "SELECT * FROM tbl_library_branch WHERE branchId = " + id;
		
		PreparedStatement stmnt = conn.prepareStatement(query);
		
		ResultSet rs = stmnt.executeQuery();
		
		if(rs.next())
			return new Branch(rs.getInt("branchId"), rs.getString("branchName"), rs.getString("branchAddress"));
		else
			throw new SQLException();
		
	}

	public List<Branch> retrieveLibraryBranches() throws SQLException {

		List<Branch> list = new ArrayList<>();

		String query = "SELECT * FROM tbl_library_branch";

		PreparedStatement stmnt = conn.prepareStatement(query);

		ResultSet rs = stmnt.executeQuery();

		while (rs.next())
			list.add(new Branch(rs.getInt("branchId"), rs.getString("branchName"), rs.getString("branchAddress")));

		return list;

	}
	
	public int updateLibraryBranch(int branchId, String newBranchName, String newBranchAddress) throws SQLException {
		
		StringBuilder query = new StringBuilder("UPDATE tbl_library_branch SET branchName = '" + newBranchName + "' , branchAddress = '" + newBranchAddress +"' ");
		query.append("WHERE branchId = " + branchId);

		PreparedStatement stmnt = conn.prepareStatement(query.toString());
		
		return stmnt.executeUpdate();
		
	}
	
	public int updateNumberOfCopies(int bookId, int branchId, int newCopies) throws SQLException {	
		
		StringBuilder query = new StringBuilder("UPDATE tbl_book_copies SET noOfCopies = " + newCopies + " ");
		query.append("WHERE branchId = " + branchId + " AND bookId = " + bookId);
		
		PreparedStatement stmnt = conn.prepareStatement(query.toString());
		
		return stmnt.executeUpdate();
		
	}
	
	public int updateBookLoan(int bookId, int branchId, int cardNo, String newDate) throws SQLException {
		
		String query = String.format
				("UPDATE tbl_book_loans SET dueDate = '%s' WHERE bookId = %d AND branchId = %d AND cardNo = %d", newDate, bookId, branchId, cardNo);
		
		PreparedStatement stmnt = conn.prepareStatement(query);
		
		return stmnt.executeUpdate();
		
	}
	
	public int updateBookLoanReturn(int bookId, int branchId, int cardNo) throws SQLException {
		
		String query = String.format("UPDATE tbl_book_loans SET dateIn = current_date() WHERE bookId = %d AND branchId = %d AND cardNo = %d" , 
				bookId, branchId, cardNo);
		
		PreparedStatement stmnt = conn.prepareStatement(query);
		
		return stmnt.executeUpdate();
		
	}
	
	public int createBookLoanEntry(int bookId, int branchId, int cardNo) throws SQLException {
		
		String query = String.format("INSERT INTO tbl_book_loans VALUES (%d, %d, %d, current_date() , DATE_ADD(current_date() , INTERVAL 7 DAY), null )", 
				bookId, branchId, cardNo);
		
		PreparedStatement stmnt = conn.prepareStatement(query);
		
		return stmnt.executeUpdate();
		
	}


	public int createBookCopies(int bookId, int branchId, int newCopies) throws SQLException {
		
		String query = String.format("INSERT INTO tbl_book_copies VALUES (%d, %d, %d)" , bookId, branchId, newCopies);
		
		PreparedStatement stmnt = conn.prepareStatement(query);
		
		return stmnt.executeUpdate();
		
	}

	public int createBook(String bookId, String title, String pubId) throws SQLException {
		
		String query = String.format("INSERT INTO tbl_book VALUES (%s , '%s' , %s)" , bookId, title, pubId);
		
		PreparedStatement stmnt = conn.prepareStatement(query);
		
		return stmnt.executeUpdate();
		
	}
	
	
	//TODO: fix case where phoneNumber input will be incorrectly read as an integer!
	
	public int createItem(String tableName, String[] fieldValues) throws SQLException {
		
		StringBuilder query = new StringBuilder("INSERT INTO ");
		
		query.append(tableName + " VALUES (");
		
		for(String s : fieldValues) {
			
			try {
				
				Integer.parseInt(s);
				query.append(String.format("%s, " , s));
				
			}catch(NumberFormatException e) { //String cannot be read as an integer, therefore it is not an integer.
				
				query.append(String.format("'%s', " , s));
				continue;
				
			}
			
		}
		
		//gets rid of ", " at the end of query after loop.
		query = new StringBuilder(query.substring(0, query.length()-2)) ;
		
		query.append(")");
		
		PreparedStatement stmnt = conn.prepareStatement(query.toString());
	
		return stmnt.executeUpdate();
		
	}

	public ResultSet retrieveResultSet(String tableName) throws SQLException {
		
		String query = String.format("SELECT * FROM %s" , tableName);
		
		PreparedStatement stmnt = conn.prepareStatement(query);
		
		return stmnt.executeQuery();
	}
	
	public int updateItem(String tableName, String field, String newFieldValue, String primaryField, int primaryKey) throws SQLException {
		
		try{
			String query = String.format("UPDATE %s SET %s = '%s' WHERE %s = %d",
					tableName, field, newFieldValue, primaryField, primaryKey);
			
			PreparedStatement stmnt = conn.prepareStatement(query);
			
			return stmnt.executeUpdate();
			
			
		}catch(SQLException e) { //newFieldValue is not a string, therefore treat as integer.
			
			String query = String.format("UPDATE %s SET %s = %s WHERE %s = %d", 
					tableName, field, newFieldValue, primaryField, primaryKey);
			
			PreparedStatement stmnt = conn.prepareStatement(query);
			
			return stmnt.executeUpdate();
			
		}
		
	}

	public int updateAuthor(String field, String newFieldValue, int primaryKey) throws SQLException{
		
		try{
			String query = String.format("UPDATE tbl_author SET %s = '%s' WHERE authorId = %d",
					field, newFieldValue, primaryKey);
			
			PreparedStatement stmnt = conn.prepareStatement(query);
			
			return stmnt.executeUpdate();
			
			
		}catch(SQLException e) { //newFieldValue is not a string, therefore treat as integer.
			
			String query = String.format("UPDATE tbl_author SET %s = %s WHERE authorId = %d", 
					field, newFieldValue, primaryKey);
			
			PreparedStatement stmnt = conn.prepareStatement(query);
			
			return stmnt.executeUpdate();
			
		}
		
	}

	public int deleteItem(Modelable item, String tableName, String primaryField) throws SQLException{
		
		String query = String.format
				("DELETE FROM %s WHERE %s = %d" , tableName, primaryField, item.getVerifiableAttribute() );
		
		PreparedStatement stmnt = conn.prepareStatement(query);
		
		return stmnt.executeUpdate();
		
		
	}

	public List<String> retrieveInfoOfBooks() throws SQLException {
		
		List<String> list = new ArrayList<String>();

		String query = "SELECT tbl_book.title, tbl_author.authorName, tbl_publisher.publisherName, tbl_genre.genre_name FROM tbl_book "
				+ "INNER JOIN tbl_book_authors ON tbl_book_authors.bookId = tbl_book.bookId "
				+ "INNER JOIN tbl_author ON tbl_author.authorId = tbl_book_authors.authorId "
				+ "INNER JOIN tbl_book_genres ON tbl_book_genres.bookId = tbl_book.bookId "
				+ "INNER JOIN tbl_genre ON tbl_genre.genre_id = tbl_book_genres.genre_id "
				+ "INNER JOIN tbl_publisher ON tbl_publisher.publisherId = tbl_book.pubId";
		
		PreparedStatement stmnt = conn.prepareStatement(query);
		
		ResultSet rs = stmnt.executeQuery();
		
		while(rs.next())
			list.add(String.format
					("%s by %s, published by %s [%s]", 
							rs.getString("title"), rs.getString("authorName"), rs.getString("publisherName"), rs.getString("genre_name").toUpperCase()) );
		
		return list;
		
	}

	public List<Branch> findBranchesWithBook(int bookId) throws SQLException {
		
		List<Branch> list = new ArrayList<Branch>();
		
		String query = "SELECT tbl_library_branch.branchId, branchName, branchAddress FROM tbl_book_copies "
				+ "INNER JOIN tbl_library_branch ON tbl_library_branch.branchId = tbl_book_copies.branchId "
				+ "WHERE bookId = %d";
			
			query = String.format(query, bookId);
			
		PreparedStatement stmnt = conn.prepareStatement(query);
		
		ResultSet rs = stmnt.executeQuery();
		
		while(rs.next())
			list.add(new Branch(rs.getInt("branchId"), rs.getString("branchName"), rs.getString("branchAddress") ) );
		
		return list;
		
	}
	


}
