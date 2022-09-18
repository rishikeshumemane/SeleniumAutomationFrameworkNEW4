package com.cs.pages;

import org.openqa.selenium.By;

import com.cs.listeners.ListenerClass;
import com.cs.utils.DisplayLogUtils;

public class CyberSuccessHomePage extends BasePage {

	private final By homeMenuOption        = By.xpath("//*[@id=\"categorymenu\"]/nav/ul/li[1]/a");
	
	public String getHomeMenuOption()
	{
		DisplayLogUtils.displayLog("Begin&End of CyberSuccessHomePage.getHomeMenuOption() ->" + ListenerClass.executionOrdercounter++);
		return getText(homeMenuOption);
	}
}
