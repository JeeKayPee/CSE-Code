package ch3_3_auto.elemactions;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import common.BaseTest1;
import common.Configuration;

class Ex02LoginLogout extends BaseTest1{

	@Test
	public void test() throws Exception {
        WebElement userTextBox = getDriver().findElement(By.name("log"));
        userTextBox.sendKeys(Configuration.USER_NAME);
        WebElement pwdTextBox = getDriver().findElement(By.name("pwd"));
        pwdTextBox.sendKeys(Configuration.PASSWORD);
        pwdTextBox.submit();
        Thread.sleep(2000);
        boolean dboardLoaded = getDriver().findElement(By.id("wpadminbar")).isDisplayed();
        assertTrue(dboardLoaded, "Assert that dashbaord is laoded.");

        // Logout
        WebElement logOut = getDriver().findElement(By.xpath("//*[text()='Log Out']"));
		getDriver().get(logOut.getAttribute("href"));
		Thread.sleep(1000);
		WebElement logoutMsg = getDriver().findElement(By.xpath("//*[contains(text(),'logged out')]"));
		assertTrue(logoutMsg.isDisplayed(), "Assert successful logout.");
	}
	
}
