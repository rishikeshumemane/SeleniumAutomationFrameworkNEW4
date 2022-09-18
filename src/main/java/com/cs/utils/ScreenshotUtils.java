package com.cs.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.cs.driver.DriverManager;
import com.cs.listeners.ListenerClass;

public final class ScreenshotUtils {

	private ScreenshotUtils() {}
	
	public static String getBase64Image()
	{
		DisplayLogUtils.displayLog("Begin&End of ScreenshotUtils.getBase64Image() ->" + ListenerClass.executionOrdercounter++);

		return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
	}
}
