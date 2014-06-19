package bookstore.action;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.ServletRequestAware;

@Results({
	   @Result(name="success", location="csv-upload-list.jsp"),
	   
	   @Result(name="download", type="stream", params={
	           "inputName", "is",
	           "contentType", "application/octet-stream; charset=UTF-8",
	           "contentLength", "${length}",
	           "contentDisposition", "attachment; filename = ${templateName}"})
	 })
public class DownloadAction implements ServletRequestAware{
	   /** �t�@�C���� */
	   public String templateName;
	   /** ���� */
	   public long length;
	   /** �X�g���[�� */
	   public InputStream is;
	   /**
	    * �e�Q�b�^�[�E�Z�b�^�[
	    */
	   public String template() throws Exception {
	       
	       File template = new File("upload/template/information", "template_information.csv");
	       
	       is = new BufferedInputStream(new FileInputStream(template));
	       templateName = URLEncoder.encode(template.getName(), "UTF-8");
	       length = template.length();
	       
	       return "download";
	   }
	public void setServletRequest(HttpServletRequest arg0) {
	}
}