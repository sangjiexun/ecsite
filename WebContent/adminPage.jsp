<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/design.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ようこそ管理者ページへ</title>
</head>
<body>
<h2>管理者用ページ</h2>
<h4><a href="organizeItems.jsp">・商品情報の管理</a></h4> <br>
サイト内の商品情報の検索・追加・削除・変更を行うことができます。<br><br>

<h4><a href="orderedItems.jsp">・注文受付状況の確認</a></h4><br>
注文が確定された商品・お客様情報の確認ができます。

<br><br><br><br>
<a href="/ecsite/InAdminServlet?action=adminlogout">ログアウト</a>
</body>
</html>