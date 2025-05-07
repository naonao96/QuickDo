package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.entity.UserInfoBeans;
import util.FileControlUtil;

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
			String query = FileControlUtil.readFile("/sql/selectUserInfo.sql");
			
			if (query == null) {
				System.out.println("SQLファイルの読み込みに失敗しました。");
				return null;
			}
			
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, mail);
			pstmt.setString(2, password);
			
			// 一致するユーザの取得を行います
			ResultSet ret = pstmt.executeQuery();
			
			while (ret.next()) {
				userInfo.set_userName(ret.getString("name"));
				userInfo.set_mail(ret.getString("mail_address"));
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
