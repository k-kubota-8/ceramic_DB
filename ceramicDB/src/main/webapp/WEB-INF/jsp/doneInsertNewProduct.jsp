<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ceramic_database</title>
</head>
<body>
	<h1>【登録完了画面】</h1>
	<p>
	登録内容
	作品タイトル:${newProduct.title }<br>
	シリーズ:${newProduct.series }<br>
	カテゴリー:${newProduct.category }<br>
	釉薬:${newProduct.glaze }<br>
	柄:${newProduct.pattern }<br>
	色:${newProduct.color }<br>
	サイズ:${newProduct.size }<br>
	税抜き価格:${newProduct.price }円<br>
	在庫:${newProduct.stock }個<br>
	制作時期（年）:${newProduct.productYear }年<br>
	オンライン取り扱い:<c:choose><c:when test="${newProduct.onlineShop}">有</c:when><c:otherwise>無</c:otherwise></c:choose><br>
	</p>
	<a href="index.jsp">[トップへ戻る]</a><br>
	<a href="InsertNewProductServlet">[作品情報登録を続ける]</a>
</body>
</html>