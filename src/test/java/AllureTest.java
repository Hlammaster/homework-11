import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.attachment;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class AllureTest {
    @Test
    @DisplayName("Listener Test")
    public void testIssueSearch() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com");

        $(".header-search-input").click();
        $(".header-search-input").sendKeys("Issues");
        $(".header-search-input").submit();

        $(linkText("microsoft/WSL")).click();
        $("#issues-tab").click();
        $(withText("#9863")).shouldBe(Condition.exist);
    }

    @Test
    @DisplayName("Step Test")
    public void stepTestIssueSearch() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        Steps steps = new Steps();
        step("Открываем главную страницу", () -> {
            open("https://github.com");

        });


        step("Ввести в поле поиска 'Issues'", () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys("Issues");
            $(".header-search-input").submit();

        });
        step("Перейти по ссылке 'microsoft/WSL'", () -> {
            $(linkText("microsoft/WSL")).click();

        });

        step("Кликнуть таб 'Issues'", () -> {
            $("#issues-tab").click();
        });

        step("Проверить наличие ссылки с хэштегом 9863", () -> {
            $(withText("#9863")).shouldBe(Condition.exist);
        });

    }

    @Test
    @DisplayName("Annotated Test")
    @Feature("Issues")
    @Owner("Evgenii")
    @Story("история пользователя")
    @Link("полезные ссылки")
    public void annotatedIssuesSearch() {
        Steps steps = new Steps();
        steps.openMainPage();
        steps.enterIssues();
        steps.followLink();
        steps.clickRepository();
        steps.checkText();
        steps.takeScreenshot();
    }
}
