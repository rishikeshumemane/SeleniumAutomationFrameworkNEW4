package com.cs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cs.driver.DriverManager;
import com.cs.listeners.ListenerClass;
import com.cs.utils.DisplayLogUtils;
import com.cs.utils.DynamicXpathUtils;

public final class AmazonHamburgerMenuPage extends BasePage{

	@FindBy(xpath="//div[text()='Computers']/parent::a")
	private WebElement linkComputers;
	
 	private String linkSubMenu    = "//a[text()='%s']";

	public AmazonHamburgerMenuPage() {
		DisplayLogUtils.displayLog("Begin of AmazonHamburgerMenuPage ->" + ListenerClass.executionOrdercounter++);
		PageFactory.initElements(DriverManager.getDriver(), this);
	}

	public AmazonHamburgerMenuPage clickComputers()
	{
 
 		click(linkComputers, "Computers");

		return new AmazonHamburgerMenuPage();
	}
	
	public AmazonLapTopAndAccessories clickOnSubMenuItem(String menuText)
	{
 
		String newXpath = DynamicXpathUtils.getXpath(linkSubMenu, menuText);
 		By newBy = By.xpath(newXpath);
		click(newBy,  menuText);
		if(menuText.contains("Laptop"))
			return new AmazonLapTopAndAccessories();
		
		return null;
	}
	
}
