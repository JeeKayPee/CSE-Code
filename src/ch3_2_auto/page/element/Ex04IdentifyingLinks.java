package ch3_2_auto.page.element;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import common.BaseTest1;
import common.SeleniumUtils;

class Ex04IdentifyingLinks extends BaseTest1{

	/*
	 * Identify Lost your password link by full text
	 */
	@Test
	public void test01() throws Exception{
        WebElement element = getDriver().findElement(By.linkText("Lost your password?"));
        SeleniumUtils.printElementInfo("Lost Password Link", element);
	}

	/*
	 * Identify <- Back to blog partial text (Contains <- and name of blog changes with blog.)
	 */
	@Test
	void test02() throws Exception{
        WebElement element = getDriver().findElement(By.partialLinkText("Back to"));
        SeleniumUtils.printElementInfo("Back to blog link", element);
	}

}
