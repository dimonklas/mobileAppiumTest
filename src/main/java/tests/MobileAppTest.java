package tests;

import com.AndroidDriverWithCalculator;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MobileAppTest {

    @BeforeTest
    public void setUp() {
        Configuration.startMaximized = false;
        Configuration.browserSize = null;
        Configuration.browser = AndroidDriverWithCalculator.class.getName();
        open();
    }

    @Test
    public void testMethod() {
        $(By.id("digit_2")).click();
        $(By.id("op_add")).click();
        $(By.id("digit_4")).click();
        $(By.id("eq")).click();
        $(By.id("result")).shouldHave(text("6"));
        System.out.println("Да, бля!");
    }
}
