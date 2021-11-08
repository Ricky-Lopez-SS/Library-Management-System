/**
 * 
 */
package test;

/**
 * @Publisher Lopez
 *
 */

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import entity.Publisher;

public class PublisherTest {
	
	Publisher item = new Publisher(1, "PublisherName", "111 memory lane", "111-111-1111");
	
	@Test
	public void toStringTest() {
		assertEquals("PublisherName", item.toString());
	}
	
	
	@Test
	public void getVerifiableAttributeTest() {
		assertEquals(1, item.getVerifiableAttribute());
	}
	
	@Test
	public void getItemTypeTest() {
		assertEquals("Publisher", item.getItemType());
	}
	
	@Test
	public void getPublisherIdTest() {
		assertEquals(1, item.getPublisherId());
	}
	
	
	@Test
	public void getPublisherNameTest() {
		assertEquals("PublisherName", item.getPublisherName());
	}
	
	@Test
	public void getPublisherAddressTest() {
		assertEquals("111 memory lane", item.getPublisherAddress());
	}
	
	@Test
	public void getPublisherPhoneTest() {
		assertEquals("111-111-1111", item.getPublisherPhone());
	}

}