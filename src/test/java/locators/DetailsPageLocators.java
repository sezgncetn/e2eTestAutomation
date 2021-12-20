package locators;

import org.openqa.selenium.By;

public class DetailsPageLocators {
	public By productTitle = By.id("sp-title");
	public By productPrice = By.id("sp-price-lowPrice");
	public By productBuy = By.id("buy-now");
	public By afterLogin = By.id("continueWithoutUser");
	public By basketPrice = By.cssSelector("div[class*='detail-price']");
	public By editBasket = By.cssSelector("a[title*='Sepeti Düzenle']");

}
