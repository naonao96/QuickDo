package Util;

import java.io.File;
import java.io.FileReader;
import java.net.URL;

public class FileControlUtil {
	
	public static String readFile(String filePath) 
	{
		URL resourceUrl = FileControlUtil.class.getClassLoader().getResource(filePath);
		if (resourceUrl == null) 
		{
			return null;
		}
		else 
		{
			filePath = resourceUrl.getPath();
		}
		
		File file = new File(filePath);
		if (!file.exists()) 
		{
			return null;
		}
		
		StringBuilder contentBuilder = new StringBuilder();
		try (FileReader fileReader = new FileReader(file)) 
		{
			int ch;
			while ((ch = fileReader.read()) != -1) {
				contentBuilder.append((char) ch);
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return contentBuilder.toString();
		
	}
}
