import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.itemWithText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class HometaskTests {

    @BeforeAll
    public static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    public void successfulSearchJunit5Example() {
        String page = "SoftAssertions";
        String junit5Example = "@ExtendWith({SoftAssertsExtension.class})\n" +
                "class Tests {\n" +
                "  @Test\n" +
                "  void test() {\n" +
                "    Configuration.assertionMode = SOFT;\n" +
                "    open(\"page.html\");\n" +
                "\n" +
                "    $(\"#first\").should(visible).click();\n" +
                "    $(\"#second\").should(visible).click();\n" +
                "  }\n" +
                "}";

        open("https://github.com/selenide/selenide");
        $(".UnderlineNav-body").$("[data-content='Wiki']").click();
        $("#wiki-pages-box").$(byText(page)).click();
        $$(".markdown-body .highlight").shouldHave(itemWithText(junit5Example));
    }

    @Test
    public void dragAndDropTest() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#column-a").shouldBe(text("A"));
        $("#column-b").shouldBe(text("B"));
        $("#column-a").dragAndDropTo("#column-b");
        $("#column-a").shouldBe(text("B"));
        $("#column-b").shouldBe(text("A"));
    }

}
