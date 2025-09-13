package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Env;
import com.constants.browser;
import com.utility.BrowserUtility;
import com.utility.JSONUtility;


public final class HomePage extends BrowserUtility {
	
private static final By SIGN_IN_LINK_LOCATOR = By.xpath("//a[@class='login']");
	
	 public HomePage(browser broswerName, boolean isHeadless) { //this constructor accept browsername and headless boolean value
		super(broswerName,isHeadless);    //To call parent class constructor (browserUtility class) from child class constructor
		goToWebsite(JSONUtility.readJSON(Env.QA).getUrl());
	}
	 public HomePage(WebDriver driver) {   //This constructor accepts browsername
			super(driver);    //To call parent class constructor (browserUtility class) from child class constructor
			goToWebsite(JSONUtility.readJSON(Env.QA).getUrl());
		}

     public LoginPage goToLoginPage() {
    	 clickOn(SIGN_IN_LINK_LOCATOR);
    	 LoginPage loginPage = new LoginPage(getDriver());
    	 return loginPage;
     }

}
