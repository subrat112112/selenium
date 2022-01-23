package TestCases;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


import LibraryClasses.ConfigReader;
import LibraryClasses.Driver;
import LibraryClasses.Screenshot;



public class BaseTest {
	ExtentReports report;
	ExtentTest test;

	Logger log = Logger.getLogger(this.getClass());
	

	@BeforeMethod
		public void setUp(ITestResult result) throws IOException {
		PropertyConfigurator.configure(System.getProperty("user.dir")+"\\Utilities\\log4j.properties");
			log.info("Logger started");
		ConfigReader config = new ConfigReader();
		Driver.initializeDriver();
		Driver.driver.get(config.getURL());
		
		report = new ExtentReports(System.getProperty("user.dir")+"\\test-output"+result.getName()+System.currentTimeMillis()+".html");
		test= report.startTest(result.getName());
	}

	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException{
		Screenshot screenshot = new Screenshot();
		
		
		if(result.getStatus()==ITestResult.FAILURE){
			screenshot.ScreenshotCapture(Driver.driver, result.getName());
			test.log(LogStatus.FAIL, result.getThrowable());
			
		}
		else if(result.getStatus()==ITestResult.SUCCESS){
			test.log(LogStatus.PASS, "The test case passed");
		}
		
		else if (result.getStatus()==ITestResult.SKIP){
			test.log(LogStatus.SKIP, "Test case skipped");
		}
		Driver.close();
		report.endTest(test);
		report.flush();
		
	}
	
}
