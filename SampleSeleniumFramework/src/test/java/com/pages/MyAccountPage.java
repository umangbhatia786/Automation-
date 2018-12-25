package com.pages;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utility.BasePage;
import com.utility.Utility;

public class MyAccountPage extends BasePage{
	
	@FindBy(xpath="//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div/div/ul/li/ul/li/span")
	WebElement successMsg;
	
	@FindBy(xpath="//*[@id=\"nav\"]/ol/li[2]/a")
	WebElement tvLink;
	
	SoftAssertions registerAssert;
	
	public MyAccountPage() {
		PageFactory.initElements(driver,this);
	}
	
	public void verifyRegistration() {
		registerAssert.assertThat(MyAccountPage.getTitle()).isEqualToIgnoringCase(Utility.MY_ACCOUNT_TITLE);
		registerAssert.assertThat(successMsg.getText()).isEqualToIgnoringCase(Utility.SUCCESS_MSG);
		registerAssert.assertAll();
	}
	
	public TVPage clickTVLink() {
		tvLink.click();
		return new TVPage();
	}
}
