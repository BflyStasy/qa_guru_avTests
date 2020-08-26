package guru.qa.selenide.starter;

import com.codeborne.selenide.CollectionCondition;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AlfabankTest {

  @BeforeEach
  void alfaInit(){
    open("http://alfabank.ru");

  }

  @AfterEach
  void alfaClose() {
    clearBrowserCookies();
  }

  @Test
  void testDeposit(){
    // Открываем депозиты
    $("body").shouldHave(text("Частным лицам"));
    $(byText("Вклады")).click();
    $("body").shouldHave(text("Вклады и инвестиции"));
    $$(byText("Депозиты")).find(visible).click();

    // клик на ссылку Архивные депозиты
    $(".col-sm-8 a").click();

    //Проверка количества элементов
    $$(".product-cell__cell").shouldBe(CollectionCondition.size(3));
  }

  @Test
  void alfaInsurance(){
  // Открываем депозиты
  $("body").shouldHave(text("Частным лицам"));
  $(byText("Вклады")).click();

  // Переходим на страхование вкладов
  $(".navigation li").sibling(4).click();

  // Проверяем, что заголовок "Страхование вкладов"
  $(".breadcrumbs").sibling(0).shouldHave(text("Страхование вкладов"));
  }
}
