package ru.appline.sberbank.tests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import ru.appline.sberbank.managers.DriverManager;
import ru.appline.sberbank.managers.InitManager;
import ru.appline.sberbank.managers.PageManager;
import ru.appline.sberbank.managers.PropManager;

import java.util.concurrent.TimeUnit;

public class Setup {

    PageManager app = PageManager.getPageManager();

    @BeforeClass
    public static void setup() {
        InitManager.initFramework();
    }

    @Before
    public void start() {
        DriverManager.getDriver().get(PropManager.getPropManager().getProperty("app.url"));
    }

    @AfterClass
    public static void close() {
        DriverManager.quitDriver();
    }
}
