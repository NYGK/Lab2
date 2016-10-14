package action;

import model.BookDetail;
import sql.Dbpool;

public class EditBook {
	BookDetail detail;
	
	public BookDetail getDetail() {
		return detail;
	}

	public void setDetail(BookDetail detail) {
		this.detail = detail;
	}

	public String execute()
	{
		this.detail =  Dbpool.FindBookDetailWithISBN(detail.getISBN());
		return "SUCCESS";
	}
}
