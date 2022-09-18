package com.cs.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.cs.enums.ConfigProperties;
import com.cs.utils.DisplayLogUtils;
import com.cs.utils.PropertyUtils;

public class RetryFailedTests implements IRetryAnalyzer {

	private int retries =  Integer.parseInt(PropertyUtils.getValue(ConfigProperties.RETRYFAILEDTESTSCOUNT));
	private int count   = 0;

	@Override
	public boolean retry(ITestResult result) {
		boolean value = false;
		DisplayLogUtils.displayLog("Begin of RetryFailedTests.retry--> "+ ListenerClass.executionOrdercounter++);

		if(PropertyUtils.getValue(ConfigProperties.RETRYFAILEDTESTS).equalsIgnoreCase("yes"))
			value = (count++ < retries);

		DisplayLogUtils.displayLog("End of RetryFailedTests.retry() --> ");

		return value ;
	}

}
