package ch4_auto.beyond;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import common.BaseTest2;

public class Ex09HandlingFrames  extends BaseTest2{

	@Test
    public void addPost() throws InterruptedException{
        getDriver().findElement(By.linkText("Posts")).click();
        getDriver().findElement(By.linkText("Add New")).click();

        WebElement publish = getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.id("publish")));

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
        getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.className("edit-slug")));
        publish.click();
        getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.linkText("View Post")));
    }
}
