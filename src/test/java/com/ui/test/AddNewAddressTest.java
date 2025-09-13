package com.ui.test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.AddressPage;
import com.ui.pages.myAccountPage;
import com.ui.pojo.AddressPOJO;
import com.utility.FakeAddressUtility;

public class AddNewAddressTest extends TestBase {
	private myAccountPage myAccountPage;
	AddressPage addressPage;
	private AddressPOJO address;
	
	
	@BeforeMethod(description = "valid user log into application")
	public void setup() {
	 myAccountPage = homePage.goToLoginPage().doLoginWith("waviy24172@endibit.com","password");
	 address = FakeAddressUtility.getFakerAddress();
	}
	
	@Test
	public void addNewAddress() throws InterruptedException {
		
		 myAccountPage.goToAddressPage().saveAddress(address);
	}
	

}
