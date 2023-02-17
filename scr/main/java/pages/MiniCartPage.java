package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MiniCartPage {

RemoteWebDriver driver;
WebDriverWait wait;

public MiniCartPage(RemoteWebDriver driver) {
this.driver = driver;
PageFactory.initElements(driver, this);
wait = new WebDriverWait(driver, Duration.ofSeconds(5));
}

@FindBy(xpath = "//a[@aria-label='Garden']")
WebElement categoryValueGarden;

@FindBy(xpath = "//ul[@class='productGrid']//li[1]//img")
WebElement firstProductImage;

@FindBy(xpath = "//a[text()='Add to Cart']")
WebElement addToCartButton;

@FindBy(how = How.XPATH, using = "//div[@class='previewCartAction-viewCart']/a")
List<WebElement> reviewCartButton;

@FindBy(how = How.XPATH, using = "//span[@class='navUser-item-cartLabel']")
WebElement miniCartButton;

@FindBy(how = How.XPATH, using = "//div[@class='previewCartItem-image']")
WebElement previewCartImage;

@FindBy(how = How.XPATH, using = "//div[@class='previewCart']")
WebElement previewCartContent;

@FindBy(how = How.XPATH, using = "//div[contains(@class,'number-icons')]")
WebElement cartQuantity;

@FindBy(how = How.XPATH, using = "//div[@class='price']")
WebElement itemPrice;

@FindBy(how = How.XPATH, using = "//div[contains(@class,'previewCartItem-content')]/h6/a")
WebElement cartItemNameLink;

@FindBy(how = How.XPATH, using = "//div[@id='previewCart']//h3[text()='Recently Viewed Items']")
WebElement recentlyViewedItemsLabel;

@FindBy(how = How.XPATH, using = "//div[@id='previewCart']//h3[text()='Saved for later']")
WebElement savedForLaterLabel;

@FindBy(how = How.XPATH, using = "//div[@id='previewCart']//p[text()='Your cart is empty']")
WebElement cartEmptyLabel;

@FindBy(how = How.XPATH, using = "//a[contains(text(),'Get inspired')]")
WebElement getInspiredButton;

@FindBy(how = How.XPATH, using = "//i[contains(@class,'mini-cart-remove')]")
WebElement removeButtonMiniCart;

@FindBy(how = How.XPATH, using = "//div[@class='price']/p")
WebElement miniCartSubTotalValue;

@FindBy(how = How.XPATH, using ="//div[@id='close-mini-cart']")
WebElement miniCarCloseButton;


public void addProductToCart() {
categoryValueGarden.click();
new Actions(driver).moveToElement(firstProductImage).build().perform();
addToCartButton.click();
}

public boolean isReviewCartButtonDisplayed() {
wait.until(ExpectedConditions.visibilityOf(previewCartContent));
return reviewCartButton.size() > 0;
}

public void clickMiniCartButton() {
miniCartButton.click();
}

public boolean isPreviewCartImageDisplayed() {
return previewCartImage.isDisplayed();
}

public boolean isPreviewCartContentDisplayed() {
return wait.until(ExpectedConditions.visibilityOf(previewCartContent)).isDisplayed();
}

public boolean isCartQuantityDisplayed() {
return cartQuantity.isDisplayed();
}

public boolean isItemPriceDisplayed() {
return itemPrice.isDisplayed();
}

public void clickItemNameLinkInMiniCart() {
cartItemNameLink.click();
}

public void clickReviewCartButtonInMiniCart() {
reviewCartButton.get(0).click();
}

public boolean isRecentlyViewedItemsLabelDisplayed() {
return wait.until(ExpectedConditions.visibilityOf(recentlyViewedItemsLabel)).isDisplayed();
}

public boolean isSavedForLaterLabelDisplayed() {
((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", savedForLaterLabel);
return savedForLaterLabel.isDisplayed();
}

public boolean isEmptyCartLabelDisplayed() {
return wait.until(ExpectedConditions.visibilityOf(cartEmptyLabel)).isDisplayed();
}

public boolean isGetInspiredDisplayed() {
return wait.until(ExpectedConditions.visibilityOf(getInspiredButton)).isDisplayed();
}

public boolean isRemoveButtonInMiniCartDisplayed() {
return wait.until(ExpectedConditions.visibilityOf(removeButtonMiniCart)).isDisplayed();
}

public int returnMiniCartSubTotal() throws InterruptedException {
wait.until(ExpectedConditions.visibilityOf(miniCartSubTotalValue)).isDisplayed();
int subTotal = Integer
.valueOf(miniCartSubTotalValue.getText().substring(1, miniCartSubTotalValue.getText().indexOf('.')));
return subTotal;
}

public void clickFirstRemoveButtonMiniCart() throws InterruptedException {
Thread.sleep(3000);
wait.until(ExpectedConditions.visibilityOf(removeButtonMiniCart)).click();
Thread.sleep(3000);
}

public void clickMiniCarCloseButton() throws InterruptedException {
Thread.sleep(3000);
miniCarCloseButton.click();
}


}
