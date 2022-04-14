
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import baseTest.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageLayers.*;

import utils.ElementUtil;

@Listeners(listeners.TestNgListeners.class)

public class SearchProduct extends BaseTest {
	
	WebDriver driver;
	ElementUtil util;
	HomePage homePage;
	SearchResultPage searchResult;
	ProductPage product;
	CartPage cart;
	String projectPath;

	@BeforeTest
	public void setupBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();

	}

	@Test
	public void searchTheProduct() {
		test = extent.createTest("searchTheProduct and confirm it is present");
		homePage = new HomePage(driver);
		searchResult = new SearchResultPage(driver);

		// Search for Kindle
		homePage.sendKeys("Kindle");
		homePage.clickOnSearch();

		// Validate the results contains product name
		boolean flag = searchResult.verifyProductDisplayed();
		Assert.assertTrue(flag, "element not displayed");

	}

	@Test(dependsOnMethods = { "searchTheProduct" })
	public void goToProductPage() throws Throwable {
		test = extent.createTest("Go to product Page and add it to cart");

		searchResult = new SearchResultPage(driver);
		product = new ProductPage(driver);

		searchResult.clickOnProduct();
		product.selectKindlePaperWhite();
		product.selectWithoutKindleUnlimited();
		product.selectWithoutAds();

		product.addToCart();

	}

	@Test(dependsOnMethods = { "goToProductPage" })
	public void verifyTheCart() throws Exception {
		test = extent.createTest("verify if the product is added to cart");
		cart = new CartPage(driver);
		boolean flag = cart.productPresent();
		Assert.assertTrue(flag, "procuct is not present");
		boolean flag2 = cart.addedToCArt();
		Assert.assertTrue(flag2, "cart is Empty");

		util = new ElementUtil();
		util.takeScreenShot(driver);
		projectPath = System.getProperty("user.dir");
		test.addScreenCaptureFromPath(projectPath + "/test-output/ScreenShot/AddToCart.png");

	}

	@AfterTest
	public void tearDownTest() {
		driver.close();
	}

}
