package ch4_auto.beyond;


import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import common.BaseTest2;
import common.SeleniumUtils;

class Ex03MultiMatch extends BaseTest2{

	@Test
	void selectAllCategories() throws Exception{
		// Click Post, Categories
		this.getDriver().findElement(By.linkText("Posts")).click();
		this.getDriver().findElement(By.linkText("Categories")).click();
		
		// Find All checkboxes for categories
		List<WebElement> delCheckboxes = getDriver().findElements(By.name("delete_tags[]"));
		
		System.out.println("Checkbox count:" + delCheckboxes.size());
		
		for(WebElement element: delCheckboxes) {
			SeleniumUtils.printElementInfo("Category Checkbox", element);
			element.click();
			assertTrue(element.isSelected(), "Assert checkbox selection");
		}
	}
	
}
