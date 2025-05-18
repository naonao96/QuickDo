// タスク編集画面を開く
function openModal(mode, taskName, taskContents, taskDeadline, taskStatus, taskPriority, taskAssignee) {
	var mode = document.getElementById("ModalWindow").dataset.mode;
	if (mode === "edit") {
		// 編集モードのとき
		document.getElementById("taskName").value = taskName;
		document.getElementById("taskContents").value = taskContents;
		document.getElementById("taskDeadline").value = taskDeadline;
		document.getElementById("taskStatus").value = taskStatus;
		document.getElementById("taskPriority").value = taskPriority;
		document.getElementById("taskAssignee").value = taskAssignee;
	}else {
		// 追加モードのとき
        document.getElementById("taskName").value = "";
        document.getElementById("taskContents").value = "";
        document.getElementById("taskDeadline").value = "";
        document.getElementById("taskStatus").value = "";
        document.getElementById("taskPriority").value = "";
        document.getElementById("taskAssignee").value = "";
    }
	var modal = document.getElementById("ModalWindow");
	modal.style.display = "block";
	modal.dataset.mode = mode;
}

// タスク編集画面を閉じる
function closeModal() {
	var modal = document.getElementById("ModalWindow");
	if(modal){
		modal.style.display = "none";
	}
}

// モーダルを閉じるボタンをクリックしたとき
window.onclick = function(event) {
    const modal = document.getElementById("ModalWindow");
    if (modal && event.target === modal) {
        modal.style.display = "none";
    }
};