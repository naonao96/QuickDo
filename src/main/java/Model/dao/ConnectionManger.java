package Model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManger 
{
	// DB接続URL
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/taskmanage_db?useSSL=false&serverTimezone=UTC";
	// DB接続ユーザ名
	private static final String USER = "taskmanageuser";
	// DB接続パスワード
	private static final String PASSWORD = "taskmanagepassword";

	public ConnectionManger() 
	{
		
	}
	
	// クラスのアクセスレベルはprivateにしてしまうとインスタンス化しても外部から呼び出しできない
	// ConnectionManagerクラスは外部呼出しを想定したクラスのためpublicに変更
	public Connection getConnection() throws SQLException, ClassNotFoundException
	{
		try {
			Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
			
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
