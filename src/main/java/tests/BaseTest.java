package tests;

import java.net.MalformedURLException;
import java.net.URL;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import constants.FileConstants;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;


public class BaseTest {
	
	public static AppiumDriver driver ;
	AppiumDriverLocalService service;
	
	//ExtentReport
	public static ExtentReports extent;
	public static ExtentTest test;
	public static ThreadLocal<ExtentTest> threadTest = new ThreadLocal<ExtentTest>();
	//logger
	public static Logger logger = LogManager.getLogger("BaseTest");

	
	@BeforeSuite(alwaysRun = true)
	public void getReport() throws Exception {	
		extent = new ExtentReports();
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(FileConstants.REPORTS_FILE_PATH);
		extent.attachReporter(sparkReporter);
	}
	@AfterSuite
	public void flushReport() {
	    extent.flush();
	}

    @AfterMethod
    public void tearDown() {
        threadTest.remove(); // Clear the reference
    }
    @BeforeClass	
	public void startServer() throws Exception {
    	
//    	AppiumDriverLocalService service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder().usingPort(4723).withArgument(GeneralServerFlag.LOG_LEVEL, "debug"));
//    	service.start();
    	AppiumDriverLocalService service = AppiumDriverLocalService.buildService(
    		    new AppiumServiceBuilder()
    		        .usingPort(4723)
    		        .withIPAddress("127.0.0.1") 
    		        .withArgument(GeneralServerFlag.LOG_LEVEL, "debug")
    		);
    	service.start();
    	
//		service = new AppiumServiceBuilder()
//				.withAppiumJS(new File("/Program Files/nodejs/node_modules/appium/lib/main.js"))
//				.withIPAddress("127.0.0.1")
//				.usingPort(4723)
//				.withLogFile(appiumLogFile)
//				.withArgument(GeneralServerFlag.LOG_LEVEL)
//	            .build();
//	    	try {
//	    	service.start();
//	    	logger.info("Attempting to start Appium server...");
		}
	    @AfterClass
	    public void stopServer() {
	    	if (service != null) {	            
	            service.close();
	            service.stop();
	           
	        }
	    }
	
	public static AppiumDriver getDriver(String driverType) throws MalformedURLException {
		driverType = driverType.toLowerCase();
		switch(driverType) {
		case "android":		
			try {		
		        URL url = new URL("http://127.0.0.1:4723");
		        UiAutomator2Options uia = new UiAutomator2Options();
		        uia.setAppPackage("com.solodroid.solomerce");
		        uia.setAppActivity(".activities.MainActivity");
		        uia.setAutomationName("UiAutomator2");
		        uia.setPlatformName("android");
		        uia.setDeviceName("ad69e5e8");
		        uia.setPlatformVersion("12");		        
		        driver  = new AndroidDriver(url, uia);
		    } catch (Exception e) {
		        logger.error("Failed to create driver: " + e.getMessage(), e);
		    }
			break;
		case "android2":	
			URL url2 = new URL("http://127.0.0.1:4723");
			UiAutomator2Options uia2 = new UiAutomator2Options();
			uia2.setAppPackage("com.solodroid.solomerce");
			uia2.setAppActivity(".activities.MainActivity");
			uia2.setAutomationName("UiAutomator2");
			uia2.setPlatformName("android");
//			uia2.setDeviceName("ad69e5e8");
			uia2.setPlatformVersion("12");
			driver = new AndroidDriver(url2,uia2);
			break;
		case "iso":
			URL iosURL= new URL("http://127.0.0.1:4723");
			XCUITestOptions xct = new XCUITestOptions();
//			xct.setApp("/Users/Pal/Downloads/Solodroid_E-CommerceApp Demo_3.2.0.apk");		
			xct.setCapability("appPackage", "com.solodroid.solomerce");
			xct.setCapability("appActivity", ".activities.MainActivity");
			xct.setAutomationName("UiAutomator2");
			xct.setPlatformName("android");
//			xct.setDeviceName("ad69e5e8");
			xct.setPlatformVersion("12");
			driver = new IOSDriver(iosURL, xct);
			break;
		default:
			break;
		}
		return driver;
	}
	
}
