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

<h2>注文受付状況を確認できます。</h2><br>

<p><a href="/ecsite/CheckOrderServlet?action=customer">注文中のお客様情報</a>(クリックすると情報が表示されます。)</p><br>

<jsp:include page="/searchOrderedItems.jsp"/>
<a href="/ecsite/adminPage.jsp">管理者用ページへ戻る</a>
<a href="/ecsite/InAdminServlet?action=adminlogout">ログアウト</a>
<hr>

<p>(注文番号をクリックで注文商品の表示へ)</p>
<table border="1">
<tr><td>注文番号</td><td>注文者</td><td>お届け先</td><td>電話番号</td><td>メールアドレス</td></tr>
<c:forEach items="${customer}" var="customer">
<tr>
	<td align="center">${customer.code}</td>
	<td align="center">${customer.name}</td>
	<td align="left">${customer.address}</td>
	<td align="left">${customer.tel}</td>
	<td align="left">${customer.email}</td>
</tr>
</c:forEach>


</table>


</body>
</html>