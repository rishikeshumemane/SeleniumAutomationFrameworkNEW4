package com.cs.listeners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import com.cs.utils.DataProviderUtils;
import com.cs.utils.DisplayLogUtils;

public class AnnotationTransformer implements IAnnotationTransformer
{

	@Override
	public void transform(ITestAnnotation annotation, 
			Class testClass, Constructor testConstructor, Method testMethod) {

 		DisplayLogUtils.displayLog("Begin of AnnotationTransformer --> " + ListenerClass.executionOrdercounter++);
		annotation.setDataProvider("getData");
		annotation.setRetryAnalyzer(RetryFailedTests.class);
		annotation.setDataProviderClass(DataProviderUtils.class);

 		DisplayLogUtils.displayLog("End of AnnotationTransformer --> " +ListenerClass.executionOrdercounter);

	}


}
