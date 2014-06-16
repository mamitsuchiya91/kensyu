
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page language="java" import ="java.util.List" %>
<%@ page language="java" import ="bookstore.db.BookDB" %>
<%@ page language="java" import ="bookstore.pbean.TBook" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<s:form action="/Addtoaction" method="post">

<s:set name="string" value="%{'testresult'}" />
<s:set name="string1" value="%{'result'}" />
<s:if test="%{#session.CART.contains('1')}">
    <font size="5" color="green">String Not Found.</font>
</s:if>
<s:else>
    <font size="5" color="green">String Found.</font>
</s:else>

<table border="1">
	<tr><th>作品名</th><th>著作名</th><th>価格</th><th>選択</th><th>
	<!-- リストに保存されてるデータだけアクセス。lblistはTBookオブジェクトをリスト形式で保存している -->
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
		<s:if test="%{#session.CART.indexOf('1') > 0}" >
		true
		</s:if>
			<s:set name="selected_isbn" value="%{id}" />
			<s:property value="%{#session.CART}" />
			<s:if test="%{#session.CART != null && !#session.CART.isEmpty() && #session.CART.contains(selected_isbn)}">
			<s:checkbox name="selecteditems" fieldValue="%{id}" theme="simple" value='true' />
			aaaa
			</s:if>
			<s:else>
			<s:checkbox name="selecteditems" fieldValue="%{id}" theme="simple" value='false' />
			bbbb
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