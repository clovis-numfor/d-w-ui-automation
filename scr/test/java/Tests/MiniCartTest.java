package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.MiniCartPage;
import pages.PDPPage;
import reusableComponents.DataSupplier;
import reusableComponents.GenericAppFunctions;
import setup.DriverManager;

public class MiniCartTest extends DriverManager {

	/*
	* =============================================================================
	* Tests
	* =============================================================================
	*/

	/*
	* Creator - Vikas SP Modifier - Story - SC-1404 TC#374 - Verify - Verify Mini
	* Cart has details about Thumbnail Image,Item Name,Quantity in Cart,Price and
	* Sale Price for Addded Item
	*/

	@Test(enabled = true, priority = 0, groups = {"MiniCart","Smoke","Regression"})
	public void SC1404_TC374_verifyItemDetailsPresentInMiniCart() throws InterruptedException {
	MiniCartPage minicartpage = new MiniCartPage(getDriver());
	GenericAppFunctions genericappfunctions = new GenericAppFunctions();
	PDPPage pdppage = new PDPPage(getDriver());
	genericappfunctions.navigateToPdpPage(pdppage, "1-l-le-parfait-jar/");
	test.info("Navigated To PDP Page");
	String productname = genericappfunctions.addProductToCartFromPDP(pdppage);
	test.info("Product Added from PDP Page");
	test.info("Product Name Added " + productname);
	minicartpage.clickMiniCartButton();	
	test.info("Preview Cart Image Displayed");
	Assert.assertTrue(minicartpage.isPreviewCartContentDisplayed());
	test.info("Item Name Displayed");
	Assert.assertTrue(minicartpage.isItemPriceDisplayed());
	test.info("Item Price Displayed");
	Assert.assertTrue(minicartpage.isCartQuantityDisplayed());
	test.info("Item Quantity Displayed");
	test.pass("All Item Details Are Present in Mini Cart");

	}

	/*
	* Creator - Surendra Modifier - Story - SC 1092 TC#756 - Verify Mini cart
	* Should be visible when user clicks on Cart Icon
	*/

	@Test(enabled = true, priority = 1, groups = {"MiniCart","Smoke","Regression"})
	public void SC1092_TC756_VerifyMiniCartShouldBeVisibleWhenUserClicksOnCartIcon() throws InterruptedException {
	MiniCartPage minicartpage = new MiniCartPage(getDriver());
	GenericAppFunctions genericappfunctions = new GenericAppFunctions();
	PDPPage pdppage = new PDPPage(getDriver());
	genericappfunctions.navigateToPdpPage(pdppage, "1-l-le-parfait-jar/");
	test.info("Navigated To PDP Page");
	genericappfunctions.addProductToCartFromPDP(pdppage);
	test.info("Product Added from PDP Page");
	minicartpage.clickMiniCartButton();
	test.info("Mini Cart Icon Clicked");
	Assert.assertTrue(minicartpage.isPreviewCartImageDisplayed());
	test.info("Preview Cart Image Displayed");
	Assert.assertTrue(minicartpage.isPreviewCartContentDisplayed());
	test.info("Item Name Displayed");
	}

	/*
	* Creator - Surndra Modifier - Story - SC-1092 TC#757 - Verify contents in my
	* cart
	*/

	@Test(enabled = true, priority = 2,groups = {"MiniCart","Smoke","Regression"})
	public void SC1092_TC757_VerifyContentsInMyCart() throws InterruptedException {
	MiniCartPage minicartpage = new MiniCartPage(getDriver());
	GenericAppFunctions genericappfunctions = new GenericAppFunctions();
	PDPPage pdppage = new PDPPage(getDriver());
	genericappfunctions.navigateToPdpPage(pdppage, "1-l-le-parfait-jar/");
	test.info("Navigated To PDP Page");
	genericappfunctions.addProductToCartFromPDP(pdppage);
	test.info("Product Added from PDP Page");
	minicartpage.clickMiniCartButton();
	test.info("Mini Cart Icon Clicked");
	Assert.assertTrue(minicartpage.isPreviewCartImageDisplayed());
	test.info("Preview Cart Image Displayed");
	Assert.assertTrue(minicartpage.isPreviewCartContentDisplayed());
	test.info("Item Name Displayed");
	Assert.assertTrue(minicartpage.isItemPriceDisplayed());
	test.info("Item Price Displayed");
	Assert.assertTrue(minicartpage.isCartQuantityDisplayed());
	test.info("Item Quantity Displayed");
	test.pass("All Item Details Are Present in Mini Cart");

	}

