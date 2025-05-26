package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import model.dao.TaskManagementDAO;
import model.entity.UserInfoBeans;
import util.UtilityTools;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 *  JSPをサーブレットから呼び出すと、文字化けが発生してしまう
		 *  デフォルトでソース生成を行った際にDoPostメソッドを
		 *  doPostメソッドの中で呼び出すという謎の処理が記述されていた
		 */
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		TaskManagementDAO dao = new TaskManagementDAO();
		UserInfoBeans userInfo = new UserInfoBeans();

		try 
		{
			userInfo = dao.revUserSertificate(request.getParameter("mail"), request.getParameter("password"));
		}
		catch(Exception e) 
		{
			request.setAttribute("error", UtilityTools.DATA_FETCH_ERROR);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
		// ログインチェック（ユーザ情報が取得できていればmenu画面へ / 取得できてなればlogin画面へ）
		if(UtilityTools.loginCheck(userInfo.getMail(), userInfo.getPassword()) == true)
		{
			HttpSession session = request.getSession();
			session.setAttribute("userInfo", userInfo);
			response.sendRedirect("menu");
		}
		else 
		{
			request.setAttribute("error", UtilityTools.LOGIN_ERROR);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
	}

}
