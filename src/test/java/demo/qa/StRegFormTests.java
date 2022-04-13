package demo.qa;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.github.javafaker.Faker;
import demo.qa.pages.StRegFormPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class StRegFormTests {
    StRegFormPage stregFormPage = new StRegFormPage();

    @BeforeAll
    static void setUp() {
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1980x1080";

    }

    @Test
    void fillFormTest(){

        stregFormPage.openPage()
                .setFirstName()
                .setLastName()
                .setEmail()
                .setMobile()
                .setCurrentAddress()
                .setGender("Male")
                .setBirthDate("25", "July", "2008" );

        $("#subjectsInput").setValue("Computer Science").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("1111.png");
        $("#state").click();
        $("#stateCity-wrapper").find(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").find(byText("Delhi")).click();
        $("#submit").click();
        ////
       /// $(".table-responsive").shouldHave(text(firstName + " " + lastName),
             //   text(email), text("Gender Male"), text(mobile),
             //   text("Date of Birth 29 April,1987"), text("Subjects Computer Science"), text("Hobbies Sports"),
              //  text("Picture 1111.png"), text(currentAddress), text("State and City NCR Delhi"));
        /////


















    }
}
