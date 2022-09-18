package com.cs.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.cs.driver.DriverManager;
import com.cs.enums.LocatorName;
import com.cs.exceptions.InvalidLocatorException;
import com.cs.factories.ExpliciteWaitFactory;
import com.cs.listeners.ListenerClass;
import com.cs.reports.ExtentLogger;
import com.cs.utils.DisplayLogUtils;
import com.google.common.util.concurrent.Uninterruptibles;


// contains utilty functions/methods
public class BasePage {

	// Name filed header is present or not
	private final static By isFieldPresentBy = By.xpath("//*[@id='app']//div[3]/div/div[1]/div/div[2]");
	private final static By isFlashedMsgFieldPresentBy = By.xpath("//*[@id='oxd-toaster_1']//p[2]");

	protected void verifyTrue(boolean result, String errorMsg, String reportMsg)
	{
		Assertions.assertThat(result)
				.as(errorMsg).isTrue();
		ExtentLogger.pass(reportMsg);
	}
	
	/*
	 * protected void verifyMsg(String expSuccessfulMsg, String actSuccessfulMsg,
	 * String reportMsg) { Assertions.assertThat(actSuccessfulMsg) .as("ERROR=> " +
	 * "Expected message: '" + expSuccessfulMsg + "' and found '" + actSuccessfulMsg
	 * + "'") .isEqualTo(expSuccessfulMsg ); ExtentLogger.pass("VERIFICATION=> "+
	 * reportMsg); }
	 * 
	 * protected void verifyMsg(String expSuccessfulMsg, String actSuccessfulMsg,
	 * String errorMsg, String reportMsg) { Assertions.assertThat(actSuccessfulMsg)
	 * .as(errorMsg) .isEqualTo(expSuccessfulMsg );
	 * ExtentLogger.pass("VERIFICATION=> "+ reportMsg); }
	 */	
	protected String getAttribute(By by, String attributeName)
	{
		DisplayLogUtils.displayLog("Begin of BasePage.getAttribute() ->" + ListenerClass.executionOrdercounter++);
		WebElement element = ExpliciteWaitFactory.performExplicitWaitForElement(by);
		DisplayLogUtils.displayLog("End of BasePage.getAttribute() ->" + ListenerClass.executionOrdercounter);
		return element.getAttribute(attributeName);

	}
	
	protected boolean getCheckboxStatus(By by)
	{
		DisplayLogUtils.displayLog("Begin of BasePage.getCheckboxStatus() ->" + ListenerClass.executionOrdercounter++);
		WebElement element = ExpliciteWaitFactory.performExplicitWaitForElement(by);
		DisplayLogUtils.displayLog("End of  BasePage.getCheckboxStatus() ->" + ListenerClass.executionOrdercounter);

		return element.isSelected();
	}
	
	
	// check from which all classes this method is being called 
	protected boolean getCheckboxStatusUsingStringLocator(String byString, LocatorName locatorType) 
	{
		DisplayLogUtils.displayLog("Begin of BasePage.getCheckboxStatusUsingStringLocator() ->" +
				ListenerClass.executionOrdercounter++);
		WebElement element = ExpliciteWaitFactory.performExplicitWaitForElement(byString, locatorType);   // changed from by to By.xpath(by) , need to pass locatorValue, Locator type later
		DisplayLogUtils.displayLog("End of  BasePage.getCheckboxStatusUsingStringLocator() ->" +
			ListenerClass.executionOrdercounter); return element.isSelected(); 
	} 
	
	
	// select month from drop down list
	protected void selectMonthNo(By calendarMonth, int monthNo) 
	{
		DisplayLogUtils.displayLog("Begin of BasePage.selectMonthNo() ->" +
				ListenerClass.executionOrdercounter++);
		WebElement elementSelect = ExpliciteWaitFactory.performExplicitWaitForElement(calendarMonth);
		selectByValue(elementSelect, (monthNo-1));
		DisplayLogUtils.displayLog("End of  BasePage.selectMonthNo() ->" +
			ListenerClass.executionOrdercounter); 
	}
	
