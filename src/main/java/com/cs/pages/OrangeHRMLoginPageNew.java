package com.cs.pages;

import org.openqa.selenium.By;

import com.cs.listeners.ListenerClass;
import com.cs.utils.DisplayLogUtils;

public final class OrangeHRMLoginPageNew extends BasePage{

	private static final By textUserName = By.name("username");
	private static final By textPassword  = By.name("password");
	private static final By btnLogin           = By.xpath("//*[@id=\"app\"]//button");
 
	public OrangeHRMHomePageNew logInToApplication(String userName, String password)
	{
		DisplayLogUtils.displayLog("Begin of OrangeHRMLoginPage.logInToApplication() ->" + ListenerClass.executionOrdercounter++);

		new OrangeHRMLoginPageNew().enterUserName(userName).enterPassword(password).clickLogin();
				
		DisplayLogUtils.displayLog("End of OrangeHRMLoginPage.OrangeHRMLoginPage() ->" + ListenerClass.executionOrdercounter);

		return new OrangeHRMHomePageNew();
	}
	
	private  OrangeHRMLoginPageNew enterUserName(String userName)
	{
		DisplayLogUtils.displayLog("Begin of OrangeHRMLoginPage.enterUserName() ->" + ListenerClass.executionOrdercounter++);

		sendKeys(textUserName, userName,"Username");
		DisplayLogUtils.displayLog("End of OrangeHRMLoginPage.OrangeHRMLoginPage() ->" + ListenerClass.executionOrdercounter);

		return new OrangeHRMLoginPageNew();
	}

	private OrangeHRMLoginPageNew enterPassword(String password)
	{
		DisplayLogUtils.displayLog("Begin of OrangeHRMLoginPage.enterPassword() ->" + ListenerClass.executionOrdercounter++);

		sendKeys(textPassword, password, "Password");

		DisplayLogUtils.displayLog("End of OrangeHRMLoginPage.enterPassword() ->" + ListenerClass.executionOrdercounter);
		
		return new OrangeHRMLoginPageNew();
	}

	private  OrangeHRMHomePageNew clickLogin()
	{
		DisplayLogUtils.displayLog("Begin of OrangeHRMLoginPage.clickLogin() ->" + ListenerClass.executionOrdercounter++);

		click(btnLogin, "Login Button");
		DisplayLogUtils.displayLog("End of OrangeHRMLoginPage.clickLogin() ->" + ListenerClass.executionOrdercounter);

		return new OrangeHRMHomePageNew();
	}
	
	public String getTitle()
	{
		DisplayLogUtils.displayLog("Begin&End of OrangeHRMLoginPage.getTitle() ->" + ListenerClass.executionOrdercounter++);

		return getPageTitle();
	}
	
}