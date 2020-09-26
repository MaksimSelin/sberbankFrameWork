package ru.appline.sberbank.tests;

import org.junit.Test;

public class MainTest extends Setup {

    @Test
    public void scenario() throws InterruptedException {
        app.getStartPage()
                .clickMortgage()
                .clickMortgageForFinishedHousing()
                .insertForm()
                .check();

    }
}