	// select month from drop down list
	protected void selectMonthName(By calendarMonth, String monthName) 
	{
		DisplayLogUtils.displayLog("Begin of BasePage.selectMonthName() ->" + ListenerClass.executionOrdercounter++);
		WebElement elementSelect = ExpliciteWaitFactory.performExplicitWaitForElement(calendarMonth);
		selectByText(elementSelect, monthName);
		DisplayLogUtils.displayLog("End of  BasePage.selectMonthName() ->" + ListenerClass.executionOrdercounter); 
	}
	
	// select year from drop down list
		protected void selectYearNo(By calendarYear, int yearNo) 
		{
			DisplayLogUtils.displayLog("Begin of BasePage.selectYearNo() ->" + ListenerClass.executionOrdercounter++);
			WebElement elementSelect = ExpliciteWaitFactory.performExplicitWaitForElement(calendarYear);
			selectByValue(elementSelect, yearNo);
			DisplayLogUtils.displayLog("End of  BasePage.selectYearNo() ->" + ListenerClass.executionOrdercounter); 
		}
// select year from drop down list
		protected void selectYearName(By calendarYear, String yearName) 
		{
			DisplayLogUtils.displayLog("Begin of BasePage.selectYearName() ->" + ListenerClass.executionOrdercounter++);
			WebElement elementSelect = ExpliciteWaitFactory.performExplicitWaitForElement(calendarYear);
			selectByText(elementSelect, yearName);
			DisplayLogUtils.displayLog("End of  BasePage.selectYearName() ->" + ListenerClass.executionOrdercounter); 
		}
				
		// select day from drop down list
		protected void selectDayNo(String calendarDay, LocatorName locatorType, int dayNo) 
		{
			DisplayLogUtils.displayLog("Begin of BasePage.selectDayNo() ->" + ListenerClass.executionOrdercounter++);
			WebElement elementSelect = ExpliciteWaitFactory.performExplicitWaitForElement(calendarDay, locatorType);
			click(elementSelect, "Day Field");
			DisplayLogUtils.displayLog("End of  BasePage.selectNoDay() ->" + ListenerClass.executionOrdercounter); 
		}	
	protected static void  selectByValue(WebElement elementSelect, int no)
	{
		DisplayLogUtils.displaySimpleLog("selectByValue: ===> "+ no);
		Select ele = new Select (elementSelect);
		ele.selectByValue(String.valueOf(no));
		DisplayLogUtils.displaySimpleLog("selected Value: ===> "+ String.valueOf(no));
	}

	// overloaded selectByText method accepts WebElement and text
	protected static void  selectByText(WebElement elementSelect, String text)
	{
		DisplayLogUtils.displaySimpleLog("selectByText: ===> "+ text);
		Select ele = new Select (elementSelect);
		ele.selectByVisibleText(text);
		DisplayLogUtils.displaySimpleLog("selected text: ===> " + text);
	}	
	// overloaded selectByText method accepts by and text
	protected static void  selectByText(By by, String text,String elementName)
	{
		DisplayLogUtils.displaySimpleLog("selectByText: ===> "+ text);
		Select ele = new Select (ExpliciteWaitFactory.performExplicitWaitForElement(by));
		while (true) {
			Uninterruptibles.sleepUninterruptibly(Duration.ofMillis(500));
			DisplayLogUtils.displaySimpleLog("selectByText: waiting to get options loaded in dropdown list");			
			if (!ele.getOptions().isEmpty())
				break;
		}
		DisplayLogUtils.displaySimpleLog("selectByText ele webelement found ***********************");
		
		ele.selectByVisibleText(text);
		ExtentLogger.pass("'" + text + "'" + " selected successfully in " + "'" + elementName + "' field" , true);

		DisplayLogUtils.displaySimpleLog("selected text: ===> " + text);
	}	
	
