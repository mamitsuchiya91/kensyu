<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page language="java" import ="java.util.List" %>
<%@ page language="java" import ="bookstore.db.BookDB" %>
<%@ page language="java" import ="bookstore.pbean.TBook" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<s:form action="/Addtoaction" method="post">
<table border="1">
	<tr><th>作品名</th><th>著作名</th><th>価格</th><th>選択</th><th>
	<s:iterator value="lblist">
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
			<s:set name="selected_isbn" value="%{isbn}" />
			<!--<s:property value="%{#session.CART}" />-->
			<s:if test="%{#session.CART != null && !#session.CART.isEmpty() && #session.CART.indexOf(#selected_isbn)!=-1}">
			<s:checkbox name="selecteditems" fieldValue="%{isbn}" theme="simple" value='true' />
			</s:if>
			<s:else>
			<s:checkbox name="selecteditems" fieldValue="%{isbn}" theme="simple" value='false' />
			</s:else>
		</td>
	</tr>
	</s:iterator>
	</table>
	<s:submit value="カートに追加" method="addtocart" theme="simple" />
	<s:submit value="会計" method="checkout" theme="simple" />
</s:form>
</body>
</html>