package ru.appline.sberbank.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.appline.sberbank.managers.PageManager;

/**
 * Стартовая страница
 */
public class StartPage extends BasePage{

    @FindBy(xpath = "//label[text()='Ипотека']")
    private WebElement mortgage ;

    @FindBy(xpath = "//a[text()='Ипотека на готовое жильё']")
    private WebElement mortgageForFinishedHousing;




    @Step("Открытие выпадающего меню 'Ипотека'")
   public StartPage clickMortgage(){
        mortgage.click();
        return this;
   }

   @Step("Клик по ссылке Ипотека на готовое жильё")
   public MortgageForFinishedHousingPage clickMortgageForFinishedHousing(){
        mortgageForFinishedHousing.click();
        return PageManager.getMortgageForFinishedHousingPage();
    }
}
