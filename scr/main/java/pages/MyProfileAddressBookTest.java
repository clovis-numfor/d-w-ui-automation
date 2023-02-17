package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import reusableComponents.GenericFunctions;
import setup.DriverManager;

public class MyProfileAddressBook extends DriverManager {

RemoteWebDriver driver;
WebDriverWait wait;

public MyProfileAddressBook(RemoteWebDriver driver) {
this.driver = driver;
PageFactory.initElements(driver, this);
wait = new WebDriverWait(driver, Duration.ofSeconds(15));
}

@FindBy(xpath = "//li[contains(@class,'breadcrumb')]//span[contains(text(),'My Account')]")
WebElement topAccountLink;

@FindBy(how = How.XPATH, using = "//li[@class='navBar-item ']//a[text()='Addresses']")
WebElement addressesSubTab;

@FindBy(xpath = "//span[@class='address-addNew']/span")
WebElement newAddressAddIcon;
//
@FindBy(how = How.ID, using = "FormField_4_input")
WebElement firstNameInputTextBox;

@FindBy(how = How.ID, using = "FormField_5_input")
WebElement lastNameInputTextBox;

@FindBy(how = How.ID, using = "FormField_8_input")
WebElement addressLine1InputTextBox;

@FindBy(how = How.ID, using = "FormField_10_input")
WebElement cityInputTextBox;

@FindBy(how = How.ID, using = "FormField_11_select")
WebElement countrySelectDropdown;

@FindBy(how = How.XPATH, using = "//select[@data-label='State/Province']")
WebElement stateSelectDropdown;

@FindBy(how = How.ID, using = "FormField_13_input")
WebElement zipInputTextBox;

@FindBy(how = How.XPATH, using = "//button[text()='Save']")
WebElement saveAddressButton;

@FindBy(how = How.XPATH, using = "(//li[@class='address'])[1]//li")
WebElement createdAddressHeader;

@FindBy(how = How.XPATH, using = "//h1[text()='Add an Address']")
WebElement addNewAddressHeading;

@FindBy(how = How.XPATH, using = "(//button[@data-reveal-id='delete-it'])[1]")
WebElement firstDeleteIconOnAddressList;

@FindBy(how = How.XPATH, using = "//form[@id='delete-address-url']/button[text()='Delete']")
WebElement deleteConfirmButton;

@FindBy(how = How.XPATH, using = "//ul[@class='addressList']/li/div")
List<WebElement> addressCount;

@FindBy(how = How.XPATH, using = "//h3[text()='Delete this Shipping Address?']")
WebElement deleteConfirmationModal;

@FindBy(how = How.XPATH, using = "//form[@id='delete-address-url']//a")
WebElement cancelConfirmationModalButton;

@FindBy(how = How.XPATH, using = "//div[@class='select-selected']")
WebElement provienceDropdown;

@FindBy(how = How.XPATH, using = "//button[text()='Default']/..//button[@data-reveal-id='delete-it']")
List<WebElement> DeleteIconOnDefaultAddress;

@FindBy(how = How.XPATH, using = "//input[@data-field-type='Phone']")
WebElement contactNumberInputBox;

@FindBy(how = How.XPATH, using = "//div[@class='form-actions']//a[text()='Cancel']")
WebElement newAddressFormCancelLink;

public void clickFirstDeleteIconUnderAddressesList() {
firstDeleteIconOnAddressList.click();
}

public void clickConfirmDeleteButton() {
deleteConfirmButton.click();
}

public void clickAccountLink() {
topAccountLink.click();
}

public void clickAddressesSubTab() {
addressesSubTab.click();
}

public void clickOnNewAddressAddIcon() throws InterruptedException {
((JavascriptExecutor)driver).executeScript("arguments[0].click();", newAddressAddIcon);

}

public void enterFirstName(String firstName) {
firstNameInputTextBox.clear();
firstNameInputTextBox.sendKeys(firstName);
}

public void enterLastName(String lastName) {
lastNameInputTextBox.clear();
lastNameInputTextBox.sendKeys(lastName);
}

public void enterAddressLine1(String addressLine) {
addressLine1InputTextBox.clear();
addressLine1InputTextBox.sendKeys(addressLine);
}

public void enterCity(String cityName) {
cityInputTextBox.clear();
cityInputTextBox.sendKeys(cityName);
}

public void selectCountryFromCountryDropDown(String countryName) {
Select countryDropdown = new Select(countrySelectDropdown);
countryDropdown.selectByVisibleText(countryName);
}

public void selectStateFromStateDropDown(String stateName) throws InterruptedException {
((JavascriptExecutor) driver).executeScript("window.scrollBy(0,400)", "");
Thread.sleep(3000);
provienceDropdown.click();
driver.findElement(By.xpath("//div[@class='select-items']/div[text()=\"" + stateName + "\"]")).click();
}

public void enterZipCode(String zipCode) {
zipInputTextBox.clear();
zipInputTextBox.sendKeys(zipCode);
}

public void clickSaveAddressButton() {
saveAddressButton.click();
}

public boolean verifyNewlyCreatedAddress(String validateText) {
return createdAddressHeader.getText().contains(validateText);
}

public WebElement addNewAddressPageHeadingElement() {
return addNewAddressHeading;
}

public boolean isAddNewAddressPageHeadingDisplayed() {
return wait.until(ExpectedConditions.visibilityOf(addNewAddressPageHeadingElement())).isDisplayed();
}

public int addressCount() {
return addressCount.size();
}

public boolean isDeleteButtonDisplayedOnSavedAddressProfilePage() {
return wait.until(ExpectedConditions.visibilityOf(firstDeleteIconOnAddressList)).isDisplayed();
}

public boolean isDeleteConfirmationModalDisplayed() {
return wait.until(ExpectedConditions.visibilityOf(deleteConfirmationModal)).isDisplayed();
}

public void clickCancelButtonInDeleteConfirmationModal() {
cancelConfirmationModalButton.click();
}

public int isDeleteButtonDisplayedOnDefaultAddressProfilePage() {
return DeleteIconOnDefaultAddress.size();
}

public boolean isFirstNameInputDisplayed() {
return firstNameInputTextBox.isDisplayed();
}

public boolean isLastNameInputDisplayed() {
return lastNameInputTextBox.isDisplayed();
}

public boolean isAddressLine1InputTextBoxInputDisplayed() {
return addressLine1InputTextBox.isDisplayed();
}

public boolean isCityInputDisplayed() {
return cityInputTextBox.isDisplayed();
}

public boolean isProvienceDropdownInputDisplayed() {
return provienceDropdown.isDisplayed();
}

public boolean isZipInputTextBoxInputDisplayed() {
return zipInputTextBox.isDisplayed();
}

public boolean isSaveAddressButtonDisplayed() {
return saveAddressButton.isDisplayed();
}

public boolean isContactNumberInputBoxDisplayed() {
return contactNumberInputBox.isDisplayed();
}

public boolean isNewAddressFormCancelLinkDisplayed() {
return newAddressFormCancelLink.isDisplayed();
}

/*
* This Method validates Invalid Input Error messages for Create New address
*/
// once validation is provided. we will work
public boolean verifyCreareNewAddressInvalidInput(String firstName, String lastName, String address, String city, String country,
String state, String zipCode) throws InterruptedException {
boolean status=false;
GenericFunctions gf = new GenericFunctions();
String firstNameWithTimeStamp = firstName + gf.getTimeStamp();
clickOnNewAddressAddIcon();
test.info("User clicked on New Address Creation Icon");
isAddNewAddressPageHeadingDisplayed();
test.info("New Address Creation Page Displayed");
enterFirstName(firstNameWithTimeStamp);
test.info("Entered First Name " + firstNameWithTimeStamp);
enterLastName(lastName);
test.info("Entered Last Name");
enterAddressLine1(address);
test.info("Entered Address");
enterCity(city);
test.info("Entered City Name");
selectStateFromStateDropDown(state);
test.info("Select State Name");
enterZipCode(zipCode);
test.info("Entered Zip Code");
clickSaveAddressButton();
test.info("Click on SAVE Button");
return status;

}

}
