package test;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import entity.Book;

public class BookTest {
	
	Book item = new Book(1, "BookName", 1);
	
	@Test
	public void toStringTest() {
		assertEquals("BookName", item.toString());
	}
	
	
	@Test
	public void getVerifiableAttributeTest() {
		assertEquals(1, item.getVerifiableAttribute());
	}
	
	@Test
	public void getItemTypeTest() {
		assertEquals("Book", item.getItemType());
	}
	
	@Test
	public void getBookIdTest() {
		assertEquals(1, item.getBookId());
	}
	
	
	@Test
	public void getTitleTest() {
		assertEquals("BookName", item.getTitle());
	}
	
	@Test
	public void getPubIdTest() {
		assertEquals(1, item.getPubId());
	}

}