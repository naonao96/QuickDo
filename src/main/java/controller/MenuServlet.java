package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.entity.TaskInfoBeans;
import util.UtilityTools;

@WebServlet("/menu")
public class MenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MenuServlet() {
    	
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		//ログインチェック
		if(UtilityTools.loginCheck(request.getParameter("mail"), request.getParameter("password")) == true) {
			//ログイン成功
			request.getRequestDispatcher("WEB-INF/menu.jsp").forward(request, response);
		} else {
			//ログイン失敗
			request.setAttribute("errorMessage", UtilityTools.LOGIN_ERROR);
			request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
		}
		
		try {			
			//タスクの取得機能
			List<TaskInfoBeans> taskList = new ArrayList<TaskInfoBeans>();
			
			//タスクの登録機能
			
			
			//タスクの更新機能
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		

	}

}
