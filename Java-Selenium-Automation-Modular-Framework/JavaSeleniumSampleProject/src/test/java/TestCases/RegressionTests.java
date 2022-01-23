package TestCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import LibraryClasses.Base64Encode;
import LibraryClasses.ConfigReader;
import LibraryClasses.Driver;
import PageObjects.StackOverFlowLoginPage;


public class RegressionTests extends BaseTest{
	Base64Encode baseEncode = new Base64Encode();
	
	@Test
	public void foo() throws IOException, InterruptedException{
		StackOverFlowLoginPage sloginPage = new StackOverFlowLoginPage(Driver.driver);
		ConfigReader config = new ConfigReader();
		boolean p=sloginPage.isLoginPresent();
		Assert.assertTrue(p);
		sloginPage.clickLoginLink();
		log.info("Clicked on Login Link");
		sloginPage.enterEmail("*******");
		sloginPage.enterPassword("*******");
		sloginPage.clickLoginButton();
		String s = sloginPage.getAvatarName();
		Assert.assertEquals(s, "NameAvatar");
		sloginPage.enterSearchText(baseEncode.encode(config.getEncodedStringToSearch()));
		
	}
	
	
}
