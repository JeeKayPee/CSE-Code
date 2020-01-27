package ch4_auto.beyond;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import common.BaseTest2;

/*
 * Select Week start as Monday on Wordpress Settings Page. Assert correct selection.
*/
public class Ex02SelectControl  extends BaseTest2{
	
	/*
	 * Handling a drop down list with clicks
	 */
	@Test
	public void test01() {
		this.getDriver().findElement(By.linkText("Settings")).click();
		this.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.id("blogname")));
		
		WebElement rawDropDown = this.getDriver().findElement(By.id("start_of_week"));
		rawDropDown.click();
		
		String expectedDay = "Monday";
		String xFinder = String.format("//option[text()='%s']", expectedDay);
		
		WebElement option = getDriver().findElement(By.xpath(xFinder));
		option.click();
		
		assertTrue(option.isSelected(), "Assert Monday is selected as start of the week");
	}
	
	/*
	 * Handling a drop down list sendKeys
	 */
	@Test
	public void test02() {
		this.getDriver().findElement(By.linkText("Settings")).click();
		this.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.id("blogname")));
		
		WebElement rawDropDown = this.getDriver().findElement(By.id("start_of_week"));
		String expectedDay = "Monday";
		rawDropDown.sendKeys(expectedDay);
		
		String xFinder = String.format("//option[text()='%s']", expectedDay);
		WebElement option = getDriver().findElement(By.xpath(xFinder));
		
		assertTrue(option.isSelected(), "Assert Monday is selected as start of the week");
	}
	
	/*
	 * Handling a drop down list as a Select control
	 */
	@Test
	public void test03() {
		// goto Settings
		getDriver().findElement(By.linkText("Settings")).click();
		getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.id("blogname")));
		
		// Update Weeks starts from Sunday to Monday
		String expectedDay = "Monday";
		Select weekStart = new Select(getDriver().findElement(By.id("start_of_week")));
		weekStart.selectByVisibleText(expectedDay);
		String actualDay = weekStart.getFirstSelectedOption().getText();
		assertEquals(expectedDay, actualDay, "Verifying Selected Start of a week");		
	}

}
