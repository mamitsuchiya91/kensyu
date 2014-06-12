<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form id="sender" action="cart" method="POST">
<table border="1">	
	<tr>
		<th>商品名</th>
		<td><input type="text" name="sname" value="<c:out value="${vo.uname }" />" size="16" />
		</td>
	</tr>
	<tr>
		<th>価格</th>
		<td><input type="text" name="uprice" value="<c:out value="${vo.uprice }" />" size="16" />
		</td>
	</tr>
	<tr>
		<th>数量</th>
		<td>
			<select name="snum" id="snum">
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="1">4</option>
				<option value="2">5</option>
			</select>
		</td>
	</tr>
	<tr>
		<th>カート</th>
		<td>
			<a href="preUpload?id=<c:out value="${vo.id}"/>">カート</a>
		</td>
	</tr>
</table>
</form>
●<a href="search" >カートの中身を見る</a>
</body>
</html>