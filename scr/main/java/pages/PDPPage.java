package pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import setup.DriverManager;
import util.PropertiesOperations;

public class PDPPage extends DriverManager {

RemoteWebDriver driver;
WebDriverWait wait;

public PDPPage(RemoteWebDriver driver) {
this.driver = driver;
PageFactory.initElements(driver, this);
wait = new WebDriverWait(driver, Duration.ofSeconds(10));
}

@FindBy(how = How.XPATH, using = "//div[contains(@class,'productView pdp_above_fold')]")
WebElement productDetailPage;

@FindBy(how = How.XPATH, using = "//span[@title='Silver']")
WebElement colorSelectionPdpSilver;

@FindBy(how = How.XPATH, using = "//span[text()='Small']/../..")
WebElement sizeSelectionPdpSmall;

@FindBy(how = How.XPATH, using = "//input[@value='Add to Cart']")
WebElement addToCartButtonPdp;

@FindBy(how = How.XPATH, using = "//section[@class='pdp_name']/h1")
WebElement productName;

@FindBy(how = How.XPATH, using = "//div[@class='pdp_mod']//span[@id='price_withoutTax']")
WebElement productSalePrice;

@FindBy(how = How.XPATH, using = "//div[@class='pdp_mod']//span[@id='price_withoutTax']/..")
WebElement productSalePriceDiv;

@FindBy(how = How.XPATH, using = "//div[@class='pdp_mod']//div[contains(@class,'non-sale-price')]")
WebElement productRetailPrice;


public boolean isPDPDisplayed() {
return productDetailPage.isDisplayed();
}

public void navigateToPdpPage(String product) {
driver.navigate().to(PropertiesOperations.getPropertyValueByKey("url") + product);
}

public String addProductToCartFromPDP() throws InterruptedException {
((JavascriptExecutor) driver).executeScript("window.scrollBy(0,700)", "");
Thread.sleep(2000);
wait.until(ExpectedConditions.elementToBeClickable(colorSelectionPdpSilver)).click();
sizeSelectionPdpSmall.click();
Thread.sleep(3000);
addToCartButtonPdp.click();
driver.navigate().refresh();
return productName.getText();
}

public String addProductToCartFromPDPwithoutSizeAndColor() throws InterruptedException {
((JavascriptExecutor) driver).executeScript("window.scrollBy(0,700)", "");
Thread.sleep(2000);
addToCartButtonPdp.click();
return productName.getText();
}

public boolean isProductSalePriceDisplayed() throws InterruptedException {
return productSalePrice.isDisplayed();
}

public String returnSalePriceColor() throws InterruptedException {
return productSalePriceDiv.getAttribute("class");
}

public boolean isProductRetailPriceDisplayed() throws InterruptedException {
return productRetailPrice.isDisplayed();
}

}
