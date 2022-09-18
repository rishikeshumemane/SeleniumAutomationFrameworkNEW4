package com.cs.tests;

import java.util.Calendar;
import java.util.Map;

import org.assertj.core.api.Assertions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.cs.annotations.FrameworkAnnotation;
import com.cs.enums.AuthorType;
import com.cs.enums.CategoryType;
import com.cs.listeners.ListenerClass;
import com.cs.pages.OrangeHRMHomePageNew;
import com.cs.pages.OrangeHRMLoginPageNew;
import com.cs.pages.PunchInOutPageNew;
import com.cs.pages.TopMenuNew;
import com.cs.reports.ExtentLogger;
import com.cs.utils.DecodeUtils;
import com.cs.utils.DisplayLogUtils;
import com.cs.utils.GenerateRandomNumber;

public class PunchInOutTestsNew extends BaseTest {

	private PunchInOutTestsNew() {}



	@FrameworkAnnotation(author    = {AuthorType.RISHI}, 
			category = {CategoryType.SMOKE})
	@Test
	public void PunchInOutTestNew(Map<String, String> data)  
	{

		DisplayLogUtils.displayLog("Begin of PunchInOutTestsNew.PunchInOutTestNew() ->" + ListenerClass.executionOrdercounter++);

		//login to application
		String homePageTitle = new OrangeHRMLoginPageNew()
				.logInToApplication(data.get("username"), DecodeUtils.getDecodedString(data.get("password"))).getTitle();
		// verify Login was successful
		Assert.assertEquals(homePageTitle, "OrangeHRM", "ERROR=>Home Page Title doesnot match ! actual was " + homePageTitle + " and expected was OrangeHRM");


		// pre-requisite of this test is to have checked a flag from Configuration page "Employee can change current time when punching in/out"
		new TopMenuNew()
				.getTimeMenuOption()
				.getAttendanceMenuOption().getConfigurationMenuOption()
				.setExpectedCheckboxStatusForEmpcanChangeTime()
				.SaveConfiguration();

		// move to Punch InOut page
		PunchInOutPageNew ohpiop  = new TopMenuNew()
													.getTimeMenuOption()
													.getAttendanceMenuOption()
													.getPunchinoutMenuOption();

		// is this right method to have required data here or should data/logic be inside other method?
		// Enter required values on a page fields
		int lastYear  = Calendar.getInstance().get(Calendar.YEAR)-1;	
		String year   = GenerateRandomNumber.generateRandomNumber(2015,lastYear);   
		String month = GenerateRandomNumber.generateRandomNumber(1,12);
		String day    = GenerateRandomNumber.generateRandomNumber(1,28); // safer side always there would be 28 days in any year irrespective of leap year

 		month = String.valueOf((Integer.parseInt(month)+1));
 		if(month.length() == 1)
 			month = "0" + month;	
		
		String actualInDate  = year + "-" + month + "-" + day;
		String actualInTime = "09:00";
		String loggedInUser = new OrangeHRMHomePageNew()
									.getElementTextForWelcomeUser();
		String actualInNote  = "In Time recorded for user: " + loggedInUser;
		DisplayLogUtils.displayLog("actualInNote  ==> "+ actualInNote);

		ohpiop= ohpiop.enterFormData(actualInDate,actualInTime, actualInNote, "btnIn");
		
		// verify punched in time and punched in note
		String expPunchedInTime = actualInDate + " " + actualInTime;
		String expPunchedInNote = actualInNote;
		String actualPunchedInTime = ohpiop.getPunchedInTime();
		String actualPunchedInNote = ohpiop.getPunchedInNote();

		Assertions.assertThat(actualPunchedInTime)
					.as(actualPunchedInTime  + " is not equal to " + expPunchedInTime)
					.isEqualTo(expPunchedInTime);

		Assertions.assertThat(actualPunchedInNote)
					.as(actualPunchedInNote + " is not equal to " + expPunchedInNote)
					.isEqualTo(expPunchedInNote);



		// Out entry
		String actualOutTime = "17:00";
		String actualOutNote = "Out Time recorded for user: " + loggedInUser;

		ohpiop= ohpiop.enterFormData(actualInDate,actualOutTime, actualOutNote, "btnOut");

		// Verify Saved  Successful flashed  message
		ohpiop.verifyFlashedMsg("Punch In and Out entry saved Successfully");

		DisplayLogUtils.displayLog("End of PunchInOutTests.PunchInOutTest() ->" + ListenerClass.executionOrdercounter);

	}



