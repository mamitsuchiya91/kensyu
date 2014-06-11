package todo.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UploadDisplayServlet
 */
@WebServlet("/preUpload")
public class UploadDisplayServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idString = request.getParameter("id");
		
		Integer id = Integer.parseInt(idString);
		request.setAttribute("id", id);
		request.getRequestDispatcher("/upload.jsp").forward(request, response);
	}
}

