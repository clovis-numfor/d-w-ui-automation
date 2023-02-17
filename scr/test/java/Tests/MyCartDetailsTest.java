package Tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.CreateAccountPage;
import pages.HomePage;
import pages.MiniCartPage;
import pages.MyCartPage;
import pages.PDPPage;
import reusableComponents.DataSupplier;
import reusableComponents.GenericAppFunctions;
import setup.DriverManager;

public class MyCartDetailsTest extends DriverManager {	
	
	/*
	* =============================================================================
	* Tests
	* =============================================================================
	*/

	/*
	* Creator - Vikas SP
	* Modifier - 
	* Story - SC-1426
	* TC#318 - Verify Name and Picture Sku Color and Size of Item under My Cart	
	*/

	@Test(enabled=false,priority = 0,groups = {"MyCart","Smoke","Regression"})
	public void SC1426_TC318_verifyNamePicturePresntInMyCart() throws InterruptedException {	
	MiniCartPage minicartpage=new MiniCartPage(getDriver());
	MyCartPage mycartpage=new MyCartPage(getDriver());	
	GenericAppFunctions genericappfunctions=new GenericAppFunctions();
	PDPPage pdppage=new PDPPage(getDriver());
	genericappfunctions.navigateToPdpPage(pdppage,"1-l-le-parfait-jar/");
	test.info("Navigated To PDP Page");
	String productname=genericappfunctions.addProductToCartFromPDP(pdppage);	
	test.info("Product Added from PDP Page");
	test.info("Product Name Added "+productname);
	minicartpage.clickReviewCartButtonInMiniCart();
	test.info("Review Cart Button Clicked");	
	Assert.assertTrue(mycartpage.isProductImageDisplayed());
	test.info("Image is Displayed in My Cart");
	Assert.assertTrue(mycartpage.isProductNameDisplayed());
	test.info("Product Name is Displayed in My Cart");	
	Assert.assertTrue(mycartpage.isSkuDisplayed());
	test.info("Sku is Displayed in My Cart");
	Assert.assertTrue(mycartpage.isSizeDisplayed());
	test.info("Size is Displayed in My Cart");
	Assert.assertTrue(mycartpage.isColorDisplayed());
	test.info("Color is Displayed in My Cart");
	test.pass("All Properties are displayed under My Cart successfully");	

	}	
	
	/*
	* Creator - Vikas SP
	* Modifier - 
	* Story - SC-1426 SC-1429
	* TC#320 -TC#384 Verify the user is able to update the Quantity for added item in the Cart	
	*/

	@Test(enabled=false,priority = 1,groups = {"MyCart","Smoke","Regression"})
	public void SC1426_SC1429_TC320_TC384_verifyUpdateQuantityInMyCart() throws InterruptedException {	
	MiniCartPage minicartpage=new MiniCartPage(getDriver());
	MyCartPage mycartpage=new MyCartPage(getDriver());	
	GenericAppFunctions genericappfunctions=new GenericAppFunctions();
	PDPPage pdppage=new PDPPage(getDriver());
	genericappfunctions.navigateToPdpPage(pdppage,"1-l-le-parfait-jar/");
	test.info("Navigated To PDP Page");
	String productname=genericappfunctions.addProductToCartFromPDP(pdppage);	
	test.info("Product Added from PDP Page");
	test.info("Product Name Added "+productname);	
	minicartpage.clickReviewCartButtonInMiniCart();
	test.info("Review Cart Button Clicked");	
	Assert.assertTrue(mycartpage.validateUserAbleToUpdate());
	test.info("User able to update with add and remove Quantity");
	test.pass("User able to update with add and remove Quantity");	

	}	
	
	
	/*
	* Creator - Vikas SP
	* Modifier - 
	* Story - SC-1426,SC-1429
	* TC#321 TC#382- Validation for InValid Quantity for Quantity input Textbox in MyCart 
	*/

	@Test(enabled=false,priority = 2,groups = {"MyCart","Smoke","Regression"})
	public void SC1426_SC1429_TC321_TC382_verifyInvalidQuantityInMyCart() throws InterruptedException {	
	MiniCartPage minicartpage=new MiniCartPage(getDriver());
	MyCartPage mycartpage=new MyCartPage(getDriver());	
	GenericAppFunctions genericappfunctions=new GenericAppFunctions();
	PDPPage pdppage=new PDPPage(getDriver());
	genericappfunctions.navigateToPdpPage(pdppage,"1-l-le-parfait-jar/");
	test.info("Navigated To PDP Page");
	String productname=genericappfunctions.addProductToCartFromPDP(pdppage);	
	test.info("Product Added from PDP Page");
	test.info("Product Name Added "+productname);	
	minicartpage.clickReviewCartButtonInMiniCart();
	test.info("Review Cart Button Clicked");
	Assert.assertTrue(mycartpage.validateAlertTextForZeroQuantityValue());
	test.info("Alert Validation For Zero Value Completed");
	Assert.assertTrue(mycartpage.validateQuantityInputForThreeDigitValue());	
	test.info("Quantity input validation for three digit value completed");
	test.pass("Quantity Input Validation Completed Successfully");	

	}	
	
