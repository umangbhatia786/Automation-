package com.stepDefinition;

import com.pages.IndexPage;
import com.pages.MobilePage;
import com.utility.BasePage;
import com.utility.LogIT;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class Test4Steps {
	public IndexPage index;
	public MobilePage mobile;
	
	@Before("@Test4")
	public void tearUp() {
		LogIT.startTestCase("TestCase4 - Verify Compare Window");
		LogIT.info("Getting Things Ready!");
		BasePage.setupDriver();
		index = new IndexPage();
		LogIT.info("Clicking on Mobile lik");
		mobile = index.clickMobileLink();
	}
	
	@After("@Test4")
	public void tearDown() {
		LogIT.info("Closing current browser session");
		MobilePage.closeSession();
		LogIT.endTestCase("TestCase3 - Verify Quantity Update");
	}
	
	@Given("^Add Xperia and Iphone for comparison$")
	public void add_Xperia_and_Iphone_for_comparison() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		mobile.addXperiaIphoneToCompare();
	    
	}

	@Then("^Click on Comapre Button$")
	public void click_on_Comapre_Button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		LogIT.info("Clicking on Compare Button");
	    mobile.clickCompareBtn();
	}

	@Then("^Verify the details of Compare Products window$")
	public void verify_the_details_of_Compare_Products_window() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		LogIT.info("Verifying Compare Window now!");
	    mobile.verifyCompareWindow();
	}

}
