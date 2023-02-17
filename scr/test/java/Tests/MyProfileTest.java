	package Tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.HomePage;
import reusableComponents.GenericAppFunctions;
import setup.DriverManager;

public class MyProfileTest extends DriverManager{
	
	/*
	 * =============================================================================
	 * Tests
	 * =============================================================================
	 */

	/*
	 * Creator - Mahantesh Hadimani
	 * Modifier - 
	 * Story - SC-1582
	 * TC#496 - Verify that "Hello Name" gets displayed in the header for the Logged In user
	 */
	
	@Test(enabled=true,dataProvider = "userDetails",priority = 0,groups= {"Regression"})
	@Parameters({ "userName", "password", "fullName" })
	public void verifyHelloNameGetsDisplayedInTheHeaderForLoggedInUser(String userName, String password, String fullName) throws InterruptedException {
						
		HomePage homePage = new HomePage(getDriver());
		GenericAppFunctions appFunctions= new GenericAppFunctions();
		appFunctions.signInUser(userName,password);
		Assert.assertTrue(homePage.isHiUserNameDisplayed(fullName));
		test.pass("Hi, User Name Text displayed");

	}
	
	/*
	 * Creator - Mahantesh Hadimani
	 * Modifier - 
	 * Story - SC-1582
	 * TC#498 - Verify the side navigation bar for the Logged In user
	 */
	
	@Test(enabled=true,dataProvider = "userDetails",priority = 1,groups= {"Regression"})
	@Parameters({ "userName", "password", "fullName"})
	public void verifySideNavigationForLoggedInUser(String userName, String password, String fullName) throws InterruptedException {
						
		HomePage homePage = new HomePage(getDriver());
		GenericAppFunctions appFunctions= new GenericAppFunctions();
		appFunctions.signInUser(userName,password);
		homePage.clickHamBergerMenu();
		Assert.assertTrue(homePage.isSignOutLinkDisplayed());
		test.pass("Logged In User Hamberger Menu Displayed");

	}
	
	/*
	 * =============================================================================
	 * TestData Providers
	 * =============================================================================
	 */

	/*
	 * Testdata for valid login attempts using data from DataProvider
	 */
	@DataProvider(name = "userDetails")
	public Object[][] getData2() {
		return new Object[][] { { "automation.user1@gmail.com", "Test1234", "Automation User" } // User with full name
		};
	}

}
