package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CreateAccountPage;
import pages.HomePage;
import pages.MyProfileAddressBook;
import reusableComponents.DataSupplier;
import reusableComponents.GenericAppFunctions;
import setup.DriverManager;

public class MyProfileAddressBookTest extends DriverManager {	
	
	/*
	* =============================================================================
	* Tests
	* =============================================================================
	*/

	/*
	* Creator - Vikas SP
	* Modifier - 
	* Story - SC-2928
	* TC#267 - Verify - Verify user able to delete the address by clicking on the delete button on profile page	
	* TC#270 - Verify address is deleted if user clicks ok button on address delete confirmation modal 
	*/

	@Test(enabled=true,priority = 0, dataProvider = "newAddress",dataProviderClass = DataSupplier.class ,groups = {"MyAccountAddress","Smoke","Regression"})
	public void SC2928_TC267_TC270_verifyUserAbleToDeleteSavedAddress(String firstName, String lastName,String address, String city,String country, String state,String zip,String userName, String password, String fullName) throws InterruptedException {	
	GenericAppFunctions genericAppFunction= new GenericAppFunctions();
	MyProfileAddressBook myProfileAddressBook=new MyProfileAddressBook(getDriver());	
	HomePage homePage = new HomePage(getDriver());
	genericAppFunction.signInUser(userName,password);
	Assert.assertTrue(homePage.isHiUserNameDisplayed(fullName));
	test.pass("Hi, User Name Text displayed");
	homePage.clickHamBergerMenu();
	test.pass("Clicked On Hamberger Menu");
	homePage.clickSideNavigationLink("My Account");
	test.info("Cliked Side Navigation My Account Link");	
	myProfileAddressBook.clickAddressesSubTab();
	test.info("User clicked on Addresses Sub Tab Link");	
	genericAppFunction.createNewAddress(myProfileAddressBook,firstName, lastName,address,city,country, state,zip);	
	Assert.assertTrue(myProfileAddressBook.verifyNewlyCreatedAddress(city));
	test.info("New Address Created Successfully");
	int noOfAddressBeforeDelete=myProfileAddressBook.addressCount();
	test.info("Total No Of Address Present Before delete "+noOfAddressBeforeDelete);
	myProfileAddressBook.clickFirstDeleteIconUnderAddressesList();
	test.info("First Delete Icon Clicked under Addresses List");
	myProfileAddressBook.clickConfirmDeleteButton();	
	test.info("Confirm Delete button Clicked");
	int noOfAddressAfterDelete=myProfileAddressBook.addressCount();
	test.info("Total No Of Address Present After delete "+noOfAddressAfterDelete);
	Assert.assertTrue(noOfAddressBeforeDelete!=noOfAddressAfterDelete);
	test.pass("Address deleted Successfully");
	
	}

	/*
	* Creator - Vikas SP
	* Modifier - 
	* Story - SC-2928
	* TC#266 - Verify delete button displayed for the saved address on profile page	
	*/

	@Test(enabled=true,priority = 1,dataProvider = "newAddress",dataProviderClass = DataSupplier.class ,groups = {"MyAccountAddress","Smoke","Regression"})
	public void SC2928_TC266_verifyDeleteButtonDisplayedForSavedAddress(String firstName, String lastName,String address, String city,String country, String state,String zip,String userName, String password, String fullName) throws InterruptedException {	
	GenericAppFunctions genericAppFunction= new GenericAppFunctions();
	MyProfileAddressBook myProfileAddressBook=new MyProfileAddressBook(getDriver());	
	HomePage homePage = new HomePage(getDriver());
	genericAppFunction.signInUser(userName,password);
	Assert.assertTrue(homePage.isHiUserNameDisplayed(fullName));
	test.pass("Hi, User Name Text displayed");
	homePage.clickHamBergerMenu();
	test.pass("Clicked On Hamberger Menu");
	homePage.clickSideNavigationLink("My Account");
	test.info("Cliked Side Navigation My Account Link");
	myProfileAddressBook.clickAddressesSubTab();
	test.info("User clicked on Addresses Sub Tab Link");
	genericAppFunction.createNewAddress(myProfileAddressBook,firstName, lastName,address,city,country, state,zip);	
	Assert.assertTrue(myProfileAddressBook.verifyNewlyCreatedAddress(city));
	test.info("New Address Created Successfully");
	Assert.assertTrue(myProfileAddressBook.isDeleteButtonDisplayedOnSavedAddressProfilePage());	
	test.info("Delete Button present on Saved Address");	
	test.pass("Delete button displayed for the saved address on profile page");
	
	}
	
