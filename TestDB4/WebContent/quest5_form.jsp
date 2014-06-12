<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*, javax.naming.*, javax.sql.*, wings.common.CheckUtil" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<form method="POST" action="quest5_process.jsp">
${requestScope['err']}
<table border = 0>
	<tr>
		<th align="right">ISBNコード:</th>
		<td><input type="text" name="isbn" size="25" maxlength="30" value="${param.isbn }" /></td>
	</tr>
	<tr>
		<th align="right">書名:</th>
		<td><input type="text" name="isbn" size="25" maxlength="30" value="${param.isbn }" /></td>
	</tr>
		<tr>
		<th align="right">価格:</th>
		<td><input type="text" name="isbn" size="25" maxlength="30" value="${param.isbn }" /></td>
	</tr>
		<tr>
		<th align="right">出版社:</th>
		<td><input type="text" name="isbn" size="25" maxlength="30" value="${param.isbn }" /></td>
	</tr>
		<tr>
		<th align="right">配本日:</th>
		<td><input type="text" name="isbn" size="25" maxlength="30" value="${param.isbn }" /></td>
	</tr>
	<tr>
		<td colspan="2"><input type="submit" value="登録"><INPUT TYPE="reset" value="クリア"></td>
	</tr>
</table>
</form>
</body>
</html>