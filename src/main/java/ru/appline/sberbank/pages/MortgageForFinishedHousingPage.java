package ru.appline.sberbank.pages;

import io.qameta.allure.*;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.appline.sberbank.entity.Form;
import ru.appline.sberbank.managers.DriverManager;


/**
 * Страница готовое жилье
 */
public class MortgageForFinishedHousingPage extends BasePage {

    private int k = 0;

    @FindBy(xpath = "//h2[text()='\u200BРассчитайте ипотеку']")
    private WebElement formName;

    @FindBy(xpath = "//div[contains(text(),'Дополнительные услуги')]")
    private WebElement additionalServicesLabel;

    @FindBy(xpath = "//div[@data-label='Стоимость недвижимости']/input")
    private WebElement priceElement;

    @FindBy(xpath = "//div[@data-label='Первоначальный взнос']/input")
    private WebElement anInitialFeeElement;

    @FindBy(xpath = "//div[@data-label='Срок кредита']/input")
    private WebElement creditTermElement;

    @FindBy(xpath = "//input[@data-e2e-id='mland-calculator/discount-item-2-switcher']")
    private WebElement lifeInsuranceElement;

    @FindBy(xpath = "//input[@data-e2e-id='mland-calculator/discount-item-6-switcher']")
    private WebElement youngFamilyElement;

    @FindBy(xpath = "//button[text()='Закрыть']")
    private WebElement buttonClose;

    @FindBy(xpath = "//span[@data-e2e-id='mland-calculator/medium-result-monthly-payment']")
    private WebElement monthlyPayment;

    @FindBy(xpath = "//span[@data-e2e-id='mland-calculator/medium-result-credit-sum']")
    private WebElement sumCredit;

    @FindBy(xpath = "//span[@data-e2e-id='mland-calculator/medium-result-required-income']")
    private WebElement income;

    @FindBy(xpath = "//span[@data-e2e-id='mland-calculator/medium-result-credit-rate']")
    private WebElement interestRate;


    /**
     * заполняет форму дефолтными значениями
     *
     * @return
     * @throws InterruptedException
     */
    @Step("Заполнение формы")
    public MortgageForFinishedHousingPage insertForm() throws InterruptedException {
        Form form = Form.getForm();
        insert(form);
        return this;
    }

    /**
     * заполняет форму кастомными значениями
     *
     * @param price         - цена
     * @param anInitialFee  - первоначальный взнос
     * @param creditTerm    - срок кредита
     * @param lifeInsurance - страховка жизни (значения true/false)
     * @param youngFamily   - молодая семья (значения true/false)
     * @return
     * @throws InterruptedException
     */
    public MortgageForFinishedHousingPage insertForm(String price, String anInitialFee, String creditTerm, String lifeInsurance, String youngFamily) throws InterruptedException {
        Form form = Form.getForm();
        form.setPrice(price);
        form.setAnInitialFee(anInitialFee);
        form.setCreditTerm(creditTerm);
        form.setLifeInsurance(lifeInsurance);
        form.setYoungFamily(youngFamily);
        insert(form);
        return this;
    }

    public MortgageForFinishedHousingPage insertForm(String fieldName, String value) throws InterruptedException {
        if (k == 0){
            setup();
        }
        switch (fieldName){
            case "цена":
                clearElementAndInsert(priceElement, value);
                break;
            case "первоначальный взнос":
                clearElementAndInsert(anInitialFeeElement, value);
                break;
            case "срок кредитования":
                clearElementAndInsert(creditTermElement, value);
                break;
            case "страхование жизни":
                checkSwitcher(lifeInsuranceElement, value);
                break;
            case "молодая семья":
                checkSwitcher(youngFamilyElement, value);
                break;
            default:
                Assert.fail("Форма не содержет поля '" + fieldName + "'");
        }
        return this;
    }

    /**
     * внутренний класс для заполнения формы
     *
     * @param form - данные для заполнения
     * @throws InterruptedException
     */
    private void insert(Form form) throws InterruptedException {
//        buttonClose.click();
//        scrollToElement(formName);
//        DriverManager.getDriver().switchTo().frame("iFrameResizer0");
        clearElementAndInsert(priceElement, form.getPrice());
        clearElementAndInsert(anInitialFeeElement, form.getAnInitialFee());
        clearElementAndInsert(creditTermElement, form.getCreditTerm());
        checkSwitcher(lifeInsuranceElement, form.getLifeInsurance());
        checkSwitcher(youngFamilyElement, form.getYoungFamily());


    }

    /**
     * внутренний класс для заполнения инпутов формы
     *
     * @param webElement
     * @param value
     * @throws InterruptedException
     */
    private void clearElementAndInsert(WebElement webElement, String value) throws InterruptedException {
        Thread.sleep(500);
        webElement.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        webElement.sendKeys((Keys.BACK_SPACE));
        webElement.sendKeys(value);
    }

    /**
     * внутренний класс для установки состояния переключаателей
     *
     * @param webElement
     * @param formElement
     */
    private void checkSwitcher(WebElement webElement, String formElement) {
        scrollToElement(webElement);
        if (!formElement.equals(webElement.getAttribute("aria-checked")))
            webElement.click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Проверки
     *
     * @throws InterruptedException
     */
    public void check() throws InterruptedException {
        Thread.sleep(1000); //элемент меняется динамически, не придумал как отследить.
        Assert.assertEquals("Проверка поля ежемесячный платеж", "16 017 ₽", monthlyPayment.getText());
        Assert.assertEquals("Проверка поля сумма кредита", "2 122 000 ₽", sumCredit.getText());
        Assert.assertEquals("Проверка поля необходимый доход", "20 618 ₽", income.getText());
        Assert.assertEquals("Проверка поля процентная ставка", "11%", interestRate.getText());
    }

    private void setup(){
        buttonClose.click();
        scrollToElement(formName);
        DriverManager.getDriver().switchTo().frame("iFrameResizer0");
        k = 1;
    }

    public void check(String fieldName, String param) {
        switch (fieldName) {
            case "ежемесячный платеж":
                Assert.assertEquals("Проверка поля ежемесячный платеж", "16 017 ₽", monthlyPayment.getText());
                break;
            case "сумма кредита":
                Assert.assertEquals("Проверка поля сумма кредита", "2 122 000 ₽", sumCredit.getText());
                break;
            case "необходимый доход":
                Assert.assertEquals("Проверка поля необходимый доход", "20 618 ₽", income.getText());
                break;
            case "процентная ставка":
                Assert.assertEquals("Проверка поля процентная ставка", "11%", interestRate.getText());
                break;
            default:
                Assert.fail("Поле с наименованием '" + fieldName + "' не найдено");
        }

    }


}
