package com.cs.tests;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.assertj.core.api.Assertions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.cs.annotations.FrameworkAnnotation;
import com.cs.enums.AuthorType;
import com.cs.enums.CategoryType;
import com.cs.exceptions.ElementNotFoundException;
import com.cs.exceptions.PropertyFileUsageException;
import com.cs.listeners.ListenerClass;
import com.cs.pages.AddCustomerPageNew;
import com.cs.pages.CustomerHomePageNew;
import com.cs.pages.OrangeHRMLoginPageNew;
import com.cs.pages.TopMenuNew;
import com.cs.utils.DecodeUtils;
import com.cs.utils.DisplayLogUtils;
import com.cs.utils.GenerateRandomString;

public final class CustomerHomeTestsNew extends BaseTest {

	private CustomerHomeTestsNew() {
	}
	
	@FrameworkAnnotation(author= {AuthorType.RISHI}, category = {CategoryType.MINIREGRESSION})
	@Test()
	public void VerifySortingOrderOfCustomerTable(Map<String, String> data)
	{
		DisplayLogUtils.displayLog("Begin of CustomerHomeTests.VerifySortingORderOfCustomerTable() ->" + ListenerClass.executionOrdercounter++);

		//login to application
		String homePageTitle = new OrangeHRMLoginPageNew()
				.logInToApplication(data.get("username"), DecodeUtils.getDecodedString(data.get("password"))).getTitle();
		// verify Login was successful
		Assert.assertEquals(homePageTitle, "OrangeHRM", "ERROR=>Home Page Title doesnot match ! actual was " + homePageTitle + " and expected was OrangeHRM");
		
		// move to CustomerHomePage
		// add new customer by clicking on Add Button
		CustomerHomePageNew chpn = new TopMenuNew()
															.getTimeMenuOption()
															.getProjectinfoMenuOption()
															.getCustomersMenuOption();	
		boolean isNameFiledPresent = chpn.waitUntilElementIsDisplayed();
		List<HashMap<String, String>> listOfMapsArrAscOrg;
		if (isNameFiledPresent)
		{
			DisplayLogUtils.displayLog("INSIDE isNAMEFieldPresent***************************************");
		    listOfMapsArrAscOrg = chpn.getCustomerDetails();
			chpn.displayCustomerList("\n\n\n\nList of customers collected from customer  table  ORG ASC: ", listOfMapsArrAscOrg);
		}
		else
			throw new  ElementNotFoundException("Name element is not present on CustomerHomePage");

		// below logic is applied to check if ASC and DESC customer link works similar way all the time
		// we could have fetched the query data from database and compare with table data retrieved from the web page
		
		// click on Customer field of a customer table twice to get this table show list of customers in desc order
		chpn.clickOnLinkCustomerHeader();   // to open a Ascending and descending menu
		chpn.clickOnLinkCustomerHeaderDesc(); // Make name in ascending order
		isNameFiledPresent = false;
		isNameFiledPresent = chpn.waitUntilElementIsDisplayed();
		List<HashMap<String, String>> listOfMapsArrDescOrg;
		if (isNameFiledPresent)
		{
			listOfMapsArrDescOrg = chpn.getCustomerDetails();
			chpn.displayCustomerList("\n\n\n\nList of customers collected from customer  table DESC : ", listOfMapsArrDescOrg);
		}
		else
			throw new  ElementNotFoundException("Name element is not present on CustomerHomePage");

		chpn.clickOnLinkCustomerHeader(); // to open a Ascending and descending menu
		chpn.clickOnLinkCustomerHeaderAsc();   // again make it name in ascending order
		isNameFiledPresent = false;
		isNameFiledPresent = chpn.waitUntilElementIsDisplayed();
		List<HashMap<String, String>> listOfMapsArrAsc;
		if (isNameFiledPresent)
		{
			listOfMapsArrAsc = chpn.getCustomerDetails();
			chpn.displayCustomerList("\n\n\n\nList of customers collected from customer  table ASC: ", listOfMapsArrAsc);
		}
		else
			throw new  ElementNotFoundException("Name element is not present on CustomerHomePage");

		// compare 2 asc customer lists now
		Assertions.assertThat(listOfMapsArrAscOrg)
				.as("both lists are not in ASC order")
				.isEqualTo(listOfMapsArrAsc);
		
	
		// make it desc now
		chpn.clickOnLinkCustomerHeader();
		chpn.clickOnLinkCustomerHeaderDesc(); // to open a Descending and descending menu
		isNameFiledPresent = false;
		isNameFiledPresent = chpn.waitUntilElementIsDisplayed();
		List<HashMap<String, String>> listOfMapsArrDesc;
		if (isNameFiledPresent)
		{
			listOfMapsArrDesc = chpn.getCustomerDetails();
			chpn.displayCustomerList("\n\n\n\nList of customers collected from customer  table DESC: ", listOfMapsArrDesc);
		}
		else
				throw new  ElementNotFoundException("Name element is not present on CustomerHomePage");
		
			// compare 2 asc customer lists now
		Assertions.assertThat(listOfMapsArrDescOrg)
				.as("both lists are not in DESC order")
				.isEqualTo(listOfMapsArrDesc);
		
		
	/*	boolean ascOrDesc = true;
		String  sortOnField  = "Customer";
		listOfMapsArr = chpn.sortOnField(listOfMapsArr, sortOnField, ascOrDesc);		
		chpn.displayList( "\n\n\n" + (ascOrDesc  ? "ASC " : "DESC ") +  " sorted on " + sortOnField + " List of Maps array content:", listOfMapsArr);
	*/	
		DisplayLogUtils.displayLog("End of CustomerHomeTests.VerifySortingORderOfCustomerTable() ->" + ListenerClass.executionOrdercounter++);

	}

