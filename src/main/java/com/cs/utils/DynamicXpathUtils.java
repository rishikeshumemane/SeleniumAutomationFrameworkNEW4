package com.cs.utils;

import com.cs.listeners.ListenerClass;

public final class DynamicXpathUtils {

	private DynamicXpathUtils () {}
	
	public static String getXpath(String xpath, String value)
	{
	//	return xpath.replace("%replaceable%", value);
	//	System.out.println("formated locator: " + String.format(xpath, value));
		
		DisplayLogUtils.displayLog("Begin&End of DynamicXpathUtils.getXpath() ->" + ListenerClass.executionOrdercounter++);

		return String.format(xpath, value);
		
	}
	
	
}
