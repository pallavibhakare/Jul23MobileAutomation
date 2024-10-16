package tests;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import io.appium.java_client.android.AndroidDriver;
import listeners.TestListener;
import pages.SearchProductPage;
import utils.FileUtils;

@Listeners(TestListener.class)
public class SearchProductTest extends BaseTest{

	public SearchProductPage sp;
	public AndroidDriver driver;
	
	@BeforeMethod
	public void setup() throws Exception{
		try {
	        driver = (AndroidDriver) getDriver(FileUtils.readAppTestDataPropertiesFile("driverType"));	       
	    } catch (Exception e) {
	        logger.error("Failed to initialize driver: " + e.getMessage());
	        throw e; 
	    }
	}
	@AfterMethod
	public void closeApp() {
		if (driver instanceof AndroidDriver) {
	        AndroidDriver androidDriver = (AndroidDriver) driver;
	        androidDriver.quit();
		 }else {
			 System.out.println("Driver is not initialized.");
		 }
	}
	
	@Test(description = "Search a Product")
	public void searchProductTest_TC01() throws FileNotFoundException, IOException {
		sp = new SearchProductPage(driver);
		logger.info("SearchProductTest : searchProductTest_TC01");
		String searchItem = FileUtils.readAppTestDataPropertiesFile("searchItem");
		sp.searchAItem(driver, searchItem);		
		Assert.assertTrue(sp.isSearchedProductsView(driver, searchItem));
		test.log(Status.INFO, "Suggested Products are listed.");
	}
	
	
}
