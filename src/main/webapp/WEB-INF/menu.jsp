<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, model.entity.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>QuickDo：タスク一覧</title>
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<script type="text/javascript" src="js/modalScript.js"></script>
	<script type="text/javascript" src="js/menuScript.js"></script>
</head>
<body>	
	<div class="menu-header">
		<div class="menu-title">Dashboard</div>
		<button onclick="logout()" type="submit"class="btn-left-design">Sign Out</button>
    </div>
	<h3 class="loginDisp">
	    <c:set var="userInfo" value="${sessionScope.userInfo}"/>
		${userInfo.userName}さん:本日もお疲れ様です。
	</h3>
    <table>
        <thead class="task-header">
            <tr>
                <th>タスク名</th>
                <th>内容</th>
                <th>期限</th>
                <th>状態</th>
                <th>優先度</th>
                <th>担当者</th>
            </tr>
        </thead>
        <tbody>
        	<c:forEach items="${taskInfo}" var="task">
            	<tr onclick="
            	openModal(
            	 '${task.taskId}',
            	 '${task.taskName}',
            	 '${task.taskContent}',
            	 '${task.taskDeadline}',
            	 '${task.taskStatus}',
            	 '${task.taskPriority}',
            	 '${task.taskAssignee}',
            	 'edit')">
                	<td>${task.taskName}</td>
                	<td>${task.taskContent}</td>
                	<td>${task.taskDeadline}</td>
                	<td>
                		<c:choose>
                			<c:when test="${task.taskStatus eq 'notStarted'}">未着手</c:when>
                			<c:when test="${task.taskStatus eq 'inProgress'}">進行中</c:when>
                			<c:when test="${task.taskStatus eq 'done'}">完了</c:when>
                		</c:choose>
                	</td>
                	<td>
    					<c:choose>
        					<c:when test="${task.taskPriority eq 'low'}">低</c:when>
      						<c:when test="${task.taskPriority eq 'medium'}">中</c:when>
      						<c:when test="${task.taskPriority eq 'high'}">高</c:when>
    					</c:choose>
					</td>
                	<td>${task.taskAssignee}</td>
            	</tr>
			</c:forEach>
        </tbody>
    </table>
    <br>
    <div class="">
    	<button onclick="openModal('','','','','','','','add')" type="submit"class="btn-right-design">Add Task</button>
    </div>
    <!-- Modal画面をTaskModal.jspから下記にロードする -->
    <div id="ModalWindow" class="modal">
    </div>
</body>
</html>
