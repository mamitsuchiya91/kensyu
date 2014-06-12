package shop.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.beans.ShopValueObject;

@WebServlet("/login")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		String user =  request.getParameter("j_username");
		String passwd = request.getParameter("j_password");
		try{
			request.login(user, passwd);
			out.println("こんにちは" + request.getRemoteUser() + "さん！");
		}catch(ServletException e){
			e.printStackTrace();
			out.print("認証済みであるか、ユーザ名／パスワードが間違ってます");
		}finally{
			out.flush();
			out.close();
		}
	}
}