package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utility.BasePage;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class XperiaPage extends BasePage{
	
	@FindBy(id="product-price-1")
	WebElement xperiaPrice;
	
	public XperiaPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String getXperiaPrice() {
		return xperiaPrice.getText();
	}
	
	public void comparePrice(String price1, String price2) {
		Assert.assertEquals(price1, price2);
	}
	
	
}
