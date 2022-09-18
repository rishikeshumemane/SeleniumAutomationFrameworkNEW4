package com.cs.factories;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cs.constants.FrameworkConstants;
import com.cs.driver.DriverManager;
import com.cs.enums.LocatorName;
import com.cs.exceptions.ElementNotFoundException;
import com.cs.listeners.ListenerClass;
import com.cs.pages.BasePage;
import com.cs.utils.DisplayLogUtils;

public final class ExpliciteWaitFactory {

	private ExpliciteWaitFactory () {}

	public static WebElement performExplicitWaitForElement(String locatorValue, LocatorName locatorType)
	{
		DisplayLogUtils.displayLog("Begin Order ExpliciteWaitFactory --> " + ListenerClass.executionOrdercounter++);
		
		By locatorNewValue =  BasePage.getLocator(locatorValue, locatorType);
		boolean exception1Flag = false;
		boolean exception2Flag = false;
		WebElement ele1 = null;
		WebElement ele2 = null;
		WebElement element = null;
		try {
			ele1 =  new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitwait())
							.until(ExpectedConditions.presenceOfElementLocated(locatorNewValue));
		} catch(Exception e) {
				exception1Flag = true;
		}
		
		try {
			ele2 =  new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitwait())
							.until(ExpectedConditions.visibilityOfElementLocated(locatorNewValue));
		} catch(Exception e){
			exception2Flag = true;
		}
		
		if ( (exception1Flag) && (exception2Flag))
			throw new ElementNotFoundException("Element not found for locator Value: " + locatorValue + " with locator Type:" + locatorType);
		if (ele1 != null) //ele1 found
			element = ele1;
		else if (ele2 != null) //ele2 found
			element = ele2;
	
		DisplayLogUtils.displayLog("End Order ExpliciteWaitFactory --> ");
		return element;
	}
	
	public static WebElement performExplicitWaitForElement(By by)
	{
		DisplayLogUtils.displayLog("Begin Order ExpliciteWaitFactory --> " + ListenerClass.executionOrdercounter++);
 
		boolean exception1Flag = false;
		boolean exception2Flag = false;
		WebElement ele1 = null;
		WebElement ele2 = null;
		WebElement element = null;
		try {
			ele1 =  new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitwait())
							.until(ExpectedConditions.presenceOfElementLocated(by));
		} catch(Exception e) {
				exception1Flag = true;
		}
		
		try {
			ele2 =  new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitwait())
							.until(ExpectedConditions.visibilityOfElementLocated(by));
		} catch(Exception e){
			exception2Flag = true;
		}
		
		if ( (exception1Flag) && (exception2Flag))
			throw new ElementNotFoundException("Element not found for by locator : " + by);
		if (ele1 != null) //ele1 found
			element = ele1;
		else if (ele2 != null) //ele2 found
			element = ele2;

		DisplayLogUtils.displayLog("End Order ExpliciteWaitFactory --> ");

		return element;
	}

/* original method
	public static WebElement performExplicitWait(By by, WaitStrategy waitStrategy)
	{
		DisplayLogUtils.displayLog("Begin Order ExpliciteWaitFactory --> " + ListenerClass.executionOrdercounter++);
		WebElement element = null;
		if (waitStrategy == WaitStrategy.CLICKABLE)
		{
			element = new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitwait())
					.until(ExpectedConditions.elementToBeClickable(by));
		}
		else if (waitStrategy == WaitStrategy.PRESENCE)
		{
			element = new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitwait())
					.until(ExpectedConditions.presenceOfElementLocated(by));
		}
		else if (waitStrategy == WaitStrategy.VISIBLE)
		{
			element = new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitwait())
					.until(ExpectedConditions.visibilityOfElementLocated(by));
		}
		DisplayLogUtils.displayLog("End Order ExpliciteWaitFactory --> ");

		return element;
	}
*/
	
	public static WebElement performExplicitWaitForElement(WebElement we)
	{
 		DisplayLogUtils.displayLog("Begin Order performExplicitWait --> " +ListenerClass.executionOrdercounter++);

 		boolean exception1Flag = false;
		boolean exception2Flag = false;
		WebElement ele1 = null;
		WebElement ele2 = null;
		WebElement element = null;
		try {
			ele1 =  new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitwait())
							.until(ExpectedConditions.elementToBeClickable(we));
		} catch(Exception e) {
				exception1Flag = true;
		}
		
		try {
			ele2 =  new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitwait())
							.until(ExpectedConditions.visibilityOf(we));
		} catch(Exception e){
			exception2Flag = true;
		}
		
		if ( (exception1Flag) && (exception2Flag))
			throw new ElementNotFoundException("Element not found for  webelement : " + we);
		if (ele1 != null) //ele1 found
			element = ele1;
		else if (ele2 != null) //ele2 found
			element = ele2;

		DisplayLogUtils.displayLog("End Order performExplicitWait --> ");

		return element;
	}
 
	// get list of web elements using String  locatorValue and locatorType parameter
	public static List<WebElement> performExplicitWaitForElements(String locatorValue, LocatorName locatorType)
	{
		DisplayLogUtils.displayLog("Begin Order ExpliciteWaitFactory -->performExplicitWaitForElements() " + ListenerClass.executionOrdercounter++);
	
		boolean exception1Flag = false;
		boolean exception2Flag = false;
		List<WebElement> ele1 = null;
		List<WebElement> ele2 = null;
		List<WebElement> elements = null;
		By locatorNewValue =  BasePage.getLocator(locatorValue, locatorType);
		try {
			ele1 = new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitwait())
						.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locatorNewValue));
		} catch(Exception e) {
				exception1Flag = true;
		}
		
		try {
			ele2 = new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitwait())
						.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locatorNewValue));
		} catch(Exception e){
			exception2Flag = true;
		}
		
		if ( (exception1Flag) && (exception2Flag))
			throw new ElementNotFoundException("Element not found for by locator value : " + locatorValue + " with locatorType: " + locatorType);
		if (ele1 != null) //ele1 found
			elements = ele1;
		else if (ele2 != null) //ele2 found
			elements = ele2;

		DisplayLogUtils.displayLog("End Order ExpliciteWaitFactory --> performExplicitWaitForElements() ");

		return elements;
	}
	
	// get list of web elements using By parameter
	public static List<WebElement> performExplicitWaitForElements(By by)
	{
		DisplayLogUtils.displayLog("Begin Order ExpliciteWaitFactory --> performExplicitWaitForElements()" + ListenerClass.executionOrdercounter++);
		boolean exception1Flag = false;
		boolean exception2Flag = false;
		List<WebElement> ele1 = null;
		List<WebElement> ele2 = null;
		List<WebElement> elements = null;
 		try {
			ele1 = new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitwait())
						.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
		} catch(Exception e) {
				exception1Flag = true;
		}
		
		try {
			ele2 = new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitwait())
						.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
		} catch(Exception e){
			exception2Flag = true;
		}
		
		if ( (exception1Flag) && (exception2Flag))
			throw new ElementNotFoundException("Element not found for by-locator: " + by);
		if (ele1 != null) //ele1 found
			elements = ele1;
		else if (ele2 != null) //ele2 found
			elements = ele2;

		DisplayLogUtils.displayLog("End Order ExpliciteWaitFactory.performExplicitWaitForElements --> ");

		return elements;
	}
}
