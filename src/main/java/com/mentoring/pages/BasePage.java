package com.mentoring.pages;

import org.openqa.selenium.By;

import static driver.DriverUtils.getDriver;

public class BasePage {

    public String getPageTitle() {
        return getDriver().getTitle();
    }

    public void clickOnElementLocated(By locator) {
        getDriver().findElement(locator).click();
    }

}
