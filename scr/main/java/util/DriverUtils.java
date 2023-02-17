package util;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import setup.DriverManager;

public class DriverUtils extends DriverManager {

public static RemoteWebDriver selectDeviceAndBrowser() throws MalformedURLException {
RemoteWebDriver driver = null;
String executionMode = PropertiesOperations.getPropertyValueByKey("execution");

switch (executionMode) {
case "local":
/*
* System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")
* + "/src/main/resources/chromedriver.exe");
*/
WebDriverManager.chromedriver().setup();
driver = new ChromeDriver();
break;
case "browserstack":

MutableCapabilities capabilities = new MutableCapabilities();
capabilities.setCapability("browserName", PropertiesOperations.getPropertyValueByKey("browserName"));
HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
browserstackOptions.put("os", PropertiesOperations.getPropertyValueByKey("os"));
browserstackOptions.put("osVersion", PropertiesOperations.getPropertyValueByKey("osVersion"));
browserstackOptions.put("browserVersion", PropertiesOperations.getPropertyValueByKey("browserVersion"));
browserstackOptions.put("local", PropertiesOperations.getPropertyValueByKey("local"));
// browserstackOptions.put("seleniumVersion", "3.14.0");
capabilities.setCapability("bstack:options", browserstackOptions);
driver = new RemoteWebDriver(new URL("https://" + PropertiesOperations.getPropertyValueByKey("userName")
+ ":" + PropertiesOperations.getPropertyValueByKey("accessKey")
+ "@hub-cloud.browserstack.com/wd/hub"), capabilities);

break;
default:
// code block
}

return driver;
}
}
