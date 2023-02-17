package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateAccountPage {

RemoteWebDriver driver;
WebDriverWait wait;

public CreateAccountPage(RemoteWebDriver driver) {
this.driver = driver;
        PageFactory.initElements(driver, this);
   wait = new WebDriverWait(driver, 15);
}

@FindBy(xpath = "//button[contains(text(),'Create an Account')]")
WebElement createAnAccountButton;

@FindBy(xpath = "//h1[contains(text(),'Create an Account')]")
WebElement createAccountPageHeading;

@FindBy(xpath = "//input[@data-label='First Name']")
WebElement firstNameInput;

@FindBy(xpath = "//input[@data-label='Last Name']")
WebElement lastNameInput;

@FindBy(xpath = "//input[@data-label='Email']")
WebElement emailInput;

@FindBy(xpath = "//input[@data-label='Confirm Email']")
WebElement confirmEmailInput;

@FindBy(xpath = "//input[@data-label='Password']")
WebElement passwordInput;

@FindBy(xpath = "//input[@data-label='Confirm Password']")
WebElement confirmPasswordInput;

@FindBy(xpath = "(//button[contains(text(),'Create Account')])[1]")
WebElement createAccountButton;

@FindBy(xpath = "(//div[@class='check-bx']//label)[2]")
WebElement privacyPolicyCheckbox;

@FindBy(xpath = "//*[contains(text(),'Your account has been created')]")
WebElement accountCreatedSuccessMessage;

@FindBy(xpath = "(//a[contains(@class,'show-account loggedIn')])[1]")
WebElement userMenu;

//@FindBy(xpath = "(//div[@class='navPages-item'])[2]")
@FindBy(xpath = "(//span[@class='onclick-btn'])[1]")
WebElement humbergerMenu;


@FindBy(xpath = "(//*[contains(text(),'Invalid Email')])[1]")
WebElement invalidEmailError;

@FindBy(xpath = "(//*[contains(text(),'Invalid Email.')])[1]")
WebElement invalidConfirmEmailError;

@FindBy(xpath = "(//*[contains(text(),'Invalid Password.')])[1]")
WebElement invalidPasswordError;

@FindBy(xpath = "(//li[@class='mt-24 flex items-center logout'])[1]")
WebElement signOutLink;

@FindBy(xpath = "//*[contains(text(),'')]") // this error is not yet implemented. It is placeholder now
WebElement emailALreadyRegisteredError;

@FindBy(xpath = "//input[@data-label='Address Line 1']")
WebElement addressLine1Input;

@FindBy(xpath = "//input[@data-label='Suburb/City']")
WebElement cityInput;

@FindBy(xpath = "//select[@data-label='Country']")
WebElement countryDropDown;

@FindBy(xpath = "//select[@data-label='State/Province']")
WebElement stateDropDown;

@FindBy(xpath = "//input[@data-label='Zip/Postcode']")
WebElement zipCodeInput;

public void clickCreateAnAccountButton() {
createAnAccountButton.click();
}

public WebElement createAccountPageHeadingElement() {
return createAccountPageHeading;
}

public boolean isCreateAccountPageHeadingDisplayed() {
return wait.until(ExpectedConditions.visibilityOf(createAccountPageHeadingElement())).isDisplayed();
}

public boolean isFirstNameInputDisplayed() {
return firstNameInput.isDisplayed();
}

public boolean isLastNameInputDisplayed() {
return lastNameInput.isDisplayed();
}

public boolean isEmailInputDisplayed() {
return emailInput.isDisplayed();
}

public boolean isConfirmEmailInputDisplayed() {
return confirmEmailInput.isDisplayed();
}

public boolean isPasswordInputDisplayed() {
return passwordInput.isDisplayed();
}

public boolean isConfirmPasswordInputDisplayed() {
return confirmPasswordInput.isDisplayed();
}


public WebElement createAccountButtonElement()
{
return createAccountButton;
}
public boolean iscreateAccountButtonDisplayed() {
return createAccountButton.isDisplayed();
//return wait.until(ExpectedConditions.visibilityOf(createAccountButtonElement())).isDisplayed();
}

public boolean isPrivacyPolicyCheckboxDisplayed() {
return privacyPolicyCheckbox.isDisplayed();
}

public void enterFirstName(String firstName) {
firstNameInput.clear();
firstNameInput.sendKeys(firstName);
}

public void enterLastName(String lastName) {
lastNameInput.clear();
lastNameInput.sendKeys(lastName);
}

public void enterEmail(String email) {
emailInput.clear();
emailInput.sendKeys(email);
}

public void enterConfirmEmail(String email) {
confirmEmailInput.clear();
confirmEmailInput.sendKeys(email);
}

public void enterPassword(String password) {
passwordInput.clear();
passwordInput.sendKeys(password);
}

public void enterConfirmPassword(String password) {
confirmPasswordInput.clear();
confirmPasswordInput.sendKeys(password);
}

public void clickPrivacyPolicyCheckbox() throws InterruptedException {
((JavascriptExecutor) driver).executeScript("window.scrollBy(0,200)", "");
Thread.sleep(3000);
privacyPolicyCheckbox.click();
}

public void clickCreateAccountButton() throws InterruptedException {
Thread.sleep(2000);
WebElement element = driver.findElement(By.xpath("(//button[contains(text(),'Create Account')])[1]"));
((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);
JavascriptExecutor executor = (JavascriptExecutor)driver;
executor.executeScript("arguments[0].click();", element);
}

public void clickHumbergerMenu() throws InterruptedException
{
WebDriverWait wait= (new WebDriverWait(driver, 5));
wait.until(ExpectedConditions.elementToBeClickable (humbergerMenu));
//alternate solution
//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay element id")));
humbergerMenu.click();
}

public boolean isAccountCreatedSuccessMessageDisplayed() {
return accountCreatedSuccessMessage.isDisplayed();
}

public boolean isUserMenuDisplayed() {
return userMenu.isDisplayed();
}

public boolean isInvalidEmailErrorDisplayed() {
return invalidEmailError.isDisplayed();
}

public boolean isInvalidConfirmEmailErrorDisplayed() {
return invalidConfirmEmailError.isDisplayed();
}

public boolean isInvalidPasswordErrorDisplayed() {
return invalidPasswordError.isDisplayed();
}

public void clickSignOutLink() throws InterruptedException {

Thread.sleep(3000);
WebElement element = driver.findElement(By.xpath("//li[@class='mt-24 flex items-center logout']/a"));
((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);
Thread.sleep(2000);
JavascriptExecutor executor = (JavascriptExecutor)driver;
executor.executeScript("arguments[0].click();", element);
}

public boolean isEmailAlreadyRegisteredErrorDisplayed() {
return emailALreadyRegisteredError.isDisplayed();
}

public void enterAddressLine1(String addressLine) {
addressLine1Input.clear();
addressLine1Input.sendKeys(addressLine);
}

public void enterCity(String cityName) {
cityInput.clear();
cityInput.sendKeys(cityName);
}

public void selectCountryFromCountryDropDown(String countryName) {
Select countryDropdown=new Select(countryDropDown);
countryDropdown.selectByVisibleText(countryName);
}

public void selectStateFromStateDropDown(String stateName) {
Select stateDropdown=new Select(stateDropDown);
stateDropdown.selectByVisibleText(stateName);
}

public void enterZipCode(String zipCode) {
zipCodeInput.clear();
zipCodeInput.sendKeys(zipCode);
}

}
