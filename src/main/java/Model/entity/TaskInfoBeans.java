package Model.entity;

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
	/// タスク開始時刻
	///</summary>
	private Date _taskStartDateTime;
	///<summary>
	/// タスク名
	///</summary>
	private Date _taskEndDateTime;
	///<summary>
	/// タスク名
	///</summary>
	private String _taskContent;
	
	
	public TaskInfoBeans() {

	}

	/**
	 * @return _taskName
	 */
	public String get_taskName() {
		return _taskName;
	}

	/**
	 * @param _taskName セットする 
	 */
	public void set_taskName(String _taskName) {
		this._taskName = _taskName;
	}

	/**
	 * @return _taskStartDateTime
	 */
	public Date get_taskStartDateTime() {
		return _taskStartDateTime;
	}

	/**
	 * @param _taskStartDateTime セットする _taskStartDateTime
	 */
	public void set_taskStartDateTime(Date _taskStartDateTime) {
		this._taskStartDateTime = _taskStartDateTime;
	}

	/**
	 * @return _taskEndDateTime
	 */
	public Date get_taskEndDateTime() {
		return _taskEndDateTime;
	}

	/**
	 * @param _taskEndDateTime セットする _taskEndDateTime
	 */
	public void set_taskEndDateTime(Date _taskEndDateTime) {
		this._taskEndDateTime = _taskEndDateTime;
	}

	/**
	 * @return _taskContent
	 */
	public String get_taskContent() {
		return _taskContent;
	}

	/**
	 * @param _taskContent セットする _taskContent
	 */
	public void set_taskContent(String _taskContent) {
		this._taskContent = _taskContent;
	}
	
	
	
}
