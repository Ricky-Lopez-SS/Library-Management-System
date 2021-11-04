/**
 * 
 */
package entity;

/**
 * @author Lopez
 *
 */
public class Genre {

	private int genreId;
	private int genreName;
	

	public Genre(int genreId, int genreName) {
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

	public int getGenreName() {
		return genreName;
	}

	public void setGenreName(int genreName) {
		this.genreName = genreName;
	}

}
