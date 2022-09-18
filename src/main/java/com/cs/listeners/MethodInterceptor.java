package com.cs.listeners;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import com.cs.constants.FrameworkConstants;
import com.cs.utils.DisplayLogUtils;
import com.cs.utils.ExcelUtils;

public class MethodInterceptor implements IMethodInterceptor{


	@Override
	public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {

		DisplayLogUtils.displayLog("Begin of MethodInterceptor.intercept--> "+ ListenerClass.executionOrdercounter++);

		List<Map<String, String>> list  = ExcelUtils.getTestDetails(FrameworkConstants.getRunmanagerSheet());  // test cases from excel
		List<IMethodInstance> result    = new ArrayList<>();  // test cases to run based on execute flag set in excel
		
		for(int i=0; i<methods.size();i++)
		{
			for(int j=0;j<list.size();j++)
			{
				if (methods.get(i).getMethod().getMethodName().equalsIgnoreCase(list.get(j).get("testname")))
				{
					if (list.get(j).get("execute").equalsIgnoreCase("yes"))
					{
						methods.get(i).getMethod().setDescription(list.get(j).get("testdescription"));
						methods.get(i).getMethod().setInvocationCount(Integer.parseInt(list.get(j).get("count")));
						methods.get(i).getMethod().setPriority(Integer.parseInt(list.get(j).get("priority")));
						result.add(methods.get(i));
					}
				}
			}
		}

		DisplayLogUtils.displayLog("size of testcases result : " +  result.size());
		for(IMethodInstance m : result)
		{
			DisplayLogUtils.displayLog("method name: " + m.getMethod().getMethodName());
		}
		DisplayLogUtils.displayLog("End of  MethodInterceptor.intercept --> ");

		return result;
	}
 
}












