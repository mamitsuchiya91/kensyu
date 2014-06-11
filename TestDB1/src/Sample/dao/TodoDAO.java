package Sample.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import Sample.beans.Todo;

public class TodoDAO extends MySQLDAO{
	public List<Todo> select() throws Exception{
		String sql = "SELECT title, task, limitdate, lastupdate, userid, status" 
				+ " FROM todo_list WHERE userid like CONCAT('%',?,'%')";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, "USER");
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
	public void insert() throws Exception{
		String sql = "INSERT INTO lecture.todo_list(title, task, limitdate, lastupdate, userid, status "+") VALUES (?, ?, ?, now(), ?, ?);";
		try{
			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setString(1, "DAO�u�K���");
			//statement.setString(2, "DAO�u�K��̃X���C�h�쐬�A�z�z�\�[�X�R�[�h�̏���");
			statement.setString(3, "2012-06-12");
			statement.setString(4, "USER80");
			statement.setInt(5, 0);

			int count = statement.executeUpdate();
			System.out.println("��ڂ̒ǉ�:" + count);
			
			connection.commit();
		}catch (Exception e){
			connection.rollback();
			throw e;
		}
	}
}