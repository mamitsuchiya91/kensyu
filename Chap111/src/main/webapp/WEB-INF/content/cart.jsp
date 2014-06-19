<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page language="java" import ="java.util.List" %>
<%@ page language="java" import ="bookstore.db.BookDB" %>
<%@ page language="java" import ="bookstore.pbean.TBook" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>カート情報</title>
</head>
<body>
<center>
<h2>カートに入っている商品</h2>
</center>
<br>
<body>
<table border="1">
	<tr><th>作品名</th><th>著作名</th><th>価格</th><th width="60">削除</th></tr>
	<s:iterator value="cartlist">
	<tr>
		<td>
			<s:property value="title" />
		</td>
		<td>
			<s:property value="author" />
		</td>
		<td>
			<s:property value="price" />円
		</td>
		<td>
		<s:form action="/Detail" method="post">
		<s:hidden name="isbn" value="%{isbn}" />
		<s:submit value="削除" method="delete" theme="simple" />
		</s:form>
		</td>
	</tr>
	</s:iterator>
	</table>

<s:form action="/Addtoaction" method="post">
<s:submit value="商品一覧へもどる" method="addtocart" theme="simple" />
</s:form>
	</body>
</html>