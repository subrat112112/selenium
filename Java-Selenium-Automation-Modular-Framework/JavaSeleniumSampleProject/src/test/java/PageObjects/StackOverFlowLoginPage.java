package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import LibraryClasses.Driver;
import TestCases.BaseTest;


public class StackOverFlowLoginPage  {

	WebDriver driver;
	
	public StackOverFlowLoginPage(WebDriver driver){
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
		
		
		@FindBy(xpath="//a[contains(text(),'Log in')]")
		public WebElement LoginLink;
		
		@FindBy(id="email")
		public WebElement emailTextBox;
		
		@FindBy(id="password")
		public WebElement passwordTextBox;
		
		@FindBy(id="submit-button")
		public WebElement LoginButton;
		
		@FindBy(className="gravatar-wrapper-24")
		public WebElement avatarName;
		
		@FindBy(name="q")
		public WebElement searchBox;

		public void clickLoginLink(){
			LoginLink.click();
		}
		
		public void enterEmail(String email){
			emailTextBox.sendKeys(email);
		}
		
		public void enterPassword(String password){
			passwordTextBox.sendKeys(password);
		}
		
		public void clickLoginButton(){
			LoginButton.click();
		}
		
		public String getAvatarName(){
			return avatarName.getAttribute("title");
		}
		
		
		public boolean isLoginPresent(){
			return LoginLink.isDisplayed();
		}
		
		public void enterSearchText(String value){
			searchBox.sendKeys(value);
		}
		
		
		
		
		
}
