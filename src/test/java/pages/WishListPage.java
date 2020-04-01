package pages;

import base.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.stream.Collectors;


public class WishListPage extends BasePageObject<WishListPage>{

	public static final String wishListURL = "https://my.rozetka.com.ua/profile/wishlists/";

	private By goodsList = By.cssSelector("label[class*='wishlist'] input");
	private By listTitleRename = By.name("wishlist-block-title-rename");

	public WishListPage(WebDriver driver){
		super(driver);
	}

	public void openPage(){
		getPage(wishListURL);
		waitForPageToLoad();
	}

	public void waitForPageToLoad(){
		waitForVisibilityOf(listTitleRename);
	}

	public List<String> getGoodsList(){
		return findElements(goodsList).stream()
				.map(element -> element.getAttribute("goods_id"))
				.map(Object::toString)
				.collect(Collectors.toList());
	}
	
}
