// タスク編集画面を開く
function openModal(taskName, taskContents, taskDeadline, taskStatus, taskPriority, taskAssignee, mode) {
	var modal = document.getElementById("ModalWindow");
	console.log("mode: " + mode);
	loadTaskModal(mode)
	if (mode === "edit") {
		// 編集モードのとき
		document.getElementById("taskName")    .value = taskName;
		document.getElementById("taskContents").value = taskContents;
		document.getElementById("taskDeadline").value = taskDeadline;
		document.getElementById("taskStatus")  .value = taskStatus;
		document.getElementById("taskPriority").value = taskPriority;
		document.getElementById("taskAssignee").value = taskAssignee;
	}else {
		// 追加モードのとき
        document.getElementById("taskName")    .value = "";
        document.getElementById("taskContents").value = "";
        document.getElementById("taskDeadline").value = "";
        document.getElementById("taskStatus")  .value = "";
        document.getElementById("taskPriority").value = "";
        document.getElementById("taskAssignee").value = "";
    }
	modal.style.display = "block";
	modal.dataset.mode = mode;
}

// TaskModal.jspをロードする関数
// TODO:この関数はまだちゃんと理解できたわけではない...
function loadTaskModal(mode) {
    var xhr = new XMLHttpRequest();
    xhr.open('GET', 'WEB-INF/TaskModal.jsp?mode=' + encodeURIComponent(mode), true);
    xhr.onload = function () {
        if (xhr.status >= 200 && xhr.status < 300) {
            // modal-contentの中身をTaskModal.jspの内容で更新
            var modalContent = document.querySelector('#ModalWindow .modal-content');
            modalContent.innerHTML = xhr.responseText;
        } else {
            console.error('TaskModal.jspのロードに失敗しました。');
        }
    };
    xhr.onerror = function () {
        console.error('TaskModal.jspのロードに失敗しました。');
    };
    xhr.send();
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