 	protected static void click(By by, String elementName)
	{
		DisplayLogUtils.displayLog("Begin of BasePage.click() ->" + ListenerClass.executionOrdercounter++);
		
		WebElement element = ExpliciteWaitFactory.performExplicitWaitForElement(by);
		try
		{
			element.click();
		} catch(Exception  e)
		{
			ExtentLogger.pass("'" + elementName + "'" + " COULD  NOT clicked", true);
		}
		try {
			ExtentLogger.pass("'" + elementName + "'" + " is clicked", true);
		} catch (Exception e) {
			DisplayLogUtils.displayLog("CATCH End of BasePage.click() ->" + ListenerClass.executionOrdercounter);
 			e.printStackTrace();
		}
	}
 
	
	protected void click(WebElement element, String elementName)
	{
		DisplayLogUtils.displayLog("Begin of BasePage.click() ->" + ListenerClass.executionOrdercounter++);

		WebElement element1 = ExpliciteWaitFactory.performExplicitWaitForElement(element);
		element1.click();
		try {
			ExtentLogger.pass("'" + elementName + "'" + " is clicked", true);
			DisplayLogUtils.displayLog("End of BasePage.click() ->" + ListenerClass.executionOrdercounter);

		} catch (Exception e) {
			DisplayLogUtils.displayLog("CatchBlock=> End of BasePage.click() ->" + ListenerClass.executionOrdercounter);

 			e.printStackTrace();
		}
	}
		
	
	protected static void sendKeys(By by, String value, String elementName)
	{
		DisplayLogUtils.displayLog("Begin of BasePage.sendKeys() ->" + ListenerClass.executionOrdercounter++);

		WebElement element = ExpliciteWaitFactory.performExplicitWaitForElement(by);
		element.sendKeys(value);
		try {
			ExtentLogger.pass("'" + value + "'" + " is entered successfully in " + "'" + elementName + "' field" , true);
			DisplayLogUtils.displayLog("End of BasePage.sendKeys() ->" + ListenerClass.executionOrdercounter);

		} catch (Exception e) {
 			e.printStackTrace();
 			DisplayLogUtils.displayLog("CatchBlock -> End of BasePage.sendKeys() ->" + ListenerClass.executionOrdercounter);
		}
	}
	
	protected static void sendKeys(By by, String value, String elementName, By listBy)
	{
		DisplayLogUtils.displayLog("Begin of BasePage.sendKeys() ->" + ListenerClass.executionOrdercounter++);

		WebElement element = ExpliciteWaitFactory.performExplicitWaitForElement(by);
		element.sendKeys(value);
		click(listBy, "EmployeeName List");
//		DriverManager.getDriver().findElement(By.xpath("//ul/li/strong")).click();
		try {
			ExtentLogger.pass("'" + value + "'" + " is entered successfully in " + "'" + elementName + "' field" , true);
			DisplayLogUtils.displayLog("End of BasePage.sendKeys() ->" + ListenerClass.executionOrdercounter);

		} catch (Exception e) {
 			e.printStackTrace();
 			DisplayLogUtils.displayLog("CatchBlock -> End of BasePage.sendKeys() ->" + ListenerClass.executionOrdercounter);
		}
	}
	protected String getPageTitle()
	{
		DisplayLogUtils.displayLog("Begin&End of BasePage.getPageTitle() ->" + ListenerClass.executionOrdercounter++);

		return DriverManager.getDriver().getTitle();
	}
	
	
	
	protected void mouseOver(By by)
	{
		DisplayLogUtils.displayLog("Begin of BasePage.mouseOver() ->" + ListenerClass.executionOrdercounter++);

		Actions action     = new Actions(DriverManager.getDriver());
		WebElement element = ExpliciteWaitFactory.performExplicitWaitForElement(by);
		action.moveToElement(element).build().perform();
		DisplayLogUtils.displayLog("End of BasePage.mouseOver() ->" + ListenerClass.executionOrdercounter);

	}
	
	
	protected String getText(By by)
	{
		DisplayLogUtils.displayLog("Begin of BasePage.getText() ->" + ListenerClass.executionOrdercounter++);

		WebElement element = ExpliciteWaitFactory.performExplicitWaitForElement(by);
		DisplayLogUtils.displayLog("End of BasePage.getText() ->" + ListenerClass.executionOrdercounter);

		return element.getText();
	}
	
