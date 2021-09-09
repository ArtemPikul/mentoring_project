package com.mentoring.driver;

import org.openqa.selenium.WebDriver;

public class DriverUtils {

    private static WebDriver driver;

    public static void setDriver(WebDriver driver) {
        DriverUtils.driver = driver;
    }

    public static WebDriver getDriver() {
        return driver;
    }

}
