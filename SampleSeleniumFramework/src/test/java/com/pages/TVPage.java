package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utility.BasePage;

public class TVPage extends BasePage {
	
	@FindBy(xpath="//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[2]/ul/li[1]/div/div[3]/ul/li[1]/a")
	WebElement addToWishlist;
	
	public TVPage() {
		PageFactory.initElements(driver,this);
	}
	
	public MyWishlistPage addToWishList() {
		addToWishlist.click();
		return new MyWishlistPage();
	}
}
