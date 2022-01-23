package LibraryClasses;



import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;



public class Screenshot {

	WebDriver driver;
	
	public void ScreenshotCapture(WebDriver driver,String ScreenshotName) throws IOException{
		
	this.driver=driver;
	TakesScreenshot ts = ((TakesScreenshot)driver);
	File src = ts.getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(src,new File(System.getProperty("user.dir")+"\\Utilities\\ScreenShots\\"+ScreenshotName+".png"));	
	
}
	
	
}
