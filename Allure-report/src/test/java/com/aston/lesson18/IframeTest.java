package com.aston.lesson18;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class IframeTest extends BaseTest {
    private final String NUMBER = "297777777";
    private final String PAYMENT = "100";
    private final List<String> LOGO_LIST = List.of("mastercard", "visa", "belkart", "mir", "maestro");
    private final List<String> TITLE_FIELD = List.of(PAYMENT + ".00 BYN", "Оплата: Услуги связи Номер:375" + NUMBER,
            "Номер карты", "Срок действия", "Имя держателя (как на карте)", "CVC", "Оплатить " + PAYMENT + ".00 BYN");

    @Test(description = "Проверка информации о логотипах в iFrame", dataProvider = "logosInfo")
    public void checkLogoTest(String number, String payment, int amount, List<String> logoname) {

        Iframe iFrame = getPaymentModule().sendParametersAndButtonClick(number, payment);

        Assert.assertEquals(iFrame.getListLogosName().size(), amount,
                "Ошибка в количестве логотипов");

        iFrame.closeIFrame();
    }

    @DataProvider
    public Object[][] logosInfo() {
        return new Object[][]{
                {NUMBER, PAYMENT, 5, LOGO_LIST}
        };
    }

    @Test(description = "Проверка поля информации", dataProvider = "fieldInformation")
    void checkFieldInformationTest(String number, String payment, List<String> expected) {

        Iframe iFrame = getPaymentModule().sendParametersAndButtonClick(number, payment);

        List<String> actualField = iFrame.getListPlaceholderName();

        for (int i = 0; i < actualField.size(); i++) {
            Assert.assertEquals(iFrame.getListPlaceholderName().get(i), expected.get(i),
                    "Ошибка в названии поля");
        }
        iFrame.closeIFrame();
    }

    @DataProvider
    public Object[][] fieldInformation() {
        return new Object[][]{
                {NUMBER, PAYMENT, TITLE_FIELD}
        };
    }
}