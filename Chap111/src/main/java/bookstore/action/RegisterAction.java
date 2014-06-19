package bookstore.action;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.ServletRequestAware;

import bookstore.mail.SimpleMailSender;
import bookstore.db.BookDB;
import bookstore.pbean.TBook;

@Results({
	@Result (name="register", location="login.jsp"),
	@Result (name="signup", location="signup.jsp"),
	@Result (name="newinsert", location="newbook.jsp"),
	@Result (name="booknew", location="newbook.jsp")
})
public class RegisterAction implements ServletRequestAware {
	private String userid;
	private String upass;
	private String uname;
	private String umail;
	private String uadd;
	private String utel;
	
	private String title;
	private String isbn;
	private String author;
	private String publisher;
	private Integer price;
	
	private HttpServletRequest request;
	@Action("/Register")
	public String register(){
		TBook tb = new TBook();
		tb.setUserid(userid);
		tb.setUpass(md5(upass));
		tb.setUname(uname);
		tb.setUmail(umail);
		tb.setUadd(uadd);
		tb.setUtel(utel);
		BookDB bookdb = new BookDB();
		try {
			bookdb.getConnection();
			bookdb.registerInsert(tb);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "register";
	}
	
	public String signup(){
		return "signup";
	}
	public String md5(String upass) {
	        String rtn = "";
	        try {
	            MessageDigest md = MessageDigest.getInstance("MD5");
	            md.update(upass.getBytes());
	            byte[] digest = md.digest();
	 
	            //ダイジェストを文字列に変換します。
	            for (int i = 0; i < digest.length; i++) {
	                rtn += String.format("%02x", digest[i]);
	            }
	        } catch (NoSuchAlgorithmException e) {
	            e.printStackTrace();
	        }
	        return rtn;
	    }
	public String booknew(){
		return "booknew";
	}
	public String newbook(){
		TBook tb = new TBook();
		tb.setTitle(title);
		tb.setIsbn(isbn);
		tb.setAuthor(author);
		tb.setPublisher(publisher);
		tb.setPrice(price);

		BookDB bookdb = new BookDB();
		try {
			bookdb.getConnection();
			bookdb.newbooker(tb);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "newinsert";
	}
	public String getIsbn(){
		return isbn;
	}
	public void setIsbn(String isbn){
		this.isbn = isbn;
	}
	public String getTitle(){
		return title;
	}
	public void setTitle(String title){
		this.title = title;
	}
	public String getAuthor(){
		return author;
	}
	public void setAuthor(String author){
		this.author = author;
	}
	public String getPublisher(){
		return publisher;
	}
	public void setPublisher(String publisher){
		this.publisher = publisher;
	}
	public Integer getPrice(){
		return price;
	}
	public void setPrice(Integer price){
		this.price = price;
	}
	public String getUserid(){
		return userid;
	}
	public void setUserid(String userid){
		this.userid = userid;
	}
	public String getUpass(){
		return upass;
	}
	public void setUpass(String upass){
		this.upass = upass;
	}
	public String getUmail(){
		return umail;
	}
	public void setUmail(String umail){
		this.umail = umail;
	}
	public String getUtel(){
		return utel;
	}
	public void setUtel(String utel){
		this.utel = utel;
	}
	public String getUadd(){
		return uadd;
	}
	public void setUadd(String uadd){
		this.uadd = uadd;
	}
	public String getUname(){
		return uname;
	}
	public void setUname(String uname){
		this.uname = uname;
	}
	public void setServletRequest(HttpServletRequest arg0) {
	}
}