package ch5_2_auto.refactoring;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Configuration {
	
	private static String ROOT_DIR = System.getProperty("user.dir") + File.separator;
	private static String DRIVERS_DIR = ROOT_DIR + "drivers" + File.separator;
	
	public static String CHROME_DRIVER = DRIVERS_DIR + "chromedriver";
	public static String FIREFOX_DRIVER = DRIVERS_DIR + "geckodriver";
	
	private static String IP = "http://192.168.56.101";
	public static String BLOG_URL = IP + "/";
	public static String ADMIN_URL = IP + "/wp-admin";
	public static final String USER_NAME = "user";
	public static final String PASSWORD = "bitnami";
	public static final long MAX_WAIT_TIME = 5;
	
	public static String SCREENSHOTS_DIR = System.getProperty("user.dir") 
			+ File.separator
			+ "screenshots"
			+ File.separator;	

	public final static Logger LOGGER = LogManager.getLogger("CSE");
}
