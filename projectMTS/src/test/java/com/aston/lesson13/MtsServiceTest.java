package com.aston.lesson13;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MtsServiceTest extends BaseTest{

    @Test(description = "Проверка названия модуля онлайн-оплаты")
    public void isModuleNameTest() {
        getPaymentModule().checkModuleName();
    }

    @Test(description = "Прорерка отображения логотипов в модуле онлайн-оплаты")
    public void isLogoDisplayedTest() {
        getPaymentModule().logoPresence();
    }

    @Test(description = "Проверка работы ссылки")
    void isLinkWorks() {
        getPaymentModule().linkWorks();
    }

    @Test(description = "Проверка работы кнопки", priority = 3, dataProvider = "button")
    void isButtonWorks(String number, String payment) {
        getPaymentModule().buttonClick(number,payment);
    }

    @DataProvider
    public Object[][] button() {
        return new Object[][]{
                {"297777777", "100"}
        };
    }
}

