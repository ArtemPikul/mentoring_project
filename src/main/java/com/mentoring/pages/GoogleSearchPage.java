package com.mentoring.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import static driver.DriverUtils.getDriver;

public class GoogleSearchPage extends BasePage {

    public void searchForQuery(String searchQuery) {

        WebElement searchField = getDriver().findElement(By.xpath("//input[@type='text']"));
        searchField.sendKeys(searchQuery, Keys.ENTER);

    }

}