	/*
	* Creator - Vikas SP
	* Modifier - 
	* Story - SC-2928
	* TC#268 - Verify on click of delete button confirmation modal displayed	
	*/

	@Test(enabled=true,priority = 2, dataProvider = "newAddress",dataProviderClass = DataSupplier.class ,groups = {"MyAccountAddress","Smoke","Regression"})
	public void SC2928_TC268_verifyDeleteConfirmationModalDisplayed(String firstName, String lastName,String address, String city,String country, String state,String zip,String userName, String password, String fullName) throws InterruptedException {	
	GenericAppFunctions genericAppFunction= new GenericAppFunctions();
	MyProfileAddressBook myProfileAddressBook=new MyProfileAddressBook(getDriver());	
	HomePage homePage = new HomePage(getDriver());
	genericAppFunction.signInUser(userName,password);
	Assert.assertTrue(homePage.isHiUserNameDisplayed(fullName));
	test.pass("Hi, User Name Text displayed");
	homePage.clickHamBergerMenu();
	test.pass("Clicked On Hamberger Menu");
	homePage.clickSideNavigationLink("My Account");
	test.info("Cliked Side Navigation My Account Link");
	myProfileAddressBook.clickAddressesSubTab();
	test.info("User clicked on Addresses Sub Tab Link");
	genericAppFunction.createNewAddress(myProfileAddressBook,firstName, lastName,address,city,country, state,zip);	
	Assert.assertTrue(myProfileAddressBook.verifyNewlyCreatedAddress(city));
	test.info("New Address Created Successfully");
	myProfileAddressBook.clickFirstDeleteIconUnderAddressesList();
	test.info("First Delete Icon Clicked under Addresses List");	
	Assert.assertTrue(myProfileAddressBook.isDeleteConfirmationModalDisplayed());	
	test.info("Delete Confirmation Modal Displayed");	
	test.pass("Delete Confirmation Modal Displayed");
	
	}
	
	/*
	* Creator - Vikas SP
	* Modifier - 
	* Story - SC-2928
	* TC#269 - Verify address is not deleted if user clicks cancel button on address delete confirmation modal	
	*/

	@Test(enabled=true,priority = 3,dataProvider = "newAddress",dataProviderClass = DataSupplier.class ,groups = {"MyAccountAddress","Smoke","Regression"})
	public void SC2928_TC269_verifyDeleteConfirmationModalCancelButton(String firstName, String lastName,String address, String city,String country, String state,String zip,String userName, String password, String fullName) throws InterruptedException {	
	GenericAppFunctions genericAppFunction= new GenericAppFunctions();
	MyProfileAddressBook myProfileAddressBook=new MyProfileAddressBook(getDriver());	
	HomePage homePage = new HomePage(getDriver());
	genericAppFunction.signInUser(userName,password);
	Assert.assertTrue(homePage.isHiUserNameDisplayed(fullName));
	test.pass("Hi, User Name Text displayed");
	homePage.clickHamBergerMenu();
	test.pass("Clicked On Hamberger Menu");
	homePage.clickSideNavigationLink("My Account");
	test.info("Cliked Side Navigation My Account Link");
	myProfileAddressBook.clickAddressesSubTab();
	test.info("User clicked on Addresses Sub Tab Link");	
	genericAppFunction.createNewAddress(myProfileAddressBook,firstName, lastName,address,city,country, state,zip);	
	Assert.assertTrue(myProfileAddressBook.verifyNewlyCreatedAddress(city));
	test.info("New Address Created Successfully");
	int noOfAddressBeforeDelete=myProfileAddressBook.addressCount();
	test.info("Total No Of Address Present Before Clicking Cancel "+noOfAddressBeforeDelete);
	myProfileAddressBook.clickFirstDeleteIconUnderAddressesList();
	test.info("First Delete Icon Clicked under Addresses List");	
	myProfileAddressBook.clickCancelButtonInDeleteConfirmationModal();	
	test.info("Clicked On Cancel Button in Delete Confirmation Modal");
	int noOfAddressAfterDelete=myProfileAddressBook.addressCount();
	test.info("Total No Of Address Present After Clicking Cancel "+noOfAddressAfterDelete);
	Assert.assertTrue(noOfAddressBeforeDelete==noOfAddressAfterDelete);	
	test.info("Address Not Deleted After user clicks on cancel button in Confirmation Modal");	
	test.pass("Address Not Deleted After user clicks on cancel button in Confirmation Modal");
	
	}
	
	
	/*
	* Creator - Vikas SP
	* Modifier - 
	* Story - SC-2928
	* TC#1180 - Verify delete button Not displayed for the Default address on profile page	
	*/

