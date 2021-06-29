package com.mentoring.driver;

import com.mentoring.core.Configuration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class WaitUtils {

    public static void waitForVisibilityOfElementLocated(By locator) {
        FluentWait wait = new FluentWait<>(DriverUtils.getDriver())
                .withTimeout(Configuration.WAIT_TIMEOUT)
                .pollingEvery(Configuration.WAIT_POLLING_INTERVAL)
                .ignoring(WebDriverException.class);

        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void waitForElementToBeExpanded(By locator) {
        FluentWait wait = new FluentWait<>(DriverUtils.getDriver())
                .withTimeout(Configuration.WAIT_TIMEOUT)
                .pollingEvery(Configuration.WAIT_POLLING_INTERVAL)
                .ignoring(WebDriverException.class);

        wait.until(ExpectedConditions.attributeToBe(locator, "aria-expanded", "true"));
    }

    public static void waitForElementToBeClickable(By locator) {
        FluentWait wait = new FluentWait<>(DriverUtils.getDriver())
                .withTimeout(Configuration.WAIT_TIMEOUT)
                .pollingEvery(Configuration.WAIT_POLLING_INTERVAL)
                .ignoring(WebDriverException.class);

        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
}
