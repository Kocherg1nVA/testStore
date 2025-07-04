package com.teststore.hooks;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.teststore.config.Config;
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
        SelenideLogger.addListener("AllureSelenide",
                new AllureSelenide().screenshots(true).savePageSource(true));
        Configuration.browser = Config.getBrowser();
        Configuration.timeout = Long.parseLong(Config.getTimeOut());
        Configuration.headless = false; // Можно включить для CI
        Configuration.browserSize = Config.getBrowserResolution();
        Configuration.browserPosition = Config.getBrowserPosition();
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