	@Test(enabled=true,priority = 4,groups = {"MyAccountAddress","Smoke","Regression"})
	public void SC2928_TC1180_verifyDeleteButtonNotDisplayedForDefaultAddress() throws InterruptedException {	
	GenericAppFunctions genericAppFunction= new GenericAppFunctions();
	MyProfileAddressBook myProfileAddressBook=new MyProfileAddressBook(getDriver());
	CreateAccountPage createAccountPage = new CreateAccountPage(getDriver());
	HomePage homePage = new HomePage(getDriver());
	String emailId=genericAppFunction.createUser(homePage,createAccountPage);
	test.info("Account Created With Email ID "+emailId);
	Assert.assertTrue(createAccountPage.isAccountCreatedSuccessMessageDisplayed());
	test.info("Account Created Successfully");
	myProfileAddressBook.clickAccountLink();
	test.info("User clicked on Account Link");
	myProfileAddressBook.clickAddressesSubTab();
	test.info("User clicked on Addresses Sub Tab Link");	
	Assert.assertTrue(myProfileAddressBook.isDeleteButtonDisplayedOnDefaultAddressProfilePage()==0);	
	test.info("Delete Button Not present on Default Address");	
	test.pass("Delete button Not displayed for the Defalut address on profile page");
	
	}
	
	/*
	* Creator - Vikas SP
	* Modifier - 
	* Story - SC-2926
	* TC#260 - Verify user able to see saved address	
	*/

	@Test(enabled=true,priority = 5,groups = {"MyAccountAddress","Smoke","Regression"})
	public void SC2926_TC260_verifyUserAbleToSeeDefaultAddress() throws InterruptedException {	
	GenericAppFunctions genericAppFunction= new GenericAppFunctions();
	MyProfileAddressBook myProfileAddressBook=new MyProfileAddressBook(getDriver());
	CreateAccountPage createAccountPage = new CreateAccountPage(getDriver());
	HomePage homePage = new HomePage(getDriver());
	String emailId=genericAppFunction.createUser(homePage,createAccountPage);
	test.info("Account Created With Email ID "+emailId);
	Assert.assertTrue(createAccountPage.isAccountCreatedSuccessMessageDisplayed());
	test.info("Account Created Successfully");
	myProfileAddressBook.clickAccountLink();
	test.info("User clicked on Account Link");
	myProfileAddressBook.clickAddressesSubTab();
	test.info("User clicked on Addresses Sub Tab Link");	
	Assert.assertTrue(myProfileAddressBook.addressCount()>=1);	
	test.info("Saved Address Present in My Addresses");	
	}
	
	/*
	* Creator - Vikas SP
	* Modifier - 
	* Story - SC-2926
	* TC#261 - Verify Create New Address Form Fields	
	*/

	@Test(enabled=true,priority = 6,dataProvider = "userDetails",dataProviderClass = DataSupplier.class ,groups = {"MyAccountAddress","Smoke","Regression"})
	public void SC2926_TC261_verifyCreateNewAddressFormFields(String userName, String password, String fullName) throws InterruptedException {	
	GenericAppFunctions genericAppFunction= new GenericAppFunctions();
	MyProfileAddressBook myProfileAddressBook=new MyProfileAddressBook(getDriver());	
	HomePage homePage = new HomePage(getDriver());
	genericAppFunction.signInUser(userName,password);
	Assert.assertTrue(homePage.isHiUserNameDisplayed(fullName));
	test.pass("Hi, User Name Text displayed");
	homePage.clickHamBergerMenu();
	test.pass("Clicked On Hamberger Menu");
	homePage.clickSideNavigationLink("My Account");
	test.info("Cliked Side Navigation My Account Link");
	myProfileAddressBook.clickAddressesSubTab();
	test.info("User clicked on Addresses Sub Tab Link");	
	myProfileAddressBook.clickOnNewAddressAddIcon();
	test.info("Create New Address Icon Clicked");	
	Assert.assertTrue(myProfileAddressBook.isAddNewAddressPageHeadingDisplayed());
	test.info("Add New Address Page heading Displayed");
	Assert.assertTrue(myProfileAddressBook.isFirstNameInputDisplayed());
	test.info("First Name input Displayed");
	Assert.assertTrue(myProfileAddressBook.isLastNameInputDisplayed());
	test.info("Last Name input Displayed");
	Assert.assertTrue(myProfileAddressBook.isAddressLine1InputTextBoxInputDisplayed());
	test.info("Address 1 Input Displayed");
	Assert.assertTrue(myProfileAddressBook.isCityInputDisplayed());
	test.info("City Input Displayed");
	Assert.assertTrue(myProfileAddressBook.isProvienceDropdownInputDisplayed());
	test.info("Provience Input displayed");
	Assert.assertTrue(myProfileAddressBook.isZipInputTextBoxInputDisplayed());
	test.info("Zip input displayed");	
	Assert.assertTrue(myProfileAddressBook.isSaveAddressButtonDisplayed());
	test.info("Save New Address Button Displayed");
	Assert.assertTrue(myProfileAddressBook.isContactNumberInputBoxDisplayed());
	test.info("Contact Number Input displayed");
	Assert.assertTrue(myProfileAddressBook.isNewAddressFormCancelLinkDisplayed());
	test.info("Cancel Link to Create New Address displayed");	
	test.info("All Fields are Present in Create New Address Form");	
	}
	
