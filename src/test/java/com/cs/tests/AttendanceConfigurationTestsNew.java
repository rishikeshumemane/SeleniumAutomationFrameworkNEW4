package com.cs.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.cs.annotations.FrameworkAnnotation;
import com.cs.enums.AuthorType;
import com.cs.enums.CategoryType;
import com.cs.listeners.ListenerClass;
import com.cs.pages.AttendanceConfigurationPageNew;
import com.cs.pages.OrangeHRMLoginPageNew;
import com.cs.pages.TopMenuNew;
import com.cs.utils.DecodeUtils;
import com.cs.utils.DisplayLogUtils;

public final class AttendanceConfigurationTestsNew extends BaseTest{

	private AttendanceConfigurationTestsNew() {}
	
	AttendanceConfigurationPageNew acp;

	@FrameworkAnnotation(author= {AuthorType.RISHI}, 
									category = {CategoryType.SMOKE})
	@Test
	public void AttendanceConfigurationTest(Map<String, String> data)
	{
		DisplayLogUtils.displayLog("Begin of AttendanceConfiguration.AttendanceConfigurationTest() ->" + ListenerClass.executionOrdercounter++);

		//login to application
		String homePageTitle = new OrangeHRMLoginPageNew()
				.logInToApplication(data.get("username"), DecodeUtils.getDecodedString(data.get("password"))).getTitle();
		// verify Login was successful
		Assert.assertEquals(homePageTitle, "OrangeHRM", "ERROR=>Home Page Title doesnot match ! actual was " + homePageTitle + " and expected was OrangeHRM");
		

		// Navigate to a Configuration page
		AttendanceConfigurationPageNew acpn = new TopMenuNew()
																.getTimeMenuOption()
																.getAttendanceMenuOption()
																.getConfigurationMenuOption();
		
		// Set   status as test expected true, false, false
		acpn.setExpectedInitialCheckboxStatus();
		// get and Verify expected check box status 
		acpn.getAndVerifyBoxStatus("CURRENTDATETIME", true);
 		acpn.getAndVerifyBoxStatus("ATTENDANCE", false);
		acpn.getAndVerifyBoxStatus("SUPERVISORATTENDANCE", false);

		// Toggle check boxes
		acpn.toggleEmpChangeCurrentTime().getAndVerifyBoxStatus("CURRENTDATETIME", false);
	
		acpn.toggleEmpEditDeleteAttendance().getAndVerifyBoxStatus("ATTENDANCE", true);

		acpn.toggleSupervisorAddEditDeleteAttendance().getAndVerifyBoxStatus("SUPERVISORATTENDANCE", true);

		// save the configuration and reopen the page to see the effect
		acpn.SaveConfiguration();
		
// navigate to different page say Customer home page		
		new TopMenuNew()
			.getTimeMenuOption()
			.getProjectinfoMenuOption()
			.getCustomersMenuOption();
		 
		// navigate from Time->Attendance->Configuration
		acpn = new TopMenuNew().getTimeMenuOption().getAttendanceMenuOption().getConfigurationMenuOption();
		
		// get the status for all checkbox 
		acpn.getAndVerifyBoxStatus("CURRENTDATETIME", false)
		   		.getAndVerifyBoxStatus("ATTENDANCE", true)
		   		.getAndVerifyBoxStatus("SUPERVISORATTENDANCE", true);

		DisplayLogUtils.displayLog("End of AttendanceConfiguration.AttendanceConfigurationTest() ->" + ListenerClass.executionOrdercounter);

	}

}
