package com.cs.tests;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.assertj.core.api.Assertions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.cs.annotations.FrameworkAnnotation;
import com.cs.enums.AuthorType;
import com.cs.enums.CategoryType;
import com.cs.listeners.ListenerClass;
import com.cs.pages.AddCustomerPageNew;
import com.cs.pages.CustomerHomePageNew;
import com.cs.pages.OrangeHRMLoginPageNew;
import com.cs.pages.TopMenuNew;
import com.cs.utils.DecodeUtils;
import com.cs.utils.DisplayLogUtils;
import com.cs.utils.GenerateRandomString;
import com.cs.utils.LoginUtils;
import com.google.common.util.concurrent.Uninterruptibles;

public final class AddCustomerTestsNew extends BaseTest {

	private AddCustomerTestsNew() {}

	
	/**
	 * addCustomerBlankNameTest: test case to verify when user keeps blank name and try to save should error out
	 */
	@FrameworkAnnotation(author= {AuthorType.RISHI, AuthorType.DHARM}, 
								category = {CategoryType.REGRESSION, CategoryType.MINIREGRESSION, CategoryType.SMOKE})
 	@Test()
	public void addCustomerBlankNameTest(Map<String, String> data)  // todo: addCsutoemrWithoutName
	{
		
		DisplayLogUtils.displayLog("Begin of AddCustomerTests.addCustomerBlankNameTest() ->" + ListenerClass.executionOrdercounter++);
 		
		//todo: utility method void LoginToApplication() add to utils package
		//login to application
		String homePageTitle = new OrangeHRMLoginPageNew()
											.logInToApplication(data.get("username"), DecodeUtils.getDecodedString(data.get("password")))
											.getTitle();
		// verify Login was successful
		Assert.assertEquals(homePageTitle, "OrangeHRM", "ERROR=>Home Page Title doesnot match ! actual was " + homePageTitle + " and expected was OrangeHRM");
		
		// move to CustomerHomePage
		TopMenuNew topMenu = new TopMenuNew();
		CustomerHomePageNew  chnp = topMenu.getTimeMenuOption()
															.getProjectinfoMenuOption()
															.getCustomersMenuOption();
		AddCustomerPageNew  acpn = chnp.clickOnAddButtonCustomer();
		// without adding a new customer name click on Save button and verify it shows an error as "Required"
		acpn.clickSaveBtn();
		
		// verify error message
		Assertions.assertThat(acpn.getErrorMessage())
					.as("ERROR=> Blank Name is allowed").isEqualTo("Required");
		
		DisplayLogUtils.displayLog("end of AddCustomerTests.addCustomerBlankNameTest() ->" + ListenerClass.executionOrdercounter);

	}
	
 	/** Add new customer and verify this has been added to customer home page search table */
	@FrameworkAnnotation(author= {AuthorType.RISHI}, 
								category = {CategoryType.REGRESSION, CategoryType.MINIREGRESSION, CategoryType.SMOKE})
	@Test
	public void AddAndVerifyNewCustomerTest(Map<String, String> data)
	{
 		
		DisplayLogUtils.displayLog("Begin of AddCustomerTests.AddAndVerifyNewCustomerTest() ->" + ListenerClass.executionOrdercounter++);

		LoginUtils.loginToAppl(data.get("username"), data.get("password"));
		
		TopMenuNew topMenu = new TopMenuNew();
		CustomerHomePageNew chpn = topMenu.getTimeMenuOption()
														.getProjectinfoMenuOption()
														.getCustomersMenuOption();
 	
		chpn.clickOnAddButtonCustomer();
		
		AddCustomerPageNew acpn = new AddCustomerPageNew();
		// generate random customer name
		String custName = GenerateRandomString.generateName(10);
		acpn.enterName(custName);
		acpn.enterDescription(custName + " customer description");
		
		// wait until Save button is visible clickable
		Uninterruptibles.sleepUninterruptibly(20, TimeUnit.SECONDS);
		chpn = acpn.clickSaveBtn();
		Uninterruptibles.sleepUninterruptibly(20, TimeUnit.SECONDS);

		List<HashMap<String, String>> lMap = chpn.getCustomerDetails();
		DisplayLogUtils.displayLog("lMap contents: " + lMap);
		DisplayLogUtils.displayLog("CustName     : " + custName);	
		Assertions.assertThat(chpn.isCustNamePresentInHomePage(custName, lMap))
								.as("ERROR=> " + custName + " is not added to a list of table on Customer Home Page").isTrue();

		DisplayLogUtils.displayLog("End of AddCustomerTests.AddAndVerifyNewCustomerTest() ->" + ListenerClass.executionOrdercounter);

	}

