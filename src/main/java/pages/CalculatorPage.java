package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;

public class CalculatorPage {

    private SelenideElement plus = $(By.id("op_add"));
    private SelenideElement equals = $(By.id("eq"));
    private SelenideElement result = $(By.id("result"));


    public CalculatorPage pressButton(String number) {
        String id = String.format("digit_%s", number);
        $(By.id(id)).shouldBe(Condition.enabled).click();
        return this;
    }

    public CalculatorPage pressPlus() {
        plus.shouldBe(Condition.enabled).click();
        return this;
    }

    public CalculatorPage pressEquals() {
        equals.shouldBe(Condition.enabled).click();
        return this;
    }

    public void checkResult(String expected) {
        Assert.assertEquals(result.shouldBe(Condition.visible).getText(), "6");
    }

}
