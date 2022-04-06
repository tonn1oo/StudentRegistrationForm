package demo.qa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class StRegFormTests {

    @BeforeAll
    static void setUp() {
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1980x1080";


    }

    @Test
    void fillFormTest(){
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        Selenide.zoom(0.85);


        $("#firstName").setValue("Anton");
        $("#lastName").setValue("Vlasov");
        $("#userEmail").setValue("qwerty@wsdx.ru");
        $("#userNumber").setValue("7912345623");
        $("#genterWrapper").$(byText("Male")).click();
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue("5");
        $(".react-datepicker__year-select").selectOptionByValue("1912");
        $(".react-datepicker__day--012").click();
        $("#subjectsInput").setValue("Computer Science").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("1111.png");
        $("#currentAddress").setValue("Georgia");
        $("#state").click();
        $("#stateCity-wrapper").find(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").find(byText("Delhi")).click();
        $("#submit").click();
















    }
}
