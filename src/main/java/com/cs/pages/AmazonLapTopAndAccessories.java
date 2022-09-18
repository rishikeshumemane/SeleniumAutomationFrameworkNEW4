package com.cs.pages;

import com.cs.driver.DriverManager;
import com.cs.listeners.ListenerClass;
import com.cs.reports.ExtentLogger;
import com.cs.utils.DisplayLogUtils;

public class AmazonLapTopAndAccessories extends BasePage {

	public String getTitle()
	{
		try {
			DisplayLogUtils.displayLog("Begin of AmazonLapTopAndAccessories.getTitle() ->" + ListenerClass.executionOrdercounter++);

			ExtentLogger.pass("Getting title: " + DriverManager.getDriver().getTitle(), true);
		} catch (Exception e) {
			DisplayLogUtils.displayLog("Begin of AmazonLapTopAndAccessories.getTitle() ->" + ListenerClass.executionOrdercounter++);
			DisplayLogUtils.displayLog("ERROR=> in logging a message in AmazonLapTopAndAccessories.getTitle while using ExtentLogger.pass()");
 			e.printStackTrace();
		}
		return DriverManager.getDriver().getTitle();
	}
	
}
