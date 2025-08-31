package com.ui.test;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.constants.browser;
import com.ui.pages.HomePage;
import com.utility.BrowserUtility;
import com.utility.LambdaTestUtility;
import com.utility.loggerUtility;

public class TestBase {
	protected HomePage homePage;
	Logger logger = loggerUtility.getLogger(this.getClass());
	
	private boolean isLambdaTest = true;
    
	@Parameters({"browserName","isHeadless","isLambdaTest"})
	@BeforeMethod(description = "load home page of website")
	
	public void setup(@Optional("chrome")String browserName,
			@Optional("false")boolean isHeadless, 
			@Optional("false")boolean isLambdaTest,ITestResult result) {
		
		WebDriver LambdaDriver;
		browser browserEnum = browser.valueOf(browserName.toUpperCase());
		this.isLambdaTest = isLambdaTest;
		  
		if (isLambdaTest) {
			LambdaDriver = LambdaTestUtility.initializeLambdaTestSession(browserEnum,
					result.getMethod().getMethodName());
			homePage = new HomePage(LambdaDriver);
		} else {
			homePage = new HomePage( browserEnum, isHeadless); // this will accept browser and headless boolean value
			logger.info("Loads homepage of website");
		}
	}

	public BrowserUtility getInstance() {
		return homePage;
	}

	@AfterMethod
	public void TearDown() {
		if (isLambdaTest) {
			LambdaTestUtility.quitSession(); // this will quit the broser session in lambda test
		} else {
			homePage.quit(); // this will quit the session on locale
		}

	}

}
