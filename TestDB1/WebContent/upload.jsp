<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>TODOタスクのアップロード画面</title>
<script type="text/javascript">
</script>
</head>
<body>
アップロードするファイルを選択し、[アップロード]ボタンを押してください。
<form name="upload" action="./upload" method="post" enctype="multipart/form-data">
	<input type="file" name="uploadfile" />
	<input type="submit" value="アップロード" />
	<input type="hidden" name="id" value="${id}"></input>
</form>
●<a href ="search">タスクの一覧へ戻る</a>|
</body>
</html>