package ch3_2_auto.page.element;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import common.BaseTest1;

class Ex01UsingName extends BaseTest1{

	/*
	 * Identify Username field by Name
	 */
	@Test
	public void test01() throws Exception{
        WebElement userNameTxtField = getDriver().findElement(By.name("log"));
        System.out.println(userNameTxtField);
	}
	
}
