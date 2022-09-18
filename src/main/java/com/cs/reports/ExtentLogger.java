package com.cs.reports;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.cs.enums.ConfigProperties;
import com.cs.listeners.ListenerClass;
import com.cs.utils.DisplayLogUtils;
import com.cs.utils.PropertyUtils;
import com.cs.utils.ScreenshotUtils;

public final class ExtentLogger {

	private ExtentLogger() {}


	public static void pass(String message)
	{
		DisplayLogUtils.displayLog("Begin of ExtentLogger.pass(message) ->" + ListenerClass.executionOrdercounter++);
		ExtentManager.getExtentTest().pass(message);
		DisplayLogUtils.displayLog("End of ExtentLogger.pass(message) ->" + ListenerClass.executionOrdercounter);
	}
	
	public static void pass(String message, boolean isScreenshotNeeded)  
	{
		DisplayLogUtils.displayLog("Begin of ExtentLogger.pass(message,isScreenshoNeeded) ->" + ListenerClass.executionOrdercounter++);
		
		if (PropertyUtils.getValue(ConfigProperties.PASSEDSTEPSSCREENSHOT).equalsIgnoreCase("yes")
				&& isScreenshotNeeded)
			ExtentManager.getExtentTest().pass(message, 
					MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());	
		else
			pass(message);
		
		DisplayLogUtils.displayLog("End of ExtentLogger.pass(message,isScreenshoNeeded) ->" + ListenerClass.executionOrdercounter);

	}


	public static void fail(String message)
	{
		DisplayLogUtils.displayLog("Begin of ExtentLogger.fail(message) ->" + ListenerClass.executionOrdercounter++);

		ExtentManager.getExtentTest().fail(message);
		DisplayLogUtils.displayLog("End of ExtentLogger.fail(message) ->" + ListenerClass.executionOrdercounter);

	}
	public static void fail(String message, boolean isScreenshotNeeded)  
	{
		DisplayLogUtils.displayLog("Begin of ExtentLogger.fail(message,isScreenshotNeeded) ->" + ListenerClass.executionOrdercounter++);

		if (PropertyUtils.getValue(ConfigProperties.FAILEDSTEPSSCREENSHOT).equalsIgnoreCase("yes")
				&& isScreenshotNeeded)
			ExtentManager.getExtentTest().fail(message, 
					MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());	
		else
			fail(message);

		DisplayLogUtils.displayLog("End of ExtentLogger.fail(message,isScreenshotNeeded) ->" + ListenerClass.executionOrdercounter);

	}


	public static void skip(String message)
	{
		DisplayLogUtils.displayLog("Begin of ExtentLogger.skip(message) ->" + ListenerClass.executionOrdercounter++);

		ExtentManager.getExtentTest().skip(message);

		DisplayLogUtils.displayLog("End of ExtentLogger.skip(message) ->" + ListenerClass.executionOrdercounter);
	}
	
	public static void skip(String message, boolean isScreenshotNeeded)  
	{
		DisplayLogUtils.displayLog("Begin of ExtentLogger.skip(message,isScreenshotNeeded) ->" + ListenerClass.executionOrdercounter++);

		if (PropertyUtils.getValue(ConfigProperties.SKIPPEDSTEPSSCREENSHOT).equalsIgnoreCase("yes")
				&& isScreenshotNeeded)
			ExtentManager.getExtentTest().skip(message, 
					MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());	
		else
			skip(message);
		DisplayLogUtils.displayLog("End of ExtentLogger.skip(message,isScreenshotNeeded) ->" + ListenerClass.executionOrdercounter);

	}


}