	/*
	* Creator - Vikas SP
	* Modifier - 
	* Story - SC-1426
	* TC#322 - Verify PDP Navigation After User clicks on Thumbnail or Name in My Cart Page 
	*/	
	@Test(enabled=false,priority = 3,groups = {"MyCart","Smoke","Regression"})
	public void SC1426_TC322_verifyPdpNavigationInMyCart() throws InterruptedException {	
	MiniCartPage minicartpage=new MiniCartPage(getDriver());
	MyCartPage mycartpage=new MyCartPage(getDriver());	
	GenericAppFunctions genericappfunctions=new GenericAppFunctions();
	PDPPage pdppage=new PDPPage(getDriver());	
	genericappfunctions.navigateToPdpPage(pdppage,"1-l-le-parfait-jar/");
	test.info("Navigated To PDP Page");
	String productname=genericappfunctions.addProductToCartFromPDP(pdppage);	
	test.info("Product Added from PDP Page");
	test.info("Product Name Added "+productname);	
	minicartpage.clickReviewCartButtonInMiniCart();
	test.info("Review Cart Button Clicked");	
	mycartpage.clickItemThumbnailInMyCart();
	test.info("User is in My Cart Page");
	test.info("Item Thumbnail Clicked in My Cart");	
	Assert.assertTrue(pdppage.isPDPDisplayed());
	minicartpage.clickMiniCartButton();	
	test.info("Mini Cart Icon Clicked");	
	minicartpage.clickReviewCartButtonInMiniCart();
	test.info("Review Cart Button Clicked");
	mycartpage.clickItemNameInMyCart();
	test.info("User is in My Cart Page");
	test.info("Item Name Clicked in My Cart");	
	Assert.assertTrue(pdppage.isPDPDisplayed());
	test.info("PDP Page Displayed");	
	test.pass("PDP Page Validation Completed For Thumbnail and Name Successfully");	

	}	
	
	/*
	* Creator - Vikas SP
	* Modifier - 
	* Story - SC-1426
	* TC#381 - Verify Cart Quantity when new item is added with already Added in the Cart 
	*/	
	@Test(enabled=false,priority = 4,groups = {"MyCart","Smoke","Regression"})
	public void SC1426_TC381_verifyCartQuantityInMyCart() throws InterruptedException {	
	MiniCartPage minicartpage=new MiniCartPage(getDriver());
	MyCartPage mycartpage=new MyCartPage(getDriver());	
	GenericAppFunctions genericappfunctions=new GenericAppFunctions();
	PDPPage pdppage=new PDPPage(getDriver());
	genericappfunctions.navigateToPdpPage(pdppage,"1-l-le-parfait-jar/");
	test.info("Navigated To PDP Page");
	String productname=genericappfunctions.addProductToCartFromPDP(pdppage);	
	test.info("Product Added from PDP Page");
	test.info("Product Name Added "+productname);	
	minicartpage.clickReviewCartButtonInMiniCart();
	test.info("Review Cart Button Clicked");
	int initialQuantity=mycartpage.quantityInputValue();
	test.info("Intial Quantity Value "+initialQuantity);
	genericappfunctions.navigateToPdpPage(pdppage,"1-l-le-parfait-jar/");
	test.info("Navigated To PDP Page");
	String productname1=genericappfunctions.addProductToCartFromPDP(pdppage);	
	test.info("Product Added from PDP Page");
	test.info("Product Name Added "+productname1);	
	minicartpage.clickReviewCartButtonInMiniCart();
	test.info("Review Cart Button Clicked");
	int afterInitialQuantity=mycartpage.quantityInputValue();
	test.info("After Intial Quantity Value "+afterInitialQuantity);
	Assert.assertTrue(afterInitialQuantity>initialQuantity);
	test.pass("Cart Quantity Validation done Successfully");

	}	
	
