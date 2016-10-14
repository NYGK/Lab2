package model;
import model.Book;
public class BookDetail extends Book{
	private String AuthorAge;
	private String AuthorCountry;
	private String AuthorName;
	public String getAuthorAge() {
		return AuthorAge;
	}
	public void setAuthorAge(String authorAge) {
		AuthorAge = authorAge;
	}
	public String getAuthorCountry() {
		return AuthorCountry;
	}
	public void setAuthorCountry(String authorCountry) {
		AuthorCountry = authorCountry;
	}
	public String getAuthorName() {
		return AuthorName;
	}
	public void setAuthorName(String authorName) {
		AuthorName = authorName;
	}
	
	
}
