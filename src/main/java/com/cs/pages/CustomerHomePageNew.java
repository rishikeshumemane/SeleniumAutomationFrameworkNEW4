package com.cs.pages;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.cs.constants.FrameworkConstants;
import com.cs.enums.LocatorName;
import com.cs.factories.ExpliciteWaitFactory;
import com.cs.listeners.ListenerClass;
import com.cs.reports.ExtentLogger;
import com.cs.utils.DisplayLogUtils;
import com.cs.utils.ReadTableData;
import com.cs.utils.ValidateUtils;

public final class CustomerHomePageNew extends BasePage{

	private final By lablePageHeader            = By.xpath("//*[@id='app']/div[1]/div[2]//h6");
//	private final By btnAdd                              = By.xpath("//*[@id='app']//div/div/div[1]/div/button");
	private final By btnAdd                              = By.xpath("//*[@id='app']//div/div/div[1]/div/button");
//	private final By btnDelete                          = By.id("btnDelete");
	private final By btnDelete                          = By.id("//*[@id='app']//div[3]/button[2]");
	
	private final By firstCustomerCheckBox = By.xpath("//tbody/tr[1]/td[1]/input");
	private final By firstCustomerName         = By.xpath("//tbody/tr[1]/td[2]/a");
	private final By linkCustomerHeader       = By.xpath("//*[@id='app']//div[2]/div/i");
	private final By descOrderOption             = By.xpath("//*[@id='app']//div/ul/li[2]/span");
	private final By ascOrderOption               = By.xpath("//*[@id='app']//div[2]//div//li[1]/span");

	final String checkBoxExpextedRowNumber                = "//*[@id='app']//div[REPLACEROWNUMBER]/div/div[4]/div/button[1]";
	private final By selectAllCustomerCheckbox             = By.id("ohrmList_chkSelectAll");
	private final String cheboxLocatorString                     = "(//tbody/tr/td/input)[REPLACE]";
	private final By lblFlashedMsgSuccessfullyDeleted  = By.xpath("//div[@class='message success fadable']");
//	private final By FlashedMsgNotAllowedToDelete     = By.xpath("//div[@class='message error fadable']");
	private final By FlashedMsgNotAllowedToDelete     = By.xpath("//*[@id='oxd-toaster_1']/div/div[1]/div[2]/p[2]");
	

//	private final By flashedSuccessfulMsg = By.xpath("//div[@class='message success fadable']");
	private final By flashedSuccessfulMsg = By.xpath("//*[@id='oxd-toaster_1']//p[2]");
	

//	private final String tableRows           = "//tbody//tr";
	private final String tableRows        = "//*[@id='app']/div[1]/div[2]/div[2]/div/div/div[3]/div/div[2]/div/div";
	
//	private final String tableRowElement     = "td";
	private final String tableRowElement  = "div/div";
	
//	private final String tableHeaderPart1 = "//thead//tr//th[";
	private final String tableHeaderPart1 = "//*[@id='app']//div[3]/div/div[1]/div/div[";
//	private final String tableHeaderPart2    = "]";
	private final String tableHeaderPart2 = "]";
	
	private TopMenuNew topMenu;
	
	public CustomerHomePageNew()
	{
		// not used in FW but to understand this concept.
		// this is a composition concept
		// where private instance variable topMenu is defined of type MenuOption
		// topMenu is ready to use in this page and can call all methods from TopMenu class
		topMenu = new TopMenuNew();
	}
	
	public void verifyCustomerIsPresent(boolean result, String errorMsg, String reportMsg)
	{
		verifyTrue(result, errorMsg,  reportMsg);
	}

	// *** Is it okay to have verification in page??? No
	public void verifyFlashedMsg(String reportMsg) {
		DisplayLogUtils.displayLog("Begin of CustomerHomePageNew.verifyFlashedMsg() ->" + ListenerClass.executionOrdercounter++);
		ValidateUtils.verifyMsg(FrameworkConstants.getLblFlashedSuccessfulMsg().trim(), getFlashedSuccessfulMsg().trim(), reportMsg);
		DisplayLogUtils.displayLog("End of CustomerHomePageNew.verifyFlashedMsg() ->" + ListenerClass.executionOrdercounter++);
	}

