package utils;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ElementUtil {
	

	public void takeScreenShot(WebDriver driver) throws Exception {
		
		String projectPath = System.getProperty("user.dir");
		File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	    FileUtils.copyFile(f, new File(projectPath+"/test-output/ScreenShot/AddToCart.png"));
		
	}
	
	public void waitforElementToBeClickable(WebDriver driver,By element) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void waitforElementToBePresent(WebDriver driver,By element) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
	}
	public void scrollToElement(WebDriver driver, WebElement element)  {
	    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",element);
	}
	
	public void clickWithJavaScript(WebDriver driver, WebElement element) {
		 ((JavascriptExecutor)driver).executeScript("arguments[0].click();",element);
	}
	

}

	
	

}
