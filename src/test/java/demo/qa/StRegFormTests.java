package demo.qa;

import com.codeborne.selenide.Configuration;
import jdk.jfr.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class StRegFormTests {

    @BeforeAll
    static void setUp() {
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillFormTest(){
        open("/automation-practice-form");

        $("#firstName").setValue("Anton");
        $("#lastName").setValue("Vlasov");
        $("#userEmail").setValue("qwerty@wsdx.ru");
        $("#userNumber").setValue("+79123456");
        $(".custom-control-label").click();
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue("5");
        $(".react-datepicker__year-select").selectOptionByValue("1912");













    }
}
