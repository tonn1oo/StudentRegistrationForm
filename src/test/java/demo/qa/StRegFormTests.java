package demo.qa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.github.javafaker.Faker;
import config.CredentialsConfig;
import demo.qa.pages.StRegFormPage;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Selenide.closeWebDriver;


public class StRegFormTests {



    @BeforeAll
    static void setUp() {
        CredentialsConfig config = ConfigFactory.create(CredentialsConfig.class);
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        Configuration.baseUrl = System.getProperty("base_url");
        Configuration.browserSize = System.getProperty("browser_size");
        Configuration.remote = "https://"+ config.login() + ":" + config.password() + "@" + System.getProperty("server_selenoid");

        /// Video
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;

    }
    @AfterEach
    void addAttach() {
        Attach.screenshotAs("screen");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        closeWebDriver();

    }

    StRegFormPage stregFormPage = new StRegFormPage();
    Faker faker = new Faker();
    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            currentAddress = faker.rickAndMorty().quote(),
            mobile = faker.phoneNumber().subscriberNumber(10),
            img = "1111.png",
            hobbies = "Sports",
            gender = "Male",
            subject = "Computer Science",
            day = "25",
            month = "July",
            year = "2008",
            state = "NCR",
            city = "Delhi";


    @Test
    @DisplayName("Successful fill registration test")
    void fillFormTest() {
        stregFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setMobile(mobile)
                .setCurrentAddress(currentAddress)
                .setGender(gender)
                .setBirthDate(day, month, year)
                .setSubjects(subject)
                .setHobbies(hobbies)
                .setPicture(img)
                .setStateCity(state, city)
                .setSubmit()
                .checkResult("Student Name", (firstName + " " + lastName))
                .checkResult("Student Email", email)
                .checkResult("Gender", gender)
                .checkResult("Mobile", mobile)
                .checkResult("Date of Birth", (day + " " + month + "," + year))
                .checkResult("Subjects", subject)
                .checkResult("Hobbies", hobbies)
                .checkResult("Picture", img)
                .checkResult("Address", currentAddress)
                .checkResult("State and City", (state + " " + city));


    }
}
