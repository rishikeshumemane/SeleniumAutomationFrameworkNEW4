package com.cs.utils;

import com.cs.constants.FrameworkConstants;
import com.cs.enums.ConfigProperties;

public class DisplayLogUtils {
	public static void displayLog(String message)
	{
			if (PropertyUtils.getValue(ConfigProperties.DEBUG).equalsIgnoreCase(FrameworkConstants.getYes()))
				System.out.println(message);
	}
	
	public static void displaySimpleLog(String message)
	{
		System.out.println(message);
	}
	
}
