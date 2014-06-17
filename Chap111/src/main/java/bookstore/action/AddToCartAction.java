package bookstore.action;

import java.sql.Connection;
import java.util.Arrays;
import java.util.List;

import javax.management.Query;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.ServletRequestAware;

import bookstore.db.BookDB;
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
		BookDB bookdb = new BookDB();
		try {
			bookdb.getConnection();
			lblist = bookdb.getListBook();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ("addtocart");
	}
	public String checkout(){
		HttpSession httpsession = request.getSession(false);
		//cartに入っている情報を取得
		List<String> cart = (List<String>)httpsession.getAttribute("CART");
		BookDB bookdb = new BookDB();
		int sum = 0;
		try {
			bookdb.getConnection();
			sum = bookdb.getSum(cart);
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