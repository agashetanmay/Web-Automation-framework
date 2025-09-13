package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class ShippmentPage extends BrowserUtility {
	
	private static final By TERM_OF_SERVICE_CHECKBOX = By.id("uniform-cgv");
	private static final By PROCEED_TO_CHECKOUT_BUTTON_LOCATOR = By.name("processCarrier");

	public ShippmentPage(WebDriver driver) {
		super(driver);
		
	}
	public PaymentMethodPage goToPaymentPage() {
		clickOn(TERM_OF_SERVICE_CHECKBOX);
		clickOn(PROCEED_TO_CHECKOUT_BUTTON_LOCATOR);
		return new PaymentMethodPage(getDriver());
	}
	
}
