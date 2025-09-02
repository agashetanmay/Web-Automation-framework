package com.ui.test;

import static org.testng.Assert.*;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.ui.pages.LoginPage;
import com.ui.pages.myAccountPage;
import com.ui.pojo.User;

@Listeners(com.ui.listeners.TestListeners.class)
public class LoginTest extends TestBase {

    
	@Test(description = "verifies with valid user able to login into application", groups = { "e2e",
			"sanity" },enabled=true, dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginJsonDataProvider")
	public void loginTest1(User user) {
		homePage.maximizeWindow();
		LoginPage loginPage = homePage.goToLoginPage();
		myAccountPage myAccount = loginPage.doLoginWith(user.getEmailAddress(), user.getPassword());
		String username = myAccount.getUserName();
		assertEquals(username, "Tanmay a");
		
	}

	@Test(description = "verifies with valid user able to login into application", groups = { "e2e",
			"sanity" },enabled=false, dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginCSVDataProvider")
	public void loginTest2(User user) {

		homePage.maximizeWindow();
		LoginPage loginPage = homePage.goToLoginPage();
		myAccountPage myAccount = loginPage.doLoginWith(user.getEmailAddress(), user.getPassword());
		String username = myAccount.getUserName();
		assertEquals(username, "Tanmay a");

	}
    
	@Test(description = "verifies with valid user able to login into application", groups = { "e2e",
			"sanity" },enabled=false, dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginExcelDataProvider", retryAnalyzer = com.ui.listeners.MyRetryAnalyzer.class)
	public void loginTest3(User user) {
		homePage.maximizeWindow();
		LoginPage loginPage = homePage.goToLoginPage();
		myAccountPage myAccount = loginPage.doLoginWith(user.getEmailAddress(), user.getPassword());
		String username = myAccount.getUserName();
		assertEquals(username, "Tanmay a");
	}

}
