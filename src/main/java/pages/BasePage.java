package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class BasePage {
	public static Logger logger = LogManager.getLogger();
	public BasePage(AndroidDriver driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	public BasePage(IOSDriver driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
}
