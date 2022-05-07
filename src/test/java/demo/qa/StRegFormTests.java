package demo.qa;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import demo.qa.pages.StRegFormPage;
import helpers.Attach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StRegFormTests {
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


    @BeforeAll
    static void setUp() {
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1980x1080";
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";

    }

    @AfterEach
    void addAttach() {
        Attach.screenshotAs("123");
        Attach.pageSource();
        Attach.browserConsoleLogs();
    }

    @Test
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
