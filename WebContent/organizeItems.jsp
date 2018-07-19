<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/design.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品情報の管理</title>
</head>
<body>
	<jsp:include page="itemForm.jsp"/>
	<a href="adminPage.jsp">管理者用ページへ戻る</a>
	<a href="/ecsite/InAdminServlet?action=adminlogout">ログアウト</a>

	<hr>
	<table border="1">
	<tr><td>NO</td><td>商品名</td><td>値段</td></tr>

	<c:forEach items="${items}" var="item">
		<tr><td>${item.code}</td><td>${item.name}</td><td>${item.price}</td></tr>
	</c:forEach>
	</table>



</body>
</html>