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

@WebServlet("/menu")
public class MenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MenuServlet() {
    	super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		UserInfoBeans userInfo = (UserInfoBeans) session.getAttribute("userInfo");
		
		// セッションにユーザ情報がない場合はログイン画面へリダイレクト
		if(userInfo == null) {
			response.sendRedirect("login");
			return;
		}
		
		TaskManagementDAO dao = new TaskManagementDAO();
		try {
			// タスクリストを取得する
			List<TaskInfoBeans> taskInfo = dao.revTaskList(userInfo.getUserId());
			request.setAttribute("taskInfo", taskInfo);
		}catch (Exception e) {
			response.sendRedirect("login");
			return;
		}
		
		request.getRequestDispatcher("/WEB-INF/menu.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		if(UtilityTools.loginCheck(request.getParameter("mail"), request.getParameter("password")) == true) {
			request.getRequestDispatcher("/WEB-INF/menu.jsp").forward(request, response);
		} else {
			request.setAttribute("errorMessage", UtilityTools.LOGIN_ERROR);
			request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
		}
	}

}
