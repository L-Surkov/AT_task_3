
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class PracticeFormTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        //Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000; // default 4000
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Ilya");
        $("#lastName").setValue("Surkov");
        $("#userEmail").setValue("el@gmail.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("8929888554");
        $("#dateOfBirthInput").click();
        String day = "010";
        String month = "October";
        int year = 2000;
        $(".react-datepicker__year-select").selectOption(String.valueOf(year));
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__day--" + day).click();
        $("#subjectsInput").setValue("History").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("images/imagefortest.png");
        $("#currentAddress").setValue("г. Пенза, ул. Красная 64, кв. 166");
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Noida").pressEnter();
        $("#submit").click();
        $(".modal-body").shouldHave(text("Ilya"));
        $(".modal-body").shouldHave(text("Surkov"));
        $(".modal-body").shouldHave(text("el@gmail.com"));
        $(".modal-body").shouldHave(text("Male"));
        $(".modal-body").shouldHave(text("8929888554"));
        $(".modal-body").shouldHave(text("10 October,2000"));
        $(".modal-body").shouldHave(text("History"));
        $(".modal-body").shouldHave(text("Sports"));
        $(".modal-body").shouldHave(text("imagefortest.png"));
        $(".modal-body").shouldHave(text("г. Пенза, ул. Красная 64, кв. 166"));
        $(".modal-body").shouldHave(text("NCR Noida"));
    }
}