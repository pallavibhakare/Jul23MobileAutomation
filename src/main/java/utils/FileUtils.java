package utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import constants.FileConstants;

public class FileUtils {
	public static String readAppTestDataPropertiesFile(String key) throws FileNotFoundException, IOException {
		Properties p = new Properties();
		p.load(new FileReader(FileConstants.APP_TEST_DATA_FILE_PATH));
		return p.getProperty(key);
	
	}
}
