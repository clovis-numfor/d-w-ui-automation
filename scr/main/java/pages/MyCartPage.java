package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import setup.DriverManager;

public class MyCartPage extends DriverManager {

RemoteWebDriver driver;
WebDriverWait wait;

public MyCartPage(RemoteWebDriver driver) {
this.driver = driver;
PageFactory.initElements(driver, this);
wait = new WebDriverWait(driver, Duration.ofSeconds(10));
}

@FindBy(how = How.XPATH, using = "//div[@class='cart-list']//div[@onclick]")
WebElement myCartProductImage;

@FindBy(how = How.XPATH, using = "//a[contains(@class,'cart-item-name')]")
WebElement myCartProductName;

@FindBy(how = How.XPATH, using = "//div[contains(@class,'product-varient-info')]/p")
WebElement myCartSkuName;

@FindBy(how = How.XPATH, using = "(//dl[@class='definitionList']//dd)[2]")
WebElement myCartProductSize;

@FindBy(how = How.XPATH, using = "(//dl[@class='definitionList']//dd)[1]")
WebElement myCartProductColor;

@FindBy(how = How.XPATH, using = "//button[@data-action='inc']")
WebElement quantityIncreaseButton;

@FindBy(how = How.XPATH, using = "//button[@data-action='dec']")
WebElement quantityDecreseButton;

@FindBy(how = How.XPATH, using = "//input[@data-action='manualQtyChange']")
WebElement quantityInputTextBox;

@FindBy(how = How.XPATH, using = "//div[@class='loadingOverlay' and @style='display: block;']")
List<WebElement> loadingIcon;

@FindBy(how = How.XPATH, using = "//div[@id='alert-modal']//div[@class='modal-content']")
WebElement alertWarningText;

@FindBy(how = How.XPATH, using = "//button[@class='confirm button']")
WebElement alertOkButton;

@FindBy(how = How.XPATH, using = "(//h2[@class='cart-item-name m-0'])")
WebElement CartItem1;

@FindBy(how = How.XPATH, using = "(//h2[@class='cart-item-name m-0'])[2]")
WebElement CartItem2;

@FindBy(how = How.XPATH, using = "//div[@class='cart-total-value']/span")
WebElement subTotalValue;

@FindBy(how = How.XPATH, using = "//span[text()='Use promo code']/..")
WebElement promoLink;

@FindBy(how = How.XPATH, using = "//input[@id='couponcode']")
WebElement promoInputTextBox;

@FindBy(how = How.XPATH, using = "//input[@id='couponApplyBtn']")
WebElement applyCouponSubmitButton;

@FindBy(how = How.XPATH, using = "//div[@class='cart-total-value cart-total-grandTotal']/span")
WebElement orderTotalValue;

@FindBy(how = How.XPATH, using = "//div[contains(@class,'applied-coupon')]/div")
WebElement firstPromoName;

@FindBy(how = How.XPATH, using = "//strong[text()='Your Savings:']")
WebElement yourSavingLabel;

@FindBy(how = How.XPATH, using = "//p[@class='coupon-err']/span")
WebElement invalidPromoErrorLabel;

@FindBy(how = How.XPATH, using = "//div[contains(@class,'applied-coupon')]/div/a")
WebElement firstPromoRemoveLink;

@FindBy(how = How.XPATH, using = "//div[contains(@class,'applied-coupon')]/div/following-sibling::div/span")
WebElement appliedPromoAmount;

@FindBy(how = How.XPATH, using = "//strong[text()='Your Savings:']/..//following-sibling::div")
WebElement yourSavingLabelAmount;

@FindBy(how = How.XPATH, using = "//div[contains(@class,'free-shipping')]//p[contains(@class,'font-bold')]")
WebElement freeShippingAquiredLabel;

@FindBy(how = How.XPATH, using = "//div[contains(@class,'free-shipping')]//p[contains(@class,'non-eligible')]")
WebElement awayAmountForFreeShippingLabel;

@FindBy(how = How.XPATH, using = "(//div[@class='cart-list']//a[text()='Remove'])[1]")
WebElement firstRemoveLinkInMyCart;

@FindBy(how = How.XPATH, using = "//div[@id='alert-modal']//button[text()='OK']")
WebElement removeItemOKButtonInMyCart;

@FindBy(how = How.XPATH, using = "//div[@class='brand-features']//a[text()='100 Night Comfort Guarantee']")
WebElement nightComfortGuaranteeLabel;

@FindBy(how = How.XPATH, using = "//div[@class='brand-features']//a[text()='Free Delivery']")
WebElement freeDeliveryLabel;

@FindBy(how = How.XPATH, using = "//div[@class='brand-features']//a[text()='Personal Sleep Experts']")
WebElement personalSleepExpertsLabel;

public boolean isProductImageDisplayed() {
return myCartProductImage.isDisplayed();
}

public boolean isProductNameDisplayed() {
return myCartProductName.isDisplayed();
}

public boolean isSkuDisplayed() {
return myCartSkuName.getText().length() > 0;
}

public boolean isColorDisplayed() {
return myCartProductSize.getText().length() > 0;
}

public boolean isSizeDisplayed() {
return myCartProductColor.getText().length() > 0;
}

public void waitForLoadingIconToDisappear() throws InterruptedException {
int count = 0;
while (loadingIcon.size() != 0 && count <= 10) {
Thread.sleep(1000);
count++;
}
}

public boolean validateUserAbleToUpdate() throws InterruptedException {
boolean flag1 = false, flag2 = false;
String currentQuantityValue = quantityInputTextBox.getAttribute("value");
quantityIncreaseButton.click();
waitForLoadingIconToDisappear();
String afterIncreaseQuantityValue = quantityInputTextBox.getAttribute("value");
if (Integer.valueOf(afterIncreaseQuantityValue) > Integer.valueOf(currentQuantityValue)) {
flag1 = true;
}
quantityDecreseButton.click();
waitForLoadingIconToDisappear();
String afterDeccreaseQuantityValue = quantityInputTextBox.getAttribute("value");
if (Integer.valueOf(afterDeccreaseQuantityValue) == Integer.valueOf(currentQuantityValue)) {
flag2 = true;
}
return flag1 && flag2;
}

public boolean validateAlertTextForZeroQuantityValue() throws InterruptedException {
boolean flag = false;
quantityInputTextBox.sendKeys(Keys.BACK_SPACE);
quantityInputTextBox.sendKeys("0", Keys.ENTER);
wait.until(ExpectedConditions.visibilityOf(alertWarningText));
String alerttext = alertWarningText.getText();
alertOkButton.click();
waitForLoadingIconToDisappear();
if (alerttext.contains("is not a valid entry")) {
flag = true;
}
return flag;
}

public boolean validateQuantityInputForThreeDigitValue() throws InterruptedException {
boolean flag = false;
quantityInputTextBox.sendKeys(Keys.BACK_SPACE);
quantityInputTextBox.sendKeys("100", Keys.ENTER);
waitForLoadingIconToDisappear();
if (quantityInputTextBox.getAttribute("value").equals("99")) {
flag = true;
}
return flag;
}

public void clickItemThumbnailInMyCart() {
myCartProductImage.click();
}

public void clickItemNameInMyCart() {
myCartProductName.click();
}

public String ProductNameFromCart1() {
return CartItem1.getText();
}

public String ProductNameFromCart2() {
return CartItem2.getText();
}

public int quantityInputValue() {
return Integer.valueOf(quantityInputTextBox.getAttribute("value"));
}

public void increaseItemCount() {
quantityIncreaseButton.click();
}

public void decreaseItemCount() {
quantityDecreseButton.click();
}

public boolean validateSubTotal() throws InterruptedException {
boolean flag = false;
int subTotalBeforeIncrease = Integer
.valueOf(subTotalValue.getText().substring(1, subTotalValue.getText().indexOf('.')));
test.info("Sub Total Value Before Increase " + subTotalBeforeIncrease);
increaseItemCount();
waitForLoadingIconToDisappear();
int subTotalAfterIncrease = Integer
.valueOf(subTotalValue.getText().substring(1, subTotalValue.getText().indexOf('.')));
test.info("Sub Total Value After Increase " + subTotalAfterIncrease);
if (subTotalAfterIncrease > subTotalBeforeIncrease) {
flag = true;
test.info("Sub Total Validation is Successfully Completed");
}
return flag;
}

public int returnOrderTotalCartSummary() {
wait.until(ExpectedConditions.visibilityOf(orderTotalValue)).isDisplayed();
return Integer.valueOf(orderTotalValue.getText().substring(1, orderTotalValue.getText().indexOf('.')));
}

public String applyValidCoupon(String coupon) throws InterruptedException {
wait.until(ExpectedConditions.visibilityOf(promoLink)).click();
promoInputTextBox.sendKeys(coupon);
applyCouponSubmitButton.click();
waitForLoadingIconToDisappear();
return firstPromoName.getText().substring(0, firstPromoName.getText().indexOf(':'));
}

public boolean isYourSavingLabelDisplayed() {
return yourSavingLabel.isDisplayed();
}

public void applyInValidCoupon(String coupon) throws InterruptedException {
wait.until(ExpectedConditions.visibilityOf(promoLink)).click();
promoInputTextBox.sendKeys(coupon);
applyCouponSubmitButton.click();
}

public String returnInValidPromoErrorLabel() throws InterruptedException {
return wait.until(ExpectedConditions.visibilityOf(invalidPromoErrorLabel)).getText();
}

public void clickPromoLinkInMyCartSummaryPage() throws InterruptedException {
wait.until(ExpectedConditions.visibilityOf(promoLink)).click();
}

public boolean isPromoInputBoxDisplayed() throws InterruptedException {
return promoInputTextBox.isDisplayed();
}

public boolean isApplyPromoButtonDisplayed() throws InterruptedException {
return applyCouponSubmitButton.isDisplayed();
}

public String returnApplyButtonDisabledAttribute() throws InterruptedException {
return applyCouponSubmitButton.getAttribute("disabled");
}

public void clickPromoRemoveLinkInMyCartSummaryPage() throws InterruptedException {
wait.until(ExpectedConditions.visibilityOf(firstPromoRemoveLink)).click();
waitForLoadingIconToDisappear();
}

public String returnAppliedPromoAmount() throws InterruptedException {
return appliedPromoAmount.getText();
}

public String returnYourSavingLabelAmount() throws InterruptedException {
return yourSavingLabelAmount.getText();
}

public String returnFreeShippingAquiredLabel() throws InterruptedException {
return freeShippingAquiredLabel.getText();
}

public boolean validateFreeShippingAmountLeftLabel() throws InterruptedException {
boolean flag = false;
int subTotal = Integer.valueOf(subTotalValue.getText().substring(1, subTotalValue.getText().indexOf('.')));
test.info("Sub Total Value is " + subTotal);
int remainingAmountToReachFreeShipping = 75 - subTotal;
test.info("Remaining Amount To Reach Free Shipping is " + subTotal);
String label = awayAmountForFreeShippingLabel.getText().trim();
if (label.contains("You’re") && label.contains("away from free shipping")
&& label.contains(Integer.toString(remainingAmountToReachFreeShipping))) {
flag = true;
test.info("Validated Free Shipping Amount Left Label");
}
return flag;
}

public void removeFirstItemFromMyCartList() throws InterruptedException {
wait.until(ExpectedConditions.visibilityOf(firstRemoveLinkInMyCart)).click();
removeItemOKButtonInMyCart.click();
waitForLoadingIconToDisappear();
}

public boolean isNightComfortGuaranteeLabelDisplayed() throws InterruptedException {
((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nightComfortGuaranteeLabel);
Thread.sleep(3000);
return nightComfortGuaranteeLabel.isDisplayed();
}

public boolean isFreeDeliveryLabelDisplayed() throws InterruptedException {
return freeDeliveryLabel.isDisplayed();
}

public boolean isPersonalSleepExpertsLabelDisplayed() throws InterruptedException {
return personalSleepExpertsLabel.isDisplayed();
}

public String returnPageTitle() throws InterruptedException {
return getDriver().getTitle();
}

public void clickNightComfortGuaranteeLabel() throws InterruptedException {
nightComfortGuaranteeLabel.click();
}

public void clickFreeDeliveryLabel() throws InterruptedException {
((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", freeDeliveryLabel);
Thread.sleep(3000);
freeDeliveryLabel.click();
}

public void clickPersonalSleepExpertsLabel() throws InterruptedException {
((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", personalSleepExpertsLabel);
Thread.sleep(3000);
personalSleepExpertsLabel.click();
}

}
