package com.cs.utils;

import java.util.Random;

import com.cs.listeners.ListenerClass;

public class GenerateRandomNumber {

	public static String generateRandomNumber(int min, int max)
	{

		DisplayLogUtils.displayLog("Begin of GenerateRandomNumber.generateRandomNumber() ->" + ListenerClass.executionOrdercounter++);

		
		Random rand = new Random();
		int no = (rand.nextInt((max - min) + 1) + min);
		if (no < 10)
		{
			DisplayLogUtils.displayLog("End of GenerateRandomNumber.generateRandomNumber() ->" + ListenerClass.executionOrdercounter);
			return ("0" + no);
		}
		else
		{
			DisplayLogUtils.displayLog("End of GenerateRandomNumber.generateRandomNumber() ->" + ListenerClass.executionOrdercounter);
			return String.valueOf(no);
		}
	}
}
