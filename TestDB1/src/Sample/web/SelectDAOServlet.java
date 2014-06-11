package Sample.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import Sample.dao.DatabaseConnection;
import Sample.dao.TodoDAO;
import Sample.beans.Todo;


/**
 * Servlet implementation class SelectDAOServlet
 */
@WebServlet("/SelectDAOServlet")
public class SelectDAOServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TodoDAO db = new TodoDAO();
		try{
			db.getConnection();
			db.insert();
			List<Todo> resultList = db.select();
			request.setAttribute("list", resultList);
			request.getRequestDispatcher("/list.jsp").forward(request, response);
		}catch (Exception e){
			e.printStackTrace();
			throw new ServletException(e);
		}finally{
		db.closeConnection();
		}
	}
}