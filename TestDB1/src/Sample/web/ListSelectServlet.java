package Sample.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import Sample.beans.Todo;

@WebServlet("/ListSelectServlet")
public class ListSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection connection = null;
		try{
			InitialContext initCtx = new InitialContext();
			DataSource ds = (DataSource) initCtx.lookup("java:comp/env/jdbc/dbtest");
			
			connection = ds.getConnection();
			log("�ڑ����J���܂���");
			
			//�������s��
			List<Todo> resultList = select(connection,request);
			//�������ʂ����N�G�X�g�����֊i�[
			request.setAttribute("list", resultList);
			//�������ʂ�\������ꏊ�փt�H���[�h
			request.getRequestDispatcher("/select_list.jsp").forward(request, response);
		}catch (Exception e){
			throw new ServletException(e);
		}finally{
			try{
				connection.close();
				log("�ڑ�����܂���");
			}catch(SQLException e){
				throw new ServletException(e);
			}
		}
	}
	
	public List<Todo> select(Connection connection,HttpServletRequest request) throws Exception{
		//���s����SQL���쐬
		String sql = "SELECT title, task, limitdate, lastupdate, userid, status" 
				+ " FROM todo_list WHERE userid like CONCAT('%',?,'%')";
		
	//SQL���i�[���Ď��s����R���e�i���擾
	PreparedStatement statement = connection.prepareStatement(sql);
	
	//�ϐ������ԂɊi�[
	
	String userid = request.getParameter("userid");
	statement.setString(1, userid);
	//�i�[����
	ResultSet rs = statement.executeQuery();
	
	List<Todo> resultList = new ArrayList<Todo>();
	
	while (rs.next()){
		Todo todo = new Todo();
		
		todo.setTitle(rs.getString("title"));
		todo.setTask(rs.getString("task"));
		todo.setLimitdate(rs.getTimestamp("limitdate"));
		todo.setLastupdate(rs.getTimestamp("lastupdate"));
		todo.setUserid(rs.getString("userid"));
		todo.setStatus(rs.getInt("status"));
		resultList.add(todo);
	}
	return resultList;
	}
}