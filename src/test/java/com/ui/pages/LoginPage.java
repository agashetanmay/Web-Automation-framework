package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class LoginPage extends BrowserUtility{
	
	private static final By EMAIL_TEXT_BOX_LOCATOR = By.id("email");
	private static final By PASSWORD_TEXT_BOX_LOCATOR = By.id("passwd");
	private static final By SUBMIT_BUTTON_LOCATOR = By.id("SubmitLogin");
	
	public LoginPage(WebDriver driver) {
		super(driver);
		
	}
	public  myAccountPage doLoginWith(String EmailAddress, String Password) {
		
		enterText(EMAIL_TEXT_BOX_LOCATOR,EmailAddress);
		enterText(PASSWORD_TEXT_BOX_LOCATOR,Password);
		clickOn(SUBMIT_BUTTON_LOCATOR);
		 myAccountPage myAccount = new myAccountPage(getDriver());
		 return myAccount;
		 
	}
		
}
