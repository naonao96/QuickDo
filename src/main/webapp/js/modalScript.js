// タスク編集画面を開く
function openModal(taskName, taskContents, taskDeadline, taskStatus, taskPriority, taskAssignee) {
    document.getElementById("taskName").value = taskName;
    document.getElementById("taskContents").value = taskContents;
    document.getElementById("taskDeadline").value = taskDeadline;
    document.getElementById("taskStatus").value = taskStatus;
    document.getElementById("taskPriority").value = taskPriority;
    document.getElementById("taskAssignee").value = taskAssignee;
    document.getElementById("editModal").style.display = "block";
}

// タスク編集画面を閉じる
function closeModal() {
    document.getElementById("editModal").style.display = "none";
}

// モーダルを閉じるボタンをクリックしたとき
window.onclick = function(event) {
    const modal = document.getElementById("editModal");
    if (event.target === modal) {
        closeModal();
    }
};