package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utility.BasePage;

public class WishListSharePage extends BasePage{
	
	@FindBy(xpath="//*[@id=\"email_address\"]")
	WebElement email;
	
	@FindBy(xpath="//*[@id=\"message\"]")
	WebElement message;
	
	@FindBy(xpath="//*[@id=\"form-validate\"]/div[2]/button")
	WebElement shareBtn;
	
	public WishListSharePage() {
		PageFactory.initElements(driver, this);
	}
	
	public MyWishlistPage shareWishList(String email_id,String msg) {
		email.sendKeys(email_id);
		message.sendKeys(msg);
		return new MyWishlistPage();
	}
}
