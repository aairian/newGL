package pages;

import base.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePage extends BasePageObject<HomePage>{

	private By userTitle = By.cssSelector("#header_user_menu_parent");
	private By secondMenu = By.name("second_menu");

	public HomePage(WebDriver driver){
		super(driver);
		waitForPageToLoad();
	}

	public void waitForPageToLoad(){
		waitForVisibilityOf(userTitle);
	}

	public String getUserTitle(){
		return getText(userTitle);
	}

	public void mouseMoveToFatMenuItem(int id){
		mouseMoveTo(By.xpath("//li[@menu_id="+ id +"]"));
		waitForVisibilityOf(secondMenu);
	}

	public void moveAndClickSecondMenuCategory(String text){
		mouseMoveAndClickTo(By.xpath("//a[contains(@href, "+ text +") and (contains(@class, 'f-menu-sub'))]"));
	}
}