	@FrameworkAnnotation(author    = {AuthorType.TESTLEAD}, 
			category = {CategoryType.REGRESSION, CategoryType.SMOKE})
	@Test
	public void PunchInOutTestNewUsingCalenderInputMonthName(Map<String, String> data)  
	{

		DisplayLogUtils.displayLog("Begin of PunchInOutTestsNew.PunchInOutTestNewUsingCalenderInput() ->" + ListenerClass.executionOrdercounter++);

		//login to application
		String homePageTitle = new OrangeHRMLoginPageNew()
				.logInToApplication(data.get("username"), DecodeUtils.getDecodedString(data.get("password"))).getTitle();
		// verify Login was successful
		Assert.assertEquals(homePageTitle, "OrangeHRM", "ERROR=>Home Page Title doesnot match ! actual was " + homePageTitle + " and expected was OrangeHRM");


		// pre-requisite of this test is to have checked a flag from Configuration page "Employee can change current time when punching in/out"
		new TopMenuNew()
				.getTimeMenuOption()
				.getAttendanceMenuOption().getConfigurationMenuOption()
				.setExpectedCheckboxStatusForEmpcanChangeTime()
				.SaveConfiguration();

		// move to Punch InOut page
		PunchInOutPageNew ohpiop  = new TopMenuNew()
												.getTimeMenuOption()
												.getAttendanceMenuOption()
												.getPunchinoutMenuOption();

		// click on the attendance field
		ohpiop.clickAttendaceDateField();
		
		// Enter required values on a page fields
		int lastYear  = Calendar.getInstance().get(Calendar.YEAR)-1;	
		String year   = GenerateRandomNumber.generateRandomNumber(2015,lastYear);
		String month = GenerateRandomNumber.generateRandomNumber(0,11);
		String day    = GenerateRandomNumber.generateRandomNumber(1,28); // safer side always there would be 28 days in any year irrespective of leap year
		ExtentLogger.pass("month: " + month + "year: " + year);
		DisplayLogUtils.displaySimpleLog("******************** Month:" + month + "    Year:" + year +  "    Day:" + day);

		String monthName= ohpiop.getmonthName(month);
 		month = String.valueOf((Integer.parseInt(month)+1));
 		if(month.length() == 1)
 			month = "0" + month;	
 		
 		String actualInDate  = year + "-" + month + "-" + day;

		DisplayLogUtils.displaySimpleLog("============= monthName: " + monthName);
		ExtentLogger.pass("================= monthName: " + monthName);
		 		
 		ohpiop.selectMonthByText(monthName)
						.selectYearByText(year)
						.selectDayNo(Integer.parseInt(day));
						
		String actualInTime = "09:00";
		String loggedInUser = new OrangeHRMHomePageNew()
										.getElementTextForWelcomeUser();
		String actualInNote  = "In Time recorded for user: " + loggedInUser;
		//enter actualInTime, actualNote
/*		ohpiop.enterTime(actualInTime)
				.enterNote(actualInNote)
				.clickBtnIn(); */
		ohpiop = ohpiop.enterFormData(null, actualInTime, actualInNote, "btnIn");
		
		DisplayLogUtils.displayLog("actualInNote  ==> "+ actualInNote);

		// verify punched in time and punched in note
		String expPunchedInTime = actualInDate + " " + actualInTime;
		String expPunchedInNote = actualInNote;

		String actualPunchedInTime = ohpiop.getPunchedInTime();
		String actualPunchedInNote = ohpiop.getPunchedInNote();

		Assertions.assertThat(actualPunchedInTime)
					.as(actualPunchedInTime  + " is not equal to " + expPunchedInTime)
					.isEqualTo(expPunchedInTime);

		Assertions.assertThat(actualPunchedInNote)
					.as(actualPunchedInNote + " is not equal to " + expPunchedInNote)
					.isEqualTo(expPunchedInNote);

		DisplayLogUtils.displaySimpleLog("******************* OUT ENTRY BEGINS");
		ExtentLogger.pass("******************* OUT ENTRY BEGINS");

		// Out entry
		String actualOutTime = "17:00";
		String actualOutNote = "Out Time recorded for user: " + loggedInUser;
		// click on the attendance field
		ohpiop.clickAttendaceDateField();
		ohpiop.selectMonthNo(Integer.parseInt(month))
				.selectYearNo(Integer.parseInt(year))
				.selectDayNo(Integer.parseInt(day));
//		ohpiop.enterTime(actualOutTime).enterNote(actualOutNote).clickBtnOut();
		ohpiop = ohpiop.enterFormData(null, actualOutTime, actualOutNote, "btnOut");
		
		// Verify Saved  Successful flashed  message
		ohpiop.verifyFlashedMsg("Punch In and Out entry saved Successfully");

		DisplayLogUtils.displayLog("End of PunchInOutTests.PunchInOutTestNewUsingCalenderInput() ->" + ListenerClass.executionOrdercounter);

	}