	/*
	* Creator - Vikas SP
	* Modifier - 
	* Story - SC-1426
	* TC#385 - Verify sub total should change when item count is increased 
	*/	
	@Test(enabled=false,priority = 5,groups = {"MyCart","Smoke","Regression"})
	public void SC1426_TC385_verifySubTotalInMyCart() throws InterruptedException {	
	MiniCartPage minicartpage=new MiniCartPage(getDriver());
	MyCartPage mycartpage=new MyCartPage(getDriver());	
	GenericAppFunctions genericappfunctions=new GenericAppFunctions();
	PDPPage pdppage=new PDPPage(getDriver());
	genericappfunctions.navigateToPdpPage(pdppage,"1-l-le-parfait-jar/");
	test.info("Navigated To PDP Page");
	String productname=genericappfunctions.addProductToCartFromPDP(pdppage);	
	test.info("Product Added from PDP Page");
	test.info("Product Name Added "+productname);	
	minicartpage.clickReviewCartButtonInMiniCart();
	test.info("Review Cart Button Clicked");	
	boolean status=mycartpage.validateSubTotal();	
	Assert.assertTrue(status);
	test.pass("Sub Total Validation done Successfully");

	}
	
	/*
	* Creator - Vikas SP
	* Modifier - 
	* Story - SC-1427--SC-1418
	* TC#304 TC#224 TC#227 TC#229 Verify Cart Summary Layout When Valid Coupon is Applied	
	* Verify once promotion is applied, the order total is updated accordingly 
	* Verify applied discount will be displayed on cart summary page
	*/

	@Test(enabled=false,priority = 6,groups = {"MyCart","Smoke","Regression"})
	public void SC1427_SC1418_TC304_TC224_TC227_TC229_verifyLayoutAfterValidCouponApplied() throws InterruptedException {	
	MiniCartPage minicartpage=new MiniCartPage(getDriver());
	MyCartPage mycartpage=new MyCartPage(getDriver());	
	GenericAppFunctions genericappfunctions=new GenericAppFunctions();
	PDPPage pdppage=new PDPPage(getDriver());
	genericappfunctions.navigateToPdpPage(pdppage, "canvas-laundry-cart/");
	test.info("Navigated To PDP Page");
	String productname1 = genericappfunctions.addProductToCartFromPDPwithoutSizeAndColor(pdppage);
	test.info("Product Added from PDP Page");
	test.info("Product Name Added " + productname1);	
	minicartpage.clickReviewCartButtonInMiniCart();
	test.info("Review Cart Button Clicked");
	int orderTotalBeforeApplyingCoupon=mycartpage.returnOrderTotalCartSummary();
	test.info("Order Total before applying Coupon " + orderTotalBeforeApplyingCoupon);
	String promoName=genericappfunctions.applyValidPromoCode(mycartpage,"ADD50");
	test.info("Promo Applied With Name As "+promoName);	
	Assert.assertTrue(mycartpage.isYourSavingLabelDisplayed());
	test.info("Your Saving Label is Displayed");
	Assert.assertTrue(mycartpage.returnAppliedPromoAmount().contains("$"));
	test.info("Promo Amount displayed after applying promo");
	int orderTotalAfterApplyingCoupon=mycartpage.returnOrderTotalCartSummary();
	test.info("Order Total After applying Coupon " + orderTotalAfterApplyingCoupon);
	Assert.assertTrue(orderTotalAfterApplyingCoupon<orderTotalBeforeApplyingCoupon);
	test.info("Valid Coupon Applied Successfully");	

	}	
	
	/*
	* Creator - Vikas SP
	* Modifier - 
	* Story - SC-1427 SC-1418
	* TC#305 TC#225 Verify Cart Summary Layout When InValid Coupon is Applied	
	*/

	@Test(enabled=false,priority = 7,groups = {"MyCart","Smoke","Regression"})
	public void SC1427_SC1418_TC305_TC225_verifyLayoutAfterInValidCouponApplied() throws InterruptedException {	
	MiniCartPage minicartpage=new MiniCartPage(getDriver());
	MyCartPage mycartpage=new MyCartPage(getDriver());	
	GenericAppFunctions genericappfunctions=new GenericAppFunctions();
	PDPPage pdppage=new PDPPage(getDriver());
	genericappfunctions.navigateToPdpPage(pdppage, "canvas-laundry-cart/");
	test.info("Navigated To PDP Page");
	String productname1 = genericappfunctions.addProductToCartFromPDPwithoutSizeAndColor(pdppage);
	test.info("Product Added from PDP Page");
	test.info("Product Name Added " + productname1);	
	minicartpage.clickReviewCartButtonInMiniCart();
	test.info("Review Cart Button Clicked");
	int orderTotalBeforeApplyingCoupon=mycartpage.returnOrderTotalCartSummary();
	test.info("Order Total before applying InValid Coupon " + orderTotalBeforeApplyingCoupon);
	mycartpage.applyInValidCoupon("ADD10");
	test.info("Applied InValid Promo");	
	Assert.assertTrue(mycartpage.returnInValidPromoErrorLabel().contains("Invalid promo code"));
	test.info("InValid Error PromoCode Label Validated");
	int orderTotalAfterApplyingCoupon=mycartpage.returnOrderTotalCartSummary();
	test.info("Order Total After applying InValid Coupon " + orderTotalAfterApplyingCoupon);
	Assert.assertTrue(orderTotalAfterApplyingCoupon==orderTotalBeforeApplyingCoupon);
	test.info("InValid Coupon Validated Successfully");	

	}	
	
