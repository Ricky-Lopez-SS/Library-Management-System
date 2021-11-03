/**
 * 
 */
package view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

/**
 * @author Lopez
 *
 */
public class Main {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	
	public static final String driver= "";
	public static final String url = "jdbc:mysql://localhost/library";
	public static final String username = "root";
	public static final String password = "Rubio0323"; //TODO :HIDE LATER!
	
	public static void main(String[] args) throws InterruptedException {
		
		try{
			
			Class.forName(driver); //throws error but still works?
			
			Connection conn = DriverManager.getConnection(url, username, password);
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		

		View.displayMain();
		TimeUnit.SECONDS.sleep(3);
		View.displayLib1();

	}

}
