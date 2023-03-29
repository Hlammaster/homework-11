import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class Steps {
    @Step("Открываем главную страницу")
    public void openMainPage(){
        open("https://github.com");
    }
    @Step("Ввести в поле поиска 'Issues'")
    public void enterIssues(){
        $(".header-search-input").click();
        $(".header-search-input").sendKeys("Issues");
        $(".header-search-input").submit();
    }
    @Step("Перейти по ссылке 'microsoft/WSL'")
    public void followLink(){
        $(linkText("microsoft/WSL")).click();
    }
    @Step("Кликнуть таб 'Issues'")
    public void clickRepository(){
        $("#issues-tab").click();
    }
    @Step("Проверить наличие ссылки с хэштегом 9863")
    public void checkText(){
        $(withText("#9863")).shouldBe(Condition.exist);
    }
}
