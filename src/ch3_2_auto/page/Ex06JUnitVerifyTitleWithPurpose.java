package ch3_2_auto.page;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import common.Configuration;

class Ex06JUnitVerifyTitleWithPurpose {

	@Test
	void testSiteTitle() throws Exception{
		WebDriver driver = Configuration.createChromeDriver();
        driver.get(Configuration.BLOG_URL);
        String expectedTitle = "Dummy";
        String actualTitle = driver.getTitle();
        assertEquals(expectedTitle, actualTitle, "Verifying Site Title");
        driver.quit();	
	}
}
