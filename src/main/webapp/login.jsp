<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タスク管理システム</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<form action="login" method="Post">
		<h2>ログイン画面</h2><br>
		メールアドレス：<input type="text" name="mail" required="required"><br>
		パスワード：<input type="text" name="password" required="required"><br>
		<c:set var="errorMessage" value="${requestScope.error}"/>
		<c:choose>
			<c:when test="${errorMessage != null}">
				<p class="error">${errorMessage}</p>
			</c:when>
		</c:choose>
		<input type="submit" class="btn-right-design" value="ログイン">
	</form>
</body>
</html>