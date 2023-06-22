package ios;

import java.net.URL;
import java.util.List;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.appium.java_client.MobileBy;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

public class BrowserStackSample {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
   	DesiredCapabilities caps = new DesiredCapabilities();
    	
    	// Set your access credentials
    	
        caps.setCapability("browserstack.user", "YOUR_USERNAME");
    	caps.setCapability("browserstack.key", "YOUR_ACCESS_KEY");
    	
    	
    	// Set URL of the application under test
	caps.setCapability("app", "bs://<app-id>");

    	
    	// Specify device and os_version for testing
    	caps.setCapability("device", "iPhone 14");
    	caps.setCapability("os_version", "16");
        //test on 1.22
    	// Set other BrowserStack capabilities

    	caps.setCapability("project", "stryker");
    	caps.setCapability("build", "browserstack-stryker");
    	caps.setCapability("name", "Repsuite");
    	caps.setCapability("browserstack.idleTimeout", "150");
//    	caps.setCapability("browserstack.resignApp", "false");
//    	caps.setCapability("")

        IOSDriver<IOSElement> driver = new IOSDriver<IOSElement>(
                new URL("http://hub-cloud.browserstack.com/wd/hub"), caps);

        try {

            driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

            IOSElement el1 = (IOSElement) driver.findElementByAccessibilityId("Continue");
            el1.click();
            IOSElement el2 = (IOSElement) driver.findElementByAccessibilityId("Enter your email, phone, or Skype.");
            el2.click();
            el2.sendKeys("rs_uat.test17@stryker.com");
            IOSElement el3 = (IOSElement) driver.findElementByXPath("(//XCUIElementTypeButton[@name=\"Next\"])[1]");
            el3.click();
            IOSElement el4 = (IOSElement) driver.findElementByAccessibilityId("Enter the password for rs_uat.test17@stryker.com");
            el4.click();
            el4.sendKeys("Stryker1");
            IOSElement el5 = (IOSElement) driver.findElementByAccessibilityId("Sign in");
            el5.click();
            IOSElement el6 = (IOSElement) driver.findElementByAccessibilityId("Yes");
            el6.click();
//            IOSElement el7 = (IOSElement) driver.findElementByAccessibilityId("Okay, got it!");
//            el7.click();
            IOSElement els1 = (IOSElement) driver.findElementByXPath("/XCUIElementTypeApplication/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]");
            els1.click();
            IOSElement el8 = (IOSElement) driver.findElementByXPath("(//XCUIElementTypeOther[@name=\"New Surgical Case\"])[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther");
            el8.click();


        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
        finally {
            driver.quit();
        }
	}
}
