package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class myAccountPage extends BrowserUtility {

	private static final By USER_NAME_LOCATOR = By.xpath("//a[@title='View my customer account']/span");
	private static final By SEARCH_TEXTBOX_LOCATOR = By.id("search_query_top");
    private static final By ADD_MY_FIRST_ADDRESS_LOCATOR = By.xpath("//a[@title='Add my first address']");
    
	public myAccountPage(WebDriver driver) {
		super(driver);
	}

	public String getUserName() {
		return getVisibleText(USER_NAME_LOCATOR);
	}

	public SearchResultPage searchForProduct(String productName) {
		enterText(SEARCH_TEXTBOX_LOCATOR, productName);
		enterSpecialKey(SEARCH_TEXTBOX_LOCATOR, Keys.ENTER);

		SearchResultPage searchResultPage = new SearchResultPage(getDriver());
         return searchResultPage;
	}
	public AddressPage goToAddressPage() {
	clickOn(ADD_MY_FIRST_ADDRESS_LOCATOR);
	return new AddressPage(getDriver());
	}
	

}
