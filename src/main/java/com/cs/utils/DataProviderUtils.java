package com.cs.utils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;

import com.cs.constants.FrameworkConstants;
import com.cs.listeners.ListenerClass;

public class DataProviderUtils {

	private static List<Map<String, String>> list = new ArrayList<>();
	
	@DataProvider
	public static Object[] getData(Method m)
	{
		DisplayLogUtils.displayLog("Begin of DataProviderUtils.getData() ->" + ListenerClass.executionOrdercounter++);

		
  		String testCaseName = m.getName();
 		if (list.isEmpty())
 			list = ExcelUtils.getTestDetails(FrameworkConstants.getIterationDataSheet());  // test data sheet to read
 
 		List<Map<String, String>> smallList = new ArrayList<>();
		
		for(int i=0;i<list.size();i++)
		{
			if (list.get(i).get("testname").equalsIgnoreCase(testCaseName)
					&& list.get(i).get("execute").equalsIgnoreCase(FrameworkConstants.getYes()))
				{
					smallList.add(list.get(i));
				}
		}
		  
		for(Map<String,String> dataMap : smallList)
			DisplayLogUtils.displayLog("data Map: " + 
					dataMap.get("testname")  +  "  = > " +
					dataMap.get("execute")    +  "  = > " +
					dataMap.get("browser")   +  "  = > " +
					dataMap.get("username") +  "  = > " +
					dataMap.get("password")  +  "  = > " +
					dataMap.get("fname")      +  "  = > " +
					dataMap.get("menutext")  +  "  = > " +
					dataMap.get("submenutext"));
		
		DisplayLogUtils.displayLog("End of DataProviderUtils.getData() ->" + ListenerClass.executionOrdercounter);

		return smallList.toArray();
	}
	
}
