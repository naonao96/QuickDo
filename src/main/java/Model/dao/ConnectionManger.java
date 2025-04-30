package Model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManger 
{
	// DB接続URL
	private final String URL = "jdbc:mysql://localhost:3306/taskdb?useSSL=false&serverTimezone=UTC";
	// DB接続ユーザ名
	private final String USER = "taskUser";
	// DB接続パスワード
	private final String PASSWORD = "taskPass";

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
