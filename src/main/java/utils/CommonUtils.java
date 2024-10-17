package utils;

import java.time.Duration;
import java.util.Arrays;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.PointerInput.Kind;
import org.openqa.selenium.interactions.PointerInput.Origin;
import org.openqa.selenium.interactions.Sequence;
import io.appium.java_client.AppiumDriver;


public class CommonUtils {

	public static void scrollUntilElementIsVisible(AppiumDriver driver, WebElement ele) {
          for(int i=0; i<4; i++) {
            	PointerInput finger = new PointerInput(Kind.TOUCH, "finger");
            	Sequence scroll = new Sequence(finger, 0);
            	scroll.addAction(finger.createPointerMove(Duration.ofSeconds(0), Origin.viewport(), 530, 1720));
            	scroll.addAction(finger.createPointerDown(0));
            	scroll.addAction(finger.createPointerMove(Duration.ofMillis(500), Origin.viewport(), 500, 400));
            	scroll.addAction(finger.createPointerUp(0));
            	driver.perform(Arrays.asList(scroll));           
            }
		
	}
	public static void swips(AppiumDriver driver) {
		
		PointerInput f1 = new PointerInput(Kind.TOUCH, "finger1");
		Sequence swipe = new Sequence(f1, 0);
		swipe.addAction(f1.createPointerMove(Duration.ofSeconds(0), Origin.viewport(), 938, 1019));
		swipe.addAction(f1.createPointerDown(0));
		swipe.addAction(f1.createPointerMove(Duration.ofMillis(500), Origin.viewport(), 23, 1227));
		swipe.addAction(f1.createPointerUp(0));
		driver.perform(Arrays.asList(swipe));
	}
}