	/*
	* Creator - Surendra Modifier - Story - SC-1092 TC#758 - verify quantity of
	* each item added
	*/

	@Test(enabled = true, priority = 3, groups = {"MiniCart","Smoke","Regression"})
	public void SC1092_TC758_VerifyQuantityOfEachItemAdded() throws InterruptedException {
	MiniCartPage minicartpage = new MiniCartPage(getDriver());
	GenericAppFunctions genericappfunctions = new GenericAppFunctions();
	PDPPage pdppage = new PDPPage(getDriver());
	genericappfunctions.navigateToPdpPage(pdppage, "1-l-le-parfait-jar/");
	test.info("Navigated To PDP Page");
	genericappfunctions.addProductToCartFromPDP(pdppage);
	test.info("Product Added from PDP Page");
	minicartpage.clickMiniCartButton();
	test.info("Mini Cart Icon Clicked");
	Assert.assertTrue(minicartpage.isPreviewCartImageDisplayed());
	test.info("Preview Cart Image Displayed");
	Assert.assertTrue(minicartpage.isCartQuantityDisplayed());
	test.info("Item Quantity Displayed.");
	}

	/*
	* Creator - Vikas SP Modifier - Story - SC-1405 TC#854 - Verify User should
	* navigate to PDP page after clicking on thumbnail image under minicart
	*/

	@Test(enabled = true, priority = 4, groups = {"MiniCart","Smoke","Regression"})
	public void SC1405_TC854_verifyPdpLandingPageFromMiniCart() throws InterruptedException {
	MiniCartPage minicartpage = new MiniCartPage(getDriver());
	GenericAppFunctions genericappfunctions = new GenericAppFunctions();
	PDPPage pdppage = new PDPPage(getDriver());
	genericappfunctions.navigateToPdpPage(pdppage, "1-l-le-parfait-jar/");
	test.info("Navigated To PDP Page");
	String productname = genericappfunctions.addProductToCartFromPDP(pdppage);
	test.info("Product Added from PDP Page");
	test.info("Product Name " + productname);	
	minicartpage.clickItemNameLinkInMiniCart();
	test.info("Clicked Item Name Link in Mini Cart");
	Assert.assertTrue(pdppage.isPDPDisplayed());
	test.info("PDP Page Displayed");
	test.pass("Landed in PDP Page Successfully");

	}

	/*
	* Creator - Vikas SP Modifier - Story - SC-1409 TC#372 - Verify Review Button
	* in Mini Cart Should Present If Cart Has Items
	*/

	@Test(enabled = true, priority = 5,groups = {"MiniCart","Smoke","Regression"})
	public void SC1409_TC372_verifyReviewButtontPresent() throws InterruptedException {
	MiniCartPage minicartpage = new MiniCartPage(getDriver());
	GenericAppFunctions genericappfunctions = new GenericAppFunctions();
	PDPPage pdppage = new PDPPage(getDriver());
	genericappfunctions.navigateToPdpPage(pdppage, "1-l-le-parfait-jar/");
	test.info("Navigated To PDP Page");
	String productname = genericappfunctions.addProductToCartFromPDP(pdppage);
	test.info("Product Added from PDP Page");
	test.info("Product Name " + productname);	
	Assert.assertTrue(minicartpage.isReviewCartButtonDisplayed());
	test.pass("Review Button is displayed in Mini Cart");

	}

	/*
	* Creator - Vikas SP Modifier - Story - SC-1409 TC#373 - Verify Review Button
	* in Mini Cart Should not Present If Cart is Empty
	*/

