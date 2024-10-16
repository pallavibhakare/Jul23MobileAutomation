package listeners;

import java.io.IOException;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import tests.BaseTest;
import utils.FileUtils;
import utils.ScreenshotUtils;

public class TestListener implements ITestListener{
	
	public void onTestStart(ITestResult name) {
		
	    BaseTest.test = BaseTest.extent.createTest(name.getName());
	    BaseTest.threadTest.set(BaseTest.test);
		BaseTest.threadTest.get().log(Status.INFO, name.getName()+" STARTED.");
	}
	
	public void onTestSuccess(ITestResult result) {

			BaseTest.threadTest.get().pass(result.getName()+" test PASSED.");
	
	}
	
	public void onTestFailure(ITestResult result) {
		try {
			BaseTest.threadTest.get().addScreenCaptureFromPath(ScreenshotUtils.captureScreenshot(BaseTest.getDriver(FileUtils.readAppTestDataPropertiesFile("driverType"))));						
//			ExtentTest currentTest = BaseTest.threadTest.get();
//			if(currentTest == null) {
//				currentTest.log(Status.INFO, result.getName()+"Current test is null for failed test: ");
//			}else {
//			currentTest.addScreenCaptureFromPath(ScreenshotUtils.captureScreenshot( BaseTest.getDriver(FileUtils.readAppTestDataPropertiesFile("driverType"))));
//			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BaseTest.threadTest.get().log(Status.FAIL, result.getName()+" FAILED.");
	}
}
