package base;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class BasePageObject<T> {

	protected WebDriver driver;

	protected WebDriverWait webDriverWait;

	protected BasePageObject(WebDriver driver){
		this.driver = driver;
		webDriverWait = new WebDriverWait(driver, 60);

	}

	protected T getPage(String url) {
		driver.get(url);
		return (T) this;
	}

	protected WebElement find(By element) {
		return driver.findElement(element);
	}

	protected List<WebElement> findElements(By element) {
		return driver.findElements(element);
	}

	protected void type(String text, By element) {
		find(element).sendKeys(text);
	}

	protected void click(By element) {
		find(element).click();
	}

	protected void waitForVisibilityOf(By element, Integer ... timeout) {
		int attempts = 0;
		while (attempts < 2) {
			try{
				waitFor(ExpectedConditions.visibilityOfElementLocated(element), (timeout.length > 0 ? timeout[0] : null));
			} catch (StaleElementReferenceException e){

			} attempts++;
		}

	}

	private void waitFor(ExpectedCondition<WebElement> condition, Integer timeout){
		timeout = timeout !=  null ? timeout : 30;
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(condition);
	}

	public String getText(By element){
		return find(element).getText();
	}

	public void mouseMoveTo(By element){
		new Actions(driver).moveToElement(find(element)).perform();
	}

	public void mouseMoveAndClickTo(By element){
		Actions action = new Actions(driver);
		action.moveToElement(find(element)).click().build().perform();
	}


}
