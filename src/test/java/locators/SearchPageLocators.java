package locators;

import org.openqa.selenium.By;

public class SearchPageLocators {

	public By inputSearch = By.cssSelector("input[data-cy='header-search-input']");
	public By btnFind = By.cssSelector("button[data-cy='search-find-button']");
	public By pageNumbers(String number) { 
	
		return By.cssSelector("a[aria-label*='"+number+"']");
	}
	public By productList = By.xpath("//li/article//a");
	public By loader = By.cssSelector("div[class*='overlaySpinnerLoading']");
}
