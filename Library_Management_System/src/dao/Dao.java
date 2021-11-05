/**
 * 
 */
package dao;

import java.sql.Connection;
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
				+ "INNER JOIN tbl_book_authors ON tbl_book.bookId = tbl_book_authors.bookId "
				+ "INNER JOIN tbl_author ON tbl_book_authors.authorId = tbl_author.authorId";
		
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

}
