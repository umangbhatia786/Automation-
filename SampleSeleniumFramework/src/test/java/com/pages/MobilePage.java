package com.pages;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.utility.BasePage;

public class MobilePage extends BasePage{
	
	@FindBy(xpath="//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[3]/div[1]/div[1]/div/select")
	WebElement sortBy;
	
	@FindBy(id="product-price-1")
	WebElement xperiaPrice;
	
	@FindBy(id="product-collection-image-1")
	WebElement xperiaImg;
	
	@FindBy(xpath = "//h2[@class='product-name']/a")
	List<WebElement> productList;
	
	
	public MobilePage() {
		PageFactory.initElements(driver, this);
	}
	
	public void sortByName() {
		Select dlSort = new Select(sortBy);
		dlSort.selectByIndex(1);
	}
	
	public String[] getProductList() {
		
		String[] productName= new String[3];
		int i = 0;
		// traveling through product list to get text
		for (WebElement el : productList) {
			productName[i] = el.getText();
			i++;
		}
		return productName;	}
	
	
	public void verifySort(String arr1[], String arr2[]) {
		Arrays.sort(arr1);
		Assert.assertTrue(Arrays.equals(arr1,arr2));
	}
	
	public String getXperiaPrice() {
		return xperiaPrice.getText();
	}
	
	public XperiaPage clickXperiaImg() {
		xperiaImg.click();
		return new XperiaPage();
	}
}
