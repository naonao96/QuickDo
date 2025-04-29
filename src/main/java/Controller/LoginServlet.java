package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.dao.TaskInfoDAO;
import Model.entity.UserInfoBeans;

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
		
		Boolean loginStatus = false; 
		String errorMessage = "ログインに失敗しました。メールアドレスかパスワードを間違えています。再度入力してください。";
		
		String mail = request.getParameter("mail");
		String password = request.getParameter("password");
		
		TaskInfoDAO dao = new TaskInfoDAO();
		UserInfoBeans userInfo = new UserInfoBeans();
		
		//ユーザ情報の取得
		try 
		{
			userInfo = dao.userSertificate(mail,password);
		}
		catch(Exception e) 
		{
			e.printStackTrace();
			System.out.println("データの取得に失敗しました");
		}

		//ログイン情報の確認
		if("TestMail".equals(mail) && "TestPassword".equals(password)) 
		{
			loginStatus = true;
		}
		
		if(loginStatus == true)
		{
			RequestDispatcher rd = request.getRequestDispatcher("menu.jsp");
			rd.forward(request, response);
		}
		else 
		{
			response.setCharacterEncoding("UTF-8");			request.setAttribute("error", errorMessage);
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
		
	}

}
