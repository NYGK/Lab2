package action;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import sql.Dbpool;
import model.*;
public class FindBookWithAuthorName extends ActionSupport{
	private String AuthorName;
	private List<Book> booklist;
	
	public List<Book> getBooklist() {
		return booklist;
	}
	public void setBooklist(List<Book> booklist) {
		this.booklist = booklist;
	}
	public String getAuthorName(){
		return this.AuthorName;
	}
	public void setAuthorName(String AuthorName){
		this.AuthorName = AuthorName;
	}
	
	public String execute()
	{
		if(AuthorName.length() == 0)
			return "INPUT";
		else{
			booklist = Dbpool.searchBookWithAuthorName(AuthorName);
			if(booklist.size()==0)
				return "EMPTY";
			return "SUCCESS";
		}
			
	}
}
