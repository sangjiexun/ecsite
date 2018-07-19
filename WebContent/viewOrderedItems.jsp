<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/design.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注文受付状況の確認</title>
</head>
<body>

<h2>注文内容の詳細を確認できます。</h2>
<br>
<a href="/ecsite/orderedItems.jsp">前ページに戻る</a>
<a href="/ecsite/adminPage.jsp">管理者用ページへ戻る</a>
<a href="/ecsite/InAdminServlet?action=adminlogout">ログアウト</a>
<hr>
<table border="1">
<tr><td>注文番号</td><td>商品番号</td><td>商品名</td><td>価格（税込）</td><td>注文数</td></tr>
<c:forEach items="${items}" var="items">
<tr>
	<td align="center">${items.orderCode}</td>
	<td align="center">${items.itemCode}</td>
	<td align="center">${items.itemName}</td>
	<td align="right">${items.itemPrice}円</td>
	<td align="right">${items.num}</td>
</tr>
</c:forEach>
</table>
</body>
</html>