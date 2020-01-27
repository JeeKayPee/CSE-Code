package ch4_auto.beyond;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import common.BaseTest2;

class Ex12KeyboardInteraction extends BaseTest2{
	
	/*
	 * Sending sequence of keys with Keys.chord
	 */
	@Test
	void test01() throws Exception {
		String title = "Sample";
		WebElement postTitle = getDriver().findElement(By.name("post_title"));
		postTitle.sendKeys(Keys.chord(Keys.SHIFT, title));
		assertEquals(title.toUpperCase(), postTitle.getAttribute("value"), "Assert upper case title");
	}
	
	/*
	 * Holding and releasing a key while other keystrokes are simulated
	 */
	@Test
	void test02() throws Exception {
		String title = "Sample";
		WebElement postTitle = getDriver().findElement(By.name("post_title"));
		
		Actions actions = new Actions(getDriver());
		actions.keyDown(Keys.SHIFT)
		.sendKeys(postTitle, title)
		.keyUp(Keys.SHIFT)
		.build()
		.perform();
		
		assertEquals(title.toUpperCase(), postTitle.getAttribute("value"), "Assert upper case title");
	}
	
}
