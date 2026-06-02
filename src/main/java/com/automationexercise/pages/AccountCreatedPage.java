package com.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountCreatedPage extends BasePage {
    public AccountCreatedPage(WebDriver driver) {
        super(driver);
    }

    // Locators
    private final By accountCreatedTextLocator = By.xpath("//h2[@data-qa='account-created']");
    private final By continueButtonLocator = By.xpath("//a[@data-qa='continue-button']");

    // Methods
    public AccountCreatedPage assertAccountCreatedPageIsSuccessfullyLoaded() {
        waitUntilVisibilityOfElementLocated(accountCreatedTextLocator);
        return this;
    }

    public HomePage clickContinueButton() {
        javaScriptClick(continueButtonLocator);
        return new HomePage(driver);
    }
}