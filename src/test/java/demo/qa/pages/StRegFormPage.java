package demo.qa.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;
import demo.qa.pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class StRegFormPage {
        CalendarComponent calendar = new CalendarComponent();
        SelenideElement firstNameInput = $("#firstName");
        Faker faker = new Faker();

        String firstName = faker.name().firstName(),
                lastName = faker.name().lastName(),
                email = faker.internet().emailAddress(),
                currentAddress = faker.rickAndMorty().quote(),
                mobile = faker.phoneNumber().subscriberNumber(10);


        public StRegFormPage openPage(){
                open("/automation-practice-form");
                $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
                executeJavaScript("$('#fixedban').remove()");
                executeJavaScript("$('footer').remove()");
                Selenide.zoom(0.85);

                return this;
        }

        public StRegFormPage setFirstName(){
                firstNameInput.setValue(firstName);

                return this;
        }
        public StRegFormPage setLastName(){
                $("#lastName").setValue(lastName);

                return this;
        }
        public StRegFormPage setEmail(){
                $("#userEmail").setValue(email);

                return this;
        }
        public StRegFormPage setCurrentAddress(){
                $("#currentAddress").setValue(currentAddress);

                return this;
        }
        public StRegFormPage setMobile(){
                $("#userNumber").setValue(mobile);

                return this;
        }
        public StRegFormPage setGender(String value){
                $("#genterWrapper").$(byText(value)).click();

                return this;

        }public StRegFormPage setBirthDate(String day, String month, String year){
                $("#dateOfBirthInput").click();
                calendar.setDate(day,month,year);

                return this;
        }

}
