package com.stepDefinition;

import com.pages.IndexPage;
import com.pages.MobilePage;
import com.pages.ShoppingCartPage;
import com.utility.BasePage;
import com.utility.LogIT;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Test3Steps {

	public IndexPage index;
	public MobilePage mobile;
	public ShoppingCartPage cart;

	@Before
	public void tearUp() {
		LogIT.startTestCase("TestCase3 - Verify Quantity Update");
		LogIT.info("Getting Things Ready!");
		BasePage.setupDriver();
		index = new IndexPage();
		LogIT.info("Clicking on Mobile lik");
		mobile = index.clickMobileLink();
	}

	@After
	public void tearDown() {
		LogIT.info("Closing current browser session");
		BasePage.closeSession();
		LogIT.endTestCase("TestCase3 - Verify Quantity Update");
	}

	@When("^Click on ADD TO CART for Xperia$")
	public void click_on_ADD_TO_CART_for_Xperia() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		LogIT.info("Clicking on ADD TO CART Link for Xperia");
		cart = mobile.addToCart();

	}

	@Then("^Update quantity to '(\\d+)'$")
	public void update_quantity_to(int quantity) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		LogIT.info("Updating the quantity to 1000");
		cart.updateQty(Integer.toString(quantity));
	}

	@Then("^Verify the error message displayed$")
	public void verify_the_error_message_displayed() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		LogIT.info("Verifying the error message upon updating cart");
		cart.verifyUpdateError();
	}

	@Then("^Click on Empty Cart link$")
	public void click_on_Empty_Cart_link() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		LogIT.info("Clicking on Empty Cart Button");
		cart.clickEmptyCart();
	}

	@Then("^Verify the message displayed$")
	public void verify_the_message_displayed() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		LogIT.info("Verifying the message displayed");
		cart.verifyEmptyCartMsg();
	}
}
