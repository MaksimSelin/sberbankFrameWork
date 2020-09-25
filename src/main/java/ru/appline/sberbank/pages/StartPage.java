package ru.appline.sberbank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.appline.sberbank.managers.PageManager;

public class StartPage extends BasePage{

    @FindBy(xpath = "//label[text()='Ипотека']")
    private WebElement mortgage ;

    @FindBy(xpath = "//a[text()='Ипотека на готовое жильё']")
    private WebElement mortgageForFinishedHousing;





   public StartPage clickMortgage(){
        click(mortgage);
        return this;
   }

   public MortgageForFinishedHousingPage clickMortgageForFinishedHousing(){
        click(mortgageForFinishedHousing);
        return PageManager.getMortgageForFinishedHousingPage();
    }
}
