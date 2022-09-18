package com.cs.driver;

import java.util.Objects;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.cs.enums.ConfigProperties;
import com.cs.utils.DisplayLogUtils;
import com.cs.utils.PropertyUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public final class Driver {

	private Driver() {}

	public static void initDriver(String browser)  
	{
		if (Objects.isNull(DriverManager.getDriver()))
		{
			if(browser.equalsIgnoreCase("chrome"))
			{
//				System.setProperty("webdriver.chrome.driver",FrameworkConstants.getChromeDriverPath());
				WebDriverManager.chromedriver().setup();
				DriverManager.setDriver(new ChromeDriver());
			} else if(browser.equalsIgnoreCase("firefox"))
			{
//				System.setProperty("webdriver.gecko.driver",FrameworkConstants.getFirefoxDriverPath());
				WebDriverManager.firefoxdriver().setup();
				DriverManager.setDriver(new FirefoxDriver());
			} else if(browser.equalsIgnoreCase("edge"))
			{
//				System.setProperty("webdriver.edge.driver",FrameworkConstants.getEdgeDriverPath());
				WebDriverManager.edgedriver().setup();
				DriverManager.setDriver(new EdgeDriver());
			}  
			// will display to console when debug = yes
			DisplayLogUtils.displayLog(browser + " browser launched !");
 			DisplayLogUtils.displaySimpleLog(browser + " browser launched !");
 

			// since extentTesst is not yet declared,we can not use ExtentManager.getExtent() used in ExtentLogger class
 			// ExtentManager.getExtent() is defined in OnTestStart() method from ListnerClass
			// ExtentLogger.pass(browser + " browser launched", true);
			
			//DriverManager.getDriver().get(ReadPropertyFile.getValue("url"));
 			DriverManager.getDriver().get(PropertyUtils.getValue(ConfigProperties.URL));
		}
	}

	public static void quitDriver()
	{
		if(Objects.nonNull(DriverManager.getDriver()))
		{
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}
	}	
}
