package Model.entity;

public class UserInfoBeans {

	///<summary>
	/// ユーザID
	///</summary>
	private int _userId = 0;
	///<summary>
	/// ユーザ名
	///</summary>
	private String _userName = "";
	///<summary>
	/// メールアドレス
	///</summary>
	private String _mail = "";
	///<summary>
	/// パスワード
	///</summary>
	private String _password = "";
	
	public UserInfoBeans() {
		
	}
	
	
	/**
	 * @return _userId
	 */
	public int get_userId() {
		return _userId;
	}
	/**
	 * @param _userId セットする 
	 */
	public void set_userId(int _userId) {
		this._userId = _userId;
	}
	/**
	 * @return _userName
	 */
	public String get_userName() {
		return _userName;
	}
	/**
	 * @param _userName セットする 
	 */
	public void set_userName(String _userName) 
	{
		this._userName = _userName;
	}
	/**
	 * @return _mail
	 */
	public String get_mail() {
		return _mail;
	}

	/**
	 * @param _mail セットする 
	 */
	public void set_mail(String _mail) {
		this._mail = _mail;
	}

	/**
	 * @return _password
	 */
	public String get_password() {
		return _password;
	}

	/**
	 * @param _password セットする 
	 */
	public void set_password(String _password) {
		this._password = _password;
	}
}
