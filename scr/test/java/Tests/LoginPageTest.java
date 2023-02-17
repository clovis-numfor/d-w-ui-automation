package Tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.CreateAccountPage;
import pages.HomePage;
import pages.LoginPage;
import reusableComponents.GenericAppFunctions;
import setup.DriverManager;

public class LoginPageTest extends DriverManager {

	/*
	* =============================================================================
	* Tests
	* =============================================================================
	*/

	/*
	* Creator - Mahantesh Hadimani Modifier - Story - SC-3378 TC#283 - To verify
	* that "I am not a robot "reCaptcha check box from Google. | Sign in Page
	*/

	@Test(priority = 0, groups= {"Regression"})
	public void VerifyRecaptchaCheckboxDisplayedOnSignInPage() throws InterruptedException {
	HomePage homePage = new HomePage(getDriver());	
	LoginPage loginPage = new LoginPage(getDriver());
	homePage.clickSignInLink();
	test.info("Clicked Sign In Link");
	//Assert.assertTrue(loginPage.isReCaptchaCheckBoxDisplayed());
	//test.pass("ReCaptcha checkbox displayed");
	GenericAppFunctions gaf = new GenericAppFunctions();
	gaf.signInUser("mahantesh.hadimani@sleepcountry.ca", "Test1234");
	}

	/*
	* Navigate to login page
	*/
	@Test(priority = 1)
	public void navigateToLoginPage() throws InterruptedException {
	HomePage homePage = new HomePage(getDriver());
	LoginPage login = new LoginPage(getDriver());
	test.info("Click on My Account link");
	homePage.clickSignInLink();
	test.info("Checking title matches string");
	Assert.assertEquals(login.getTitle(), "QA - Sign in111");
	test.pass("Title matches with title from DOM");
	}

	/*
	* Test Login with invalid credentials
	*/
	@Test(priority = 2, dataProvider = "validAccounts")
	public void verifyInvalidCredentialsLogin(String testUsername, String testPassword) {
	HomePage homePage = new HomePage(getDriver());
	LoginPage login = new LoginPage(getDriver());
	homePage.clickSignInLink();
	login.typeUsername(testUsername);
	test.info("Entering invalid username");
	login.typePassword(testPassword);
	test.info("Entering invalid password");
	login.clickSignInButton();
	test.info("Clicking Sign in button");
	Assert.assertTrue(login.errorContainerDisplayed());
	test.pass("Log in with invalid crendentials failed");
	}

	/*
	* Test Login with valid credentials
	*/
	@Test(priority = 3, dataProvider = "validAccounts")
	@Parameters({ "username", "password" })
	public void verifyValidCredentialsLogin(String username, String password) throws InterruptedException {
	HomePage homePage = new HomePage(getDriver());
	LoginPage login = new LoginPage(getDriver());
	homePage.clickSignInLink();
	login.typeUsername(username);
	test.info("Entering valid username");
	login.typePassword(password);
	test.info("Entering valid password");
	login.clickSignInButton();
	test.info("Clicking Sign in button");
	Assert.assertTrue(homePage.isSignOutLinkDisplayed());
	test.pass("Log in with valid crendentials passed");
	}

	/*
	* =============================================================================
	* TestData Providers
	* =============================================================================
	*/

	/*
	* Testdata for invalid login attempts using data from DataProvider
	*/
	@DataProvider(name = "invalidAccounts")
	public Object[][] getData1() {
	return new Object[][] { { "InvalidEmail@gmail.com", "testing123" }, // Invalid email, correct password
	{ "testuser@yahoo.com", "InvalidPassword2" } // Correct email, Invalid password
	};
	}

	/*
	* Testdata for valid login attempts using data from DataProvider
	*/
	@DataProvider(name = "validAccounts")
	public Object[][] getData2() {
	return new Object[][] { { "mahantesh.hadimani@sleepcountry.ca", "Test1234" } // valid email, correct password
	};
	}

}
