<%@page import="javax.websocket.Decoder.Text"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タスク管理システム</title>
<style>
.error {
	color: red;
	font-weight: bold;
}
</style>
</head>
<body>
	<form action="Login" method="Post">
		<h1>ログイン画面</h1>
		<br> メールアドレス：<input type="text" name="mail"><br>
		パスワード：<input type="text" name="password"><br>
		<% String errorMessage = (String)request.getAttribute("error"); %>
		<%
			if(errorMessage != null)
			{
		%>
		<p class="error"><%= errorMessage %></p>
		<%
			} 
		%>
		<input type="submit" value="登録">
	</form>
</body>
</html>