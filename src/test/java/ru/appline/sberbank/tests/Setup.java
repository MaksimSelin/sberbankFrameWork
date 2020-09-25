package ru.appline.sberbank.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import ru.appline.sberbank.managers.DriverManager;
import ru.appline.sberbank.managers.PageManager;

import java.util.concurrent.TimeUnit;

public class Setup {

    PageManager app = PageManager.getPageManager();

    @BeforeClass
    public static void setup(){
        DriverManager.getDriver().manage().window().maximize();
        DriverManager.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        DriverManager.getDriver().manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        DriverManager.getDriver().manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
    }

    @Before
    public void start(){
        DriverManager.getDriver().get("https://www.sberbank.ru/person");
    }

    @After
    public void close(){
        DriverManager.quitDriver();
    }
}
