package bookstore.action;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.ServletRequestAware;

import bookstore.db.BookDB;
import bookstore.pbean.TBook;

@Results({
	@Result (name="register", location="login.jsp"),
	@Result (name="signup", location="signup.jsp")
})
public class RegisterAction implements ServletRequestAware {
	private String userid;
	private String upass;
	private String uname;
	private String umail;
	private String uadd;
	private String utel;
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
	@Action("/Signup")
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