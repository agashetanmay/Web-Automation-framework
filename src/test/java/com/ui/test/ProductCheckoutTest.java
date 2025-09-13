package com.ui.test;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.constants.Size;
import com.ui.pages.SearchResultPage;

public class ProductCheckoutTest extends TestBase {
	
	private static final String SEARCH_TERM = "Printed summer dress";
	SearchResultPage searchResultPage;
	
	@BeforeMethod (description="user logs in to application and search for product")
	public void setup() {
		
		searchResultPage = homePage.goToLoginPage().doLoginWith("waviy24172@endibit.com","password").
	searchForProduct(SEARCH_TERM);
	}

	
	@Test(description = "verify if login user able to buy dress", groups = {"e2e","sanity","smoke"}, enabled = true)
	public void checkoutTest() {
	 searchResultPage.clickOnProductAt(1).changeSize(Size.L).
	 addProductToCart().proceedToCheckout().goToConfirmAddressPage().goToShipmentPage().
	 goToPaymentPage().goToOrderSummeryPage().clickOnConfirmMyOrder();
	 
	 Assert.assertTrue(true, "completed");
	 
}
}