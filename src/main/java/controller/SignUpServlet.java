package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.dao.TaskManagementDAO;

@WebServlet("/sign-up")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public SignUpServlet() {
    	super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/signup.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		TaskManagementDAO dao = new TaskManagementDAO();
		
		try {
			Boolean insRes = dao.insUserInfo(
					request.getParameter("name"), 
					request.getParameter("mail"),
					request.getParameter("password")
					);
			
			if (insRes) {
				response.sendRedirect("login");
				response.setStatus(HttpServletResponse.SC_OK);
				return;
			}
			else {
				response.sendRedirect("login");
				response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
				return;
			}
			
		}catch (Exception e) {
			response.sendRedirect("login");
			return;
		}
	}
}
