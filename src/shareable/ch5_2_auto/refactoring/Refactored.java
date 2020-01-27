package ch5_2_auto.refactoring;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

class Refactored extends BaseTest{

	@Test
	void test() {
		UiElement title = this.getAutomator().find(By.name("post_title"));
		String titleText = "Sample" + String.valueOf(System.currentTimeMillis()); 
		title.enterText(titleText);
		UiElement content = this.getAutomator().find(By.name("content"));
		content.enterText("Sample content");
		content.submit(By.linkText(titleText));
	}

}
