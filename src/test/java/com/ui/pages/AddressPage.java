package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ui.pojo.AddressPOJO;
import com.utility.BrowserUtility;

public class AddressPage extends BrowserUtility {

	private static final By COMPANY_TEXTBOX_LOCATOR = By.id("company");
	private static final By ADDRESS1_TEXTBOX_LOCATOR = By.id("address1");
	private static final By ADDRESS2_TEXTBOX_LOCATOR = By.id("address2");
	private static final By CITY_TEXTBOX_LOCATOR = By.id("city");
	private static final By POSTCODE_TEXTBOX_LOCATOR = By.id("postcode");
	private static final By HOME_PHONE_TEXTBOX_LOCATOR = By.id("phone");
	private static final By MOBILE_PHONE_TEXTBOX_LOCATOR = By.id("phone_mobile");
	private static final By ADDITIONAL_INFORMATION_TEXTAREA_LOCATOR = By.id("other");
	private static final By ADDRESS_ALIAS_TEXTBOX_LOCATOR = By.id("alias");
	private static final By STATE_DROPDOWN_LOCATOR = By.id("id_state");
	private static final By SAVAE_ADDRESS_BUTTON_LOCATOR = By.id("submitAddress");
	private static final By ADDRESS_DELETE_BUTTON_LOCATOR = By.xpath("//li[@class='address_update']/a[2]");

	public AddressPage(WebDriver driver) {
		super(driver);

	}

	public void saveAddress(AddressPOJO addressPOJO) {
		enterText(COMPANY_TEXTBOX_LOCATOR,addressPOJO.getCompany());
		enterText(ADDRESS1_TEXTBOX_LOCATOR,addressPOJO.getAddress1());
		enterText(ADDRESS2_TEXTBOX_LOCATOR,addressPOJO.getAddress2());
		enterText(CITY_TEXTBOX_LOCATOR,addressPOJO.getCity());
		enterText(POSTCODE_TEXTBOX_LOCATOR,addressPOJO.getPostcode());
		enterText(HOME_PHONE_TEXTBOX_LOCATOR,addressPOJO.getHomePhone());
		enterText(MOBILE_PHONE_TEXTBOX_LOCATOR,addressPOJO.getMobilePhone());
		enterText(ADDITIONAL_INFORMATION_TEXTAREA_LOCATOR,addressPOJO.getAdditionalInformation());
		clearText(ADDRESS_ALIAS_TEXTBOX_LOCATOR);
		enterText(ADDRESS_ALIAS_TEXTBOX_LOCATOR,addressPOJO.getAddressAlias());
		selectFromDropDown(STATE_DROPDOWN_LOCATOR,addressPOJO.getState());
		clickOn(SAVAE_ADDRESS_BUTTON_LOCATOR);	
//		clickOn(ADDRESS_DELETE_BUTTON_LOCATOR);	
	}
	
	

}
