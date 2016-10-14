package action;

import java.util.List;

import model.Author;
import model.Book;
import model.BookDetail;
import sql.Dbpool;

public class AddBook {
	private BookDetail detail;
	
	public BookDetail getDetail() {
		return detail;
	}

	public void setDetail(BookDetail detail) {
		this.detail = detail;
	}

	public String execute()
	{
		Book book = new Book();
		Author author = new Author();
		author.setAge(this.detail.getAuthorAge());
		author.setAuthorID(this.detail.getAuthorID());
		author.setCountry(this.detail.getAuthorCountry());
		author.setName(this.detail.getAuthorName());
		book.setISBN(detail.getISBN());
		book.setTitle(detail.getTitle());
		book.setAuthorID(detail.getAuthorID());
		book.setISBN(detail.getISBN());
		book.setPrice(detail.getPrice());
		book.setPublishDate(detail.getPublishDate());
		book.setPublisher(detail.getPublisher());
		book.setTitle(detail.getTitle());
		
		List<Author> tempAuthor = Dbpool.FindAuthorWithID(author.getAuthorID());
		if(tempAuthor.size() == 0)
			Dbpool.insertAuthor(author);
		else
		{
			if(!(tempAuthor.get(0).equals(author)))
				return "ERROR";
		}
		BookDetail tempBook = Dbpool.FindBookDetailWithISBN(detail.getISBN());
		if(tempBook.ISBN==null)		
		{
			Dbpool.insertBook(book);
			return "SUCCESS";
		}
		else
			return "ERROR";
			
	}
}
