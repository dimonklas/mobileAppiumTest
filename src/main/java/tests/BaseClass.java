package tests;

import com.AndroidDriverWithCalculator;
import com.codeborne.selenide.Configuration;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.open;

public class BaseClass {

    private AppiumDriverLocalService service = AppiumDriverLocalService.buildDefaultService();

    @BeforeTest
    public void setUp() {

        String myShellScript = "/home/DN060191MDO/Android/Sdk/tools/emulator -avd Nexus_S_API_26";

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

    @AfterTest
    public void tearDown() {
        close();
        service.stop();
    }
}
