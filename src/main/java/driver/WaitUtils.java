package driver;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static driver.DriverUtils.getDriver;

public class WaitUtils {

    public static void waitForPageReadyState(long timeout) {
        new WebDriverWait(getDriver(), timeout).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    public static void waitForElementVisibility(long timeout, WebElement element) {
        WebDriverWait wait = new WebDriverWait(getDriver(), timeout);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void implicitlyWait(long timeout) {
        getDriver().manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
    }

}
