package Model.dao;

import java.sql.ResultSet;

import Model.entity.UserInfoBeans;

public class TaskInfoDAO {
	// ログインメールアドレスとパスワードの検索
	public UserInfoBeans userSertificate(String mail, String password){
		ConnectionManger connectionManger = new ConnectionManger();
		UserInfoBeans userInfo = new UserInfoBeans();
		ResultSet ret = null;
		
		/*		//try(Connection con = connectionManger.getConnection();
						Statement stmt = con.createStatement();			
						)
				{
					BufferedReader br = new BufferedReader(new FileReader("src/main/java/sql/selectUserInfo.sql"));
					String query = br.readLine();
					
					ret = stmt.executeQuery(query);
					
					while (ret.next()) {
						userInfo.set_userId(ret.getInt("userId"));
						userInfo.set_userName(ret.getString("userName"));
						userInfo.set_mail(ret.getString("mail"));
						userInfo.set_password(ret.getString("password"));
					}
					
					//後始末
					br.close();
					stmt.close();
					con.close();
				}
				catch(Exception e) 
				{
					e.printStackTrace();
					System.out.println("DB接続失敗");
				}*/
		return userInfo;
	}
	
}
