/**
 * 
 */
package test;

/**
 * @Borrower Lopez
 *
 */

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import entity.Borrower;

public class BorrowerTest {
	
	Borrower item = new Borrower(1, "BorrowerName", "111 memory lane", "111-111-1111");
	
	@Test
	public void toStringTest() {
		assertEquals("BorrowerName", item.toString());
	}
	
	
	@Test
	public void getVerifiableAttributeTest() {
		assertEquals(1, item.getVerifiableAttribute());
	}
	
	@Test
	public void getItemTypeTest() {
		assertEquals("Borrower", item.getItemType());
	}
	
	@Test
	public void getCardNoTest() {
		assertEquals(1, item.getCardNo());
	}
	
	
	@Test
	public void getNameTest() {
		assertEquals("BorrowerName", item.getName());
	}
	
	@Test
	public void getAddressTest() {
		assertEquals("111 memory lane", item.getAddress());
	}
	
	@Test
	public void getPhoneTest() {
		assertEquals("111-111-1111", item.getPhone());
	}

}