package com.mentoring.pages;

import com.mentoring.driver.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.mentoring.driver.DriverUtils.getDriver;

public class BasePage {

    public void clickOnElementLocated(By locator) {
        getDriver().findElement(locator).click();
    }

    public void fillInputWithText(By locator, String text) {
        WaitUtils.waitForVisibilityOfElementLocated(locator);
        WebElement element = getDriver().findElement(locator);
        element.sendKeys(text);
    }
}
