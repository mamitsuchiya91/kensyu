<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page language="java" import ="java.util.List" %>
<%@ page language="java" import ="bookstore.db.BookDB" %>
<%@ page language="java" import ="bookstore.pbean.TBook" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>管理者画面</title>
</head>
<body>
<center>
<h2>管理者画面</h2>
</center>
<br>
<body>
<s:form action="/Register" method="post">
<s:submit value="商品追加" method="booknew" theme="simple" />
</s:form>
<s:form action="/Manager" method="post">
<s:submit value="オーダー確認" method="order" theme="simple" />
</s:form>
</body>
</html>