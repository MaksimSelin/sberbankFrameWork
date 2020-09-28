package steps;

import io.cucumber.datatable.DataTable;
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
    public void insertForm(DataTable dataTable) {
//        app.getMortgageForFinishedHousingPage().insertForm();
        dataTable.cells().forEach(row -> {
            try {
                app.getMortgageForFinishedHousingPage().insertForm(row.get(0), row.get(1) );
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

//    @Then("^Проверка полей$")
//    public void checkField() throws InterruptedException {
//        app.getMortgageForFinishedHousingPage().check();
//    }

    @Then("^Проверка полей$")
    public void checkField(DataTable dataTable){
        dataTable.cells().forEach(row ->app.getMortgageForFinishedHousingPage().check(row.get(0), row.get(1)));
    }



}
