package testRunner;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import actions.BasketActions;
import actions.DetailPageActions;
import actions.SearchPageActions;
import utilities.DriverManager;
import utilities.SeleniumHelper;


public class TestClass {

	SearchPageActions searchActions;
	SeleniumHelper seleniumHelper;
	DetailPageActions detailPage;
	BasketActions basketActions;
	
	
	@Before
	public void initilaze() {
		
		
		DriverManager.setDriver();
		this.seleniumHelper = new SeleniumHelper(DriverManager.getDriver());
		this.searchActions = new SearchPageActions(DriverManager.getDriver());
		this.detailPage = new DetailPageActions(DriverManager.getDriver());
		this.basketActions = new BasketActions(DriverManager.getDriver());
		
	}
	
	@Test
	public void senario1() throws Throwable {
		
		seleniumHelper.nagivateUrl("http://www.gittigidiyor.com");
		searchActions.searchProduct("Bilgisayar");
		searchActions.clickProductPage("2");
		searchActions.controlProductPage("sf=2");
		searchActions.clickRandomProduct();
		detailPage.write›nfoTxt();
		detailPage.clickDetailPageBuyNow();
		detailPage.clickAfterLogin();
		detailPage.clickEditBasket();
		basketActions.selectItemCount("2");
		basketActions.deleteItem();
		Thread.sleep(3000);
		basketActions.deleteItemControl();
		
	}
	
	@After
	public void close() {
		
		DriverManager.closeBrowser();
	}
}
