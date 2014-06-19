package bookstore.action;

	import java.sql.Connection;
import java.util.Arrays;
import java.util.List;

	import javax.management.Query;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

	import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.ServletRequestAware;

import bookstore.db.BookDB;
import bookstore.pbean.TBook;

@Results({
	@Result (name="detail", location="cart.jsp"),
	@Result (name="delete", location="cart.jsp")
})
public class DetailAction implements ServletRequestAware {
	private List<TBook> cartlist;
	private HttpServletRequest request;
	private String isbn = null;
	@Action("/Detail")
	public String detail(){
		HttpSession httpsession = request.getSession(false);
		String user = (String) httpsession.getAttribute("USER");
		BookDB bookdb = new BookDB();
		try {
			bookdb.getConnection();
			cartlist = bookdb.cartnakami(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ("detail");
	}
	
	public String delete(){
		HttpSession httpsession = request.getSession(false);
		String user = (String) httpsession.getAttribute("USER");
		BookDB bookdb = new BookDB();
		try{
			bookdb.getConnection();
			bookdb.delete(isbn);
			cartlist = bookdb.cartnakami(user);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return ("delete");
	}
	public String getIsbn(){
		return isbn;
	}
	public void setIsbn(String isbn){
		this.isbn = isbn;
	}
	public List<TBook> getCartlist(){
		return cartlist;
	}
	public void setCartlist(List<TBook> cartlist){
		this.cartlist = cartlist;
	}
	public void setServletRequest(HttpServletRequest request){
		this.request = request;
	}
	
}