package ch5_2_auto.refactoring;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebAutomator {
	private WebDriver driver;
	private WebDriverWait wait;
	
	public WebAutomator(Browser browser) throws Exception {
		switch (browser) {
		case CHROME:
			System.setProperty("webdriver.chrome.driver", modifyIfWindows(Configuration.CHROME_DRIVER));
			driver = new ChromeDriver();
			break;
		case FIREFOX:
			System.setProperty("webdriver.gecko.driver", modifyIfWindows(Configuration.FIREFOX_DRIVER));
			driver = new FirefoxDriver();
			break;
		case HTMLUNIT:
			driver = new HtmlUnitDriver(true);
			break;
		default:
			throw new Exception("Unsupported browser: " + browser);
		}
		wait = new WebDriverWait(driver, Configuration.MAX_WAIT_TIME);
	}
	
	public WebAutomator() throws Exception{
		this(Browser.HTMLUNIT);
	}
	
	private static String modifyIfWindows(String inPath) {
		if (System.getProperty("os.name").toLowerCase().contains("windows")){
			return inPath + ".exe";
		} else {
			return inPath;
		}
	}

	private UiElement wait(ExpectedCondition<WebElement> condition) {
		Configuration.LOGGER.debug("Waiting for expected condition: " + condition.toString());
		return new UiElement(this, wait.until(condition));
	}
	
	public UiElement waitUntilPresent(By by) {
		return wait(ExpectedConditions.presenceOfElementLocated(by));
	}
	
	public UiElement waitUntilClickable(By by) {
		return wait(ExpectedConditions.elementToBeClickable(by));
	}
	
	public UiElement find(By by) {
		return waitUntilPresent(by);
	}
	
	public UiElement goTo(String url, By by) {
		Configuration.LOGGER.info("Go to URL:" + url);
		driver.get(url);
		return waitUntilPresent(by);
	}

	public void closeAll() {
		driver.quit();
	}

	public void assertPresent(By by) {
		try {
			waitUntilPresent(by);
		} catch (Exception e) {
			Configuration.LOGGER.error("Assertion exception while checking presence of element by: " + by.toString());
			throw new AssertionError("Element not present" + e.getMessage());
		}
	}

}
