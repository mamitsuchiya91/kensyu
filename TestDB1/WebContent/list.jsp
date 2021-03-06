<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*, javax.naming.*, javax.sql.*, java.text.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
<tr>
	<th>タイトル</th><th>タスク</th><th>ユーザID</th><th>ステータス</th>
</tr>
<c:forEach items="${list}" var="todo">
	<tr>
		<td><c:out value="${todo.title}" /></td>
		<td><c:out value="${todo.task}" /></td>
		<td><c:out value="${todo.userid}" /></td>
		<td><c:out value="${todo.status}" /></td>
	</tr>
</c:forEach>
</table>
</body>
</html>