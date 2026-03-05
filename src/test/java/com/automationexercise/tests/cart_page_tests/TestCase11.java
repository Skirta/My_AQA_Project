package com.automationexercise.tests.cart_page_tests;

import com.automationexercise.components.Footer;
import com.automationexercise.pages.HomePage;
import com.automationexercise.tests.BaseTest;
import org.testng.annotations.Test;

public class TestCase11 extends BaseTest {

    @Test
    public void testCase11() {

        new HomePage(driver)
                .openHomePage()
                .assertHomePageIsSuccessfullyLoaded();
        mainMenu
                .clickCartButton()
                .assertCartPageIsSuccessfullyLoaded();
        new Footer(driver)
                .assertSubscriptionTextInFooterIsDisplayed()
                .enterEmailAndClickSubscribeButton()
                .assertSubscribedMessageIsVisible();
    }
}