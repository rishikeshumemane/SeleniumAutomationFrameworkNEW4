package com.cs.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cs.driver.DriverManager;

public class AmazonHomePage extends BasePage {
	@FindBy(xpath="//*[@id='nav-hamburger-menu']/i")
	private WebElement linkHamburger;
	
	public AmazonHomePage()
	{
 		PageFactory.initElements(DriverManager.getDriver(), this);
 	}
	
	public AmazonHamburgerMenuPage clickHamberger()
	{
		click(linkHamburger, "LinkHamburger");
 		return new AmazonHamburgerMenuPage();
	}
	
}
