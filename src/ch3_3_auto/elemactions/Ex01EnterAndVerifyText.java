package ch3_3_auto.elemactions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import common.BaseTest1;
import common.Configuration;

public class Ex01EnterAndVerifyText extends BaseTest1{

	@Test
	void enterUserName() throws Exception{
        String expectedUserName = Configuration.USER_NAME;
        WebElement userTextBox = getDriver().findElement(By.name("log"));
        assertTrue(userTextBox.isEnabled(), "Assert that user name text box is enabled.");
        userTextBox.sendKeys(expectedUserName);
        String actualUserName = userTextBox.getAttribute("value");
        assertEquals(expectedUserName, actualUserName, "Assert that user name is entered correctly");
	}

}
