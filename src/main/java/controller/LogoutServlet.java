package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public LogoutServlet() {
    	super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		// セッションを削除
		HttpSession session = request.getSession(false);
		if (session != null) {
		    session.invalidate();
		}
		
		// キャッシュを削除
		// Cache-Control:ブラウザキャッシュを無効化
		// Pragma:古いブラウザ向けのキャッシュ無効化
		// Expires:キャッシュの有効期限
		// ブラウザの「戻るボタン」などで過去のページが表示されないようにする
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Expires", 0);
		
		response.sendRedirect("login.jsp");
	}

}
