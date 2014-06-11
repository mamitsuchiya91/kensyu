package Sample.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/InsertServlet")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	Connection connection = null;
	try{
		InitialContext initCtx = new InitialContext();
		DataSource ds = (DataSource) initCtx.lookup("java:comp/env/jdbc/dbtest");

		connection = ds.getConnection();
		log("�ڑ����J���܂���");
		insert(connection);
	}catch(Exception e){
			throw new ServletException(e);
	}finally{
		try{
			connection.close();
			log("�ڑ�����܂���");
		}catch(SQLException e){
			throw new ServletException(e);
		}
	}
	request.getRequestDispatcher("/complete.html").forward(request, response);
	}

private void insert(Connection connection) throws Exception{
	String sql = "INSERT INTO lecture.todo_list(title, task, limitdate, lastupdate, userid, status "+") VALUES (?, ?, ?, now(), ?, ?);";
	//try{
		PreparedStatement statement = connection.prepareStatement(sql);

		statement.setString(1, "����");
		statement.setString(2, "1��������̏o��");
		statement.setString(3, "2012-03-12");
		statement.setString(4, "USE01");
		statement.setInt(5, 0);

		int count = statement.executeUpdate();

		statement.setString(1, "�T�[�o����");
		//statement.setString(2, "�T�[�o������Ɨ\���");
		statement.setString(3, "2011-12-01");
		statement.setString(4, "USER02");
		statement.setInt(5, 1);

		count = statement.executeUpdate();
		
		statement.setString(1, "�^�C�g���e�X�g");
		statement.setString(2, "�^�X�N�e�X�g");
		statement.setString(3, "2011-12-12");
		statement.setString(4, "USER03");
		statement.setInt(5, 2);

		count = statement.executeUpdate();
	}
}
