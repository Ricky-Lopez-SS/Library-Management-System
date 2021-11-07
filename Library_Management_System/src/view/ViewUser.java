package view;

import java.util.List;

import entity.Branch;

public class ViewUser {
	
public static void displayCardCheck() {
		
		System.out.format("%n*******************************************************************%n%n");
		
		System.out.format("Please enter your Card Number:%n%n");
		
	}
	
	public static void displayBor1(String name) {
		
		System.out.format("%n*******************************************************************%n%n");
		
		System.out.format("Hello, %s! What would you like to do?%n%n", name);
		
		System.out.println("1) Check out a Book");
		System.out.println("2) Return a Book");
		System.out.format("%n3) Quit to Main Menu%n%n");
		
	}
	
	public static void displayBor2(List<Branch> branchList) {
		
		System.out.format("%n*******************************************************************%n%n");
		
		System.out.format("Pick the Branch you want to check out%n%n");
		
		int counter;
		
		for(counter = 1; counter <= branchList.size(); counter++)
			System.out.format("%d) %s Library%n" , counter, branchList.get(counter-1).getBranchName());
		
		System.out.format("%n%d) Quit to previous menu%n%n", counter);
		
	}
	
	public static void displayBor2Cont(List<String> list) {
		
		System.out.format("Pick the Book you would like to check out.%n%n");
		
		int counter;
		
		for(counter = 1; counter <= list.size(); counter++) 
			System.out.format("%d) %s%n" , counter , list.get(counter - 1));
		
		System.out.format("%n%d) Quit to Main Menu%n%n", counter);
		
		
		
		
	}
	
	public static void displayBor3(List<Branch> branchList) {
		
		System.out.format("%n*******************************************************************%n%n");
		
		System.out.format("Pick the Branch you want to return a book to.%n%n");
		
		int counter;
		
		for(counter = 1; counter <= branchList.size(); counter++)
			System.out.format("%d) %s Library%n" , counter, branchList.get(counter-1).getBranchName());
		
		System.out.format("%n%d) Quit to previous menu%n%n", counter);
		
	}
	
	public static void displayBor3Cont(List<String> list) {
		
		System.out.format("Pick the Book you would like to return. %n%n");
		
		int counter;
		
		for(counter = 1; counter <= list.size(); counter++) 
			System.out.format("%d) %s%n" , counter , list.get(counter - 1));
		
		System.out.format("%n%d) Quit to Main Menu%n%n", counter);
		
		
		
		
	}
	

}
