package Tests;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import reusableComponents.GenericFunctions;
import setup.DriverManager;

public class HomePageTest extends DriverManager {

	/*
	* =============================================================================
	* Tests
	* =============================================================================
	*/

	/*
	* Creator - Mahantesh Hadimani
	* Modifier - 
	* SC-1568
	* TC#552 - Validate the Footer Contents 
	*/

	@Test(enabled=true, priority = 0, groups = {"Footer","Home","Smoke","Regression"})
	public void SC1568_TC552_validateFooterContents() throws InterruptedException {
	HomePage homePage = new HomePage(getDriver());
	HashMap<String,String> footerLinks = new HashMap<String,String>();	
	footerLinks.put("100 Night Guarantee","100 Night Guarantee");
	footerLinks.put("Sleep System Quiz","Sleep System Quiz");	
	footerLinks.put("Ultimate Buying Guide","Ultimate Buying Guide");
	footerLinks.put("Return & Exchanges","Return & Exchanges");
	footerLinks.put("Shipping & Delivery","Shipping & Delivery");
	footerLinks.put("Warranty Guide","Warranty Guide");
	footerLinks.put("Gift Card Balance","Gift Card Balance");
	footerLinks.put("Affirm Financing","Affirm Financing");
	footerLinks.put("Flexiti Financing","Flexiti Financing");
	footerLinks.put("Price Match Guarantee","Price Match Guarantee");
	footerLinks.put("About Us","About Us");
	footerLinks.put("Investor Relations","Investor Relations");
	footerLinks.put("Careers","Careers");
	footerLinks.put("Environmental Sustainability","Environmental Sustainability");	
	footerLinks.put("Help Center","Help Center");
	footerLinks.put("Contact Us","Contact Us");
	footerLinks.put("Track My Order","Track My Order");
	footerLinks.put("Find a Store","Find a Store");	
	
	for(Map.Entry<String, String> footer: footerLinks.entrySet()) {
	homePage.clickFooterElement(footer.getKey());
	test.info(footer.getKey() + " - Footer Link Clicked");
	Assert.assertTrue(homePage.isPageHeadingDisplayed(footer.getValue()));
	test.info(footer.getValue() + "- Page Displayed");
	//getDriver().navigate().back();
	}

	test.pass("All Footer Contents verified");
	}
	
	/*
	* Creator - Mahantesh Hadimani
	* Modifier - 
	* SC-2004
	* TC#1164 - Create Newsletter sign up 
	*/

	@Test(enabled=true, priority = 1, groups = {"Footer","Home","Smoke","Regression", "Newsletter"})
	public void SC2004_TC1164_verifyNewsletterSignUpBoxInFooter() throws InterruptedException {
	HomePage homePage = new HomePage(getDriver());
	Assert.assertTrue(homePage.isSubscribeInputDisplayed());
 test.info("Subscribe Input Displayed");
 Assert.assertTrue(homePage.isSubscribeButtonDisplayed());
 test.info("Subscribe Button Displayed");	
	test.pass("Subscribe input and button displayed");
	}
	
	/*
	* Creator - Mahantesh Hadimani
	* Modifier - 
	* SC-2004
	* TC#1165 - Verify that only new user is able Sign up for Newsletter 
	*/

	@Test(enabled=true, priority = 2, groups = {"Footer","Home","Smoke","Regression", "Newsletter"})
	public void SC2004_TC1165_verifyNewUserAbleToSignupForNewsletter() throws InterruptedException {
	HomePage homePage = new HomePage(getDriver());
	GenericFunctions gf = new GenericFunctions();
	long currentTimeStamp = gf.getTimeStamp();
	String emailAddress = "automation.user" + currentTimeStamp + "@gmail.com";
	homePage.enterEmailInSubScribeInput(emailAddress);
 test.info("Enter email in Subscribe Input");
 homePage.clickSubscribeButton();
 test.info("Clicked Subscribe Button");
 Assert.assertTrue(homePage.isnewsletterSubscriptionSuccessMsgDisplayed());
	test.pass("User able to signup for Newsletter");
	}
	
	/*
	* Creator - Mahantesh Hadimani
	* Modifier - 
	* SC-2004
	* TC#1166 - Verify that when user signUp for newsletter information is captured in contacts as opted in for marketing 
	*/

	@Test(enabled=true, priority = 3,groups = {"Footer","Home","Smoke","Regression", "Newsletter"})
	public void SC2004_TC1166_verifyNewUserSignupForNewsletterCaptured() throws InterruptedException {
	HomePage homePage = new HomePage(getDriver());
	GenericFunctions gf = new GenericFunctions();
	long currentTimeStamp = gf.getTimeStamp();
	String emailAddress = "automation.user" + currentTimeStamp + "@gmail.com";
	homePage.enterEmailInSubScribeInput(emailAddress);
 test.info("Enter email in Subscribe Input");
 homePage.clickSubscribeButton();
 test.info("Clicked Subscribe Button");
 Assert.assertTrue(homePage.isnewsletterSubscriptionSuccessMsgDisplayed());
	test.pass("User able to signup for Newsletter");
	//To-DO : Functionality not yet implemented to check user subscribed or not
	}
	
	/*
	* Creator - Mahantesh Hadimani
	* Modifier - 
	* SC-2004
	* TC#1167 - Verify the success message when user Sign up for Newsletter 
	*/

