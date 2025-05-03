package model.entity;

public class UserInfoBeans {

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
	
	public String get_userName() {
		return _userName;
	}

	public void set_userName(String _userName) 
	{
		this._userName = _userName;
	}

	public String get_mail() {
		return _mail;
	}

	public void set_mail(String _mail) {
		this._mail = _mail;
	}

	public String get_password() {
		return _password;
	}

	public void set_password(String _password) {
		this._password = _password;
	}
}
