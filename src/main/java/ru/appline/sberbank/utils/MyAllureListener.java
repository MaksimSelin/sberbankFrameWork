package ru.appline.sberbank.utils;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ru.appline.sberbank.managers.DriverManager;

/**
 * Настройка скриншотов
 */
public class MyAllureListener {

    @Attachment(value = "Error_screenshot", type = "image/png")
    public static byte[] addScreenshot(){
        return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
    }

}