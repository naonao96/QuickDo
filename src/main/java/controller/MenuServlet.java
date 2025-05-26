package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

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
		
		if(request.getParameter("mode") != null) {
			request.getRequestDispatcher("/TaskModal.jsp").forward(request, response);
			return;
		}
		
		//ログインチェック
		if(UtilityTools.loginCheck(request.getParameter("mail"), request.getParameter("password")) == true) {
			//ログイン成功
			request.getRequestDispatcher("/WEB-INF/menu.jsp").forward(request, response);
		} else {
			//ログイン失敗
			request.setAttribute("errorMessage", UtilityTools.LOGIN_ERROR);
			request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
		}
	}

}
