package com.stepDefinition;

import java.util.List;

import com.pages.CustomerLoginPage;
import com.pages.IndexPage;
import com.pages.MyAccountPage;
import com.pages.MyWishlistPage;
import com.pages.NewAccountPage;
import com.pages.TVPage;
import com.pages.WishListSharePage;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class Test5Steps {
	
	public IndexPage index;
	public CustomerLoginPage login;
	public NewAccountPage newAccount;
	public MyAccountPage myAccount;
	public TVPage tv;
	public MyWishlistPage wishList;
	public WishListSharePage sharePage;
	public MyWishlistPage wishList2;
	
	@Before("@Test5")
	public void tearUp() {
		IndexPage.setupDriver();
		index = new IndexPage();
	}
	
	@After("@Test5")
	public void tearDown() {
		MyWishlistPage.closeSession();
	}
	
	@Given("^click on MyAccount Link$")
	public void click_on_MyAccount_Link() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    login = index.clickMyAccount();
	}

	@Then("^Click Create Account and fill the required details$")
	public void click_Create_Account_and_fill_the_required_details(DataTable details) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		newAccount = login.clickCreateNewAccount();
		List<List<String>> formData = details.raw();
		newAccount.register(formData.get(0).get(0),formData.get(0).get(1),formData.get(0).get(2),formData.get(0).get(3),formData.get(0).get(4));
	    
	}

	@Then("^Click Register$")
	public void click_Register() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		myAccount = newAccount.clickRegister();
	}

	@Then("^Verify that the registration is done$")
	public void verify_that_the_registration_is_done() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    myAccount.verifyRegistration();
	}

	@Then("^Goto TV and add LG LCD to your wishlist$")
	public void goto_TV_and_add_LG_LCD_to_your_wishlist() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   tv = myAccount.clickTVLink();
	   wishList = tv.addToWishList();
	   
	}

	@Then("^Click SHARE WISHLIST$")
	public void click_SHARE_WISHLIST() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		sharePage = wishList.shareWishList();
	}

	@Then("^Enter email, message and then click on share wishlist$")
	public void enter_email_message_and_then_click_on_share_wishlist(DataTable shareDetails) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		List<List<String>> data = shareDetails.raw();
		wishList2 = sharePage.shareWishList(data.get(0).get(0),data.get(0).get(1));

	}

	@Then("^Verify that wishlist has been shared$")
	public void verify_that_wishlist_has_been_shared() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		wishList2.verifyShareMessage();
	}

}
