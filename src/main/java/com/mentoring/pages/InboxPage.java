package com.mentoring.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.mentoring.driver.DriverUtils.getDriver;
import static com.mentoring.driver.WaitUtils.waitFor;

public class InboxPage extends BasePage {

    private static final By FIRST_EMAIL_SUBJECT = By.cssSelector("span.bog");

    public void clickOnComposeEmailButton() {
        By composeEmailButton = By.xpath("//div[@class='T-I T-I-KE L3']");
        clickOnElementLocated(composeEmailButton);
    }

    public void fillEmailRecipientInputField(String email) {
        By emailRecipientField = By.xpath("//textarea[@name='to']");
        fillInputWithText(emailRecipientField, email);
    }

    public void fillEmailSubjectInputField(String subject) {
        By emailSubjectField = By.xpath("//input[@name='subjectbox']");
        fillInputWithText(emailSubjectField, subject);
    }

    public void fillEmailContentTextarea(String content) {
        By emailContentTextarea = By.xpath("//div[@role='textbox']");
        fillInputWithText(emailContentTextarea, content);
    }

    public void clickOnSendEmailButton() {
        WebElement sendEmailButton = getDriver().findElement(By.xpath("//div[@class = 'T-I J-J5-Ji aoO v7 T-I-atl L3']"));

        Actions clickOnButtonAction = new Actions(getDriver());
        clickOnButtonAction.moveToElement(sendEmailButton).click().build().perform();
    }

    public String getSubjectOfFirstEmail() {
        return waitFor(ExpectedConditions.visibilityOfElementLocated(FIRST_EMAIL_SUBJECT)).getText();
    }

    public void openFirstEmailFromInbox() {
        clickOnElementLocated(FIRST_EMAIL_SUBJECT);
    }

    public String getTextOfFirstEmail() {
        By letterText = By.xpath("//div[@role='listitem']//div[@dir='ltr']");

        return waitFor(ExpectedConditions.visibilityOfElementLocated(letterText)).getText();
    }
}
