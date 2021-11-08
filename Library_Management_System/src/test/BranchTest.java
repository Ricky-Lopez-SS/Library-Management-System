/**
 * 
 */
package test;

/**
 * @Branch Lopez
 *
 */

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import entity.Branch;

public class BranchTest {
	
	Branch item = new Branch(1, "BranchName", "111 memory lane");
	
	@Test
	public void toStringTest() {
		assertEquals("BranchName", item.toString());
	}
	
	
	@Test
	public void getVerifiableAttributeTest() {
		assertEquals(1, item.getVerifiableAttribute());
	}
	
	@Test
	public void getItemTypeTest() {
		assertEquals("Branch", item.getItemType());
	}
	
	@Test
	public void getBranchIdTest() {
		assertEquals(1, item.getBranchId());
	}
	
	
	@Test
	public void getBranchNameTest() {
		assertEquals("BranchName", item.getBranchName());
	}
	
	@Test
	public void getBranchAddressTest() {
		assertEquals("111 memory lane", item.getBranchAddress());
	}


}