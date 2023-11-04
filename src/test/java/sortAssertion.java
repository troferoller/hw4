import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class sortAssertion {
    @BeforeAll
    static void configs(){
        Configuration.browserSize = "2560x1440";
        Configuration.baseUrl = "https://github.com";
        Configuration.pageLoadStrategy = "eager";
    }
    @Test
    void fillFormTest() {
        open("/selenide/selenide");
        $("#wiki-tab").click();
        $(byText("Soft assertions")).click();
        $("#user-content-3-using-junit5-extend-test-class").sibling(0).shouldHave(exactText("""
                @ExtendWith({SoftAssertsExtension.class})
                class Tests {
                @Test
                void test() {
                Configuration.assertionMode = SOFT;
                open("page.html");

                $("#first").should(visible).click();
                $("#second").should(visible).click();
                }
                }"""));
    }
}