package com.mentoring;

import com.mentoring.pages.GoogleResultsPage;
import com.mentoring.pages.GoogleSearchPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import java.util.List;

import static driver.DriverUtils.getDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchSeleniumAndVerifyResultsTest extends BaseTest {

    private static final String GOOGLE_URL = "https://www.google.com/";
    private static final String SEARCH_QUERY = "selenium";

    GoogleSearchPage googleSearchPage = new GoogleSearchPage();
    GoogleResultsPage googleResultsPage = new GoogleResultsPage();

    @BeforeEach
    public void googlePageSetUp() {
        getDriver().get(GOOGLE_URL);
    }

    @Test
    public void checkThatSearchWorksAndReturnsResults() {

        int expectedResultsAmount = 8;
        googleSearchPage.searchForQuery(SEARCH_QUERY);
        List<WebElement> listOfSearchResults = googleResultsPage.getListOfSearchResults();

        String firstSearchResultTitle = listOfSearchResults.get(0).getText();

        assertEquals(expectedResultsAmount, listOfSearchResults.size(),
                "The actual result amount is not equal to the expected");
        assertTrue(firstSearchResultTitle.toLowerCase().contains(SEARCH_QUERY),
                "The first search result doesn't contain the search query");

    }

    @Test
    public void verifyTheTitleOfTheFirstSearchResultPage() {

        googleSearchPage.searchForQuery(SEARCH_QUERY);
        List<WebElement> listOfSearchResults = googleResultsPage.getListOfSearchResults();
        listOfSearchResults.get(0).click();

        String expectedTitle = "Что такое Selenium? / Хабр";

        assertEquals(expectedTitle, getDriver().getTitle(),
                "The actual title doesn't match the expected");

    }

    @Test
    public void verifyThatEachSearchResultContainsSearchQuery() {

        googleSearchPage.searchForQuery(SEARCH_QUERY);
        List<WebElement> listOfSearchResults = googleResultsPage.getListOfSearchResults();

        assertTrue(listOfSearchResults.stream().allMatch(x -> x.getText().toLowerCase().contains(SEARCH_QUERY)),
                "Not all of the search results contain the search query");

    }

    @Test
    public void verifyThatEachSearchResultDoesntContainWrongSearchQuery() {

        String wrongSearchQuery = "seeleniuum";

        googleSearchPage.searchForQuery(SEARCH_QUERY);
        List<WebElement> searchQueriesList = googleResultsPage.getListOfSearchResults();

        assertTrue(searchQueriesList.stream().noneMatch(x -> x.getText().toLowerCase().contains(wrongSearchQuery)),
                "There is a search result which contains wrong search query");

    }


}
