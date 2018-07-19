<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<form action="CheckOrderServlet?action=itemsDetail" method="post">
注文番号<input type="text" name="orderedCode" style="width:50px;text-align:right">番の注文内容を
<input type="hidden" name="action" value="itemsDetail">
<input type="submit" value="表示"style="width:50px; height:50px;">
</form>

