package driver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static core.Configuration.WAIT_TIMEOUT;
import static driver.DriverUtils.getDriver;

public class WaitUtils {

    public static void waitForPageReadyState() {
        new WebDriverWait(getDriver(), WAIT_TIMEOUT).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    public static void waitForElementVisibility(WebElement element) {
        WebDriverWait wait = new WebDriverWait(getDriver(), WAIT_TIMEOUT);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForVisibilityOfElementLocated(By locator) {
        WebDriverWait wait = new WebDriverWait(getDriver(), WAIT_TIMEOUT);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void waitForElementToBeClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(getDriver(), WAIT_TIMEOUT);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitForElementToBeExpanded(By locator) {
        WebDriverWait wait = new WebDriverWait(getDriver(), WAIT_TIMEOUT);
        wait.until(ExpectedConditions.attributeToBe(locator, "aria-expanded", "true"));
    }

}
