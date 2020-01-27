package ch4_auto.beyond;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;

import common.BaseTest2;

class Ex13Cookies extends BaseTest2{
	
	@Test
	public void handleCookies() throws Exception {
		// Get Cookies and print cookie information
		for (Cookie cookie: getDriver().manage().getCookies()) {
			System.out.println("Cookie information");
			System.out.println("Name: " + cookie.getName());
			System.out.println("Value: " + cookie.getValue());
			System.out.println("Domain: " + cookie.getDomain());
			System.out.println("Path: " + cookie.getPath());
			System.out.println("Secure?: " + cookie.isSecure());
			System.out.println("HttpOnly? : " + cookie.isHttpOnly());
			System.out.println("Full Text: " + cookie);
		}
		
		// Delete all cookies
		getDriver().manage().deleteAllCookies();
		
		// Refresh page - login page should appear as session is logged out.
		getDriver().navigate().refresh();
		getDriver().findElement(By.name("log"));
		
		// As we are on home page, the @AfterEach would fail in BaseTest2.
	}

}
