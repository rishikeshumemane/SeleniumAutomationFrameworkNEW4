package com.cs.utils;

import org.assertj.core.api.Assertions;

import com.cs.reports.ExtentLogger;

public class ValidateUtils 
{
	 public static void validateMsg( String expMsg, String actMsg, String errorMsg, String reportMsg)
	{
		verifyMsg(expMsg, actMsg, errorMsg, reportMsg);
	}
	
	public static void verifyMsg(String expSuccessfulMsg, String actSuccessfulMsg, String reportMsg)
	{		
		Assertions.assertThat(actSuccessfulMsg)
			.as("ERROR=> " + "Expected message: '" + expSuccessfulMsg + "' and found '" + actSuccessfulMsg + "'")
			.isEqualTo(expSuccessfulMsg );
		ExtentLogger.pass("VERIFICATION=> "+ reportMsg);
	}
	
	public static void verifyMsg(String expSuccessfulMsg, String actSuccessfulMsg, String errorMsg, String reportMsg)
	{		
		Assertions.assertThat(actSuccessfulMsg)
						.as(errorMsg)
						.isEqualTo(expSuccessfulMsg );
		ExtentLogger.pass("VERIFICATION=> "+ reportMsg);
	}

}
