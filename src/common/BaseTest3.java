package common;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest3 {
	
	private WebDriver driver = null;
	private WebDriverWait wait = null;

	@BeforeEach
	public void login() throws Exception {
		// Create Driver
		ChromeOptions options = new ChromeOptions();
		options.setHeadless(true);
		setDriver(Configuration.createChromeDriver(options));	
		wait = new WebDriverWait(getDriver(), 60);

		// Login
		getDriver().get(Configuration.ADMIN_URL);
        WebElement userTextBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("log")));
        userTextBox.sendKeys(Configuration.USER_NAME);
        WebElement pwdTextBox = getDriver().findElement(By.name("pwd"));
        pwdTextBox.sendKeys(Configuration.PASSWORD);
        pwdTextBox.submit();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("wpadminbar")));
	}

	@AfterEach
	public void logout() throws Exception {
		WebElement logOut = getDriver().findElement(By.xpath("//*[text()='Log Out']"));
		getDriver().get(logOut.getAttribute("href"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'logged out')]")));
		getDriver().quit();
	}

	protected WebDriver getDriver(){
		return this.driver;
	}
	
	private void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	protected WebDriverWait getWaiter(){
		return this.wait;
	}

}
