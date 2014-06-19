package bookstore.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import bookstore.db.BookDB;
import bookstore.pbean.TBook;

@Results({
	@Result (name="order", location="order.jsp"),
	@Result (name="manager", location="manager.jsp"),
	@Result (name="deleteorder", location="order.jsp")
})
public class ManagerAction {
	private List<TBook> orderlist;
	private HttpServletRequest request;
	private String isbn = null;
	@Action("/Manager")
	public String order(){
		BookDB bookdb = new BookDB();
		try {
			bookdb.getConnection();
			orderlist = bookdb.ordernakami();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ("order");
	}
	public String deleteorder(){
		BookDB bookdb = new BookDB();
		try{
			bookdb.getConnection();
			bookdb.orderdelete(isbn);
			orderlist = bookdb.ordernakami();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return ("deleteorder");
	}
	public String manager(){
		return "manager";
	}
	public List<TBook> getOrderlist(){
		return orderlist;
	}
	public void setOrderlist(List<TBook> orderlist){
		this.orderlist = orderlist;
	}
	public void setServletRequest(HttpServletRequest request){
		this.request = request;
	}
	public String getIsbn(){
		return isbn;
	}
	public void setIsbn(String isbn){
		this.isbn = isbn;
	}
}
