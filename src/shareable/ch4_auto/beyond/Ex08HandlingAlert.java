package ch4_auto.beyond;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;

import common.BaseTest2;

public class Ex08HandlingAlert  extends BaseTest2{

    public void createNewTab() throws InterruptedException{
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("alert('cse');");
        
        Alert alert = this.getWaiter().until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }
}
