package tests;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.CalculatorPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class MobileAppTest extends BaseClass {

    private CalculatorPage calculatorPage = new CalculatorPage();

    @Test
    public void testMethod() {
        $(By.id("digit_2")).click();
        $(By.id("op_add")).click();
        $(By.id("digit_4")).click();
        $(By.id("eq")).click();
        $(By.id("result")).shouldHave(text("6"));
        System.out.println("Да, бля!");
    }

    @Test
    public void testMethod2() {
        calculatorPage.pressButton("2").
                pressPlus().
                pressButton("4").
                pressEquals().
                checkResult("6");
    }

    @Test
    public void testTourist() {
        try {
            $(By.id("button")).waitUntil(visible, 10000);
            $(By.id("button")).click();
        }catch (Throwable e) {
            System.out.println("Опа, пиздец!");
        }
        $(By.id("tour_page_switcher")).shouldBe(visible).click();
        $(By.id("tour_page_switcher")).shouldBe(visible).click();
        $(By.id("tour_page_switcher")).shouldBe(visible).click();
        $(By.id("tour_page_switcher")).shouldBe(visible).click();
        $(By.id("button")).waitUntil(visible, 10000);
        $(By.id("button")).click();
        $(By.id("places")).waitUntil(visible, 15000);
        $(By.id("places")).click();
        sleep(500);
    }


    @Test
    public void setValues() {
        $(By.id("places_toolbar")).shouldBe(visible).click();
        $(By.id("dynamic_item_container")).shouldBe(visible).click();
        $(By.id("dynamic_item_container")).shouldBe(visible).sendKeys("Русский текст");
        $(By.id("dynamic_item_container")).shouldBe(visible).setValue("bla-text2");
    }
}
