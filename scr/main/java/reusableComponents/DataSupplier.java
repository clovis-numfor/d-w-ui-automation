package reusableComponents;

import org.testng.annotations.DataProvider;

public class DataSupplier {
	
	/*
	 * Testdata for valid login attempts using data from DataProvider
	 */
	@org.testng.annotations.DataProvider(name = "userDetails")
	public Object[][] getUserDetails() {
		return new Object[][] { { "automation.user1@gmail.com", "Test1234", "Automation User" } // User with full name
		};
	}

	/*
	 * Testdata for Creating New Valid  Address
	 */
	@DataProvider(name = "newAddress")
	public Object[][] getData2() {
		return new Object[][] { { "Automation", "Tester", "Test Address", "White Rock", "Canada", "Alberta", "V4B",
				"automation.user1@gmail.com", "Test1234", "Automation User" } };
	}

	/*
	 * Testdata to check for Invid Address
	 */
	@DataProvider(name = "getInvalidAddress")
	public Object[][] getInvalidData() {
		return new Object[][] { { "Automation", "Tester", "Test Address", "White Rock", "Canada", "Alberta", "V4B",
				"automation.user1@gmail.com", "Test1234", "Automation User" } };
	}
	
	/*
	 * Testdata for valid login attempts using data from DataProvider
	 */
	@org.testng.annotations.DataProvider(name = "userDetailsEmptyCart")
	public Object[][] getUserDetailsWithEmtyCart() {
		return new Object[][] { { "vikas.sp@sleepcountry.ca", "Sham@2026", "Vikas SP" } // User with full name
		};
	}
	
	/*
	 * Testdata for valid login attempts using data from DataProvider
	 */
	@DataProvider(name = "loginDetails")
	public Object[][] getLoginDetails() {
		return new Object[][] { { "mahantesh.hadimani@sleepcountry.ca", "Test1234"} // Users Credential
		};
	}
	/*
	 * Testdata for valid login attempts using data from DataProvider
	 */
	@DataProvider(name = "invalidloginDetails")
	public Object[][] getinvalidLoginDetails()  {
		return new Object[][] {
				{ "InvalidEmail@gmail.com", "testing123" }, // Invalid email, correct password
				{ "testuser@yahoo.com", "InvalidPassword2" } // Correct email, Invalid password
		};
	}

	/**
	 * Test data for Login for Order Confirmation data from DataProvider
	 */
	@DataProvider(name = "loginDetailsForOrder")
	public Object[][] getLoginDetailsForOrder() {
		return new Object[][] { { "yeshwanth.kote@sleepcountry.ca", "Test@1234"} // Users Credential
		};
	}
}
