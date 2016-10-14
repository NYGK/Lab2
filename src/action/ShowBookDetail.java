package action;

import model.*;
import sql.Dbpool;

public class ShowBookDetail {
	private String ISBN;
	BookDetail detail;
	
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public BookDetail getDetail() {
		return detail;
	}
	public void setDetail(BookDetail detail) {
		this.detail = detail;
	}
	public String execute()
	{
		detail = Dbpool.FindBookDetailWithISBN(ISBN);
		return "SUCCESS";
	}

}
