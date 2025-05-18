<%-- TaskModal.jsp --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String mode = request.getParameter("mode");
	System.out.println("mode: " + mode);
    String title = "タスク登録";
    String buttonText = "登録";
    String action = "addTask";
    if ("edit".equals(mode)) {
        title = "タスク編集";
        buttonText = "保存";
        action = "editTask";
    }
%>
<div id="ModalWindow" class="modal">
    <div class="modal-content">
        <span class="close" onclick="closeModal()">&times;</span>
        <h2><%= title %></h2>
        <form action="<%= action %>" method="post">
            <input type="hidden" id="taskId" name="taskId">
            <p>
                <label for="taskName">タスク名:</label>
                <input type="text" id="taskName" name="taskName">
            </p>
            <p>
                <label for="taskContents">内容:</label>
                <input type="text" id="taskContents" name="taskContents">
            </p>
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
            <button type="submit"><%= buttonText %></button>
        </form>
    </div>
</div>
