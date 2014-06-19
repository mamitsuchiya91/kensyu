<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page language="java" import ="java.util.List" %>
<%@ page language="java" import ="bookstore.db.BookDB" %>
<%@ page language="java" import ="bookstore.pbean.TBook" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<s:form action="/Register" method="post">
<table border="1">
	<tr>
		<th>番号</th>
		<td width="60">
			(新規登録)
		</td>
	</tr>
	<tr>
		<th>タイトル</th>
		<td><input type="text" name="title" /></td>
	</tr>
	<tr>
		<th>著作者</th>
		<td><input type="text" name="author" /></td>
	</tr>
	<tr>
		<th>出版社</th>
		<td><input type="text" name="publisher" /></td>
	</tr>
	<tr>
		<th>価格</th>
		<td><input type="text" name="price" /></td>
	</tr>
	<tr>
		<th>ISBN</th>
		<td><input type="text" name="isbn" /></td>
	</tr>
</table>
<s:submit value="商品追加" method="newbook" theme="simple" />
</s:form>
<s:form action="/Addtoaction" method="post">
<s:submit value="商品一覧に戻る" method="addtocart" theme="simple" />
</s:form>
</body>
</html>