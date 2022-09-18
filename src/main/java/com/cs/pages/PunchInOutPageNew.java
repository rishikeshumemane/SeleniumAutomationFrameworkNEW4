package com.cs.pages;

import org.openqa.selenium.By;

import com.cs.constants.FrameworkConstants;
import com.cs.enums.LocatorName;
import com.cs.listeners.ListenerClass;
import com.cs.reports.ExtentLogger;
import com.cs.utils.DisplayLogUtils;
import com.cs.utils.ValidateUtils;

public final class PunchInOutPageNew extends BasePage{

	private static final By  lblPunchInOut      = By.xpath("//h1");
	private static final By  txtAttendanceDate  = By.id("attendance_date");
	private static final By  txtAttedanceTime   = By.id("attendance_time");
	private static final By  txtAttedanceNote   = By.id("attendance_note");
	private static final By  btnIn                  = By.id("btnPunch");
	private static final By  btnOut            = By.id("btnPunch");
	private static final By  lblPunchedInTime  = By.xpath("//fieldset//li[1]/label[2]");
	private static final By  lblPunchedInNote  = By.xpath("//fieldset//li[2]/label[2]");
	private static final By  lblSuccessfulMsg  = By.xpath("//div[@class='message success fadable']");
	private static final By selectCalendarMonth  = By.xpath("//select[@class='ui-datepicker-month']");
	private static final By selectCalendarYear    = By.xpath("//select[@class='ui-datepicker-year']");
	private static final String selectCalendarDay         = "//a[text()='REPLACE']";
	
	public PunchInOutPageNew selectMonthNo(int monthNo)
	{
		DisplayLogUtils.displayLog("Begin of OrangeHRMPunchInOutPage.selectMonthNo() ->" + ListenerClass.executionOrdercounter++);
		selectMonthNo(selectCalendarMonth,monthNo);
		DisplayLogUtils.displayLog("End of OrangeHRMPunchInOutPage.selectMonthNo() ->" + ListenerClass.executionOrdercounter);
		return this;
	}
	public PunchInOutPageNew selectMonthByText(String monthName)
	{
		DisplayLogUtils.displayLog("Begin of OrangeHRMPunchInOutPage.selectMonthByText() ->" + ListenerClass.executionOrdercounter++);
		selectMonthName(selectCalendarMonth,monthName);
		DisplayLogUtils.displayLog("End of OrangeHRMPunchInOutPage.selectMonthByText() ->" + ListenerClass.executionOrdercounter);
		return this;
	}
	
	public PunchInOutPageNew selectYearNo(int yearNo)
	{
		DisplayLogUtils.displayLog("Begin of OrangeHRMPunchInOutPage.selectYearNo() ->" + ListenerClass.executionOrdercounter++);
		selectYearNo(selectCalendarYear,yearNo);
		DisplayLogUtils.displayLog("End of OrangeHRMPunchInOutPage.selectYearNo() ->" + ListenerClass.executionOrdercounter);
		return this;
	}	
	public PunchInOutPageNew selectYearByText(String yearName)
	{
		DisplayLogUtils.displayLog("Begin of OrangeHRMPunchInOutPage.selectYearByText() ->" + ListenerClass.executionOrdercounter++);
		selectYearName(selectCalendarYear,yearName);
		DisplayLogUtils.displayLog("End of OrangeHRMPunchInOutPage.selectYearByText() ->" + ListenerClass.executionOrdercounter);
		return this;
	}	
	public PunchInOutPageNew selectDayNo(int dayNo)
	{
		DisplayLogUtils.displayLog("Begin of OrangeHRMPunchInOutPage.selectDayNo() ->" + ListenerClass.executionOrdercounter++);
		String newCalendarDay = selectCalendarDay.replaceAll("REPLACE", String.valueOf(dayNo));
		ExtentLogger.pass("newCalendarDay:"+ newCalendarDay  + "    selectCalendarDay:"+ selectCalendarDay);
		DisplayLogUtils.displaySimpleLog("newCalendarDay:"+ newCalendarDay  + "    selectCalendarDay:"+ selectCalendarDay);

		selectDayNo(newCalendarDay, LocatorName.XPATH, dayNo);
		DisplayLogUtils.displayLog("End of OrangeHRMPunchInOutPage.selectDayNo() ->" + ListenerClass.executionOrdercounter);
		return this;
	}	
	
	public PunchInOutPageNew clickAttendaceDateField()
	{ 
		DisplayLogUtils.displayLog("Begin of OrangeHRMPunchInOutPage.clickAttendaceDateField() ->" + ListenerClass.executionOrdercounter++);
		click(txtAttendanceDate, "Attendance field");
		DisplayLogUtils.displayLog("End of OrangeHRMPunchInOutPage.clickAttendaceDateField() ->" + ListenerClass.executionOrdercounter);
		return this;
	}
	
	public PunchInOutPageNew clearAttendaceDateField()
	{ 
		DisplayLogUtils.displayLog("Begin of OrangeHRMPunchInOutPage.clearAttendaceDateField() ->" + ListenerClass.executionOrdercounter++);
		clear(txtAttendanceDate);
		DisplayLogUtils.displayLog("End of OrangeHRMPunchInOutPage.clearAttendaceDateField() ->" + ListenerClass.executionOrdercounter);
		return this;
	}

	public PunchInOutPageNew clearAttendanceTimeField()
	{ 
		DisplayLogUtils.displayLog("Begin of OrangeHRMPunchInOutPage.clearAttendanceTimeField() ->" + ListenerClass.executionOrdercounter++);
		clear(txtAttedanceTime);
		DisplayLogUtils.displayLog("End of OrangeHRMPunchInOutPage.clearAttendanceTimeField() ->" + ListenerClass.executionOrdercounter);
		return this;
	}
	
