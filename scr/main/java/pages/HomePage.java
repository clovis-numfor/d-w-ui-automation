package pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage{
RemoteWebDriver driver;
WebDriverWait wait;

@SuppressWarnings("deprecation")
public HomePage(RemoteWebDriver driver) {

this.driver = driver;

PageFactory.initElements(driver, this);
       wait = new WebDriverWait(driver, 30);
}

@FindBy(id = "guestTkn")
WebElement previewCodeInput;

@FindBy(xpath = "//div[@class='rc-inline-block']")
WebElement captchaCheckbox;

@FindBy(xpath = "//input[@value='Submit']")
WebElement submitButton;

@FindBy(xpath = "//span[@class='header-logo-text']")
WebElement sleepCountryLogo;

@FindBy(xpath = "//div[@id='myAccountBtn']")
WebElement myAccountBtn;

@FindBy(xpath = "//button[@id='CC-userLoginSubmit']")
WebElement signinButton;

@FindBy(xpath = "//a[@class='show-account loggedOut']/span[contains(text(),'Sign in')]")
WebElement signInLink;

@FindBy(xpath = "(//a[@aria-label='Sign out'])[1]")
WebElement signOutLink;

@FindBy(xpath = "//div[@class='subscribtion-form']/button")
WebElement subscribeButton;

@FindBy(xpath = "//input[@id='subscribtionMail']")
WebElement subscribeInput;

@FindBy(xpath = "//*[contains(text(),'Thank you for subscribing!')]")
WebElement newsletterSubscriptionSuccessMsg;

@FindBy(xpath = "//*[contains(text(),'Email already signed up!')]")
WebElement emailAlreadySignedUpMsg;

@FindBy(xpath = "(//div[@class='navPages-item'])[2]")
WebElement hamBergerMenu;

@FindBy(xpath = "//div[@id='mySidenav']//a[contains(text(),'Sign in')]")
WebElement signInButttonInHamBergerMenu;

@FindBy(xpath = "//div[@id='mySidenav']//a[contains(text(),'Sign out')]")
WebElement signOutButttonInHamBergerMenu;

@FindBy(xpath = "//div[@id='mySidenav']//a[contains(text(),'Create Account')]")
WebElement createAccountLinkInHamBergerMenu;

@FindBy(xpath = "//a[contains(@title,'Hi,')]")
WebElement hiText;

@FindBy(xpath = "(//li/a[contains(text(),'My Account')])[1]")
WebElement myAccountLinkFromHamBergerMenu;

@FindBy(xpath = "(//p[contains(text(),'Copyright © 2023 QA.')])[1]")
WebElement copyRightsText_1;

@FindBy(xpath = "(//p[contains(text(),'All rights reserved')])[1]")
WebElement copyRightsText_2;

@FindBy(xpath = "//li/a[contains(text(),'Privacy Policy')]")
WebElement privacyPolicyLink;

@FindBy(xpath = "//li/a[contains(text(),'Offers Detail Page')]")
WebElement offerDetailsLink;

@FindBy(xpath = "//li/a[contains(text(),'Terms & Conditions')]")
WebElement termsAndConditionsLink;


public WebElement signOutLinkElement() {
return signOutLink;
}

public boolean isSignOutLinkDisplayed() {
return wait.until(ExpectedConditions.visibilityOf(signOutLinkElement())).isDisplayed();
}

public String getTitle() throws InterruptedException {
Thread.sleep(5000);
return driver.getTitle();
}

public boolean getLogo() {
return sleepCountryLogo.isDisplayed();
}

public void clickMyAccountLink() {
myAccountBtn.click();
}

public void clickSignInLink() {
signInLink.click();
}

public void switchTabs() {
ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
driver.switchTo().window(tabs.get(1));
}

public void typePreviewCode(String previewCode) {
previewCodeInput.sendKeys(previewCode);
}

public void selectCaptchaCheckbox() {
captchaCheckbox.click();
}

public void clickSubmitButton() {
submitButton.click();
}

public void SignOut() {
signOutLink.click();
}

public void clickFooterElement(String linkName) {

WebElement footerLink= driver.findElement(By.xpath("//ul[@class='content footer-info-list']/li/a[contains(text(),'"+linkName+"')]"));
JavascriptExecutor executor = (JavascriptExecutor)driver;
executor.executeScript("arguments[0].click();", footerLink);
}

public boolean isPageHeadingDisplayed(String pageHeading) {
return driver.findElement(By.xpath("//h1[contains(text(),'"+pageHeading+"')]")).isDisplayed();
}

public boolean isSubscribeInputDisplayed() {
return subscribeInput.isDisplayed();
}

public boolean isSubscribeButtonDisplayed() {
return subscribeButton.isDisplayed();
}

public void enterEmailInSubScribeInput(String emailAddress) {
subscribeInput.sendKeys(emailAddress);
}

public void clickSubscribeButton() {
subscribeButton.click();
}

public boolean isnewsletterSubscriptionSuccessMsgDisplayed() {
return newsletterSubscriptionSuccessMsg.isDisplayed();
}

public boolean isEmailAlreadySignedUpMsgDisplayed() {
return emailAlreadySignedUpMsg.isDisplayed();
}

public void clickHamBergerMenu() {
hamBergerMenu.click();
}

public boolean isSignInButttonDisplayedInHamBergerMenu() throws InterruptedException {
Thread.sleep(3000);
JavascriptExecutor jse2 = (JavascriptExecutor)driver;
jse2.executeScript("arguments[0].scrollIntoView()", signInButttonInHamBergerMenu);
Thread.sleep(3000);
return signInButttonInHamBergerMenu.isDisplayed();
}

public void clickSignOutButttonInHamBergerMenu() throws InterruptedException {
Thread.sleep(3000);
JavascriptExecutor jse2 = (JavascriptExecutor)driver;
jse2.executeScript("arguments[0].scrollIntoView()", signOutButttonInHamBergerMenu);
Thread.sleep(3000);
signOutButttonInHamBergerMenu.click();
}

public void clickCreateAccountLinkInHamBergerMenu() {
JavascriptExecutor jse2 = (JavascriptExecutor)driver;
jse2.executeScript("arguments[0].scrollIntoView()", createAccountLinkInHamBergerMenu);
createAccountLinkInHamBergerMenu.click();

}

public boolean isCreateAccountLinkInHamBergerMenudisplayed() {
JavascriptExecutor jse2 = (JavascriptExecutor)driver;
jse2.executeScript("arguments[0].scrollIntoView()", createAccountLinkInHamBergerMenu);
return createAccountLinkInHamBergerMenu.isDisplayed();
}

public boolean isHiUserNameDisplayed(String userName) {
hiText.isDisplayed();
return driver.findElement(By.xpath("//a[contains(@title,'"+userName+"')]")).isDisplayed();
}

public boolean isMyAccountLinkFromHamBergerMenuDisplayed() throws InterruptedException{
Thread.sleep(2000);
return myAccountLinkFromHamBergerMenu.isDisplayed();
}

public void clickSideNavigationLink(String linkName) {
driver.findElement(By.xpath("//div[@id='mySidenav']//ul[contains(@class,'account-links')]//a[contains(text(),'"+linkName+"')]")).click();
}

public boolean isCopyRightsTextDisplayed() {
copyRightsText_1.isDisplayed();
return copyRightsText_2.isDisplayed();
}

public void clickPrivacyPolicyLink() {
JavascriptExecutor executor = (JavascriptExecutor)driver;
executor.executeScript("arguments[0].click();", privacyPolicyLink);
}

public void clickOfferDetailsLink() {
JavascriptExecutor executor = (JavascriptExecutor)driver;
executor.executeScript("arguments[0].click();", offerDetailsLink);
}

public void clickTermsAndConditionsLink() {
JavascriptExecutor executor = (JavascriptExecutor)driver;
executor.executeScript("arguments[0].click();", termsAndConditionsLink);
}


}
