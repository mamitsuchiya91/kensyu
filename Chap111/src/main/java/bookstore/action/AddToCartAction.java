package bookstore.action;

import java.sql.Connection;
import java.util.Arrays;
import java.util.List;

import javax.management.Query;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.ServletRequestAware;

import bookstore.db.BookDB;
import bookstore.mail.SimpleMailSender;
import bookstore.pbean.TBook;

@Results({
	@Result (name="addtocart", location="bookstore.jsp"),
	@Result (name="checkout", location="checkout.jsp")
})
public class AddToCartAction implements ServletRequestAware {
	//lblistは全書籍のデータを格納しておくリスト
	private List<TBook> lblist;
	private HttpServletRequest request;
	private String[] selecteditems = null;
	@Action("/Addtoaction")
	public String addtocart(){
		HttpSession session = request.getSession();
		//初期化
		session.removeAttribute("CART");
		if(selecteditems != null && selecteditems.length != 0){
			//cartに入れるためにarraysオブジェクトにかえる
			List<String> cart = Arrays.asList(selecteditems);
			//sessionに値を格納
			session.setAttribute("CART", cart);
		}
		HttpSession httpsession = request.getSession(false);
		List<String> cart = (List<String>)httpsession.getAttribute("CART");
		String user = (String) httpsession.getAttribute("USER");
		
		BookDB bookdb = new BookDB();
		try {
			bookdb.getConnection();
			lblist = bookdb.getListBook();
			bookdb.cart(cart, user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ("addtocart");
	}
	public String checkout(){
		HttpSession httpsession = request.getSession(false);
		String user = (String) httpsession.getAttribute("USER");
		String toAddr = "ratsrepap@gmail.com";
		String fromAddr = "databasetest1991@yahoo.co.jp";
		String personName = "Tsuchiya";
		String subject = "BookStoreからの注文";
		String message = user + "さんから注文が入りました。";
		SimpleMailSender mail = new SimpleMailSender();
		BookDB bookdb = new BookDB();
		int sum = 0;
		try {
			bookdb.getConnection();
			bookdb.ooo(user);
			//bookdb.orderlist(cart, user);
			sum = bookdb.getSummmmmm(user);
			//sum = bookdb.getSum(cart,user);
			mail.sendMessage(toAddr, fromAddr, personName, subject, message);
			} catch (Exception e) {
				e.printStackTrace();
			}
		request.setAttribute("SUM", sum);
		return ("checkout");
	}
	
	public List<TBook> getLblist(){
		return lblist;
	}
	public void setLblist(List<TBook> lblist){
		this.lblist = lblist;
	}
	public String[] getSelecteditems(){
		return selecteditems;
	}
	public void setSelecteditems(String[] selecteditems){
		this.selecteditems = selecteditems;
	}
	public void setServletRequest(HttpServletRequest request){
		this.request = request;
	}
	
}