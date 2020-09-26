package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import ru.appline.sberbank.managers.PageManager;

public class Steps {

    private PageManager app = PageManager.getPageManager();


    @When("^Загрузка стартовой траницы$")
    public void initialTest(){
        app.getStartPage();
    }

    @When("^Клик по иконки Ипотека$")
    public void clickIpoteka(){
        app.getStartPage().clickMortgage();
    }

    @When("^Клик ипотека на готовое жилье$")
    public void clickIcon(){
        app.getStartPage().clickMortgageForFinishedHousing();
    }

    @When("^Заполнение формы$")
    public void insertForm() throws InterruptedException {
        app.getMortgageForFinishedHousingPage().insertForm();
    }

    @Then("^Проверка полей$")
    public void checkField() throws InterruptedException {
        app.getMortgageForFinishedHousingPage().check();
    }



}
