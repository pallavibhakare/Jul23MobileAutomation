package utils;

import java.time.Duration;
import java.util.Arrays;
import java.util.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.PointerInput.Kind;
import org.openqa.selenium.interactions.PointerInput.Origin;
import org.openqa.selenium.interactions.Sequence;

import io.appium.java_client.AppiumDriver;


public class CommonUtils {

	public static void scrollUntilElementIsVisible(AppiumDriver driver, WebElement ele) {
        boolean isVisible = false;
        
        while (!isVisible) {
            try {
                // Try to find the element
                WebElement element = ele;
                if (element.isDisplayed()) {
                    isVisible = true;
                }
            } catch (NoSuchElementException e) {
                // If not found, scroll
            	for(int i=0; i<4; i++) {
            		PointerInput f2 = new PointerInput(Kind.TOUCH, "finger1");
            		Sequence scroll = new Sequence(f2, 0);
            		scroll.addAction(f2.createPointerMove(Duration.ofSeconds(0), Origin.viewport(), 938, 1800));
            		scroll.addAction(f2.createPointerDown(0));
            		scroll.addAction(f2.createPointerMove(Duration.ofMillis(500), Origin.viewport(), 938, 300));
            		scroll.addAction(f2.createPointerUp(0));
            		driver.perform(Arrays.asList(scroll));
            		}
            }
        }
    }
	
}
