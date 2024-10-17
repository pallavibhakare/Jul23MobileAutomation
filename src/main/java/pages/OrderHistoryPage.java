package pages;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class OrderHistoryPage  extends BasePage{

	public OrderHistoryPage(AndroidDriver driver) {
		super(driver);
	}
	@iOSXCUITFindBy(id = "com.solodroid.solomerce:id/nav_profile")
	@AndroidFindBy( id = "com.solodroid.solomerce:id/nav_profile")
	public WebElement userProfile;
	
	@iOSXCUITFindBy(accessibility = "new UiSelector().text(\"Order History\")")
	@AndroidFindBy( uiAutomator = "new UiSelector().text(\"Order History\")")
	public WebElement orderHistory;

	@iOSXCUITFindBy(id = "com.solodroid.solomerce:id/lyt_empty_history")
	@AndroidFindBy( id = "com.solodroid.solomerce:id/lyt_empty_history")
	public WebElement empty_history_layout;
	
	@iOSXCUITFindBy(id = "com.solodroid.solomerce:id/recycler_view")
	@AndroidFindBy( id = "com.solodroid.solomerce:id/recycler_view")
	public WebElement recyclerView;
	
	@iOSXCUITFindBy(id = "com.solodroid.solomerce:id/txt_purchase_code")
	@AndroidFindBy( id = "com.solodroid.solomerce:id/txt_purchase_code")
	public WebElement purchaseCode;
	
	
	public void orderHistory() {
		
		userProfile.click();
		orderHistory.click();
		if(recyclerView.isDisplayed()){
			logger.info("Order Histroy '"+purchaseCode.getText()+"'is displayed.");
		}else {
			logger.info("No item in the cart.");
		}
	}
}
