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

import Sample.beans.TodoValueObject;
import todo.dao.TodoDAO;


/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); 
		TodoDAO dao = new TodoDAO();
		String paramId;
		try{
			dao.getConnection();
			paramId = request.getParameter("id");
			int id  = Integer.parseInt(paramId);
			int result = dao.delete(id);
		}catch (Exception e){
			throw new ServletException(e);
		}finally{
			dao.closeConnection();
		}
		setMessage(request, "タスク[" + paramId + "]の削除処理が完了しました。");
		RequestDispatcher rd = request.getRequestDispatcher("search");
		rd.forward(request, response);
	}
	protected void setMessage(HttpServletRequest request, String message){
		request.setAttribute("message", message);
	}
}