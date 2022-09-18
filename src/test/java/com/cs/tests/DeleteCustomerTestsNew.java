package com.cs.tests;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.cs.annotations.FrameworkAnnotation;
import com.cs.enums.AuthorType;
import com.cs.enums.CategoryType;
import com.cs.listeners.ListenerClass;
import com.cs.pages.AddCustomerPageNew;
import com.cs.pages.BasePage;
import com.cs.pages.CustomerHomePageNew;
import com.cs.pages.OrangeHRMLoginPageNew;
import com.cs.pages.TopMenuNew;
import com.cs.utils.DecodeUtils;
import com.cs.utils.DisplayLogUtils;
import com.cs.utils.GenerateRandomString;
import com.google.common.util.concurrent.Uninterruptibles;

public final class DeleteCustomerTestsNew extends BaseTest {

	private DeleteCustomerTestsNew() {	}
	
	/**
 
	 * Test steps:
	 * Login to application
	 * Navigate Time->Project Info -> Customers
	 * try finding out customer named ACME Ltd and click on its check box
	 * click on delete button
	 * Verify message "Not Allowed to Delete Customer(s) Which Have Time Logged Against"
	 */
	
	/*
	@FrameworkAnnotation(author= {AuthorType.RISHI}, 
								  category = {CategoryType.SMOKE})
	@Test
	public void VerifyDeletingMasterCustomer(Map<String, String> data)
	{
		
		//login to application
		String homePageTitle = new OrangeHRMLoginPageNew()
				.logInToApplication(data.get("username"), DecodeUtils.getDecodedString(data.get("password"))).getTitle();
		// verify Login was successful
		Assert.assertEquals(homePageTitle, "OrangeHRM", "ERROR=>Home Page Title doesnot match ! actual was " + homePageTitle + " and expected was OrangeHRM");
		
		
		// move to CustomerHomePage
		ExtentLogger.pass("Navigate to Customer option from main menu", true);
		
		CustomerHomePageNew chpn = new CustomerHomePageNew();
		new TopMenuNew().getTimeMenuOption().getProjectinfoMenuOption().getCustomersMenuOption();
				
		// todo: find a customer against which we have time logged in
		
		String custName = "ACME Ltd";
		ExtentLogger.pass("Click on customer checkbox having customer name " + custName);
		// Wait for table to get displayed
		boolean isNameFieldExist =  BasePage.waitUntilElementIsDisplayed();
		int rowNum;
		List<HashMap<String, String>> custList;
		if (isNameFieldExist )
		{
			 custList = chpn.getCustomerDetails();
			DisplayLogUtils.displayLog("Customer details========================> " + custList);
			rowNum = chpn.getCustNameRowNumberInHomePage(custName, custList);
			DisplayLogUtils.displayLog("RowNum where ACME LTd is present:============>" + rowNum);
		} else
		{
			DisplayLogUtils.displayLog("Customer Details could not captured...");
			throw new  ElementNotFoundException("Name Header element is not present on CustomerHomePage");
		}
		chpn.clickOnCustomerCheckBox(rowNum);
							 
		// verify flash message "for Not Allowed to Delete Customer(s) Which Have Time Logged Against
 		DisplayLogUtils.displayLog("flashed message: " + chpn.getFlashedMsgNotAllowedToDelete());
		// Verify flashed  message
		chpn.verifyFlashedMsgForUnsuccessfulDelete(custName + " Customer not deleted as expected");

		custList = chpn.getCustomerDetails();
		chpn.verifyCustomerExistance(custName, true, custList);
		
		DisplayLogUtils.displayLog("End of DeleteCustomerTests.VerifyDeletingMasterCustomer() ->" + ListenerClass.executionOrdercounter);

	}
	*/
	
