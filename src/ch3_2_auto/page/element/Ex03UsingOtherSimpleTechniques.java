package ch3_2_auto.page.element;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import common.BaseTest1;
import common.SeleniumUtils;

class Ex03UsingOtherSimpleTechniques extends BaseTest1{

	/*
	 * Identify Username field by Name
	 */
	@Test
	public void test01() throws Exception{
        WebElement userNameTxtField = getDriver().findElement(By.name("log"));
        System.out.println(userNameTxtField);
	}

	/*
	 * Identify Username field by ID
	 */
	@Test
	void test02() throws Exception{
        WebElement element = getDriver().findElement(By.id("user_login"));
        SeleniumUtils.printElementInfo("Username Text Box", element);
	}
	
	/*
	 * Identify Username field by Tag Name
	 */
	@Test
	void test03() throws Exception{
        WebElement element = getDriver().findElement(By.tagName("input"));
        SeleniumUtils.printElementInfo("Username Text Box", element);
	}

	/*
	 * Identify Username field by Class Name
	 */
	@Test
	void test04() throws Exception{
        WebElement element = getDriver().findElement(By.className("input"));
        SeleniumUtils.printElementInfo("Username Text Box", element);
	}

	/*
	 * Identify Submit button by Class Name (using one class from multiple classes)
	 */
	@Test
	void test05() throws Exception{
        WebElement element = getDriver().findElement(By.className("button-large"));
        SeleniumUtils.printElementInfo("Submit button", element);
	}
	
}
