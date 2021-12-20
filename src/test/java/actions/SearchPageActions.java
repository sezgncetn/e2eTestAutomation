package actions;

import java.util.Random;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import locators.SearchPageLocators;
import utilities.SeleniumHelper;
import utilities.WaitHelper;

public class SearchPageActions {

	private WebDriver driver;
	private SeleniumHelper seleniumHelper;
	private SearchPageLocators searchPageLocators;
	private WaitHelper waitHelper;

	public SearchPageActions(WebDriver driver) {

		this.driver = driver;
		this.searchPageLocators = new SearchPageLocators();
		this.seleniumHelper = new SeleniumHelper(driver);
		this.waitHelper = new WaitHelper(driver);
		PageFactory.initElements(driver, searchPageLocators);
	}

	public void searchProduct(String text) {

		seleniumHelper.clickElement(searchPageLocators.inputSearch);
		seleniumHelper.sendKey(searchPageLocators.inputSearch, text);
		seleniumHelper.clickElement(searchPageLocators.btnFind);
	}

	public void clickProductPage(String number) {

		seleniumHelper.scrollDownToElement(searchPageLocators.pageNumbers(number));
		seleniumHelper.clickElement(searchPageLocators.pageNumbers(number));
	}

	public void controlProductPage(String page) {
		Assert.assertTrue(driver.getCurrentUrl().contains(page));

	}

	public void clickRandomProduct() throws Throwable {

		Random rn = new Random();
		waitHelper.waitForElementWithLocator(searchPageLocators.productList, 30);
		int index = rn.nextInt(seleniumHelper.getWebElementList(searchPageLocators.productList).size());
		System.out.println("size:: " + seleniumHelper.getWebElementList(searchPageLocators.productList).size());
		System.out.println("index: " + index);
		waitHelper.waitForElemenInVisibletWithLocator(searchPageLocators.loader, 30);
		waitHelper.waitForElementWithWebELement(
				seleniumHelper.getWebElementList(searchPageLocators.productList).get(index), 100);
		seleniumHelper.scrollDownToElement(seleniumHelper.getWebElementList(searchPageLocators.productList).get(index));
		seleniumHelper.getWebElementList(searchPageLocators.productList).get(index).click();
	}
}
