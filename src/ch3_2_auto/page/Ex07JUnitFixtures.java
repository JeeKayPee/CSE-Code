package ch3_2_auto.page;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import common.Configuration;

class Ex07JUnitFixtures {
	WebDriver driver = null;

	@BeforeEach
	void launchBrowser() {
        driver = Configuration.createChromeDriver();		
	}

	@Test
	void testSiteTitle() throws Exception{
        driver.get(Configuration.BLOG_URL);
        String expectedTitle = "Dummy";
        String actualTitle = driver.getTitle();
        assertEquals(expectedTitle, actualTitle, "Verifying Site Title");
	}
	
	@AfterEach
	void closeBrowser() {
        driver.quit();		
	}
}
