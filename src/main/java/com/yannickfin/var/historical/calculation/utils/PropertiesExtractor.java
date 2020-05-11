package com.yannickfin.var.historical.calculation.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesExtractor {

    public static final String CONFIDENCE_LEVEL_PROPERTY_NAME = "confidenceLevel";

    public static Properties getConfigurationProperty() {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();

        Properties appProps = new Properties();
        try {
            appProps.load(new FileInputStream(classLoader.getResource("configuration.properties").getFile()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return appProps;
    }
}
