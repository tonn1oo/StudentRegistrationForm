package demo.qa;

import com.codeborne.selenide.Configuration;
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

        $("[id=firstName]").setValue("Anton");
        $("[id=lastName]").setValue("Vlasov");
        $("[id=userEmail]").setValue("qwerty@gmail.com");
        $("[id=userNumber]").setValue("+79123456");
        $("[class=custom-control-label]").click();





    }
}
