package utilities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SeleniumHelper {

	WebDriver driver;
	WaitHelper waitHelper;

	public SeleniumHelper(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		this.waitHelper = new WaitHelper(driver);
	}

	public void nagivateUrl(String url) {

		driver.get(url);
	}

	public WebElement getWebElement(By locator) {

		waitHelper.waitForElementWithLocator(locator, 30);
		return driver.findElement(locator);
	}

	public List<WebElement> getWebElementList(By locator) {

		return driver.findElements(locator);
	}

	public void sendKey(By locator, String text) {

		getWebElement(locator).sendKeys(text);
	}

	public void clickElement(By locator) {

		getWebElement(locator).click();
	}
	
	public void clickElementForceClick(WebElement element) {
		
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
	}

	public void scrollDownToElement(By locator) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", getWebElement(locator));
	}

	public void scrollDownToElement(WebElement element) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}
	
	public String getWebElementText(By locator) {
		
		scrollDownToElement(getWebElement(locator));
		return getWebElement(locator).getText();
	}
}
