package mobileTesting;

import java.awt.PointerInfo;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.PointerInput.Kind;
import org.openqa.selenium.interactions.PointerInput.Origin;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTHeaderFooter;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class LaunchApp {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		AndroidDriver driver=null;
		URL url = new URL("http://127.0.0.1:4723/");
		UiAutomator2Options uia = new UiAutomator2Options();
//		uia.DEVICE_NAME_OPTION="";
//		uia.PLATFORM_VERSION_OPTION = "";
		uia.setAppPackage("com.solodroid.solomerce");
		uia.setAppActivity(".activities.MainActivity");
		uia.setAutomationName("UiAutomator2");
		uia.setPlatformName("android");
		uia.setDeviceName("ad69e5e8");
		uia.setPlatformVersion("12");
//		uia.setCapability("unlockType", "pattern");
//		uia.setCapability("unlockPin", "12345");
//		uia.setCapability("ignoreHiddenApiPolicyError" , true);
		
		
		driver = new AndroidDriver(url, uia);
		System.out.println("Appliaction Launched.");
		
//		driver.lockDevice();
		driver.unlockDevice();
		
//		// 1. click on the product
		Thread.sleep(3000);
//		driver.findElement(AppiumBy.xpath("(//*[@resource-id='com.solodroid.solomerce:id/product_name'])[1]")).click();		

		
//		// 2. zoom
//		driver.findElement(AppiumBy.id("com.solodroid.solomerce:id/product_image")).click();				
//		PointerInput finger1 = new PointerInput(Kind.TOUCH, "finger1");
//		Sequence tap1 = new Sequence(finger1, 0);
//		tap1.addAction(finger1.createPointerMove(Duration.ofSeconds(1), Origin.viewport(), 947, 827));
//		tap1.addAction(finger1.createPointerDown(0));
//		tap1.addAction(finger1.createPointerUp(0));
//		
//		PointerInput finger2 = new PointerInput(Kind.TOUCH, "finger2");
//		Sequence tap2 = new Sequence(finger2, 0);
//		tap2.addAction(finger2.createPointerDown(0));
//		tap2.addAction(finger2.createPointerUp(0));
//		driver.perform(Arrays.asList(tap1, tap2));
		
//		// 3. swipe
//		PointerInput f1 = new PointerInput(Kind.TOUCH, "finger1");
//		Sequence swipe = new Sequence(f1, 0);
//		swipe.addAction(f1.createPointerMove(Duration.ofSeconds(0), Origin.viewport(), 938, 1019));
//		swipe.addAction(f1.createPointerDown(0));
//		swipe.addAction(f1.createPointerMove(Duration.ofMillis(500), Origin.viewport(), 23, 1227));
//		swipe.addAction(f1.createPointerUp(0));
//		driver.perform(Arrays.asList(swipe));
		
//		// 4. scroll
//		for(int i=0; i<4; i++) {
//		PointerInput f2 = new PointerInput(Kind.TOUCH, "finger1");
//		Sequence scroll = new Sequence(f2, 0);
//		scroll.addAction(f2.createPointerMove(Duration.ofSeconds(0), Origin.viewport(), 938, 1800));
//		scroll.addAction(f2.createPointerDown(0));
//		scroll.addAction(f2.createPointerMove(Duration.ofMillis(500), Origin.viewport(), 938, 300));
//		scroll.addAction(f2.createPointerUp(0));
//		driver.perform(Arrays.asList(scroll));
//		}
		
//		// 5. Pinch Zoom	
//		PointerInput f3 = new PointerInput(Kind.TOUCH, "finger3");
//		Sequence act1 = new Sequence(f3, 0);
//		act1.addAction(f3.createPointerMove(Duration.ofSeconds(0), Origin.viewport(), 750, 1400));
//		act1.addAction(f3.createPointerDown(0));
//		act1.addAction(f3.createPointerMove(Duration.ofMillis(500), Origin.viewport(), 750, 700));
//		act1.addAction(f3.createPointerUp(0));
//		PointerInput f4 = new PointerInput(Kind.TOUCH, "finger4");
//		Sequence act2 = new Sequence(f4, 0);
//		act2.addAction(f4.createPointerMove(Duration.ofSeconds(0), Origin.viewport(), 750, 1550));
//		act2.addAction(f4.createPointerDown(0));
//		act2.addAction(f4.createPointerMove(Duration.ofMillis(500), Origin.viewport(), 750, 2500));
//		act2.addAction(f4.createPointerUp(0));
//		driver.perform(Arrays.asList(act1, act2));
	
//		// 6. Zoom out		
//		PointerInput f5 = new PointerInput(Kind.TOUCH, "finger5");
//		Sequence act5 = new Sequence(f5, 0);
//		act5.addAction(f5.createPointerMove(Duration.ofSeconds(0), Origin.viewport(), 750, 700));
//		act5.addAction(f5.createPointerDown(0));
//		act5.addAction(f5.createPointerMove(Duration.ofMillis(500), Origin.viewport(), 750, 1400));
//		act5.addAction(f5.createPointerUp(0));
//		PointerInput f6 = new PointerInput(Kind.TOUCH, "finger6");
//		Sequence act6 = new Sequence(f6,0);
//		act6.addAction(f6.createPointerMove(Duration.ofSeconds(0), Origin.viewport(), 750, 2500));
//		act6.addAction(f6.createPointerDown(0));
//		act6.addAction(f6.createPointerMove(Duration.ofMillis(500), Origin.viewport(), 750, 1550));
//		act6.addAction(f6.createPointerUp(0));
//		driver.perform(Arrays.asList(act5, act6));
		
//	    // 7. run app in background
//		driver.runAppInBackground(Duration.ofSeconds(5));
		
//       // 8. Rotate device
//		 if(driver.getOrientation().equals(ScreenOrientation.PORTRAIT)) {
//			 driver.rotate(ScreenOrientation.LANDSCAPE);
//		 }
		
		
//		driver.lockDevice();
//		driver.unlockDevice();
		
//		AppiumBy.id("com.solodroid.solomerce:id/product_image")
		Thread.sleep(3000);
		WebElement productImage = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().textContains(\"Samsung\")"));
		productImage.click();
	}
	

}
