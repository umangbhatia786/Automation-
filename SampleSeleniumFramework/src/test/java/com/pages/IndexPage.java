package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utility.BasePage;

public class IndexPage extends BasePage {
	
	@FindBy(xpath="//*[@id=\"nav\"]/ol/li[1]/a")
	WebElement mobileLink;
	
	@FindBy(xpath="//*[@id=\"top\"]/body/div/div/div[3]/div/div[4]/ul/li[1]/a")
	WebElement myAccount;
	
	public IndexPage() {
		PageFactory.initElements(driver, this);
	}
	
	public MobilePage clickMobileLink() {
		mobileLink.click();
		return new MobilePage();
	}
	
	public CustomerLoginPage clickMyAccount() {
		myAccount.click();
		return new CustomerLoginPage();
		
	}

}
