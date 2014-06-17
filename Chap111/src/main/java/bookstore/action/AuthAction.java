package bookstore.action;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.ServletRequestAware;

import bookstore.db.BookDB;
import bookstore.pbean.TBook;

@Results({@Result(name="auth", location="bookstore.jsp")})
public class AuthAction implements ServletRequestAware {
	private String username;
	private String password;
	private HttpServletRequest request;
	private List<TBook> lblist;
	@Action("/Auth")
	public String loginauth(){
		BookDB bookdb = new BookDB();
		try{
			request.login(username, password);
			bookdb.getConnection();
			lblist = bookdb.getListBook();
		}catch(ServletException e){
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ("auth");
	}
	public String getUsername(){
		return username;
	}
	public void setUsername(String username){
		this.username = username;
	}
	public String getPasswd(){
		return password;
	}
	public void setPassword(String password){
		this.password = password;
	}
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	public List<TBook> getLblist(){
		return lblist;
	}
	public void setLblist(List<TBook> lblist){
		this.lblist = lblist;
	}
}