	@Test(enabled = true, priority = 6, groups = {"MiniCart","Smoke","Regression"})
	public void SC1409_TC373_verifyReviewButtontNotPresent() {
	MiniCartPage minicartpage = new MiniCartPage(getDriver());
	minicartpage.clickMiniCartButton();
	test.info("Mini Cart Button Clicked");
	Assert.assertFalse(minicartpage.isReviewCartButtonDisplayed());
	test.pass("Review Button is Not displayed in Mini Cart");

	}

	/*
	* Creator - Vikas SP Modifier - Story - SC-1563 TC#473 -Verify the Slide out of
	* Mini cart items count Logged in user
	*/

	@Test(enabled = true, priority = 7, dataProvider = "userDetails",dataProviderClass = DataSupplier.class, groups = {"MiniCart","Smoke","Regression"})
	public void SC1563_TC473_verifyDetailsPresentInMiniCartForLoggedInUsers(String userName, String password, String fullName) throws InterruptedException {
	MiniCartPage minicartpage = new MiniCartPage(getDriver());
	GenericAppFunctions genericappfunctions = new GenericAppFunctions();
	PDPPage pdppage = new PDPPage(getDriver());	
	HomePage homePage = new HomePage(getDriver());
	genericappfunctions.signInUser(userName,password);
	Assert.assertTrue(homePage.isHiUserNameDisplayed(fullName));
	test.pass("Hi, User Name Text displayed");
	genericappfunctions.navigateToPdpPage(pdppage, "1-l-le-parfait-jar/");
	test.info("Navigated To PDP Page");
	String productname = genericappfunctions.addProductToCartFromPDP(pdppage);
	test.info("Product Added from PDP Page");
	test.info("Product Name Added " + productname);	
	Assert.assertTrue(minicartpage.isRecentlyViewedItemsLabelDisplayed());
	test.info("Recently Viewed Items Label Displayed");
	Assert.assertTrue(minicartpage.isSavedForLaterLabelDisplayed());
	test.info("Saved For Later Label Displayed");
	Thread.sleep(8000);
	test.pass("All Item Details Are Present in Mini Cart");

	}

	/*
	* Creator - Vikas SP Modifier - Story - SC-1563 TC#474 - Verify Mini Cart
	* layout if Cart is Empty Logged in user
	*/

	@Test(enabled = true, priority = 8,dataProvider = "userDetails",dataProviderClass = DataSupplier.class, groups = {"MiniCart","Smoke","Regression"})
	public void SC1563_TC474_verifyEmptyMiniCartForLoggedInUsers(String userName, String password, String fullName) throws InterruptedException {
	MiniCartPage minicartpage = new MiniCartPage(getDriver());
	GenericAppFunctions genericappfunctions = new GenericAppFunctions();	
	HomePage homePage = new HomePage(getDriver());
	genericappfunctions.signInUser(userName,password);
	Assert.assertTrue(homePage.isHiUserNameDisplayed(fullName));
	test.pass("Hi, User Name Text displayed");
	minicartpage.clickMiniCartButton();
	test.info("Mini Cart Icon Clicked");
	Assert.assertTrue(minicartpage.isEmptyCartLabelDisplayed());
	test.info("Empty Cart Label Displayed in MiniCart");	

	}

	/*
	* Creator - Vikas SP Modifier - Story - SC-1563 TC#874 - Verify Mini Cart
	* layout - For Guest User
	*/

	@Test(enabled = true, priority = 9, groups = {"MiniCart","Smoke","Regression"})
	public void SC1563_TC874_verifyMiniCartLayoutForGuestInUsers() throws InterruptedException {
	MiniCartPage minicartpage = new MiniCartPage(getDriver());
	GenericAppFunctions genericappfunctions = new GenericAppFunctions();
	PDPPage pdppage = new PDPPage(getDriver());
	genericappfunctions.navigateToPdpPage(pdppage, "1-l-le-parfait-jar/");
	test.info("Navigated To PDP Page");
	String productname = genericappfunctions.addProductToCartFromPDP(pdppage);
	test.info("Product Added from PDP Page");
	test.info("Product Name Added " + productname);
	Assert.assertTrue(minicartpage.isRecentlyViewedItemsLabelDisplayed());
	test.info("Recently Viewed Items Label Displayed");	
	test.pass("All Details Are Present in Mini Cart");

	}

