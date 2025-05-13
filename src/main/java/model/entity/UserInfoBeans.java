package model.entity;

public class UserInfoBeans 
{
	///<summary>
	/// ユーザID
	///</summary>
	private String _userId = "";
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
	
	public String get_userId() {
		return _userId;
	}
	
	public void set_userId(String userId) {
		this._userId = userId;
	}
	
	public String get_userName() {
		return _userName;
	}

	public void set_userName(String userName) 
	{
		this._userName = userName;
	}

	public String get_mail() {
		return _mail;
	}

	public void set_mail(String mail) {
		this._mail = mail;
	}

	public String get_password() {
		return _password;
	}

	public void set_password(String password) {
		this._password = password;
	}
}
