package actions;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import locators.DetailsPageLocators;
import utilities.SeleniumHelper;

public class DetailPageActions {

	private SeleniumHelper seleniumHelper;
	private WebDriver browser;
	private DetailsPageLocators locators;
	private String productPrice;
	
	public DetailPageActions(WebDriver driver) {
		
		this.browser = driver;
		this.seleniumHelper = new SeleniumHelper(driver);
		this.locators = new DetailsPageLocators();
		PageFactory.initElements(driver, locators);
		
	}
	
	public void write›nfoTxt() throws Throwable {
		
		 String testFile = System.getProperty("user.dir") +"\\src\\test\\gittigidiyor.txt";
		 System.out.println(testFile);
		  File FC = new File(testFile);
		  FC.createNewFile();
		  FileWriter FW = new FileWriter(testFile);
		  BufferedWriter BW = new BufferedWriter(FW);
		  BW.write(seleniumHelper.getWebElementText(locators.productTitle)); 
		  BW.newLine();
		  BW.write(seleniumHelper.getWebElementText(locators.productPrice)); 
		  productPrice = seleniumHelper.getWebElementText(locators.productPrice);
		  BW.close();
	}
	
	public void clickDetailPageBuyNow() {

		seleniumHelper.scrollDownToElement(locators.productBuy);
		seleniumHelper.clickElement(locators.productBuy);
	}
	
	public void clickAfterLogin() {
		
		seleniumHelper.scrollDownToElement(locators.afterLogin);
		seleniumHelper.clickElement(locators.afterLogin);
		Assert.assertEquals("prices are not equal",seleniumHelper.getWebElementText(locators.basketPrice), productPrice);
		
	}
	
	public void clickEditBasket() {

		seleniumHelper.scrollDownToElement(locators.editBasket);
		seleniumHelper.clickElement(locators.editBasket);
	}


}
