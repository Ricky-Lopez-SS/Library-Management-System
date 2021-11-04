/**
 * 
 */
package service;

import java.util.concurrent.TimeUnit;

import dao.Dao;
import view.View;
/**
 * @author Lopez
 *
 */
public class Main {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	
	public static void main(String[] args) throws InterruptedException {
		
		Dao DB = new Dao();
		
		//TODO: clean up Main and handle return codes!
		

		View.displayMain();
		TimeUnit.SECONDS.sleep(3);
		int Lib2Code = Librarian.lib1(DB);
		

	}
	

}
