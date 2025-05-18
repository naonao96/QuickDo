package model.entity;

import java.util.Date;

///<summary>
/// タスク情報を格納するBeansクラス
/// </summary>
public class TaskInfoBeans {
	
	///<summary>
	/// タスクID
	///</summary>
	private String taskId = "";
	///<summary>
	/// タスク名
	///</summary>
	private String taskName = "";
	///<summary>
	/// タスク内容
	///</summary>
	private String taskContent;
	///<summary>
	/// 期限
	///</summary>
	private Date taskDeadline;
	///<summary>
	/// 状態
	///</summary>
	private String taskStatus;
	///<summary>
	/// 優先度
	///</summary>
	private String taskPriority;	
	///<summary>
	/// 担当者
	///</summary>
	private String taskAssignee;
	
	
	public TaskInfoBeans() {

	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	
	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getTaskContent() {
		return taskContent;
	}

	public void setTaskContent(String taskContent) {
		this.taskContent = taskContent;
	}

	public Date getTaskDeadline() {
		return taskDeadline;
	}

	public void setTaskDeadline(Date taskDeadline) {
		this.taskDeadline = taskDeadline;
	}

	public String getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}
	
	public String getTaskPriority() {
		return taskPriority;
	}

	public void setTaskPriority(String taskPriority) {
		this.taskPriority = taskPriority;
	}
	
	public String getTaskAssignee() {
		return taskAssignee;
	}

	public void setTaskAssignee(String taskAssignee) {
		this.taskAssignee = taskAssignee;
	}
	
	
}
