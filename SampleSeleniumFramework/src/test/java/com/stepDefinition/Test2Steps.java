package com.stepDefinition;

import com.pages.IndexPage;
import com.pages.MobilePage;
import com.pages.XperiaPage;
import com.utility.BasePage;
import com.utility.LogIT;

import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Test2Steps {
	
	public IndexPage index;
	public MobilePage mobile;
	public XperiaPage xperia;
	public String price1;
	public String price2;
	
	@Before("@Test2")
	public void tearUp() {
		LogIT.startTestCase("TestCase2 - Compare Product Price");
		LogIT.info("Getting Things Ready!");
		BasePage.setupDriver();
		index = new IndexPage();
		LogIT.info("Clicking on Mobile lik");
		mobile = index.clickMobileLink();
	}
	
	@When("^Get price of Xperia on List Page$")
	public void get_price_of_Xperia_on_List_Page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		LogIT.info("Fetching price of Xperia from Mobile Page");
		price1 = mobile.getXperiaPrice();
	}

	@Then("^Get price of Xperia on Product Page$")
	public void get_price_of_Xperia_on_Product_Page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		LogIT.info("Clicking on Xperia's image");
	    xperia= mobile.clickXperiaImg();
	    LogIT.info("Fetching price of Xperia on Xperia Page");
	    price2 = xperia.getXperiaPrice();
	}

	@Then("^Comapre the two prices$")
	public void comapre_the_two_prices() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		LogIT.info("Verifying that both the prices are same");
		xperia.comparePrice(price1, price2);
	}

}