	/*
	* Creator - Vikas SP
	* Modifier - 
	* Story - SC-1418
	* TC#223 Verify Promo code input field displayed when user clicks on use promo code button cart page	
	*/

	@Test(enabled=false,priority = 8,groups = {"MyCart","Smoke","Regression"})
	public void SC1418_TC223_verifyPromoInputTextBox() throws InterruptedException {	
	MiniCartPage minicartpage=new MiniCartPage(getDriver());
	MyCartPage mycartpage=new MyCartPage(getDriver());	
	GenericAppFunctions genericappfunctions=new GenericAppFunctions();
	PDPPage pdppage=new PDPPage(getDriver());
	genericappfunctions.navigateToPdpPage(pdppage, "canvas-laundry-cart/");
	test.info("Navigated To PDP Page");
	String productname1 = genericappfunctions.addProductToCartFromPDPwithoutSizeAndColor(pdppage);
	test.info("Product Added from PDP Page");
	test.info("Product Name Added " + productname1);	
	minicartpage.clickReviewCartButtonInMiniCart();
	test.info("Review Cart Button Clicked");
	mycartpage.clickPromoLinkInMyCartSummaryPage();
	test.info("Promo link Clicked");	
	Assert.assertTrue(mycartpage.isPromoInputBoxDisplayed());
	test.info("Promo Input TextBox Displyed");	

	}	
	
	/*
	* Creator - Vikas SP
	* Modifier - 
	* Story - SC-1418
	* TC#231 Verify Promo code input field remains open until user clicks close button	
	*/

	@Test(enabled=false,priority = 9,groups = {"MyCart","Smoke","Regression"})
	public void SC1418_TC231_verifyPromoInputAndApplyButtonAfterApplied() throws InterruptedException {	
	MiniCartPage minicartpage=new MiniCartPage(getDriver());
	MyCartPage mycartpage=new MyCartPage(getDriver());	
	GenericAppFunctions genericappfunctions=new GenericAppFunctions();
	PDPPage pdppage=new PDPPage(getDriver());
	genericappfunctions.navigateToPdpPage(pdppage, "canvas-laundry-cart/");
	test.info("Navigated To PDP Page");
	String productname1 = genericappfunctions.addProductToCartFromPDPwithoutSizeAndColor(pdppage);
	test.info("Product Added from PDP Page");
	test.info("Product Name Added " + productname1);	
	minicartpage.clickReviewCartButtonInMiniCart();
	test.info("Review Cart Button Clicked");
	String promoName=genericappfunctions.applyValidPromoCode(mycartpage,"ADD50");
	test.info("Promo Applied With Name As "+promoName);	
	Assert.assertFalse(mycartpage.isPromoInputBoxDisplayed());
	test.info("Promo Input Text Box Not present");
	Assert.assertFalse(mycartpage.isApplyPromoButtonDisplayed());
	test.info("Promo Apply Button Not Present");	

	}
	
	/*
	* Creator - Vikas SP
	* Modifier - 
	* Story - SC-1418
	* TC#232 Verify Apply button is disabled when user clicks apply button without entering promo code in promo code input field	
	*/

	@Test(enabled=false,priority = 10,groups = {"MyCart","Smoke","Regression"})
	public void SC1418_TC232_verifyPromoInputAndApplyDisable() throws InterruptedException {	
	MiniCartPage minicartpage=new MiniCartPage(getDriver());
	MyCartPage mycartpage=new MyCartPage(getDriver());	
	GenericAppFunctions genericappfunctions=new GenericAppFunctions();
	PDPPage pdppage=new PDPPage(getDriver());
	genericappfunctions.navigateToPdpPage(pdppage, "canvas-laundry-cart/");
	test.info("Navigated To PDP Page");
	String productname1 = genericappfunctions.addProductToCartFromPDPwithoutSizeAndColor(pdppage);
	test.info("Product Added from PDP Page");
	test.info("Product Name Added " + productname1);	
	minicartpage.clickReviewCartButtonInMiniCart();
	test.info("Review Cart Button Clicked");
	mycartpage.clickPromoLinkInMyCartSummaryPage();
	test.info("Promo link Clicked");	
	Assert.assertTrue(mycartpage.isPromoInputBoxDisplayed());
	test.info("Promo Input TextBox Displyed");	
	Assert.assertFalse(mycartpage.returnApplyButtonDisabledAttribute().equals("disabled"));
	test.info("Promo Apply Button is Disabled");

	}
	
