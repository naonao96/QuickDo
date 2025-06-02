package util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class UtilityTools {
	
	/**
	 * エラーメッセージ一覧
	 */
	public static final String LOGIN_ERROR = "ログインに失敗しました。メールアドレスかパスワードを間違えています。再度入力してください。";
	public static final String DATA_FETCH_ERROR = "データの取得に失敗しました";
	public static final String SESSION_ERROR = "セッションが切れました。再度ログインしてください。";
	public static final String SIGNUP_ERROR = "アカウントの作成に失敗しました。";
	public static final String SERVER_ERROR = "サーバーエラーが発生しました。";
	public static final String CREATED_ACCOUNT = "アカウントは既に登録されています。";
	
	/**
	 * 正常なメッセージ一覧
	 */
	public static final String FINISHED_ACCOUNT = "アカウントの作成が完了しました。";
	
	/**
	 * 指定されたファイルパスの内容を読み込み、文字列として返します。
	 * @param filePath 読み込むファイルのパス（クラスパスからの相対パス）
	 * @return ファイルの内容を文字列として返します。ファイルが存在しない場合はnullを返します。
	 */
	public static String readFile(String filePath) 
	{
		StringBuilder contentBuilder = new StringBuilder();

		try (InputStream inputStream = UtilityTools.class.getResourceAsStream(filePath)) 
		{
           BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
           
           String line;
           while (strHasValue(line = reader.readLine()))
           {
               contentBuilder.append(line).append(System.lineSeparator());
           }
           
           if (contentBuilder.length() == 0) 
           {
        	   return null;
           }
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}

		return contentBuilder.toString();
		
	}
	
	/**
	 * 文字列がnullまたは空でないかをチェックします。
	 * @param str チェックする文字列
	 * @return nullまたは空でない場合はtrue、そうでない場合はfalseを返します。
	 */
	public static boolean strHasValue(String str)
	{
		if (str == null || str.isEmpty()) {
			return false;
		}
		return true;
	}
	
	public static boolean loginCheck(String userName, String password)
	{
		if (strHasValue(userName) && strHasValue(password)) {
			return true;
		}
		return false;
	}
}
