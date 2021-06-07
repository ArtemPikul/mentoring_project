package com.mentoring;

import com.mentoring.pages.GoogleResultsPage;
import com.mentoring.pages.GoogleSearchPage;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.mentoring.core.ConciseAPI.getPageTitle;
import static com.mentoring.core.ConciseAPI.visit;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchSeleniumAndVerifyResultsTest extends BaseTest {

    private static final String GOOGLE_URL = "https://www.google.com/";
    private static final String SEARCH_QUERY = "selenium";

    GoogleSearchPage googleSearchPage = new GoogleSearchPage();
    GoogleResultsPage googleResultsPage = new GoogleResultsPage();

    @Test
    public void testVerifySearchReturnsResults() {

        int expectedResultsAmount = 8;

        visit(GOOGLE_URL);
        googleSearchPage.searchFor(SEARCH_QUERY);

        String firstSearchResultTitle = googleResultsPage.getFirstSearchResultTitle();
        int numberOfSearchResults = googleResultsPage.getNumberOfSearchResults();

        assertEquals(expectedResultsAmount, numberOfSearchResults,
                "The actual result amount is not equal to the expected");
        assertTrue(firstSearchResultTitle.toLowerCase().contains(SEARCH_QUERY),
                "The first search result doesn't contain the search query");
    }

    @Test
    public void testVerifyTheTitleOfTheFirstResultPage() {

        visit(GOOGLE_URL);
        googleSearchPage.searchFor(SEARCH_QUERY);
        googleResultsPage.clickFirstResultLink();

        String expectedTitle = "Что такое Selenium? / Хабр";

        assertEquals(expectedTitle, getPageTitle(),
                "The actual title doesn't match the expected");
    }

    @Test
    public void testVerifyThatEachSearchResultContainsSearchQuery() {

        visit(GOOGLE_URL);
        googleSearchPage.searchFor(SEARCH_QUERY);
        List<String> searchResultsList = googleResultsPage.getListOfSearchResultsLinksText();

        assertTrue(searchResultsList.stream().allMatch(x -> x.toLowerCase().contains(SEARCH_QUERY)),
                "Not all of the search results contain the search query");
    }

    @Test
    public void testVerifyThatEachSearchResultDoesntContainWrongSearchQuery() {

        String wrongSearchQuery = "seeleniuum";

        visit(GOOGLE_URL);
        googleSearchPage.searchFor(SEARCH_QUERY);
        List<String> searchResultsList = googleResultsPage.getListOfSearchResultsLinksText();

        assertTrue(searchResultsList.stream().noneMatch(x -> x.toLowerCase().contains(wrongSearchQuery)),
                "There is a search result which contains wrong search query");
    }
}
