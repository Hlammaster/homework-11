import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class AllureTest {
    @Test
    public void testIssueSearch() {
     //   SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com");

        $(".header-search-input").click();
        $(".header-search-input").sendKeys("Issues");
        $(".header-search-input").submit();

        $(linkText("microsoft/WSL")).click();
        $("#issues-tab").click();
        $(withText("#9858")).shouldBe(Condition.exist);
    }
}
