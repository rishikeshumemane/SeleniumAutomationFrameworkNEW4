package com.cs.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.cs.driver.DriverManager;
import com.cs.listeners.ListenerClass;
import com.cs.utils.DisplayLogUtils;

public final class HomePageTests extends BaseTest{

	private HomePageTests() {}

	@Test
	public void test3()
	{
		DisplayLogUtils.displayLog("Begin of HomePageTests.test3() ->" + ListenerClass.executionOrdercounter++);

		DriverManager.getDriver().findElement(By.name("q")).sendKeys("Rishikesh Memane",Keys.ENTER);
		DisplayLogUtils.displayLog("End of HomePageTests.test3() ->" + ListenerClass.executionOrdercounter);

	}
	@Test
	public void test5()
	{
		DisplayLogUtils.displayLog("Begin of HomePageTests.test5() ->" + ListenerClass.executionOrdercounter++);
		DriverManager.getDriver().findElement(By.name("q")).sendKeys("QA Manager",Keys.ENTER);
		DisplayLogUtils.displayLog("End of HomePageTests.test5() ->" + ListenerClass.executionOrdercounter);
	}
}
