
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
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
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000; // default 4000
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Ilya");
        $("#lastName").setValue("Surkov");
        $("#userEmail").setValue("el@gmail.com");
        $("label[for='gender-radio-1']").click();
        $("#userNumber").setValue("89298885541");
        $("#dateOfBirthInput").click();
        String day = "010";
        String month = "October";
        int year = 2000;
        $(".react-datepicker__year-select").selectOption(String.valueOf(year));
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__day--" + day).click();
        $("#subjectsInput").click();
        $("#subjectsInput").setValue("Hi");
        Selenide.sleep(500);
        $$(".subjects-auto-complete__option").findBy(text("History")).click();

        $("#submit").click();

        $("#output #name").shouldHave(text("Alex"));
        $("#output #email").shouldHave(text("alex@egorov.com"));
        $("#output #currentAddress").shouldHave(text("Some street 1"));
        $("#output #permanentAddress").shouldHave(text("Another street 1"));
    }
}