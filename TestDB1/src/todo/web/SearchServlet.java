package todo.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;



import javax.naming.InitialContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import javax.sql.DataSource;


//import Sample.dao.DatabaseConnection;
import todo.dao.TodoDAO;
import Sample.beans.TodoValueObject;


/**
 * Servlet implementation class SelectDAOServlet
 */
@WebServlet("/search")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); 
		TodoDAO dao = new TodoDAO();
		try{
			dao.getConnection();
			//認証情報の取得処理
			//String userid = request.getRemoteUser();
			//request.setAttribute("LoginUserId", userid);
			//adminロールを所有するユーザであるか判定
			//boolean isAdmin = request.isUserInRole("admin");
			//request.setAttribute("isAdmin", isAdmin);
			
			List<TodoValueObject> list = dao.todoList();
			request.setAttribute("todoList", list);
		}catch (Exception e){
			throw new ServletException(e);
		}finally{
		dao.closeConnection();
		}
		//service(request, response);
		RequestDispatcher rd = request.getRequestDispatcher("/search.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}