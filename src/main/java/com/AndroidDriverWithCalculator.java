package com;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class AndroidDriverWithCalculator implements WebDriverProvider {

    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {

        File app = new File("src/main/resources/appDir/Tourist_Ukraine_v1.9.2.apk");

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus S");
        capabilities.setCapability("autoGrantPermissions", true);
        capabilities.setCapability("appPackage", "ua.privatbank.tourist");
        capabilities.setCapability("appActivity", "ua.privatbank.tourist.ui.authorization.Authorization");
//        capabilities.setCapability("appActivity", "ua.privatbank.tourist.ui.tour.TourActivity");
        capabilities.setCapability("unicodeKeyboard", true);

//        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator1");
//        capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
//        capabilities.setCapability(MobileCapabilityType.LANGUAGE, "ru");
//        capabilities.setCapability(MobileCapabilityType.LOCALE, "UA");

        try {
            return new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
