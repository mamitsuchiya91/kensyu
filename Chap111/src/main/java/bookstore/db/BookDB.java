package bookstore.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bookstore.pbean.TBook;

public class BookDB extends BookDao{
	//�{�̏���S���擾���郁�\�b�h�B
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
	//�`�F�b�N���ꂽ���i�ƌڋq�������т��郁�\�b�h
	public List<TBook> getCostomer() throws Exception{
		String sql = "id, costomer_id_fk FROM lecture.t_book LEFT JOIN lecture.t_order ON t_order.id = t_book_id";
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet rs = statement.executeQuery();
		List<TBook> resultList = new ArrayList<TBook>();	
		while (rs.next()){
			TBook book = new TBook();
			book.setId(rs.getInt("id"));
			book.setCostomer_id_fk(rs.getInt("costomer_id_fk"));
			resultList.add(book);
		}
		return resultList;
	}
	//isbn�ԍ��ɂ���Ė{�̏��Ƃ��󂯎��
	public TBook sumISB(String iterBookISBN)throws Exception{
		TBook tb = new TBook();
		String sql = "INSERT INTO lecture.t_order_detail (order_id_fk, book_id_fk)" + "VALUES (?, ?)";
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet rs = statement.executeQuery();		
		while (rs.next()){
			//book.setId(rs.getInt("id"));
		}
		return tb;
	}
	
	
	//�I�����ꂽ���̂�price���Ăяo���č��v���o��
	public TBook sumISBN(String iterBookISBN)throws Exception{
		TBook tb = new TBook();
		String sql = "INSERT INTO lecture.t_order_detail (order_id_fk, book_id_fk)" + "VALUES (?, ?)";
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet rs = statement.executeQuery();		
		while (rs.next()){
			//book.setId(rs.getInt("id"));
		}
		return tb;
	}
}