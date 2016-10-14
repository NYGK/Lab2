package sql;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.*;


public class Dbpool {
	
	private static Connection getConn() {
	    String driver = "com.mysql.jdbc.Driver";
	    String url = "jdbc:mysql://nxzqamtlputd.rds.sae.sina.com.cn:10585/mybooklibrary?useUnicode=true&characterEncoding=utf-8&useSSL=false";
	    String username = "root";
	    String password = "sonofab1tch";
	    Connection conn = null;
	    try {
	        Class.forName(driver); //classLoader,加载对应驱动
	        conn = (Connection) DriverManager.getConnection(url, username, password);
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return conn;
	}
	public static void deleteBook(String ISBN)
	{
		
		    Connection conn = getConn();
		    int i = 0;
		    String sql = "delete from book where ISBN='" + ISBN + "'";
		    PreparedStatement pstmt;
		    try {
		        pstmt = (PreparedStatement) conn.prepareStatement(sql);
		        i = pstmt.executeUpdate();
		        
		        pstmt.close();
		        conn.close();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
	}
	public static int insertBook(Book book){
		Connection conn = getConn();
	    int i = 0;
	    String sql = "insert into book (ISBN,Title,AuthorID,Publisher,PublishDate,Price) values(?,?,?,?,?,?)";
	    PreparedStatement pstmt;
	    try {
	        pstmt = (PreparedStatement) conn.prepareStatement(sql);
	        pstmt.setString(1, book.getISBN());
	        pstmt.setString(2, book.getTitle());
	        pstmt.setString(3, book.getAuthorID());
	        pstmt.setString(4, book.getPublisher());
	        pstmt.setString(5, book.getPublishDate());
	        pstmt.setString(6, book.getPrice());
	        i = pstmt.executeUpdate();
	        pstmt.close();
	        conn.close();
	    } catch (SQLException e) {
	        return 0;
	    }
	    return i;
	}
	public static int insertAuthor(Author author){
		Connection conn = getConn();
	    int i = 0;
	    String sql = "insert into author (AuthorID,Name,Age,Country) values(?,?,?,?)";
	    PreparedStatement pstmt;
	    try {
	        pstmt = (PreparedStatement) conn.prepareStatement(sql);
	        pstmt.setString(1, author.getAuthorID());
	        pstmt.setString(2, author.getName());
	        pstmt.setString(3, author.getAge());
	        pstmt.setString(4, author.getCountry());
	        i = pstmt.executeUpdate();
	        pstmt.close();
	        conn.close();
	    } catch (SQLException e) {
	        return 0;
	    }
	    return i;
	}
	public static int updateBook(Book book) {
	    Connection conn = getConn();
	    int i = 0;
	    String sql = "update book set AuthorID='" + book.getAuthorID() + "',Price = '"+ book.getPrice() + "',PublishDate = '" + book.getPublishDate()+"',Publisher = '"+book.getPublisher() + "',Title = '"+book.getTitle()+ "' where ISBN='" + book.getISBN() + "'";
	    PreparedStatement pstmt;
	    try {
	        pstmt = (PreparedStatement) conn.prepareStatement(sql);
	        i = pstmt.executeUpdate();
	        pstmt.close();
	        conn.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return i;
	}
	public static BookDetail FindBookDetailWithISBN(String ISBN) {
		Connection conn = getConn();
		
    	PreparedStatement pstmt;
	    try {
	    	String sql = "select * from book where ISBN='"+ISBN+"'";
	        pstmt = (PreparedStatement)conn.prepareStatement(sql);
	        ResultSet rs = pstmt.executeQuery();
	        BookDetail detail = new BookDetail();
	        while (rs.next()) {
	        	detail.setAuthorID(rs.getString("AuthorID"));
	        	detail.setISBN(rs.getString("ISBN"));
	        	detail.setPrice(rs.getString("Price"));
	        	detail.setPublishDate(rs.getString("PublishDate"));
	        	detail.setPublisher(rs.getString("Publisher"));
	        	detail.setTitle(rs.getString("Title"));
	        } 
	        sql = "select * from author where AuthorID='"+detail.getAuthorID()+"'";
	        pstmt = (PreparedStatement)conn.prepareStatement(sql);
	        rs = pstmt.executeQuery();
	        while (rs.next()) {
	        	detail.setAuthorAge(rs.getString("Age"));
	        	detail.setAuthorCountry(rs.getString("Country"));
	        	detail.setAuthorName(rs.getString("Name"));
	        } 
	        conn.close(); 
	        return detail;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return null;
	    }
	}
	public static List<Book> searchBookWithAuthorName(String name) {
	    Connection conn = getConn();
	    List<Author> AuthorList = FindAuthorWithName(name) ;
	    List<Book> ResultBookList = new ArrayList<Book>();
	    for(int i = 0;i <AuthorList.size();i++)
	    {
	    	Author tempAuthor = AuthorList.get(i);
	    	List<Book> TempBookList = new ArrayList<Book>();
	    	String sql = "select * from book where AuthorID='"+tempAuthor.getAuthorID()+"'";
	    	PreparedStatement pstmt;
		    try {
		        pstmt = (PreparedStatement)conn.prepareStatement(sql);
		        ResultSet rs = pstmt.executeQuery();
		        
		        while (rs.next()) {
		        	Book TempBook = new Book();
		        	TempBook.setAuthorID(rs.getString("AuthorID"));
		        	TempBook.setISBN(rs.getString("ISBN"));
		        	TempBook.setPrice(rs.getString("Price"));
		        	TempBook.setPublishDate(rs.getString("PublishDate"));
		        	TempBook.setPublisher(rs.getString("Publisher"));
		        	TempBook.setTitle(rs.getString("Title"));
		        	TempBookList.add(TempBook);   
		        }
		            
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    ResultBookList.addAll(TempBookList);
	    }
	    return ResultBookList;
	}
	public static List<Author> FindAuthorWithName(String name) {
		Connection conn = getConn();
	    String sql = "select * from author where Name ='" + name + "'";
	    PreparedStatement pstmt;
	    try {
	        pstmt = (PreparedStatement)conn.prepareStatement(sql);
	        ResultSet rs = pstmt.executeQuery();
	        List<Author> AuthorList = new ArrayList<Author>();
	        while (rs.next()) {
	        	Author temp = new Author();
	        	temp.setAge(rs.getString("Age"));
	        	temp.setAuthorID(rs.getString("AuthorID"));
	        	temp.setCountry(rs.getString("Country"));
	        	temp.setName(rs.getString("Name"));
	        	AuthorList.add(temp);
	        }
	        conn.close();
	        return AuthorList;
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return null;
	}
	public static List<Author> FindAuthorWithID(String AuthorID) {
		Connection conn = getConn();
	    String sql = "select * from author where AuthorID ='" + AuthorID + "'";
	    PreparedStatement pstmt;
	    try {
	        pstmt = (PreparedStatement)conn.prepareStatement(sql);
	        ResultSet rs = pstmt.executeQuery();
	        List<Author> AuthorList = new ArrayList<Author>();
	        while (rs.next()) {
	        	Author temp = new Author();
	        	temp.setAge(rs.getString("Age"));
	        	temp.setAuthorID(rs.getString("AuthorID"));
	        	temp.setCountry(rs.getString("Country"));
	        	temp.setName(rs.getString("Name"));
	        	AuthorList.add(temp);
	        }
	        conn.close();
	        return AuthorList;
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return null;
	}

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		List<Book> booklist = Dbpool.searchBookWithAuthorName("草拟吗");
		
		
		
	}

}
