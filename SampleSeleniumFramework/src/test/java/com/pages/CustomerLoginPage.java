package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utility.BasePage;

public class CustomerLoginPage extends BasePage{
	
	@FindBy(xpath="//*[@id=\"login-form\"]/div/div[1]/div[2]/a")
	WebElement createAccountBtn;
	
	public CustomerLoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public NewAccountPage clickCreateNewAccount() {
		
		createAccountBtn.click();
		return new NewAccountPage();
	}
}
