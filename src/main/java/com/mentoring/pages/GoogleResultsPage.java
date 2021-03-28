package com.mentoring.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static driver.DriverUtils.getDriver;

public class GoogleResultsPage extends BasePage {

    public List<WebElement> getListOfSearchResults() {

        List<WebElement> listOfSearchResults = getDriver().findElements(By.xpath("//a/h3"));
        return listOfSearchResults;

    }

}
