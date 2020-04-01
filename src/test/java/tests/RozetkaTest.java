package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.HomePage;
import pages.NotebooksPage;
import pages.WishListPage;

import java.util.Arrays;


public class RozetkaTest extends BaseTest {


	@Test
	public void glRozetkaTest(){
		LoginPage loginPage = new LoginPage(driver);
		loginPage.openPage();
		loginPage.openSignInForm();
		loginPage.fillUpMailAndPass("place_for_your_email_:)", "*******");
		loginPage.clickSubmitBtn();

		HomePage homePage = new HomePage(driver);
		Assert.assertEquals(homePage.getUserTitle(), "Анна", "Incorrect userName");
		homePage.mouseMoveToFatMenuItem(2416);
		homePage.moveAndClickSecondMenuCategory("notebooks");

		NotebooksPage notebooksPage = new NotebooksPage(driver);
		notebooksPage.clickFilterPriceBy(1000);
		int itemId = notebooksPage.getIdOfMaxRateGood();
		notebooksPage.addMaxRateGoodToWishList(itemId);

		WishListPage wishListPage = new WishListPage(driver);
		wishListPage.openPage();
		Assert.assertEquals(wishListPage.getGoodsList(), Arrays.asList(String.valueOf(itemId)), "Incorrect wish-list goods");

	}
	
}