	/*
	* Creator - Vikas SP Modifier - Story - SC-1563 TC#534 - Verify GetInspired
	* Button Under Empty MiniCart
	*/

	@Test(enabled = true, priority = 10, groups = {"MiniCart","Smoke","Regression"})
	public void SC1563_TC534_verifyGetInspiredButtonInMiniCart() throws InterruptedException {
	MiniCartPage minicartpage = new MiniCartPage(getDriver());	
	minicartpage.clickMiniCartButton();
	test.info("Mini Cart Icon Clicked");
	Assert.assertTrue(minicartpage.isGetInspiredDisplayed());
	test.info("Get Inspired Button Displayed");	

	}
	
	/*
	* Creator - Vikas SP
	* Modifier - 
	* Story - SC-1179
	* TC#630 - Verify Layout of Remove Item(s) in Mini Cart	
	*/

	@Test(enabled = true, priority = 11, groups = {"MiniCart","Smoke","Regression"})
	public void SC1179_TC630_verifyRemoveButtonInMiniCart() throws InterruptedException {
	MiniCartPage minicartpage = new MiniCartPage(getDriver());
	GenericAppFunctions genericappfunctions = new GenericAppFunctions();
	PDPPage pdppage = new PDPPage(getDriver());
	genericappfunctions.navigateToPdpPage(pdppage, "1-l-le-parfait-jar/");
	test.info("Navigated To PDP Page");
	String productname = genericappfunctions.addProductToCartFromPDP(pdppage);
	test.info("Product Added from PDP Page");
	test.info("Product Name Added " + productname);
	Assert.assertTrue(minicartpage.isRemoveButtonInMiniCartDisplayed());
	test.info("Remove Button in Mini Cart Displayed");	

	}
	
	/*
	* Creator - Vikas SP
	* Modifier - 
	* Story - SC-1179
	* TC#691 - Verify Remove Item(s) Using Mini Cart Slide-out 
	*/

	@Test(enabled = true, priority = 11,groups = {"MiniCart","Smoke","Regression"})
	public void SC1179_TC691_verifyRemoveButtonOperationInMiniCart() throws InterruptedException {
	MiniCartPage minicartpage = new MiniCartPage(getDriver());
	GenericAppFunctions genericappfunctions = new GenericAppFunctions();
	PDPPage pdppage = new PDPPage(getDriver());
	genericappfunctions.navigateToPdpPage(pdppage, "1-l-le-parfait-jar/");
	test.info("Navigated To PDP Page");
	String productname = genericappfunctions.addProductToCartFromPDP(pdppage);
	test.info("Product Added from PDP Page");
	test.info("Product Name Added " + productname);
	genericappfunctions.navigateToPdpPage(pdppage, "canvas-laundry-cart/");
	test.info("Navigated To PDP Page");
	String productname1 = genericappfunctions.addProductToCartFromPDPwithoutSizeAndColor(pdppage);
	test.info("Product Added from PDP Page");
	test.info("Product Name Added " + productname1);
	int subTotalBeforeRemove=minicartpage.returnMiniCartSubTotal();
	test.info("SubTotal Before Remove " + subTotalBeforeRemove);
	minicartpage.clickFirstRemoveButtonMiniCart();
	test.info("Clicked On First Remove Button in Mini Cart");
	int subTotalAfterRemove=minicartpage.returnMiniCartSubTotal();
	test.info("SubTotal After Remove " + subTotalAfterRemove);	
	Assert.assertTrue(subTotalAfterRemove<subTotalBeforeRemove);	
	test.info("Remove Item in Mini cart Validated Successfully");
	}	
	
}
