package com.cs.pages;

import org.openqa.selenium.By;

import com.cs.listeners.ListenerClass;
import com.cs.utils.DisplayLogUtils;

public final class temp extends BasePage{
	
	private static final By lblPageHeader  = By.xpath("//h1");
	private final By txtName        = By.id("addCustomer_customerName");
	private final By txtDescription = By.id("addCustomer_description");
	private final By btnSave        = By.id("btnSave");
	private final By btnCancel      = By.id("btnCancel");
	
	private final By lblrequiredBy  = By.xpath("//fieldset//ol//li[3]");
	private final By lblrequired     = By.xpath("//span[@for='addCustomer_customerName']");
	private final By lblName        = By.xpath("//*[@id='frmAddCustomer']/fieldset/ol/li[1]/label");
	private final By lblDescription = By.xpath("//*[@id='frmAddCustomer']/fieldset/ol/li[2]/label");
	
	/**
	 * getPageHeader returns page header
	 * 
	 * @param waitStrategy: Element wait strategy like VISIBLE, PRESENCE, CLICKABLE etc.
	 * @return page header/label
	 */
	public String getPageHeader()
	{
		DisplayLogUtils.displayLog("Being of AddCustomerPage.getPageHeader ->" + ListenerClass.executionOrdercounter++);
		return getText(lblPageHeader);
	}
	
	
	/**
	 * enterName allow to enter name 
	 * @param name: actual name to be entered
	 * @param waitStrategy: Element wait strategy like VISIBLE, PRESENCE, CLICKABLE etc.
	 * @return AddCustomer object
	 */
	public temp enterName(String name)
	{
		DisplayLogUtils.displayLog("Begin of AddCustomerPage.enterName ->" + ListenerClass.executionOrdercounter++);

		sendKeys(txtName, name, "Name");
		DisplayLogUtils.displayLog("End of AddCustomerPage.enterName ->" + ListenerClass.executionOrdercounter++);

		return this;
	}
	
	
	/**
	 * enterName allow to enter description 
	 * @param name: actual name to be entered
	 * @param waitStrategy: Element wait strategy like VISIBLE, PRESENCE, CLICKABLE etc.
	 * @return AddCustomer object
	 */
	public temp enterDescription(String name)
	{
		DisplayLogUtils.displayLog("Begin of AddCustomerPage.enterDescription ->" + ListenerClass.executionOrdercounter++);

		sendKeys(txtDescription, name,"Description");
		return this;
	}
	
	
	
	public CustomerHomePageNew clickSaveBtn()
	{
		DisplayLogUtils.displayLog("Begin of AddCustomerPage.clickSaveBtn ->" + ListenerClass.executionOrdercounter++);

//		click(btnSave, waitStrategy,"Save Button");
		click(btnSave,"Save Button");
		return new CustomerHomePageNew();
	}
	
	
	
	public CustomerHomePageNew clickCancelBtn()
	{
		DisplayLogUtils.displayLog("Begin of AddCustomerPage.clickCancelBtn ->" + ListenerClass.executionOrdercounter++);

//		click(btnCancel, waitStrategy, "Cancel Button");
		click(btnCancel, "Cancel Button");
		return new CustomerHomePageNew();
	}
	
	
	// getLabel
	public String getRequiredByLabel()
	{
		DisplayLogUtils.displayLog("Begin of AddCustomerPage.getRequiredByLabel ->" + ListenerClass.executionOrdercounter++);

		return getText(lblrequiredBy);
	}
	
	public String getNameByLabel()
	{
		DisplayLogUtils.displayLog("Begin of AddCustomerPage.getNameByLabel ->" + ListenerClass.executionOrdercounter++);

		return getText(lblName);
	}
	public String getDescriptionByLabel()
	{
		DisplayLogUtils.displayLog("Begin of AddCustomerPage.getDescriptionByLabel ->" + ListenerClass.executionOrdercounter++);

		return getText(lblDescription);
	}
	public String getSaveButtonByLabel()
	{
		DisplayLogUtils.displayLog("Begin of AddCustomerPage.getSaveButtonByLabel ->" + ListenerClass.executionOrdercounter++);

		return getAttribute(btnSave, "value");
	}
	public String getCancelButtonByLabel()
	{
		DisplayLogUtils.displayLog("Begin of AddCustomerPage.getCancelButtonByLabel ->" + ListenerClass.executionOrdercounter++);

		return getAttribute(btnCancel, "value");
	}
	
	public String getErrorMessage()
	{
		DisplayLogUtils.displayLog("Begin of AddCustomerPage.getErrorMessage ->" + ListenerClass.executionOrdercounter++);

		return getText(lblrequired);
	}
	
	
}
