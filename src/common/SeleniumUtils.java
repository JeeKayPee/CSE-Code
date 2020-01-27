package common;

import org.openqa.selenium.WebElement;

public class SeleniumUtils {

	public static void printElementInfo(String name, WebElement element) {
		String marker = "------------------------------";
		System.out.println(marker);
		System.out.println("Element meta-data: " + name);
		System.out.println(marker);
		System.out.println("WebElement object:: " + element);
		System.out.println("Outer HTML:: " + element.getAttribute("outerHTML"));
		System.out.println("Inner HTML:: " + element.getAttribute("innerHTML"));
		System.out.println("Text:: " + element.getText());
        System.out.println("Value::" + element.getAttribute("value"));
        System.out.println("Tag:: " + element.getTagName());
        System.out.println("Displayed?:: " + element.isDisplayed());
        System.out.println("Selected?:: " + element.isSelected());
        System.out.println("Enabled?:: " + element.isEnabled());
        System.out.println(marker);
	}
}