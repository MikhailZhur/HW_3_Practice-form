import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Selenide.*;

public class TextBoxTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1280";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillTestForm() {
        open("/automation-practice-form");
        $("[id='firstName']").setValue("Mikhail");
        $("[id='lastName']").setValue("Zhuravlev");
        $("[id='userEmail']").setValue("miha99_66@mail.ru");
        $("[for='gender-radio-1']").click();
        $("[id='userNumber']").setValue("9126298333");

        $("[id='dateOfBirthInput']").click();
        $("[class='react-datepicker__month-select']").click();
        $("[value='4']").click();
        $("[class='react-datepicker__year-select']").click();
        $("[value='1988']").click();
        $("[aria-label='Choose Friday, May 27th, 1988']").click();

        $("[id='subjectsInput']").setValue("e").pressEnter();
        $("[for='hobbies-checkbox-3']").click();

        $("input[type='file']").uploadFile(new File("src/test/resources/CV.jpg"));

        $("[id='currentAddress']").setValue("Kras");

        $("#state").click();
        $("#react-select-3-option-0").click();

        $("#city").click();
        $("#react-select-4-option-0").click();

        sleep(5000);

       // int x = 0;
    }
}
