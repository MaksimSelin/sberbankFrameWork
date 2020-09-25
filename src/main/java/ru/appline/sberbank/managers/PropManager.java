package ru.appline.sberbank.managers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropManager {

    private final Properties properties = new Properties();

    private static PropManager propManager;

    private PropManager(){
        try {
            properties.load(new FileInputStream(new File("src/main/resources/prop.properties")));
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public static PropManager getPropManager(){
        if (propManager == null)
            propManager = new PropManager();
        return propManager;
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    public String getProperty (String key, String defaultValue){
        return properties.getProperty(key, defaultValue);
    }

}
