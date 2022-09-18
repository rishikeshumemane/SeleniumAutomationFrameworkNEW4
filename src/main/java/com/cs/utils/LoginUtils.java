package com.cs.utils;

import org.testng.Assert;

import com.cs.pages.OrangeHRMLoginPageNew;

public class LoginUtils {
	//login to application

	public static void loginToAppl(String userName, String password)
	{
		String homePageTitle = new OrangeHRMLoginPageNew()
				.logInToApplication(userName, DecodeUtils.getDecodedString(password)).getTitle();
		// verify Login was successful
		Assert.assertEquals(homePageTitle, "OrangeHRM", "ERROR=>Home Page Title doesnot match ! actual was " + homePageTitle + " and expected was OrangeHRM");
	}
}
