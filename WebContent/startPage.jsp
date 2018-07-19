<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/design.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome Shopping!</title>

</head>
<body>
 <div align="center">
	<h1>Simple Shopping Site!</h1>
	<br>
	<p>
		プログラミング学習過程で製作したものです。 <br>
		言語「Java,JSP,CSS」,開発環境「Eclipse」,データベース「Postgres」を使用しました。<br>
		まずは「ログイン」もしくは「新規登録」をして進んでください。
	</p>
</div>
	<hr>
	<br><br>

	<form action="/ecsite/LoginServlet" method="post">
		ログインID：<input type="text" name="name"><br>
		パスワード：<input type="password" name="pw"><br>
		<input type="hidden" name="action" value="login">
		<input type="submit" value="ログイン">
	</form>

	<br><br>

	<a href="registration.jsp">新規登録に進む</a>

	<br><br><br><br><br><br><br><br><br><br><br><br><br><br>
	<hr>
	<jsp:include page="gotoAdminPage.jsp"/>
</body>
</html>