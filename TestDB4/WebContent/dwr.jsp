<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>住所情報の検索</title>
</head>
<!-- インポート -->
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script type="text/javascript" src="dwr/engine.js"></script>
<script type="text/javascript" src="dwr/util.js"></script>
<script type="text/javascript" src="dwr/interface/Address.js"></script>
<script type="text/javascript">

function init(){
	dwr.util.useLoadingMessage();
}
function getResult() {
    Address.getInfoByName($('#name').val(), function (result){
		var msg = '<table border="1">';
		msg += '<tr><th>名前</th><th>住所</th><th>TEL</th><th>e-mail</th></tr>';
		for(i = 0; i < result.length; i++){
			msg += '<tr>';
			msg += '<td>' + result[i].name + '</td>';
			msg += '<td>' + result[i].address + '</td>';
			msg += '<td>' + result[i].tel + '</td>';
			msg += '<td>' + result[i].email + '</td>';
			msg += '</tr>';
		}
		msg += '</table>';
		//alert(msg);
		$('#result').html(msg);
	}
);
}
</script>
<!-- 実行でinit()を呼び出す -->
<body onload="init();">
<form>
名前:
<input type="text" name='name' id='name' size="20" />

<!-- クリックでgetResult()を呼び出す -->
<input type="button" value="検索" onClick="getResult();" />
</form>
<!-- function(result)の中身をidに入れる -->
<div id="result"></div>
</body>
</html>