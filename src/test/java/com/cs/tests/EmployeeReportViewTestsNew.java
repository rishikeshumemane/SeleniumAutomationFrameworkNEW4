package com.cs.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.cs.annotations.FrameworkAnnotation;
import com.cs.enums.AuthorType;
import com.cs.enums.CategoryType;
import com.cs.enums.StoryId;
import com.cs.listeners.ListenerClass;
import com.cs.pages.EmployeeReportPageNew;
import com.cs.pages.EmployeeReportSearchPageNew;
import com.cs.pages.OrangeHRMLoginPageNew;
import com.cs.pages.TopMenuNew;
import com.cs.utils.DecodeUtils;
import com.cs.utils.DisplayLogUtils;
import com.cs.utils.LoginUtils;
import com.cs.utils.ValidateUtils;

public final class EmployeeReportViewTestsNew extends BaseTest {

	private EmployeeReportViewTestsNew() {}

	
	/**
	 * AddCustomerTestsNew: test case to verify hours logged against specific  employee, specific 
	 * project name, specific activity name 
	 *  for specific from and to date
	 * 
	 */
	@FrameworkAnnotation(author   = {AuthorType.RISHI}, 
			                    category = {CategoryType.REGRESSION, CategoryType.SMOKE},
			                    story = {StoryId.ENCOMPASS_1023})
 	@Test()
	public void verifyEmployeeProjectLoggedhoursForProjectActivityNameForAPeriodTest(Map<String, String> data)  // test method name should be small 
	{
		
		DisplayLogUtils.displayLog("Begin of EmployeeReportViewTestsNew.verifyEmployeeProjectLoggedhoursForProjectActivityNameForAPeriodTest() ->" + ListenerClass.executionOrdercounter++);
 	
		//login to application
		LoginUtils.loginToAppl(data.get("username"), data.get("password"));
		
		// move to CustomerHomePage
		TopMenuNew topMenu = new TopMenuNew();
		EmployeeReportSearchPageNew  erspn = topMenu.getTimeMenuOption()
																	.getReportsMenuOption()
																	.getEmployeeReportMenuOption();
		
		// enter Search employee report form data 
		EmployeeReportPageNew erpn = erspn.enterFormData(data.get("fname"), data.get("projectname"), 
																		 data.get("activityname"), data.get("projectdatefrom"), 
																		 data.get("projectdateto"), Boolean.parseBoolean(data.get("approvedtimesheet")));

		erpn.validateCustomerDetails("employeeName", data.get("fname"),erpn.getEmployeeName(),
											"projectName", data.get("projectname"),erpn.getProjectName(),
											"activityName", data.get("activityname"),erpn.getActivityName(),
											"Hours", "14.00",erpn.getHours(),
											"totalHours", "14.00", erpn.getTotalHours(),
											"reportPageHeader", erpn.getEmployeeReportPageHeader(),erpn.getHeaderExpPageHeader());
/*// all code in test only - creating exp and act maps and its values
		expMap.put("employeeName", data.get("fname"));
		actMap.put("employeeName", erpn.getEmployeeName());
		
		expMap.put("projectName", data.get("projectname"));
		actMap.put("projectName", erpn.getProjectName());
		
		expMap.put("activityName", data.get("activityname"));
		actMap.put("activityName", erpn.getActivityName());
		
		expMap.put("Hours", "14.00");
		actMap.put("Hours", erpn.getHours());
		
		expMap.put("totalHours", "14.00");
		actMap.put("totalHours", erpn.getTotalHours());
		
		expMap.put("reportPageHeader", erpn.getEmployeeReportPageHeader());
		actMap.put("reportPageHeader", erpn.getHeaderExpPageHeader());
 
		Assertions.assertThat(expMap)
					.as("ERROR=> Expected customer details are not matching wtih actual details on customer page")
					.isEqualTo(actMap);
*/
		DisplayLogUtils.displayLog("end of AddCustomerTests.addCustomerBlankNameTest() ->" + ListenerClass.executionOrdercounter);
	}
	

	/**
	 * AddCustomerTestsNew: test case to verify hours logged against specific  employee, specific 
	 * project name, specific activity name 
	 *  for specific from and to date for approved timesheet - no records found
	 */
	@FrameworkAnnotation(author   = {AuthorType.RISHI}, 
								category = {CategoryType.REGRESSION, CategoryType.SMOKE})
 	@Test()
	public void verifyEmployeeProjectLoggedhoursForProjectActivityNameForAPeriodTestWithApprovedTimesheeets(Map<String, String> data)
	{
		
		DisplayLogUtils.displayLog("Begin of EmployeeReportViewTestsNew.verifyEmployeeProjectLoggedhoursForProjectActivityNameForAPeriodTest() ->" + ListenerClass.executionOrdercounter++);
 	
		//login to application
		String homePageTitle = new OrangeHRMLoginPageNew()
											.logInToApplication(data.get("username"), DecodeUtils.getDecodedString(data.get("password")))
											.getTitle();
		// verify Login was successful
		Assert.assertEquals(homePageTitle, "OrangeHRM", 
								"ERROR=>Home Page Title doesnot match ! actual was " + homePageTitle + " and expected was OrangeHRM");
		
		// move to CustomerHomePage
		TopMenuNew topMenu = new TopMenuNew();
		EmployeeReportSearchPageNew  erspn = topMenu.getTimeMenuOption()
														  .getReportsMenuOption()
														  .getEmployeeReportMenuOption();
		
		// enter Search employee report form data 
		EmployeeReportPageNew erpn = erspn.enterFormData(data.get("fname"), data.get("projectname"), 
																		 data.get("activityname"), data.get("projectdatefrom"), 
																		 data.get("projectdateto"), Boolean.parseBoolean(data.get("approvedtimesheet")));
		
		// verify  data on employee report
		ValidateUtils.validateMsg( erpn.getEmployeeReportPageHeader(), erpn.getHeaderExpPageHeader(), 
				"page header: " + erpn.getEmployeeReportPageHeader()+ " does not match with expected header: " + erpn.getHeaderExpPageHeader(),
				"page header: " + erpn.getEmployeeReportPageHeader()+ " matched with expected header: " + erpn.getHeaderExpPageHeader());

		String actNoRecordsFoundMsg = erspn.getResultEmployeeTableMsg();
		String expNoRecordsFoundMsg  = "No Records Found";
		ValidateUtils.validateMsg( expNoRecordsFoundMsg , actNoRecordsFoundMsg, 
				actNoRecordsFoundMsg  + " does not match with expected value: " + expNoRecordsFoundMsg,
				actNoRecordsFoundMsg  + " matched with expected value: " + expNoRecordsFoundMsg);
	
		String expEmployeeName = data.get("fname");
		String actEmployeeName = erpn.getEmployeeName();
		ValidateUtils.validateMsg(expEmployeeName, actEmployeeName, 
				"actual employee name: " + actEmployeeName + " does not match with expected employee name: " + expEmployeeName,
				"actual employee name: " + actEmployeeName + " matched with expected employee name: " + expEmployeeName);
	
		DisplayLogUtils.displayLog("end of AddCustomerTests.addCustomerBlankNameTest() ->" + ListenerClass.executionOrdercounter);
	}
	

}
