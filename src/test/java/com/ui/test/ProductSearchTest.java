package com.ui.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.ui.pages.myAccountPage;

@Listeners(com.ui.listeners.TestListeners.class)
public class ProductSearchTest extends TestBase  {
	 private myAccountPage myAccountPage;
	 private static final String SEARCH_TERM = "printed summer dress";
	 
	@BeforeMethod(description="valid user logs into the application")
	public void setup() {
	myAccountPage = homePage.goToLoginPage().doLoginWith("waviy24172@endibit.com", "password");
	}
	
	@Test(description="verify if login user able to search for product and verify search product title",groups= {"e2e","sanity"},
			enabled=true)
	public void verifySearchProductResultTtile() {
	String data = myAccountPage.searchForProduct("printed summer dress").getResultTitle();
	System.out.println(data);
	}

	@Test(description="verify if login user able to search for product and correct product name are display",groups= {"e2e","sanity"},
			enabled=true)
	public void verifyProductSearchTest() throws InterruptedException {
	boolean actualResult = myAccountPage.searchForProduct(SEARCH_TERM).isSearchTermPresentInProductList(SEARCH_TERM);
	   Assert.assertEquals(actualResult, true);
		}
	

}
