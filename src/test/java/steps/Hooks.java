package steps;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import ru.appline.sberbank.managers.DriverManager;
import ru.appline.sberbank.managers.InitManager;

public class Hooks {


    @Before
    public void start() {
        InitManager.initFramework();
    }

    @After
    public static void close() {
        DriverManager.quitDriver();
    }
}

