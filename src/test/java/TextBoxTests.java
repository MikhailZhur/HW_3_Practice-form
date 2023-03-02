import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.screenshots = false;
    }

    @Test
    void fillTestForm() {
        open("/automation-practice-form");
        $("#firstName").setValue("Mikhail");
        $("#lastName").setValue("Zhuravlev");
        $("#userEmail").setValue("miha99_66@mail.ru");
        $(byText("Male")).click();
        $("#userNumber").setValue("9126298333");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $("[value='4']").click();
        $(".react-datepicker__year-select").click();
        $("[value='1988']").click();
        $("[aria-label='Choose Friday, May 27th, 1988']").click();

        $("#subjectsInput").setValue("Commerce").pressEnter();
        $(byText("Music")).click();
        $(byText("Reading")).click();
        $(byText("Sports")).click();

        $("input[type='file']").uploadFile(new File("src/test/resources/CV.jpg"));

        $("#currentAddress").setValue("Kras");

        $("#state").click();
        $(byText("NCR")).click();

        $("#city").click();
        $(byText("Delhi")).click();

        $("#submit").click();

        $(".modal-body").shouldHave(text("Mikhail Zhuravlev"),
                text("miha99_66@mail.ru"),
                text("Male"),
                text("9126298333"),
                text("27 May,1988"),
                text("Commerce"),
                text("Music"),
                text("CV.jpg"),
                text("Kras"),
                text("NCR Delhi"));
    }
}
