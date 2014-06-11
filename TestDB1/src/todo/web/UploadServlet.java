package todo.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import Sample.beans.TodoValueObject;
import todo.dao.TodoDAO;

@WebServlet("/upload")
@MultipartConfig(location="C:/upload")
public class UploadServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		Part part = request.getPart("uploadfile");
		String filename = null;
		for(String cd : part.getHeader("Content-Disposition").split(";")){
			cd = cd.trim();
			
			if(cd.startsWith("filename")){
				filename= cd.substring(cd.indexOf("=") +1).trim().replace("\"", "");
				break;
			}
		}
		String idStr = request.getParameter("id");
		log("idStr:" + idStr);
		int id = Integer.parseInt(idStr);
		
		String message = null;
		if(filename != null){
			filename = filename.replace("\\", "/");
			int pos = filename.lastIndexOf("/");
			if(pos >= 0){
				filename = filename.substring(pos+1);
			}
			part.write(filename);
			
			TodoValueObject vo = new TodoValueObject();
			vo.setId(id);
			vo.setFilename(filename);
			
			TodoDAO dao = new TodoDAO();
			try{
				dao.getConnection();
				int result = dao.updateUploadInfo(vo);
				vo = dao.detail(result);
				request.setAttribute("vo", vo);
			}catch (Exception e){
				throw new ServletException(e);
			}finally{
				dao.closeConnection();
			}
			message = "[" + filename + "]のアップロードが完了しました";
		}else{
			message = "アップロードが失敗しました";
		}
		request.setAttribute("message", message);
		request.getRequestDispatcher("/detail?id=" + id).forward(request, response);
	}
}
