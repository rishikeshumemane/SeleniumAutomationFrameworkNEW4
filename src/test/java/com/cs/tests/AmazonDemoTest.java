package com.cs.tests;

import java.util.Map;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import com.cs.annotations.FrameworkAnnotation;
import com.cs.enums.AuthorType;
import com.cs.enums.CategoryType;
import com.cs.listeners.ListenerClass;
import com.cs.pages.AmazonHomePage;
import com.cs.pages.AmazonLapTopAndAccessories;
import com.cs.utils.DisplayLogUtils;

public final class AmazonDemoTest extends BaseTest {

	@FrameworkAnnotation(author= {AuthorType.RISHI, AuthorType.DHARM}, 
			category= {CategoryType.REGRESSION, CategoryType.SMOKE})
	@Test
	public void amazonTest(Map<String, String> data)
	{
		
		 
		  
		
		DisplayLogUtils.displayLog("Begin of AmazonDemoTest.amazonTest() ->" + ListenerClass.executionOrdercounter++);

		DisplayLogUtils.displaySimpleLog("First amazon test ----->");

		AmazonLapTopAndAccessories alpaa = new AmazonHomePage()
				.clickHamberger().clickComputers().clickOnSubMenuItem(data.get("menutext"));
		Assertions.assertThat(alpaa.getTitle()).isNotNull().isNotEmpty();
		
/*		DisplayLogUtils.displaySimpleLog("Second amazon test ----->");
 
		new AmazonHomePage()
			.clickHamberger()
			.clickComputers()
			.clickOnSubMenuItem(data.get("submenutext"));
		
		AmazonTablleReplacementPartsPage arpp = new AmazonTablleReplacementPartsPage();
		String title1 = arpp.getTitle();		
		System.out.println("Tablet Replacement Parts title1: " + title1);
		Assertions.assertThat(title1).isNotNull().isNotEmpty();


		DisplayLogUtils.displayLog("End of AmazonDemoTest.amazonTest() ->" + ListenerClass.executionOrdercounter);
*/
	}



}
