package tests;

import com.AndroidDriverWithCalculator;
import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.open;

public class BaseClass {
    @BeforeTest
    public void setUp() {
        Configuration.startMaximized = false;
        Configuration.browserSize = null;
        Configuration.timeout = 20 * 1000;
        Configuration.browser = AndroidDriverWithCalculator.class.getName();
        open();
    }

    @AfterTest
    public void tearDown() {
        close();
    }
}
