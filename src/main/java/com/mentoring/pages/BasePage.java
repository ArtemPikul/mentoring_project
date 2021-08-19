package com.mentoring.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.mentoring.driver.WaitUtils.waitFor;

public class BasePage {

    public void clickOnElementLocated(By locator) {
        waitFor(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public void fillInputWithText(By locator, String text) {
        waitFor(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(text);
    }
}
