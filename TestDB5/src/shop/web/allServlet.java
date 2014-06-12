package shop.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.beans.ShopValueObject;
import shop.dao.ShopDao;


/**
 * Servlet implementation class allServlet
 */
@WebServlet("/all")
public class allServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); 
		ShopDao dao = new ShopDao();
		try{
			dao.getConnection();
			List<ShopValueObject> list = dao.shopList();
			request.setAttribute("shopList", list);
		}catch (Exception e){
			throw new ServletException(e);
		}finally{
		dao.closeConnection();
		}
		//service(request, response);
		RequestDispatcher rd = request.getRequestDispatcher("/list01.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}