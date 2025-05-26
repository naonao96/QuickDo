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

@WebServlet("/deleteTask")
public class DeleteTaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public DeleteTaskServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		UserInfoBeans userInfo = (UserInfoBeans)session.getAttribute("userInfo");
		
		String taskId = request.getParameter("taskId");
		if (taskId == null) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			response.sendRedirect("menu");
			return;
		}
		
		try 
		{
			TaskManagementDAO dao = new TaskManagementDAO();
			boolean deleteResult = dao.delTaskInfo(taskId);
			
			if (deleteResult) {
				System.out.println("タスクの削除に成功しました。タスクリストを再取得します。");
				request.setAttribute("taskInfo", dao.revTaskList(userInfo.getUserId()));
				response.setStatus(HttpServletResponse.SC_OK);
			}
			else 
			{
				response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
				response.sendRedirect("menu");
				return;
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			response.sendRedirect("menu");
			return;
		}
	}
}
