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

	public static final String driver = "com.mysql.cj.jdbc.Driver";
	public static final String url = "jdbc:mysql://localhost/library";
	public static final String username = "root";
	public static final String password = "Rubio0323"; // TODO :HIDE LATER!

	private Connection conn;

	public Dao() {
		super();

		try {

			Class.forName(driver); // throws error but still works?
			this.conn = DriverManager.getConnection(url, username, password);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

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

}
