package ch3_2_auto.page.element;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import common.BaseTest1;
import common.SeleniumUtils;

class Ex02PrintElementInfo extends BaseTest1{

	/*
	 * Identify Username field by Name
	 */
	@Test
	void test() {
        WebElement element = getDriver().findElement(By.name("log"));
        SeleniumUtils.printElementInfo("Username Text Box", element);
	}
	
}
