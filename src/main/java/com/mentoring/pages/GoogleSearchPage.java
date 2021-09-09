package com.mentoring.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.mentoring.driver.DriverUtils.getDriver;
import static com.mentoring.driver.WaitUtils.waitFor;

public class GoogleSearchPage extends BasePage {

    private By GoogleApps = By.xpath("//a[@class='gb_C']");

    public void searchFor(String searchQuery) {
        By searchField = By.xpath("//input[@type='text']");
        fillInputWithText(searchField, searchQuery);
    }

    public void clickGoogleAppsButton() {
        clickOnElementLocated(GoogleApps);
        waitFor(ExpectedConditions.attributeToBe(GoogleApps, "aria-expanded", "true"));
    }

    public void clickLoginButton() {
        By loginButton = By.xpath("//a[@class='gb_3 gb_4 gb_9d gb_3c']");
        clickOnElementLocated(loginButton);
    }

    public void fillEmailInputField(String email) {
        By emailField = By.id("identifierId");
        fillInputWithText(emailField, email);

        By emailNextButton = By.xpath("//button[@class='VfPpkd-LgbsSe VfPpkd-LgbsSe-OWXEXe-k8QpJ VfPpkd-LgbsSe-OWXEXe-dgl2Hf nCP5yc AjY5Oe DuMIQc qIypjc TrZEUc lw1w4b']");
        clickOnElementLocated(emailNextButton);
    }

    public void fillPasswordInputField(String password) {
        By passwordField = By.xpath("//input[@name='password']");
        fillInputWithText(passwordField, password);

        By passwordNextButton = By.id("passwordNext");
        clickOnElementLocated(passwordNextButton);
    }

    public void switchToGmailFromGoogleAppsMenu() {
        getDriver().switchTo().frame(0);
        By gmailIcon = By.xpath("//a[@href='https://mail.google.com/mail/']");
        clickOnElementLocated(gmailIcon);
        getDriver().switchTo().defaultContent();
    }

}