	public PunchInOutPageNew clearAttedanceNoteField()
	{ 
		DisplayLogUtils.displayLog("Begin of OrangeHRMPunchInOutPage.clearAttedanceNoteField() ->" + ListenerClass.executionOrdercounter++);
		clear(txtAttedanceNote);
		DisplayLogUtils.displayLog("End of OrangeHRMPunchInOutPage.clearAttedanceNoteField() ->" + ListenerClass.executionOrdercounter);
		return this;
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
	
	public PunchInOutPageNew enterDate(String date)
	{
		DisplayLogUtils.displayLog("Begin of OrangeHRMPunchInOutPageNew.enterDate() ->" + ListenerClass.executionOrdercounter++);
		
		clearAttendaceDateField();
//		sendKeys(txtAttendanceDate, date, waitStrategy, "Date");
		sendKeys(txtAttendanceDate, date, "Date");
//		click(lblPunchInOut,waitStrategy, "Date");  // click on  Punch In label to make calender disaaper
		click(lblPunchInOut, "Date");  // click on  Punch In label to make calender disaaper

		DisplayLogUtils.displayLog("End of OrangeHRMPunchInOutPage.enterDate() ->" + ListenerClass.executionOrdercounter);
		return this;
	}

	public PunchInOutPageNew enterTime(String time)
	{
		DisplayLogUtils.displayLog("Begin of OrangeHRMPunchInOutPage.enterTime() ->" + ListenerClass.executionOrdercounter++);

		clearAttendanceTimeField();
//		sendKeys(txtAttedanceTime, time, waitStrategy, "Time");
		sendKeys(txtAttedanceTime, time, "Time");

		DisplayLogUtils.displayLog("End  of OrangeHRMPunchInOutPage.enterTime() ->" + ListenerClass.executionOrdercounter);
		return this;
	}
	
	public PunchInOutPageNew enterNote(String note)
	{
		DisplayLogUtils.displayLog("Begin of OrangeHRMPunchInOutPage.enterNote() ->" + ListenerClass.executionOrdercounter++);

		clearAttedanceNoteField();
//		sendKeys(txtAttedanceNote, note, waitStrategy, "Note");
		sendKeys(txtAttedanceNote, note, "Note");

		DisplayLogUtils.displayLog("End of OrangeHRMPunchInOutPage.enterNote() ->" + ListenerClass.executionOrdercounter);
		return this;
	}
	
	public PunchInOutPageNew clickBtnIn()
	{
		DisplayLogUtils.displayLog("Begin of OrangeHRMPunchInOutPage.clickBtnIn() ->" + ListenerClass.executionOrdercounter++);
//		click(btnIn, WaitStrategy.PRESENCE,"In Button");
		click(btnIn,"In Button");
		DisplayLogUtils.displayLog("End  of OrangeHRMPunchInOutPage.clickBtnIn() ->" + ListenerClass.executionOrdercounter);
		return this;
	}
	
	public PunchInOutPageNew clickBtnOut()
	{
		DisplayLogUtils.displayLog("Begin of OrangeHRMPunchInOutPage.clickBtnOut() ->" + ListenerClass.executionOrdercounter++);
//		click(btnOut, WaitStrategy.PRESENCE, "Out Button");
		click(btnOut,  "Out Button");
		DisplayLogUtils.displayLog("End of OrangeHRMPunchInOutPage.clickBtnOut() ->" + ListenerClass.executionOrdercounter);
		return this;
	}

	public void verifyFlashedMsg(String reportMsg) {
		DisplayLogUtils.displayLog("Begin of OrangeHRMPunchInOutPageNew.verifyFlashedMsg() ->" + ListenerClass.executionOrdercounter++);
		ValidateUtils.verifyMsg(FrameworkConstants.getLblFlashedSuccessfulMsg().trim(), getSucessfulSavedMsg().trim(), reportMsg);
		DisplayLogUtils.displayLog("End of OrangeHRMPunchInOutPageNEw.verifyFlashedMsg() ->" + ListenerClass.executionOrdercounter++);
	}

	public  String getmonthName(String monthNo)
	{
		String monthName = "MONTHNOTFOUND";
		switch(monthNo)
 		{
 		case "0": 
 			monthName = "Jan";
 			break;
 		case "01": 
 			monthName = "Feb";
 			break;
 		case "02": 
 			monthName = "Mar";
 			break;
 		case "03": 
 			monthName = "Apr";
 			break;
 		case "04": 
 			monthName = "May";
 			break;
 		case "05": 
 			monthName = "Jun";
 			break;
 		case "06": 
 			monthName = "Jul";
 			break;
 		case "07": 
 			monthName = "Aug";
 			break;
 		case "08": 
 			monthName = "Sep";
 			break;
 		case "09": 
 			monthName = "Oct";
 			break;
 		case "10": 
 			monthName = "Nov";
 			break;
 		case "11": 
 			monthName = "Dec";
 			break;
 		}
		return monthName;
	}
	
	public PunchInOutPageNew enterFormData(String inOutDate,String inOutTime, String inOutNote, String btnInOrOut)
	{
		if (btnInOrOut.equals("btnIn"))
		{
			if (inOutDate != null) 
				enterDate(inOutDate);
			enterTime(inOutTime)
			.enterNote(inOutNote)
			.clickBtnIn();
		} else if (btnInOrOut.equals("btnOut"))
		{
			if (inOutDate != null) 
				enterDate(inOutDate);
			enterTime(inOutTime)
			.enterNote(inOutNote)
			.clickBtnOut();			
		}
		return this;
	}
}
