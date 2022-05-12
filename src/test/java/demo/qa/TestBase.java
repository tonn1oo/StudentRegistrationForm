package demo.qa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.CredentialsConfig;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {

    @BeforeAll
    static void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        CredentialsConfig config = ConfigFactory.create(CredentialsConfig.class);
        String login = config.login();
        String password = config.password();
        String selenoidUrl = System.getProperty("selenoid", "selenoid.autotests.cloud/wd/hub");
        String propertyBrowserSize = System.getProperty("propertyBrowserSize", "1980x1080");
        String startUrl = System.getProperty("startUrl", "https://demoqa.com");


        Configuration.baseUrl = startUrl;
        Configuration.browserSize = propertyBrowserSize;
        Configuration.remote = "https://" + login + ":" + password + "@" + selenoidUrl;

    }

    @AfterEach
    void addAttach() {
        Attach.screenshotAs("screen");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        closeWebDriver();

    }
}
