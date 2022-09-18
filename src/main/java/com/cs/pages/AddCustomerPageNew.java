package com.cs.pages;

import org.openqa.selenium.By;

import com.cs.listeners.ListenerClass;
import com.cs.utils.DisplayLogUtils;

public final class AddCustomerPageNew extends BasePage{
	
	private static final By lblPageHeader  = By.xpath("//h1");
	private final By txtName          = By.xpath("//*[@id='app']//div[2]/input");
	private final By txtDescription = By.xpath("//*[@id='app']//textarea");
//	private final By btnSave         = By.xpath("//*[@id='app']//button[2]");
	private final By btnSave         = By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[3]/button[2]");
	
	
	private final By btnCancel      = By.xpath("//*[@id='app']//div[3]/button[1]");
	
	private final By lblrequiredBy  = By.xpath("//fieldset//ol//li[3]");
	private final By lblrequired      = By.xpath("//*[@id='app']//form//span");
	private final By lblName          = By.xpath("(//*[@id='app']//label)[1]");
	private final By lblDescription = By.xpath("(//*[@id='app']//label)[2]");
	
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
	public AddCustomerPageNew enterName(String name)
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
	public AddCustomerPageNew enterDescription(String name)
	{
		DisplayLogUtils.displayLog("Begin of AddCustomerPage.enterDescription ->" + ListenerClass.executionOrdercounter++);

		sendKeys(txtDescription, name,"Description");
		return this;
	}
	
	
	
	public CustomerHomePageNew clickSaveBtn()
	{
		DisplayLogUtils.displayLog("Begin of AddCustomerPageNew.clickSaveBtn ->" + ListenerClass.executionOrdercounter++);
		click(btnSave,"Save Button");
		DisplayLogUtils.displayLog("After Clicking on Save button ************************************************");

		return new CustomerHomePageNew();
	}
	
	
	
	public CustomerHomePageNew clickCancelBtn()
	{
		DisplayLogUtils.displayLog("Begin of AddCustomerPage.clickCancelBtn ->" + ListenerClass.executionOrdercounter++);

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

		return getText(btnSave);
		
		//return getAttribute(btnSave, "value");
		
	}
	public String getCancelButtonByLabel()
	{
		DisplayLogUtils.displayLog("Begin of AddCustomerPage.getCancelButtonByLabel ->" + ListenerClass.executionOrdercounter++);

		return getText(btnCancel);
	}
	
	public String getErrorMessage()
	{
		DisplayLogUtils.displayLog("Begin of AddCustomerPage.getErrorMessage ->" + ListenerClass.executionOrdercounter++);

		return getText(lblrequired);
	}
	
	
}
