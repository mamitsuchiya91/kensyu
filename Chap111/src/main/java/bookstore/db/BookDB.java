package bookstore.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bookstore.pbean.TBook;

public class BookDB extends BookDao{
	//本の情報を全部取得するメソッド。
	public List<TBook> getListBook()throws Exception{
		String sql = "SELECT title, author, price, publisher, isbn, id FROM lecture.t_book";
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet rs = statement.executeQuery();
		List<TBook> resultList = new ArrayList<TBook>();
		while (rs.next()){
			TBook book = new TBook();
			book.setTitle(rs.getString("title"));
			book.setAuthor(rs.getString("author"));
			book.setPrice(rs.getInt("price"));
			book.setPublisher(rs.getString("publisher"));
			book.setIsbn(rs.getString("isbn"));
			book.setId(rs.getInt("id"));
			resultList.add(book);
		}
		return resultList;
	}
	public TBook findBookByISBN(String iterBookISBN)throws Exception{
		String sql = "SELECT title, author, price, publisher, isbn, id FROM t_book where isbn = '"
				+ iterBookISBN
				+ "'";
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet rs = statement.executeQuery();
		TBook book = new TBook();
		while (rs.next()){
			book.setTitle(rs.getString("title"));
			book.setAuthor(rs.getString("author"));
			book.setPrice(rs.getInt("price"));
			book.setPublisher(rs.getString("publisher"));
			book.setIsbn(rs.getString("isbn"));
			book.setId(rs.getInt("id"));
		}
		return book;
	}
	
	
	public int getSum(List<String> cart) throws Exception{
		String[] str = cart.toArray(new String[cart.size()]);
		String arr = "";
		for (String st: str){
			arr +="'" + st +"',";
		}
		String sql = "SELECT SUM(price) sum from t_book where isbn in ("
				+ arr
				+ "'0')";
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet rs = statement.executeQuery();
		int resultList = 0;	
		while (rs.next()){
			resultList = rs.getInt("sum");
		}
		return resultList;
	}
	public int registerInsert(TBook tb) throws Exception{
		String sql = "INSERT INTO lecture.t_customer(userid, upass, uname, umail, uadd, utel )" + "VALUES (?, ?, ?, ?, ?, ?);";
		int result = 0;
		try{
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, tb.getUserid());
			statement.setString(2, tb.getUpass());
			statement.setString(3, tb.getUname());
			statement.setString(4, tb.getUmail());
			statement.setString(5, tb.getUadd());
			statement.setString(6, tb.getUtel());
			result = statement.executeUpdate();
			connection.commit();
		}catch (Exception e){
			connection.rollback();
			throw e;
		}
		return result;
	}
}