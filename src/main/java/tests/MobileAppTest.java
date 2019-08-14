package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.CalculatorPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

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
}
