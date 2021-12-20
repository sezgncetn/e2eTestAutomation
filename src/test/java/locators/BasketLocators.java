package locators;

import org.openqa.selenium.By;

public class BasketLocators {
	
	public By selectionProductCount = By.cssSelector("select[class='amount']");
	public By selectionOptions = By.cssSelector("select[class='amount'] option");
	public By itemCount = By.cssSelector("li[class*='total-price'] div[class*='detail-text']");
	public By selectLoader = By.xpath("//div[contains(@class,'input-select')]/following-sibling::span");
	public By deleteItem = By.cssSelector("i[class=\"gg-icon gg-icon-bin-medium\"]");
	public By deleteItemText = By.cssSelector("div[class*='empty-cart-info'] h2");
	

}
