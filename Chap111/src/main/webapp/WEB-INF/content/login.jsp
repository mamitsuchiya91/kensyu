<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http//www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
<form method="post" action="Auth">
<table>
	<tr>
		<td>ユーザID</td>
		<td><input type="text" name="username"></td>
	</tr>
	<tr>
		<td>パスワード</td>
		<td><input type="password" name="password"></td>
	</tr>
</table>
<br>
<input type="submit" value="ログイン" name="submit">
<input type="reset" value="リセット" name="submit">
</form>
<a href ="signup">新規登録</a>
<a href ="manager">管理者画面へ</a>
</body>
</html>