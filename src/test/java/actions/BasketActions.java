package actions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import locators.BasketLocators;
import utilities.SeleniumHelper;
import utilities.WaitHelper;

public class BasketActions {

	
	private WebDriver driver;
	private SeleniumHelper seleniumHelper;
	private BasketLocators locators;
	private WaitHelper waitHelper;
	
	
	public BasketActions(WebDriver driver) {

		this.driver = driver;
		this.seleniumHelper = new SeleniumHelper(driver);
		this.locators = new BasketLocators();
		this.waitHelper = new WaitHelper(driver);
		PageFactory.initElements(driver, locators);
	}

	public void selectItemCount(String index) throws Throwable {
		
		Select counts = new Select(seleniumHelper.getWebElement(locators.selectionProductCount));
		counts.selectByVisibleText(index);
		waitHelper.waitForElemenInVisibletWithLocator(locators.selectLoader, 30);
		controlItemCount(index);
	}
	
	public void controlItemCount(String text) {
		
		System.out.println(seleniumHelper.getWebElementText(locators.itemCount));
		System.out.println(text+" Adet");
		Assert.assertTrue(seleniumHelper.getWebElementText(locators.itemCount).contains(text+" Adet"));
		
	}
	
	public void deleteItem() {
		seleniumHelper.clickElement(locators.deleteItem);
	}
	
	public void deleteItemControl() {
		System.out.println(seleniumHelper.getWebElementText(locators.deleteItemText));
		Assert.assertEquals(seleniumHelper.getWebElementText(locators.deleteItemText), "Sepetinizde ürün bulunmamaktadýr.");
	}

}
