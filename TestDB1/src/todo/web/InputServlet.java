package todo.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import todo.dao.TodoDAO;
import Sample.beans.TodoValueObject;

/**
 * Servlet implementation class InputServlet
 */
@WebServlet("/input")
public class InputServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); 
		TodoValueObject vo = new TodoValueObject();
		vo.setId(0);
		request.setAttribute("vo", vo);
		RequestDispatcher rd = request.getRequestDispatcher("/detail.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doGet(request, response);
	}
}