	/*
	* Creator - Vikas SP
	* Modifier - 
	* Story - SC-1418
	* TC#233 Verify applied promotion is removed , tax and order total updated accordingly when user clicks remove link next to the promotion	
	* SC-1414
	* TC#236 Verify applied promotion is removed , tax and order total updated accordingly when user clicks remove link next to the promotion 
	*/

	@Test(enabled=false,priority = 11,groups = {"MyCart","Smoke","Regression"})
	public void SC1418_SC1414_TC233_TC236_verifyPromoRemoveFunctionality() throws InterruptedException {	
	MiniCartPage minicartpage=new MiniCartPage(getDriver());
	MyCartPage mycartpage=new MyCartPage(getDriver());	
	GenericAppFunctions genericappfunctions=new GenericAppFunctions();
	PDPPage pdppage=new PDPPage(getDriver());
	genericappfunctions.navigateToPdpPage(pdppage, "canvas-laundry-cart/");
	test.info("Navigated To PDP Page");
	String productname1 = genericappfunctions.addProductToCartFromPDPwithoutSizeAndColor(pdppage);
	test.info("Product Added from PDP Page");
	test.info("Product Name Added " + productname1);	
	minicartpage.clickReviewCartButtonInMiniCart();
	test.info("Review Cart Button Clicked");
	int orderTotalBeforeApplyingCoupon=mycartpage.returnOrderTotalCartSummary();
	test.info("Order Total before applying Coupon " + orderTotalBeforeApplyingCoupon);
	String promoName=genericappfunctions.applyValidPromoCode(mycartpage,"ADD50");
	test.info("Promo Applied With Name As "+promoName);	
	Assert.assertTrue(mycartpage.isYourSavingLabelDisplayed());
	test.info("Your Saving Label is Displayed");
	int orderTotalAfterApplyingCoupon=mycartpage.returnOrderTotalCartSummary();
	test.info("Order Total After applying Coupon " + orderTotalAfterApplyingCoupon);
	mycartpage.clickPromoRemoveLinkInMyCartSummaryPage();
	test.info("User clicked on Remove Promo Link");
	int orderTotalAfterRemoveCoupon=mycartpage.returnOrderTotalCartSummary();
	test.info("Order Total After Remove Coupon " + orderTotalAfterRemoveCoupon);
	Assert.assertTrue(orderTotalBeforeApplyingCoupon==orderTotalAfterRemoveCoupon);
	test.info("Order Total Updated Successfully After Promo Remove");	

	}
	
	/*
	* Creator - Vikas SP
	* Modifier - 
	* Story - SC-1414
	* TC#237 Verify NA is displayed next to Discounts label on Cart summary when no promo codes are applied	
	*/

	@Test(enabled=false,priority = 12,groups = {"MyCart","Smoke","Regression"})
	public void SC1414_TC237_verifyYourSvingsIfPromoNotApplied() throws InterruptedException {	
	MiniCartPage minicartpage=new MiniCartPage(getDriver());
	MyCartPage mycartpage=new MyCartPage(getDriver());	
	GenericAppFunctions genericappfunctions=new GenericAppFunctions();
	PDPPage pdppage=new PDPPage(getDriver());
	genericappfunctions.navigateToPdpPage(pdppage, "canvas-laundry-cart/");
	test.info("Navigated To PDP Page");
	String productname1 = genericappfunctions.addProductToCartFromPDPwithoutSizeAndColor(pdppage);
	test.info("Product Added from PDP Page");
	test.info("Product Name Added " + productname1);	
	minicartpage.clickReviewCartButtonInMiniCart();
	test.info("Review Cart Button Clicked");	
	Assert.assertTrue(mycartpage.returnYourSavingLabelAmount().equals("NA"));
	test.info("NA is Displayed If promo not applied");

	}
	
	/*
	* Creator - Vikas SP
	* Modifier - 
	* Story - SC-1438
	* TC#1135 Verify Cart Details - Calculator to Free Shipping | See Progress Bar for Free Shipping | Guest User Cost > $75	
	*/

