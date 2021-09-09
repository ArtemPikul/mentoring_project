package com.mentoring.driver;

import com.mentoring.core.Configuration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

import static com.mentoring.driver.DriverUtils.getDriver;

public class WaitUtils {

    public static <T> T waitFor(ExpectedCondition<T> condition, Duration timeout, Duration polling) {
        return new FluentWait<>(getDriver())
                .withTimeout(timeout)
                .pollingEvery(polling)
                .ignoring(WebDriverException.class, IndexOutOfBoundsException.class)
                .until(condition);
    }

    public static <T> T waitFor(ExpectedCondition<T> condition) {
        return waitFor(condition, Configuration.WAIT_TIMEOUT, Configuration.WAIT_POLLING_INTERVAL);
    }
}
