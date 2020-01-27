package ch3_1_auto.browser;

import org.openqa.selenium.WebDriver;

import common.Configuration;

public class Ex04Browser {
 	public static void main(String[] args) throws Exception {
        WebDriver driver = Configuration.createChromeDriver();
        Thread.sleep(5000);
        driver.quit();
 	}
}

