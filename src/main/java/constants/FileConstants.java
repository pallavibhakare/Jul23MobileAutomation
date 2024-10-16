package constants;

import utils.ScreenshotUtils;

public class FileConstants {
	
	public static String ROOT_PATH = System.getProperty("user.dir");
	
	public static final String APP_TEST_DATA_FILE_PATH = ROOT_PATH +
			"/src/main/java/testData/appTestData.properties";
	
	
	public static final String SCREENSHOT_FOLDER_PATH = ROOT_PATH +
			"/src/main/resources/reports/SS"+ScreenshotUtils.getTimeStamp()+".png";
	public static final String REPORTS_FILE_PATH = ROOT_PATH +
			"/src/main/resources/reports/Report"+ScreenshotUtils.getTimeStamp()+".html";
	
}
