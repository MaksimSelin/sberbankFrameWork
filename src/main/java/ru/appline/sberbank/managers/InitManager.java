package ru.appline.sberbank.managers;

import java.util.concurrent.TimeUnit;

public class InitManager {

    public static void initFramework() {
        DriverManager.getDriver().manage().window().maximize();
        DriverManager.getDriver().manage().timeouts().implicitlyWait(Integer.parseInt(PropManager.getPropManager().getProperty("implicitly.Wait")), TimeUnit.SECONDS);
        DriverManager.getDriver().manage().timeouts().pageLoadTimeout(Integer.parseInt(PropManager.getPropManager().getProperty("page.Load.Timeout")), TimeUnit.SECONDS);
    }
}
