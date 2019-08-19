package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.CalculatorPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

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
        } catch (Throwable e) {
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
        back();
    }


    @Test
    public void setValues() {
//        $(By.id("progressBar")).waitUntil(not(visible), 30* 1000);
//        $(By.id("progressBar")).shouldNotBe(visible);
        $(By.id("places_toolbar")).shouldBe(visible).click();
        $(By.id("dynamic_item_container")).shouldBe(visible).val("Кафе");
        $$(By.id("dynamic_item_container")).get(1).shouldBe(visible).click();
        $(By.id("name_filter")).val("Днепр");
        $(By.id("item_name")).shouldHave(text("Днепр"));
        $(By.id("item_name")).click();

        $(By.className("android.widget.Button")).shouldBe(visible).click();
        $x("//android.widget.Button[contains(@text,'Показать')]").shouldBe(visible).click();
//        $x("//android.widget.Button").shouldBe(visible);
//        $x("//android.widget.Button").click();
//        $(By.id("apply_meta_filters_button")).click();
    }


    @Test
    public void howTime() {
        sleep(1);
    }
}
