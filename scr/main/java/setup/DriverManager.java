package setup;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.aventstack.extentreports.ExtentTest;

import pages.HomePage;
import util.DriverUtils;
import util.PropertiesOperations;

public class DriverManager {

	private static RemoteWebDriver driver;
	public static ExtentTest test;
	Properties prop = new Properties();
	protected static ThreadLocal<RemoteWebDriver> driverobject = new ThreadLocal<RemoteWebDriver>();

	// Reading all the properties in or from the config.properties
	//public void loadconfigurations() throws IOException {
	//	File file = new File(System.getProperty("\\src\\main\\java\\config\\config.properties"));
	//	FileInputStream fis = new FileInputStream(file);
	//	prop.load(fis);
	//}

	@BeforeMethod(alwaysRun = true)
	public void setup(ITestContext context) throws IOException {
		String previewCode = PropertiesOperations.getPropertyValueByKey("preview_code");
		//loadconfigurations();
		driver = DriverUtils.selectDeviceAndBrowser();
		// context.setAttribute("RemoteWebDriver", driver);

		driverobject.set(driver);
		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		getDriver().manage().window().maximize();
		getDriver().get(PropertiesOperations.getPropertyValueByKey("url"));

		HomePage homePage = new HomePage(driver);
		// Handling preview code
		//homePage.typePreviewCode(previewCode);
		//homePage.clickSubmitButton();
	}
	
	//get thread-safe driver
    public static RemoteWebDriver getDriver(){
        return  driverobject.get();
    }

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		getDriver().close();
		driverobject.remove();

	}

}
