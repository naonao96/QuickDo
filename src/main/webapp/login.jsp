<%@page import="javax.websocket.Decoder.Text"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タスク管理システム</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<form action="Login" method="Post">
		<h2>ログイン画面</h2>
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