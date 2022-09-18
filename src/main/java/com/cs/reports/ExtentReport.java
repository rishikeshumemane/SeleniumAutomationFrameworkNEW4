package com.cs.reports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.cs.constants.FrameworkConstants;
import com.cs.enums.AuthorType;
import com.cs.enums.CategoryType;
import com.cs.listeners.ListenerClass;
import com.cs.utils.DisplayLogUtils;

public final class ExtentReport {

	private ExtentReport() {}

	public static ExtentReports extent;
 	
	public static void initReports()  
	{
		DisplayLogUtils.displayLog("Begin of ExtentReport.initReports() ->" + ListenerClass.executionOrdercounter++);

		if(Objects.isNull(extent))
		{
			extent = new ExtentReports();
			ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstants.getExtentReportFilePath());
			extent.attachReporter(spark);
			spark.config().setTheme(Theme.DARK);
			spark.config().setDocumentTitle("DocumentTitle: OrangeCRM Automation Test Suite Report");
			spark.config().setReportName("ReportName: Orange HRM CRM Report");
		}
		DisplayLogUtils.displayLog("End of ExtentReport.initReports() ->" + ListenerClass.executionOrdercounter);

	}

	public static void flushReports()  
	{
		
		DisplayLogUtils.displayLog("Begin  of ExtentReport.flushReports() ->" + ListenerClass.executionOrdercounter++);

		if(Objects.nonNull(extent))
			extent.flush();
		ExtentManager.unload();

		DisplayLogUtils.displayLog("End  of ExtentReport.flushReports() ->" + ListenerClass.executionOrdercounter);

		try {
			Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentReportFilePath()).toURI());
		} catch (IOException e) {
			System.out.println("ERROR=> Can not open extent report in browser !");
			e.printStackTrace();
		}

	}

	public static void createTest(String testCaseName)
	{
		DisplayLogUtils.displayLog("Begin of ExtentReport.createTest() ->" + ListenerClass.executionOrdercounter++);

		ExtentTest test = extent.createTest(testCaseName);
		ExtentManager.setExtentTest(test);
		System.out.println("ExtentManager.setExtentTest is set here");

		DisplayLogUtils.displayLog("End of ExtentReport.createTest() ->" + ListenerClass.executionOrdercounter);
	}
	
	public static void addAuthors(AuthorType[] authors)
	{
		for(AuthorType author : authors)
			ExtentManager.getExtentTest().assignAuthor(author.toString());
	}

	public static void addCategories(CategoryType[] categories)
	{
		for(CategoryType category: categories)
			ExtentManager.getExtentTest().assignCategory(category.toString());
	}
	
}