	public void verifyFlashedMsgForsuccessfulDelete(String reportMsg) {
		DisplayLogUtils.displayLog("Begin of CustomerHomePageNew.verifyFlashedMsgForsuccessfulDelete() ->" + ListenerClass.executionOrdercounter++);
		ValidateUtils.verifyMsg(FrameworkConstants.getLblFlashedSuccessfulMsgForDelete().trim(), getFlashedMsgSuccessfullyDeleted().trim(), reportMsg);
		DisplayLogUtils.displayLog("End of CustomerHomePageNew.verifyFlashedMsgForsuccessfulDelete() ->" + ListenerClass.executionOrdercounter++);
	}

	public void verifyFlashedMsgForUnsuccessfulDelete(String reportMsg) {
		DisplayLogUtils.displayLog("Begin of CustomerHomePageNew.verifyFlashedMsgForUnsuccessfulDelete() ->" + ListenerClass.executionOrdercounter++);
		ValidateUtils.verifyMsg(FrameworkConstants.getLblFlashedUnSuccessfulMsgForDelete().trim(), getFlashedMsgNotAllowedToDelete().trim(), reportMsg);
		DisplayLogUtils.displayLog("End of CustomerHomePageNew.verifyFlashedMsgForUnsuccessfulDelete() ->" + ListenerClass.executionOrdercounter++);
	}

	public String getFlashedSuccessfulMsg()
	{
		DisplayLogUtils.displayLog("Begin&End of CustomerHomePageNew.getFlashedSuccessfulMsg() ->" + ListenerClass.executionOrdercounter++);
		return getText(flashedSuccessfulMsg);
	}

	public String getFlashedMsgNotAllowedToDelete()
	{
		DisplayLogUtils.displayLog("Begin&End of CustomerHomePage.getFlashedMsgNotAllowedToDelete() ->" + ListenerClass.executionOrdercounter++);

		return getText(FlashedMsgNotAllowedToDelete);
	}

	public String getFlashedMsgSuccessfullyDeleted()
	{
		DisplayLogUtils.displayLog("Begin&End of CustomerHomePage.getFlashedMsgSuccessfullyDeleted() ->" + ListenerClass.executionOrdercounter++);
		return getText(lblFlashedMsgSuccessfullyDeleted);
	}

	public List<Boolean> verifyAllCheckboxAreSelected()
	{
		DisplayLogUtils.displayLog("Begin&End of CustomerHomePage.verifyAllCheckboxAreSelected() ->" + ListenerClass.executionOrdercounter++);
		List<Boolean> checbboxStatus = getAllCheckboxStatus(cheboxLocatorString, LocatorName.XPATH);
		return checbboxStatus;
	}

	public CustomerHomePageNew clickOnSelectAllCustomerCheckbox()
	{
		DisplayLogUtils.displayLog("Begin&End of CustomerHomePage.clickOnSelectAllCustomerCheckbox() ->" + ListenerClass.executionOrdercounter++);
//		click(selectAllCustomerCheckbox, WaitStrategy.PRESENCE, "SelectAllCheckbox");
		click(selectAllCustomerCheckbox, "SelectAllCheckbox");
		return this;
	}
	public CustomerHomePageNew clickOnCustomerCheckBox()
	{
		DisplayLogUtils.displayLog("Begin&End of CustomerHomePage.clickOnCustomerCheckBox() ->" + ListenerClass.executionOrdercounter++);
//		click(firstCustomerCheckBox, WaitStrategy.PRESENCE,"First checkbox");
		click(firstCustomerCheckBox,"First checkbox");
		return this;
	}


	public CustomerHomePageNew clickOnCustomerCheckBox(int rowNum)
	{
		DisplayLogUtils.displayLog("Begin of CustomerHomePage.clickOnCustomerCheckBox(rowNum) ->" + ListenerClass.executionOrdercounter++);


		String path = checkBoxExpextedRowNumber.replace("REPLACEROWNUMBER",String.valueOf(rowNum));
		By custCheckBox = By.xpath(path);
//		click(custCheckBox, WaitStrategy.PRESENCE, "Rownumber: " + String.valueOf(rowNum)+" Checkbox");
		click(custCheckBox, "Rownumber: " + String.valueOf(rowNum)+" Checkbox");

		DisplayLogUtils.displayLog("End of CustomerHomePage.clickOnCustomerCheckBox(rowNum) ->" + ListenerClass.executionOrdercounter);

		return this;
	}



