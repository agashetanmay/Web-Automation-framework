package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class PaymentMethodPage extends BrowserUtility {
	
	private static final By PAY_BY_CHECK_LOCATOR = By.xpath("//p[@class=\"payment_module\"]/a[@title='Pay by check.']");

	public PaymentMethodPage(WebDriver driver) {
		super(driver);
	}
  
	
	public OrderSummeryPage goToOrderSummeryPage() {
		clickOn(PAY_BY_CHECK_LOCATOR);
		return new OrderSummeryPage(getDriver());
	}
	
	
	
	
	
	
}
