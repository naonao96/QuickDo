package Model.dao;

public class ConnectionManger {

	// JDBCドライバのクラス名
	private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	// DB接続URL
	private static final String URL = "jdbc:mysql://localhost:3306/taskmanage_db";
	// DB接続ユーザ名
	private static final String USER = "root";
	// DB接続パスワード
	private static final String PASSWORD = "root";

	public ConnectionManger() 
	{
		
	}
}
