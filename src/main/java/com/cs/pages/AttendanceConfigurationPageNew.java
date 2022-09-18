package com.cs.pages;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;

import com.cs.listeners.ListenerClass;
import com.cs.utils.DisplayLogUtils;

public final class AttendanceConfigurationPageNew  extends BasePage{

	private final By lablPageHeader			           = By.xpath("//h1");
	private final By empChangeCurrentTime                     = By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/label/input");
	private final By empEditDeleteAttendance                   = By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/div/label/input");
	private final By SupervisorAddEditDeleteAttendance = By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/label/input");
	private final By btnSave                                                  = By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[2]/button");
	
	
	public AttendanceConfigurationPageNew setExpectedCheckboxStatusForEmpcanChangeTime()
	{
		DisplayLogUtils.displayLog("Begin of AttendanceConfigurationPageNew->setExpectedInitialCheckboxStatus() " + ListenerClass.executionOrdercounter++);
		if(!getEmpChangeCurrentTimeCheckBoxStatus())
		{	
			toggleEmpChangeCurrentTime();
			DisplayLogUtils.displaySimpleLog("Checked CurrentTime checkbox");
		}
		DisplayLogUtils.displayLog("Begin of AttendanceConfigurationPageNew->setExpectedInitialCheckboxStatus() " + ListenerClass.executionOrdercounter++);
		return new AttendanceConfigurationPageNew();
	}
	
	public String getPageHeader()
	{
		DisplayLogUtils.displayLog("Begin&End of AttendanceConfigurationPage->getPageHeader() " + ListenerClass.executionOrdercounter++);
		return getText(lablPageHeader);
	}
	
	public boolean getEmpChangeCurrentTimeCheckBoxStatus()
	{
		DisplayLogUtils.displayLog("Begin&End of AttendanceConfigurationPage->getEmpChangeCurrentTimeCheckBoxStatus() " + ListenerClass.executionOrdercounter++);
		return getCheckboxStatus(empChangeCurrentTime);
	}
	
	public boolean getEmpEditDeleteAttendanceCheckBoxStatus()
	{
		DisplayLogUtils.displayLog("Begin&End of AttendanceConfigurationPage->getEmpEditDeleteAttendanceCheckBoxStatus() " + ListenerClass.executionOrdercounter++);
		return getCheckboxStatus(empEditDeleteAttendance);
	}
	
	public boolean getSupervisorAddEditDeleteAttendanceCheckBoxStatus()
	{
		DisplayLogUtils.displayLog("Begin&End of AttendanceConfigurationPage->getSupervisorAddEditDeleteAttendanceCheckBoxStatus() " + ListenerClass.executionOrdercounter++);
		return getCheckboxStatus(SupervisorAddEditDeleteAttendance);
	}
 
	public AttendanceConfigurationPageNew toggleEmpChangeCurrentTime()
	{
		DisplayLogUtils.displayLog("Begin of AttendanceConfigurationPageNew->toggleEmpChangeCurrentTime() " + ListenerClass.executionOrdercounter++);

//		click(empChangeCurrentTime, WaitStrategy.PRESENCE,"Current Time");
		jsClick(empChangeCurrentTime,"Current Time");
		
		DisplayLogUtils.displayLog("End of AttendanceConfigurationPageNew->toggleEmpChangeCurrentTime() " + ListenerClass.executionOrdercounter);
		return this;
	}

	public AttendanceConfigurationPageNew toggleEmpEditDeleteAttendance()
	{
		DisplayLogUtils.displayLog("Begin of AttendanceConfigurationPageNew->toggleEmpEditDeleteAttendance() " + ListenerClass.executionOrdercounter++);
//		click(empEditDeleteAttendance, WaitStrategy.PRESENCE,"Edit Delete Attendance Checbox");
		jsClick(empEditDeleteAttendance, "Edit Delete Attendance Checbox");
		DisplayLogUtils.displayLog("End of AttendanceConfigurationPageNew->toggleEmpEditDeleteAttendance() " + ListenerClass.executionOrdercounter);
		return this;
	}
	
