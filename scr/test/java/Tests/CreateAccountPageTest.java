package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CreateAccountPage;
import pages.HomePage;
import reusableComponents.GenericAppFunctions;
import reusableComponents.GenericFunctions;
import setup.DriverManager;

public class CreateAccountPageTest extends DriverManager {
	
	/*
	* =============================================================================
	* Tests
	* =============================================================================
	*/

	/*
	* Creator - Mahantesh Hadimani
	* Modifier - 
	* Story - SC-2921,SC-2916
	* TC#254, TC#310 - Verify the content of create account page
	*/

	@Test(enabled=true,priority = 0,groups= {"Regression"})
	public void verifyContentOfCreateAccountPage() throws InterruptedException {
	HomePage homePage = new HomePage(getDriver());
	CreateAccountPage createAccountPage = new CreateAccountPage(getDriver());
	homePage.clickSignInLink();
	test.info("Click on My Account link");
	createAccountPage.clickCreateAnAccountButton();
	test.info("Clicked on Create an Account button");
	Assert.assertTrue(createAccountPage.isCreateAccountPageHeadingDisplayed());
	test.info("Create An Account Heading Displayed");
	Assert.assertTrue(createAccountPage.isFirstNameInputDisplayed());
	test.info("First Name input Displayed");
	Assert.assertTrue(createAccountPage.isLastNameInputDisplayed());
	test.info("Last Name input Displayed");
	Assert.assertTrue(createAccountPage.isEmailInputDisplayed());
	test.info("Email Input Displayed");
	Assert.assertTrue(createAccountPage.isConfirmEmailInputDisplayed());
	test.info("Confirm Email Input Displayed");
	Assert.assertTrue(createAccountPage.isPasswordInputDisplayed());
	test.info("Password Input displayed");
	Assert.assertTrue(createAccountPage.isConfirmPasswordInputDisplayed());
	test.info("Confirm Password input displayed");
	Assert.assertTrue(createAccountPage.isPrivacyPolicyCheckboxDisplayed());
	Assert.assertTrue(createAccountPage.iscreateAccountButtonDisplayed());
	test.pass("All Create Account Page elements displayed");

	}
	
	/*
	* Creator - Mahantesh Hadimani
	* Modifier - 
	* Story - SC-2921, SC-2916
	* TC#255, TC#312- Verify that user able to create account when user enters valid data and clicks create account button
	*/

	@Test(enabled=true,priority = 1,groups= {"Regression"})
	public void verifyUserAbleToCreateAccountWithValidData() throws InterruptedException {
	CreateAccountPage createAccountPage = new CreateAccountPage(getDriver());
	GenericAppFunctions appFunctions= new GenericAppFunctions();
	HomePage homePage = new HomePage(getDriver());
	appFunctions.createUser(homePage,createAccountPage);

	Assert.assertTrue(createAccountPage.isAccountCreatedSuccessMessageDisplayed());
	test.info("Account Created Successfully");

	}	
	
	/*
	* Creator - Mahantesh Hadimani
	* Modifier - 
	* Story - SC-2921
	* TC#258 - Verify user successfully logged in when user enters valid data and clicks create account button
	*/

	@Test(enabled=true,priority = 2,groups= {"Regression"})
	public void verifyUserLoggedInAfterCreatingAccount() throws InterruptedException {
	CreateAccountPage createAccountPage = new CreateAccountPage(getDriver());
	GenericAppFunctions appFunctions= new GenericAppFunctions();
	HomePage homePage = new HomePage(getDriver());
	appFunctions.createUser(homePage,createAccountPage);

	Assert.assertTrue(createAccountPage.isAccountCreatedSuccessMessageDisplayed());
	test.info("Account Created Successfully");
	Assert.assertTrue(createAccountPage.isAccountCreatedSuccessMessageDisplayed());
	test.info("Account Created Successfully message Displayed");
	Assert.assertTrue(createAccountPage.isUserMenuDisplayed());
	test.pass("User Logged In Successfully");
	}
	
	/*
	* Creator - Mahantesh Hadimani
	* Modifier - 
	* Story - SC-2921,SC-2916
	* TC#256,TC#314,TC#311 - Verify that appropriate error message displayed when user enters invalid data and clicks create account button
	*/

	@Test(enabled=true,priority = 3,groups= {"Regression"})
	public void verifyErrorMessageDisplayedWhenUserEntersInvalidData() throws InterruptedException {
	HomePage homePage = new HomePage(getDriver());
	CreateAccountPage createAccountPage = new CreateAccountPage(getDriver());
	GenericFunctions gf=new GenericFunctions();
	
	homePage.clickSignInLink();
	test.info("Click on My Account link");
	createAccountPage.clickCreateAnAccountButton();
	test.info("Clicked on Create an Account button");
	Assert.assertTrue(createAccountPage.isCreateAccountPageHeadingDisplayed());
	test.info("Create An Account Page Heading Displayed");
	createAccountPage.enterFirstName("Automation");
	test.info("Entered First Name");
	createAccountPage.enterLastName("User");
	test.info("Entered Last Name");
	long currentTimeStamp = gf.getTimeStamp();
	createAccountPage.enterEmail("@@ddf.cp.co,");
	test.info("Entered Invalid Email");
	createAccountPage.enterConfirmEmail("66666");
	test.info("Entered Invalid Confirm Email");
	createAccountPage.enterPassword("Tes");
	test.info("Entered Invalid Password");
	createAccountPage.enterConfirmPassword("Tes777,,,");
	test.info("Entered Invalid Confirm Password");
	//createAccountPage.clickPrivacyPolicyCheckbox();
	//test.info("Clicked Privacy Policy checkbox");
	//Assert.assertTrue(createAccountPage.isInvalidEmailErrorDisplayed());
	//test.info("Invalid Email Error Displayed");
	Assert.assertTrue(createAccountPage.isInvalidConfirmEmailErrorDisplayed());
	test.info("Invalid Confirm Email Error Displayed");
	Assert.assertTrue(createAccountPage.isInvalidPasswordErrorDisplayed());
	test.info("Invalid Password Error Displayed");
	test.pass("Invalid Data errors data displayed");
	}
	
