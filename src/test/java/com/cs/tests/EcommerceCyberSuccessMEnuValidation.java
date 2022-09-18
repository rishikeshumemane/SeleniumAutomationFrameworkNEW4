package com.cs.tests;

import java.util.Map;

import org.assertj.core.api.Assertions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.cs.annotations.FrameworkAnnotation;
import com.cs.enums.AuthorType;
import com.cs.enums.CategoryType;
import com.cs.listeners.ListenerClass;
import com.cs.pages.CyberSuccessHomePage;
import com.cs.utils.DisplayLogUtils;

public final class EcommerceCyberSuccessMEnuValidation extends BaseTest {

	@FrameworkAnnotation(author= {AuthorType.RITESH, AuthorType.KUNAL}, 
			category= {CategoryType.REGRESSION, CategoryType.SMOKE})
	@Test
	public void verifyTopMenuOptionsTest(Map<String, String> data)
	{
	 	
		DisplayLogUtils.displayLog("Begin of verifyTopMenuOptionsTest() ->" + ListenerClass.executionOrdercounter++);

		CyberSuccessHomePage cshp = new CyberSuccessHomePage(); 
		String actHomeMenuOptionString = cshp.getHomeMenuOption();
		String expHomeMenuOptionString = "HOME1";
		DisplayLogUtils.displayLog("actHomeMenuOptionString : " + actHomeMenuOptionString );
		DisplayLogUtils.displayLog("expHomeMenuOptionString : " + expHomeMenuOptionString );
		
		/*
		 * Assertions.assertThat(actHomeMenuOptionString ) .as(expHomeMenuOptionString +
		 * " is not equal to " + actHomeMenuOptionString)
		 * .isEqualTo(expHomeMenuOptionString);
		 */
		Assert.assertEquals(actHomeMenuOptionString,expHomeMenuOptionString, expHomeMenuOptionString  + " is not equal to " + actHomeMenuOptionString);
		
		DisplayLogUtils.displayLog("End of verifyTopMenuOptionsTest() ->" + ListenerClass.executionOrdercounter);

	}



}
