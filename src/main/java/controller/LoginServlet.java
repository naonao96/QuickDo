package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.TaskInfoDAO;
import model.entity.TaskInfoBeans;
import model.entity.UserInfoBeans;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// JSPをサーブレットから呼び出すと、文字化けが発生してしまう
		// デフォルトでソース生成を行った際にDoPostメソッドをdoPostメソッドの中で呼び出すという謎の処理が記述されていた
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String errorMessage = "ログインに失敗しました。メールアドレスかパスワードを間違えています。再度入力してください。";
		
		String mail = request.getParameter("mail");
		String password = request.getParameter("password");
		
		TaskInfoDAO dao = new TaskInfoDAO();
		
		TaskInfoBeans taskInfo = new TaskInfoBeans();
		UserInfoBeans userInfo = new UserInfoBeans();
		
		//ログイン確認用ユーザ情報の取得
		try 
		{
			userInfo = dao.userSertificate(mail,password);
		}
		catch(Exception e) 
		{
			e.printStackTrace();
			System.out.println("データの取得に失敗しました");
		}
		
		//DEBUG用：テスト用のタスク情報を作成
		
		ArrayList<TaskInfoBeans> taskList = new ArrayList<TaskInfoBeans>();
		Date datetime = new Date(System.currentTimeMillis());
		taskInfo.set_taskName("タスク名");
		taskInfo.set_taskContent("タスク内容");
		taskInfo.set_taskDeadline(datetime);
		taskInfo.set_taskStatus("未着手");
		taskInfo.set_taskPriority("高");
		taskInfo.set_taskAsignee("担当者");
		taskList.add(taskInfo);
		//DEBUG用：テスト用のタスク情報を作成
		
	
		if(userInfo.get_mail() == "" && userInfo.get_password() == "")
		{
			// ログインに失敗した場合
			request.setAttribute("error", errorMessage);
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
		else 
		{
			// ログインに成功した場合
			HttpSession session = request.getSession();
			session.setAttribute("userName", userInfo.get_userName());
			request.setAttribute("taskList", taskList);
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/menu.jsp");
			rd.forward(request, response);
		}
		
	}

}
