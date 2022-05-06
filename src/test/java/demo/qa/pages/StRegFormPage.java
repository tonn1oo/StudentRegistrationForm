package demo.qa.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import demo.qa.pages.components.CalendarComponent;
import demo.qa.pages.components.StateCityComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static io.qameta.allure.Allure.step;

public class StRegFormPage {
    CalendarComponent calendar = new CalendarComponent();
    StateCityComponent statecity = new StateCityComponent();
    SelenideElement firstNameInput = $("#firstName");

    public StRegFormPage openPage() {
        step("Open registration form", () -> {
            open("/automation-practice-form");
            $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
            executeJavaScript("$('#fixedban').remove()");
            executeJavaScript("$('footer').remove()");
            Selenide.zoom(0.85);
        });
        return this;
    }




        public StRegFormPage setFirstName (String firstName){
            firstNameInput.setValue(firstName);

            return this;
        }

        public StRegFormPage setLastName (String lastName){
            $("#lastName").setValue(lastName);

            return this;
        }

        public StRegFormPage setEmail (String email){
            $("#userEmail").setValue(email);

            return this;
        }

        public StRegFormPage setCurrentAddress (String currentAddress){
            $("#currentAddress").setValue(currentAddress);

            return this;
        }

        public StRegFormPage setMobile (String mobile){
            $("#userNumber").setValue(mobile);

            return this;
        }

        public StRegFormPage setGender (String value){
            $("#genterWrapper").$(byText(value)).click();

            return this;

        }

        public StRegFormPage setBirthDate (String day, String month, String year){
            $("#dateOfBirthInput").click();
            calendar.setDate(day, month, year);

            return this;
        }

        public StRegFormPage setSubjects (String value){
            $("#subjectsInput").setValue(value).pressEnter();

            return this;
        }

        public StRegFormPage setHobbies (String value){
            $("#hobbiesWrapper").$(byText(value)).click();

            return this;
        }

        public StRegFormPage setPicture (String value){
            $("#uploadPicture").uploadFromClasspath("1111.png");

            return this;
        }

        public StRegFormPage setStateCity (String state, String city){
            $("#state").click();
            statecity.setState(state);
            $("#city").click();
            statecity.setCity(city);

            return this;

        }

        public StRegFormPage setSubmit () {
            $("#submit").click();

            return this;
        }

        public StRegFormPage checkResult (String key, String value){

            $(".table-responsive").$(byText(key)).parent()
                    .shouldHave(text(value));
            return this;


        }
    }






