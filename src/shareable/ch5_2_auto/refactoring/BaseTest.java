package ch5_2_auto.refactoring;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;

public class BaseTest {
	private WebAutomator automator;

	@BeforeEach
	public void login() throws Exception {
		// Create Driver
		automator = new WebAutomator(Browser.CHROME);

		// Login
		UiElement userTextBox = automator.goTo(Configuration.ADMIN_URL, By.name("log"));
        userTextBox.enterText(Configuration.USER_NAME);
        UiElement pwdTextBox = automator.find(By.name("pwd"));
        pwdTextBox.enterText(Configuration.PASSWORD);
        pwdTextBox.submit(By.id("wpadminbar"));
	}

	@AfterEach
	public void logout() throws Exception {
		UiElement logOut = automator.find(By.xpath("//*[text()='Log Out']"));
		automator.goTo(logOut.getLink(), By.xpath("//*[contains(text(),'logged out')]"));
		automator.closeAll();
	}

	protected WebAutomator getAutomator(){
		return this.automator;
	}

}
