package pageLayers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultPage {
	
	WebDriver driver;
	public SearchResultPage(WebDriver driver ) {
		this.driver=driver;
	}

	//By locators
	
	private By product = By.xpath("(//span[contains(text(),'Kindle Paperwhite (8 GB)')])[1]");
	
	//Methods
	
	public boolean verifyProductDisplayed() {
		return driver.findElement(product).isDisplayed();
	}
	
	public void clickOnProduct() {
		driver.findElement(product).click();
	}
}
