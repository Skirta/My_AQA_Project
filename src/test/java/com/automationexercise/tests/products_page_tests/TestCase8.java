package com.automationexercise.tests.products_page_tests;

import com.automationexercise.pages.HomePage;
import com.automationexercise.tests.BaseTest;
import org.testng.annotations.Test;

public class TestCase8 extends BaseTest {

    @Test
    public void testCase8() {

        new HomePage(driver)
                .openHomePage()
                .clickConsentButton()
                .assertHomePageIsSuccessfullyLoaded();

        mainMenu
                .clickProductsButton()
                .assertProductsPageIsSuccessfullyLoaded()
                .assertProductsMoreThan(0)
                .chooseRandomProductAndClickViewButton()
                .assertThatProductDetailsPageIsSuccessfullyLoaded()
                .assertThatNameAndPriceOfRandomProductCorrespond();

    }
}
