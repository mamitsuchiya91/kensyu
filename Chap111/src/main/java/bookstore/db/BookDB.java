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
	
	/*
	public int getSum(List<String> cart) throws Exception{
		String[] str = cart.toArray(new String[cart.size()]);
		String arr = "";
		for (String st: str){
			arr +="'" + st +"',";
		}
		String sql = "SELECT SUM(price) sum from t_book where isbn in ("
				+ arr
				+ "'a')";
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet rs = statement.executeQuery();
		int resultList = 0;	
		while (rs.next()){
			resultList = rs.getInt("sum");
		}
		return resultList;
	}
	*/
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
	
	public void cart(List<String> cart, String user) throws Exception{
		String[] str = cart.toArray(new String[cart.size()]);
		String sql = "INSERT INTO lecture.t_cartcheck(isbn, userid)" + "VALUES (?, ?);";
		try{
			for (String st: str){
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, st);
			statement.setString(2, user);
			statement.executeUpdate();
			connection.commit();
			}
		}catch (Exception e){
			connection.rollback();
			throw e;
		}
	}
	public List<TBook> cartnakami(String user) throws Exception{
		String sql = "SELECT t_book.isbn, t_cartcheck.id, t_book.title, t_book.author, t_book.publisher, t_book.price, t_cartcheck.userid FROM t_cartcheck left JOIN t_book ON t_book.isbn = t_cartcheck.isbn where t_cartcheck.userid in ('"
				+ user
				+ "'); ";
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
	public void delete(String isbn) throws Exception{
		String sql = "DELETE FROM t_cartcheck where isbn = ?";
		try{
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, isbn);
			statement.executeUpdate();
			connection.commit();
		}catch(Exception e){
			connection.rollback();
			throw e;
		}
	}
	public int newbooker(TBook tb) throws Exception{
		String sql = "INSERT INTO lecture.t_book(title, author, publisher, price, isbn )" + "VALUES (?, ?, ?, ?, ?);";
		int result = 0;
		try{
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, tb.getTitle());
			statement.setString(2, tb.getAuthor());
			statement.setString(3, tb.getPublisher());
			statement.setInt(4, tb.getPrice());
			statement.setString(5, tb.getIsbn());
			result = statement.executeUpdate();
			connection.commit();
		}catch (Exception e){
			connection.rollback();
			throw e;
		}
		return result;
	}
	
	public void orderlist(List<String> cart, String user) throws Exception{
		String[] str = cart.toArray(new String[cart.size()]);
		String sql = "INSERT INTO lecture.t_orderlist(isbn, userid)" + "VALUES (?, ?);";
		try{
			for (String st: str){
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, st);
			statement.setString(2, user);
			statement.executeUpdate();
			connection.commit();
			}
		}catch (Exception e){
			connection.rollback();
			throw e;
		}
	}
	public List<TBook> ordernakami() throws Exception{
		String sql = "SELECT t_orderlist.isbn, t_customer.uname, t_customer.umail, t_customer.uadd, t_orderlist.orderday, t_customer.utel FROM t_orderlist left JOIN t_customer ON t_orderlist.userid = t_customer.userid ORDER BY t_orderlist.orderday ASC;";
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet rs = statement.executeQuery();
		List<TBook> resultList = new ArrayList<TBook>();
		while (rs.next()){
			TBook book = new TBook();
			book.setIsbn(rs.getString("isbn"));
			book.setUname(rs.getString("uname"));
			book.setUmail(rs.getString("umail"));
			book.setUadd(rs.getString("uadd"));
			book.setUtel(rs.getString("utel"));
			book.setOrderday(rs.getTimestamp("orderday"));
			resultList.add(book);
		}
		return resultList;
	}
	public void ooo(String user) throws Exception{
		String sql = "insert into t_orderlist(userid, isbn) select userid, isbn from t_cartcheck where userid in ('"
				+ user
				+ "');";
		try{
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.executeUpdate();
			connection.commit();
		}catch(Exception e){
			connection.rollback();
			throw e;
		}
	}
	public int getSummmmmm(String userid) throws Exception{
		String sql = "SELECT SUM(price) sum FROM t_book JOIN t_orderlist ON t_book.isbn = t_orderlist.isbn where t_orderlist.userid in ('"
				+ userid
				+ "'a')";
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet rs = statement.executeQuery();
		int resultList = 0;	
		while (rs.next()){
			resultList = rs.getInt("sum");
		}
		return resultList;
	}
	public void orderdelete(String isbn) throws Exception{
		String sql = "DELETE FROM t_orderlist where isbn = ?";
		try{
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, isbn);
			statement.executeUpdate();
			connection.commit();
		}catch(Exception e){
			connection.rollback();
			throw e;
		}
	}
	public String hozon(String user) throws Exception{
		String sql = "SELECT t_book.isbn, t_cartcheck.id, t_book.title, t_book.author, t_book.publisher, t_book.price, t_cartcheck.userid FROM t_cartcheck left JOIN t_book ON t_book.isbn = t_cartcheck.isbn where t_cartcheck.userid in ('"
				+ user
				+ "'); ";
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet rs = statement.executeQuery();
		String resultList ="";
		while (rs.next()){
			TBook book = new TBook();
			book.setTitle(rs.getString("title"));
			book.setAuthor(rs.getString("author"));
			book.setPrice(rs.getInt("price"));
			book.setPublisher(rs.getString("publisher"));
			book.setIsbn(rs.getString("isbn"));
			book.setId(rs.getInt("id"));
			}
			return resultList;
	}
}