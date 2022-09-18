package com.cs.pages;

import org.openqa.selenium.By;

import com.cs.listeners.ListenerClass;
import com.cs.utils.DisplayLogUtils;

public final class OrangeHRMPunchInOutPage extends BasePage{

	private final By  menuTime         = By.id("menu_time_viewTimeModule");
	private final By  menuAttendance  = By.id("menu_attendance_Attendance");
	private final By  menuPunchInOut  = By.id("menu_attendance_punchIn");
	private final By  lblPunchInOut      = By.xpath("//h1");
	

	private final By  txtAttendanceDate = By.id("attendance_date");
	private final By  txtAttedanceTime  = By.id("attendance_time");
	private final By  txtAttedanceNote  = By.id("attendance_note");
	private final By  btnIn             = By.id("btnPunch");
	private final By  btnOut            = By.id("btnPunch");
	private final By  lblPunchedInTime  = By.xpath("//fieldset//li[1]/label[2]");
	private final By  lblPunchedInNote  = By.xpath("//fieldset//li[2]/label[2]");
	private final By  lblSuccessfulMsg  = By.xpath("//*[text()='Successfully Saved']");

	public void clearAttendaceDateField()
	{ 
		DisplayLogUtils.displayLog("Begin of OrangeHRMPunchInOutPage.clearAttendaceDateField() ->" + ListenerClass.executionOrdercounter++);

		clear(txtAttendanceDate);

		DisplayLogUtils.displayLog("End of OrangeHRMPunchInOutPage.clearAttendaceDateField() ->" + ListenerClass.executionOrdercounter);
	}

	public void clearAttendanceTimeField()
	{ 
		DisplayLogUtils.displayLog("Begin of OrangeHRMPunchInOutPage.clearAttendanceTimeField() ->" + ListenerClass.executionOrdercounter++);
		clear(txtAttedanceTime);
		DisplayLogUtils.displayLog("End of OrangeHRMPunchInOutPage.clearAttendanceTimeField() ->" + ListenerClass.executionOrdercounter);

	}
	
	public void clearAttedanceNoteField()
	{ 
		DisplayLogUtils.displayLog("Begin of OrangeHRMPunchInOutPage.clearAttedanceNoteField() ->" + ListenerClass.executionOrdercounter++);
		clear(txtAttedanceNote);
		DisplayLogUtils.displayLog("End of OrangeHRMPunchInOutPage.clearAttedanceNoteField() ->" + ListenerClass.executionOrdercounter);
	}
	
	public String getSucessfulSavedMsg()
	{
		DisplayLogUtils.displayLog("Begin&End of OrangeHRMPunchInOutPage.getSucessfulSavedMsg() ->" + ListenerClass.executionOrdercounter++);
		return getText(lblSuccessfulMsg);
	}
	
	public String getPunchedInTime()
	{
		DisplayLogUtils.displayLog("Begin&End of OrangeHRMPunchInOutPage.getPunchedInTime() ->" + ListenerClass.executionOrdercounter++);
		return getText(lblPunchedInTime);
	}
	
	public String getPunchedInNote()
	{
		DisplayLogUtils.displayLog("Begin&End of OrangeHRMPunchInOutPage.getPunchedInNote() ->" + ListenerClass.executionOrdercounter++);
		return getText(lblPunchedInNote);
	}
	
	public OrangeHRMPunchInOutPage mouseOverMenuTime()
	{
		DisplayLogUtils.displayLog("Begin of OrangeHRMPunchInOutPage.mouseOverMenuTime() ->" + ListenerClass.executionOrdercounter++);

		mouseOver(menuTime);
//		click(menuTime, waitStrategy, "Time Menu");
		click(menuTime, "Time Menu");

		DisplayLogUtils.displayLog("End of OrangeHRMPunchInOutPage.mouseOverMenuTime() ->" + ListenerClass.executionOrdercounter);
		return this;
	}
	
