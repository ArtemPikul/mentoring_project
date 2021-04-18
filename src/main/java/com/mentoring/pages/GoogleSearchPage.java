package com.mentoring.pages;

import driver.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import static driver.DriverUtils.getDriver;

public class GoogleSearchPage extends BasePage {

    private By GoogleApps = By.xpath("//a[@class='gb_D']");

    public void searchFor(String searchQuery) {

        WebElement searchField = getDriver().findElement(By.xpath("//input[@type='text']"));
        searchField.sendKeys(searchQuery, Keys.ENTER);

    }

    public void clickGoogleAppsButton() {
        WaitUtils.waitForVisibilityOfElementLocated(GoogleApps);
        clickOnElementLocated(GoogleApps);
        WaitUtils.waitForElementToBeExpanded(GoogleApps);
    }

    public void clickLoginButton() {
        WebElement loginButton = getDriver().findElement(By.xpath("//a[@class='gb_4 gb_5 gb_ae gb_ce gb_4c']"));
        loginButton.click();
    }

    public void loginIntoGoogleAccountWithCredentials(String email, String password) {
        WebElement emailField = getDriver().findElement(By.id("identifierId"));
        emailField.sendKeys(email);

        WebElement emailNextButton = getDriver().findElement(By.xpath("//button[@class='VfPpkd-LgbsSe VfPpkd-LgbsSe-OWXEXe-k8QpJ VfPpkd-LgbsSe-OWXEXe-dgl2Hf nCP5yc AjY5Oe DuMIQc qIypjc TrZEUc lw1w4b']"));
        WaitUtils.waitForElementToBeClickable(emailNextButton);
        emailNextButton.click();
        WaitUtils.waitForVisibilityOfElementLocated(By.xpath("//input[@name='password']"));

        WebElement passwordField = getDriver().findElement(By.xpath("//input[@name='password']"));
        passwordField.sendKeys(password);

        WebElement passwordNextButton = getDriver().findElement(By.id("passwordNext"));
        WaitUtils.waitForElementToBeClickable(passwordNextButton);
        passwordNextButton.click();
        WaitUtils.waitForPageReadyState();
    }

    public void switchToGmailFromGoogleAppsMenu() {
        WaitUtils.waitForPageReadyState();
        getDriver().switchTo().frame(0);
        By gmailIcon = By.xpath("//a[@href='https://mail.google.com/mail/']");
        clickOnElementLocated(gmailIcon);
        getDriver().switchTo().defaultContent();
    }

}
