package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CreateAccountPage;
import pages.HomePage;
import pages.LoginPage;
import pages.MiniCartPage;
import pages.MyCartPage;
import pages.PDPPage;
import reusableComponents.GenericAppFunctions;
import setup.DriverManager;
import util.PropertiesOperations;

public class CartPageTest extends DriverManager {	
	
	/*
	 * =============================================================================
	 * Tests
	 * =============================================================================
	 */

	/*
	 * Creator - Surendra
	 * Modifier - 
	 * Story - SC-1422
	 * TC#1035  - Verify cart persistent functionality 	 
	 */

	@Test(priority = 0, groups= {"Cart", "Regression"})
	public void SC1422_TC1035_VerifyCartPersistentFunctionality() throws InterruptedException  {		
		GenericAppFunctions genericAppFunctions=new GenericAppFunctions();
		MiniCartPage miniCartPage=new MiniCartPage(getDriver());
		MyCartPage myCartPage=new MyCartPage(getDriver());
		PDPPage pdppage=new PDPPage(getDriver());
		HomePage homePage = new HomePage(getDriver());			
		CreateAccountPage createAccountPage = new CreateAccountPage(getDriver());	
		String UserName = genericAppFunctions.createUser(homePage,createAccountPage);
		test.info("New user created");
		genericAppFunctions.navigateToPdpPage(pdppage,"1-l-le-parfait-jar/");
		test.info("Navigated To PDP Page");
		String productName = genericAppFunctions.addProductToCartFromPDP(pdppage);			
		test.info("Product Added from PDP Page");
		test.info("Product Name Added "+ productName);
		createAccountPage.clickHumbergerMenu();
		test.info("Click on Humberger Menu");
		homePage.clickSignOutButttonInHamBergerMenu();
		test.info("Click on Sig out button present in Humberger Menu");
		genericAppFunctions.deleteCookies();
		genericAppFunctions.signInUser(UserName, PropertiesOperations.getPropertyValueByKey("password"));
		miniCartPage.clickMiniCartButton();	
		test.info("Mini Cart Icon Clicked");	
		miniCartPage.clickReviewCartButtonInMiniCart();
		test.info("Review Cart Button Clicked");		
		Assert.assertTrue(myCartPage.isProductImageDisplayed());
		test.info("Image is Displayed in My Cart");
		Assert.assertTrue(myCartPage.isProductNameDisplayed());
		test.info("Product Name is Displayed in My Cart");
		getDriver().navigate().refresh();
		String ProductNameFromCart = myCartPage.ProductNameFromCart1();
		Assert.assertEquals(ProductNameFromCart, productName);		
		test.info("Cart persistent functionality working fine");
	}	
	
	
	/*
	 * Creator - Surendra
	 * Modifier - 
	 * Story - SC-1422
	 * TC#1036  - Verify cart persistent functionality 	 
	 */

	@Test(priority = 1, groups= {"Cart", "Regression"})
	public void SC1422_TC1036_VerifyCartPersistentAndMergingFunctionality() throws InterruptedException  {		
		GenericAppFunctions genericAppFunctions=new GenericAppFunctions();
		MiniCartPage miniCartPage=new MiniCartPage(getDriver());
		MyCartPage myCartPage=new MyCartPage(getDriver());
		PDPPage pdppage=new PDPPage(getDriver());
		HomePage homePage = new HomePage(getDriver());	
		CreateAccountPage createAccountPage = new CreateAccountPage(getDriver());
		String UserName = genericAppFunctions.createUser(homePage,createAccountPage);
		test.info("New user created");
		genericAppFunctions.navigateToPdpPage(pdppage,"1-l-le-parfait-jar/");
		test.info("Navigated To PDP Page");
		String productName1 = genericAppFunctions.addProductToCartFromPDP(pdppage);			
		test.info("Product Added from PDP Page");
		test.info("Product Name Added "+ productName1);
		createAccountPage.clickHumbergerMenu();
		test.info("Click on Humberger Menu");
		homePage.clickSignOutButttonInHamBergerMenu();
		test.info("Click on Sig out button present in Humberger Menu");
		genericAppFunctions.deleteCookies();
		genericAppFunctions.navigateToPdpPage(pdppage,"able-brewing-system/");
		test.info("Navigated To PDP Page");
		String productName2 = genericAppFunctions.addProductToCartFromPDPwithoutSizeAndColor(pdppage);			
		test.info("Product Added from PDP Page");
		test.info("Product Name Added "+ productName2);
		getDriver().navigate().refresh();
		genericAppFunctions.signInUser(UserName, PropertiesOperations.getPropertyValueByKey("password"));
		miniCartPage.clickMiniCartButton();	
		test.info("Mini Cart Icon Clicked");	
		miniCartPage.clickReviewCartButtonInMiniCart();
		test.info("Review Cart Button Clicked");		
		Assert.assertTrue(myCartPage.isProductImageDisplayed());
		test.info("Image is Displayed in My Cart");
		Assert.assertTrue(myCartPage.isProductNameDisplayed());
		test.info("Product Name is Displayed in My Cart");
		String ProductNameFromCart1 = myCartPage.ProductNameFromCart1();
		String ProductNameFromCart2 = myCartPage.ProductNameFromCart2();
		Assert.assertEquals(ProductNameFromCart1, productName1);	
		Assert.assertEquals(ProductNameFromCart2, productName2);
		test.info("Cart persistent and merging functionality working fine");
	}	
	
}
