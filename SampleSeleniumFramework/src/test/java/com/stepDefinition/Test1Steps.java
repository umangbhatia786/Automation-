package com.stepDefinition;

import com.pages.IndexPage;
import com.pages.MobilePage;
import com.utility.BasePage;
import com.utility.LogIT;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Test1Steps {
	public IndexPage index;
	public MobilePage mobile;
	public String[] initList;
	public String[] sortedList;
	
	@Before
	public void tearUp() {
		LogIT.startTestCase("TestCase1 - Verify Product Sort");
		LogIT.info("Getting Things Ready!");
		BasePage.setupDriver();
		index = new IndexPage();
		mobile = index.clickMobileLink();
	}
	
	@After
	public void tearDown() {
		LogIT.info("Closing the current Browser Session");
		BasePage.closeSession();
		LogIT.endTestCase("TestCase1 - Verify Product Sort");
	}
	@When("^Select SORT BY as Name$")
	public void select_SORT_BY_as_Name() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		LogIT.info("Fetching intitial Product List");
		initList = mobile.getProductList();
		LogIT.info("Sorting the products by name");
		mobile.sortByName();
		LogIT.info("Fetching the sorted Product List");
		sortedList = mobile.getProductList();
	    
	}

	@Then("^Products are sorted by Name$")
	public void products_are_sorted_by_Name() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		LogIT.info("Verifying that Products have been sorted by Name");
	    mobile.verifySort(initList,sortedList);
	}

}
