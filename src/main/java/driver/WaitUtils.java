package driver;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.util.NoSuchElementException;

import static core.Configuration.WAIT_POLLING_INTERVAL;
import static core.Configuration.WAIT_TIMEOUT;
import static driver.DriverUtils.getDriver;

public class WaitUtils {

    public static void waitForVisibilityOfElementLocated(By locator) {
        FluentWait wait = new FluentWait<>(getDriver())
                .withTimeout(WAIT_TIMEOUT)
                .pollingEvery(WAIT_POLLING_INTERVAL)
                .ignoring(NoSuchElementException.class, ElementNotVisibleException.class);

        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void waitForElementToBeExpanded(By locator) {
        FluentWait wait = new FluentWait<>(getDriver())
                .withTimeout(WAIT_TIMEOUT)
                .pollingEvery(WAIT_POLLING_INTERVAL)
                .ignoring(NoSuchElementException.class);

        wait.until(ExpectedConditions.attributeToBe(locator, "aria-expanded", "true"));
    }
}
