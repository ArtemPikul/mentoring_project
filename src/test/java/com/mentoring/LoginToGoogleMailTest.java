package com.mentoring;

import com.mentoring.pages.GoogleSearchPage;
import org.junit.jupiter.api.Test;

import static com.mentoring.core.ConciseAPI.visit;
import static com.mentoring.core.Configuration.EMAIL_ADDRESS;
import static com.mentoring.core.Configuration.EMAIL_PASSWORD;

public class LoginToGoogleMailTest extends BaseTest {

    private static final String GOOGLE_URL = "https://www.google.com/";

    GoogleSearchPage googleSearchPage = new GoogleSearchPage();

    @Test
    public void testVerifyLoginToGoogleMail() {

        visit(GOOGLE_URL);
        googleSearchPage.clickLoginButton();
        googleSearchPage.fillEmailInputField(EMAIL_ADDRESS);
        googleSearchPage.fillPasswordInputField(EMAIL_PASSWORD);
        googleSearchPage.clickGoogleAppsButton();
        googleSearchPage.switchToGmailFromGoogleAppsMenu();
    }
}
