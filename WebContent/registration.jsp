<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/design.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新規登録画面</title>
</head>
<body>
	<div align="center">

		<h1>新規登録画面</h1>
	</div>
	<hr>
	<form action="/ecsite/RegistrationServlet?action=AllnewDateAdd" method="post">

		名前 <input type="text" name="name" value="" size="24"><br>

		性別 <input type="radio" name="gender" value="m" checked="checked">男性
			<input type="radio" name="gender" value="f">女性
			<br>


		住所 <input type="text" name="address" size="24"><br>
		電話番号<input type="text" name="tel" size="24"> <br>
		ログインID<input type="text" name="user_id"  size="24">
		パスワード<input type="password" name="password" size="24"><br><br>

		<input type="reset" value="入力内容を消去します。" size="10"><br><br>
		<input type="hidden" name="action" value="AllnewDateAdd">
		<input type="submit" value="登録">
	</form>

</body>
</html>