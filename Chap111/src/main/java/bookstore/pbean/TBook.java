package bookstore.pbean;

import java.sql.Timestamp;

public class TBook {
	Integer id;
	String isbn;
	String title;
	String author;
	String publisher;
	Integer price;
	
	String userid;
	String upass;
	String uname;
	String umail;
	String uadd;
	String utel;
	String roles;
	
	Integer costomer_id_fk;
	Timestamp orderday;
	
	Integer order_id_fk;
	Integer book_id_fk;
	
	public Integer getId(){
		return id;
	}
	public void setId(Integer id){
		this.id = id;
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
	public String getRoles(){
		return roles;
	}
	public void setRoles(String roles){
		this.roles = roles;
	}
	public Integer getCostomer_id_fk(){
		return costomer_id_fk;
	}
	public void setCostomer_id_fk(Integer costomer_id_fk) {
		this.costomer_id_fk = costomer_id_fk;
		}
}