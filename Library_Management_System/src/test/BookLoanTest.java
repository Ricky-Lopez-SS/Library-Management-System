/**
 * 
 */
package test;

/**
 * @BookLoan Lopez
 *
 */

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import java.sql.Date;

import entity.BookLoan;

public class BookLoanTest {
	
	BookLoan item = new BookLoan(1, 2, 3, Date.valueOf("2021-10-10"), Date.valueOf("2021-11-11"), Date.valueOf("2021-12-12") );
	
	
	
	@Test
	public void getVerifiableAttributeTest() {
		assertEquals(3, item.getVerifiableAttribute());
	}
	
	@Test
	public void getItemTypeTest() {
		assertEquals("Bookloan", item.getItemType());
	}
	
	@Test
	public void getBookIdTest() {
		assertEquals(1, item.getBookId());
	}
	
	@Test
	public void getBranchIdTest() {
		assertEquals(2, item.getBranchId());
	}
	
	@Test
	public void getCardNoTest() {
		assertEquals(3, item.getCardNo());
	}
	
	@Test
	public void getDateOutTest() {
		assertEquals(Date.valueOf("2021-10-10"), item.getDateOut());
	}
	
	@Test
	public void getDueDateTest() {
		assertEquals(Date.valueOf("2021-11-11"), item.getDueDate());
	}
	
	@Test
	public void getDateInTest() {
		assertEquals(Date.valueOf("2021-12-12"), item.getDateIn());
	}

}