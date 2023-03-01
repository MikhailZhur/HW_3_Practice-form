import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillTestForm() {
        open("/automation-practice-form");
        $("input[id='firstName']").setValue("Mikhail");
        $("input[id='lastName']").setValue("Zhuravlev");
        $("input[id='userEmail']").setValue("miha99_66@mail.ru");
        $("label[for='gender-radio-1']").click();
        $("input[id='userNumber']").setValue("9126298333");
        $("input[id='dateOfBirthInput']").click();
        $("select[class='react-datepicker__month-select']").click();
        $("option[value='4']").click();

        int x = 0;
    }
}
