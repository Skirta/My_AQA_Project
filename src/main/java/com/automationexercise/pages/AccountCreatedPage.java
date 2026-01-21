package com.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountCreatedPage extends BasePage {
    public AccountCreatedPage(WebDriver driver) {
        super(driver);
    }

    // Locators
    private final By accountCreatedTextLocator = By.xpath("//h2[@data-qa='account-created']");
    private final By clickContinueButtonLocator = By.xpath("//a[@data-qa='continue-button']");

    // Methods
    public AccountCreatedPage assertAccountCreatedPageIsSuccessfullyLoaded() {
        click(accountCreatedTextLocator);
        return this;
    }

    public HomePage clickContinueButton() {
        click(clickContinueButtonLocator);
        return new HomePage(driver);
    }
}