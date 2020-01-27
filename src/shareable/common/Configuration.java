package common;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Configuration {
	public static String DRIVER_DIR = System.getProperty("user.dir") 
			+ File.separator
			+ "drivers"
			+ File.separator;
			
	public static String CHROME_DRIVER_PATH = DRIVER_DIR + "chromedriver";
	public static String GECKO_DRIVER_PATH = DRIVER_DIR + "geckodriver";
	
	private static String IP = "http://192.168.56.103";
	public static String BLOG_URL = IP + "/";
	public static String ADMIN_URL = IP + "/wp-admin";
	
	public static String USER_NAME = "user";
	public static String PASSWORD = "bitnami";
	
	public static String SCREENSHOTS_DIR = System.getProperty("user.dir") 
			+ File.separator
			+ "screenshots"
			+ File.separator;
	
	private static String modifyIfWindows(String inPath) {
		if (System.getProperty("os.name").toLowerCase().contains("windows")){
			return inPath + ".exe";
		} else {
			return inPath;
		}
	}
	
	public static WebDriver createChromeDriver(ChromeOptions options) {
		System.setProperty("webdriver.chrome.driver", modifyIfWindows(CHROME_DRIVER_PATH));
		return new ChromeDriver(options);
	}
	
	public static WebDriver createChromeDriver() {
		return createChromeDriver(new ChromeOptions());
	}
	
	public static WebDriver createFireFoxDriver() {
		System.setProperty("webdriver.gecko.driver", modifyIfWindows(GECKO_DRIVER_PATH));
		return new FirefoxDriver();
	}
}
