package com.automationexercise.tests.products_page_tests;

import com.automationexercise.pages.HomePage;
import com.automationexercise.pages.ProductsPage;
import com.automationexercise.tests.BaseTest;
import org.testng.annotations.Test;

public class TestCase9 extends BaseTest {

    @Test
    public void testCase9 () {
        new HomePage(driver)
                .openHomePage()
                .clickConsentButton()
                .assertHomePageIsSuccessfullyLoaded();
        ProductsPage productsPage = mainMenu
                .clickProductsButton()
                .assertProductsPageIsSuccessfullyLoaded();
        String randomProductName = productsPage
                .getRandomProductName();
        productsPage
                .inputRandomProductNameToSearchBox(randomProductName)
                .clickSearchButton()
                .assertSearchedProductsTextIsVisible()
                .assertProductsMoreThan(0)
                .assertOnlyRelatedProductsAreVisible(randomProductName);
    }
}