	@Test(enabled=false,priority = 13,groups = {"MyCart","Smoke","Regression"})
	public void SC1438_TC1135_verifyFreeShippingLabelForGuestUser() throws InterruptedException {	
	MiniCartPage minicartpage=new MiniCartPage(getDriver());
	MyCartPage mycartpage=new MyCartPage(getDriver());	
	GenericAppFunctions genericappfunctions=new GenericAppFunctions();
	PDPPage pdppage=new PDPPage(getDriver());
	genericappfunctions.navigateToPdpPage(pdppage, "canvas-laundry-cart/");
	test.info("Navigated To PDP Page");
	String productname1 = genericappfunctions.addProductToCartFromPDPwithoutSizeAndColor(pdppage);
	test.info("Product Added from PDP Page");
	test.info("Product Name Added " + productname1);	
	minicartpage.clickReviewCartButtonInMiniCart();
	test.info("Review Cart Button Clicked");	
	Assert.assertTrue(mycartpage.returnFreeShippingAquiredLabel().trim().equals("Free Shipping Acquired"));
	test.info("Free Shipping Acquired Displayed");
	}
	
	
	/*
	* Creator - Vikas SP
	* Modifier - 
	* Story - SC-1438
	* TC#1136 Verify Logged in User Cart Details - Calculator to Free Shipping | See Progress Bar for Free Shipping | Cost > $75	
	*/

	@Test(enabled=false,priority = 14,dataProvider = "userDetails",dataProviderClass = DataSupplier.class,groups = {"MyCart","Smoke","Regression"})
	public void SC1438_TC1136_verifyFreeShippingLabelForLoggedInUser(String userName, String password, String fullName) throws InterruptedException {	
	MiniCartPage minicartpage = new MiniCartPage(getDriver());
	GenericAppFunctions genericappfunctions = new GenericAppFunctions();
	MyCartPage mycartpage=new MyCartPage(getDriver());
	PDPPage pdppage = new PDPPage(getDriver());	
	HomePage homePage = new HomePage(getDriver());
	genericappfunctions.signInUser(userName,password);
	Assert.assertTrue(homePage.isHiUserNameDisplayed(fullName));
	test.pass("Hi, User Name Text displayed");
	genericappfunctions.navigateToPdpPage(pdppage, "canvas-laundry-cart/");
	test.info("Navigated To PDP Page");
	String productname = genericappfunctions.addProductToCartFromPDPwithoutSizeAndColor(pdppage);
	test.info("Product Added from PDP Page");
	test.info("Product Name Added " + productname);	
	minicartpage.clickReviewCartButtonInMiniCart();
	test.info("Review Cart Button Clicked");	
	Assert.assertTrue(mycartpage.returnFreeShippingAquiredLabel().trim().equals("Free Shipping Acquired"));
	test.info("Free Shipping Acquired Displayed");
	}
	
	/*
	* Creator - Vikas SP
	* Modifier - 
	* Story - SC-1438
	* TC#1137 Verify Cart Details - Calculator to Free Shipping | See Progress Bar for Free Shipping | Guest User Cost < $75	
	*/

	@Test(enabled=false,priority = 15,groups = {"MyCart","Smoke","Regression"})
	public void SC1438_TC1137_verifyFreeShippingLabelLessThan75ForGuestUser() throws InterruptedException {	
	MiniCartPage minicartpage=new MiniCartPage(getDriver());
	MyCartPage mycartpage=new MyCartPage(getDriver());	
	GenericAppFunctions genericappfunctions=new GenericAppFunctions();
	PDPPage pdppage=new PDPPage(getDriver());
	genericappfunctions.navigateToPdpPage(pdppage, "1-l-le-parfait-jar/");
	test.info("Navigated To PDP Page");
	String productname1 = genericappfunctions.addProductToCartFromPDP(pdppage);
	test.info("Product Added from PDP Page");
	test.info("Product Name Added " + productname1);	
	minicartpage.clickReviewCartButtonInMiniCart();
	test.info("Review Cart Button Clicked");	
	Assert.assertTrue(mycartpage.validateFreeShippingAmountLeftLabel());
	test.info("Amount left for Free Shipping Label Validated For Guest User");
	}
	
	/*
	* Creator - Vikas SP
	* Modifier - 
	* Story - SC-1438
	* TC#1138 Verify Logged in User Cart Details - Calculator to Free Shipping | See Progress Bar for Free Shipping | Cost < $75	
	*/

	@Test(enabled=false,priority = 16,dataProvider = "userDetails",dataProviderClass = DataSupplier.class,groups = {"MyCart","Smoke","Regression"})
	public void SC1438_TC1138_verifyFreeShippingLabelLessThan75ForLoggedInUser(String userName, String password, String fullName) throws InterruptedException {	
	MiniCartPage minicartpage = new MiniCartPage(getDriver());
	GenericAppFunctions genericappfunctions = new GenericAppFunctions();
	MyCartPage mycartpage=new MyCartPage(getDriver());
	PDPPage pdppage = new PDPPage(getDriver());	
	HomePage homePage = new HomePage(getDriver());
	genericappfunctions.signInUser(userName,password);
	Assert.assertTrue(homePage.isHiUserNameDisplayed(fullName));
	test.pass("Hi, User Name Text displayed");
	genericappfunctions.navigateToPdpPage(pdppage, "1-l-le-parfait-jar/");
	test.info("Navigated To PDP Page");
	String productname1 = genericappfunctions.addProductToCartFromPDP(pdppage);
	test.info("Product Added from PDP Page");
	test.info("Product Name Added " + productname1);	
	minicartpage.clickReviewCartButtonInMiniCart();
	test.info("Review Cart Button Clicked");	
	Assert.assertTrue(mycartpage.validateFreeShippingAmountLeftLabel());
	test.info("Amount left for Free Shipping Label Validated For Logged In User");
	}
	
