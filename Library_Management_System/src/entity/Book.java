/**
 * 
 */
package entity;

/**
 * @author Lopez
 *
 */
public class Book implements Modelable {

	private final String ITEMTYPE = "Book";
	
	private int bookId;
	private String title;
	private int pubId;

	public Book(int bookId, String title, int pubId) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.pubId = pubId;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPubId() {
		return pubId;
	}

	public void setPubId(int pubId) {
		this.pubId = pubId;
	}
	
	@Override
	public String toString() {
		return title;
	}

	@Override
	public String getItemType() {
		return ITEMTYPE;
	}
	
	@Override
	public int getVerifiableAttribute() {
		return bookId;
	}
}
