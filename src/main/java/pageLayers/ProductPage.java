package pageLayers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.ElementUtil;

public class ProductPage {

	WebDriver driver;
	ElementUtil util = new ElementUtil();

	public ProductPage(WebDriver driver) {
		this.driver = driver;
	}

	WebElement element;

	// By locators

	private By kindlePaperWhite = By.xpath("//span[contains(text(),'Kindle Paperwhite') and @class='a-color-base']");
	private By WithoutUnlimited = By.xpath("//button[@id='a-autoid-14-announce']");
	private By withoutAds = By.xpath("//button[@id='a-autoid-16-announce']");
	private By addToCart = By.xpath("//span[@id='submit.add-to-cart']");
	private By submit = By.xpath("//span[@id='a-autoid-3']");

	// Methods

	public void selectKindlePaperWhite() throws Exception {

		Thread.sleep(5000);
		WebElement kindlePaperWhite1 = driver.findElement(kindlePaperWhite);
		util.waitforElementToBePresent(driver, kindlePaperWhite);
		if (!(kindlePaperWhite1.isSelected())) {
			kindlePaperWhite1.click();
		}

	}

	public void selectWithoutKindleUnlimited() throws Throwable {
		util.waitforElementToBeClickable(driver, WithoutUnlimited);
		driver.findElement(WithoutUnlimited).click();
	}

	public void selectWithoutAds() {
		util.waitforElementToBeClickable(driver, withoutAds);
		driver.findElement(withoutAds).click();

	}

	public void addToCart() throws Exception {
		Thread.sleep(3000);
		driver.navigate().refresh();
		util.waitforElementToBeClickable(driver, addToCart);
		driver.findElement(addToCart).click();
		util.waitforElementToBeClickable(driver, submit);
		driver.findElement(submit).click();

	}
}
