package Model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManger 
{
	// DB接続URL
	private String _url = "";
	// DB接続ユーザ名
	private String _User = "";
	// DB接続パスワード
	private String _Password = "";

	public ConnectionManger(String url, String user, String password)
	{
		this._url = url;
		this._User = user;
		this._Password = password;
	}
	
	// クラスのアクセスレベルはprivateにしてしまうとインスタンス化しても外部から呼び出しできない
	// ConnectionManagerクラスは外部呼出しを想定したクラスのためpublicに変更
	public Connection getConnection() throws SQLException, ClassNotFoundException
	{
		try {
			Connection con = DriverManager.getConnection(_url, _User, _Password);
			
			System.out.println("DB接続成功");
			return con;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			System.out.println("DB接続失敗");
		}
		return null;
	}
	
}
