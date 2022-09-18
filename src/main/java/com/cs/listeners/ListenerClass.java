package com.cs.listeners;

import java.util.Arrays;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.cs.annotations.FrameworkAnnotation;
import com.cs.reports.ExtentLogger;
import com.cs.reports.ExtentReport;
import com.cs.utils.DisplayLogUtils;

public class ListenerClass implements ITestListener, ISuiteListener{

	public static int executionOrdercounter = 1;
	

	@Override   
	public void onStart(ISuite suite) // from ISuiteListener
	{
	
		System.out.println("Begin of ListenerClass.onStart --> " + ListenerClass.executionOrdercounter++);
		
//		DisplayLogUtils.displayLog("Begin of ListenerClass.onStart --> " + ListenerClass.executionOrdercounter++);

 		ExtentReport.initReports();
		
 		DisplayLogUtils.displayLog("End of ListenerClass.onStart --> " + ListenerClass.executionOrdercounter);

	}
	
	@Override
	public void onFinish(ISuite suite)
	{
		DisplayLogUtils.displayLog("Begin Order ListenerClass.onFinish --> " + ListenerClass.executionOrdercounter++);

		ExtentReport.flushReports();
		
		DisplayLogUtils.displayLog("End Order ListenerClass.onFinish --> " + ListenerClass.executionOrdercounter);
	}
	
	@Override
	public void onTestStart(ITestResult result)
	{
		DisplayLogUtils.displaySimpleLog("testname: " + result.getMethod().getMethodName());
	
		DisplayLogUtils.displayLog("Begin of ListenerClass.onTestStart --> " + ListenerClass.executionOrdercounter++);
	
		DisplayLogUtils.displayLog("Begin of ListenerClass.onTestStart.createTest --> " + ListenerClass.executionOrdercounter++);
		ExtentReport.createTest(result.getMethod().getMethodName() + " => " + result.getMethod().getDescription());

		// Assign author and category
		ExtentReport.addAuthors(result.getMethod().getConstructorOrMethod()
				.getMethod().getAnnotation(FrameworkAnnotation.class).author());
		ExtentReport.addCategories(result.getMethod().getConstructorOrMethod()
				.getMethod().getAnnotation(FrameworkAnnotation.class).category());
		
		DisplayLogUtils.displayLog("End of ListenerClass.onTestStart --> " + ListenerClass.executionOrdercounter);

	}
	
	@Override
	public void onTestSuccess(ITestResult result)
	{
		DisplayLogUtils.displayLog("Begin of ListenerClass .onTestSuccess--> " + ListenerClass.executionOrdercounter++);
		ExtentLogger.pass(result.getMethod().getMethodName() + " is passed");
		DisplayLogUtils.displayLog("End of ListenerClass onTestSuccess");

	}
	@Override
	public void onTestFailure(ITestResult result)
	{
		DisplayLogUtils.displayLog("Begin of ListenerClass.onTestFailure--> "+ ListenerClass.executionOrdercounter++);

			ExtentLogger.fail(result.getMethod().getMethodName() + " is failed", true);
			ExtentLogger.fail(result.getThrowable().toString()); //first line of a stack trace is displayed
			ExtentLogger.fail(Arrays.toString(result.getThrowable().getStackTrace())); /// complete stack trace
			DisplayLogUtils.displayLog("End of ListenerClass.onTestFailure-->");
		DisplayLogUtils.displayLog("End of ListenerClass.onTestFailure-->");
	}
	
	@Override
	public void onTestSkipped(ITestResult result)
	{
		DisplayLogUtils.displayLog("Being Order ListenerClass.onTestSkipped--> "+ ListenerClass.executionOrdercounter++);
		ExtentLogger.skip(result.getMethod().getMethodName()+ " is skipped");
		DisplayLogUtils.displayLog("End Order ListenerClass.onTestSkipped--> ");
	}
		
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result)
	{           
		// this method does not make
	}

	// onStart, onFinish of ITestLister will be executed before/after of <Test> tag from testng.xml
	@Override
	public void onStart(ITestContext context)  // from ITestListener
	{
		// not using this method currently. this onStart method will be called
		// based on test tag from testng.xml.
		// this OnStart method will be called as many time as test tag is present in testng.xml
		
	}
	
	@Override
	public void onFinish(ITestContext context)  // from ITestListener
	{
		// not using this method currently. this onFinish method will be 
		// called
		// based on test tag from testng.xml.
		// this OnFinish method will be called as many time as test tag is 
		// present in testng.xml
		
	}
	
}
