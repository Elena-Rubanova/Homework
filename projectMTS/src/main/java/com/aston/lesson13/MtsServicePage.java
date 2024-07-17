package com.aston.lesson13;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class MtsServicePage {
    WebDriver driver;

    @FindBy(css = "div.pay__wrapper h2")
    WebElement moduleName;

    @FindBy(id = "cookie-agree")
    WebElement cookies;

    @FindBy(xpath = "//div[@class='pay__partners']/img")
    List<WebElement> logos;

    @FindBy(linkText = "Подробнее о сервисе")
    WebElement link;

    @FindBy(xpath = "//iframe[@class='bepaid-iframe']")
    WebElement iFrame;

    @FindBy(id = "connection-phone")
    WebElement phoneNumber;

    @FindBy(id = "connection-sum")
    WebElement paymentAmount;

    @FindBy(xpath = "//form[@id='pay-connection']/button")
    WebElement buttonContinue;

    @FindBy(xpath = "(//div[@class='pay-description__cost']/span)[1]")
    WebElement paymentText;

    public MtsServicePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    void acceptCookies() {
        cookies.click();
    }

    void checkModuleName() {
        Assert.assertEquals(moduleName.getText(),
                "Онлайн пополнение\nбез комиссии", "Название блока не соответствует ожидаемому");
    }

    void logoPresence() {
        for (WebElement element : logos) {
            Assert.assertTrue(element.isDisplayed(), "Ошибка в отображении логотипов платежных систем");
        }
    }

    void linkWorks() {
        link.click();
        Assert.assertEquals(driver.getCurrentUrl(),
                "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/",
                "URL после перехода по ссылке не соответствует ожидаемому");
        driver.navigate().back();
    }

    void buttonClick(String number, String payment) {
        phoneNumber.sendKeys(number);
        paymentAmount.sendKeys(payment);
        buttonContinue.click();
        driver.switchTo().frame(iFrame);

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(paymentText));

        Assert.assertEquals((paymentText).getText(), payment + ".00 BYN");
    }
}