	@FrameworkAnnotation(author    = {AuthorType.TESTLEAD}, 
			category = {CategoryType.REGRESSION, CategoryType.SMOKE})
	@Test
	public void PunchInOutTestNewUsingCalenderInputMonthNo(Map<String, String> data)  
	{

		DisplayLogUtils.displayLog("Begin of PunchInOutTestsNew.PunchInOutTestNewUsingCalenderInput() ->" + ListenerClass.executionOrdercounter++);

		//login to application
		String homePageTitle = new OrangeHRMLoginPageNew()
				.logInToApplication(data.get("username"), DecodeUtils.getDecodedString(data.get("password"))).getTitle();
		// verify Login was successful
		Assert.assertEquals(homePageTitle, "OrangeHRM", "ERROR=>Home Page Title doesnot match ! actual was " + homePageTitle + " and expected was OrangeHRM");


		// pre-requisite of this test is to have checked a flag from Configuration page "Employee can change current time when punching in/out"
		new TopMenuNew()
				.getTimeMenuOption()
				.getAttendanceMenuOption().getConfigurationMenuOption()
				.setExpectedCheckboxStatusForEmpcanChangeTime()
				.SaveConfiguration();

		// move to Punch InOut page
		PunchInOutPageNew ohpiop  = new TopMenuNew()
												.getTimeMenuOption()
												.getAttendanceMenuOption()
												.getPunchinoutMenuOption();

		// click on the attendance field
		ohpiop.clickAttendaceDateField();
		
		// Enter required values on a page fields
		int lastYear  = Calendar.getInstance().get(Calendar.YEAR)-1;	
		String year   = GenerateRandomNumber.generateRandomNumber(2015,lastYear);
		String month = GenerateRandomNumber.generateRandomNumber(0,11);
		String day    = GenerateRandomNumber.generateRandomNumber(1,28); // safer side always there would be 28 days in any year irrespective of leap year
		ExtentLogger.pass("month: " + month + "year: " + year);
		DisplayLogUtils.displaySimpleLog("******************** Month:" + month + "    Year:" + year +  "    Day:" + day);

  		month = String.valueOf((Integer.parseInt(month)+1));
 		if(month.length() == 1)
 			month = "0" + month;	
 		
 		String actualInDate  = year + "-" + month + "-" + day;

		DisplayLogUtils.displaySimpleLog("============= monthNo: " + month);
		ExtentLogger.pass("================= monthNo: " + month);
		 		
 		ohpiop.selectMonthNo(Integer.parseInt(month))
						.selectYearByText(year)
						.selectDayNo(Integer.parseInt(day));
						
		String actualInTime = "09:00";
		String loggedInUser = new OrangeHRMHomePageNew()
										.getElementTextForWelcomeUser();
		String actualInNote  = "In Time recorded for user: " + loggedInUser;
		//enter actualInTime, actualNote
		ohpiop = ohpiop.enterFormData(null, actualInTime, actualInNote, "btnIn");
		
		DisplayLogUtils.displayLog("actualInNote  ==> "+ actualInNote);

		// verify punched in time and punched in note
		String expPunchedInTime = actualInDate + " " + actualInTime;
		String expPunchedInNote = actualInNote;

		String actualPunchedInTime = ohpiop.getPunchedInTime();
		String actualPunchedInNote = ohpiop.getPunchedInNote();

		Assertions.assertThat(actualPunchedInTime)
					.as(actualPunchedInTime  + " is not equal to " + expPunchedInTime)
					.isEqualTo(expPunchedInTime);

		Assertions.assertThat(actualPunchedInNote)
					.as(actualPunchedInNote + " is not equal to " + expPunchedInNote)
					.isEqualTo(expPunchedInNote);

		DisplayLogUtils.displaySimpleLog("******************* OUT ENTRY BEGINS");
		ExtentLogger.pass("******************* OUT ENTRY BEGINS");

		// Out entry
		String actualOutTime = "17:00";
		String actualOutNote = "Out Time recorded for user: " + loggedInUser;
		// click on the attendance field
		ohpiop.clickAttendaceDateField();
		ohpiop.selectMonthNo(Integer.parseInt(month))
				.selectYearNo(Integer.parseInt(year))
				.selectDayNo(Integer.parseInt(day));
		ohpiop = ohpiop.enterFormData(null, actualOutTime, actualOutNote, "btnOut");
		
		// Verify Saved  Successful flashed  message
		ohpiop.verifyFlashedMsg("Punch In and Out entry saved Successfully");

		DisplayLogUtils.displayLog("End of PunchInOutTests.PunchInOutTestNewUsingCalenderInput() ->" + ListenerClass.executionOrdercounter);

	}

}
