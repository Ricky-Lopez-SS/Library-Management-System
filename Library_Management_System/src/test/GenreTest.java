/**
 * 
 */
package test;

/**
 * @Genre Lopez
 *
 */

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import entity.Genre;

public class GenreTest {
	
	Genre item = new Genre(1, "GenreName");
	
	@Test
	public void toStringTest() {
		assertEquals("GenreName", item.toString());
	}
	
	
	@Test
	public void getVerifiableAttributeTest() {
		assertEquals(1, item.getVerifiableAttribute());
	}
	
	@Test
	public void getItemTypeTest() {
		assertEquals("Genre", item.getItemType());
	}
	
	@Test
	public void getGenreIdTest() {
		assertEquals(1, item.getGenreId());
	}
	
	
	@Test
	public void getGenreNameTest() {
		assertEquals("GenreName", item.getGenreName());
	}
	

}