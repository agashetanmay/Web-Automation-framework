package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class OrderSummeryPage extends BrowserUtility {

	 private static final By CONFIRM_MY_ORDER_BUTTON_LOCATOR = By.xpath("//p[@id=\"cart_navigation\"]/button/span[contains(text(), 'I confirm my order')]");
	private static final By ORDER_CONFIRM_ALERT_MESSGAE = By.xpath("//div[@id=\"center_column\"]/p[contains(text(), 'My Shop is complete.')]");
	public OrderSummeryPage(WebDriver driver) {
		super(driver);
	}
	
	
	public OrderSummeryPage clickOnConfirmMyOrder() {
		clickOn(CONFIRM_MY_ORDER_BUTTON_LOCATOR);
		getVisibleText(ORDER_CONFIRM_ALERT_MESSGAE);
		return new OrderSummeryPage(getDriver());
	
	}
	

}
