package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.entity.TaskInfoBeans;
import model.entity.UserInfoBeans;
import util.FileControlUtil;

public class TaskManagementDAO {
	
	// DB接続URL
	private String _url = "jdbc:mysql://localhost:3306/taskdb?useSSL=false&serverTimezone=UTC";
	// DB接続ユーザ名
	private String _User = "taskUser";
	// DB接続パスワード
	private String _Password = "taskPass";
	
	// ログインメールアドレスとパスワードの検索
	public UserInfoBeans revUserSertificate(String mail, String password){
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
				userInfo.set_userId(ret.getString("user_id"));
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
	
	// タスク一覧取得を行う
	public List<TaskInfoBeans> revTaskList(String userId) 
	{
		ConnectionManger connectionManger = new ConnectionManger(_url, _User, _Password);
		List<TaskInfoBeans> taskList = new ArrayList<TaskInfoBeans>();
		try(Connection con = connectionManger.getConnection();)
		{
			String query = FileControlUtil.readFile("/sql/selectTaskInfo.sql");
			
			if (query == null) {
				System.out.println("SQLファイルの読み込みに失敗しました。");
				return null;
			}
			
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, userId);
			
			// 一致するユーザの取得を行います
			ResultSet ret = pstmt.executeQuery();
			
			while (ret.next()) {
				TaskInfoBeans taskInfo = new TaskInfoBeans();
				taskInfo.set_taskId(ret.getString("task_id"));
				taskInfo.set_taskName(ret.getString("task_name"));
				taskInfo.set_taskContent(ret.getString("task_contents"));
				taskInfo.set_taskDeadline(ret.getDate("task_deadline"));
				taskInfo.set_taskStatus(ret.getString("task_status"));
				taskInfo.set_taskPriority(ret.getString("task_priority"));
				taskInfo.set_taskAssignee(ret.getString("task_assignee"));
				
				taskList.add(taskInfo);
			}
			
			con.close();
		}
		catch(Exception e) 
		{
			e.printStackTrace();
			System.out.println("データ取得失敗");
		}
		return taskList;
	}
	
	// タスク新規登録を行う
	public boolean insTaskInfo() 
	{
		return false;
	}
	
	// タスク更新登録を行う
	public boolean updTaskInfo() 
	{
		return false;
	}
	
	// タスク削除を行う
	public boolean delTaskInfo() 
	{
		return false;
	}
}
