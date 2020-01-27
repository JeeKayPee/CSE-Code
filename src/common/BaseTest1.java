package common;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

public class BaseTest1 {
	private WebDriver driver = null;
	
	@BeforeEach
	public void launchBrowser() throws Exception {
        setDriver(Configuration.createChromeDriver());	
        getDriver().get(Configuration.ADMIN_URL);
        Thread.sleep(2000);
	}

	@AfterEach
	public void closeBrowser() {
        getDriver().quit();		
	}

	protected WebDriver getDriver() {
		return driver;
	}

	private void setDriver(WebDriver driver) {
		this.driver = driver;
	}
}
