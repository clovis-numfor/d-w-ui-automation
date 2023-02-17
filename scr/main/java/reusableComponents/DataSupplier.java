package reusableComponents;

import org.testng.annotations.DataProvider;

public class DataSupplier {

/*
* Testdata for valid login attempts using data from DataProvider
*/
@org.testng.annotations.DataProvider(name = "userDetails")
public Object[][] getUserDetails() {
return new Object[][] { { "automation.user1@gmail.com", "Test1234", "Automation User" } // User with full name
};
}

/*
* Testdata for Creating New Valid  Address
*/
@DataProvider(name = "newAddress")
public Object[][] getData2() {
return new Object[][] { { "Automation", "Tester", "Test Address", "White Rock", "Canada", "Alberta", "V4B",
"automation.user1@gmail.com", "Test1234", "Automation User" } };
}

/*
* Testdata to check for Invid Address
*/
@DataProvider(name = "getInvalidAddress")
public Object[][] getInvalidData() {
return new Object[][] { { "Automation", "Tester", "Test Address", "White Rock", "Canada", "Alberta", "V4B",
"automation.user1@gmail.com", "Test1234", "Automation User" } };
}

}