	/*
	* Creator - Vikas SP
	* Modifier - 
	* Story - SC-1438
	* TC#1139 Verify Progress Bar and Calculations for Free Shipping| When Delete OR Add Cart Items to Cart	
	*/

	@Test(enabled=false,priority = 17,groups = {"MyCart","Smoke","Regression"})
	public void SC1438_TC1139_verifyFreeShippingLabel() throws InterruptedException {	
	MiniCartPage minicartpage=new MiniCartPage(getDriver());
	MyCartPage mycartpage=new MyCartPage(getDriver());	
	GenericAppFunctions genericappfunctions=new GenericAppFunctions();
	PDPPage pdppage=new PDPPage(getDriver());
	genericappfunctions.navigateToPdpPage(pdppage, "canvas-laundry-cart/");
	test.info("Navigated To PDP Page");
	String productname = genericappfunctions.addProductToCartFromPDPwithoutSizeAndColor(pdppage);
	test.info("Product Added from PDP Page");
	test.info("Product Name Added " + productname);	
	genericappfunctions.navigateToPdpPage(pdppage, "1-l-le-parfait-jar/");
	test.info("Navigated To PDP Page");
	String productname1 = genericappfunctions.addProductToCartFromPDP(pdppage);
	test.info("Product Added from PDP Page");
	test.info("Product Name Added " + productname1);	
	minicartpage.clickReviewCartButtonInMiniCart();
	test.info("Review Cart Button Clicked");	
	Assert.assertTrue(mycartpage.returnFreeShippingAquiredLabel().trim().equals("Free Shipping Acquired"));
	test.info("Free Shipping Acquired Displayed");	
	mycartpage.removeFirstItemFromMyCartList();
	test.info("First Item Removed From My Cart");
	Assert.assertTrue(mycartpage.validateFreeShippingAmountLeftLabel());
	test.info("Amount left for Free Shipping Label Validated For Logged In User");	
	genericappfunctions.navigateToPdpPage(pdppage, "canvas-laundry-cart/");
	test.info("Navigated To PDP Page");
	String productname2 = genericappfunctions.addProductToCartFromPDPwithoutSizeAndColor(pdppage);
	test.info("Product Added from PDP Page");
	test.info("Product Name Added " + productname2);	
	minicartpage.clickReviewCartButtonInMiniCart();
	test.info("Review Cart Button Clicked");	
	Assert.assertTrue(mycartpage.returnFreeShippingAquiredLabel().trim().equals("Free Shipping Acquired"));
	}
	
	/*
	* Creator - Vikas SP
	* Modifier - 
	* Story - SC-1421
	* TC#1160 Verify the UI of the brand promise widgets in the cart page	
	*/

	@Test(enabled=true,priority = 18,groups = {"MyCart","Smoke","Regression"})
	public void SC1421_TC1160_verifyBrandPromiseWidgets() throws InterruptedException {	
	MiniCartPage minicartpage=new MiniCartPage(getDriver());
	MyCartPage mycartpage=new MyCartPage(getDriver());	
	GenericAppFunctions genericappfunctions=new GenericAppFunctions();
	PDPPage pdppage=new PDPPage(getDriver());
	genericappfunctions.navigateToPdpPage(pdppage, "canvas-laundry-cart/");
	test.info("Navigated To PDP Page");
	String productname1 = genericappfunctions.addProductToCartFromPDPwithoutSizeAndColor(pdppage);
	test.info("Product Added from PDP Page");
	test.info("Product Name Added " + productname1);	
	minicartpage.clickReviewCartButtonInMiniCart();
	test.info("Review Cart Button Clicked");	
	Assert.assertTrue(mycartpage.isNightComfortGuaranteeLabelDisplayed());
	test.info("Night Comfort Guarantee Brand Promise widget Displayed");
	Assert.assertTrue(mycartpage.isFreeDeliveryLabelDisplayed());
	test.info("Free Delivery Brand Promise widget Displayed");
	Assert.assertTrue(mycartpage.isPersonalSleepExpertsLabelDisplayed());
	test.info("Personal Sleep Experts Brand Promise widget Displayed");
	}
	
