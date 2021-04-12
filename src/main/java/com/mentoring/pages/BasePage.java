package com.mentoring.pages;

import static driver.DriverUtils.getDriver;

public class BasePage {

    public String getPageTitle() {
        return getDriver().getTitle();
    }

}
