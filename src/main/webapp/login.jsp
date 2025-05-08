<%@page import="javax.websocket.Decoder.Text"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タスク管理システム</title>
<style>
	body{
	    background-color: #C0C0C0;
        font-family: Arial, sans-serif;
    },
	.error {
		color: red;
		font-weight: bold;
	}
</style>
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