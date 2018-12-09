package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utility.BasePage;
import com.utility.Utility;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class ShoppingCartPage extends BasePage {
	
	@FindBy(xpath="//*[@id=\"shopping-cart-table\"]/tbody/tr/td[4]/input")
	WebElement qtyBox;
	
	@FindBy(name="update_cart_action")
	WebElement updateBtn;
	
	@FindBy(xpath="//*[@id=\"shopping-cart-table\"]/tbody/tr/td[2]/p")
	WebElement qtyUpdateError;
	
	@FindBy(xpath="//*[@id=\"empty_cart_button\"]/span/span")
	WebElement emptyCart;
	
	@FindBy(xpath="//*[@id=\"top\"]/body/div/div/div[2]/div/div/div[2]/p[1]")
	WebElement cartEmptyMsg;
	
	public ShoppingCartPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void updateQty(String qty) throws InterruptedException {
		qtyBox.click();
		qtyBox.clear();
		Thread.sleep(1000);
		qtyBox.sendKeys(qty);
		updateBtn.click();
		
	}
	

	public void verifyUpdateError() {
		Assert.assertEquals(Utility.QTY_UPDATE_ERROR,qtyUpdateError.getText());
	}
	
	public void clickEmptyCart() {
		emptyCart.click();
	}
	
	public void verifyEmptyCartMsg() {
		Assert.assertEquals(Utility.CART_EMPTY_MSG, cartEmptyMsg.getText());
	}
	
}
