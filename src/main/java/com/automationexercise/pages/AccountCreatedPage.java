package com.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
        // 1. Спочатку пробуємо клікнути твоїм стандартним методом
        click(continueButtonLocator);

        // 2. Перевіряємо, чи ми не застрягли в рекламному "капкані"
        if (driver.getCurrentUrl().contains("#google_vignette")) {
            System.out.println("Виявлено повноекранну рекламу. Робимо примусовий перехід.");
            // Просто переходимо за прямим посиланням на головну
            driver.get("https://www.automationexercise.com/");
        }

        return new HomePage(driver);
    }
}