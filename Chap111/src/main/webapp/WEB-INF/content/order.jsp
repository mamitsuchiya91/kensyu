<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page language="java" import ="java.util.List" %>
<%@ page language="java" import ="bookstore.db.BookDB" %>
<%@ page language="java" import ="bookstore.pbean.TBook" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>オーダー情報</title>
</head>
<body>
<center>
<h2>オーダー情報</h2>
</center>
<br>
<body>
<table border="1">
	<tr><th>注文日時</th><th>ISBN情報</th><th>名前</th><th>めーる</th><th>住所</th><th>でんわ</th><th width="60">発送完了</th></tr>
	<s:iterator value="orderlist">
	<tr>
		<td>
			<s:property value="orderday" />
		</td>
		<td>
			<s:property value="isbn" />
		</td>
		<td>
			<s:property value="uname" />
		</td>
		<td>
			<s:property value="umail" />
		</td>
		<td>
			<s:property value="uadd" />
		</td>
		<td>
			<s:property value="utel" />
		</td>
		<td>
			<s:form action="/Manager" method="post">
			<s:hidden name="isbn" value="%{isbn}" />
			<s:submit value="削除" method="deleteorder" theme="simple" />
			</s:form>
		</td>
	</tr>
	</s:iterator>
	</table>
<s:form action="/Manager" method="post">
<s:submit value="管理者画面へもどる" method="manager" theme="simple" />
</s:form>
</body>
</html>