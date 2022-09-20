package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	WebDriver driver;
	public LandingPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
@FindBy(xpath = "//span[contains(.,'My Account')]")
private WebElement myaccountdropdown;

public WebElement myaccountdropdown() {
	return myaccountdropdown;
	
}
@FindBy(xpath = "//a[contains(.,'Login')]")
private WebElement logindropdown;

 	public WebElement logindropdown() {
	 return logindropdown;
 }
}
