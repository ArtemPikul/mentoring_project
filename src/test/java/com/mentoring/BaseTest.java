package com.mentoring;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.mentoring.driver.DriverUtils.getDriver;
import static com.mentoring.driver.DriverUtils.setDriver;


public class BaseTest {

    @BeforeAll
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        setDriver(new ChromeDriver());
        getDriver().manage().window().maximize();
    }

    @AfterAll
    public static void tearDown() {
        getDriver().quit();
    }

}
