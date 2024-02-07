<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>作品情報検索</title>
</head>
<body>
	<h1>【作品情報検索】</h1>
	<p>
	ーー検索条件の指定ーー<br>
	検索文字を含んだ条件で検索<br>
	＊指定しない場合は何も入力しない
	</p>
	<form action="SelectProductServlet" method="post">
	作品タイトル:<input type="text" name="title"><br>
	シリーズ:<input type="text" name="series"><br>
	カテゴリー:<input type="text" name="category"><br>
	釉薬:<input type="text" name="glaze"><br>
	柄:<input type="text" name="pattern"><br>
	色:<input type="text" name="color"><br>
	サイズ:<input type="text" name="size"><br>
	税抜き価格:<input type="text" name="priceLowerLimit">～<input type="text" name="priceUpperLimit">円<br>
	在庫:<input type="text" name="stockLowerLimit">～<input type="text" name="stockUpperLimit">個<br>
	制作時期（年）:<input type="text" name="productYearLowerLimit">～<input type="text" name="productYearUpperLimit">年<br>
	オンライン取り扱い:<input type="radio" name="isOnlineShop" value="1">有&nbsp;&nbsp;&nbsp;
	<input type="radio" name="isOnlineShop" value="0">無&nbsp;&nbsp;&nbsp;
	<input type="radio" name="isOnlineShop" value="2">どちらも<br>
	
	<input type ="submit" value="検索">&nbsp;&nbsp;&nbsp;
	<input type="reset" value="入力内容取消">
	</form>
	<br>
	<a href="SelectServlet">[戻る]</a>
</body>
</html>