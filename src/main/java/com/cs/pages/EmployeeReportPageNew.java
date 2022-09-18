package com.cs.pages;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;

import com.cs.listeners.ListenerClass;
import com.cs.utils.DisplayLogUtils;
import com.cs.utils.ValidateUtils;

public class EmployeeReportPageNew extends BasePage{

	
	private static final By txtEmpName                   = By.xpath("//dd");
	private static final By lblprojectName                = By.xpath("//*[@id='resultTable']/tbody/tr/td[1]");
	private static final By lblListactivityName           = By.xpath("//*[@id='resultTable']/tbody/tr/td[2]");
	private static final By lblHours                        = By.xpath("//*[@id=\"resultTable\"]/tbody/tr/td[3]");
	private static final By lblTotalHours                  = By.xpath("//*[@id='resultTable']/tfoot/tr/td[3]");
	private static final By lblPageHeder                  = By.xpath("//h1");
	private final String headerExpPageHeader           = "Employee Report";
	
	public String getHeaderExpPageHeader() {
		return headerExpPageHeader;
	}

	private TopMenuNew topMenu;
	
	public EmployeeReportPageNew()
	{
		topMenu = new TopMenuNew();
	}
	
	
	public String getEmployeeName()
	{
		DisplayLogUtils.displayLog("Begin&End of EmployeeReportPageNew.getEmployeeName ->" + ListenerClass.executionOrdercounter++);
		return getText(txtEmpName);
	}
	
	public String getProjectName()
	{
		DisplayLogUtils.displayLog("Begin&End of EmployeeReportPageNew.getProjectName ->" + ListenerClass.executionOrdercounter++);
		return getText(lblprojectName);
	}
	public String getActivityName()
	{
		DisplayLogUtils.displayLog("Begin&End of EmployeeReportPageNew.getActivityName ->" + ListenerClass.executionOrdercounter++);
		return getText(lblListactivityName);
	}
	
	public String getHours()
	{
		DisplayLogUtils.displayLog("Begin&End of EmployeeReportPageNew.getHours ->" + ListenerClass.executionOrdercounter++);
		return getText(lblHours);
	}
	
	public String getTotalHours()
	{
		DisplayLogUtils.displayLog("Begin&End of EmployeeReportPageNew.getTotalHours ->" + ListenerClass.executionOrdercounter++);
		return getText(lblTotalHours);
	}
	
	public String getEmployeeReportPageHeader()
	{
		DisplayLogUtils.displayLog("Begin&End of EmployeeReportPageNew.getEmployeeReportPageHeader ->" + ListenerClass.executionOrdercounter++);
		return getText(lblPageHeder);
	}
	
	public void validateCustomerDetails(	String employeeName, String actEmpName, String expEmpName,
												String projectName, String actProjectName, String expProjectName,
												String activityName, String actActivityName, String expActivityName,
												String hours, String actHours, String expHours,
												String totalHours, String actTotalHours, String expTotalHours,
												String reportPageHeader, String actEmployeeReportPageHeader, String expHeaderExpPageHeader)
	{
		Map<String, String> expMap = new HashMap<String,String>();
		Map<String, String> actMap  = new HashMap<String,String>();
		
		expMap.put(employeeName, expEmpName);
		actMap.put(employeeName, actEmpName);
		ValidateUtils.validateMsg(expEmpName, actEmpName, 
				"actual employee name: " + actEmpName + " does not match with expected employee name: " + expEmpName,
				"actual employee name: " + actEmpName + " matched with expected employee name: " + expEmpName);

		expMap.put(projectName, actProjectName);
		actMap.put(projectName, expProjectName);
		ValidateUtils.validateMsg(expProjectName, actProjectName, 
				"actual project name: " + actProjectName + " does not match with expected project name: " + expProjectName,
				"actual project name: " + actProjectName + " matched with expected project name: " + expProjectName);
				
				
		expMap.put(activityName, actActivityName);
		actMap.put(activityName, expActivityName);
		ValidateUtils.validateMsg(expActivityName, actActivityName, "actual activity name: " + actActivityName + " does not match with expected activity name: " + expActivityName,
				"actual activity name: " + actActivityName + " matched with expected activity name: " + expActivityName);
		
				
		expMap.put(hours, actHours);
		actMap.put(hours, expHours);
		ValidateUtils.validateMsg(expHours,actHours,"actual Hours: " + actHours + " does not match with expected hours: " + expHours,
				"actual Hours: " + actHours + " matched with expected hours: " + expHours);
		
				
		expMap.put(totalHours, actTotalHours);
		actMap.put(totalHours, expTotalHours);
		ValidateUtils.validateMsg(expTotalHours, actTotalHours , "actual Total Hours: " + actTotalHours + " does not match with expected total hours: " + expTotalHours,
				"actual Total Hours: " + actTotalHours + " matched with expected total hours: " + expTotalHours);
				
		expMap.put(reportPageHeader, actEmployeeReportPageHeader);
		actMap.put(reportPageHeader, expHeaderExpPageHeader);
		ValidateUtils.validateMsg(actEmployeeReportPageHeader, expHeaderExpPageHeader, 
				"page header: " + actEmployeeReportPageHeader + " does not match with expected header: " + expHeaderExpPageHeader,
				"page header: " + actEmployeeReportPageHeader + " matched with expected header: " + expHeaderExpPageHeader);

/*		//one liner assertion, if it  is required, then use map else remove actMap and expMap
		Assertions.assertThat(expMap)
					.as("ERROR=> Expected customer details are not matching wtih actual details on customer page")
					.isEqualTo(actMap);
*/
		
	}

}
