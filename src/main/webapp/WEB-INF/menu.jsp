<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, model.entity.*" %>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>タスク一覧</title>
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<script type="text/javascript" src="js/modalScript.js"></script>
</head>
<body>	
	<div class="header">
		<h2 class="title">現在のタスク一覧</h2>
		<div class="loginDisp">
			${userName}さん:本日もお疲れ様です。
		</div>
    </div>
    <table>
        <thead>
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
        	<c:forEach items="${taskList}" var="task">
            	<tr onclick="openModal(
            	'${task.taskName}', 
            	'${task.taskContent}',
            	'${task.taskDeadline}', 
            	'${task.taskStatus}', 
            	'${task.taskPriority}', 
            	'${task.taskAssignee}')">
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

    <!-- Modal -->
    <div id="editModal" class="modal">
        <div class="modal-content">
            <span class="close" onclick="closeModal()">&times;</span>
            <h2>タスク編集</h2>
            <form action="editTask" method="post">
                <input type="hidden" id="taskId" name="taskId">
                <p>
                    <label for="taskName">タスク名:</label>
                    <input type="text" id="taskName" name="taskName">
                </p>
                <p>
                    <label for="taskContents">内容:</label>
                    <input type="text" id="taskContents" name="taskContents"></textarea>
                <p>
                    <label for="taskDeadline">期限:</label>
                    <input type="date" id="taskDeadline" name="taskDeadline">
                </p>
                <p>
                    <label for="taskStatus">状態:</label>
                    <select id="taskStatus" name="taskStatus">
                        <option value="notStarted">未着手</option>
                        <option value="inProgress">進行中</option>
                        <option value="done">完了</option>
                    </select>
                </p>
                <p>
                    <label for="taskPriority">優先度:</label>
                    <select id="taskPriority" name="taskPriority">
                        <option value="low">低</option>
                        <option value="medium">中</option>
                        <option value="high">高</option>
                    </select>
                </p>
                <p>
                    <label for="taskAssignee">担当者:</label>
                    <input type="text" id="taskAssignee" name="taskAssignee">
                </p>
                <button type="submit">保存</button>
            </form>
        </div>
    </div>
</body>
</html>
