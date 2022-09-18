package com.cs.pages;

import java.util.Objects;

import org.openqa.selenium.By;

import com.cs.listeners.ListenerClass;
import com.cs.utils.DisplayLogUtils;

public class EmployeeReportSearchPageNew extends BasePage{

	private static final By txtEmpName                   = By.id("employee_empName");
	private static final By txtEmpNameList               = By.xpath("//ul/li/strong");
	private static final By drpdnListprojectName       = By.id("time_project_name");
	private static final By drpdnListactivityName       = By.id("time_activity_name");
	private static final By txtListprojectDateFrom      = By.id("project_date_range_from_date");
	private static final By txtProjectDateTo              = By.id("project_date_range_to_date");
	private static final By chboxApprovedTimesheet  = By.id("only_include_approved_timesheets");
	private static final By btnView                         = By.id("viewbutton");
	private static final By resultEmployeeTableMsg   = By.xpath("//table[@id='resultTable']//td");
	
	private TopMenuNew topMenu;
	
	public EmployeeReportSearchPageNew()
	{
		topMenu = new TopMenuNew();
	}
	
	public String getResultEmployeeTableMsg()
	{
		DisplayLogUtils.displayLog("Begin&End of EmployeeReportSearchPageNew.getResultEmployeeTableMsg ->" + ListenerClass.executionOrdercounter++);
		return getText(resultEmployeeTableMsg);
	}
	
	public EmployeeReportPageNew clickViewBtn()
	{
		DisplayLogUtils.displayLog("Begin of EmployeeReportSearchPageNew.clickViewBtn ->" + ListenerClass.executionOrdercounter++);
		click(btnView,"View Button");
		DisplayLogUtils.displayLog("End of EmployeeReportSearchPageNew.clickViewBtn ->" + ListenerClass.executionOrdercounter);

		return new EmployeeReportPageNew();   
	}
		
	public EmployeeReportSearchPageNew SelectTimesheetApproved(boolean isSelect)
	{
		DisplayLogUtils.displayLog("Begin of EmployeeReportSearchPageNew.SelectTimesheetApproved ->" + ListenerClass.executionOrdercounter++);
		
		// when checkbox is not already ticked and isSelect is true
		if (!getChecBoxStatus(chboxApprovedTimesheet) && isSelect)
			click(chboxApprovedTimesheet, "Select Only Approved Timesheets");	
		// when checkbox is already ticked and isSelect is false ==> uncheck
		if (getChecBoxStatus(chboxApprovedTimesheet) && !isSelect)
			click(chboxApprovedTimesheet, "Select Only Approved Timesheets");	
		// when checbox is already ticked and isSelect is true no need to do anything
		// when checbox is already ticked and isSelect is false no need to do anything

		DisplayLogUtils.displayLog("End of EmployeeReportSearchPageNew.SelectTimesheetApproved ->" + ListenerClass.executionOrdercounter);

		return this;
	}
	
	public EmployeeReportSearchPageNew enterProjectDateTo(String projectToDate)
	{
		DisplayLogUtils.displayLog("Begin of EmployeeReportSearchPageNew.enterProjectDateTo ->" + ListenerClass.executionOrdercounter++);
		clear(txtProjectDateTo);
		sendKeys(txtProjectDateTo, projectToDate, "Project To Date");
		DisplayLogUtils.displayLog("End of EmployeeReportSearchPageNew.enterProjectDateTo ->" + ListenerClass.executionOrdercounter);

		return this;
	}
	
	public EmployeeReportSearchPageNew enterProjectDateFrom(String projectFromDate)
	{
		DisplayLogUtils.displayLog("Begin of EmployeeReportSearchPageNew.enterProjectDateFrom ->" + ListenerClass.executionOrdercounter++);
		clear(txtListprojectDateFrom);
		sendKeys(txtListprojectDateFrom, projectFromDate, "Project From Date");
		DisplayLogUtils.displayLog("End of EmployeeReportSearchPageNew.enterProjectDateFrom ->" + ListenerClass.executionOrdercounter);

		return this;
	}
	
	public EmployeeReportSearchPageNew selectActivityName(String activityName)
	{
		DisplayLogUtils.displayLog("Begin of EmployeeReportSearchPageNew.selectActivityName ->" + ListenerClass.executionOrdercounter++);
		selectByText(drpdnListactivityName, activityName, "Activity Name Field");
		DisplayLogUtils.displayLog("End of EmployeeReportSearchPageNew.selectActivityName ->" + ListenerClass.executionOrdercounter);

		return this;
	}
	
	public EmployeeReportSearchPageNew selectProjectName(String projectName)
	{
		DisplayLogUtils.displayLog("Begin of EmployeeReportSearchPageNew.selectProjectName ->" + ListenerClass.executionOrdercounter++);
		selectByText(drpdnListprojectName, projectName, "Project Name Field");
		DisplayLogUtils.displayLog("End of EmployeeReportSearchPageNew.selectProjectName ->" + ListenerClass.executionOrdercounter);

		return this;
	}

	public EmployeeReportSearchPageNew enterEmployeeName(String empName)
	{
		DisplayLogUtils.displayLog("Begin of EmployeeReportSearchPageNew.enterEmployeeName ->" + ListenerClass.executionOrdercounter++);
		sendKeys(txtEmpName, empName, "Employee Name", txtEmpNameList);
		
		DisplayLogUtils.displayLog("End of EmployeeReportSearchPageNew.enterEmployeeName ->" + ListenerClass.executionOrdercounter);

		return this;
	}
	
	public EmployeeReportPageNew  enterFormData(String empName, String projectName, String activityName,
			String projectFromDate, String projectToDate, boolean approvedTimeSheetFlag)
	{
		if(Objects.nonNull(empName))
			enterEmployeeName(empName);
		if(Objects.nonNull(projectName))
			selectProjectName(projectName);
		if(Objects.nonNull(activityName))
			selectActivityName(activityName);
		if(Objects.nonNull(projectFromDate))
			enterProjectDateFrom(projectFromDate);
		if(Objects.nonNull(projectToDate))
			enterProjectDateTo(projectToDate);
		if(Objects.nonNull(approvedTimeSheetFlag))
			SelectTimesheetApproved(approvedTimeSheetFlag);
			
		return clickViewBtn();
	}
	
	/*
	 * public void validateMsg( String expMsg, String actMsg, String errorMsg,
	 * String reportMsg) { verifyMsg(expMsg, actMsg, errorMsg, reportMsg); }
	 */
 
}