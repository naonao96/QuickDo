<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" type="text/css" href="css/style.css">
<c:set var="mode" value="${param.mode}"/>
<c:choose>
	<c:when test="${mode == 'edit'}">
		<c:set var="title" value="タスク編集"/>
		<c:set var="buttonText" value="保存"/>
		<c:set var="action" value="editTask"/>
	</c:when>
	<c:otherwise>
        <c:set var="title" value="タスク登録"/>
        <c:set var="buttonText" value="登録"/>
        <c:set var="action" value="addTask"/>
    </c:otherwise>
</c:choose>
<div class="modal-content">
    <span class="close" onclick="closeModal()">&times;</span>
    <h3 class="title">${title}</h3>
    <form action="${action}" method="post">
    	<span>
    	    <input type="hidden" id="taskId" name="taskId" value="${param.taskId}"/>
	        <label for="taskName">タスク名</label><br>
	        <input type="text" id="taskName" name="taskName"><br>  
	        <label for="taskContents">内容</label><br>
	        <input type="text" id="taskContents" name="taskContents"><br>
	        <label for="taskDeadline">期限</label><br>
	        <input type="date" id="taskDeadline" name="taskDeadline"><br>
	        <label for="taskStatus">状態</label><br>
	        <select id="taskStatus" name="taskStatus">
	            <option value="notStarted">未着手</option>
	            <option value="inProgress">進行中</option>
	            <option value="done">完了</option>
	        </select><br>
	        <label for="taskPriority">優先度</label><br>
	        <select id="taskPriority" name="taskPriority">
	            <option value="low">低</option>
	            <option value="medium">中</option>
	            <option value="high">高</option>
	        </select><br>
	        <label for="taskAssignee">担当者</label><br>
	        <input type="text" id="taskAssignee" name="taskAssignee"><br>
	        <button type="submit" class="btn-submit-design">${buttonText}</button>
	        <c:if test="${mode == 'edit'}">
           		<button type="button" class="btn-delete-design" onclick="deleteTask()">削除</button>
           	</c:if>
        </span>
    </form>

</div>
