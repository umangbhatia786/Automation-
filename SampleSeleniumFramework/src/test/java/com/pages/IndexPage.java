package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utility.BasePage;

public class IndexPage extends BasePage {
	
	@FindBy(xpath="//*[@id=\"nav\"]/ol/li[1]/a")
	WebElement mobileLink;
	
	public IndexPage() {
		PageFactory.initElements(driver, this);
	}
	
	public MobilePage clickMobileLink() {
		mobileLink.click();
		return new MobilePage();
	}

}
