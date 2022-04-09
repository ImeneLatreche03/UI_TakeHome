package pageLayers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	
	WebDriver driver;
	public HomePage(WebDriver driver ) {
		this.driver=driver;
	}
	//By locators
	private By searchBox= By.id("twotabsearchtextbox");
	private By searchButton=By.id("nav-search-submit-button");

	//Methods 
	public void sendKeys(String str) {
		driver.findElement(searchBox).sendKeys(str);
	}
	public void clickOnSearch() {
		driver.findElement(searchButton).click();
	}
}
