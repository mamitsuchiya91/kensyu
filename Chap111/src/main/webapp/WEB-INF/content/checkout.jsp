<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page language="java" import ="java.util.List" %>
<%@ page language="java" import ="bookstore.db.BookDB" %>
<%@ page language="java" import ="bookstore.pbean.TBook" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head></head>
<body>
<center>
<h2>購入商品</h2>
</center>

<br>
以下が購入する商品と合計です。<br>
<table border="1">
<%	
List<String> listCheckedBook = (List<String>)session.getAttribute("CART");
String[] str = listCheckedBook.toArray(new String[listCheckedBook.size()]);
BookDB bd = new BookDB();
if(listCheckedBook != null){
	for(String iterBookISBN :str){
		try {
			bd.getConnection();
			TBook book = bd.findBookByISBN(iterBookISBN);
	%>
	<tr>
		<td>
		<%= book.getTitle() %>
		</td>
		<td>
		<%= book.getAuthor() %>
		</td>
		</tr>
		<tr>
		<td>
		<%= book.getPublisher() %>
		</td>
		<td>
		<%= book.getPrice() %>
		</td>
	</tr>
	<%
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
} %>
</table>
合計：
<% out.println(request.getAttribute("SUM"));%>円
<s:form action="/Download" method="post">
<s:submit value="ダウンロード" method="download" theme="simple" />
</s:form>
<br>
</body>
</html>