	public String getfirstCustomerName()
	{
		DisplayLogUtils.displayLog("Begin&End of CustomerHomePage.getfirstCustomerName() ->" + ListenerClass.executionOrdercounter++);

		return getText(firstCustomerName);
	}

 

	public String getPageHeader()
	{
		DisplayLogUtils.displayLog("Begin&End of CustomerHomePage.getPageHeader() ->" + ListenerClass.executionOrdercounter++);

		return getText(lablePageHeader);
	}

	public AddCustomerPageNew clickOnAddButtonCustomer()
	{
		DisplayLogUtils.displayLog("Begin of CustomerHomePage.clickOnAddButtonCustomer() ->" + ListenerClass.executionOrdercounter++);
		click(btnAdd,"Add Button");
		DisplayLogUtils.displayLog("End of CustomerHomePage.clickOnAddButtonCustomer() ->" + ListenerClass.executionOrdercounter);

		return new AddCustomerPageNew();
	}


	public List<HashMap<String, String>> getCustomerDetails()
	{
		DisplayLogUtils.displayLog("Begin&End of CustomerHomePage.getCustomerDetails() ->" + ListenerClass.executionOrdercounter++);

//		return ReadTableData
//				.getTableData(tableRows, tableRowElement, tableHeaderPart1, tableHeaderPart2, 0); // start reading table from 0throw (including header)
		return ReadTableData
				.getTableDataNew(tableRows, tableRowElement, tableHeaderPart1, tableHeaderPart2, 1); // start reading table from 1strow (including header)
	}

	public int getCustNameRowNumberInHomePage(String custName, List<HashMap<String, String>> lMap)
	{
		DisplayLogUtils.displayLog("Begin of CustomerHomePage.getCustNameRowNumberInHomePage() ->" + ListenerClass.executionOrdercounter++);

		int rowNumber = 1;
		DisplayLogUtils.displayLog("lMap.size================"+ lMap.size());
		for(int i=0;i<lMap.size();i++)
		{
			rowNumber++;
			String lMapCustName = lMap.get(i).get("Name");
			DisplayLogUtils.displayLog("lMapCustName========> " + lMapCustName);
			if (lMapCustName.equalsIgnoreCase(custName))
				break;
		}
		DisplayLogUtils.displaySimpleLog("rownNumber:" + rowNumber);
		DisplayLogUtils.displayLog("End of CustomerHomePage.getCustNameRowNumberInHomePage() ->" + ListenerClass.executionOrdercounter);

		return rowNumber;
	}

	public boolean isCustNamePresentInHomePage(String custName, List<HashMap<String, String>> lMap)
	{
		DisplayLogUtils.displayLog("Begin of CustomerHomePage.isCustNamePresentInHomePage() ->" + ListenerClass.executionOrdercounter++);

		boolean isCustNamePresent = false;
		for(int i=0;i<lMap.size();i++)
		{
			String lMapCustName = lMap.get(i).get("Name");  //Customer
			if (lMapCustName.equalsIgnoreCase(custName))
			{
				isCustNamePresent = true;
				break;
			}
		}
		DisplayLogUtils.displayLog("End of CustomerHomePage.isCustNamePresentInHomePage() ->" + ListenerClass.executionOrdercounter);

		return isCustNamePresent;
	}

	public DeleteCustomerPageNew clickOnDeleteCustomerButton(int rowNum)
	{
		DisplayLogUtils.displayLog("Begin of CustomerHomePage.clickOnDeleteCustomerButton() ->" + ListenerClass.executionOrdercounter++);

//		click(btnDelete, waitStrategy, "Delete Button");
		click(btnDelete, "Delete Button");
		DisplayLogUtils.displayLog("End of CustomerHomePage.clickOnDeleteCustomerButton() ->" + ListenerClass.executionOrdercounter);

		return new DeleteCustomerPageNew();
	}

