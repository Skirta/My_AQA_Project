package com.automationexercise.tests.home_page_tests;

import com.automationexercise.pages.HomePage;
import com.automationexercise.tests.BaseTest;
import org.testng.annotations.Test;

public class TestCase10 extends BaseTest {

    @Test
    public void testCase10() {

       new HomePage(driver)
               .openHomePage()
               .clickConsentButton()
               .assertHomePageIsSuccessfullyLoaded()
               .scrollDownPageToFooter()
               .assertSubscriptionTextInFooterIsDisplayed()
               .enterEmailAndClickSubscribeButton()
               .assertSubscribedMessageIsVisible();
    }
}