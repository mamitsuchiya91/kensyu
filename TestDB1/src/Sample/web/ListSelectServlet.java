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
			log("接続を開きました");
			
			//検索を行う
			List<Todo> resultList = select(connection,request);
			//検索結果をリクエスト属性へ格納
			request.setAttribute("list", resultList);
			//検索結果を表示する場所へフォワード
			request.getRequestDispatcher("/select_list.jsp").forward(request, response);
		}catch (Exception e){
			throw new ServletException(e);
		}finally{
			try{
				connection.close();
				log("接続を閉じました");
			}catch(SQLException e){
				throw new ServletException(e);
			}
		}
	}
	
	public List<Todo> select(Connection connection,HttpServletRequest request) throws Exception{
		//実行するSQLを作成
		String sql = "SELECT title, task, limitdate, lastupdate, userid, status" 
				+ " FROM todo_list WHERE userid like CONCAT('%',?,'%')";
		
	//SQLを格納して実行するコンテナを取得
	PreparedStatement statement = connection.prepareStatement(sql);
	
	//変数を順番に格納
	
	String userid = request.getParameter("userid");
	statement.setString(1, userid);
	//格納する
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