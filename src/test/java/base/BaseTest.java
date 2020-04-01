package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class BaseTest {
	protected WebDriver driver;

	@BeforeMethod
	protected void setDriver(){
		System.setProperty("webdriver.gecko.driver", "/home/user/Документы/GL/geckodriver");
		driver = new FirefoxDriver();
	}

	@AfterMethod
	protected void tearDown(){
		driver.quit();
	}
}
