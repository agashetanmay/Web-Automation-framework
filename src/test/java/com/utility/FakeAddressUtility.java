package com.utility;

import java.util.Locale;

import com.github.javafaker.Faker;
import com.ui.pojo.AddressPOJO;

public class FakeAddressUtility {
	private static AddressPOJO addressPOJO;

	public static AddressPOJO getFakerAddress() {
		Faker faker = new Faker(Locale.US);
		addressPOJO = new AddressPOJO(faker.company().name(), faker.address().fullAddress(),

				faker.address().secondaryAddress(), faker.address().city(), faker.numerify("#####"),
				
				faker.phoneNumber().cellPhone(), faker.phoneNumber().subscriberNumber(7),
				
				faker.expression("additional information"), faker.expression("additional alis"),
				
				faker.address().state());

		return addressPOJO;
	}
}
