package com.cs.pages;

import org.openqa.selenium.By;

public class TimePageMenu  extends BasePage{

	// Time Menu options
	private final static By timeSheetsMenuOption           = By.xpath("//*[@id='app']//nav/ul/li[1]");
	private final static By attendanceMenuOption           = By.xpath("//*[@id='app']//nav/ul/li[2]");
	private final static By reportsMenuOption                  = By.xpath("//*[@id='app']//nav/ul/li[3]");
	private final static By projectInfoMenuOption            = By.xpath("//*[@id='app']//nav/ul/li[4]");
	
	// Time->Attendance SubMenu option shown below
	private final static By myRecordsMenuOption                = By.xpath("//*[@id='app']//li[2]/ul/li[1]/a");
	private final static By punchInOutMenuOption               = By.xpath("//*[@id='app']//li[2]/ul/li[2]/a");
	private final static By employeeRecordsMenuOption    = By.xpath("//*[@id='app']//li[2]/ul/li[3]/a");
	private final static By configurationMenuOption             = By.xpath("//*[@id='app']//li[2]/ul/li[4]/a");

	// Time->ProjectInfo SubMenu option shown below
	private final static By customersMenuOption         = By.xpath("//*[@id=\"app\"]//nav/ul/li[4]/ul/li[1]/a");
	private final static By projectsMenuOption             = By.xpath("//*[@id=\"app\"]//nav/ul/li[4]/ul/li[2]/a");

	// Time->Reports
	private final static By projectReportsMenuOption         = By.xpath("//*[@id=\"app\"]//li[3]/ul/li[1]/a");
	private final static By employeeReportsMenuOption      = By.xpath("//*[@id=\"app\"]//li[3]/ul/li[2]/a");
	private final static By attedanceSummaryMenuOption    = By.xpath("//*[@id=\"app\"]//li[3]/ul/li[3]/a");
	
	// employee Reports Menu options
	public EmployeeReportSearchPageNew getEmployeeReportMenuOption() {
		click(employeeReportsMenuOption, "Employee Reports Menu  Option");
		return new EmployeeReportSearchPageNew();
	}
	
	
// ProjectInfo SubMenu options shown below
	public CustomerHomePageNew getCustomersMenuOption() {
//		click(customersMenuOption, WaitStrategy.CLICKABLE, "Customers Menu  Option");
		click(customersMenuOption, "Customers Menu  Option");
		return new CustomerHomePageNew();
	}
	
	//todo:Create a page class for projectsPage
	public By  getProjectsMenuOption() {
//		click(projectsMenuOption, WaitStrategy.CLICKABLE, "Projects  Menu  Option");
		click(projectsMenuOption, "Projects  Menu  Option");
		return null;
	}
// End of ProjectInfo SubMenu methods
	
	

// TimeMenu options show below	
	//todo:
	public  TimePageMenu getTimesheetsMenuOption() {
//		click(timeSheetsMenuOption, WaitStrategy.CLICKABLE, "Timesheets Menu Option");
		click(timeSheetsMenuOption,  "Timesheets Menu Option");
		return this;
	}
	
	//todo:
	public TimePageMenu getAttendanceMenuOption() {
//		click(attendanceMenuOption, WaitStrategy.CLICKABLE, "Attendance Menu Option");
		click(attendanceMenuOption,  "Attendance Menu Option");
		return this;
	}
	
	//todo:
	public TimePageMenu getReportsMenuOption() {
//		click(reportsMenuOption, WaitStrategy.CLICKABLE, "Reports Menu Option");
		click(reportsMenuOption, "Reports Menu Option");
		return this;
	}
	
	//todo:
	public TimePageMenu getProjectinfoMenuOption() {
//		click(projectInfoMenuOption,WaitStrategy.CLICKABLE, "Project Info  Menu Option");
		click(projectInfoMenuOption,"Project Info  Menu Option");
		return this;
	}
// End of TimeMenu options show below	

	
// Attendance Menu options shown below
	//todo:write a page myRecordsPage
	public By getMyrecordsMenuOption() {
//		click(myRecordsMenuOption, WaitStrategy.CLICKABLE, "My Records Menu  Option");
		click(myRecordsMenuOption,  "My Records Menu  Option");
		return null;
	}
	
	public PunchInOutPageNew getPunchinoutMenuOption() {
//		click(punchInOutMenuOption, WaitStrategy.CLICKABLE, "Punch In/Out Menu  Option");
		click(punchInOutMenuOption, "Punch In/Out Menu  Option");
		return new PunchInOutPageNew();
	}

	//todo:write a class for EmployeeRecordsPage
	public By getEmployeerecordsMenuOption() {
//		click(employeeRecordsMenuOption, WaitStrategy.CLICKABLE, "Employee Records Menu  Option");
		click(employeeRecordsMenuOption, "Employee Records Menu  Option");
		return null;
	}
	
	public AttendanceConfigurationPageNew getConfigurationMenuOption() {
//		click(configurationMenuOption, WaitStrategy.CLICKABLE, "Configuration Menu  Option");
		click(configurationMenuOption, "Configuration Menu  Option");
		return new AttendanceConfigurationPageNew();
	}
	
// End of Attendance Menu options shown below	
	
}
