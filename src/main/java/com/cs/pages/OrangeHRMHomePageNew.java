package com.cs.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cs.driver.DriverManager;
import com.cs.listeners.ListenerClass;
import com.cs.reports.ExtentLogger;
import com.cs.utils.DisplayLogUtils;

public final class OrangeHRMHomePageNew extends BasePage{

	private final By linkWelcome = By.id("welcome");
	private final By linkLogout = By.xpath("//a[text()='Logout']");


	public OrangeHRMHomePageNew clickWelcome()    
	{
		DisplayLogUtils.displayLog("Begin of OrangeHRMHomePage.OrangeHRMHomePage() ->" + ListenerClass.executionOrdercounter++);

 		click(linkWelcome, "Welcome Link");
		//Uninterruptibles.sleepUninterruptibly(4, TimeUnit.SECONDS);
 
		DisplayLogUtils.displayLog("End of OrangeHRMHomePage.OrangeHRMHomePage() ->" + ListenerClass.executionOrdercounter);

		return this;
	}

	
	public OrangeHRMLoginPageNew clickLogout()
	{
		DisplayLogUtils.displayLog("Begin of OrangeHRMHomePage.clickLogout() ->" + ListenerClass.executionOrdercounter++);

		new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10))
				.until(d->d.findElement(linkLogout).isEnabled());
		
		click(linkLogout, "logoutLink");
		
		DisplayLogUtils.displayLog("End of OrangeHRMHomePage.clickLogout() ->" + ListenerClass.executionOrdercounter);
		
		return new OrangeHRMLoginPageNew();
	}
	//	wait.until(d->d.findElement(linkLogout).isEnabled()); // JAva 8 way

	public String getTitle()
	{
		return getPageTitle();
	}
	
	public String getElementTextForWelcomeUser()
	{
		DisplayLogUtils.displayLog("Begin of OrangeHRMHomePage.getElementText() ->" + ListenerClass.executionOrdercounter++);
		ExtentLogger.pass("get Welcome Link", true);
		DisplayLogUtils.displayLog("End of OrangeHRMHomePage.getElementText() ->" + ListenerClass.executionOrdercounter);

		return getText(linkWelcome);
	}
}