	/*
	* Creator - Vikas SP
	* Modifier - 
	* Story - SC-1421
	* TC#1161 Verify the functionality of the 100 Night Guarantee link in brand promise widget in the cart page	
	*/

	@Test(enabled=true,priority = 19,groups = {"MyCart","Smoke","Regression"})
	public void SC1421_TC1161_verifyNightComfortGuaranteeWidgetsNavigation() throws InterruptedException {	
	MiniCartPage minicartpage=new MiniCartPage(getDriver());
	MyCartPage mycartpage=new MyCartPage(getDriver());	
	GenericAppFunctions genericappfunctions=new GenericAppFunctions();
	PDPPage pdppage=new PDPPage(getDriver());
	genericappfunctions.navigateToPdpPage(pdppage, "canvas-laundry-cart/");
	test.info("Navigated To PDP Page");
	String productname1 = genericappfunctions.addProductToCartFromPDPwithoutSizeAndColor(pdppage);
	test.info("Product Added from PDP Page");
	test.info("Product Name Added " + productname1);	
	minicartpage.clickReviewCartButtonInMiniCart();
	test.info("Review Cart Button Clicked");	
	Assert.assertTrue(mycartpage.isNightComfortGuaranteeLabelDisplayed());
	test.info("Night Comfort Guarantee Brand Promise widget Displayed");
	mycartpage.clickNightComfortGuaranteeLabel();
	test.info("Clicked Night Comfort Guarantee Brand Promise widget");
	Assert.assertTrue(mycartpage.returnPageTitle().equals("100 Night Guarantee"));
	test.info("Night Comfort Guarantee Brand Promise widget Link Validated");
	}
	
	/*
	* Creator - Vikas SP
	* Modifier - 
	* Story - SC-1421
	* TC#1162 Verify the functionality of the "Free Delivery" link in brand promise widget in the cart page.	
	*/

	@Test(enabled=true,priority = 20,groups = {"MyCart","Smoke","Regression"})
	public void SC1421_TC1162_verifyFreeDeliveryLabelWidgetsNavigation() throws InterruptedException {	
	MiniCartPage minicartpage=new MiniCartPage(getDriver());
	MyCartPage mycartpage=new MyCartPage(getDriver());	
	GenericAppFunctions genericappfunctions=new GenericAppFunctions();
	PDPPage pdppage=new PDPPage(getDriver());
	genericappfunctions.navigateToPdpPage(pdppage, "canvas-laundry-cart/");
	test.info("Navigated To PDP Page");
	String productname1 = genericappfunctions.addProductToCartFromPDPwithoutSizeAndColor(pdppage);
	test.info("Product Added from PDP Page");
	test.info("Product Name Added " + productname1);	
	minicartpage.clickReviewCartButtonInMiniCart();
	test.info("Review Cart Button Clicked");	
	mycartpage.clickFreeDeliveryLabel();
	test.info("Clicked Free Delivery Label Brand Promise widget");
	Assert.assertTrue(mycartpage.returnPageTitle().equals("Shipping & Delivery"));
	test.info("FreeDeliveryLabel Brand Promise widget Link Validated");
	}
	
	/*
	* Creator - Vikas SP
	* Modifier - 
	* Story - SC-1421
	* TC#1325 Verify the functionality of the "Personal Sleep Experts" link in brand promise widget in the cart page.	
	*/

	@Test(enabled=true,priority = 21,groups = {"MyCart","Smoke","Regression"})
	public void SC1421_TC1325_verifyPersonalSleepExpertsWidgetsNavigation() throws InterruptedException {	
	MiniCartPage minicartpage=new MiniCartPage(getDriver());
	MyCartPage mycartpage=new MyCartPage(getDriver());	
	GenericAppFunctions genericappfunctions=new GenericAppFunctions();
	PDPPage pdppage=new PDPPage(getDriver());
	genericappfunctions.navigateToPdpPage(pdppage, "canvas-laundry-cart/");
	test.info("Navigated To PDP Page");
	String productname1 = genericappfunctions.addProductToCartFromPDPwithoutSizeAndColor(pdppage);
	test.info("Product Added from PDP Page");
	test.info("Product Name Added " + productname1);	
	minicartpage.clickReviewCartButtonInMiniCart();
	test.info("Review Cart Button Clicked");	
	mycartpage.clickPersonalSleepExpertsLabel();
	test.info("Clicked PersonalSleepExperts Brand Promise widget");
	Assert.assertTrue(mycartpage.returnPageTitle().equals("Live Chat"));
	test.info("Personal Sleep Experts Brand Promise widget Link Validated");
	}	
	
}
