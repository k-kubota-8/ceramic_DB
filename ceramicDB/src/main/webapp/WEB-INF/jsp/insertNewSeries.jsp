<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>作品シリーズ追加</title>
</head>
<body>
	<h1>【作品シリーズ追加】</h1>
	<p>
	<form action="InsertNewSeriesServlet" method="post">
		追加するシリーズ名:<input type="text" name="seriesName"><br>
		<br>
		<input type="submit" value="登録">&nbsp;&nbsp;&nbsp;
		<input type="reset" value="リセット"><br>
	</form>
	</p>
	<a href="InsertOrUpdateServlet">[戻る]</a>
</body>
</html>