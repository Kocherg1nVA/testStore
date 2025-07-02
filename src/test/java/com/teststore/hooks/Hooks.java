package com.teststore.hooks;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @Before
    public void setup(Scenario scenario) {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
        Configuration.browser = "chrome";
        Configuration.headless = false; // Можно включить для CI
        Configuration.timeout = 10000;
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            Allure.getLifecycle().addAttachment(
                    "Screenshot",
                    "image/png",
                    "png",
                    ((TakesScreenshot) Selenide.webdriver().driver()).getScreenshotAs(OutputType.BYTES)
            );
        }
        Selenide.closeWebDriver();
    }
}