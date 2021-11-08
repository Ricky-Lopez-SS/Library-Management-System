/**
 * 
 */
package entity;

/**
 * @author Lopez
 *
 */
public class Author implements Modelable{
	
	private final String ITEMTYPE = "Author";
	
	private int authorId;
	private String authorName;


	public Author(int authorId, String authorName) {
		super();
		this.authorId = authorId;
		this.authorName = authorName;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
	

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	
	@Override
	public String toString() {
		
		return authorName;
	}
	
	@Override
	public String getItemType() {
		return ITEMTYPE;
	}
	
	@Override
	public int getVerifiableAttribute() {
		return authorId;
	}
	

}
