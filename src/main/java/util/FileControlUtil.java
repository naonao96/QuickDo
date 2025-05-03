package util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FileControlUtil {
	
	/**
	 * 指定されたファイルパスの内容を読み込み、文字列として返します。
	 * @param filePath 読み込むファイルのパス（クラスパスからの相対パス）
	 * @return ファイルの内容を文字列として返します。ファイルが存在しない場合はnullを返します。
	 */
	public static String readFile(String filePath) 
	{
		StringBuilder contentBuilder = new StringBuilder();

		try (InputStream inputStream = FileControlUtil.class.getResourceAsStream(filePath)) 
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
}
