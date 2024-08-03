package com.aston.lesson18;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import java.util.ArrayList;
import java.util.List;

public class PaymentModule extends BasePage {

    public PaymentModule(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(css = "div.pay__wrapper h2")
    private WebElement moduleName;

    @FindBy(id = "cookie-agree")
    private WebElement cookies;

    @FindBy(xpath = "//div[@class='pay__partners']//img")
    private List<WebElement> logos;

    @FindBy(linkText = "Подробнее о сервисе")
    private WebElement link;

    @FindBy(className = "select__wrapper")
    private WebElement chooseOption;

    @FindBy(id = "connection-phone")
    private WebElement phoneNumber;

    @FindBy(id = "connection-sum")
    private WebElement paymentAmountPhone;

    @FindBy(id = "connection-email")
    private WebElement emailPhone;

    @FindBy(xpath = "//form[@id='pay-connection']/button")
    private WebElement buttonContinue;

    @FindBy(id = "internet-phone")
    private WebElement internet;

    @FindBy(id = "internet-sum")
    private WebElement paymentAmountInternet;

    @FindBy(id = "internet-email")
    private WebElement emailInternet;

    @FindBy(id = "score-instalment")
    private WebElement instalment;

    @FindBy(id = "instalment-sum")
    private WebElement instalmentSum;

    @FindBy(id = "instalment-email")
    private WebElement instalmentEmail;

    @FindBy(id = "score-arrears")
    private WebElement arrears;

    @FindBy(id = "arrears-sum")
    private WebElement arrearsSum;

    @FindBy(id = "arrears-email")
    private WebElement arrearsEmail;

    @FindBy(xpath = "//iframe[@class='bepaid-iframe']")
    private WebElement iFrame;

    public void acceptCookies() {
        wait5(cookies);
        cookies.click();
    }

    public String getModuleName() {
        return moduleName.getText();
    }

    public int logoAmount() {
        return logos.size();
    }

    public List<String> listOfLogosName() {
        List<String> logosName = new ArrayList<>();
        for (WebElement element : logos) {
            logosName.add(element.getAttribute("alt"));
        }
        return logosName;
    }

    public String getURLLinkAboutService() {
        link.click();
        return getWebDriver().getCurrentUrl();
    }

    public Iframe sendParametersAndButtonClick(String number, String payment) {
        phoneNumber.sendKeys(number);
        paymentAmountPhone.sendKeys(payment);
        buttonContinue.click();
        wait5(iFrame);
        getWebDriver().switchTo().frame(iFrame);
        return new Iframe(getWebDriver());
    }

    void chooseOptionConnection(String choice) {
        Actions action = new Actions(getWebDriver());
        WebElement option = getWebDriver().findElement(By.xpath("//p[text()='" + choice + "']"));
        chooseOption.click();
        wait5(option);
        action.moveToElement(option)
                .click()
                .build()
                .perform();
    }

    String placeholder(WebElement element) {
        return element.getAttribute("placeholder");
    }

    public ArrayList<String> checkPlaceholderText(String choice) {
        ArrayList<String> listPlaceholders = new ArrayList<>();
        switch (choice) {
            case ("phone"):
                chooseOptionConnection("Услуги связи");
                listPlaceholders.add(placeholder(phoneNumber));
                listPlaceholders.add(placeholder(paymentAmountPhone));
                listPlaceholders.add(placeholder(emailPhone));
                break;
            case ("internet"):
                chooseOptionConnection("Домашний интернет");
                listPlaceholders.add(placeholder(internet));
                listPlaceholders.add(placeholder(paymentAmountInternet));
                listPlaceholders.add(placeholder(emailInternet));
                break;
            case ("instalment"):
                chooseOptionConnection("Рассрочка");
                listPlaceholders.add(placeholder(instalment));
                listPlaceholders.add(placeholder(instalmentSum));
                listPlaceholders.add(placeholder(instalmentEmail));
                break;
            case ("arrears"):
                chooseOptionConnection("Задолженность");
                listPlaceholders.add(placeholder(arrears));
                listPlaceholders.add(placeholder(arrearsSum));
                listPlaceholders.add(placeholder(arrearsEmail));
                break;
            default:
                break;
        }
        return listPlaceholders;
    }

    public void returnToHomePage() {
        getWebDriver().navigate().back();
    }
}