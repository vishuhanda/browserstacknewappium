

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;

public class Drivermanager {


    private static ThreadLocal<AppiumDriver<MobileElement>> appiumDriverThreadLocal = new ThreadLocal<>();



    private Drivermanager() throws MalformedURLException {

    }

    public static void initDriver() throws MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("app", System.getProperty("browserstackurl"));
        caps.setCapability("browserstack.user", "vhvl_9KOMkx");
        caps.setCapability("browserstack.key", "puL2x1SZ4AhecfrcxW39");
        System.out.println("browserstackurl :- " + System.getProperty("browserstackurl"));
        // Specify device and os_version for testing
        caps.setCapability("device", "Google Pixel 3");
        caps.setCapability("os_version", "9.0");

        // Set other BrowserStack capabilities
        caps.setCapability("project", "First Java Project");
        caps.setCapability("build", "Java Android");
        caps.setCapability("name", "first_test");
        AppiumDriver<MobileElement> appiumDriver = new AndroidDriver<MobileElement>(new URL("http://hub.browserstack.com/wd/hub"), caps);
        appiumDriverThreadLocal.set(appiumDriver);

    }


    public static WebDriver getDriver() {
        return appiumDriverThreadLocal.get();
    }

    public static void tearDownDriver() {
        appiumDriverThreadLocal.get().quit();
        appiumDriverThreadLocal.remove();
    }


}
