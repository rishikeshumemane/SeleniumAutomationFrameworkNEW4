package com.cs.tests;

import java.util.Map;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.cs.driver.Driver;
import com.cs.listeners.ListenerClass;
import com.cs.utils.DisplayLogUtils;

public class BaseTest {

	protected BaseTest() {}
	
	@BeforeMethod
	protected void setUp(Object[] data)  
	{
		DisplayLogUtils.displayLog("Begin of BaseTest.setUp() ->" + ListenerClass.executionOrdercounter++);
		// convert 0th cell to map as we have list of map passed to a dataprovider
		@SuppressWarnings("unchecked")
		Map<String, String> map = (Map<String, String>)data[0];
		Driver.initDriver(map.get("browser"));
		DisplayLogUtils.displayLog("Begin of BaseTest.setUp() ->" + ListenerClass.executionOrdercounter);
	}

	@AfterMethod
	protected void tearDown()
	{
		DisplayLogUtils.displayLog("Begin of BaseTest.tearDown() ->" + ListenerClass.executionOrdercounter++);

		//Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(10));
		Driver.quitDriver();
		DisplayLogUtils.displayLog("End of BaseTest.tearDown() ->" + ListenerClass.executionOrdercounter);

	}
}
