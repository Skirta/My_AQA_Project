package com.automationexercise.tests.products;

import com.automationexercise.pages.HomePage;
import com.automationexercise.pages.ProductsPage;
import com.automationexercise.tests.BaseTest;
import org.testng.annotations.Test;

public class ProductTests extends BaseTest {

    @Test(description = "Test Case 8: Verify All Products and product detail page")
    public void shouldVerifyAllProductsAndProductDetailPages() {

        new HomePage(driver)
                .openHomePage()
                .assertHomePageIsSuccessfullyLoaded();

        mainMenu
                .clickProductsButton()
                .assertProductsPageIsSuccessfullyLoaded()
                .assertProductsMoreThan(0)
                .chooseRandomProductAndClickViewButton()
                .assertThatProductDetailsPageIsSuccessfullyLoaded()
                .assertThatNameAndPriceOfRandomProductCorrespond();

    }

    @Test(description = "Test Case 9: Search Product")
    public void shouldSearchForProductAndVerifyResults() {
        new HomePage(driver)
                .openHomePage()
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