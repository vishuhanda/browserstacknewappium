

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Drivermanager {


    private static ThreadLocal<AppiumDriver<MobileElement>> appiumDriverThreadLocal = new ThreadLocal<>();



    private Drivermanager() throws MalformedURLException {

    }

    public static void initDriver() throws MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("app", "bs://bd83683ba0ff3fa2c3c2d247c2ca0d6e64058c94");
        caps.setCapability("browserstack.user", "vhvl_9KOMkx");
        caps.setCapability("browserstack.key", "puL2x1SZ4AhecfrcxW39");

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
