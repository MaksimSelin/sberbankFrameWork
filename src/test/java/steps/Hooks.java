package steps;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import static io.qameta.allure.Allure.getLifecycle;
import ru.appline.sberbank.managers.DriverManager;
import ru.appline.sberbank.managers.InitManager;
import ru.appline.sberbank.utils.MyAllureListener;

public class Hooks {


    @Before
    public void start() {
        InitManager.initFramework();
    }

    @After
    public static void close(Scenario scenario) {
        if (scenario.isFailed()) {
            getLifecycle().addAttachment("Скриншот","image/png",null, MyAllureListener.addScreenshot());
        }
        DriverManager.quitDriver();
    }
}

