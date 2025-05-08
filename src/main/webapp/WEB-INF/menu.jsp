<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.entity.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タスク管理システムメニュー</title>
<style>
	body{
	    background-color: #C0C0C0;
        font-family: Arial, sans-serif;
    }
    .header{
        display: flex;
        justify-content: space-between;
    	align-items: center;
    	padding: 10px;
    }
    .title{
        text-align: left;
        margin: 0;
    }
    .loginDisp{
        text-align: right;
        margin: 0;
    }
</style>
</head>
<body>
	<div class="header">
		<h2 class="title">タスク一覧</h2>
		<div class="loginDisp">
			<%=session.getAttribute("userName")%>さん
		</div>
    </div>
   	<div class="task">
        <p>タスク名：</p>
        <p>期限：</p>
        <p>状態：</p>
        <p>優先度：</p>
        <p>担当者：</p>
        <a href="">詳細</a>
        <a href="">編集</a>
        <a href="">削除</a>
    </div>
</body>
</html>