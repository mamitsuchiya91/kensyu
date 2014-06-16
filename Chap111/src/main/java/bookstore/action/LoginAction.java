package bookstore.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import bookstore.db.BookDB;
import bookstore.pbean.TBook;

@Results({@Result(name="login", location="bookstore.jsp")})
public class LoginAction {
	//lblist�Ƃ����v���p�e�B�ɂȂ�I�u�W�F�N�g��錾
	//�S���Ђ̃f�[�^��List<TBook>�^�֊i�[
	private List<TBook> lblist;
	//index.jsp��肱�̃��\�b�h�֔�ԁB
	@Action("/Login")
	public String loginAndGetBookList(){
		BookDB bookdb = new BookDB();
		try {
			bookdb.getConnection();
			lblist = bookdb.getListBook();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ("login");
	}
	public List<TBook> getLblist(){
		return lblist;
	}
	public void setLblist(List<TBook> lblist){
		this.lblist = lblist;
	}
}
