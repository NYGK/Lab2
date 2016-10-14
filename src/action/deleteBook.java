package action;

import model.BookDetail;
import sql.Dbpool;

public class deleteBook {
	
	BookDetail detail;

	public BookDetail getDetail() {
		return detail;
	}

	public void setDetail(BookDetail detail) {
		this.detail = detail;
	}
	public String execute()
	{
		Dbpool.deleteBook(detail.getISBN());
		return "SUCCESS";
	}
}
