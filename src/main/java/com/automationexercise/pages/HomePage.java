package com.automationexercise.pages;

import com.automationexercise.helpers.SecretManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    private final By cookieAggryButtonLocator = By.xpath("//button[@aria-label='Consent']");
    private final By logoLocator = By.xpath("//img[contains(@src,'logo.png')]");



    public HomePage openHomePage() {
        driver.get(SecretManager.get("BASE_URL"));
        return this;
    }

    public HomePage clickConsentButton(){
        click(cookieAggryButtonLocator);
        return this;
    }

    public HomePage assertHomePageIsSuccessfullyLoaded() {
        waitUntilVisibilityOfElementLocated(logoLocator);
        removeAds();
        waitUntilUrlToBe("https://www.automationexercise.com/");
        return this;
    }
}