	protected String getLabel(By by)
	{
		DisplayLogUtils.displayLog("Begin of BasePage.getLabel() ->" + ListenerClass.executionOrdercounter++);

		WebElement element = ExpliciteWaitFactory.performExplicitWaitForElement(by);
		// to check if this works for label, need to check which method to use instead of getText here
		DisplayLogUtils.displayLog("End of BasePage.getLabel() ->" + ListenerClass.executionOrdercounter);

		return element.getText();
	}
	
	protected void displayText(String txt, String value)
	{
		DisplayLogUtils.displayLog("Begin of BasePage.displayText() ->" + ListenerClass.executionOrdercounter++);

		DisplayLogUtils.displayLog(txt +  value);
		DisplayLogUtils.displayLog("End of BasePage.displayText() ->" + ListenerClass.executionOrdercounter);

		
	}
	
	
	protected void clear(By by)
	{
		DisplayLogUtils.displayLog("Begin of BasePage.clear() ->" + ListenerClass.executionOrdercounter++);

		WebElement element = ExpliciteWaitFactory.performExplicitWaitForElement(by);
		element.clear();
		DisplayLogUtils.displayLog("End of BasePage.clear() ->" + ListenerClass.executionOrdercounter);

	}
	
	protected List<Boolean> getAllCheckboxStatus(String xpathString, LocatorName locatorType)
	{
		DisplayLogUtils.displayLog("Begin of BasePage.getAllCheckboxStatus() ->" + ListenerClass.executionOrdercounter++);

		List<Boolean> checboxStatusList = new ArrayList<>();
		String newXpathString = xpathString.replace("[REPLACE]", "");
		
		int totalNoOfCheckboxes = DriverManager.getDriver().findElements(By.xpath(newXpathString)).size();
		DisplayLogUtils.displayLog("totalNoOfCheckboxes: " +totalNoOfCheckboxes);
		for(int i=1;i<=totalNoOfCheckboxes;i++)   
		{
			xpathString = xpathString.replace("REPLACE", String.valueOf(i));
			boolean result= getCheckboxStatusUsingStringLocator(xpathString, locatorType);
			DisplayLogUtils.displayLog("result:"+result);
			checboxStatusList.add(result);
		}	
		DisplayLogUtils.displayLog("checboxStatusList: " + checboxStatusList);
		
		DisplayLogUtils.displayLog("End of BasePage.getAllCheckboxStatus() ->" + ListenerClass.executionOrdercounter);
		return checboxStatusList;
	}

	
	
	
	// For Radio buttons : used LocatorName enum
	// 2 main methods 
	// 1. click radio button using By parameter, WebElement parameter, and using String locatorValue and String locatorType parameter
	// 2. getStatus for radio button using By parameter, WebElement parameter, and using String locatorValue and String locatorType parameter
	
	// click using By parameter
	void clickRadioButton(By by)
	{
		WebElement btnRb = ExpliciteWaitFactory.performExplicitWaitForElement(by);
		btnRb.click();
	}
	// click using WebElement parameter
	void clickRadioButton(WebElement we)
	{
		we.click();
	}	
	// click using String LocatorValue and String LocatorTpye parameter
	void clickRadioButton(String locatorValue, LocatorName locatorType)
	{
		By newLocator = null;
		newLocator = getLocator(locatorValue, locatorType);
		WebElement btnRb = ExpliciteWaitFactory.performExplicitWaitForElement(newLocator);
		btnRb.click();
	}
	
	// get Radio button status using By parameter
	boolean getRadioButtonStatus(By by)
	{
		WebElement btnRb = ExpliciteWaitFactory.performExplicitWaitForElement(by);
		return btnRb.isSelected();
	}
	// get Radio button status using WebElement parameter
	boolean getRadioButtonStatus(WebElement we)
	{
		return we.isSelected();
	}	
	// get Radio button status using String locatorValue and String locatorType parameter
	boolean getRadioButtonStatus(String locatorValue, LocatorName locatorType)
	{
		By newLocator = null;
		newLocator = getLocator(locatorValue, locatorType);
		WebElement btnRb = ExpliciteWaitFactory.performExplicitWaitForElement(newLocator);
		return btnRb.isSelected();
	}
	
