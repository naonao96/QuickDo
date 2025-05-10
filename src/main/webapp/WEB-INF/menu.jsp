<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, model.entity.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タスク一覧</title>
<style>
    body {
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
    table {
        width: 100%;
        border-collapse: collapse;
    }
    th, td {
        border: 1px solid #000;
        padding: 8px;
        text-align: left;
    }
    th {
        background-color: #f2f2f2;
    }
    .modal {
        display: none;
        position: fixed;
        z-index: 1;
        left: 0;
        top: 0;
        width: 100%;
        height: 100%;
        overflow: auto;
        background-color: rgba(0, 0, 0, 0.4);
    }
    .modal-content {
        background-color: #fff;
        margin: 15% auto;
        padding: 20px;
        border: 1px solid #888;
        width: 50%;
    }
    .close {
        color: #aaa;
        float: right;
        font-size: 28px;
        font-weight: bold;
    }
    .close:hover,
    .close:focus {
        color: black;
        text-decoration: none;
        cursor: pointer;
    }
</style>
<script>
    function openModal(taskName, taskContents, taskDeadline, taskStatus, taskPriority, taskAssignee) {
        document.getElementById("taskName").value = taskName;
        document.getElementById("taskContents").value = taskContents;
        document.getElementById("taskDeadline").value = taskDeadline;
        document.getElementById("taskStatus").value = taskStatus;
        document.getElementById("taskPriority").value = taskPriority;
        document.getElementById("taskAssignee").value = taskAssignee;
        document.getElementById("editModal").style.display = "block";
    }

    function closeModal() {
        document.getElementById("editModal").style.display = "none";
    }

    window.onclick = function(event) {
        const modal = document.getElementById("editModal");
        if (event.target === modal) {
            closeModal();
        }
    };
</script>
</head>
<body>	
	<div class="header">
		<h2 class="title">タスク一覧</h2>
		<div class="loginDisp">
			<%=session.getAttribute("userName")%>さん
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
            <%
                List<TaskInfoBeans> tasks = (List<TaskInfoBeans>) request.getAttribute("taskList");
                if (tasks != null && !tasks.isEmpty()) {
                    for (TaskInfoBeans task : tasks) {
            %>
            <tr onclick="openModal(
            '<%= task.get_taskName() %>', 
            '<%= task.get_taskContent() %>',
            '<%= task.get_taskDeadline() %>', 
            '<%= task.get_taskStatus() %>', 
            '<%= task.get_taskPriority() %>', 
            '<%= task.get_taskAsignee() %>')">
                <td><%= task.get_taskName() %></td>
                <td><%= task.get_taskContent() %></td>
                <td><%= task.get_taskDeadline() %></td>
                <td><%= task.get_taskStatus() %></td>
                <td><%= task.get_taskPriority() %></td>
                <td><%= task.get_taskAsignee() %></td>
            </tr>
            <%
                    }
                } else {
            %>
            <tr>
                <td colspan="5">タスクがありません。</td>
            </tr>
            <%
                }
            %>
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
