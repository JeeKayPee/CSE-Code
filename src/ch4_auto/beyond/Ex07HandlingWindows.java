package ch4_auto.beyond;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;

import common.BaseTest2;
import common.Configuration;

public class Ex07HandlingWindows  extends BaseTest2{

	@Test
    public void createNewTab() throws InterruptedException{
        System.out.println(getDriver().getTitle());
        String mainWin = getDriver().getWindowHandle();
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        // Open blog url in new window/tab
        js.executeScript("window.open(arguments[0]);", Configuration.BLOG_URL);
        
        for (String handle: getDriver().getWindowHandles()) {
            if (!handle.equals(mainWin)) {
                getDriver().switchTo().window(handle);
                System.out.println(getDriver().getTitle());
                getDriver().close();
            }
        }
        
        getDriver().switchTo().window(mainWin);
        System.out.println(getDriver().getTitle());
        
        // Assert that the new window was closed
        assertEquals(getDriver().getWindowHandles().size(), 1, "Verifying whether new window is closed");
    }
}
