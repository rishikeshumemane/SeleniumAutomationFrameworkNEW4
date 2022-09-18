package com.cs.pages;

import org.openqa.selenium.By;

import com.cs.listeners.ListenerClass;
import com.cs.utils.DisplayLogUtils;

public final class DeleteCustomerPageNew extends BasePage {

	private final By title                = By.xpath("//div[@id='deleteConfModal']//h3");
	private final By lblWarning1 = By.xpath("(//div[@class='modal-body']/p)[2]");
	private final By lblWarning2 = By.xpath("(//div[@class='modal-body']/p)[3]");
	
//	private final By btnOk        = By.id("dialogDeleteBtn");
	private final By btnOk        = By.id("//*[@id='app']/div[3]//button[2]");
	
	private final By btnCancel   = By.xpath("//input[@value='Cancel'][@class='btn reset']");

	public String getOkayButtonLabelAttribute()
	{
		DisplayLogUtils.displayLog("Begin&End of DeleteCustomerPage.getOkayButtonLabelAttribute() ->" + ListenerClass.executionOrdercounter++);

		return getAttribute(btnOk, "value");
	}
	public String getCancelButtonLabelAttribute()
	{
		DisplayLogUtils.displayLog("Begin&End of DeleteCustomerPage.getCancelButtonLabelAttribute() ->" + ListenerClass.executionOrdercounter++);

		return getAttribute(btnCancel,  "value");
	}
	
	public String getlableWarning1()
	{
		DisplayLogUtils.displayLog("Begin&End of DeleteCustomerPage.getlableWarning1() ->" + ListenerClass.executionOrdercounter++);

		return getText(lblWarning1);
	}

	public String getlableWarning2()
	{
		DisplayLogUtils.displayLog("Begin&End of DeleteCustomerPage.getlableWarning2() ->" + ListenerClass.executionOrdercounter++);
		return getText(lblWarning2);
	}
	
	public String getDeleteCustomerPageTitle()
	{
		DisplayLogUtils.displayLog("Begin&End of DeleteCustomerPage.getDeleteCustomerPageTitle() ->" + ListenerClass.executionOrdercounter++);
		return getText(title);
	}
	
	public CustomerHomePageNew CancelModalWindow()
	{
		DisplayLogUtils.displayLog("Begin of DeleteCustomerPage.CancelModalWindow() ->" + ListenerClass.executionOrdercounter++);
//		click(btnCancel, waitStrategy, "Cancel Button");
		click(btnCancel, "Cancel Button");
		DisplayLogUtils.displayLog("Begin of DeleteCustomerPage.CancelModalWindow() ->" + ListenerClass.executionOrdercounter);
		return new CustomerHomePageNew();
	}
	
	public CustomerHomePageNew OkayModalWindow()
	{
		DisplayLogUtils.displayLog("Begin of DeleteCustomerPage.OkayModalWindow() ->" + ListenerClass.executionOrdercounter++);
//		click(btnOk, waitStrategy, "Okay Button");
		click(btnOk, "Okay Button");
		DisplayLogUtils.displayLog("End of DeleteCustomerPage.OkayModalWindow() ->" + ListenerClass.executionOrdercounter);
		return new CustomerHomePageNew();
	}			

	public boolean verifyCustomerDelete(String custName)
	{
 
		return true;
	}
	
		


}

