package com.cs.utils;

import org.apache.commons.lang3.RandomStringUtils;

import com.cs.listeners.ListenerClass;

public class GenerateRandomString {

	public static String generateName(int maxCharacters)
	{
		DisplayLogUtils.displayLog("Begin&End of GenerateRandomString.generateName() ->" + ListenerClass.executionOrdercounter++);

		return RandomStringUtils.randomAlphabetic(maxCharacters);
	}
	
	
}