	/** Verifies if Add Customer page has proper title*/
	@FrameworkAnnotation(author= {AuthorType.RISHI, AuthorType.DHARM}, 
			category = {CategoryType.REGRESSION, CategoryType.MINIREGRESSION, CategoryType.SMOKE})
 	@Test
	public void verifyAddCustomerPageTitle(Map<String, String> data)
	{
		DisplayLogUtils.displayLog("Begin of AddCustomerTests.verifyAddCustomerPageTitle() ->" + ListenerClass.executionOrdercounter++);

		LoginUtils.loginToAppl(data.get("username"), data.get("password"));

		CustomerHomePageNew chpn = new TopMenuNew().getTimeMenuOption().getProjectinfoMenuOption().getCustomersMenuOption();
		
		chpn.clickOnAddButtonCustomer();
		Assertions.assertThat(chpn.getPageHeader())
			.as("ERROR=> 'Add Customer' page title is not present")
			.isEqualTo("Add Customer");
		DisplayLogUtils.displayLog("End of AddCustomerTests.verifyAddCustomerPageTitle() ->" + ListenerClass.executionOrdercounter);

	}
	
	/**
	 * Verifies all the labels present on the page
	 */
	@FrameworkAnnotation(author= {AuthorType.RISHI, AuthorType.DHARM}, 
			category = {CategoryType.REGRESSION, CategoryType.MINIREGRESSION, CategoryType.SMOKE})
 	@Test
	public void verifyAllLabelsOnAddCustomerPage(Map<String, String> data)
	{
		DisplayLogUtils.displayLog("Begin of AddCustomerTests.verifyAllLabelsOnAddCustomerPage() ->" + ListenerClass.executionOrdercounter++);
 
		LoginUtils.loginToAppl(data.get("username"), data.get("password"));

		CustomerHomePageNew chpn = new TopMenuNew()
															.getTimeMenuOption()
															.getProjectinfoMenuOption()
															.getCustomersMenuOption();
		DisplayLogUtils.displayLog("Begin of ADD Button click ->" + ListenerClass.executionOrdercounter);
		AddCustomerPageNew acpn = chpn.clickOnAddButtonCustomer();
		DisplayLogUtils.displayLog("End of ADD Button click ->" + ListenerClass.executionOrdercounter);

		// temp wait to see if navigation lands on add customer page or not
		Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(5));
		
		// Get Label for Name field 
		Assertions.assertThat(acpn.getNameByLabel())
			.as("ERROR=>Label 'Name ' is not present")
			.isEqualTo("Name");
		
		// Get Label for Description field 
		Assertions.assertThat(acpn.getDescriptionByLabel())
			.as("ERROR=>Label 'Description' is not present")
			.isEqualTo("Description");
		
		// Get value of a Save Button
		Assertions.assertThat(acpn.getSaveButtonByLabel())
			.as("ERROR=>Label 'Save' on Save button is not present")
			.isEqualTo("Save");
		
		// Get value of a Cancel Button
		Assertions.assertThat(acpn.getCancelButtonByLabel())
			.as("ERROR=>Label 'Cancel' on Cancel button is not present")
			.isEqualTo("Cancel");
		DisplayLogUtils.displayLog("End of AddCustomerTests.verifyAllLabelsOnAddCustomerPage() ->" + ListenerClass.executionOrdercounter);

	}

}
