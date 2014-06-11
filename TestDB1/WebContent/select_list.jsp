<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*, javax.servlet.*, javax.naming.*,javax.sql.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>QUE</title>
</head><body>
<table border="1">
<tr>
	<th>タイトル</th><th>タスク</th><th>期限</th><th>最終更新</th><th>ユーザID</th><th>ステータス</th>
</tr>
<c:forEach items="${list}" var="todo">
	<tr>
		<td><c:out value="${todo.title}" /></td>
		<td><c:out value="${todo.task}" /></td>
		<td><c:out value="${todo.limitdate}" /></td>
		<td><c:out value="${todo.lastupdate}" /></td>
		<td><c:out value="${todo.userid}" /></td>
		<td><c:out value="${todo.status}" /></td>
	</tr>
</c:forEach>
</table>
</body>
</html>