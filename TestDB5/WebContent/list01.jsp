<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>カート一覧</title>
</head>
<body>
<form id="sender" action="cart" method="get">
<table border="1">	
	<tr>
		<th>商品名</th><th>価格</th><th>数量</th><th>カート</th>
	</tr>
	<tr>
		<td><input type="text" name="sname" value="<c:out value="${sname }" />" size="16" /></td>
		<td><input type="text" name="uprice" value="<c:out value="${sprice }" />" size="16" /></td>
		<td><select name="snum" id="snum">
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="1">4</option>
				<option value="2">5</option>
			</select>
		</td>
		<td><!-- <a href="preUpload?id=<c:out value="${shopList.id}"/>">カート</a> --></td>
	</tr>
</table>
</form>
●<a href="search" >カートの中身を見る</a>
</body>
</html>