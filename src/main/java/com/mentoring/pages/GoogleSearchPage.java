package com.mentoring.pages;

import driver.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static driver.DriverUtils.getDriver;

public class GoogleSearchPage extends BasePage {

    private By GoogleApps = By.xpath("//a[@class='gb_D']");

    public void searchFor(String searchQuery) {
        By searchField = By.xpath("//input[@type='text']");
        fillInputWithText(searchField, searchQuery);
    }

    public void clickGoogleAppsButton() {
        WaitUtils.waitForVisibilityOfElementLocated(GoogleApps);
        clickOnElementLocated(GoogleApps);
        WaitUtils.waitForElementToBeExpanded(GoogleApps);
    }

    public void clickLoginButton() {
        By loginButton = By.xpath("//a[@class='gb_4 gb_5 gb_ae gb_4c']");
        WaitUtils.waitForVisibilityOfElementLocated(loginButton);
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
        WaitUtils.waitForVisibilityOfElementLocated(passwordField);
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
