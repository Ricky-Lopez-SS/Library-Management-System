package test;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import entity.Author;

public class AuthorTest {
	
	Author item = new Author(1, "authorName");
	
	@Test
	public void toStringTest() {
		assertEquals("authorName", item.toString());
	}
	
	
	@Test
	public void getVerifiableAttributeTest() {
		assertEquals(1, item.getVerifiableAttribute());
	}
	
	@Test
	public void getItemTypeTest() {
		assertEquals("Author", item.getItemType());
	}
	
	@Test
	public void getAuthorIdTest() {
		assertEquals(1, item.getAuthorId());
	}
	
	
	@Test
	public void getAuthorNameTest() {
		assertEquals("authorName", item.getAuthorName());
	}

}
