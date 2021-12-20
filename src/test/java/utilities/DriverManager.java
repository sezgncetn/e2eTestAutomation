package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager{
	
	
private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	
	public static  void setDriver() {
		WebDriverManager.chromedriver().setup();
		driver.set(new ChromeDriver());
	}
	
	public static WebDriver getDriver()
	{
		driver.get().manage().window().maximize();
		return driver.get();
	}
	
	public static void closeBrowser()
	{
		driver.get().close();
		driver.remove();
	}

}
