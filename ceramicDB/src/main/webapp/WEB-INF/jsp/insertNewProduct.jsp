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
	<h1>【作品情報新規登録画面】</h1>
	<p>
	<form action="InsertNewProductServlet" method="post">
		作品タイトル:<input type="text" name="title">　＊作品名を入力<br>
		<%-- シリーズ:<input type="text" name="series">　＊作品シリーズを入力<br>
		カテゴリー:<input type="text" name="category">　＊作品種類を入力<br>
		釉薬:<input type="text" name="glaze">　＊使用した釉薬を入力<br>
		--%>
		シリーズ:<select name="seriesTag">
			<c:forEach var="sTag" items="${sessionScope.seriesTag}">
				<option value="${sTag.seriesID }"><c:out value="${sTag.seriesID}:${sTag.seriesName}"></c:out></option>
			</c:forEach>
		</select>　＊シリーズを選択<br>
		カテゴリー:<select name="categoryTag">
			<c:forEach var="cTag" items="${sessionScope.categoryTag }">
				<option value="${cTag.categoryID }"><c:out value="${cTag.categoryID}:${cTag.categoryName}" /></option>
			</c:forEach>
		</select>　＊カテゴリーを選択<br>
		釉薬:<select name="glazeTag">
			<c:forEach var="gTag" items="${sessionScope.glazeTag}">
				<option value="${gTag.glazeID }"><c:out value="${gTag.glazeID}:${gTag.glazeName}" /></option>
			</c:forEach>
		</select>　＊釉薬を選択<br>
		
		柄:<input type="text" name="pattern"><br>
		色:<input type="text" name="color"><br>
		サイズ:<input type="text" name="size">　＊例）10x20x30、小<br>
		税抜き価格:<input type="text" name="price">　＊数字のみで入力。例）2,000円→2000<br>
		在庫:<input type="text" name="stock">　＊数字のみで入力。例）５個→5<br>
		制作時期（年）:<input type="text" name="productYear">　＊数字のみで入力。例）2020年→2020<br>
		オンライン取り扱い:有<input type="radio" name="isOnlineShop" value="1">
		無<input type="radio" name="isOnlineShop" value="0"><br>
		<input type="submit" value="登録">&nbsp;&nbsp;&nbsp;
		<input type="reset" value="リセット"><br>
	</form>
	</p>
	<br>
	<a href="InsertOrUpdateServlet">[戻る]</a>
</body>
</html>