	public CustomerHomePageNew verifyCustomerExistance(String custName, boolean expResult, List<HashMap<String,String>> custList)
	{
		DisplayLogUtils.displayLog("Begin of CustomerHomePage.verifyCustomerExistance() ->" + ListenerClass.executionOrdercounter++);

		if (expResult)
			Assertions.assertThat(isCustNamePresentInHomePage(custName, custList))
			.as("ERROR=> " + custName + " is not present in a customer list on Customer Home Page")
			.isTrue();
		else
			Assertions.assertThat(isCustNamePresentInHomePage(custName, custList))
			.as("ERROR=> " + custName + " is present in a Customer list on Customer Home Page")
			.isFalse();

		DisplayLogUtils.displayLog("End of CustomerHomePage.verifyCustomerExistance() ->" + ListenerClass.executionOrdercounter);

		return this;
	}

	public void  verifyExpectedActualMsg(String expMsg, String actMsg, String errorMsg, String reportMsg)
	{
		DisplayLogUtils.displayLog("Begin of DeleteCustomerPage.verifyMsg() -> " + ListenerClass.executionOrdercounter++);
		ValidateUtils.verifyMsg(expMsg, actMsg,  errorMsg,reportMsg);
		DisplayLogUtils.displayLog("End of DeleteCustomerPage.verifyMsg() -> " + ListenerClass.executionOrdercounter);
	}	

	// sort List of map containing customer details
	public  List<HashMap<String,String>> sortOnField(List<HashMap<String, String>> listOfMapsArr, String fieldName, boolean ascOrDesc)
	{
			if (ascOrDesc) {
				Collections.sort(listOfMapsArr, new Comparator<Map<String, String>>() 
				{
					public int compare(final Map<String, String> o1, final Map<String, String> o2) {
						return o1.get(fieldName).compareTo(o2.get(fieldName));
					}});  }
			else{
				Collections.sort(listOfMapsArr, new Comparator<Map<String, String>>() 
				{
					public int compare(final Map<String, String> o1, final Map<String, String> o2) {
						return o2.get(fieldName).compareTo(o1.get(fieldName));
					}});}
			 
		return listOfMapsArr;
	}

	// display List of HashMap content
	public  void displayCustomerList(String msg, List<HashMap<String, String>> listOfMapsArr)
	{
		DisplayLogUtils.displayLog(msg);
		ExtentLogger.pass(msg);
		for(HashMap<String, String> m: listOfMapsArr)
		{
			DisplayLogUtils.displayLog(m.get("Name")  + "  => " + m.get("Description"));
			ExtentLogger.pass(m.get("Name")  + "  => " + m.get("Description"));
		}
		DisplayLogUtils.displayLog("\n\n\n");
	}
/**
 * 
 * @return
 */
	public CustomerHomePageNew clickOnLinkCustomerHeader()
	{
		DisplayLogUtils.displayLog("Begin&End of CustomerHomePage.clickOnLinkCustomerHeader() ->" + ListenerClass.executionOrdercounter++);
		click(linkCustomerHeader,"Name Field from table column");
		return this;
	}
	
	public CustomerHomePageNew clickOnLinkCustomerHeaderAsc()
	{
		DisplayLogUtils.displayLog("Begin&End of CustomerHomePage.clickOnLinkCustomerHeader() ->" + ListenerClass.executionOrdercounter++);
		click(ascOrderOption,"Name Header Field from table column to display names in ascending order");
		return this;
	}

	public CustomerHomePageNew clickOnLinkCustomerHeaderDesc()
	{
		DisplayLogUtils.displayLog("Begin&End of CustomerHomePage.clickOnLinkCustomerHeader() ->" + ListenerClass.executionOrdercounter++);
		click(descOrderOption,"Name Header Field from table column to display names in descending order");
		return this;
	}
	
// TopMenu operations on menu - Admin, PIM, LEave etc
	public TimePageMenu clickOnAdmin()
	{
		return topMenu.clickAdmin();
	}
	
	 
	
}
