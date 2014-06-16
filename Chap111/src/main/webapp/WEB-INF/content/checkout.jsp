<%@ page language="java" import ="java.util.Iterator" %>
<%@ page language="java" import ="java.util.List" %>
<%@ page language="java" import ="bookstore.db.BookDB" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page language="java" import ="bookstore.pbean.TBook" %>
<html>
<head></head>
<body>
<center>
<h2>購入商品</h2>
</center>
<br><br>
以下が購入する商品と合計です。<br>
<table border="1">
	<%
	List<String> listCheckedBook = (List<String>)session.getAttribute("CART");
	if(listCheckedBook != null){
		for(String iterBookISBN :listCheckedBook){
			TBook book = (TBook)BookDB.findBookByISBN(iterBookISBN);
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
	}
	}
	%>
</table><br><br>
合計：<%= request.getAttribute("TOTAL") %>円
</body>
</html>