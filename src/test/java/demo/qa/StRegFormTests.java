package demo.qa;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class StRegFormTests {
    @Test
    void fillFormTest(){
        open("https://demoqa.com/automation-practice-form");

    }
}
