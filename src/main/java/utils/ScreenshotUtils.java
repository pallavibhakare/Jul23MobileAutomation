package utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import constants.FileConstants;
import io.appium.java_client.AppiumDriver;


public class ScreenshotUtils {

	public static String captureScreenshot(AppiumDriver	driver) {
		if (driver == null) {
            System.err.println("Driver is null, cannot capture screenshot.");
            return null;
        }
		String filePath = FileConstants.SCREENSHOT_FOLDER_PATH;
		TakesScreenshot page = (TakesScreenshot)driver;
		File screenshotFile = page.getScreenshotAs(OutputType.FILE);
		File dst = new File(filePath);
		screenshotFile.renameTo(dst);		
		return filePath;
	}
	public static String getTimeStamp() {
		return new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	}
}
