
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
	ProductPage product;
	ElementUtil util;
	String projectPath;
	HomePage homePage;
	SearchResultPage searchResult;
	
	@BeforeTest
	public void setupBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		
	}

	@Test
	public void searchTheProduct() {
		test=extent.createTest("searchTheProduct and confirm it is present");
		homePage = new HomePage(driver);
		SearchResultPage searchResult = new SearchResultPage(driver);
		
		// Search for Kindle
		homePage.sendKeys("Kindle");
		homePage.clickOnSearch();

		// Validate the results contains product name
		boolean flag = searchResult.verifyProductDisplayed();
		Assert.assertTrue(flag, "element not displayed");

	}

	@Test(dependsOnMethods = { "searchTheProduct" })
	public void goToProductPage() {
		test=extent.createTest("TC_ResponseCode_405");
		
		searchResult = new SearchResultPage(driver);
		product = new ProductPage(driver);
		
		searchResult.clickOnProduct();
		product.selectKindlePaperWhite();
		product.selectWithoutKindleUnlimited();
		product.selectWithoutAds();
		product.addToCart();

	}
	
	@Test (dependsOnMethods= {"goToProductPage"})	
	public void verifyTheCart() throws Exception {
		test=extent.createTest("verify if the product is added to cart");
		CartPage cart=new CartPage(driver);
		boolean flag= cart.productPresent();
		Assert.assertTrue(flag,"procuct is not present");
		boolean flag2= cart.addedToCArt();
		Assert.assertTrue(flag2,"cart is Empty");	
		
		util= new ElementUtil();
		util.takeScreenShot(driver);
		projectPath = System.getProperty("user.dir");
		test.addScreenCaptureFromPath(projectPath+"/test-output/ScreenShot/AddToCart.png");
		
	}
		
	@AfterTest 
	public void tearDownTest() {
		driver.close();
	}
	
}
