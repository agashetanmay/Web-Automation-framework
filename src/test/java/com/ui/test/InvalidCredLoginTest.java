package com.ui.test;

import static org.testng.Assert.*;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.ui.pages.LoginPage;
import com.ui.pages.myAccountPage;
import com.ui.pojo.User;
import com.utility.loggerUtility;

@Listeners(com.ui.listeners.TestListeners.class)
public class InvalidCredLoginTest extends TestBase {

      Logger logger =  loggerUtility.getLogger(this.getClass());
      private static final String INVALID_EMAIL_ADDRESS = "tanmay@gmail.com";
      private static final String INVALID_PASSWORD = "Password";
      
      
	@Test(description = "verify if proper error message display when user enter invalid credentials", groups = { "e2e",
			"sanity" },enabled=true)
	public void loginTest1() {
		homePage.maximizeWindow();
		LoginPage loginPage = homePage.goToLoginPage();
		LoginPage invalidCred = loginPage.doLoginWithInvalidCredentials(INVALID_EMAIL_ADDRESS, INVALID_PASSWORD);
		String errorMessage = invalidCred.getErrorMessage();
		assertEquals(errorMessage, "Authentication failed.");
	}

}