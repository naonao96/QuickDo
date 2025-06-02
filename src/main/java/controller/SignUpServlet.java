package controller;

import java.io.BufferedReader;
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import model.dao.TaskManagementDAO;
import model.entity.UserInfoBeans;
import util.UtilityTools;

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
		
		try {
			TaskManagementDAO dao = new TaskManagementDAO();
			BufferedReader reqReader = request.getReader();
			String line;
			
			// TODO: レスポンスでアカウント登録の失敗やアカウント登録済みのエラーメッセージを返すようにする
			// リクエスト自体がnullの場合はログイン画面にリダイレクト
			if (reqReader == null) {
				setResponse(response, HttpServletResponse.SC_BAD_REQUEST, UtilityTools.SERVER_ERROR);
				return;
			}
			
			// リクエストボディからJSONを読み込む
			StringBuilder jsonBuilder = new StringBuilder();
			while ((line = reqReader.readLine()) != null) {
				jsonBuilder.append(line);
			}
	        JSONObject json = new JSONObject(jsonBuilder.toString());
	        
	        // アカウントが既に登録されているか確認/登録済みならエラーメッセージを返す
	        UserInfoBeans userInfo = dao.revUserSertificate(json.getString("mail"), json.getString("password"));
	        if (userInfo != null) {
				setResponse(response, HttpServletResponse.SC_CONFLICT, UtilityTools.CREATED_ACCOUNT);
	        	return;
	        }
	        
	        // アカウントの登録を行う
			Boolean insRes = dao.insUserInfo(
					json.getString("name"), 
					json.getString("mail"),
					json.getString("password")
					);
			
			if (insRes) {
				setResponse(response, HttpServletResponse.SC_OK, UtilityTools.FINISHED_ACCOUNT);
			}
			else {
				setResponse(response, HttpServletResponse.SC_BAD_REQUEST, UtilityTools.SERVER_ERROR);
			}
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
			setResponse(response, HttpServletResponse.SC_BAD_REQUEST, UtilityTools.SERVER_ERROR);
			return;
		}
	}
	
	// レスポンスの設定を行うメソッド（引数にレスポンスメッセージを渡す）
	private static void setResponse(HttpServletResponse response,int status,String message) 
			throws IOException {
		response.setContentType("application/json; charset=UTF-8");
		response.setStatus(status);
		
		JSONObject jsonResponse = new JSONObject();
		jsonResponse.put("message", message);
		response.getWriter().write(jsonResponse.toString());
		response.getWriter().flush();
	}
}
