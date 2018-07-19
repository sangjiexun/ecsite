<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div align="right">管理者ページへアクセス：共通ID[admin],PASS[abc123]でログインできます。
<form action="InAdminServlet" method="post">
ログインID:<input type="text" name="name">
パスワード:<input type="password" name="pw">
<input type="hidden" name="action" value="adminlogin">
<input type="submit" value="ログイン">
</form>
</div>