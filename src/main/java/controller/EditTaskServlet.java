package controller;

import java.io.IOException;
import java.util.List;

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

@WebServlet("/editTask")
public class EditTaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public EditTaskServlet() {
    	
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		TaskManagementDAO dao = new TaskManagementDAO();
		HttpSession session = request.getSession();
		UserInfoBeans userInfo = (UserInfoBeans)session.getAttribute("userInfo");
		
		try {
			//タスクの更新機能
			Boolean updRes = dao.updTaskInfo(
				request.getParameter("taskId"),
				userInfo.getUserId(),
				request.getParameter("taskName"),
				request.getParameter("taskContents"),
				request.getParameter("taskDeadline"),
				request.getParameter("taskStatus"),
				request.getParameter("taskPriority"),
				request.getParameter("taskAssignee")
			);
			
			if (updRes) {
				System.out.println("タスクの更新に成功しました。タスクを再取得します。");
				// タスクリストの再取得
				List<TaskInfoBeans> taskInfo = dao.revTaskList(userInfo.getUserId());
				request.setAttribute("taskInfo", taskInfo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(UtilityTools.loginCheck(userInfo.getMail(), userInfo.getPassword()) == true)
		{
			// ログインに成功した場合
			request.getRequestDispatcher("WEB-INF/menu.jsp").forward(request, response);
		}
		else 
		{
			// ログインに失敗した場合
			request.setAttribute("error", UtilityTools.LOGIN_ERROR);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

}
