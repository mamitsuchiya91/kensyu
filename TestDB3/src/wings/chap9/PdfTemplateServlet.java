package wings.chap9;

import java.io.IOException;

import javax.naming.InitialContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;






import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;

@WebServlet("/PdfTemplateServlet.pdf")
public class PdfTemplateServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			Document doc = new Document(PageSize.A4, 50, 20, 270, 20);
			PdfWriter writer = PdfWriter.getInstance(doc, response.getOutputStream());
			doc.open();
			ServletContext app = this.getServletContext();
			//テンプレートとなるPDF文書を読み込み
			PdfReader reader = new PdfReader(app.getRealPath("/Test/PdfBasicServlet.pdf"));
			//PdfBasicServlet.pdfの1ページ目をインポート
			PdfImportedPage impPage = writer.getImportedPage(reader, 1);
			//インポートしたページをテンプレートとして適用
			PdfContentByte pcb = writer.getDirectContent();
			pcb.addTemplate(impPage, 0, 0);
			Font fnt = new Font(
					BaseFont.createFont("HeiseiKakuGo-W5", "UniJIS-UCS2-H", BaseFont.NOT_EMBEDDED), 18, Font.BOLD);
			doc.add(new Paragraph("こんにちは、iText!てんぷれーと側", fnt));
			doc.close();
		}catch(DocumentException e){
			throw new ServletException(e);
		}
	}
}