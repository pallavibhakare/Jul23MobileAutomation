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
public class AddProductToCartTest  extends BaseTest{
	
	public SearchProductPage sp;
	public AndroidDriver driver;
	
	@BeforeMethod
	public void setup() throws FileNotFoundException, IOException {
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
	
	@Test(description = "Add a Product to the Cart")
	public void addProductToCart_TC02() throws FileNotFoundException, IOException, InterruptedException {
		sp = new SearchProductPage(driver);
		logger.info("SearchProductTest : addProductToCart_TC02");			
		String addedProduct = sp.addProductToCart(driver);	
		Assert.assertTrue(sp.isProductAddedToTheCart(driver, addedProduct));
		test.log(Status.INFO, "Product '"+addedProduct+"' is added to the cart.");
	}
}
