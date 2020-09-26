package ru.appline.sberbank.managers;

import ru.appline.sberbank.pages.MortgageForFinishedHousingPage;
import ru.appline.sberbank.pages.StartPage;

public class PageManager {

    private static PageManager pageManager;
    private static StartPage startPage;
    private static MortgageForFinishedHousingPage mortgageForFinishedHousingPage;


    private PageManager() {

    }

    public static PageManager getPageManager() {
        if (pageManager == null) {
            pageManager = new PageManager();
        }
        return pageManager;
    }

    public static StartPage getStartPage() {
        if (startPage == null) {
            startPage = new StartPage();
        }
        return startPage;
    }

    public static MortgageForFinishedHousingPage getMortgageForFinishedHousingPage() {
        if (mortgageForFinishedHousingPage == null) {
            mortgageForFinishedHousingPage = new MortgageForFinishedHousingPage();
        }
        return mortgageForFinishedHousingPage;
    }
}
