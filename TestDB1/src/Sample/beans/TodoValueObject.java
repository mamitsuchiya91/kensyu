package Sample.beans;
import java.sql.Timestamp;

public class TodoValueObject {
	Integer id;
	String title;
	String task;
	Timestamp limitdate;
	Timestamp lastupdate;
	String userid;
	String label;
	Integer status;
	String inputLimitdate;
	String filename;
	
	public Integer getId(){
		return id;
	}
	public void setId(Integer id){
		this.id = id;
	}
	public String getTitle(){
		return title;
	}
	public void setTitle(String title){
		this.title = title;
	}
	public String getTask(){
		return task;
	}
	public void setTask(String task){
		this.task = task;
	}
	public Timestamp getLimitdate(){
		return limitdate;
	}
	public void setLimitdate(Timestamp limitdate){
		this.limitdate = limitdate;
	}
	public Timestamp getLastupdate(){
		return lastupdate;
	}
	public void setLastupdate(Timestamp lastupdate){
		this.lastupdate = lastupdate;
	}
	public Integer getStatus(){
		return status;
	}
	public void setStatus(Integer status){
		this.status = status;
	}
	public String getUserid(){
		return userid;
	}
	public void setUserid(String userid){
		this.userid = userid;
	}
	public String getLabel(){
		return label;
	}
	public void setLabel(String label){
		this.label = label;
	}
	public void setInputLimitdate(String inputLimitdate) {
		this.inputLimitdate = inputLimitdate;
	}
	public String getInputLimit() {
		return inputLimitdate;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getFilename() {
		return filename;
	}
}