package LibraryClasses;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

		Properties pro;
	
		public ConfigReader() throws IOException
		{
		File file = new File(System.getProperty("user.dir")+"\\Utilities\\config.properties");
		FileInputStream fileInput;
		fileInput= new FileInputStream(file);
		pro=new Properties();
		pro.load(fileInput);
		
	}

	public String getURL(){
		
	return pro.getProperty("url");	
		
	}
	
	public String getChromeDriver(){
		
		return pro.getProperty("chrome");	
			
		}

	public String getFireFoxDriver(){
		return pro.getProperty("firefox");	
			
		}

	public String getInternetExplorerDriver(){
		return pro.getProperty("ie");	
			
		}
	public String getEncodedStringToSearch(){
		
		return pro.getProperty("searchText");
	}
	 
}
