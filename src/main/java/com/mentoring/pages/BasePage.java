package com.mentoring.pages;

import driver.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static driver.DriverUtils.getDriver;

public class BasePage {

    public String getPageTitle() {
        return getDriver().getTitle();
    }

    public void clickOnElementLocated(By locator) {
        getDriver().findElement(locator).click();
    }

    public void visit(String link) {
        getDriver().get(link);
    }

    public void fillInputWithText(By locator, String text) {
        WaitUtils.waitForVisibilityOfElementLocated(locator);
        WebElement element = getDriver().findElement(locator);
        element.sendKeys(text);
    }
}
