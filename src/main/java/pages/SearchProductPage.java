package pages;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import utils.FileUtils;
import utils.WaitUtils;

public class SearchProductPage extends BasePage {

	public SearchProductPage(WebDriver driver) {
		super((AndroidDriver) driver);
	}
		
	@iOSXCUITFindBy(id = "com.solodroid.solomerce:id/search")
	@AndroidFindBy(id = "com.solodroid.solomerce:id/search")
	public WebElement searchIcon;
	
	@iOSXCUITFindBy(id = "com.solodroid.solomerce:id/search_src_text")
	@AndroidFindBy(id = "com.solodroid.solomerce:id/search_src_text")
	public WebElement searchInput;
	
	@iOSXCUITFindBy(id="com.solodroid.solomerce:id/recycler_view")
	@AndroidFindBy(id="com.solodroid.solomerce:id/recycler_view")
	public WebElement recycler_view;
	
	@iOSXCUITFindBy(id="com.solodroid.solomerce:id/product_name")
	@AndroidFindBy(id="com.solodroid.solomerce:id/product_name")
	public List<WebElement> productsListed;

	
	@iOSXCUITFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.solodroid.solomerce:id/product_name\" and @text=\"Scientific Calculator - Doraemon 350 MS\"]")
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.solodroid.solomerce:id/product_name\" and @text=\"Scientific Calculator - Doraemon 350 MS\"]")
	public WebElement aItemAtBottom;
	
	@iOSXCUITFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.solodroid.solomerce:id/product_name\" and @text=\"Apple watch series 3 GPS 42mm Black\"]")
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.solodroid.solomerce:id/product_name\" and @text=\"Apple watch series 3 GPS 42mm Black\"]")
	public WebElement item;
	
	@iOSXCUITFindBy(xpath ="//android.widget.TextView[@resource-id=\"com.solodroid.solomerce:id/product_name\"]")
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id=\"com.solodroid.solomerce:id/product_name\"]")
	public WebElement product_name;
	
	@iOSXCUITFindBy(id="com.solodroid.solomerce:id/btn_add_cart")
	@AndroidFindBy(id="com.solodroid.solomerce:id/btn_add_cart")
	public WebElement addToCartBtn;
	
	@iOSXCUITFindBy(id="com.solodroid.solomerce:id/dialogTitle")
	@AndroidFindBy(id="com.solodroid.solomerce:id/dialogTitle")
	public WebElement userInputDialogTitle;

	@iOSXCUITFindBy(id="com.solodroid.solomerce:id/userInputDialog")
	@AndroidFindBy(id="com.solodroid.solomerce:id/userInputDialog")
	public WebElement numOfOrderInput;
	
	@iOSXCUITFindBy(id="android:id/button2")
	@AndroidFindBy(id="android:id/button2")
	public WebElement numOfOrderCancel;
	
	@iOSXCUITFindBy(id="android:id/button1")
	@AndroidFindBy(id="android:id/button1")
	public WebElement numOfOrderAdd;

	@iOSXCUITFindBy(id="com.solodroid.solomerce:id/cart")
	@AndroidFindBy(id="com.solodroid.solomerce:id/cart")
	public WebElement cartView;
	
	@iOSXCUITFindBy(xpath ="//android.widget.TextView[@text=\"Shopping Cart\"]")
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Shopping Cart\"]")
	public WebElement shoppingCart;
	
	@iOSXCUITFindBy(id="com.solodroid.solomerce:id/no_item_message")
	@AndroidFindBy(id="com.solodroid.solomerce:id/no_item_message")
	public WebElement noItemInCartMsg;
	
	public void searchAItem(WebDriver driver, String searchItem) {
//		WaitUtils.explicitWaitForElementsVisibility(null, searchIcon);
		searchIcon.click();
		logger.info("Search Icon is clicked.");	
		searchInput.sendKeys(searchItem);
		if(recycler_view.isDisplayed()) {
			logger.info(searchItem+" items are listed.");
		}else {
			logger.atError();
		}
	}
	public boolean isSearchedProductsView(AndroidDriver driver, String searchedProduct) {
//		String[] actualProductNameInTheCart = product_name.getText();
//		String expectedProductName = searchedProduct;
		if(recycler_view.isDisplayed())
		{			
			logger.info("Searched Product suggestions are displayed.");
			return true;
		}else {
			logger.info("Can not display searched products.");
			return false;
		}
	}
	public void addToCartBtnAction(AndroidDriver driver) throws FileNotFoundException, IOException {
		String numberOfProducts=FileUtils.readAppTestDataPropertiesFile("numberOfItemsToAddInTheCart");
		String addToCartBtnTxt = addToCartBtn.getText();
		addToCartBtn.click();
		logger.info("'"+addToCartBtnTxt+"' button is clicked.");
		WaitUtils.explicitWaitForElementsVisibility(driver, userInputDialogTitle);
		numOfOrderInput.click();		
		numOfOrderInput.sendKeys(numberOfProducts);
		logger.info("'"+numberOfProducts+"' products are entered.");
		numOfOrderAdd.click();
		logger.info("'ADD' button is clicked.");
	}
	public String addProductToCart(AndroidDriver driver) throws FileNotFoundException, IOException, InterruptedException {
//		String numberOfProducts=FileUtils.readAppTestDataPropertiesFile("numberOfItemsToAddInTheCart");
		//System.out.println("itemCount: "+itemCount);	
		WaitUtils.explicitWaitForElementsVisibility(driver, item);
				
//		CommonUtils.scrollUntilElementIsVisible(driver, item);
		
		String itemTxt = item.getText();
		item.click();	
		logger.info(itemTxt+" is clicked.");
//		String addToCartBtnTxt = addToCartBtn.getText();
//		addToCartBtn.click();
//		logger.info("'"+addToCartBtnTxt+"' button is clicked.");
//		WaitUtils.explicitWaitForElementsVisibility(driver, userInputDialogTitle);
//		numOfOrderInput.click();		
//		numOfOrderInput.sendKeys(numberOfProducts);
//		logger.info("'"+numberOfProducts+"' products are entered.");
//		numOfOrderAdd.click();
//		logger.info("'ADD' button is clicked.");
		addToCartBtnAction(driver);
		cartView.click();	
		logger.info("'Cart' button is clicked.");
		if(shoppingCart.isDisplayed()) {
			logger.info(shoppingCart.getText()+" is displayed.");
		}else {
			logger.info("'Shopping Cart' is empty.");
		}
		return item.getText();
	}

	public boolean isProductAddedToTheCart(AndroidDriver driver, String addedProduct) {
		String actualProductNameInTheCart = product_name.getText();
		String expectedProductName = addedProduct;
		if(actualProductNameInTheCart.equals(expectedProductName))
		{			
			logger.info("Product is added to the cart.");
			return true;
		}else {
			logger.info("Can not add Product to the cart.");
			return false;
		}
	}
	
	
}