	// generic method: get By locator  using String locatorValue and String locatorType
	public static By getLocator(String locatorValue, LocatorName locatorType)
	{
		By newLocator = null;
	//	convert from enum to string or value
	//	LocatorName ln = LocatorName.valueOf(locatorType);
		
		switch(locatorType)
		{
		case XPATH:
			newLocator = By.xpath(locatorValue);
			break;
		case CSS:
			newLocator = By.cssSelector(locatorValue);
			break;
		case ID:
			newLocator = By.id(locatorValue);
			break;
		case NAME:
			newLocator = By.name(locatorValue);
			break;
		case CLASSNAME:
			newLocator = By.className(locatorValue);
			break;
		case TAGNAME:
			newLocator = By.tagName(locatorValue);
			break;
		case LINKTEXT:
			newLocator = By.tagName(locatorValue);
			break;
		case PARTIALLINKTEXT:
			newLocator = By.tagName(locatorValue);
		default:
			throw new InvalidLocatorException("ERROR=> " + locatorType + " is invalid");
		}
		return newLocator;
	}
	
	
	
	
	 // get list of webelements methods
	List<WebElement> getListOfWebElements(By by)
	{
		return ExpliciteWaitFactory.performExplicitWaitForElements(by);
	}
	
	// does not work with any subBy except tagName. Seleniumd finds elements within element using tagName only, please do not use this  method unless subBy is tagName
	List<WebElement> getListOfWebElements(WebElement we, By subBy )
	{
			// todo 
		return null;

	}
	
	List<WebElement> getListOfWebElements(String  locatorValue, LocatorName locatorType)
	{
		By newLocator = getLocator(locatorValue, locatorType);
		return ExpliciteWaitFactory.performExplicitWaitForElements(newLocator);
	}

	// get checkbox status using By parameter
	boolean getChecBoxStatus(By by)
	{
		WebElement checkBox = ExpliciteWaitFactory.performExplicitWaitForElement(by);
		return checkBox.isSelected();
	}
	
	protected void jsClick(By element, String elementName)
	{
		DisplayLogUtils.displayLog("Begin of BasePage.jsClick() ->" + ListenerClass.executionOrdercounter++);

	//	WebElement element1 = ExpliciteWaitFactory.performExplicitWaitForElement(element);
	     JavascriptExecutor js = ((JavascriptExecutor) DriverManager.getDriver());
		js.executeScript("arguments[0].click();", DriverManager.getDriver().findElement(element));
			
		try {
			ExtentLogger.pass("'" + elementName + "'" + " is clicked using jsClick()", true);
			DisplayLogUtils.displayLog("End of BasePage.jsClick() ->" + ListenerClass.executionOrdercounter);

		} catch (Exception e) {
			DisplayLogUtils.displayLog("CatchBlock=> End of BasePage.jsClick() ->" + ListenerClass.executionOrdercounter);

 			e.printStackTrace();
		}
	}
	public static boolean waitUntilElementIsDisplayed()
	{
		DisplayLogUtils.displayLog("Begin&End of CustomerHomePage.checkIfFieldIsPresent() ->" + ListenerClass.executionOrdercounter++);
		WebElement element = ExpliciteWaitFactory.performExplicitWaitForElement(isFieldPresentBy);
		if (element != null)
			return true;
		else
			return false;
	}	
	
	public static boolean waitUntilSavedSuccessfullyMsgDisplayed()
	{
		DisplayLogUtils.displayLog("Begin&End of CustomerHomePage.waitUntilSavedSuccessfullyMsgDisplayed() ->" + ListenerClass.executionOrdercounter++);
		WebElement element = ExpliciteWaitFactory.performExplicitWaitForElement(isFlashedMsgFieldPresentBy);
		if (element != null)
			return true;
		else
			return false;
	}	
}