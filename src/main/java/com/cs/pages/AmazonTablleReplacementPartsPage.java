package com.cs.pages;

import com.cs.driver.DriverManager;
import com.cs.listeners.ListenerClass;
import com.cs.utils.DisplayLogUtils;

public class AmazonTablleReplacementPartsPage extends BasePage{

	public String  getTitle()
	{
		DisplayLogUtils.displayLog("Being of AmazonTablleReplacementPartsPage.getTitle()-->" + ListenerClass.executionOrdercounter++);
		return DriverManager.getDriver().getTitle();
	}
	
}
