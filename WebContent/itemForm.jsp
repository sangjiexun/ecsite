<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h2>サイト内の商品情報の検索・編集ができます。</h2><br>

ソート<a href="/ecsite/ItemServlet?action=sort&key=price_asc">値段の低い順</a>
<a href="/ecsite/ItemServlet?action=sort&key=price_desc">値段の高い順</a>
（クリックすると商品一覧が表示されます。）<br>

<form action="/ecsite/ItemServlet" method="post">
追加：商品名<input type="text" name="name">
価格<input type="text" name="price" size="5">
円、カテゴリー
<select size="1" name="category">
	<option value="1">本</option>
	<option value="2" selected="selected">BD・DVD</option>
	<option value="3">家電</option>
	<option value="4">服・シューズ</option>
	<option value="5">パソコン・オフィス用品</option>
</select>
を<input type="submit" value="追加">
<input type="hidden" name="action" value="add">
</form>

<form action="/ecsite/ItemServlet" method="post">
検索：<input type="text" name="price" size="5">円以下の商品を
<input type="submit" value="検索">
<input type="hidden" name="action" value="search">
</form>

<form action="/ecsite/ItemServlet" method="post">
削除：商品番号<input type="text" name="code" size="5">
番の商品を<input type="submit" value="削除">
<input type="hidden" name="action" value="delete">
</form>