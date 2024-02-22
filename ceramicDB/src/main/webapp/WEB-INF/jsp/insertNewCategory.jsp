<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>作品カテゴリー追加</title>
</head>
<body>
	<h1>【作品カテゴリー追加】</h1>
	<p>
	<form action="InsertNewCategoryServlet" method="post">
		追加するカテゴリー名:<input type="text" name="categoryName"><br>
		<br>
		<input type="submit" value="登録">&nbsp;&nbsp;&nbsp;
		<input type="reset" value="リセット"><br>
	</form>
	</p>
	<a href="InsertOrUpdateServlet">[戻る]</a>
</body>
</html>