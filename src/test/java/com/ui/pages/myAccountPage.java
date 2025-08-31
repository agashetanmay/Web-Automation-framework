package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class myAccountPage extends BrowserUtility {

	   private static final By USER_NAME_LOCATOR = By.xpath("//a[@title='View my customer account']/span");
	
	   public myAccountPage(WebDriver driver) {
		super(driver);
	}
	 
	   public String getUserName() {
	        return getVisibleText(USER_NAME_LOCATOR);
	   }

	    
}
