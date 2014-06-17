<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新規登録</title>
</head>
<body>
<form action="Register" method="POST">
<table border="1">
	<tr>
		<th>ユーザid(ログインid)</th>
		<td><input type="text" name="userid" /></td>
	</tr>
	<tr>
		<th>パスワード</th>
		<td><input type="text" name="upass" /></td>
	</tr>
	<tr>
		<th>なまえ</th>
		<td><input type="text" name="uname" /></td>
	</tr>
	<tr>
		<th>メールアドレス</th>
		<td><input type="text" name="umail" /></td>
	</tr>
	<tr>
		<th>住所</th>
		<td><input type="text" name="uadd" /></td>
	</tr>
	<tr>
		<th>電話番号</th>
		<td><input type="text" name="utel" /></td>
	</tr>
</table>
<input type="submit" value="登録する" />
</form>
</body>
</html>