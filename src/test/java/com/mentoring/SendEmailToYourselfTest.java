package com.mentoring;

import com.mentoring.pages.GoogleSearchPage;
import com.mentoring.pages.InboxPage;
import org.junit.jupiter.api.Test;

import static com.mentoring.core.ConciseAPI.visit;
import static com.mentoring.core.Configuration.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SendEmailToYourselfTest extends BaseTest {

    private static final String GOOGLE_URL = "https://www.google.com/";

    GoogleSearchPage googleSearchPage = new GoogleSearchPage();
    InboxPage inboxPage = new InboxPage();

    @Test
    public void testSendEmailToYourselfAndVerifyReceiving() {

        String emailContent = "This is the content of the email sent at: " + DATE_TODAY;

        visit(GOOGLE_URL);
        googleSearchPage.clickLoginButton();
        googleSearchPage.fillEmailInputField(EMAIL_ADDRESS);
        googleSearchPage.fillPasswordInputField(EMAIL_PASSWORD);
        googleSearchPage.clickGoogleAppsButton();
        googleSearchPage.switchToGmailFromGoogleAppsMenu();

        inboxPage.clickOnComposeEmailButton();
        inboxPage.fillEmailRecipientInputField(EMAIL_ADDRESS);
        inboxPage.fillEmailSubjectInputField(DATE_TODAY);
        inboxPage.fillEmailContentTextarea(emailContent);
        inboxPage.clickOnSendEmailButton();

        assertEquals(DATE_TODAY, inboxPage.getSubjectOfFirstEmail(),
                " The subject of the first letter is not as expected.");

        inboxPage.openFirstEmailFromInbox();

        assertEquals(emailContent, inboxPage.getTextOfFirstEmail(),
                "The content of the first letter is not as expected.");
    }
}
