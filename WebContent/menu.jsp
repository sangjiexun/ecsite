<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<a href="/ecsite/ShowItemServlet?action=top">ようこそ！</a>
<c:forEach items="${categories}" var="category">
<a href="/ecsite/ShowItemServlet?action=list&code=${category.code}">${category.name}</a>
</c:forEach>

<a href="/ecsite/CartServlet?action=show">カートを見る</a>

<br><br>

<a href="/ecsite/LoginServlet?action=logout">ログアウト</a>