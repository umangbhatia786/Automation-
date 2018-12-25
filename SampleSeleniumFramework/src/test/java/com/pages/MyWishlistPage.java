package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utility.BasePage;
import com.utility.Utility;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class MyWishlistPage extends BasePage {
	
	@FindBy(xpath="//*[@id=\"wishlist-view-form\"]/div/div/button[1]")
	WebElement shareWishlist;
	
	@FindBy(xpath="//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div/div[1]/ul/li/ul/li/span")
	WebElement shareMessage;
	
	public MyWishlistPage() {
		PageFactory.initElements(driver, this);
	}
	
	public WishListSharePage shareWishList( ) {
		shareWishlist.click();
		return new WishListSharePage();
	}
	
	public void verifyShareMessage() {
		Assert.assertEquals(Utility.WISHLIST_SHARE_MESSAGE,shareMessage.getText());
	}
}
