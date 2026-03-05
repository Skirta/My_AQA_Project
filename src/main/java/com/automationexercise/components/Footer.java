package com.automationexercise.components;

import com.automationexercise.helpers.SecretManager;
import com.automationexercise.pages.BasePage;
import com.automationexercise.pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import static org.assertj.core.api.Assertions.assertThat;

public class Footer extends BasePage {

    public Footer(WebDriver driver){
        super(driver);
    }

    //Locators
    private final By footerLocator = By.id("footer");
    private final By subscriptionInputLocator = By.id("susbscribe_email");
    private final By subscriptionButtonLocator = By.id("subscribe");
    private final By subscriptionMessageTextLocator = By.xpath("//div[@class='alert-success alert']");
    private final By subscriptionTextLocator = By.xpath("//div[@class='single-widget']/h2");

    //Methods
    public Footer scrollDownPageToFooter() {
        new Actions(driver)
                .scrollToElement(driver.findElement(footerLocator))
                .perform();
        return this;
    }

    public Footer assertSubscriptionTextInFooterIsDisplayed(){
        String actualText = waitUntilVisibilityOfElementLocated(subscriptionTextLocator).getText();
        assertThat(actualText)
                .as("Text in footer")
                .isEqualTo("SUBSCRIPTION");
        return this;
    }

    public Footer enterEmailAndClickSubscribeButton() {
        type(subscriptionInputLocator, SecretManager.get("USER_EMAIL"));
        click(subscriptionButtonLocator);
        return this;
    }

    public Footer assertSubscribedMessageIsVisible() {
        String actualText = waitUntilVisibilityOfElementLocated(subscriptionMessageTextLocator).getText();
        assertThat(actualText)
                .as("Message about successful subscription")
                .isEqualTo("You have been successfully subscribed!");
        return this;
    }
}
