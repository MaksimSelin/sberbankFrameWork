package ru.appline.sberbank.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import ru.appline.sberbank.managers.DriverManager;
import ru.appline.sberbank.managers.PageManager;
import ru.appline.sberbank.managers.PropManager;

import java.util.concurrent.TimeUnit;

public class Setup {

    PageManager app = PageManager.getPageManager();

    @BeforeClass
    public static void setup(){
        DriverManager.getDriver().manage().window().maximize();
        DriverManager.getDriver().manage().timeouts().implicitlyWait(Integer.parseInt(PropManager.getPropManager().getProperty("implicitly.Wait")), TimeUnit.SECONDS);
        DriverManager.getDriver().manage().timeouts().pageLoadTimeout(Integer.parseInt(PropManager.getPropManager().getProperty("page.Load.Timeout")), TimeUnit.SECONDS);
    }

    @Before
    public void start(){
        DriverManager.getDriver().get(PropManager.getPropManager().getProperty("app.url"));
    }

    @After
    public void close(){
        DriverManager.quitDriver();
    }
}
