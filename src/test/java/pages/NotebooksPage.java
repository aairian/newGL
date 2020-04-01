package pages;

import base.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class NotebooksPage extends BasePageObject<NotebooksPage>{

	private By notebooksPortal = By.cssSelector("div[class*='portal-notebooks']");
	private By resetFilterPriceLink = By.cssSelector("#reset_filterprice");
	private By ratingCont = By.xpath("//a[@data-count]");

	private By getWishListLinkOf(int itemId) {
		return By.xpath("//div[@id='wishlist-popup-"+ String.valueOf(itemId)+"']//a");
	};


	public NotebooksPage(WebDriver driver){
		super(driver);
		waitForPageToLoad();
	}

	public void waitForPageToLoad(){
		waitForVisibilityOf(notebooksPortal);
	}

	public void clickFilterPriceBy(int amount){
		click(By.xpath("//a[contains(@href, 'price="+ String.valueOf(amount) +"')]"));
		waitForVisibilityOf(resetFilterPriceLink);
	}

	public void addMaxRateGoodToWishList(int itemId){
		find(getWishListLinkOf(itemId)).click();
	}

	public int getIdOfMaxRateGood(){
		return Integer.valueOf(
				findElements(ratingCont).stream()
						.max((e1, e2) -> Integer.compare(Integer.parseInt(e1.getAttribute("data-count")), Integer.parseInt(e2.getAttribute("data-count"))))
						.get()
						.findElement(By.xpath("./../../div")).getAttribute("id").replaceAll("\\D+", ""));
	}

}
