package com.cs.reports;

import com.aventstack.extentreports.ExtentTest;
import com.cs.listeners.ListenerClass;
import com.cs.utils.DisplayLogUtils;

public class ExtentManager {
	
	public static final ThreadLocal<ExtentTest> extTest= new ThreadLocal<>();

	private ExtentManager() {}

	public static ExtentTest getExtentTest() {
		DisplayLogUtils.displayLog("Begin&End of ExtentManager.getExtentTest() ->" + ListenerClass.executionOrdercounter++);

		return extTest.get();
	}
	static void setExtentTest(ExtentTest test) {
		DisplayLogUtils.displayLog("Begin&End of ExtentManager.setExtentTest() ->" + ListenerClass.executionOrdercounter++);
		extTest.set(test);
	}
	static void unload() {
		DisplayLogUtils.displayLog("Begin&End of ExtentManager.unload() ->" + ListenerClass.executionOrdercounter++);

		extTest.remove();
	}
}
