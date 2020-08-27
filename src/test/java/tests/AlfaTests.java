package tests;

import com.codeborne.selenide.CollectionCondition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class AlfaTests {
    @Test
    void alfaDepositTest()
    {
        // открыть сайт alfabank.ru
        open("https://alfabank.ru/");

        //Нажимаем на "Вклады"
        $(byText("Вклады")).click();

        //Нажимаем на "Депозиты"
        $$(byText("Депозиты")).find(visible).click();

        //Нажимаем на ссылку "Архивные депозиты"
        $(".col-sm-frame").$("a").click();

        //Проверяем, что отобразилось ровно 3 архивных депозита
        $$(".product-cell__cell").shouldBe(CollectionCondition.size(3));
    }

    @Test
    void alfaInsuranceTest()
    {
        // открыть сайт alfabank.ru
        open("https://alfabank.ru/");

        //Нажимаем на "Вклады"
        $(byText("Вклады")).click();

        //Нажимаем на "Страхование вкладов"
        $(".navigation").$("li").sibling(4).click();

        //Проверяем наличие заголовка "Страхование вкладов"
        $("h1").shouldHave(text("Страхование вкладов"));
    }
}
