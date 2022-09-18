package com.cs.tests;

import java.util.Map;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import com.cs.annotations.FrameworkAnnotation;
import com.cs.enums.AuthorType;
import com.cs.enums.CategoryType;
import com.cs.listeners.ListenerClass;
import com.cs.pages.OrangeHRMLoginPageNew;
import com.cs.utils.DisplayLogUtils;

public final class OrangeHrmTests extends BaseTest{
	
	private OrangeHrmTests() {}
	
 
	@FrameworkAnnotation(author= {AuthorType.DHARM}, category = CategoryType.REGRESSION)
	@Test
	public void loginLogoutTest(Map<String, String> data)  
	{
		
		DisplayLogUtils.displayLog("Begin of OrangeHrmTests.loginLogoutTest() ->" + ListenerClass.executionOrdercounter++);

		String title = new OrangeHRMLoginPageNew()
								.logInToApplication(data.get("username"), data.get("password"))
								.clickWelcome().clickLogout().getTitle();
		Assertions.assertThat(title)
				.as("Title is not equal to 'OrangeHRM'")
				.isEqualTo("OrangeHRM");
		
		DisplayLogUtils.displayLog("End of OrangeHrmTests.loginLogoutTest() ->" + ListenerClass.executionOrdercounter);
	}
}
