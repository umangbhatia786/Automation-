package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utility.BasePage;

public class NewAccountPage extends BasePage {

	@FindBy(id = "firstname")
	WebElement firstName;

	@FindBy(id = "lastname")
	WebElement lastName;

	@FindBy(id = "email_address")
	WebElement email;

	@FindBy(id = "password")
	WebElement passWord;

	@FindBy(id = "confirmation")
	WebElement confirmPassword;

	@FindBy(xpath = "//*[@id=\"form-validate\"]/div[2]/button")
	WebElement registerBtn;

	public NewAccountPage() {
		PageFactory.initElements(driver, this);
	}

	public void register(String fname, String lname, String emailId, String pwd, String cnfPwd) {
		firstName.sendKeys(fname);
		lastName.sendKeys(lname);
		email.sendKeys(emailId);
		passWord.sendKeys(pwd);
		confirmPassword.sendKeys(cnfPwd);

	}

	public MyAccountPage clickRegister() {
		registerBtn.click();
		return new MyAccountPage();
	}

}
