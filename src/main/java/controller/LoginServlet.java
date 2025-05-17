package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import model.dao.TaskManagementDAO;
import model.entity.TaskInfoBeans;
import model.entity.UserInfoBeans;
import util.UtilityTools;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 *  JSPをサーブレットから呼び出すと、文字化けが発生してしまう
		 *  デフォルトでソース生成を行った際にDoPostメソッドを
		 *  doPostメソッドの中で呼び出すという謎の処理が記述されていた
		 */
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		TaskManagementDAO dao = new TaskManagementDAO();
		
		UserInfoBeans userInfo = new UserInfoBeans();
		List<TaskInfoBeans> taskList = new ArrayList<TaskInfoBeans>();

		try 
		{
			// ユーザ情報の取得
			userInfo = dao.revUserSertificate(request.getParameter("mail"), request.getParameter("password"));
			// タスク情報の取得(タスクデータはユーザIDに紐づいている（親子関係）)
			if (userInfo != null) 
				taskList = dao.revTaskList(userInfo.get_userId());
		}
		catch(Exception e) 
		{
			e.printStackTrace();
			System.out.println("データの取得に失敗しました");
		}
		
		if(UtilityTools.loginCheck(request.getParameter("mail"), request.getParameter("password")) == true)
		{
			// ログインに成功した場合
			HttpSession session = request.getSession();
			session.setAttribute("userName", userInfo.get_userName());
			request.setAttribute("taskList", taskList);
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/menu.jsp");
			rd.forward(request, response);
		}
		else 
		{
			// ログインに失敗した場合
			request.setAttribute("error", UtilityTools.LOGIN_ERROR);
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
		
	}

}