	@Test(enabled=true, priority = 4, groups = {"Footer","Home","Smoke","Regression", "Newsletter"})
	public void SC2004_TC1167_verifySuccessMessageDisplayedAfterSignupForNewsletter() throws InterruptedException {
	HomePage homePage = new HomePage(getDriver());
	GenericFunctions gf = new GenericFunctions();
	long currentTimeStamp = gf.getTimeStamp();
	String emailAddress = "automation.user" + currentTimeStamp + "@gmail.com";
	homePage.enterEmailInSubScribeInput(emailAddress);
 test.info("Enter email in Subscribe Input");
 homePage.clickSubscribeButton();
 test.info("Clicked Subscribe Button");
 Assert.assertTrue(homePage.isnewsletterSubscriptionSuccessMsgDisplayed());
	test.pass("Success Message for Newsletter subscription displayed");
	}
	
	/*
	* Creator - Mahantesh Hadimani
	* Modifier - 
	* SC-2004
	* TC#1168 - Verify the functionality when the user who has previously signed up for newsletter tries again to signup
	*/

	@Test(enabled=true, priority = 5, groups = {"Footer","Home","Smoke","Regression", "Newsletter"})
	public void SC2004_TC1168_verifyWhenUserTryToSignupForNewsletterAgainUsingSignupEmail() throws InterruptedException {
	HomePage homePage = new HomePage(getDriver());
	GenericFunctions gf = new GenericFunctions();
	long currentTimeStamp = gf.getTimeStamp();
	String emailAddress = "automation.user" + currentTimeStamp + "@gmail.com";
	homePage.enterEmailInSubScribeInput(emailAddress);
 test.info("Enter email in Subscribe Input");
 homePage.clickSubscribeButton();
 test.info("Clicked Subscribe Button");
 Assert.assertTrue(homePage.isnewsletterSubscriptionSuccessMsgDisplayed());
 homePage.enterEmailInSubScribeInput(emailAddress);
 test.info("Enter email in Subscribe Input");
 homePage.clickSubscribeButton();
 test.info("Clicked Subscribe Button");
 Assert.assertTrue(homePage.isEmailAlreadySignedUpMsgDisplayed());
	test.pass("Email Already SignedUp Message displayed");
	}
	
	/*
	* Creator - Mahantesh Hadimani
	* Modifier - 
	* SC-1575
	* TC#509 - Verify the copyright info in the Footer
	*/

	@Test(enabled=true, priority = 6, groups = {"Footer","Home","Smoke","Regression"})
	public void SC1575_TC509_verifyCopyrightInfoInTheFooter() throws InterruptedException {
	HomePage homePage = new HomePage(getDriver());
	
 Assert.assertTrue(homePage.isCopyRightsTextDisplayed());
	test.pass("Copy Rights info displayed");
	}
	
	/*
	* Creator - Mahantesh Hadimani
	* Modifier - 
	* SC-1575
	* TC#510 - Verify that copyright info in the footer is as per the UX design
	*/

	@Test(enabled=true, priority = 7, groups = {"Footer","Home","Smoke","Regression"})
	public void SC1575_TC510_verifyCopyrightInfoInTheFooterIsDiaplayedAsPerUXdesign() throws InterruptedException {
	HomePage homePage = new HomePage(getDriver());
	
 Assert.assertTrue(homePage.isCopyRightsTextDisplayed());
	test.pass("Copy Rights info displayed as per UX design");
	}
	
	/*
	* Creator - Mahantesh Hadimani
	* Modifier - 
	* SC-1575
	* TC#511 - Verify the behavior when user clicks on Privacy policy 
	*/

	@Test(enabled=true, priority = 8, groups = {"Footer","Home","Smoke","Regression"})
	public void SC1575_TC511_verifyPrivacyPolicyLinkOnFooter() throws InterruptedException {
	HomePage homePage = new HomePage(getDriver());
	homePage.clickPrivacyPolicyLink();
	test.info("Clicked Privacy Policy Link");
 Assert.assertTrue(homePage.isPageHeadingDisplayed("Privacy Policy"));
	test.pass("Privacy Policy Page Displayed");
	}
	
	/*
	* Creator - Mahantesh Hadimani
	* Modifier - 
	* SC-1575
	* TC#512 - Verify the behavior when user clicks on the offers Details link in the footer
	*/

	@Test(enabled=true, priority = 9, groups = {"Footer","Home","Smoke","Regression"})
	public void SC1575_TC512_verifyOfferDetailsLinkOnFooter() throws InterruptedException {
	HomePage homePage = new HomePage(getDriver());
	homePage.clickOfferDetailsLink();
	test.info("Clicked Offer Details Link");
 Assert.assertTrue(homePage.isPageHeadingDisplayed("Offers Detail Page"));
	test.pass("Offers Detail Page Displayed");
	}
	
	/*
	* Creator - Mahantesh Hadimani
	* Modifier - 
	* SC-1575
	* TC#513 - Verify the behavior when user clicks on terms & conditions link in the Footer
	*/

	@Test(enabled=true, priority = 10, groups = {"Footer","Home","Smoke","Regression"})
	public void SC1575_TC513_verifyTermsAndConditionsLinkOnFooter() throws InterruptedException {
	HomePage homePage = new HomePage(getDriver());
	homePage.clickTermsAndConditionsLink();
	test.info("Clicked Terms & Conditions Link");
 Assert.assertTrue(homePage.isPageHeadingDisplayed("Terms & Conditions"));
	test.pass("Terms & Conditions Page Displayed");
	}
}
