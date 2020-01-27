package ch4_auto.beyond;

import java.io.File;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import common.BaseTest2;
import common.Configuration;

public class Ex10TakingScreenshot extends BaseTest2{
	
	@Test
	public void takeScreenshot() {
		TakesScreenshot camera = (TakesScreenshot) getDriver();
		File sFile = camera.getScreenshotAs(OutputType.FILE);
		String path = String.format("%s%s-%s.png", Configuration.SCREENSHOTS_DIR, "dashboard", System.currentTimeMillis());
		sFile.renameTo(new File(path));
	}

}
