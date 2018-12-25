package com.pages;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.utility.BasePage;
import com.utility.LogIT;
import com.utility.Utility;

import org.assertj.core.api.SoftAssertions;

public class MobilePage extends BasePage {

	@FindBy(xpath = "//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[3]/div[1]/div[1]/div/select")
	WebElement sortBy;

	@FindBy(id = "product-price-1")
	WebElement xperiaPrice;

	@FindBy(id = "product-collection-image-1")
	WebElement xperiaImg;

	@FindBy(xpath = "//h2[@class='product-name']/a")
	List<WebElement> productList;

	@FindBy(xpath = "//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[1]/div/div[3]/button")
	WebElement addToCartBtn;

	@FindBy(xpath = "//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[1]/div/div[3]/ul/li[2]/a")
	WebElement addXperiaCmp;

	@FindBy(xpath = "//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[2]/div/div[3]/ul/li[2]/a")
	WebElement addIphoneCmp;
	
	@FindBy(xpath="//*[@id=\"top\"]/body/div/div/div[2]/div/div[3]/div[1]/div[2]/div/button")
	WebElement compareBtn;
	
	@FindBy(xpath="//*[@id=\"product_comparison\"]/tbody[1]/tr[1]/td[1]/h2/a")
	WebElement xperiaTag;
	
	@FindBy(xpath="//*[@id=\"product_comparison\"]/tbody[1]/tr[1]/td[2]/h2/a")
	WebElement iPhoneTag;
	
	SoftAssertions assert1 = null;

	public MobilePage() {
		PageFactory.initElements(driver, this);
	}

	public void sortByName() {
		Select dlSort = new Select(sortBy);
		dlSort.selectByIndex(1);
	}

	public String[] getProductList() {

		String[] productName = new String[3];
		int i = 0;
		// traveling through product list to get text
		for (WebElement el : productList) {
			productName[i] = el.getText();
			i++;
		}
		return productName;
	}

	public void verifySort(String arr1[], String arr2[]) {
		Arrays.sort(arr1);
		Assert.assertTrue(Arrays.equals(arr1, arr2));
	}

	public String getXperiaPrice() {
		return xperiaPrice.getText();
	}

	public XperiaPage clickXperiaImg() {
		xperiaImg.click();
		return new XperiaPage();
	}

	public ShoppingCartPage addToCart() {
		addToCartBtn.click();
		return new ShoppingCartPage();
	}

	public void addXperiaIphoneToCompare() throws InterruptedException {
		LogIT.info("Adding Xperia for Comparison");
		addXperiaCmp.click();
		Thread.sleep(2000);
		LogIT.info("Adding iPhone for comparison");
		addIphoneCmp.click();
		Thread.sleep(2000);
	}
	
	public void clickCompareBtn() {
		compareBtn.click();
	}
	
	
	public void verifyCompareWindow() throws InterruptedException {
		LogIT.info("Switiching to Compare Window");
		BasePage.switchWindow();
		Thread.sleep(3000);
		LogIT.info("Verifying Title of the Compare Window");
		assert1.assertThat(MobilePage.getTitle()).isEqualToIgnoringCase(Utility.COMPARE_WINDOW_TITLE);
		LogIT.info("Verifying that Xperia Tag is displayed");
		assert1.assertThat(xperiaTag.isDisplayed()).isTrue();
		LogIT.info("Verifying that iPhone tag is displayed");
		assert1.assertThat(iPhoneTag.isDisplayed()).isTrue();
		assert1.assertAll();
	}
}
