package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.AccountPage;
import pageobjects.LandingPage;
import pageobjects.LoginPage;
import resources.Base;

import org.apache.log4j.BasicConfigurator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class LoginTest extends Base {
	Logger log; 
	public WebDriver driver;
	
	@BeforeMethod

	 public void openapplication() throws IOException {		
		System.setProperty("org.freemarker.loggerLibrary", "none");
		log=LogManager.getLogger(LoginTest.class.getName());
		BasicConfigurator.configure();													
		driver=Intializedriver();
		log.debug("Browser got Launched");
		driver.get(prop.getProperty("URL"));
		log.debug("Navigated to application URL");
	}
	
	@Test(dataProvider="getloginData")
	public void login(String email,String password,String expectedresult) throws IOException, InterruptedException  {
		
//	driver=Intializedriver();
//	driver.get(prop.getProperty("URL"));	
	//log=LogManager.getLogger(LoginTest.class.getName());
						
	LandingPage landingpage=new LandingPage(driver);
		landingpage.myaccountdropdown().click();
		log.debug("Clicked Myaccount Dropdown");
	landingpage.logindropdown().click();
	log.debug("Clicked on login option");
	Thread.sleep(5000);
	
	LoginPage loginpage=new LoginPage(driver);
	loginpage.emailaddressfield().sendKeys(email);
	log.debug("Email address got entered");
	loginpage.passwordfield().sendKeys(password);
	log.debug("Password got entered");
	loginpage.logintButton().click();
	log.debug("Cliked on Login button");
	 
	AccountPage accounpage=new AccountPage(driver);
	
	String actualresult=null;
	try {
		
if(accounpage.editAccountInformationoption().isDisplayed()) {
	log.debug("User get logged in");
actualresult="Successful";

}
	}catch(Exception e) {
		log.debug("User didn't Login");
		actualresult="Failure";
	}
	if(actualresult.equals(expectedresult)) {
	log.info("Login Test got passed");
	
	}else {
		
	}
	log.error("Login test got failed");
	}

 @AfterMethod
 
 public void closure() throws Exception{
	 driver.close();
	 log.debug("Browser got closed");									
 }
 
 @DataProvider
 
 public Object[][] getloginData() {
	 Object[][] data = {{"arun.selenium@gmail.com","Second@123","Successful"},{"dummy@gmail.com","dummy@123","Failure"}};
	 return data;
	 																																								
 } 
 																																							
 
}