package com.automationexercise.pages;

import com.automationexercise.helpers.SecretManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    //Locators
    private final By cookieAggryButtonLocator = By.xpath("//button[@aria-label='Consent']");
    private final By logoLocator = By.xpath("//img[contains(@src,'logo.png')]");
    private final By categoryLocator = By.xpath("//div[@class='left-sidebar']/h2[text()='Category']");
    private final By womanCategoryLocator = By.xpath("//div[@class='left-sidebar']//a[@href='#Women']");
    private final By dressLinkInWomanCategoryLocator = By.xpath("//div[@id='Women']//a[contains(text(), 'Dress')]");

    //Methods
    public HomePage openHomePage() {
        driver.get(SecretManager.get("BASE_URL"));
        if (!driver.findElements(cookieAggryButtonLocator).isEmpty()) {
            clickConsentButton();
        }
        return this;
    }

    public HomePage clickConsentButton() {
        click(cookieAggryButtonLocator);
        return this;
    }

    public HomePage assertHomePageIsSuccessfullyLoaded() {
        waitUntilVisibilityOfElementLocated(logoLocator);
        removeAds();
        waitUntilUrlToBe(SecretManager.get("BASE_URL"));
        return this;
    }

    public HomePage assertCategoriesAreVisible() {
        waitUntilVisibilityOfElementLocated(categoryLocator);
        return this;
    }

    public HomePage clickOnWomanCategory() {
        click(womanCategoryLocator);
        return this;
    }

    public CategoryProductsPage clickOnDressInWomanCategory() {
        click(dressLinkInWomanCategoryLocator);
        return new CategoryProductsPage(driver);
    }
}