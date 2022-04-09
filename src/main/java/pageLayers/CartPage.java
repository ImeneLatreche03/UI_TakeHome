package pageLayers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ElementUtil;

public class CartPage {
	
	WebDriver driver;
	ElementUtil util= new ElementUtil();
	
	public CartPage ( WebDriver driver) {
		this.driver=driver;
	}
	
	//By Locators
	private By cart= By.xpath("//span[contains(text(),'Added to Cart')]");
	private By product= By.xpath("(//img[contains(@alt,'Kindle Paperwhite (8 GB) ')])[2]");
	
	//Methods

	public boolean productPresent() {
		
		util.waitforElementToBePresent(driver,product);
		return driver.findElement(product).isDisplayed();
	}
	
	public boolean addedToCArt() {
		
		return driver.findElement(cart).isDisplayed();
	}
}
