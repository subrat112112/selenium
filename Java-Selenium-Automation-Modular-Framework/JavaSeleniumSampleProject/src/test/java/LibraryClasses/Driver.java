package LibraryClasses;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Driver {

	public static WebDriver driver=null;
	public static String browser= "chrome";
	
	public static void initializeDriver() throws IOException{
		System.out.println(" ......Initializing driver......");
		ConfigReader config = new ConfigReader();
		if(driver==null){
			if(Driver.browser.equalsIgnoreCase("chrome")){
				
				System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+config.getChromeDriver());
				driver = new ChromeDriver();
				
			}
			else if (Driver.browser.equalsIgnoreCase("firefox")){
				System.setProperty("webdriver.gecko.driver","user.dir"+config.getFireFoxDriver());
				driver=new FirefoxDriver();
			}
			else if (Driver.browser.equalsIgnoreCase("ie")){
				
				System.setProperty("webdriver.ie.driver","user.dir"+config.getInternetExplorerDriver());	
				driver = new InternetExplorerDriver();
			}
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		
	}
	
	
	public static void close(){
		System.out.println("....Closing Browser.....");
		driver.close();
		driver=null;
		
	}
	
	public static void quit(){
		System.out.println(".....Quitting Browser.....");
		driver.quit();
		driver=null;
		
	}
	public static WebDriver returnDriver(){
		return driver;
	}
}
