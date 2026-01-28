package com.automationexercise.tests.testcases_page_tests;

import com.automationexercise.pages.HomePage;
import com.automationexercise.tests.BaseTest;
import org.testng.annotations.Test;

public class TestCase7 extends BaseTest {

    @Test
    public void testCase7() {

        new HomePage(driver)
                .openHomePage()
                .clickConsentButton()
                .assertHomePageIsSuccessfullyLoaded();

        mainMenu
                .clickTestCasesButton()
                .assertTestCasesPageIsSuccessfullyLoaded();
    }
}