	/*
	* Creator - Vikas SP
	* Modifier - 
	* Story - SC-2926
	* TC#262- Verify - Verify logged in user able to Create New address in My addresses	
	* TC#264 -Verify the default address set by the system. 
	* TC#265 -Verify user able to view newly added address .
	*/

	@Test(enabled=true,priority = 7, dataProvider = "newAddress",dataProviderClass = DataSupplier.class , groups = {"MyAccountAddress","Smoke","Regression"})
	public void SC2926_TC262_TC264_TC265_verifyUserAbleToNewAddress(String firstName, String lastName,String address, String city,String country, String state,String zip,String userName, String password, String fullName) throws InterruptedException {	
	GenericAppFunctions genericAppFunction= new GenericAppFunctions();
	MyProfileAddressBook myProfileAddressBook=new MyProfileAddressBook(getDriver());	
	HomePage homePage = new HomePage(getDriver());
	genericAppFunction.signInUser(userName,password);
	Assert.assertTrue(homePage.isHiUserNameDisplayed(fullName));
	test.pass("Hi, User Name Text displayed");
	homePage.clickHamBergerMenu();
	test.pass("Clicked On Hamberger Menu");
	homePage.clickSideNavigationLink("My Account");
	test.info("Cliked Side Navigation My Account Link");
	myProfileAddressBook.clickAddressesSubTab();
	test.info("User clicked on Addresses Sub Tab Link");	
	genericAppFunction.createNewAddress(myProfileAddressBook,firstName, lastName,address,city,country, state,zip);	
	Assert.assertTrue(myProfileAddressBook.verifyNewlyCreatedAddress(city));
	test.info("New Address Created Successfully");	
	
	
	}
	
	/*
	* Creator - Vikas SP
	* Modifier - 
	* Story - SC-2926
	* TC#263 - Verify appropriate error message displayed when user enters invalid data	
	*/

	@Test(enabled=true,priority = 8, dataProvider = "getInvalidAddress",dataProviderClass = DataSupplier.class ,groups = {"MyAccountAddress","Smoke","Regression"})
	public void SC2926_TC263_verifyNewAddressFormForInvalidData(String firstName, String lastName,String address, String city,String country, String state,String zip,String userName, String password, String fullName) throws InterruptedException {	
	GenericAppFunctions genericAppFunction= new GenericAppFunctions();
	MyProfileAddressBook myProfileAddressBook=new MyProfileAddressBook(getDriver());	
	HomePage homePage = new HomePage(getDriver());
	genericAppFunction.signInUser(userName,password);
	Assert.assertTrue(homePage.isHiUserNameDisplayed(fullName));
	test.pass("Hi, User Name Text displayed");
	homePage.clickHamBergerMenu();
	test.pass("Clicked On Hamberger Menu");
	homePage.clickSideNavigationLink("My Account");
	test.info("Cliked Side Navigation My Account Link");
	myProfileAddressBook.clickAddressesSubTab();
	test.info("User clicked on Addresses Sub Tab Link");	
	boolean status=myProfileAddressBook.verifyCreareNewAddressInvalidInput(firstName, lastName,address,city,country, state,zip);	
	Assert.assertTrue(status);
	test.info("Invalid Input to Create New Address validated Successfully");	
	
	}
	
	
	
}