	/* 
	@FrameworkAnnotation(author= {AuthorType.RISHI}, 
			  category = {CategoryType.SMOKE, CategoryType.REGRESSION})
	@Test
	public void verifyDeleteCustomerPageTitle(Map<String, String> data) {

		DisplayLogUtils.displayLog("Begin of DeleteCustomerTests.verifyDeleteCustomerPageTitle() ->" + ListenerClass.executionOrdercounter++);

		//login to application
		String homePageTitle = new OrangeHRMLoginPageNew()
				.logInToApplication(data.get("username"), DecodeUtils.getDecodedString(data.get("password"))).getTitle();
		// verify Login was successful
		Assert.assertEquals(homePageTitle, "OrangeHRM", "ERROR=>Home Page Title doesnot match ! actual was " + homePageTitle + " and expected was OrangeHRM");
		
		CustomerHomePageNew chpn = new TopMenuNew()
														.getTimeMenuOption()
														.getProjectinfoMenuOption()
														.getCustomersMenuOption();
		
		// click on first check box to delete customer and click on Delete Button for new customer
		chpn.clickOnCustomerCheckBox()
				.clickOnDeleteCustomerButton();
		Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(5));
		
		DeleteCustomerPageNew dcpn = new DeleteCustomerPageNew();
		String deleteExpectedCustomerPageTitle = "OrangeHRM - Confirmation Required";
		String deleteActualCustomerPageTitle = dcpn.getDeleteCustomerPageTitle();
		chpn.verifyExpectedActualMsg(deleteExpectedCustomerPageTitle, deleteActualCustomerPageTitle,
				 "ERROR=> epxpected warning:" + deleteExpectedCustomerPageTitle + " does not match with actual page title: " + deleteActualCustomerPageTitle,
				 deleteExpectedCustomerPageTitle + " is matching with expected label " + deleteActualCustomerPageTitle);
		
		
		String lblExpectedWarning = "Projects under selected customer will also be deleted";
		String actualWarning = dcpn.getlableWarning1(); 
     	chpn.verifyExpectedActualMsg(lblExpectedWarning, actualWarning,
				 "ERROR=> epxpected wanring:" + lblExpectedWarning + " does not match with actual warning: " + actualWarning,
				 actualWarning + " is matching with expected label " + lblExpectedWarning);
		
		lblExpectedWarning = "Delete records?";
		actualWarning =dcpn.getlableWarning2(); 
   	    chpn.verifyExpectedActualMsg(lblExpectedWarning, actualWarning,
				 "ERROR=> epxpected wanring:" + lblExpectedWarning + " does not match with actual warning: " + actualWarning,
				 actualWarning + " is matching with expected label " + lblExpectedWarning);
			
		
		String lblExpectedOnOkayButton = "Ok";
		String actualLabel = dcpn.getOkayButtonLabelAttribute();
		chpn.verifyExpectedActualMsg(lblExpectedOnOkayButton, actualLabel,"ERROR=> " + actualLabel + " does not match with " + lblExpectedOnOkayButton,
				actualLabel + " is matching with expected label " + lblExpectedOnOkayButton);
		
		
		  String lblOnCancelButton = "Cancel"; 
		  actualLabel = dcpn.getCancelButtonLabelAttribute();
		  DisplayLogUtils.displaySimpleLog("actualLabel: " + actualLabel);
		  chpn.verifyExpectedActualMsg(lblOnCancelButton, actualLabel, 
								"ERROR=> " + actualLabel + " does not match with " + lblOnCancelButton,
								actualLabel + " is matching with expected label " + lblOnCancelButton);
						
		DisplayLogUtils.displayLog("End of DeleteCustomerTests.verifyDeleteCustomerPageTitle() ->" + ListenerClass.executionOrdercounter);

	}
	
 */
	
 /*
	@FrameworkAnnotation(author= {AuthorType.RISHI}, 
			  category = {CategoryType.SMOKE, CategoryType.REGRESSION})
	@Test
	public void Delete2NewlyAddedCustomerAndVerifyCustomerIsDeletedTest(Map<String, String> data) throws Exception {
		
		DisplayLogUtils.displayLog("Begin of DeleteCustomerTests.Delete2NewlyAddedCustomerAndVerifyCustomerIsDeletedTest() ->" + ListenerClass.executionOrdercounter++);

		
		//login to application
		String homePageTitle = new OrangeHRMLoginPageNew()
				.logInToApplication(data.get("username"), DecodeUtils.getDecodedString(data.get("password"))).getTitle();
		// verify Login was successful
		Assert.assertEquals(homePageTitle, "OrangeHRM", "ERROR=>Home Page Title doesnot match ! actual was " + homePageTitle + " and expected was OrangeHRM");
		

		CustomerHomePageNew chpn = new TopMenuNew().getTimeMenuOption()
														.getProjectinfoMenuOption().getCustomersMenuOption();
		
		ExtentLogger.pass("Adding first customer...",true);
		
		// click on add Button for new customer
		chpn.clickOnAddButtonCustomer();

		// add first customer
		AddCustomerPageNew acpn = new AddCustomerPageNew();
		String custName1 = GenerateRandomString.generateName(10);
		acpn.enterName(custName1)
				.enterDescription(custName1 + " customer description")
				.clickSaveBtn();
		chpn.verifyFlashedMsg(custName1 + " Customer saved successfully");
		
		// verify new cust got added or not
		List<HashMap<String, String>> custList = chpn.getCustomerDetails();
		chpn.verifyCustomerExistance(custName1, true, custList);

		// add second customer
		// click on add Button for new customer
		ExtentLogger.pass("Adding second customer...",true);
		chpn.clickOnAddButtonCustomer();
		String custName2 = GenerateRandomString.generateName(10);
		acpn.enterName(custName2)
				.enterDescription(custName2 + " customer description")
				.clickSaveBtn();

		chpn.verifyFlashedMsg(custName2 + " Customer saved successfully");

		// verify new cust got added or not
		custList = chpn.getCustomerDetails();
		chpn.verifyCustomerExistance(custName2, true, custList);

		ExtentLogger.pass("Deleting 2 customers...",true);
		// delete newly added customer
		int rowNum1 = chpn.getCustNameRowNumberInHomePage(custName1, custList);
		chpn.clickOnCustomerCheckBox(rowNum1);
		int rowNum2 = chpn.getCustNameRowNumberInHomePage(custName2, custList);
		chpn.clickOnCustomerCheckBox(rowNum2);

		chpn.clickOnDeleteCustomerButton().OkayModalWindow();

		ExtentLogger.pass("Verifying if customers are deleted...",true);
		custList = chpn.getCustomerDetails();
		chpn.verifyCustomerExistance(custName1, false, custList).verifyCustomerExistance(custName2, false, custList);

		// verify flash message for Successfully Deleted
		String actFlashedMsgSucessfulDelete= chpn.getFlashedMsgSuccessfullyDeleted(); 
		System.out.println("flashed message: " + actFlashedMsgSucessfulDelete);
		String expFlashedMsgSucessfulDelete = "Successfully Deleted";
		Assertions.assertThat(actFlashedMsgSucessfulDelete)
			.as("ERROR=> " + "Expected message: '"+expFlashedMsgSucessfulDelete+"'" + " and found '" + actFlashedMsgSucessfulDelete + "'")
			.isEqualTo(expFlashedMsgSucessfulDelete);
		
		chpn.verifyFlashedMsgForsuccessfulDelete(custName1 + " & " + custName2 + " deleted successfully");

		ExtentLogger.pass("Deletion completed for 2 customers...",true);
	
		DisplayLogUtils.displayLog("End of DeleteCustomerTests.Delete2NewlyAddedCustomerAndVerifyCustomerIsDeletedTest() ->" + ListenerClass.executionOrdercounter);

	}

	
 */
	
