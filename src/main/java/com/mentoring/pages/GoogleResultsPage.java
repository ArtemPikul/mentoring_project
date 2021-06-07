package com.mentoring.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static com.mentoring.driver.DriverUtils.getDriver;

public class GoogleResultsPage extends BasePage {

    public List<WebElement> getListOfSearchResults() {

        List<WebElement> listOfSearchResults = getDriver().findElements(By.xpath("//a/h3"));
        return listOfSearchResults;

    }

    public String getFirstSearchResultTitle() {

        return getListOfSearchResults().get(0).getText();

    }

    public int getNumberOfSearchResults() {

        return getListOfSearchResults().size();

    }

    public void clickFirstResultLink() {

        List<WebElement> listOfSearchResults = getDriver().findElements(By.xpath("//a/h3"));
        listOfSearchResults.get(0).click();

    }

    public List<String> getListOfSearchResultsLinksText() {

        List<String> listOfSearchResultsLinksText = new ArrayList<>();

        for (WebElement element : getListOfSearchResults()) {
            listOfSearchResultsLinksText.add(element.getText());
        }

        return listOfSearchResultsLinksText;
    }
}
