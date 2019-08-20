package tests;

import com.AndroidDriverWithCalculator;
import com.codeborne.selenide.Configuration;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.open;

public class BaseClass {

    private AppiumDriverLocalService service = AppiumDriverLocalService.buildDefaultService();

    @BeforeSuite
    public void setUp() {

//        String myShellScript = System.getenv("ANDROID_HOME") + "/tools/emulator -avd Nexus_S_API_26";
        String myShellScript = "/home/victor/Android/Sdk/tools/emulator -avd Pixel_API_26";

        try {
            Runtime.getRuntime().exec(myShellScript);
        } catch (IOException e) {
            e.printStackTrace();
        }
        service.start();

        Configuration.startMaximized = false;
        Configuration.browserSize = null;
        Configuration.timeout = 20 * 1000;
        Configuration.browser = AndroidDriverWithCalculator.class.getName();
        open();
    }

    @AfterSuite
    public void tearDown() {

        try {
            Runtime.getRuntime().exec("adb -s emulator-5554 emu kill");
        } catch (IOException e) {
            e.printStackTrace();
        }
        close();
        service.stop();
    }
}
