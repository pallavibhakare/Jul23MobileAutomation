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
import pages.CheckoutProductPage;
import pages.OrderHistoryPage;
import utils.FileUtils;

@Listeners(TestListener.class)
public class CheckoutProductTest extends BaseTest{
	public CheckoutProductPage cpp;
	public OrderHistoryPage ohp;
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
			 logger.error("Driver is not initialized.");
		 }
	}
	
	@Test(description = "Checkout Product")
	public void checkoutProductTest_TC03() throws FileNotFoundException, IOException {
		cpp = new CheckoutProductPage(driver);
		cpp.checkoutProduct(driver);
		Assert.assertTrue(cpp.isCategoryView(driver));
		test.log(Status.INFO, "Chekout is done. Back to 'Category'.");
	}
	
//	@Test(description = "Order History of Product", dependsOnMethods = "checkoutProductTest_TC03")
//	public void orderHistoryTest_TC04() {
//		ohp = new OrderHistoryPage(driver);
//		ohp.orderHistory();
//	}
}
