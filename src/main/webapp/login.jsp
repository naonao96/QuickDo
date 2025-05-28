<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>QuickDo</title>
		<link rel="stylesheet" type="text/css" href="css/style.css">
	</head>
	<body>
		<div class="sign-in-locate">
			<form action="login" method="Post">
				<h2 class="login-title">QuickDo</h2>
				<div>
					<label for="mail">Email</input><br>
					<input type="text" class="login-controller" name="mail" required="required"><br>
					<label for="password">Password</input><br>
					<input type="text" class="login-controller" name="password" required="required"><br>
					<c:set var="errorMessage" value="${requestScope.error}"/>
					<c:choose>
						<c:when test="${errorMessage != null}">
							<p class="error">${errorMessage}</p>
						</c:when>
					</c:choose>
					<input type="submit" class="login-btn" value="Sign In"><br>
					Don't have an account? <a href="http://localhost:8080/TaskManagementSystem/login">Sign Up</a>
				</div>
			</form>
		</div>
	</body>
</html>