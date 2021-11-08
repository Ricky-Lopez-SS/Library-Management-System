/**
 * 
 */
package entity;

/**
 * @author Lopez
 *
 */
public class Genre implements Modelable {
	
	private final String ITEMTYPE = "Genre";

	private int genreId;
	private String genreName;
	

	public Genre(int genreId, String genreName) {
		super();
		this.genreId = genreId;
		this.genreName = genreName;
	}

	public int getGenreId() {
		return genreId;
	}

	public void setGenreId(int genreId) {
		this.genreId = genreId;
	}

	public String getGenreName() {
		return genreName;
	}

	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}
	
	@Override
	public String toString() {
		return genreName;
	}
	
	@Override
	public String getItemType() {
		return ITEMTYPE;
	}
	
	@Override
	public int getVerifiableAttribute() {
		return genreId;
	}

}
