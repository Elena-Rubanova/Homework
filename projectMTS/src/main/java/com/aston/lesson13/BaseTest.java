package com.aston.lesson13;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public abstract class BaseTest {
    private WebDriver driver;
    private MtsServicePage paymentModule;

    public MtsServicePage getPaymentModule() {
        return paymentModule;
    }

    @BeforeTest
    protected void beforeTest() {
        driver = new ChromeDriver();
        driver.get("https://www.mts.by/");
        paymentModule = new MtsServicePage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        paymentModule.acceptCookies();
    }

    @AfterTest
    protected void afterTest() {
        if (driver != null) {
            driver.quit();
        }
    }
}

