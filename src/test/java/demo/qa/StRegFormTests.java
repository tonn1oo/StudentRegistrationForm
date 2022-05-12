package demo.qa;

import com.github.javafaker.Faker;
import demo.qa.pages.StRegFormPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class StRegFormTests extends TestBase {


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
