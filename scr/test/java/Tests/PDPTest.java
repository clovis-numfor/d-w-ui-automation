package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PDPPage;
import reusableComponents.GenericAppFunctions;
import setup.DriverManager;

public class PDPTest extends DriverManager{
	
	/*
	 * =============================================================================
	 * Tests
	 * =============================================================================
	 */

	/*
	 * Creator - Vikas SP
	 * Modifier - 
	 * Story - SC-4350
	 * TC#652 -  Verify the Sale price on PDP for the product on sale -SCC	 
	 */

	@Test(enabled=true,priority = 0,groups = {"PDP","Smoke","Regression"})
	public void SC4350_TC652_validateSalePriceOnPDP() throws InterruptedException {					
		GenericAppFunctions genericappfunctions=new GenericAppFunctions();
		PDPPage pdppage=new PDPPage(getDriver());
		genericappfunctions.navigateToPdpPage(pdppage,"1-l-le-parfait-jar/");
		test.info("Navigated To PDP Page");		
		Assert.assertTrue(pdppage.isProductSalePriceDisplayed());
		test.info("Product Sale Price Displayed");

	}	

	/*
	 * Creator - Vikas SP
	 * Modifier - 
	 * Story - SC-4350
	 * TC#653 -  Verify the Sale price Color on PDP for the product on sale-SCC	 
	 */

	@Test(enabled=true,priority = 1,groups = {"PDP","Smoke","Regression"})
	public void SC4350_TC653_validateSalePriceColor() throws InterruptedException {					
		GenericAppFunctions genericappfunctions=new GenericAppFunctions();
		PDPPage pdppage=new PDPPage(getDriver());
		genericappfunctions.navigateToPdpPage(pdppage,"1-l-le-parfait-jar/");
		test.info("Navigated To PDP Page");		
		Assert.assertTrue(pdppage.returnSalePriceColor().contains("color-maroon"));
		test.info("Product Sale Price Displayed in Red Color");

	}	
	
	/*
	 * Creator - Vikas SP
	 * Modifier - 
	 * Story - SC-4350
	 * TC#654 -  Verify the retail price on the PDP for the product which or not on sale-SCC	 
	 */

	@Test(enabled=true,priority = 2,groups = {"PDP","Regression"})
	public void SC4350_TC654_validateRetailPrice() throws InterruptedException {					
		GenericAppFunctions genericappfunctions=new GenericAppFunctions();
		PDPPage pdppage=new PDPPage(getDriver());
		genericappfunctions.navigateToPdpPage(pdppage,"canvas-laundry-cart/");
		test.info("Navigated To PDP Page");		
		Assert.assertTrue(pdppage.isProductRetailPriceDisplayed());
		test.info("Product Retail Price Displayed ");

	}	
}
