package pages;

import base.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by user on 19.09.17.
 */
public class LoginPage extends BasePageObject<LoginPage>{

	public static final String loginURL = "https://rozetka.com.ua/";

	private By signIn = By.name("signin");
	private By emailField = By.name("login");
	private By passField = By.name("password");
	private By submitBtn = By.name("auth_submit");

	public LoginPage(WebDriver driver){
		super(driver);
	}

	public void openPage(){
		getPage(loginURL);
	}

	public void fillUpMailAndPass(String email, String pass){
		type(email, emailField);
		type(pass, passField);
	}

	public void clickSubmitBtn(){
		click(submitBtn);
		webDriverWait.until(ExpectedConditions.invisibilityOf(find(signIn)));
	}

	public void openSignInForm(){
		click(signIn);
	}

	
}
