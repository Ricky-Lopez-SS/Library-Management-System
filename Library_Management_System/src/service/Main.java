/**
 * 
 */
package service;

import java.util.Scanner;
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
		Scanner scnnr = new Scanner(System.in);
		
		String input = "";
		int code = 0; //initialized with main menu code. 
		
		//TODO: clean up Main and handle return codes!
		//TODO: close scanner
		

		View.displayMain();
		
		while(scnnr.hasNextLine()) {
			input = scnnr.nextLine();
		
			if("1".equals(input)) 
				code = new Librarian(DB, scnnr).lib1();
			else if("2".equals(input)) 
				code = new Administrator(DB, scnnr).admin1();
			else if("3".equals(input)) 
				code = new User(DB, scnnr).bor1();
			else if("quit".equals(input.toLowerCase())) {
				scnnr.close();
				return;
			}else
				View.printUserErr();
			
			if(code == 0) {
				View.displayMain();
				continue;
			}
		}
			

		

	}
	

}
