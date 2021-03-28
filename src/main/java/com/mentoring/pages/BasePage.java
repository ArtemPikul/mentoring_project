package com.mentoring.pages;

import static driver.DriverUtils.getDriver;

public class BasePage {

    public String getTitleOfThePage() {
        return getDriver().getTitle();
    }

}
