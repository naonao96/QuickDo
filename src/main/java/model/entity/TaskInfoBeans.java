package model.entity;

import java.util.Date;

///<summary>
/// タスク情報を格納するBeansクラス
/// </summary>
public class TaskInfoBeans {
	
	///<summary>
	/// タスク名
	///</summary>
	private String _taskName = "";
	///<summary>
	/// タスク内容
	///</summary>
	private String _taskContent;
	///<summary>
	/// 期限
	///</summary>
	private Date _taskDeadline;
	///<summary>
	/// 状態
	///</summary>
	private String _taskStatus;
	///<summary>
	/// 優先度
	///</summary>
	private String _taskPriority;	
	///<summary>
	/// 担当者
	///</summary>
	private String _taskAsignee;
	
	
	public TaskInfoBeans() {

	}

	public String get_taskName() {
		return _taskName;
	}

	public void set_taskName(String _taskName) {
		this._taskName = _taskName;
	}

	public String get_taskContent() {
		return _taskContent;
	}

	public void set_taskContent(String taskContent) {
		this._taskContent = taskContent;
	}

	public Date get_taskDeadline() {
		return _taskDeadline;
	}

	public void set_taskDeadline(Date taskDeadline) {
		this._taskDeadline = taskDeadline;
	}

	public String get_taskStatus() {
		return _taskStatus;
	}

	public void set_taskStatus(String taskStatus) {
		this._taskStatus = taskStatus;
	}
	
	public String get_taskPriority() {
		return _taskPriority;
	}

	public void set_taskPriority(String taskPriority) {
		this._taskPriority = taskPriority;
	}
	public String get_taskAsignee() {
		return _taskAsignee;
	}

	public void set_taskAsignee(String taskAsignee) {
		this._taskAsignee = taskAsignee;
	}
	
	
}
