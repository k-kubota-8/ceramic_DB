<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>作品検索結果</title>
</head>
<body>
	<h1>【作品検索結果】</h1>
	<p>
	<form action="" method="post">
	<table border="1">
		<thead>
			<tr>
				<th>作品ID</th>
				<th>タイトル</th>
				<th>シリーズ</th>
				<th>カテゴリー</th>
				<th>釉薬</th>
				<th>柄</th>
				<th>色</th>
				<th>サイズ</th>
				<th>税抜き価格(円)</th>
				<th>在庫(個)</th>
				<th>制作年(年)</th>
				<th>ネット販売</th>
				<th>変更作品選択</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="result" items="${resultSelectProduct }">
				<tr>
					<td><c:out value="${result.productID}" /></td>
					<td><c:out value="${result.title}" /></td>
					<td><c:out value="${result.series}" /></td>
					<td><c:out value="${result.category}" /></td>
					<td><c:out value="${result.glaze}" /></td>
					<td><c:out value="${result.pattern}" /></td>
					<td><c:out value="${result.color}" /></td>
					<td><c:out value="${result.size}" /></td>
					<td><c:out value="${result.price}" /></td>
					<td><c:out value="${result.stock}" /></td>
					<td><c:out value="${result.productYear}" /></td>
					<c:choose>
						<c:when test="${result.onlineShop }"><td>有</td></c:when>
						<c:otherwise><td>無</td></c:otherwise>
					</c:choose>
					<td><input type="radio" name="selectedProduct" value="${result.productID}"></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br>
	<input type ="submit" value="選択した作品情報の変更">
	</form>
	</p>
	<a href="index.jsp">[トップへ戻る]</a><br>
	<a href="SelectProductServlet">[続けて検索]</a>
</body>
</html>