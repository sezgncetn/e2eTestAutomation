package utilities;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper {

	public WebDriver driver;

	public WaitHelper(WebDriver driver) {

		this.driver = driver;
	}

	public void waitForElementWithLocator(By locator, long timeOutInSeconds) {

		WebDriverWait wait = (WebDriverWait) new WebDriverWait(driver, timeOutInSeconds)
				.withTimeout(30, TimeUnit.SECONDS)

				.pollingEvery(5, TimeUnit.MILLISECONDS).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public void waitForElemenInVisibletWithLocator(By locator, long timeOutInSeconds) {

		WebDriverWait wait = (WebDriverWait) new WebDriverWait(driver, timeOutInSeconds)
				.withTimeout(30, TimeUnit.SECONDS)

				.pollingEvery(5, TimeUnit.MILLISECONDS).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}
	
	public void waitForElementWithWebELement(WebElement element, long timeOutInSeconds) {

		WebDriverWait wait = (WebDriverWait) new WebDriverWait(driver, timeOutInSeconds)
				.withTimeout(100, TimeUnit.SECONDS)
				.pollingEvery(10, TimeUnit.MILLISECONDS)
				.ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
}
