package model.entity;

public class UserInfoBeans 
{
	///<summary>
	/// ユーザID
	///</summary>
	private String userId = "";
	///<summary>
	/// ユーザ名
	///</summary>
	private String userName = "";
	///<summary>
	/// メールアドレス
	///</summary>
	private String mail = "";
	///<summary>
	/// パスワード
	///</summary>
	private String password = "";
	
	public UserInfoBeans() {
		
	}
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) 
	{
		this.userName = userName;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
