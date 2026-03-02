package com.automationexercise.pages;

import com.automationexercise.helpers.SecretManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

import static org.assertj.core.api.Assertions.assertThat;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    //Locators
    private final By cookieAggryButtonLocator = By.xpath("//button[@aria-label='Consent']");
    private final By logoLocator = By.xpath("//img[contains(@src,'logo.png')]");
    private final By subscriptionInputLocator = By.id("susbscribe_email");
    private final By subscriptionButtonLocator = By.id("subscribe");
    private final By subscriptionMessageTextLocator = By.xpath("//div[@class='alert-success alert']");
    private final By subscriptionTextLocator = By.xpath("//div[@class='single-widget']/h2");

    //Methods
    public HomePage openHomePage() {
        driver.get(SecretManager.get("BASE_URL"));
        if (!driver.findElements(cookieAggryButtonLocator).isEmpty()){
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
        waitUntilUrlToBe("https://www.automationexercise.com/");
        return this;
    }

    public HomePage scrollDownPageToFooter() {
        new Actions(driver)
                .scrollToElement(driver.findElement(By.id("footer")))
                .perform();
        return this;
    }

    public HomePage assertSubscriptionTextInFooterIsDisplayed(){
        String actualText = waitUntilVisibilityOfElementLocated(subscriptionTextLocator).getText();
        assertThat(actualText)
                .as("Text in footer")
                .isEqualTo("SUBSCRIPTION");
        return this;
    }

    public HomePage enterEmailAndClickSubscribeButton() {
        type(subscriptionInputLocator, SecretManager.get("USER_EMAIL"));
        click(subscriptionButtonLocator);
        return this;
    }

    public HomePage assertSubscribedMessageIsVisible() {
        String actualText = waitUntilVisibilityOfElementLocated(subscriptionMessageTextLocator).getText();
        assertThat(actualText)
                .as("Message about successful subscription")
                .isEqualTo("You have been successfully subscribed!");
        return this;
    }
}