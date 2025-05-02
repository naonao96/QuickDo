package Model.dao;

import java.sql.Connection;
import java.sql.ResultSet;

import Model.entity.UserInfoBeans;
import Util.FileControlUtil;

public class TaskInfoDAO {
	
	// DB接続URL
	private String _url = "jdbc:mysql://localhost:3306/taskdb?useSSL=false&serverTimezone=UTC";
	// DB接続ユーザ名
	private String _User = "taskUser";
	// DB接続パスワード
	private String _Password = "taskPass";
	
	// ログインメールアドレスとパスワードの検索
	public UserInfoBeans userSertificate(String mail, String password){
		ConnectionManger connectionManger = new ConnectionManger(_url, _User, _Password);
		UserInfoBeans userInfo = new UserInfoBeans();
		
		try(Connection con = connectionManger.getConnection();)
		{
			String query = FileControlUtil.readFile("Sql/selectUserInfo.sql");
			
			if (query == null) {
				System.out.println("SQLファイルの読み込みに失敗しました。");
				return null;
			}
			
			// 一致するユーザの取得を行います
			ResultSet ret = con.createStatement().executeQuery(query);
			
			while (ret.next()) {
				userInfo.set_userName(ret.getString("userName"));
				userInfo.set_mail(ret.getString("mail"));
				userInfo.set_password(ret.getString("password"));
			}
			
			con.close();
		}
		catch(Exception e) 
		{
			e.printStackTrace();
			System.out.println("データ取得失敗");
		}
		return userInfo;
	}
	
}
