package com.mentoring.pages;

import driver.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import static driver.DriverUtils.getDriver;

public class GoogleSearchPage extends BasePage {

    public void searchFor(String searchQuery) {

        WebElement searchField = getDriver().findElement(By.xpath("//input[@type='text']"));
        searchField.sendKeys(searchQuery, Keys.ENTER);

    }

    public void clickGoogleAppsButton() {
        WebElement googleAppsButton = getDriver().findElement(By.xpath("//a[@aria-label='Приложения Google']"));
        googleAppsButton.click();
    }

    public void clickLoginButton() {
        WebElement loginButton = getDriver().findElement(By.xpath("//a[@class='gb_4 gb_5 gb_ae gb_ce gb_4c']"));
        loginButton.click();
    }

    public void loginIntoGoogleAccountWithCredentials(String email, String password) {
        WebElement emailField = getDriver().findElement(By.id("identifierId"));
        emailField.sendKeys(email);

        WebElement emailNextButton = getDriver().findElement(By.xpath("//button[@class='VfPpkd-LgbsSe VfPpkd-LgbsSe-OWXEXe-k8QpJ VfPpkd-LgbsSe-OWXEXe-dgl2Hf nCP5yc AjY5Oe DuMIQc qIypjc TrZEUc lw1w4b']"));
        WaitUtils.waitForElementToBeClickable(10, emailNextButton);
        emailNextButton.click();

        WebElement passwordField = getDriver().findElement(By.xpath("//div[@id='password']//input[@class='whsOnd zHQkBf']"));
        passwordField.sendKeys(password);

        WebElement passwordNextButton = getDriver().findElement(By.id("passwordNext"));
        WaitUtils.waitForElementToBeClickable(10, passwordNextButton);
        passwordNextButton.click();
        WaitUtils.waitForPageReadyState(10);
    }

    public void switchToGmailFromGoogleAppsMenu() {
        clickGoogleAppsButton();
        WebElement gmailAppIcon = getDriver().findElement(By.xpath("//a[@href='https://mail.google.com/mail/']"));
        gmailAppIcon.click();
    }

}
