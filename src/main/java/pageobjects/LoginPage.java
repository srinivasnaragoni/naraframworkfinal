package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath = "//input[@name='email']")	
			private WebElement emailaddressfield;
	public WebElement emailaddressfield() {
			return emailaddressfield;
	}
		@FindBy(xpath = "//input[contains(@id,'input-password')]")
			private	WebElement passwordfield;
				
		public WebElement passwordfield() {
					return passwordfield;
}
		@FindBy(xpath = "//input[@type='submit']")	
			private	WebElement logintButton;
		public WebElement logintButton() {
					return logintButton;		 
}
}