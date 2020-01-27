package ch5_1_auto.end2end;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import common.BaseTest2;

public class Ex01_E2EScenarios extends BaseTest2 {
	
	@Test
	public void updateSettings() {
		// goto Settings
		getDriver().findElement(By.linkText("Settings")).click();
		getWaiter().until(ExpectedConditions.elementToBeClickable(By.id("submit")));
		
		// Update the blog title to Selenium Blog 
		String blogTitle = "Selenium Blog";
		WebElement blogName = getDriver().findElement(By.id("blogname"));
		blogName.clear();
		blogName.sendKeys(blogTitle);
		blogName = getDriver().findElement(By.id("blogname"));
		assertEquals(blogTitle, blogName.getAttribute("value"),
				String.format("Blog Title should be %s.", blogTitle));
		
		// Update User can register 
		WebElement usersCanRegister = getDriver().findElement(By.id("users_can_register"));
		if(!usersCanRegister.isSelected()) {
			usersCanRegister.click();
		}
		assertTrue(usersCanRegister.isSelected(), "Verifying the Anyone can register is checked");
		
		
		// Update the date format to m d y format
		WebElement targetRadio = getDriver().findElement(By.cssSelector("input[type='radio'][value = 'm/d/Y']"));
		targetRadio.click();
		assertTrue(targetRadio.isSelected(),
				String.format("%s Date Format should be selected", targetRadio.getAttribute("value")));
		
		
		// Update Weeks starts to Monday
		String expectedWeekDay = "Monday";
		Select weekStart = new Select(getDriver().findElement(By.id("start_of_week")));
		weekStart.selectByVisibleText(expectedWeekDay);
		String actualWeekStart = weekStart.getFirstSelectedOption().getText();
		assertEquals(expectedWeekDay, actualWeekStart, "Verifying Selected Start of a week");	
		
		
		// Submit the form
		getDriver().findElement(By.tagName("form")).submit();
		assertTrue(getDriver().findElement(By.xpath("//strong[text()='Settings saved.']")).isDisplayed(),
				"Settings should be saved");
	}
	
	@Test
	public void createPreviewDeletePost() throws Exception {
		// Click Posts link, Add New
        getDriver().findElement(By.linkText("Posts")).click();
        getDriver().findElement(By.linkText("Add New")).click();

        String title = "Sample Title";
        WebElement titleBox = getDriver().findElement(By.id("title"));
        titleBox.sendKeys(title);
        assertEquals(title, titleBox.getAttribute("value"), "Assert post title");
        
        getDriver().switchTo().frame("content_ifr");
        
        String text = "Dummy text";
        WebElement content = getDriver().findElement(By.id("tinymce"));
        content.sendKeys(text);
        assertEquals(text, content.getText(), "Assert post content");
        
        // Once an iframe is handled, switch back to default content (dom root)
        getDriver().switchTo().defaultContent();
        
        //Clicking on Publish Button
        getDriver().findElement(By.id("publish")).click();
        
        // Get current window name
        String mainWin = getDriver().getWindowHandle();
        
        // Click post preview button
        getDriver().findElement(By.id("post-preview")).click();
        
        for (String handle: getDriver().getWindowHandles()) {
            if (!handle.equals(mainWin)) {
                getDriver().switchTo().window(handle);
                getDriver().close();
            }
        }
        
        // Switch to main window
        getDriver().switchTo().window(mainWin);
        
        // Assert that the new window was closed
        assertEquals(getDriver().getWindowHandles().size(), 1, "Verifying preview window is closed or not");
        
        // CLicking on Move Trash
        getDriver().findElement(By.linkText("Move to Trash")).click();
    }

}