	public AttendanceConfigurationPageNew toggleSupervisorAddEditDeleteAttendance()
	{
		DisplayLogUtils.displayLog("Begin of AttendanceConfigurationPage->toggleSupervisorAddEditDeleteAttendance() " + ListenerClass.executionOrdercounter++);
//		click(SupervisorAddEditDeleteAttendance, WaitStrategy.PRESENCE,"Supervisor AddEditDelteAttendance Checbox");
		jsClick(SupervisorAddEditDeleteAttendance,"Supervisor AddEditDelteAttendance Checbox");
		DisplayLogUtils.displayLog("End of AttendanceConfigurationPage->toggleSupervisorAddEditDeleteAttendance() " + ListenerClass.executionOrdercounter);
		return this;
	}

	
	public AttendanceConfigurationPageNew SaveConfiguration()
	{
		DisplayLogUtils.displayLog("Begin of AttendanceConfigurationPage->SaveConfiguration() " + ListenerClass.executionOrdercounter++);

//		click(btnSave, WaitStrategy.PRESENCE,"Save Button");
		click(btnSave,"Save Button");
		DisplayLogUtils.displayLog("End of AttendanceConfigurationPage->SaveConfiguration() " + ListenerClass.executionOrdercounter);
		return this;
	}
	
	public AttendanceConfigurationPageNew setExpectedInitialCheckboxStatus()
	{
		DisplayLogUtils.displayLog("Begin of AttendanceConfigurationPage->setExpectedInitialCheckboxStatus() " + ListenerClass.executionOrdercounter++);
		if(!getEmpChangeCurrentTimeCheckBoxStatus())
		{	
			toggleEmpChangeCurrentTime();
			DisplayLogUtils.displaySimpleLog("Checked CurrentTime checkbox - TRUE");
		}
		else
			DisplayLogUtils.displaySimpleLog("Unchecked touch EmpCurrentTime checkbox - FALSE");

		if(getEmpEditDeleteAttendanceCheckBoxStatus())
		{
			/*
			 * try { Thread.sleep(4000l); } catch (InterruptedException e) { // TODO
			 * Auto-generated catch block e.printStackTrace(); }
			 */
			
			toggleEmpEditDeleteAttendance();
			DisplayLogUtils.displaySimpleLog("Unchecked EmpAttendance checkbox");
		}
		else 
			DisplayLogUtils.displaySimpleLog("Checked EmpAttendance checkbox");

		if(getSupervisorAddEditDeleteAttendanceCheckBoxStatus())
		{
			toggleSupervisorAddEditDeleteAttendance();
			DisplayLogUtils.displaySimpleLog("Unchecked SupervisorAttendance checkbox");
		}
		else
			DisplayLogUtils.displaySimpleLog("Checked SupervisorAttendance checkbox");
	
		DisplayLogUtils.displayLog("End of AttendanceConfigurationPage->setExpectedInitialCheckboxStatus() " + ListenerClass.executionOrdercounter);

		return this;
	}
	
	
	public AttendanceConfigurationPageNew getAndVerifyBoxStatus(String checkBoxName, boolean status)
	{
		DisplayLogUtils.displayLog("Begin of AttendanceConfigurationPage->getAndVerifyBoxStatus() " + ListenerClass.executionOrdercounter++);
		switch(checkBoxName)
		{
			case "CURRETNDATETIME" :
				boolean statusEmpCurrentTimeCheckBox = getEmpChangeCurrentTimeCheckBoxStatus();
				Assertions.assertThat(statusEmpCurrentTimeCheckBox)
					.as("ERROR=> statusEmpCurrentTimeCheckBox (1) Check box is not " + (status ? "enabled":"disabled"))
					.isEqualTo(status);
					break;
			case "ATTENDANCE":
				boolean statusEmpEditDeleteAttendanceCheckBox = getEmpEditDeleteAttendanceCheckBoxStatus();
				Assertions.assertThat(statusEmpEditDeleteAttendanceCheckBox)
					.as("ERROR=> statusEmpEditDeleteAttendanceCheckBox (2) Check box is not " + (status ? "enabled":"disabled"))
					.isEqualTo(status);
				break;
			case "SUPERVISORATTENDANCE":
				boolean statusSupervisorAddEditDeleteAttendanceCheckBox = getSupervisorAddEditDeleteAttendanceCheckBoxStatus();
				Assertions.assertThat(statusSupervisorAddEditDeleteAttendanceCheckBox)
					.as("ERROR=> statusSupervisorAddEditDeleteAttendanceCheckBox (3) Check box is not " + (status ? "enabled":"disabled"))
					.isEqualTo(status);
		}
		DisplayLogUtils.displayLog("End of AttendanceConfigurationPage->getAndVerifyBoxStatus() " + ListenerClass.executionOrdercounter);
		return this;
	}
}
