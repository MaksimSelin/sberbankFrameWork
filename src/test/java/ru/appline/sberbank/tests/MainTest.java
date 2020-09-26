package ru.appline.sberbank.tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.Test;

public class MainTest extends Setup {

    @Epic("Тест для сбербанк ипотека")
    @Feature(value = "Тест ипотеки для готового жилья")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void scenario() throws InterruptedException {
        app.getStartPage()
                .clickMortgage()
                .clickMortgageForFinishedHousing()
                .insertForm()
                .check();

    }

}
