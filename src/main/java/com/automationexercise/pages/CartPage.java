package com.automationexercise.pages;

import com.automationexercise.helpers.SecretManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import static org.assertj.core.api.Assertions.assertThat;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    //Locators
    private final By shoppingCartTextLocator = By.xpath("//li[text()='Shopping Cart']");
    private final By subscriptionTextLocator = By.xpath("//div[@class='single-widget']/h2");
    private final By subscriptionInputLocator = By.id("susbscribe_email");
    private final By subscriptionButtonLocator = By.id("subscribe");
    private final By subscriptionMessageTextLocator = By.xpath("//div[@class='alert-success alert']");

    //Methods

    public CartPage assertCartPageIsSuccessfullyLoaded() {
        waitUntilVisibilityOfElementLocated(shoppingCartTextLocator);
        waitUntilUrlToBe(SecretManager.get("BASE_URL") + "view_cart");
        return this;
    }

    public CartPage scrollDownPageToFooter() {
        new Actions(driver)
                .scrollToElement(driver.findElement(By.id("footer")))
                .perform();
        return this;
    }

    public CartPage assertSubscriptionTextInFooterIsDisplayed() {
        String actualText = waitUntilVisibilityOfElementLocated(subscriptionTextLocator).getText();
        assertThat(actualText)
                .as("Text in footer")
                .isEqualTo("SUBSCRIPTION");
        return this;
    }

    public CartPage enterEmailAndClickSubscribeButton() {
        type(subscriptionInputLocator, SecretManager.get("USER_EMAIL"));
        click(subscriptionButtonLocator);
        return this;
    }

    public CartPage assertSubscribedMessageIsVisible() {
        String actualText = waitUntilVisibilityOfElementLocated(subscriptionMessageTextLocator).getText();
        assertThat(actualText)
                .as("Message about successful subscription")
                .isEqualTo("You have been successfully subscribed!");
        return this;
    }

}