	public OrangeHRMPunchInOutPage mouseOverMenuAttendance()
	{
		DisplayLogUtils.displayLog("Begin of OrangeHRMPunchInOutPage.mouseOverMenuAttendance() ->" + ListenerClass.executionOrdercounter++);

		mouseOver(menuAttendance);
//		click(menuAttendance, waitStrategy, "Attendance Menu");
		click(menuAttendance,  "Attendance Menu");

		DisplayLogUtils.displayLog("End of OrangeHRMPunchInOutPage.mouseOverMenuAttendance() ->" + ListenerClass.executionOrdercounter);

		return this;

	}
	
	public OrangeHRMPunchInOutPage mouseOverMenuPunchInOut()
	{
		DisplayLogUtils.displayLog("Begin of OrangeHRMPunchInOutPage.mouseOverMenuPunchInOut() ->" + ListenerClass.executionOrdercounter++);

		mouseOver(menuPunchInOut);
//		click(menuPunchInOut, waitStrategy,"PunchInOut Menu");
		click(menuPunchInOut, "PunchInOut Menu");

		DisplayLogUtils.displayLog("End of OrangeHRMPunchInOutPage.mouseOverMenuPunchInOut() ->" + ListenerClass.executionOrdercounter);

		return this;
	}
	
	public void enterDate(String date)
	{
		DisplayLogUtils.displayLog("Begin of OrangeHRMPunchInOutPage.enterDate() ->" + ListenerClass.executionOrdercounter++);
		
		clearAttendaceDateField();
//		sendKeys(txtAttendanceDate, date, waitStrategy, "Date");
		sendKeys(txtAttendanceDate, date, "Date");

//		click(lblPunchInOut,waitStrategy, "Date");  // click on  Punch In label to make calender disaaper
		click(lblPunchInOut, "Date");  // click on  Punch In label to make calender disaaper

		DisplayLogUtils.displayLog("End of OrangeHRMPunchInOutPage.enterDate() ->" + ListenerClass.executionOrdercounter);

	}

	public void enterTime(String time)
	{
		DisplayLogUtils.displayLog("Begin of OrangeHRMPunchInOutPage.enterTime() ->" + ListenerClass.executionOrdercounter++);

		clearAttendanceTimeField();
//		sendKeys(txtAttedanceTime, time, waitStrategy, "Time");
		sendKeys(txtAttedanceTime, time, "Time");

		DisplayLogUtils.displayLog("End  of OrangeHRMPunchInOutPage.enterTime() ->" + ListenerClass.executionOrdercounter);
	}
	
	public void enterNote(String note)
	{
		DisplayLogUtils.displayLog("Begin of OrangeHRMPunchInOutPage.enterNote() ->" + ListenerClass.executionOrdercounter++);

		clearAttedanceNoteField();
//		sendKeys(txtAttedanceNote, note, waitStrategy, "Note");
		sendKeys(txtAttedanceNote, note, "Note");

		DisplayLogUtils.displayLog("End of OrangeHRMPunchInOutPage.enterNote() ->" + ListenerClass.executionOrdercounter);
	}
	
	public void clickBtnIn()
	{
		DisplayLogUtils.displayLog("Begin of OrangeHRMPunchInOutPage.clickBtnIn() ->" + ListenerClass.executionOrdercounter++);
//		click(btnIn, WaitStrategy.PRESENCE,"In Button");
		click(btnIn, "In Button");
		DisplayLogUtils.displayLog("End  of OrangeHRMPunchInOutPage.clickBtnIn() ->" + ListenerClass.executionOrdercounter);

	}
	
	public void clickBtnOut()
	{
		DisplayLogUtils.displayLog("Begin of OrangeHRMPunchInOutPage.clickBtnOut() ->" + ListenerClass.executionOrdercounter++);
//		click(btnOut, WaitStrategy.PRESENCE, "Out Button");
		click(btnOut, "Out Button");
		DisplayLogUtils.displayLog("End of OrangeHRMPunchInOutPage.clickBtnOut() ->" + ListenerClass.executionOrdercounter);
	}
}