	@FrameworkAnnotation(author= {AuthorType.RISHI}, category = {CategoryType.REGRESSION})
	@Test()
	public void VerifyAddCustomerTestNew(Map<String, String> data)
	{

		DisplayLogUtils.displayLog("Begin of CustomerHomeTests.VerifyAddCustomerTest() ->" + ListenerClass.executionOrdercounter++);

		//login to application
		String homePageTitle = new OrangeHRMLoginPageNew()
				.logInToApplication(data.get("username"), DecodeUtils.getDecodedString(data.get("password"))).getTitle();
		// verify Login was successful
		Assert.assertEquals(homePageTitle, "OrangeHRM", "ERROR=>Home Page Title doesnot match ! actual was " + homePageTitle + " and expected was OrangeHRM");
		
		// move to CustomerHomePage
		// add new customer by clicking on Add Button
				new TopMenuNew()
						.getTimeMenuOption()
						.getProjectinfoMenuOption()
						.getCustomersMenuOption()
						.clickOnAddButtonCustomer();

		// generate random customer name
		String custName = GenerateRandomString.generateName(10);
		
		CustomerHomePageNew chpn = new AddCustomerPageNew()
														.enterName(custName)
														.enterDescription("customer1 description")
														.clickSaveBtn();
		
		// Verify flashed successful message
		chpn.verifyFlashedMsg(custName + " Customer added successfully");
		
		// verify customer is added in the customer information table on customer page
		List<HashMap<String, String>> lMap = chpn.getCustomerDetails();
		chpn.verifyCustomerIsPresent(chpn.isCustNamePresentInHomePage(custName, lMap), 
											"ERROR=> " + custName + " is not added to a list of table on Customer Home Page",
											"Verified " + custName + " is present" );

		// todo: now delete the customer which was added as a part of tear down activity
		
		
		DisplayLogUtils.displayLog("End of CustomerHomeTests.VerifyAddCustomerTest() ->" + ListenerClass.executionOrdercounter);

	}

//	@Test
	public void VerifyAllCustomerDetails()
	{
		// todo: how to verify customer details on this page, should data displayed on this page 
		// to compare with database?
	}
	
	@FrameworkAnnotation(author= {AuthorType.DHARM}, category = {CategoryType.SMOKE})
	@Test()
//	@Test
	public void VerifySelectAllCheckBoxButton(Map<String, String> data)
	{
		
		DisplayLogUtils.displayLog("Begin of CustomerHomeTests.VerifySelectAllCheckBoxButton() ->" + ListenerClass.executionOrdercounter++);

		//login to application
		String homePageTitle = new OrangeHRMLoginPageNew()
				.logInToApplication(data.get("username"), DecodeUtils.getDecodedString(data.get("password"))).getTitle();
		// verify Login was successful
		Assert.assertEquals(homePageTitle, "OrangeHRM", "ERROR=>Home Page Title doesnot match ! actual was " + homePageTitle + " and expected was OrangeHRM");
		
		// move to CustomerHomePage
		TopMenuNew topMenu = new TopMenuNew();
		CustomerHomePageNew chpn  = topMenu.getTimeMenuOption()
															.getProjectinfoMenuOption()
															.getCustomersMenuOption();

		chpn.clickOnSelectAllCustomerCheckbox();
		Assertions.assertThat(chpn.verifyAllCheckboxAreSelected())
			.as("ERROR=> Some of the checkboxes are NOT selected")
			.containsOnly(true);		
		
		DisplayLogUtils.displayLog("End of CustomerHomeTests.VerifySelectAllCheckBoxButton() ->" + ListenerClass.executionOrdercounter);

	}
	
	
	//@Test
	public void deleteSingleCustomer()
	{
		// todo: How to implement?
		// should this test be here or can it be on DeletecustomerPage?
		
	}
	
	//todo:
	//@Test
	public void deleteMultipleCustomer()
	{
	}
	
}
