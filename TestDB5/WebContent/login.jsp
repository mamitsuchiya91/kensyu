<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ログイン画面</title>
</head>
<body>
<form method="post" action="all">
<!-- request.getRemoteUser() -->
ログインしてください
<table>
	<tr>
		<td>ユーザID</td>
		<td><input type="text" name="j_username"></td>
	</tr>
	<tr>
		<td>パスワード</td>
		<td><input type="password" name="j_password"></td>
	</tr>
</table>
<br>
<input type="submit" value="ログイン" name="submit">
<input type="reset" value="クリア" name="reset">
</form>
<br />
登録がまだの方
●<a href="login" >新規登録</a>
</body>
</html>