	/*
	* Creator - Mahantesh Hadimani
	* Modifier - 
	* Story - SC-2921, SC-2916
	* TC#257,TC#313 - Verify that appropriate error message displayed when user enters already registered email address and clicks create account button
	*/

	@Test(enabled=true,priority = 4,groups= {"Regression"})
	public void verifyErrorMessageDisplayedWhenUserEntersRegisteredEmail() throws InterruptedException {
	CreateAccountPage createAccountPage = new CreateAccountPage(getDriver());
	GenericAppFunctions appFunctions= new GenericAppFunctions();
	HomePage homePage = new HomePage(getDriver());
	String emailAddress = appFunctions.createUser(homePage,createAccountPage);

	Assert.assertTrue(createAccountPage.isAccountCreatedSuccessMessageDisplayed());
	test.info("Account Created Successfully");
	Assert.assertTrue(createAccountPage.isAccountCreatedSuccessMessageDisplayed());
	test.info("Account Created Successfully message Displayed");
	Assert.assertTrue(createAccountPage.isUserMenuDisplayed());
	test.info("User Logged In Successfully");
	createAccountPage.clickHumbergerMenu();
	test.info("Clicked Humberger Menu");
	createAccountPage.clickSignOutLink();
	test.info("User clicked signout button");
	createAccountPage.clickCreateAnAccountButton();
	test.info("Clicked on Create an Account button");
	createAccountPage.enterFirstName("Automation");
	test.info("Entered First Name");
	createAccountPage.enterLastName("User");
	test.info("Entered Last Name");
	createAccountPage.enterEmail(emailAddress);
	test.info("Entered Registered Email");
	createAccountPage.enterConfirmEmail(emailAddress);
	test.info("Entered Registered Email");
	createAccountPage.enterPassword("Test1234");
	test.info("Entered Password");
	createAccountPage.enterConfirmPassword("Test1234");
	test.info("Entered Confirm Password");
	createAccountPage.clickPrivacyPolicyCheckbox();
	test.info("Clicked Privacy Policy checkbox");
	createAccountPage.clickCreateAccountButton();
	test.info("Clicked Create Account Button");
	Assert.assertTrue(createAccountPage.isEmailAlreadyRegisteredErrorDisplayed());
	test.info("Email Already Registered Error Displayed");
	test.pass("Email Already Registered Error Displayed");
	}
	
	/*
	* Creator - Mahantesh Hadimani
	* Modifier - 
	* Story - SC-2916
	* TC#309 - Verify the New Account Creation page displayed when user clicks on Create Account button
	*/

	@Test(enabled=true,priority = 0,groups= {"Regression"})
	public void verifyCreateAccountPageDisplayedWhenUserClicksCreateAccountBtn() throws InterruptedException {
	HomePage homePage = new HomePage(getDriver());
	CreateAccountPage createAccountPage = new CreateAccountPage(getDriver());
	homePage.clickSignInLink();
	test.info("Click on My Account link");
	createAccountPage.clickCreateAnAccountButton();
	test.info("Clicked on Create an Account button");
	Assert.assertTrue(createAccountPage.isCreateAccountPageHeadingDisplayed());
	test.info("Create An Account Heading Displayed");
	test.pass("Create Account Page displayed");

	}
	
	/*
	* Creator - Surendra
	* Modifier - 
	* Story - SC-1093
	* TC#387 - SC-1093 Verify that Sigin button present in Humberger Menu
	*/

	@Test(enabled=true,priority = 0,groups= {"Regression"})
	public void verifyUserIsableNavigateToCreateAccountPage() throws InterruptedException {
	HomePage homePage = new HomePage(getDriver());
	CreateAccountPage createAccountPage = new CreateAccountPage(getDriver());
	homePage.clickSignInLink();
	createAccountPage.clickHumbergerMenu();
	test.info("Click on Humberger Menu");
	Assert.assertTrue(homePage.isSignInButttonDisplayedInHamBergerMenu());
	test.info("Sigin button present in Humberger Menu");
	}
	
	/*
	* Creator - Surendra
	* Modifier - 
	* Story - SC-1093
	* TC#388 - SC-1093 Verify that new user is able to navigate to create new account page on the website.
	*/

	@Test(enabled=true,priority = 0,groups= {"Regression"})
	public void verifyUserIsableNavigateToCreateAccountPageFromHumbergerMenu() throws InterruptedException {
	HomePage homePage = new HomePage(getDriver());
	CreateAccountPage createAccountPage = new CreateAccountPage(getDriver());
	createAccountPage.clickHumbergerMenu();
	test.info("Click on Humberger Menu");
	Assert.assertTrue(homePage.isSignInButttonDisplayedInHamBergerMenu());
	test.info("Sigin button present in Humberger Menu");
	Assert.assertTrue(homePage.isCreateAccountLinkInHamBergerMenudisplayed());
	test.info("CreateAccount Link present in Humberger Menu");
	homePage.clickCreateAccountLinkInHamBergerMenu();
	test.info("click on CreateAccount Link In HamBergerMenu");
	Assert.assertTrue(createAccountPage.isCreateAccountPageHeadingDisplayed());
	test.info("Navigated to Create an Account page");
	
	}
	
}
