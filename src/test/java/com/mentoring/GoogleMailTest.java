package com.mentoring;

import com.mentoring.pages.GoogleSearchPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static driver.DriverUtils.getDriver;

public class GoogleMailTest extends BaseTest {

    private static final String EMAIL_ADDRESS = "mentoring.test.email@gmail.com";
    private static final String EMAIL_PASSWORD = "Hard_Passw0rd";
    private static final String GOOGLE_URL = "https://www.google.com/";

    GoogleSearchPage googleSearchPage = new GoogleSearchPage();


    @BeforeEach
    public void googlePageSetUp() {
        getDriver().get(GOOGLE_URL);
    }

    @Test
    public void testVerifyLoginToGoogleMail() {

        googleSearchPage.clickLoginButton();
        googleSearchPage.loginIntoGoogleAccountWithCredentials(EMAIL_ADDRESS, EMAIL_PASSWORD);
        googleSearchPage.clickGoogleAppsButton();
        googleSearchPage.switchToGmailFromGoogleAppsMenu();
    }


}
