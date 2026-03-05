package com.automationexercise.tests.subscription;

import com.automationexercise.components.Footer;
import com.automationexercise.pages.HomePage;
import com.automationexercise.tests.BaseTest;
import org.testng.annotations.Test;

public class SubscriptionTests extends BaseTest {

    @Test(description = "Test Case 10: Verify Subscription in home page")
    public void shouldSubscribeSuccessfullyOnHomePage() {

        new HomePage(driver)
                .openHomePage()
                .assertHomePageIsSuccessfullyLoaded();
        new Footer(driver)
                .scrollDownPageToFooter()
                .assertSubscriptionTextInFooterIsDisplayed()
                .enterEmailAndClickSubscribeButton()
                .assertSubscribedMessageIsVisible();
    }

    @Test(description = "Test Case 11: Verify Subscription in cart page")
    public void shouldSubscribeSuccessfullyInCartPage() {

        new HomePage(driver)
                .openHomePage()
                .assertHomePageIsSuccessfullyLoaded();
        mainMenu
                .clickCartButton()
                .assertCartPageIsSuccessfullyLoaded();
        new Footer(driver)
                .scrollDownPageToFooter()
                .assertSubscriptionTextInFooterIsDisplayed()
                .enterEmailAndClickSubscribeButton()
                .assertSubscribedMessageIsVisible();
    }
}