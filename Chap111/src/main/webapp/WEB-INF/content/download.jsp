<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page language="java" import ="java.util.List" %>
<%@ page language="java" import ="bookstore.db.BookDB" %>
<%@ page language="java" import ="bookstore.pbean.TBook" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
<s:form method="post">
   <dt>ダウンロードファイル<br>
     <s:url id="url" action="csv-upload-list" method="template" />
     <s:a href="%{url}">テンプレート</s:a>
   </dt>
</s:form>
</body>
</html>