	/**
	 * Delete newly added customer and verify this has been deleted from customer
	 * home page search table
	 */
	@FrameworkAnnotation(author= {AuthorType.RISHI}, 
			  category = {CategoryType.SMOKE, CategoryType.REGRESSION})
	@Test
	public void DeleteNewlyAddedCustomerAndVerifyCustomerIsDeletedTest(Map<String, String> data) 
	{
	
		DisplayLogUtils.displayLog("Begin of DeleteCustomerTests.DeleteNewlyAddedCustomerAndVerifyCustomerIsDeletedTest() ->" + ListenerClass.executionOrdercounter++);

		//login to application
		String homePageTitle = new OrangeHRMLoginPageNew()
				.logInToApplication(data.get("username"), DecodeUtils.getDecodedString(data.get("password"))).getTitle();
		// verify Login was successful
		Assert.assertEquals(homePageTitle, "OrangeHRM", "ERROR=>Home Page Title doesnot match ! actual was " + homePageTitle + " and expected was OrangeHRM");
		

		CustomerHomePageNew chpn = new TopMenuNew()
													.getTimeMenuOption()
													.getProjectinfoMenuOption()
													.getCustomersMenuOption();
		
		// Add new customer by entering name, description fields
		chpn.clickOnAddButtonCustomer();

		String custName = GenerateRandomString.generateName(10);
		AddCustomerPageNew acpn =new AddCustomerPageNew()
				.enterName(custName)
				.enterDescription(custName + " customer description");
		Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
		acpn.clickSaveBtn();
		
		// wait until flashed message appears
		BasePage.waitUntilSavedSuccessfullyMsgDisplayed();
		// verify customer added flashed msg
		chpn.verifyFlashedMsg(custName + " Customer added successfully");
		BasePage.waitUntilElementIsDisplayed();
		// verify new cust got added or not
		List<HashMap<String, String>> custList = chpn.getCustomerDetails();
		chpn.verifyCustomerExistance(custName, true, custList);

		// delete newly added customer
		int rowNum = chpn.getCustNameRowNumberInHomePage(custName, custList);
		chpn.clickOnCustomerCheckBox(rowNum) 
				.clickOnDeleteCustomerButton(rowNum)
				.OkayModalWindow(); 
		
		// verify flash message for Successfully Deleted
		chpn.verifyFlashedMsgForsuccessfulDelete(custName + " Customer deleted Successfully");
		
		// verify the customer is still present on customer home page
		custList = chpn.getCustomerDetails();
		chpn.verifyCustomerExistance(custName, false, custList);
		
		DisplayLogUtils.displayLog("End of DeleteCustomerTests.DeleteNewlyAddedCustomerAndVerifyCustomerIsDeletedTest() ->" + ListenerClass.executionOrdercounter);

	}
 
}
