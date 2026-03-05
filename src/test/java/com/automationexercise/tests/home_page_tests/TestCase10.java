package com.automationexercise.tests.home_page_tests;

import com.automationexercise.components.Footer;
import com.automationexercise.pages.HomePage;
import com.automationexercise.tests.BaseTest;
import org.testng.annotations.Test;

public class TestCase10 extends BaseTest {

    @Test //(invocationCount = 10, successPercentage = 100)
    public void testCase10() {

       new HomePage(driver)
               .openHomePage()
               .assertHomePageIsSuccessfullyLoaded();
       new Footer(driver)
               .scrollDownPageToFooter()
               .assertSubscriptionTextInFooterIsDisplayed()
               .enterEmailAndClickSubscribeButton()
               .assertSubscribedMessageIsVisible();
    }
}