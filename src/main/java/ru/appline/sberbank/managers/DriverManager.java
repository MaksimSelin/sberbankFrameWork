package ru.appline.sberbank.managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {

    private static WebDriver driver;

    private DriverManager(){

    }

    public static WebDriver getDriver(){
        if (driver == null){
            System.setProperty("webdriver.chrome.driver", PropManager.getPropManager().getProperty("path.chrome.driver"));
            driver = new ChromeDriver();
        }
        return driver;
    }

    public static void quitDriver(){
        driver.quit();
        driver = null;
    }
}
