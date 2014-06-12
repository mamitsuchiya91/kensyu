package shop.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.beans.ShopValueObject;
import shop.dao.ShopDao;

/**
 * Servlet implementation class inputCartServlet
 */
@WebServlet("/cart")
public class inputCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); 
		
		String sname = request.getParameter("sname");
		Integer sprice = Integer.parseInt(request.getParameter("sprice"));
		Integer snum = Integer.parseInt(request.getParameter("snum"));
		String uname = request.getParameter("uname");
		
		ShopValueObject vo = new ShopValueObject();
		vo.setSname(sname);
		vo.setSprice(sprice);
		vo.setSnum(snum);
		vo.setUname(uname);
		
		ShopDao dao = new ShopDao();
		try{
			dao.getConnection();
		}catch(Exception e){
			throw new ServletException(e);
		}finally{
			dao.closeConnection();
		}		
		RequestDispatcher rd = request.getRequestDispatcher("/cart02.jsp");
		rd.forward(request, response);
	}
	protected void setMessage(HttpServletRequest request, String message){
		request.setAttribute("message", message);
	}
}
