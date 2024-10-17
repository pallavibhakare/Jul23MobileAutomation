package pages;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import utils.CommonUtils;
import utils.WaitUtils;

public class CheckoutProductPage  extends BasePage{
	public CheckoutProductPage(WebDriver driver) {
		super((AndroidDriver) driver);
	}
	
	@iOSXCUITFindBy(accessibility = "new UiSelector().text(\"Gold Titanium Diamond Women's Bracelet\")")
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Gold Titanium Diamond Women's Bracelet\")")
	public WebElement fashionItem;
	
	
	@iOSXCUITFindBy(accessibility = "new UiSelector().text(\"Category\").instance(0)")
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Category\").instance(0)")
	public WebElement categoryView;
	
	
	@iOSXCUITFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.solodroid.solomerce:id/category_name\" and @text=\"Fashions\"]")
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.solodroid.solomerce:id/category_name\" and @text=\"Fashions\"]")
	public WebElement fashionsCategory;
	
	@iOSXCUITFindBy(id = "com.solodroid.solomerce:id/btn_checkout")
	@AndroidFindBy( id = "com.solodroid.solomerce:id/btn_checkout")
	public WebElement checkoutBtn;
	
	@iOSXCUITFindBy(id = "com.solodroid.solomerce:id/btn_submit_order")
	@AndroidFindBy( id = "com.solodroid.solomerce:id/btn_submit_order")
	public WebElement processCheckoutBtn;
	
	@iOSXCUITFindBy(id = "android:id/buttonPanel")
	@AndroidFindBy( id = "android:id/buttonPanel")
	public WebElement buttonPanel;
	
	@iOSXCUITFindBy(id = "android:id/button1")
	@AndroidFindBy( id = "android:id/button1")
	public WebElement yesBtn;
	
	@iOSXCUITFindBy(id = "android:id/button2")
	@AndroidFindBy( id = "android:id/button2")
	public WebElement noBtn;
	
	@iOSXCUITFindBy(id = "android:id/message")
	@AndroidFindBy( id = "android:id/message")
	public WebElement alterCongratsMessage;
	
	@iOSXCUITFindBy(id = "com.solodroid.solomerce:id/edt_address")
	@AndroidFindBy( id = "com.solodroid.solomerce:id/edt_address")
	public WebElement address;
	
	
	
	@iOSXCUITFindBy(xpath = "//android.widget.Button[@resource-id=\"android:id/button1\"]")
	@AndroidFindBy(xpath = "//android.widget.Button[@resource-id=\"android:id/button1\"]")
	public WebElement alterOkBtn;
	
	public void checkoutProduct(AndroidDriver driver) throws FileNotFoundException, IOException {
		CommonUtils.swips(driver);
		WaitUtils.explicitWaitForElementsVisibility(driver, fashionsCategory);
		fashionsCategory.click();
		fashionItem.click();
		logger.info("'Fashions' category is clicked.");
		SearchProductPage sp = new SearchProductPage(driver);
		sp.addToCartBtnAction(driver);
		sp.cartView.click();
		logger.info("'Cart' is clicked.");
		WaitUtils.explicitWaitForElementsVisibility(driver, checkoutBtn);
		checkoutBtn.click();
		logger.info("'Checkout' button is clicked.");

		address.click();
		address.sendKeys("Main street");
		driver.hideKeyboard();
//		WaitUtils.explicitWaitForElementsVisibility(driver, processCheckoutBtn);
		processCheckoutBtn.click();
		
			yesBtn.click();
			WaitUtils.explicitWaitForElementsVisibility(driver, yesBtn);
		
		WaitUtils.explicitWaitForElementsVisibility(driver, alterCongratsMessage);
		alterOkBtn.click();
		
	}
	public boolean isCategoryView(AndroidDriver driver) {
		if(categoryView.isDisplayed()) {
			return true;
		}else {
			return false;
		}
	}
}
