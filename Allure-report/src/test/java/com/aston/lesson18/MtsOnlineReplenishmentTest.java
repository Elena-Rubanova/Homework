package com.aston.lesson18;

import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class MtsOnlineReplenishmentTest extends BaseTest {
    private final String URL = "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/";
    private final List<String> LOGO_LIST = List.of("Visa", "Verified By Visa", "MasterCard", "MasterCard Secure Code",
            "Белкарт");

    @Test(description = "Проверка названия модуля онлайн-оплаты")
    @Owner(value = "Elena-Rubanova")
    public void checkModuleNameTest() {
        Assert.assertEquals(getPaymentModule().getModuleName(),
                "Онлайн пополнение\nбез комиссии", "Ошибка в названии блока");
    }

    @Test(description = "Проверка отображения логотиповв модуле онлайн-оплаты", dataProvider = "logos")
    @Owner(value = "Elena-Rubanova")
    public void checkLogoDisplayedTest(int amount, List<String> logoName) {
        Assert.assertEquals(getPaymentModule().logoAmount(), amount);
        for (int i = 0; i < amount; i++) {
            Assert.assertEquals(getPaymentModule().listOfLogosName().get(i),
                    logoName.get(i), "Ошибка в модуле оплаты");
        }
    }

    @DataProvider
    public Object[][] logos() {
        return new Object[][]{
                {5, LOGO_LIST}
        };
    }

    @Test(description = "Проверка работы ссылки")
    @Owner(value = "Elena-Rubanova")
    void checkLinkWorksTest() {
        Assert.assertEquals(getPaymentModule().getURLLinkAboutService(), URL,
                "Ошибка в работе ссылки");
        getPaymentModule().returnToHomePage();
    }

    @Test(description = "Проверка кнопки оплаты", dataProvider = "button")
    @Owner(value = "Elena-Rubanova")
    void checkButtonWorksTest(String number, String payment) {

        Iframe iFrame = getPaymentModule().sendParametersAndButtonClick(number, payment);

        Assert.assertEquals(iFrame.getPaymentText(), payment + ".00 BYN",
                "Ошибка в сообщении с суммой");
        iFrame.closeIFrame();
    }

    @DataProvider
    public Object[][] button() {
        return new Object[][]{
                {"297777777", "100"}
        };
    }

    @Test(description = "Проверка информации в  placeholders", dataProvider = "connection")
    @Owner(value = "Elena-Rubanova")
    void checkPlaceholderTextTest(String option, String number, String amount, String email) {
        List<String> listPlaceholders;

        listPlaceholders = getPaymentModule().checkPlaceholderText(option);

        Assert.assertEquals(listPlaceholders.get(0), number,
                "Неверная информация в поле имени: " + option);
        Assert.assertEquals(listPlaceholders.get(1), amount,
                "Неверная информация в поле суммы: " + option);
        Assert.assertEquals(listPlaceholders.get(2), email,
                "Неверная информация в поле email: " + option);
    }

    @DataProvider
    public Object[][] connection() {
        String sum = "Сумма";
        String email = "E-mail для отправки чека";
        return new Object[][]{
                {"phone", "Номер телефона", sum, email},
                {"internet", "Номер абонента", sum, email},
                {"instalment", "Номер счета на 44", sum, email},
                {"arrears", "Номер счета на 2073", sum, email}
        };
    }
}
