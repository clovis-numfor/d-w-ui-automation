package reusableComponents;

import org.testng.Assert;
import pages.CreateAccountPage;
import pages.HomePage;
import pages.LoginPage;
import pages.MyCartPage;
import pages.MyProfileAddressBook;
import pages.PDPPage;
import setup.DriverManager;
import util.PropertiesOperations;

public class GenericAppFunctions extends DriverManager {

public void navigateToPdpPage(PDPPage pdppage,String product) {
pdppage.navigateToPdpPage(product);
}

public String addProductToCartFromPDPwithoutSizeAndColor(PDPPage pdppage) throws InterruptedException {
return pdppage.addProductToCartFromPDPwithoutSizeAndColor();
}

public String addProductToCartFromPDP(PDPPage pdppage) throws InterruptedException {
return pdppage.addProductToCartFromPDP();
}

/*
* This Method is to wait till loading Icon disappears
*/
public void waitForLoadingIconToDisappear(MyCartPage mycartpage) throws InterruptedException {
mycartpage.waitForLoadingIconToDisappear();
}

/*
* Create User method create unique user and returns the email address
*/

public String createUser(HomePage homePage,CreateAccountPage createAccountPage) throws InterruptedException {
GenericFunctions gf = new GenericFunctions();

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
String emailAddress = "automation.user" + currentTimeStamp + "@gmail.com";
createAccountPage.enterEmail(emailAddress);
test.info("Entered Email");
createAccountPage.enterConfirmEmail(emailAddress);
test.info("Entered Confirm Email");
createAccountPage.enterPassword("Test1234");
test.info("Entered Password");
createAccountPage.enterConfirmPassword("Test1234");
test.info("Entered Confirm Password");
// createAccountPage.enterAddressLine1("244 Street 1");
// test.info("Entered Address Line 1");
// createAccountPage.enterCity("Calagary");
// test.info("Entered City Name");
// createAccountPage.selectCountryFromCountryDropDown("Canada");
// test.info("Selected Country");
// createAccountPage.selectStateFromStateDropDown("Alberta");
// test.info("Selected State");
// createAccountPage.enterZipCode("T3S");
// test.info("Entered Zipcode");
createAccountPage.clickPrivacyPolicyCheckbox();
test.info("Checked Privacy Policy Checkbox");
createAccountPage.clickCreateAccountButton();
test.info("Clicked Create Account Button");
return emailAddress;
}

/*
* This Method sign in the user
*/

public void signInUser(String userName, String password) throws InterruptedException {
HomePage homePage = new HomePage(getDriver());
LoginPage loginPage = new LoginPage(getDriver());
homePage.clickSignInLink();
loginPage.typeUsername(userName);
test.info("Entered username");
loginPage.typePassword(password);
test.info("Entered password");
// login.clickReCaptchaCheckBox();
// logger.log(LogStatus.INFO, "Clicked on ReCaptcha checkbox"); //Dev team will
// disable captcha in the later stage. we cant automate this
loginPage.clickMainSignInButton();
test.info("Clicking Sign in button");
}

/*
* This Method Creates New Address
*/

public void createNewAddress(MyProfileAddressBook myProfileAddressBook,String firstName, String lastName, String address, String city, String country,
String state, String zipCode) throws InterruptedException {
GenericFunctions gf = new GenericFunctions();
String firstNameWithTimeStamp = firstName + gf.getTimeStamp();
myProfileAddressBook.clickOnNewAddressAddIcon();
test.info("User clicked on New Address Creation Icon");
myProfileAddressBook.isAddNewAddressPageHeadingDisplayed();
test.info("New Address Creation Page Displayed");
myProfileAddressBook.enterFirstName(firstNameWithTimeStamp);
test.info("Entered First Name " + firstNameWithTimeStamp);
myProfileAddressBook.enterLastName(lastName);
test.info("Entered Last Name");
myProfileAddressBook.enterAddressLine1(address);
test.info("Entered Address");
myProfileAddressBook.enterCity(city);
test.info("Entered City Name");
//myProfileAddressBook.selectCountryFromCountryDropDown(country);
//test.info("Select Country Name");
myProfileAddressBook.selectStateFromStateDropDown(state);
test.info("Select State Name");
myProfileAddressBook.enterZipCode(zipCode);
test.info("Entered Zip Code");
myProfileAddressBook.clickSaveAddressButton();
test.info("Click on SAVE Button");

}

public void signOut(HomePage homePage) throws InterruptedException {
homePage.SignOut();
test.info("Clicked on Sign out button");
}

public String applyValidPromoCode(MyCartPage mycartpage,String promoCode) throws InterruptedException {
return mycartpage.applyValidCoupon(promoCode);
}

public void deleteCookies() {
HomePage homePage=new HomePage(getDriver());
String previewCode = PropertiesOperations.getPropertyValueByKey("preview_code");
getDriver().manage().deleteAllCookies();
getDriver().navigate().refresh();
homePage.typePreviewCode(previewCode);
homePage.clickSubmitButton();
}

}
