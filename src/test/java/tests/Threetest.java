package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import resources.Base;

public class Threetest extends Base {
	
public	WebDriver driver;
		
		@Test
		public void testthree() throws IOException, InterruptedException {
			System.out.println("testthree");
																
			 driver=Intializedriver();
				
				driver.get("http://tutorialsninja.com/demo/");
				Thread.sleep(6000);
				Assert.assertTrue(false);
			
				
			}
		@AfterMethod
			public void closebrowser() {
				driver.close();
			}

}
